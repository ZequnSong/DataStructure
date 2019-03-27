package com.stack;

import java.util.HashMap;
import java.util.Map;

public class ObjectStackTest {
    /**
     * test ObjectStack, push different types elements and get them
     */
    public static void test(){
        System.out.println("-------------testDiffElementType--------------");
        ObjectStack stack = new ObjectStack(3);
        Map<String,String> map = new HashMap<>();
        map.put("11","22");

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("size before grow: "+stack.size());
        stack.push(map);
        stack.push("abc");
        System.out.println("size after grow: "+stack.size());

        Object obj = stack.peek();
        String peek1= obj.toString();
        System.out.println("String element on the stack: "+peek1);

        stack.pop();
        obj = stack.pop();
        Map<String,String> peek2 = (Map<String,String>)obj;
        System.out.println("Map element on the stack: "+peek2.get("11"));
        stack.pop();
        System.out.println(stack.peek());
        System.out.println("------------------------------------------");
    }

    /**
     * reverse the string "How are you"
     */
    public static void testStringReversal(){
        System.out.println("-------------testStringReversal---------------");
        ObjectStack stack = new ObjectStack();
        String str = "How are you";
        char[] cha = str.toCharArray();
        for(char c : cha){
            stack.push(c);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.println();
        System.out.println("-----------------------------------------------");
    }

    /**
     * Delimiters Matching
     * if get a left Delimiter ({,[,<), push into Stack
     * if get a right Delimiter (},],>), pop and compare if these two are equal
     */
    public static void testDelimiterMatch() {
        System.out.println("------------------testDelimiterMatch------------");
        ObjectStack stack = new ObjectStack();
        String str = "12<a[b{c}]>";
        char[] cha = str.toCharArray();
        for (char c : cha) {
            switch (c) {
                case '{':
                case '[':
                case '<':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                case '>':
                    if (!stack.isEmpty()) {
                        char ch = (char) stack.pop();
                        if (c == '}' && ch != '{'
                                || c == ']' && ch != '['
                                || c == '>' && ch != '<') {
                            System.out.println("Error Matching: "+ch+"-"+c);
                        }
                    }else {
                        System.out.println("Error Matching: "+c);
                    }
                    break;
                default:
                    break;
            }
        }
        if (stack.isEmpty()){
            System.out.println("Matching success: " + str);
        }
        System.out.println("-----------------------------------------------");
    }



    public static void main (String[] args){
       test();
       testStringReversal();
        testDelimiterMatch();
    }
}
