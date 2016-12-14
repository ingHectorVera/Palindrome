package com.example;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Excercises {

    public static void main(String[] args){
        Excercises excercise = new Excercises();
        excercise.palindromeExcercise("aaaaa");
        excercise.palindromeExcercise("abccba");
        excercise.palindromeExcercise("exceerrrcise");

    }

    public void palindromeExcercise(String word){
        StringBuilder builder = new StringBuilder(word);
        int count = word.length();
        for(int i=0; i<count; i++) {
            for(int j=1; j<=count; j++) {
                if(i<j) {
                    String sTemp = builder.substring(i, j);
                    if (isPalindrome(sTemp)) {
                        System.out.println("It is a palindrome: " + sTemp + " from the original word - " + word);
                    } else {
                        //System.out.println("It is not a palindrome: " + sTemp + " from the original word - " + word + " i:" + i + " j:" + j);
                    }
                }
            }
        }
    }

    private boolean isPalindrome(String word){
        boolean flag = false;
        StringBuilder builder = new StringBuilder(word);
        builder = builder.reverse();
        if(word.equals(builder.toString())){
            flag = true;
        }
        return flag;
    }


}

