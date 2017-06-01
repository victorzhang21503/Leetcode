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
 * 
 * Explanation:
 * 
 * tails is an array storing the smallest tail of all increasing subsequences 
 * with length i+1 in tails[i].
 * For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:
 * len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
 * len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
 * len = 3   :      [4, 5, 6]            => tails[2] = 6
 * 
 * 
 * Just explain more about the tail processing example:
 * [1,3,5,2,8,4,6]
 * 
 * For this list, we can have LIS with different length.
 * For length = 1, [1], [3], [5], [2], [8], [4], [6], we pick the one with smallest tail element as the representation of length=1, which is [1]
 * For length = 2, [1,2] [1,3] [3,5] [2,8], ...., we pick [1,2] as the representation of length=2.
 * Similarly, we can derive the sequence for length=3 and length=4
 * The result sequence would be:
 * len=1: [1]
 * len=2: [1,2]
 * len=3: [1,3,4]
 * len=4: [1,3,5,6]
 * 
 * According to the logic in the post,we can conclude that:
 * (1) If there comes another element, 9
 * We iterate all the sequences, found 9 is even greater than the tail of len=4 sequence, we then copy len=4 sequence to be a new sequece, and append 9 to the new sequence, which is len=5: [1,3,5,6,9]
 * The result is:
 * len=1: [1]
 * len=2: [1,2]
 * len=3: [1,3,4]
 * len=4: [1,3,5,6]
 * len=5: [1,3,5,6,9]
 * 
 * (2) If there comes another 3,
 * We found len=3 [1,3,4], whose tailer is just greater than 3, we update the len=3 sequence tobe [1,3,3]. The result is:
 * len=1: [1]
 * len=2: [1,2]
 * len=3: [1,3,3]
 * len=4: [1,3,5,6]
 * 
 * (3) If there comes another 0,
 * 0 is smaller than the tail in len=1 sequence, so we update the len=1 sequence. The result is:
 * len=1: [0]
 * len=2: [1,2]
 * len=3: [1,3,3]
 * len=4: [1,3,5,6]
 * 
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
