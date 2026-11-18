package com.coding;

import java.util.Stack;

public class StringBrackets {

    public static void main(String[] args) {

        String str = "[]";

        System.out.println(isBalanced(str));

    }

    private static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            else if(c==')' || c=='}' || c==']'){
                if(stack.isEmpty()){
                    return false;
                }
               char pop= stack.pop();


               if((c==')' && pop!='(')||(c == '}' && pop != '{') ||
                       (c == ']' && pop != '[')){
                   return false;
               }
            }
        }

        return stack.isEmpty();
    }
}
