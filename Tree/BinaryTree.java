package com.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree
 * @author : Zequn Song
 * Email : zsong73@gwu.edu
 */
public class BinaryTree implements Tree {
    //root node
    private Node root;

    /**
     * find the node with data key
     * @param key keyValue for search
     * @return null if cannot find it
     */
    public Node find(int key) {
        Node current = root;
        while(current != null){
            if(key < current.data){//if key is smaller than current data, then search left subtree
                current = current.leftChild;
            }else if(key > current.data){//if key is bigger than current data, then search right subtree
                current = current.rightChild;
            }else{//if key is equal to current data, then find it
                return current;
            }
        }
        return null;//return null because cannot find the key
    }

    /**
     * insert new node
     * @param data insert data
     * @return
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        Node current = root;
        //need to save the information of parentNode
        //because need the parentNode to connect the new node to the tree
        Node parentNode = null;

        //1. find the insert position, which is current
        while(current != null){
            parentNode = current;//store the parent of current, because current is going to move
            if(data < current.data)//if insert data is smaller than current data, then go into left subtree
                current = current.leftChild;
            else//if insert data is bigger than or equal to current data, then go into right subtree
                current = current.rightChild;
        }

        //2. connect newNode to parentNode
        if(parentNode != null){
            if(data < parentNode.data)
                parentNode.leftChild = newNode;
            else
                parentNode.rightChild = newNode;
        }else {
            //if parentNode is null, means tree was empty, let root = newNode
            this.root = newNode;
        }
    }

    /**
     * infix order iterate
     * will make all nodes to be sorted in ascending order
     * recursive version, simple but need one parameter
     * @param current current node is root node
     */
    public void infixOrder(Node current){
        /*
        1. calls itself to iterate current's leftChild
        2. visit current node
        3, calls itself to iterate current's rightChild
         */
        if(current != null){
            infixOrder(current.leftChild);
            System.out.print(current.data+" ");
            infixOrder(current.rightChild);
        }
    }

    /**
     * pre-order iterate
     * non-recursive version, simple but need one parameter
     */
    public List<Integer> preOrderRecur(){
        Stack<Node> stack = new Stack<>();
        List<Integer> preorder = new ArrayList<>();
        if(root == null) return preorder;
        stack.push(root);
        while(!stack.empty()){
            Node node = stack.pop();
            preorder.add(node.data);
            if(node.rightChild != null)
                stack.push(node.rightChild);
            if(node.leftChild != null)
                stack.push(node.leftChild);
        }
        return preorder;
    }

    /**
     * preorder
     * recursive version
     * @param current current node is root node
     */
    public void preOrder(Node current){
        /*
        1. visit current node
        2. calls itself to iterate current's leftChild
        3, calls itself to iterate current's rightChild
         */
        if(current != null){
            System.out.print(current.data+" ");
            infixOrder(current.leftChild);
            infixOrder(current.rightChild);
        }
    }

    /**
     *  post-order iterate
     *  recursive version, simple but need one parameter
     * @param current current node is root node
     */
    public void postOrder(Node current){
        /*
        1. calls itself to iterate current's leftChild
        2. calls itself to iterate current's rightChild
        3, visit current node
         */
        if(current != null){
            infixOrder(current.leftChild);
            infixOrder(current.rightChild);
            System.out.print(current.data+" ");
        }
    }

    public Node findMax(){
        Node current = root;
        Node maxNode = current;
        while(current != null){
            maxNode = current;
            current = current.rightChild;
        }
        return maxNode;
    }

    public Node findMin(){
        Node current = root;
        Node minNode = current;
        while(current != null){
            minNode = current;
            current = current.leftChild;
        }
        return minNode;
    }

    @Override
    public boolean delete(int key) {
        Node current = root; // to locate the node we want to delete
        Node parent = root;
        boolean isLeftChild = false;
        //find the value，return false if cannot find
        while(current.data != key){
            parent = current;
            if(current.data > key){//if value is smaller than current data, then go into left subtree
                isLeftChild = true;
                current = current.leftChild;
            }else{//if value is bigger than current data, then go into right subtree
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null){//return false if cannot find
                return false;
            }
        }
        /*
         * after find the node to delete
         * there are three situations:
         * 1. if current node has no childNode
         * 2. if current node has one childNode
         * 3. if current node has two childNode
         */

        /*
         * 1. if current node has no childNode
         * if current node is leftChild of parent, disconnect parent.leftChild
         * if current node is rightChild of parent,disconnect parent.rightChild
         */
        if(current.leftChild == null && current.rightChild == null){
            if(current == root){//if root, then tree is empty
                root = null;
            }else if(isLeftChild){
                parent.leftChild = null;
            }else{
                parent.rightChild = null;
            }
            return true;

            /*
             * 2. if current node has one childNode (rightChild)
             * if current node is leftChild of parent, reconnect parent.leftChild to current.rightChild
             * if current node is rightChild of parent,reconnect parent.rightChild to current.rightChild
             */
        }else if(current.leftChild == null && current.rightChild != null){
            if(current == root){
                root = current.rightChild;
            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else{
                parent.rightChild = current.rightChild;
            }
            return true;
            /*
             * 2. if current node has one childNode (leftChild)
             * if current node is leftChild of parent, reconnect parent.leftChild to current.leftChild
             * if current node is rightChild of parent,reconnect parent.rightChild to current.leftChild
             */
        }else if(current.leftChild != null && current.rightChild == null){
            if(current == root){
                root = current.leftChild;
            }else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }
            return true;
        }else{
            /*
             * 3. if current node has two childNodes
             * using currentNode's successor to replace the position of currentNode ()
             * successor is the minimum node that bigger than currentNode
             * again there are two situations:
             * 3.1 successor is the rightChild of currentNode
             * 3.2 successor is the most lefChild of currentNode's rightChild
             */
            /*
             * No matter 3.1 or 3.2
             * if current node is leftChild of parent, reconnect parent.leftChild to successor
             * if current node is rightChild of parent,reconnect parent.rightChild to successor
             * link successor.leftChild to current.leftChild
             */
            Node successor = getSuccessor(current);
            if(current == root){
                successor = root;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else{
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return false;

    }

    /**
     * get the successor node of currentNode
     * using for delete()
     * successor is the minimum node that bigger than currentNode
     * @param delNode
     * @return
     */
    public Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        //start with the rightChild of delNode
        //because successor is bigger than delNode, so must in rightChild
        //because this is situation 3, so currentNode must have two childNodes
        Node current = delNode.rightChild;

        //continue and keep moving current to leftChild
        //the most left node is the successor of delNode
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        //3.2 if successor is the most lefChild of currentNode's rightChild
        if(successor != delNode.rightChild){
            /* successor cannot have leftChild
             * successor can have rightChild or successor.rightChild is null
             * reconnect successorParent.leftChild to successor.rightChild
             * link successor.rightChild to delNode.rightChild;
             * */
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        System.out.println("infix-order iterate: ---");
        bt.infixOrder(bt.root);
        List<Integer> list = bt.preOrderRecur();
        System.out.println();
        System.out.println(list);
        bt.delete(10);
        bt.delete(30);
        bt.delete(80);
        System.out.println();
        System.out.print("after delete 10,30,80 : ---");
        bt.infixOrder(bt.root);
        System.out.println();
        System.out.println("max value in bt: " + bt.findMax().data);
        System.out.println("min value in bt: " + bt.findMin().data);
        System.out.print("find node with data=100: " + bt.find(100) + "  ");
        bt.find(100).display();
        System.out.println("find node with data=200: " + bt.find(200));

    }

}
