package array;

import java.util.Arrays;
import java.util.HashMap;

// Day -2

// Valid Anagram

/* Description
Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: s = "racecar", t = "carrace"

Output: true
 */

/** Time Complexity: O(n+m), Space Complexity: O(1) */

// 1. Sorting

/* Algorithm
If the lengths of the two strings differ, return false immediately because they cannot be anagrams.
Sort both strings.
Compare the sorted versions of the strings:
If they are equal, return true.
Otherwise, return false. */

class SortingSolution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }
}

// 2. Hash Map

/* Algorithm
If the two strings have different lengths, return false immediately.
Create two hash maps to store character frequencies for each string.
Iterate through both strings at the same time:
Increase the character count for s[i] in the first map.
Increase the character count for t[i] in the second map.
After building both maps, compare them:
If the maps are equal, return true.
Otherwise, return false. */

class HashMapSolution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
            countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }
}

// 3. Hash Table (Using Array)

/*
Algorithm
If the lengths of the strings differ, return false immediately.
Create a frequency array count of size 26 initialized to 0.
Iterate through both strings:
Increment the count at the index corresponding to s[i].
Decrement the count at the index corresponding to t[i].
After processing both strings, scan through the count array:
If any value is not 0, return false because the frequencies differ.
If all values are 0, return true since the strings are anagrams. */

class HashTableSolution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}

// Main method to test the solutions

public class Day2 {
    public static void main(String[] args) {
        SortingSolution sol1 = new SortingSolution();
        HashMapSolution sol2 = new HashMapSolution();
        HashTableSolution sol3 = new HashTableSolution();

        System.out.println(sol1.isAnagram("racecar", "carrace")); // true
        System.out.println(sol2.isAnagram("jar",     "jam"));     // false
        System.out.println(sol3.isAnagram("anagram", "nagaram")); // true
        System.out.println(sol3.isAnagram("rat",     "car"));     // false
    }
}
