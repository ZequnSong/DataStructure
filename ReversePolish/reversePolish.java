package com.reversePolishNotation;

/**
 *  reverse PolishNotation
 *  transfer Normal Notation to Reverse-Polish Notation
 *  For example : A*(B+C)-D/(E+F)  -->   A B C + * D E F + / -
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class reversePolish {
    //operator stack
    private MyCharStack s1;
    //result stack
    private MyCharStack s2;
    //original notation string
    private String input;

    public reversePolish(String input){
        this.input = input;
        s1 = new MyCharStack(input.length());
        s2= new MyCharStack(input.length());
    }

    /**
     * main transfer method
     * @return goal stack, output Reverse-Polish Notation
     */
    public MyCharStack doTransfer(){
        //from the left to the right, scan each char of the input string
        for(int j = 0; j < input.length(); j++){

            System.out.print("what's in s1 now: ");
            s1.displayStack();
            System.out.print("what's in s1 now: ");
            s2.displayStack();
            char ch = input.charAt(j);
            System.out.println("current resolving: "+ch);

            switch(ch){
                //if got +&-, give weight=1 to the currentOperator
                case '+':
                case '-':
                    gotOper(ch,1);
                    break;
                //if got *&/, give weight=2 to the currentOperator
                case '*':
                case '/':
                    gotOper(ch,2);
                    break;
                //if currentOperator is '(', push into s1 directly
                case '(':
                    s1.push(ch);
                    break;
                //if currentOperator is ')', pop operators in s1 one by one until meet '('
                case ')':
                    getParen();
                    break;
                //if currentOperator is number, push into s2 directly
                default:
                    s2.push(ch);
                    break;
            }
        }
        //pop the remaining operators in s1 orderly and push into s2
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        return s2;
    }

    /**
     * do this part if currentOperator is '+''-''*''/'
     * @param thisOper
     * @param weight1
     */
    public void gotOper(char thisOper, int weight1){
        while(!s1.isEmpty()){
            char topOper  = s1.peek();
            //if topOper in s1 is '(', break and goto s1.push(thisOper);
            //push thisOper in s1 directly
            if(topOper == '('){
                break;
            }else{
                //give a weight to topOper
                int weight2;
                if(topOper == '+' || topOper =='-'){
                    weight2 = 1;
                }else{
                    weight2 = 2;
                }
                //if thisOper's weight bigger than topOper's weight
                //push thisOper in s1 directly
                if(weight1 > weight2){
                    break;
                }else{
                    //if  thisOper's weight smaller than equal to topOper's weight
                    //pop topOper and push it into s2
                    //then continue the loop and compare thisOper with the next new topOper in s1
                    s2.push(s1.pop());
                }
            }
        }
        //if s1 is empty, push thisOper into s1 directly
        s1.push(thisOper);
    }

    /**
     * do this part if currentOperator is ')'
     * pop operators in s1 one by one until meet '('
     */
    public void getParen(){
        while(!s1.isEmpty()){
            //pop and get the current top on s1
            char ch = s1.pop();
            //push into s2 one by one until meet '('
            if(ch == '('){
                break;
            }else{
                s2.push(ch);
            }
        }
    }
}
