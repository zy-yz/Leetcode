package com.zy.leet.twenty;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
*/
public class IsValid {
    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};

    public boolean isValid(String s) {
        if(s.length() > 0 && !map.containsKey(s.charAt(0))){
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>(){{add('?');}};
        for (Character c : s.toCharArray()){
            if(map.containsKey(c)) {
                stack.addLast(c);
            } else if(map.get(stack.removeLast()) != c) {
                return false;
            }
        }
        return stack.size()==1;

    }
}
