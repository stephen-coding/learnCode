package com.life.algorithm;

/**
 * @author T596
 * @date 2023/12/26
 */
public class LeetCode1349 {

    public static int maxStudents(char[][] seats) {
        int i = 0;
        for (char[] seat : seats) {
            int j = 0;
           for (char s : seat) {
               if (s == '.') {
                   seats[j][i] = (char) j;
               }
               j++;
           }
           i++;
        }
        return 0;

    }

    public static void main(String[] args) {
        char[][] seats = {{'#','.','#','#','.','#'},{'.','#','#','#','#','.'},{'#','.','#','#','.','#'}};
        int i = maxStudents(seats);
        System.out.println(i);
    }
}
