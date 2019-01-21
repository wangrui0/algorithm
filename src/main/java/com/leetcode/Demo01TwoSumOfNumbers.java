package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangrui
 * @Date: 2019/1/21 16:46
 * Two sum of numbers
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [1,2,3,4,5,6 7,8,9 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Demo01TwoSumOfNumbers {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 11, 32, 43, 0, -1};
        int target = 9;
        //返回任意一个的数组的下标
        int[] result = twoSum(numbers, target);
        System.out.println(target + "=" + numbers[result[0]] + "+" + numbers[result[1]]);
        System.out.println("============================");
        //返回所有的素组的下标
        List<int[]> resultAll = calculatTwoSumAll(numbers, target);
        resultAll.stream().forEach(e-> System.out.println(target + "=" + numbers[e[0]] + "+" + numbers[e[1]]));
        /**
         * 9=5+4
         * ============================
         * 9=5+4
         * 9=6+3
         * 9=7+2
         * 9=8+1
         */
    }

    /**
     * @param numbers
     * @param target
     * @return 以结果为导向，根据一个数字判断另一个数字有没有；
     *
     * 复杂度分析：
     *
     * 时间复杂度：O(n)， 我们只遍历了包含有 n 个元素的列表一次。在表中进行的每次查找只花费 O(1) 的时间。
     *
     * 空间复杂度：O(n)， 所需的额外空间取决于哈希表中存储的元素数量，该表最多需要存储 n 个元素。
     */
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("numbers为空！");
        }
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int otherNumber = target - numbers[i];
            if (resultMap.get(otherNumber) != null) {
                return new int[]{i, resultMap.get(otherNumber)};
            } else {
                resultMap.put(numbers[i], i);
            }
        }
        throw new IllegalArgumentException("numbers为空！");
    }

    /**
     * @param numbers
     * @param target
     * 返回所有的结果
     * @return
     */
    public static List<int[]>  calculatTwoSumAll(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("numbers为空！");
        }
        List<int[]> result = new ArrayList<>();
        Map<Integer, Integer> resultMap = new HashMap<>();
        boolean flag = false;
        for (int i = 0; i < numbers.length; i++) {
            int otherNumber = target - numbers[i];
            if (resultMap.get(otherNumber) != null) {
                flag = true;
                result.add(new int[]{i, resultMap.get(otherNumber)});
            } else {
                resultMap.put(numbers[i], i);
            }
        }
        if(!flag){
            throw new IllegalArgumentException("numbers为空！");
        }
        return result;
    }
}
