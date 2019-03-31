package com.recursion;

/**
 *  Merge Sort
 *  a quick version of recursive MergeSort
 *  instead of creating temp[] array in each recursion step
 *  create temp[] in mergeSort()
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class MergeSort2 {
    private int[] array;
    private int numElem;

    public MergeSort2(int max){
        array = new int[max];
        numElem = 0;
    }

    public void insert(int value){
        array[numElem++] = value;
    }

    public void randomInsert(int value){
        if(numElem + value <= array.length){
            int i = 0;
            while(i < value){
                array[numElem++] = (int)(1 + Math.random()*1000);
                i++;
            }
        }
    }

    public void display(){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void mergeSort(){
        int[] temp = new int[numElem];
        recMergeSort(temp, 0 ,numElem - 1);
    }

    /**
     * Merge Sort
     * recursive
     * @param temp
     * @param start 0
     * @param last array.length - 1
     * @return
     */
    private int[] recMergeSort(int[] temp,int start,int last){
        //if more than one value in the array
        if(last > start){
            //find midpoint
            int mid = start + (last - start)/2;
            //sort low half
            recMergeSort(temp,start,mid);
            //sort high half
            recMergeSort(temp,mid + 1,last);
            //merge the two part
            merge(temp,start,mid,last);
        }
        return temp;
    }

    /**
     * merge operation, similar to mergeSortFor()
     * array[start] --- array[mid] is sorted array a
     * array[mid+1] --- array[last] is sorted array b
     * @param temp
     * @param start
     * @param mid
     * @param last
     */
    private void merge(int[] temp, int start, int mid, int last){
        int i = start;
        int j = mid + 1;
        int k = 0;
        //if both a and b have values
        while(i <= mid && j <= last){
            //compare the value in a and value in b
            //push the smaller one into temp[]
            if(array[i] <  array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        //if all values in a are already in temp[], then push all rest values in b into temp[]
        while(j <= last && i > mid)
            temp[k++] = array[j++];
        //if all values in b are already in temp[], then push all rest values in a into temp[]
        while(i <= mid && j > last)
            temp[k++] = array[i++];
        //copy the values in new array temp[] into array
        for(int k2 = 0 ;k2 < last - start + 1 ; k2++){
            array[start + k2] = temp[k2];
        }
    }
}
