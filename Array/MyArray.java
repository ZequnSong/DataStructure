package com.array;

/**
 * Array Structure
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class MyArray {

    //define an array
    private int[] intArray;

    //define the actual length
    private int elemsnum;

    //define the max length
    private int length;

    public MyArray(){
        elemsnum = 0;
        length = 50;
        intArray = new int [length];
    }

    public MyArray(int length){
        elemsnum = 0;
        this.length = length;
        intArray = new int [length];
    }

    public int getSize(){
        return elemsnum;
    }

    /**
     * iterate the array
     */
    public void display(){
        for(int i = 0; i < elemsnum; i++){
            System.out.print(intArray[i] + " ");
        }
        System.out.println();
    }

    /**
     * add element
     * @param value
     * @return true if success, flase if index out of range
     */
    public boolean add(int value){
        if(elemsnum == length){
            return false;
        }else{
            intArray[elemsnum] = value;
            elemsnum++;
        }
        return true;
    }

    /**
     * get i-th element
     * @param i
     * @return return the element if index is legal
     * return error if index out of range
     */
    public int get(int i){
        if(i < 0 || i >= elemsnum) {
            System.out.println("error: [get] index out of range");
            return -1;
        }
        return intArray[i];
    }

    /**
     * find element
     * @param searchValue
     * @return if searchValue exist in array, return the index
     */
    public int find(int searchValue){
        int i;
        for(i = 0; i < elemsnum; i++){
            if(intArray[i] == searchValue) {
                break;
            }
        }
        if(i == elemsnum){
            System.out.println("error: [find] value doesn't exist in the array");
            return -1;
        }
        return i;
    }

    /**
     * delete element
     * @param deleteValue
     * @return if deleteValue doesn't exist in array, return the false, otherwise true
     */
    public boolean delete(int deleteValue){
        int k = find(deleteValue);
        if(k == -1){
            System.out.println("error: [delete] value doesn't exist in the array");
            return false;
        }else{
            if(k == elemsnum - 1)
                elemsnum--;
            else{
                for(int i = k; i < elemsnum - 1; i++){
                    intArray[i] = intArray[i+1];
                }
                elemsnum--;
            }
        }
        return true;
    }

    /**
     * modify the array
     * @param oldValue
     * @param newValue
     * @return success return true, otherwise false
     */
    public boolean modify(int oldValue, int newValue){
        int i = find(oldValue);
        if(i == -1){
            System.out.println("error: [modify] value doesn't exist");
            return false;
        }else{
            intArray[i] = newValue;
            return true;
        }
    }

}
