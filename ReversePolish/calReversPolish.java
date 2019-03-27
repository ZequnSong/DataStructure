package com.reversePolishNotation;

import com.stack.MyStack;

/**
 *  how to calculate the result given a reverse PolishNotation
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class calReversPolish {
    private MyStack stack;
    private String input;

    public calReversPolish(String input){
        this.input = input;
        stack = new MyStack(input.length());
    }

    public int doCal(){
        int num1,num2,result;
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            //if get a number, push into stack directly
            if(ch >= '0'&& ch<='9'){
                stack.push((int)(ch-'0'));
            }else{
                //first pop is num2 -- important
                num2 = stack.pop();
                num1 = stack.pop();
                switch(ch){
                    case'+':
                        result = num1 + num2;
                        break;
                    case'-':
                        result = num1 - num2;
                        break;
                    case'*':
                        result = num1 * num2;
                        break;
                    case'/':
                        result = num1 / num2;
                        break;
                    default:
                        result = 0;
                        break;
                }
                stack.push(result);
            }
        }
        //finally only one number in the stack
        result = stack.pop();
        return result;
    }

    /**
     * using reversePolish.java
     * convert a Normal Notation String to a Reverse-Polish Notation String
     * @param input
     * @return
     */
    public static String convert(String input){
        //instance of reversePolish.java
        reversePolish rp = new reversePolish(input);
        //the reverse of the reverStack is Reverse-Polish Notation String
        MyCharStack reverStack = rp.doTransfer();
        //reverse output the reverStack
        char[] res = new char[reverStack.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = reverStack.pop();
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        //Normal Notation String
        //1*(2+3)-5/(2+3) = 4
        String input = "1*(2+3)-5/(2+3)";
        System.out.println("Normal Notation String: " + input);

        //Reverse-Polish Notation String
        //123+*123+/-
        String reversPolishString = convert(input);
        System.out.println("Reverse-Polish Notation String: " + reversPolishString);

        calReversPolish cs = new calReversPolish(reversPolishString);
        System.out.println("Result of calculation: " + cs.doCal());
    }
}
