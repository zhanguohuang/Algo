package org.zhan.leetcode;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

 你可以假设 nums1 和 nums2 不会同时为空。

 示例 1:

 nums1 = [1, 3]
 nums2 = [2]

 则中位数是 2.0
 示例 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 则中位数是 (2 + 3)/2 = 2.5
 */
public class T4Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0, j = 0; i < nums1.length || j < nums2.length; ) {
            if (i == nums1.length) {
                nums[i+j] = nums2[j];
                j++;
                continue;
            }
            if (j == nums2.length) {
                nums[i+j] = nums1[i];
                i++;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                nums[i+j] = nums1[i];
                i++;
            } else {
                nums[i+j] = nums2[j];
                j++;
            }
        }
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        } else {
            return (double) nums[nums.length/2];
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
