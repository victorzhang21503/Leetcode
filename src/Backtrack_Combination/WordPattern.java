package Backtrack_Combination;
import java.util.*;

/*
 * 291. Word Pattern II
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * 
 * Examples:
 * pattern = "abab", str = "redblueredblue" should return true.
 * pattern = "aaaa", str = "asdasdasdasd" should return true.
 * pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * 
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 * 
 * */


public class WordPattern {
	public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        
        return backtrack(map, pattern, str, 0, 0);
    }
    
    public boolean backtrack(Map<Character, String> map, String pattern, String str, int pos1, int pos2){
        if(pos1 == pattern.length() && pos2 == str.length()){
            return true;
        }
        
        else if(pos1 < pattern.length() && pos2 < str.length()){
            char ch = pattern.charAt(pos1);
            
            if(map.containsKey(ch)){
                String word = map.get(ch);
                int len = word.length();
                if(pos2 + len <= str.length() && word.equals(str.substring(pos2, pos2 + len))){
                    return backtrack(map, pattern, str, pos1 + 1, pos2 + len);
                }
                else{
                    return false;
                }
            }
            
            else{
               for(int i = pos2 + 1; i <= str.length(); i++){
                   String word = str.substring(pos2, i);
                   
                   if(!map.values().contains(word)){
                       map.put(ch, word);
                       
                       if(backtrack(map, pattern, str, pos1 + 1, i)){
                           return true;
                       }
                   }
                   
               }
               map.remove(ch);
               return false;
            }    
        }
        
        
        else{
            return false;
        }
        
    }
}

class WordPattern2{
Map<Character, String> map = new HashMap<>();
    
    public boolean wordPatternMatch(String pattern, String str) {
        int pLen = pattern.length();
        int sLen = str.length();
        
        if(pLen > sLen){
            return false;
        }
        
        if(pLen == 0 && sLen == 0){
            return true;
        }
        else if(pLen == 0){
            return false;
        }
        
        char ch = pattern.charAt(0);
        
        if(map.containsKey(ch)){
            String value = map.get(ch);
            int len = value.length();
            if(len > str.length()){
                return false;
            }
            
            if(value.equals(str.substring(0, len))){
                return wordPatternMatch(pattern.substring(1), str.substring(len));
            }
        }
        else{
            for(int i = 1; i <= str.length(); i++){
                String value = str.substring(0, i);
                int len = value.length();
                if(map.values(). contains(value)){
                    continue;
                }
                
                
                /*
                 * 
                 *  Give consider into every situation which is not necessarily checked in the backtrack recursion    
                 *   
                 * */
                
                
                String sub = pattern.substring(1);
                String substr = str.substring(i);
                boolean flag = false;
                while(sub.contains(ch + "")){
                    if(! substr.contains(value)){
                        flag = true;
                        break;
                    }
                    int idx = sub.indexOf(ch);
                    sub = sub.substring(idx + 1);
                    int subidx = substr.indexOf(value);
                    substr = substr.substring(subidx + len);
                }
                if(flag){
                    continue;
                }
                
                
                
                
                map.put(ch, value);
                
                if(wordPatternMatch(pattern.substring(1), str.substring(i))){
                    return true;
                }
            }
            map.remove(ch);
            
            return false;
        }
        
        return false;
    }
}
