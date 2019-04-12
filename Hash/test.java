package com.hash;

public class test {

   static int[] dataSet = {12,5,7,33,24,23,3,0,19,28};

    public static void main(String []args){

        //-----------------HashTable-----------------------------
        System.out.println("------------------- HashTable---------------------------");
        HashTable ht = new HashTable(10);
        HashTable.DataItem dataItem;
        for(int i = 0; i < dataSet.length; i++ ) {
            dataItem = new HashTable.DataItem(dataSet[i]);
            ht.insert(dataItem);
        }
        System.out.println("print the HashTable:");
        ht.display();
        System.out.println("find key = 33:  " + ht.find(33).getKey() );
        dataItem = new HashTable.DataItem(9);
        System.out.println("insert key = 9");
        ht.insert(dataItem);
        ht.display();
        System.out.println("delete key = 9, then try to find 9");
        ht.delete(9);
        ht.display();
        System.out.println("find key = 9:  " + ht.find(9) );

        //------------------Double Hash Table--------------------
        System.out.println("-------------------Double Hash Table---------------------------");
        DHashTable dht = new DHashTable();
        DHashTable.DataItem dataItem1;
        for(int i = 0; i < dataSet.length; i++ ) {
            dataItem1 = new DHashTable.DataItem(dataSet[i]);
            dht.insert(dataItem1);
        }
        System.out.println("print the Double Hash Table:");
        dht.display();
        System.out.println("find key = 33:  " + ht.find(33).getKey() );
        dataItem1 = new DHashTable.DataItem(9);
        System.out.println("insert key = 9");
        dht.insert(dataItem1);
        dht.display();
        System.out.println("delete key = 9, then try to find 9");
        dht.delete(9);
        dht.display();
        System.out.println("find key = 9:  " + dht.find(9) );
        //-----------------------Chain Hash-----------------------
        System.out.println("-------------------Chain Hash---------------------------");
        ChainHash ch = new ChainHash(10);
        ChainHash.DataItem dataItem2;
        for(int i = 0; i < dataSet.length; i++ ) {
            dataItem2 = new ChainHash.DataItem(dataSet[i]);
            ch.insert(dataItem2);
        }
        System.out.println("print theChain Hash:");
        ch.displayTable();
        System.out.println("find key = 33:  " + ch.find(33).getKey() );
        System.out.println("insert key = 9");
        dataItem2 = new ChainHash.DataItem(9);
        ch.insert(dataItem2);
        ch.displayTable();
        System.out.println("delete key = 9, then try to find 9");
        ch.delete(9);
        ch.displayTable();
        System.out.println("find key = 9:  " + ch.find(9) );


    }
}
