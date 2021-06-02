package com.zhs.zbhuang.subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 电话号码的字母组合 {

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        }
        backTrack(result,digits,0,new StringBuilder());
      return result;
    }

    public static void backTrack(List<String> result, String digits, int index, StringBuilder str) {
        if(index == digits.length()) {
            result.add(str.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = convertCharacter(digit);
            for (int i=0;i<letters.length();i++) {
                str.append(letters.charAt(i));
                backTrack(result, digits,index+1,str);
                str.deleteCharAt(index);
            }
        }
    }

    public static String convertCharacter(char ch){
        String str = "";
        switch (ch) {
            case '2':
                str = "abc";
                break;
            case '3':
                str = "def";
                break;
            case '4':
                str = "ghi";
                break;
            case '5':
                str = "jkl";
                break;
            case '6':
                str = "mno";
                break;
            case '7':
                str = "pqrs";
                break;
            case '8':
                str = "tuv";
                break;
            case '9':
                str = "wxyz";
                break;
        }
        return str;
    }



    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
