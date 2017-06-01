package Backtrack_Combination;

/*
 * 494. Target Sum
 * 
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 * 
 * Example 1:
 * 
 * Input: nums is [1, 1, 1, 1, 1], S is 3. 
 * Output: 5
 * Explanation: 
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 * 
 * Comment:
 * Actually, it is a 0-1 packet DP problem 
 * */

public class TargetSum {
	public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(S > sum || (sum + S) % 2 == 1)   return 0;
        return subsetSum(nums, (sum + S) / 2); // pick the numbers in nums, which sum up to (sum + S) / 2; which is the numbers with minus operator
    }

    private int subsetSum(int[] nums, int S){
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = S; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[S];
    }
}
