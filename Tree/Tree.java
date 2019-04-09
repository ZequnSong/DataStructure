package com.tree;

public interface Tree {
    //search node
    Node find(int key);

    //insert new node
    boolean insert(int data);

    //infix iterate
    void infixOrder(Node current);
    //pre-order iterate
    void preOrder(Node current);
    //post-order iterate
    void postOrder(Node current);

    //fina node with max data
    Node findMax();
    //find node with min data
    Node findMin();

    //delete node
    boolean delete(int key);

    //Other Method......
}