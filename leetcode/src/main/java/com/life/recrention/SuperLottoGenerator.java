package com.life.recrention;

import java.util.*;

public class SuperLottoGenerator {

    public static void main(String[] args) {
        generateTickets(true); // true生成复式，false生成单式
    }

    public static void generateTickets(boolean isCompound) {
        if (isCompound) {
            // 生成复式方案（金额≤30元）
            generateCompoundTicket();
        } else {
            // 生成五组单式（总金额10元）
            generateSingleTickets(5);
        }
    }

    /**
     * 生成单式投注
     * @param count 生成组数
     */
    private static void generateSingleTickets(int count) {
        System.out.println("----- 单式投注（" + count + "组，共" + 2*count + "元）-----");
        for (int i = 1; i <= count; i++) {
            List<Integer> front = generateSortedNumbers(35, 5);
            List<Integer> back = generateSortedNumbers(12, 2);
            System.out.printf("第%02d组: 前区 %s 后区 %s%n", i, front, back);
        }
    }

    /**
     * 生成复式投注（金额≤30元）
     */
    private static void generateCompoundTicket() {
        // 有效组合[前区数量, 后区数量]
        final int[][] VALID_COMBOS = {
                {5,3}, {5,4}, {5,5}, {5,6}, {6,2}
        };

        Random rand = new Random();
        int[] combo = VALID_COMBOS[rand.nextInt(VALID_COMBOS.length)];
        int frontCount = combo[0], backCount = combo[1];

        // 生成号码
        List<Integer> front = generateSortedNumbers(35, frontCount);
        List<Integer> back = generateSortedNumbers(12, backCount);

        // 计算注数和金额
        int bets = combination(frontCount,5) * combination(backCount,2);
        int cost = bets * 2;

        System.out.println("----- 复式投注（" + cost + "元）-----");
        System.out.println("前区选" + frontCount + "码: " + front);
        System.out.println("后区选" + backCount + "码: " + back);
        System.out.println("共组成" + bets + "注，金额" + cost + "元");
    }

    /**
     * 生成排序的不重复随机数
     */
    private static List<Integer> generateSortedNumbers(int max, int count) {
        Set<Integer> nums = new HashSet<>();
        Random rand = new Random();
        while (nums.size() < count) {
            nums.add(rand.nextInt(max) + 1);
        }
        List<Integer> sorted = new ArrayList<>(nums);
        Collections.sort(sorted);
        return sorted;
    }

    /**
     * 组合数计算 C(n,k)
     */
    private static int combination(int n, int k) {
        if (k == 0 || k == n) return 1;
        return combination(n-1, k-1) + combination(n-1, k);
    }
}