package com.life;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LeetCode2441 {

    public static int findMaxK(int[] nums) {

        int[] zhengshu = new int[1001];
        int[] fushu = new int[1001];

        for (int num : nums) {
            if (num>0){
                zhengshu[num] = 1;
            }else {
                fushu[Math.abs(num)] = -1;
            }
        }

        for (int i = 1000; i > 0; i--) {
            if (zhengshu[i]==0){
                continue;
            }

            if (zhengshu[i]+fushu[i]==0){
                return i;
            }
        }

        return -1;

    }
    public static String t(String s) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy/M/d");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date1 = inputFormat.parse(s);
            //Date date2 = inputFormat.parse(s);

            String formattedDate1 = outputFormat.format(date1);
            //String formattedDate2 = outputFormat.format(date2);

            return formattedDate1;
        } catch (ParseException e) {
            e.printStackTrace();

        }

        return null;


    }

    public static void main(String[] args) {
        System.out.println(t("2022/12/9"));
    }
}
