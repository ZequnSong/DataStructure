package com.hash;
import com.hash.SortedList.Node;

/**
 * Hash Table
 * Chain Addressing
 *  sorted linked list
 * @author : Zequn Song
 * Email : zsong73@gwu.edu
 */



public class ChainHash {

    private SortedList[] hashArray;//data of array is linked list
    private int arraySize;

    public ChainHash(int size){
        arraySize = size;
        hashArray = new SortedList[arraySize];
        //initialize each linked list in array
        for(int i = 0 ; i < arraySize ; i++){
            hashArray[i] = new SortedList();
        }
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

    public void displayTable(){
        for(int i = 0 ; i < arraySize ; i++){
            System.out.print(i + "：");
            hashArray[i].display();
        }
        System.out.println();
    }

    public int hashFunction(int key){
        return key%arraySize;
    }

    public void insert(DataItem data){
        int key = data.getKey();
        int hashVal = hashFunction(key);
        hashArray[hashVal].insert(key);
    }

    public DataItem delete(int key){
        int hashVal = hashFunction(key);
        DataItem temp = find(key);
        hashArray[hashVal].delete(key);
        return temp;
    }

    public DataItem find(int key){
        int hashVal = hashFunction(key);
        Node node = hashArray[hashVal].find(key);
        if(node == null)
            return null;
        else{
            DataItem data =node.getKey();
            return data;
        }
    }

}
