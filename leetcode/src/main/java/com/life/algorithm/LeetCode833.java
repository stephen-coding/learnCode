package com.life.algorithm;

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
}
