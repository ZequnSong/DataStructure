package com.recursion;

public class test {
    /**
     * iterate the array
     */
    public static void display(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){

        System.out.println("-------test for factorial---------");
        System.out.println(Factorial.factorial(10));

        System.out.println("-------test for binary search---------");
        int[] array = {2,5,8,11,23,34,56,78,99};
        System.out.println("Search for \"78\":"+BinarySearch.binarySearchFor(array,78));
        System.out.println("Search for \"99\":"+BinarySearch.binarySearch(array,99,0,array.length-1));

        System.out.println("-------test for HanoiTower---------");
        Hanoi.doHanoi(3,'A','B','C');

        System.out.println("-------test for MergeSort---------");
        int[] a = {3,6,12,22,45,78,345,675};
        int[] b = {0,5,55,68,77,444,676,999,9999};
        display(MergeSort.mergeSortFor(a,b));


        int size = 10000000;
        int[] c = new int[size];
        int i = 0;
        while(i < c.length){
            c[i] = (int)(1 + Math.random()*1000);
            i++;
        }
        double startTime = System.nanoTime();
        MergeSort.mergeSort(c,0,c.length-1);
        double endTime = System.nanoTime();
        //display(c);
        System.out.println("time for mergeSort1: " + (endTime - startTime));

        MergeSort2 ms = new MergeSort2(size);
        ms.randomInsert(size);
        startTime = System.nanoTime();
        ms.mergeSort();
        endTime = System.nanoTime();
        //ms.display();
        System.out.println("time for mergeSort2: " + (endTime - startTime));
    }
}
