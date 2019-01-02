package com;

import java.util.Arrays;
import java.util.List;

/**
 * @author: wangrui
 * @Date: 2019/1/2 20:29
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 面试官：如果把题目改成数组中的数按照大小分为两部分，所有的负数在所有的非负数的前面，该怎么做？
 * 如果再把题目改改，变成 把数组中的数分成两部分，能被3整除的数都在不能被3整除的数的前面，怎么办？
 */
public class Demo01EvenOdd {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 12, 7, 8, 9, 10);
        System.out.println("调整前：" + arr.toString());
        order(arr);
        System.out.println("调整后：" + arr.toString());
    }

    /**
     * 排序
     * @param arr
     */
    public static void order(List<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return;
        }
        for (int i = 0, j = arr.size() - 1; i < j; ) {
            if (!isEven(arr.get(i)) && isEven(arr.get(j))) {//arr[i]为偶数，arr[j]为奇数；调换位置
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
                i++;
                j--;
            } else if (isEven(arr.get(i)) && isEven(arr.get(j))) {//arr[i]为奇数，arr[j]为奇数；i++
                i++;
            } else if (isEven(arr.get(i)) && isEven(arr.get(j))) {//arr[i]为偶数，arr[j]为偶数；j--
                j--;
            } else {
                i++;
                j--;
            }
        }
    }

    /**
     * 判断奇数和偶数
     *
     * @param num
     * @return
     */
    private static boolean isEven(Integer num) {
        return num % 2 != 0;
    }

}
