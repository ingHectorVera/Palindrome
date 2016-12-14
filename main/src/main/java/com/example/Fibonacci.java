package com.example;

import java.util.ArrayList;

/**
 * Created by User on 11/17/2016.
 */

public class Fibonacci {

    public static void main(String[] args){
        Fibonacci f = new Fibonacci();
        f.fibonacciExcercise(15);
    }

    public ArrayList<Integer> fibonacciExcercise(int iterator){
        iterator--;
        ArrayList<Integer> fibonacci = new ArrayList<Integer>();
        int temp = 1;
        System.out.println("Number: " + temp);
        fibonacci.add(temp);
        if(iterator >= 1){
            for (int i = 1; i<= iterator; i++){
                int last = fibonacci.get(i-1);
                fibonacci.add(temp);
                System.out.println("Number: " + temp);
                temp = temp+last;
            }
        }
        return fibonacci;
    }
}
