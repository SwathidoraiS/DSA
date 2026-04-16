package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Day -1 

/* Contains Duplicate  */

/** 
 * Description :
Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

Example 1:

Input: nums = [1, 2, 3, 3]

Output: true **/

/** Time Complexity: O(n), Space Complexity: O(n) */

// 1. Brute Force

/* Algorithm
Iterate through the array using two nested loops to check all possible pairs of distinct indices.
If any pair of elements has the same value, return true.
If all pairs are checked and no duplicates are found, return false. */

class BruteForceSolution {
    public boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

// 2. Sorting

/* Algorithm
Sort the array in non-decreasing order.
Iterate through the array starting from index 1.
Compare the current element with the previous element.
If both elements are equal, we have found a duplicate — return true.
If the loop finishes without detecting equal neighbors, return false. */

class SortingSolution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}

// 3. HashSet

/* Algorithm
Initialize an empty hash set to store seen values.
Iterate through each number in the array.
For each number:
If it is already in the set, return true because a duplicate has been found.
Otherwise, add it to the set.
If the loop finishes without finding any duplicates, return false. */


class HashSetSolution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}

// Main class to test the solutions
public class containsDuplicate {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 3};

        BruteForceSolution brute = new BruteForceSolution();
        SortingSolution sorting = new SortingSolution();
        HashSetSolution hash = new HashSetSolution();

        System.out.println("Brute Force: " + brute.hasDuplicate(nums));
        System.out.println("Sorting: " + sorting.hasDuplicate(nums));
        System.out.println("HashSet: " + hash.hasDuplicate(nums));
    }
}