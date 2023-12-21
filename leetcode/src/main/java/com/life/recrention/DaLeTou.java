package com.life.recrention;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author T596
 * @date 2023/11/24
 */
//模拟大乐透
public class DaLeTou {


    private static List<Integer> ticket() {
        //前区list集合
        List<Integer> list1 = new ArrayList<>();
        //后区list集合
        List<Integer> list2 = new ArrayList<>();
        //前区1-35，随机五个不重复
        while (list1.size() < 5) {
            int a = (int) (Math.random() * 35 + 1);
            if (!list1.contains(a)) {
                list1.add(a);
            }
        }
        //按升序排列
        Collections.sort(list1);
        System.out.print(list1);
        //后区1-12随机2个不重复
        while (list2.size() < 2) {
            int b = (int) (Math.random() * 12+1);
            if (!list2.contains(b)){
                list2.add(b);
            }
        }
        //按升序排列
        Collections.sort(list2);
        return list2;
    }

    public static void main(String[] args) {

        int i = 0;
        while (i < 5) {
            System.out.println(ticket());
            i++;
        }

    }
}
