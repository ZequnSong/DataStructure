package com.recursion;

/**
 * Combination only consider which to select, ignoring the order
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class Combination {
    //people who we can select
    private char[] persons;
    //mark a person as true if selected
    private boolean[] selects;

    public Combination(char[] persons){
        this.persons = persons;
        //default is false
        selects = new boolean[persons.length];
    }

    public void showResult(int num){
        combination(num, 0);
    }

    /**
     *
     * @param num number need to select
     * @param index where to start
     */
    public void combination(int num,int index){
        //num reduce to 0, means find one solution
        if(num == 0){
            //print the result
            for(int i = 0 ; i < selects.length ; i++){
                if(selects[i] == true){
                    System.out.print(persons[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        //index surpass the total number of people, didn't find it
        if(index >= persons.length)
            return;

        //select k nums from n
        // -- (n,k) = (n-1,k-1) + (n-1,k)
        // -- (5,3) = (4,2) + (4,3)
        selects[index] = true;
        combination(num-1,index+1);
        selects[index] = false;
        combination(num,index+1);
    }


    public static void main(String[] args) {
        char[] persons = {'A','B','C','D','E'};
        Combination cb = new Combination(persons);
        cb.showResult(3);
}
}
