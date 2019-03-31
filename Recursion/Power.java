package com.recursion;
/**
 *  Power function
 *  using Divide & Conquer and Recursion
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class Power {
    /**
     * power function
     * using Divide & Conquer
     * a^n = a^(n/2) * a^(n/2)
     * @param x
     * @param y
     * @return
     */
    public static int pow1(int x, int y){
        int result = 0;
        if(x == 0 || x == 1 || y==1 )
            return x;
        if(y == 0 )
            return 1;
        else{//y>1
            if (y%2 == 1){ // y is odd num
                result = pow1(x,y/2);
                result = result * result * x;
            }else{ //y is even num
                result = pow1(x,y/2);
                result = result * result;
            }
        }
        return result;
    }

    /**
     * power function
     * using Recursion
     * a^n = (a^2)^(n/2)
     * @param x
     * @param y
     * @return
     */
    public static int pow2(int x, int y){
        if(x == 0 || x == 1 || y==1 )
            return x;
        if(y == 0 )
            return 1;
        else{//y>1
            //x^y = (x^2)^(y/2)
            int a = x * x;
            int b = y / 2;
            if (y%2 == 1){ // y is odd num
                return pow2(a,b) * x;
            }else{ //y is even num
                return pow2(a,b);
            }
        }
    }
    public static void main (String[] args){
        System.out.println(pow1(2,10));
        System.out.println(pow2(2,10));
    }
}
