package com.hash;

/**
 * Hash Table
 * Open Addressing
 * Double Hashing
 * incomplete about extension
 * @author : Zequn Song
 * Email : zsong73@gwu.edu
 */

public class DHashTable {
    private DataItem[] hashArray;
    private int arraySize;//original size of hashArray
    private int itemNum;//number of items actually in the array
    private DataItem nonItem;//used for deletion

    //Double Hash requires the size of array is prime number
    public DHashTable(){
        this.arraySize = 13;
        hashArray = new DataItem[arraySize];
        //assume data is all positive, if delete a data, replace it with nonItem
        //we cannot just delete it because if a position is null, when we run find method
        //algorithm will stop if meet a null position, even if we could find the data later
        nonItem = new DataItem(-1);
    }

    public static class DataItem{
        private int iData;
        public DataItem(int iData){
            this.iData = iData;
        }
        public int getKey(){
            return iData;
        }
    }

    public boolean isFull(){
        return (itemNum == arraySize);
    }

    public boolean isEmpty(){
        return (itemNum == 0);
    }


    public void display(){
        System.out.println("Table:");
        for(int j = 0 ; j < arraySize ; j++){
            if(hashArray[j] != null){
                System.out.print(hashArray[j].getKey() + " ");
                continue;
            }
            System.out.print("** ");
        }
        System.out.println();
    }

    // Hash Function
    //given a keyValue, get an index
    public int hashFunction1(int key){
        return key%arraySize;
    }

    // Hash Function 2
    // using for double hashing
    // stepSize = constant - key % constant;
    // constant is a prime number smaller than size of array
    public int hashFunction2(int key){
        return 5 - key%5;
    }

    //insertion
    public void insert(DataItem item){
        if(isFull()){
            System.out.println("HashTable is full, Rehashing..");
            extendHashTable();
        }
        int key = item.getKey();
        int hashVal = hashFunction1(key);
        //get the stepSize using hash function 2
        int stepSize = hashFunction2(key);
        //find an empty position or a position with nonItem to insert
        //because the hashTable should never be fulled, so while loop will eventually end
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1){
            //if hashArray[hashVal] != key,go to next stepSize
            //using double hashing, find next neighbor hashArray[hashVal + stepSize]
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
        itemNum++;
    }

    /**
     * the size of array is fixed, therefore we can only create another bigger array
     * insert the data from old array to new array
     * because hashFunction uses SIZE of array to compute the index, therefore these data cannot insert in the original position
     * therefore we cannot simply copy array
     * we need use insert method, visit each data in old array and put them in new array
     * this process is called re-hash
     *
     * size of array must be a prime number
     */
    public void extendHashTable(){
        int num = arraySize;
        itemNum = 0;//reset the itemNum
        arraySize *= 2;//*************not double, using prime number***************
        //save the old array
        DataItem[] oldHashArray = hashArray;
        //create the new array
        hashArray = new DataItem[arraySize];
        //insert each data of old array to new array
        for(int i = 0 ; i < num ; i++){
            insert(oldHashArray[i]);
        }
    }

    //deletion
    public DataItem delete(int key){
        if(isEmpty()){
            System.out.println("Hash Table is Empty!");
            return null;
        }
        //find the location of key
        int hashVal = hashFunction1(key);
        int stepSize = hashFunction2(key);
        while(hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey() == key){
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;//nonItem means null Item, key==-1
                itemNum--;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    //search
    public DataItem find(int key){
        //get the hashVal of key
        int hashVal = hashFunction1(key);
        //get the stepSize
        int stepSize = hashFunction2(key);
        //because the hashTable should never be fulled, so while loop will eventually end
        while(hashArray[hashVal] != null){
            //if hashArray[hashVal] == key, then successfully find
            if(hashArray[hashVal].getKey() == key){
                return hashArray[hashVal];
            }
            //if hashArray[hashVal] != key,go to next stepSize
            //using double hashing find next
            hashVal += stepSize;
            //as hashVal increases, eventually reach the tail of array
            //so we need it to warp around to the head of array
            hashVal %= arraySize;
        }
        return null;
    }

}
