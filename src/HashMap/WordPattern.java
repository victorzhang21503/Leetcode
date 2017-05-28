package HashMap;
import java.util.*;

/*
 * 290. Word Pattern
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection 
 * between a letter in pattern and a non-empty word in str.
 * 
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * 
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * 
 * Comment:
 * map.values() and map.keySet() are Set structure which could be used to check unique
 * 
 * */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null){
            return false;
        }
        
        String[] split = str.split(" ");
        if(pattern.length() != split.length){
            return false;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        int i = 0;
        
        for(char ch : pattern.toCharArray()){
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(split[i++])){
                    return false;    
                }
            }
            else{
                if(map.values().contains(split[i])){
                    return false;
                }
                map.put(ch, split[i++]);
            }
        }
        
        return true;
    }
}
