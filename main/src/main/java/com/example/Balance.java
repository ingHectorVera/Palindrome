package com.example;

import java.util.Stack;

/**
 * Created by User on 11/17/2016.
 */

public class Balance {

    public static void main(String[] args){
        String [] exercise = new String[]{")(",
        "a)", "{[()]}","{[()}]", "{a[b(c)d]e}", "a{b[c(d)e]f}g",
                "{a[b(c)d}e]", "a{b[c(d)e}f]g", "", "a", "a()", null};
        Balance b = new Balance();
        for (int i = 0; i<exercise.length; i++){
            if(b.balance(exercise[i])){
                System.out.println("It is balanced -> "+ exercise[i]);
            }else{
                System.out.println("It is not balanced -> "+ exercise[i]);
            }
        }
    }


    public boolean balance(String exp){
        boolean flag = false;
        int countFirst = 0;
        if(exp != null) {
            if (!exp.equals("")) {
                char[] cExp = exp.toCharArray();
                Stack<Character> stack = new Stack<Character>();
                for (int i = 0; i < cExp.length; i++) {
                    //char temp = cExp[i];
                    if (descartChar(cExp[i])) {
                        if ((i == 0 || countFirst == 0) && (isOpenOrClose(cExp[i]) == 1)) {
                            return false;
                        } else {
                            if (isOpenOrClose(cExp[i]) == 0) {
                                stack.push(cExp[i]);
                            } else {
                                if (!stack.isEmpty()) {
                                    char temp = stack.pop();
                                    if (isPSQ(temp) != isPSQ(cExp[i])) {
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            }
                        }
                        countFirst++;
                    }
                }
                if (stack.isEmpty() && countFirst != 0) {
                    flag = true;
                }
            } else {
                flag = false;
            }
        }else {
            flag = false;
        }
        return flag;
    }

    public char isPSQ(char c){
        char cTemp = ' ';
        if(c == '(' || c == ')'){
            cTemp ='P';
        }else if(c == '[' || c == ']'){
            cTemp = 'S';
        }else if(c == '{' || c == '}'){
            cTemp = 'Q';
        }
        return cTemp;
    }
    /* 0 - Open
    ** 1 - Close
     */
    public int isOpenOrClose(char c){
        int flag = 0;
        if(c == '(' || c == '[' || c == '{'){
            flag = 0;
        }else if(c == ')' || c == ']' || c == '}'){
            flag = 1;
        }
        return flag;
    }

    public boolean descartChar(char c){
        if(c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}'){
            return true;
        }else {
            return false;
        }
    }


}
