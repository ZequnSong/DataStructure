package com.tree;

public class Node {
    int data;
    Node leftChild;
    Node rightChild;
    //boolean isDelete;

    public Node(int data){
        this.data = data;
    }

    //print the data of the node
    public void display(){
        System.out.println(data);
    }

}