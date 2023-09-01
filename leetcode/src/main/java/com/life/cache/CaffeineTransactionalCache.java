package com.life.cache;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.cache.CacheManager;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author T596
 * @date 2023/8/9
 */
@RequiredArgsConstructor
public abstract class CaffeineTransactionalCache<K extends Serializable, V extends Serializable> implements TransactionalCache<K, V>{

    private final CacheManager cacheManager;

    @Getter
    private final String cacheName;

    private final Lock lock = new ReentrantLock();

    private final Map<K, Set<UUID>> objectTransactions = new HashMap<>();

    private final Map<UUID, CaffeineCacheTransaction<K, V>> transactions = new HashMap<>();

    @Override
    public CacheValueWrapper<V> get(K key) {
        return SimpleCacheValueWrapper.wrap(cacheManager.getCache(cacheName).get(key));
    }

    @Override
    public void put(K key, V value) {



    }

    @Override
    public void putIfAbsent(K key, V value) {

    }

    @Override
    public void evict(K key) {

    }

    @Override
    public void evict(Collection<K> keys) {

    }

    @Override
    public void evictOrPut(K key, V value) {

    }

    @Override
    public CacheTransaction<K, V> newTransactionForKey(K key) {
        return null;
    }

    void doPutIfAbsent(Object key, Object value) {
        Objects.requireNonNull(cacheManager.getCache(cacheName)).putIfAbsent(key, value);
    }

    void doEvict(Object key) {
        Objects.requireNonNull(cacheManager.getCache(cacheName)).evict(key);
    }

    CacheTransaction<K, V> newTransaction(List<K> keys) {

        lock.lock();
        try {
            var transaction = new CaffeineCacheTransaction<>(this, keys);
            var transactionId = transaction.getUuid();
            for (K key : keys) {
                objectTransactions.computeIfAbsent(key, k -> new HashSet<>()).add(transactionId);
            }
            transactions.put(transactionId, transaction);
            return transaction;

        } finally {
            lock.unlock();
        }

    }

    public boolean commit(UUID trId, Map<Object, Object> pendingPuts) {

        lock.lock();
        try {
            var tr = transactions.get(trId);
            var success = !tr.isFail();
            if (success) {
                for (K key : tr.getKeys()) {
                    Set<UUID> otherTransactions = objectTransactions.get(key);
                    if (otherTransactions != null) {
                        for (UUID otherTrId : otherTransactions) {
                            if (trId == null || !trId.equals(otherTrId)) {
                                transactions.get(otherTrId).setFail(true);
                            }
                        }
                    }
                }
                pendingPuts.forEach(this::doPutIfAbsent);
            }
            removeTransaction(trId);
            return success;
        } finally {
            lock.unlock();
        }
    }

    private void removeTransaction(UUID id) {
        CaffeineCacheTransaction<K, V> transaction = transactions.remove(id);
        if (transaction != null) {
            for (var key : transaction.getKeys()) {
                Set<UUID> transactions = objectTransactions.get(key);
                if (transactions != null) {
                    transactions.remove(id);
                    if (transactions.isEmpty()) {
                        objectTransactions.remove(key);
                    }
                }
            }
        }
    }

    private void failAllTransactionsByKey(K key) {
        Set<UUID> transactionsIds = objectTransactions.get(key);
        if (transactionsIds != null) {
            for (UUID otherTrId : transactionsIds) {
                transactions.get(otherTrId).setFail(true);
            }
        }
    }


}
