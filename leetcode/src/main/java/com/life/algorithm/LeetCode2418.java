package com.life.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode2418 {

    public static String[] sortPeople(String[] names, int[] heights) {


        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < names.length ; i++) {
            map.put(heights[i], names[i]);
        }
        List<Integer> collect1 = map.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int j = 0;
        for (int c : collect1) {
            String s = map.get(c);
            names[j] = s;
            j++;
        }

        return names;
    }

    public static void main(String[] args) {
        String[]  names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        System.out.println(Arrays.toString(sortPeople(names, heights)));
    }


}
