package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ：IceSource
 * @Description：
 * @Date ：Created in 2020/11/18 9:26
 * @modified By：
 */
public class T17letterCombinations {
    
    String[] digitToChar = new String[]{"","","abc", "def", "ghj", "jkl", "mno","pqrs", "tuv","wxzy"};
    
    char[] tempChars;
    
    static  List<String> result = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        tempChars = new char[digits.length()];
        
        char[] temp = digits.toCharArray();
        int[] digitsInt = new int[digits.length()];
        for(int i =0;i<digits.length();i++){
            digitsInt[i] = Integer.parseInt(String.valueOf(temp[i]));
        }
        
        dfs(0, digits.length(),digitsInt);
        return result;
    }
    
    public void dfs(int n, int size, int[]digitsInt){
        if(n>=size) {
            result.add(String.valueOf(tempChars));
        }else{
            char[] tempChar = digitToChar[digitsInt[n]].toCharArray();
            for(int i =0;i<tempChar.length;i++){
                tempChars[n] = tempChar[i];
                dfs(++n, size, digitsInt);
                n--;
            }
        }
    }
    
    
    // 牛客网解法，思路一样，代码简洁点
    public List<String> letterCombinations2(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }
    
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
    
    
    public static void main(String[] args) {
        String test = "";
    
        T17letterCombinations t17letterCombinations = new T17letterCombinations();
        t17letterCombinations.letterCombinations(test);
        
        for (String sresult :result) {
            System.out.println(sresult);

        }
    }
    
}
