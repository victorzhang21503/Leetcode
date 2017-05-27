package Backtrack_Combination;
import java.util.*;

/*
 * 241. Different Ways to Add Parentheses
 * 
 * Given a string of numbers and operators, 
 * return all possible results from computing all the 
 * different possible ways to group numbers and operators. 
 * The valid operators are +, - and *.
 * 
 * Example:
 * Input: "2-1-1".
 * ((2-1)-1) = 0
 * 2-(1-1)) = 2
 * Output: [0, 2]
 * 
 * Input: "2*3-4*5"
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 * */

public class DiffWaysAddParenth {
	public List<Integer> diffWaysToCompute(String input) {
        return dfs(input, new HashMap<String, List<Integer>>());
    }
    
    private List<Integer> dfs(String input, Map<String, List<Integer>> map){
        if(map.containsKey(input)){
            return map.get(input);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char curChar = input.charAt(i);
            
            if(curChar == '+' || curChar == '-' || curChar == '*'){
                String leftPart = input.substring(0, i);
                String rightPart = input.substring(i + 1);
                List<Integer> leftRes = dfs(leftPart, map);
                List<Integer> rightRes = dfs(rightPart, map);
                
                for(int left : leftRes){
                    for(int right: rightRes){
                        int cur = 0;
                        switch(curChar){
                            case '+': 
                                cur = left + right;
                                break;
                            case '-':
                                cur = left - right;
                                break;
                            case '*':
                                cur = left * right;
                                break;
                        }
                        res.add(cur);
                    }
                }
            }
        }
        
        if(res.size() == 0){
            res.add(Integer.parseInt(input));
        }
        
        map.put(input, res);
        return res;
    }
}
