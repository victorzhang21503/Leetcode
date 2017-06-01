package BinarySearch;
import java.util.*;

/*
 * 
 * 354. Russian Doll Envelopes
 * 
 * Difficulty: $$$$$
 * 
 * 
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * 
 * Example:
 * Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * 
 * */
public class RussianDoll {
	public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] envelope1, int[] envelope2){
                return envelope1[0] == envelope2[0] ? Integer.compare(envelope2[1], envelope1[1]) : Integer.compare(envelope1[0], envelope2[0]);
            } 
        });
        
        int[] dp = new int[envelopes.length];
        int len = 0;
        for(int i = 0; i < envelopes.length; i++){
            
            int index = binarySearch(dp, len, envelopes[i][1]);
            dp[index] = envelopes[i][1];    
            
            if(index == len){
                len++;
            }
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
            else if(dp[mid] < key){
                low = mid + 1;
            }    
            else{
                high = mid;
            }
        }
        
        return low;
    }
}
