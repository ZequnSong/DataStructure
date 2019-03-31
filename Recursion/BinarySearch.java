package com.recursion;

/**
 *  Binary Search
 *  for loop and recursion version
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class BinarySearch {
    /**
     * binary search in for loop
     * @param array
     * @param value
     * @return -1 if cannot find value
     */
    public static int binarySearchFor(int[] array, int value){
        int start = 0;
        int end = array.length - 1;
        while(start < end){
            int mid = (end - start) / 2 + start;
            if(value == array[mid])
                return mid;
            if(value > array[mid]) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * binary search in recursion
     * @param array
     * @param value
     * @return -1 if cannot find value
     */
    public static int binarySearch(int[] array, int value, int low, int high){
        int mid = (high - low) / 2 + low;
        if(array[mid] == value)
            return mid;
        else if(low > high)
            return -1;
        else{
            if(array[mid] > value)
                return binarySearch(array, value, low, mid - 1);
            if(array[mid] < value)
                return binarySearch(array, value, mid + 1, high);
        }
        return -1;
    }
}
