package in.dibasbehera.logicalcode0003;

/**
 * @Problem Given an integer array nums, find the contiguous subarray
 *          (containing at least one number) which has the largest sum and
 *          return its sum.
 * 
 * @Expected Input: nums = [-2,1,-3,4,-1,2,1,-5,4] -> Output: 6 -> Explanation:
 *           [4,-1,2,1] has the largest sum = 6. Input: nums = [5,4,-1,7,8] ->
 *           Output: 23
 * 
 * @author DIBAS BEHERA
 */
public class MaximumSubArray {

	public static void main(String[] args) {

		int[] testcase1 = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] testcase2 = new int[] { 5, 4, -1, 7, 8 };

		// Print ActuaL Output to match expected Output
		System.out.println(maxSubArray(testcase1));
		System.out.println(maxSubArray(testcase2));
	}

	/**
	 * @Solution Brute Force way
	 * @ComplexityAnalysis Time: O(N) Space: O(1)
	 */
	public static int maxSubArray(int[] nums) {
		int sum = 0, maxValue = Integer.MIN_VALUE;
		for (int x : nums) {
			sum += x;
			maxValue = Math.max(maxValue, sum);
			if (sum < 0)
				sum = 0;
		}
		return maxValue;
	}

}
