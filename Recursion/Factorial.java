package com.recursion;
/**
 *  compute factorial in for loop and recursion
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class Factorial {
    /**
     * factorial written in for loop
     * 0!=1!=1
     * @param n
     * @return
     */
    public static int factorialFor(int n){
        int temp = 1;
        if(n >= 0){
            for(int i = 1; i <=n; i++){
                temp = temp * i;
            }
        }else
            return  -1;
        return temp;
    }

    /**
     * factorial written in recursion
     * @param n
     * @return
     */
    public static int factorial(int n){
        if(n >= 0){
            if(n == 0){
                System.out.println(n+"!=1");
                return 1;
            }else{
                System.out.println(n);
                int temp = n * factorial(n-1);
                System.out.println(n + "!=" + temp);
                return temp;
            }
        }else
            return -1;
    }
}
