package Backtrack_Combination;
import java.util.*;
/*
 * 301. Remove Invalid Parentheses
 * 
 * Difficulty: $$$$$
 * 
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and ).
 * 
 * Examples:
 *  "()())()" -> ["()()()", "(())()"]
 *  "(a)())()" -> ["(a)()()", "(a())()"]
 *  ")(" -> [""]
 * 
 * Comment: 
 * the less number of recursion, the avoidance for duplicate result and keep the length maximized should be considered
 * */
public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<String>();
        remove(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }
    
    public void remove(List<String> res, String s, int pos1, int pos2, char[] par){
        int count = 0;
        for(int i = pos1; i < s.length(); i++){
            if(s.charAt(i) == par[0]){
                count++;    
            }
            if(s.charAt(i) == par[1]){
                count--;
            }
            if(count >= 0) continue;
            for(int j = pos2; j <= i; j++){
                 if (s.charAt(j) == par[1] && (j == pos2 || s.charAt(j - 1) != par[1]))
                remove(res, s.substring(0, j) + s.substring(j + 1, s.length()), i, j, par);
                
            }
            return;
        }
        
        String reverse = new StringBuilder(s).reverse().toString();
        if(par[0] == '('){
            remove(res, reverse, 0, 0, new char[]{')', '('});
        }
        else{
            res.add(reverse);
        }
    }
}
