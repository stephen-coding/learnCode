package com.life.algorithm;

public class Solution {

    //面试题 消失的两个数字
    public int[] missingTwo(int[] nums) {

         // 首先算出完整版数组的总和，残缺版数组的总和
        int numLength = nums.length + 2;
        int sumAll = numLength * (numLength + 1) / 2;
        int sum = 0;
        for (int num : nums) {

            sum += num;
        }
        //消失两个数的和 x + y = sumAll - sum
        int sumTwo = sumAll - sum;
        //对差值进行对半计算，那么x,y必然有一个值是小于计算后的对半值
        int mid = sumTwo / 2;
        //同样使用对半值未基准，通过两个数组求和，得出差值即为x或者y
        sumAll = (mid + 1) * mid / 2;
        sum = 0;
        for (int num : nums) {
            if (num <= mid) {
                sum += num;
            }
        }
        int num1 = sumAll - sum;
        //得到其中一值，再根据第一步的差值和，即可得出另外值
        int num2 = sumTwo - num1;
        return new int[] {num1, num2};
    }

    /**
     * 题目分析：
     *  由题意的，某一个满足结果的数，一定是之前的某个 resultA*3 或者是 resultB*5 或者是 resultC*7 的结果
     *  并且结果一定是 这三个乘积的最小值，
     *  因此，只要能够记录 resultA、resultB、resultC 的值，再相互与 3、5、7 相乘，取其中的最小值，就是当前的目标值！
     *  需要注意，resultA、B、C 是不断变化的，并且都应该是由小到大，谁被选中，就应该取下一个值！
     *      例如 3 就是 resultA=1 的结果，此时 B、C 都等于 1，此后 resultA 取下一个值 3
     *      例如 5 就是 resultB=1 的结果，此时 resultA=3，resultC=1，此后 resultB 取下一个值 3
     *      例如 7 就是 resultC=1 的结果，此时 resultA、resultB 都等于 3，此后 resultC 取下一个值 3
     *      例如 15 就是 resultA=5 或者是 resultB=3 的结果，此时 resultC=7，此后 resultA 取下一个值 7 ，resultB 取下一个值 5
     *
     */
    public int getKthMagicNumber(int k) {
        int [] result = new int[k];
        result[0] = 1;
        // 定义三个 指针，分别表示 resultA、B、C 的下标
        int point3 = 0;
        int point5 = 0;
        int point7 = 0;
        for (int i = 1; i < k; i++) {
            int resultN = Math.min(Math.min(result[point3] * 3, result[point5] * 5), result[point7] * 7);
            if (resultN % 3 == 0) {
                point3++;
            }
            if (resultN % 5 == 0) {
                point5++;
            }
            if (resultN % 7 == 0) {
                point7++;
            }
            result[i] = resultN;
        }
        return result[k - 1];
    }
}
