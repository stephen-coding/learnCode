package com.life.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author T596
 * @date 2023/8/15
 */
public class LeetCode833 {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> indexMap = new HashMap<>();  // 用于记录每个索引需要替换的源字符串的长度
        for (int i = 0; i < indices.length; i++) {
            if (s.indexOf(sources[i], indices[i]) == indices[i]) {
                indexMap.put(indices[i], sources[i].length());
            }
        }
        StringBuilder sb = new StringBuilder();  // 依次生成最终的替换后的字符串
        for (int i = 0; i < s.length(); i++) {
            if (indexMap.containsKey(i)) {
                int len = indexMap.get(i);
                sb.append(targets[indexOf(indices, i)]);
                i += len - 1;  // 将索引移动到当前需要替换的源字符串之后
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    private int indexOf(int[] indices, int target) {  // 查找目标值在数组 indices 中的位置
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public String findReplaceString1(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();

        int[] next = new int[n]; // 使用 KMP 算法进行匹配
        Arrays.fill(next, -1);

        boolean[] replaced = new boolean[n]; // 记录已经替换过的位置

        for (String source : sources) {
            int m = source.length();
            int j = 0;
            int k = -1;

            while (j < m - 1) {
                if (k == -1 || source.charAt(j) == source.charAt(k)) {
                    j++;
                    k++;
                    next[j] = k;
                } else {
                    k = next[k];
                }
            }
        }

        char[] arr = s.toCharArray(); // 将字符串转换为字符数组，以便直接修改替换

        for (int i = 0; i < indices.length; i++) {
            int start = indices[i];
            int m = sources[i].length();

            if (start + m <= n) {
                int j = 0;
                while (j < m && arr[start + j] == sources[i].charAt(j)) {
                    j++;
                }

                if (j == m) {
                    Arrays.fill(replaced, start, start + m, true);
                    for (int k = 0; k < targets[i].length(); k++) {
                        arr[start + k] = targets[i].charAt(k);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!replaced[i]) {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}
