package BinarySearch;


/*
 * 
 * 300. Longest Increasing Subsequence
 * 
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * */


public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {            
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = binarySearch(dp, len, x);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
    
    public int binarySearch(int[] dp, int high, int key){
        
        
        int low = 0;
        while(high > low){
            int mid = low + (high - low) / 2;
            if(dp[mid] == key){
                return mid;
            }
            
            else if(dp[mid] > key){
                high = mid;
            }
            
            else{
                low = mid + 1;
            }
        }
        
        return low;
    }
}
