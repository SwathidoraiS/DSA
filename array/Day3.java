package array;

import java.util.*;

// Day -3

//  Two Sum 

/* Description
Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

Return the answer with the smaller index first.

Example 1:

Input: 
nums = [3,4,5,6], target = 7

Output: [0,1] */

/** Time Complexity: O(n), Space Complexity: O(n) */

// 1. Hash Map

/* Algorithm
Create an empty hash map to store the indices of the numbers we have seen so far. The keys will be the numbers from the array, and the values will be their corresponding indices.
Iterate through the array of numbers: 
For each number nums[i], calculate the complement as target - nums[i].
Check if the complement exists in the hash map:
If it does, we have found the two numbers that add up to the target. Return the
indices of the current number and the complement from the hash map.
If it does not exist, add the current number and its index to the hash map.
If we finish iterating through the array without finding a pair, return an empty array or null
to indicate that no solution exists. */

class HashMapSolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0]; // Return an empty array if no solution is found
    }
}