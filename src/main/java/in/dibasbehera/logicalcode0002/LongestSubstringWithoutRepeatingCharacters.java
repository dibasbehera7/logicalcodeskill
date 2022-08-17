package in.dibasbehera.logicalcode0002;

import java.util.HashSet;

/**
 * @Problem Given a string s, find the length of the longest substring without
 *          repeating characters.
 * 
 * @Expected Input: s = "abcabcbb" -> Output: 3 -> Explanation: The answer is
 *           "abc", with the length of 3.
 *
 *           Input: s = "bbbbb" -> Output: 1 -> Explanation: The answer is "b",
 *           with the length of 1.
 * 
 *           Input: s = "pwwkew" -> Output: 3 -> Explanation: The answer is
 *           "wke", with the length of 3.Notice that the answer must be a
 *           substring, "pwke" is a subsequence and not a substring.
 * 
 * @author DIBASBEHERA
 */

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String testcase1 = "abcabcbb";
		String testcase2 = "bbbbb";
		String testcase3 = "pwwkew";

		System.out.println("Test Case 1: " + lengthOfLongestSubstring(testcase1));
		System.out.println("Test Case 2: " + lengthOfLongestSubstring(testcase2));
		System.out.println("Test Case 3: " + lengthOfLongestSubstring(testcase3));
	}

	public static int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, result = 0;
		HashSet<Character> set = new HashSet<Character>();
		while (j < s.length()) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				result = Math.max(result, set.size());
				j++;
			} else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		return result;
	}
}
