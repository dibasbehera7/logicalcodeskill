package in.dibasbehera.logicalcode0001;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Problem Consider you are given an array of integers and a target sum, return
 *          indices of two numbers in the array such that they add up to the
 *          given target. You may assume that each input would have exactly one
 *          solution. Also, you cannot use the same element twice. You are
 *          allowed to return the answer in any order.
 * 
 * @Expected Input: nums = [7,2,13,11], target = 9 -> Output: [0,1] ->
 *           [7,2,13,11] is the given array and the given target sum = 9. If we
 *           take a look at the given array, the pair which adds to the target
 *           sum 9 is (7,2) i.e. 7+2 = 9. So our algorithm should return (0,1)
 *           as the result because these are the indexes of elements 7 and 2
 *           respectively in the given array.
 * 
 *           Input: nums = [7,3,5], target = 8 -> Output: [1,2] -> [7,3,5]
 *           output is (1,2) because these are the indexes of elements 3 and 5
 *           respectively which add up to the target sum 8.
 * 
 * @author DIBASBEHERA
 */
public class TwoSumProblem {

	public static void main(String[] args) {

		int[] testcase1 = new int[] { 7, 2, 13, 11 };
		int[] testcase2 = new int[] { 7, 3, 5 };

		// Print ActuaL Output to match expected Output
		System.out.println(Arrays.toString(solveBruteForceWay(testcase1, 9)));
		System.out.println(Arrays.toString(solveBruteForceWay(testcase2, 8)));

		System.out.println(Arrays.toString(solveUsingHashMap(testcase1, 9)));
		System.out.println(Arrays.toString(solveUsingHashMap(testcase2, 8)));
	}

	/**
	 * @Solution1 : Brute Force -> A straight forward solution to this problem is to
	 *            check for every possible pair present in the given array.
	 * 
	 * @ComplexityAnalysis ->Time Complexity: O(n^2) -> Space Complexity: O(1)
	 * 
	 * @Steps: 1.Run two loops and check for every combination in the given array.
	 *         2.Fix the outer loop at a specific index and move the inner loop to
	 *         get all the possible pairs. The outer loop runs from i=0 to i=n-2 and
	 *         inner loop runs from j=i+1 to j=n-1. 3.In each iteration of the inner
	 *         loop check if the numbers represented by the outer and inner loop
	 *         indexes add up to the target sum. 4.If nums[outerLoopIndex] +
	 *         nums[innerLoopIndex] is equal to target, return {outerLoopIndex,
	 *         innerLoopIndex} as result. Else continue iteration to check for the
	 *         next pair. 5.Repeat the above steps until you find a combination that
	 *         adds up to the given target.
	 * 
	 * @Explain: For example, for array [7,2,13,11] and target sum 24, we fix the
	 *           outer loop at index i=0 i.e element 7 and check it with all
	 *           possible values of the inner loop from j=i+1 to j=n-1, i.e from
	 *           index 1 to 3. So, we will be checking the following pair of
	 *           elements in the first iteration of outer loop: (7,2) (7,13) and
	 *           (7,11). Now we increment the outer loop index i by 1 and check it
	 *           with indices 2 to 3 (i+1 to n-1) of the inner loop. We repeat this
	 *           until we find the required answer.
	 * 
	 */
	private static int[] solveBruteForceWay(int[] nums, int target) {
		int n = nums.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] {};
	}

	/**
	 * @Solution1 : Using Hashmap -> The idea is to make use of a hashmap to store
	 *            the indices of the elements that are already visited. Hashmap
	 *            "key" is the number in the given input array (You add this to the
	 *            hashmap as you visit each element). Hashmap "value" is the index
	 *            of the number in the array represented by the hashmap key.
	 * 
	 * @ComplexityAnalysis ->Time Complexity: O(n) -> Space Complexity: O(n)
	 * 
	 * @Steps: 1. Create a hashmap which accepts integer datatype as key and value.
	 *         2. Iterate through each element in the given array starting from the
	 *         first element. 3. In each iteration check if required number
	 *         (required number = target sum - current number) is present in the
	 *         hashmap. 4. If present, return {required number index, current number
	 *         index} as result. 5. Otherwise add the current iteration number as
	 *         key and its index as value to the hashmap. Repeat this until you find
	 *         the result.
	 * 
	 */
	private static int[] solveUsingHashMap(int[] nums, int target) {
		HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer requiredNum = (Integer) (target - nums[i]);
			if (indexMap.containsKey(requiredNum)) {
				int toReturn[] = { indexMap.get(requiredNum), i };
				return toReturn;
			}

			indexMap.put(nums[i], i);
		}
		return null;
	}

}
