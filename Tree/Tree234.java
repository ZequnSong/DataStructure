package com.tree;
/**
 * 2-3-4 Tree
 * no deletion method
 * no repeat element
 * @author Zequn Song
 * Email : zsong73@gwu.edu
 */
public class Tree234 {
    private Node root = new Node() ;
    /*public Tree234(){
        root = new Node();
    }*/

    //dataItem in node, each node have at most 3 dataItems
    class DataItem{
        public long dData;
        public DataItem(long dData){
            this.dData = dData;
        }
        public void displayItem(){
            System.out.println("/"+dData);
        }
    }

    class Node{
        private static final int ORDER = 4;//each node has at most 4 children
        private int numItems;//number of dataItem in each node
        private Node parent;
        private Node childArray[] = new Node[ORDER];//save pointer to the children of node, at most 4 children
        private DataItem itemArray[] = new DataItem[ORDER-1];// an ordered array save the dataItems of node, at most 3 dataItems

        //connect a child node to this.node
        public void connectChild(int childNum,Node child){
            childArray[childNum] = child;
            if(child != null){
                child.parent = this;
            }
        }

        //disconnect a child node to this.node
        public Node disconnectChild(int childNum){
            Node tempNode = childArray[childNum];
            childArray[childNum] = null;
            return tempNode;
        }

        public Node getChild(int childNum){
            return childArray[childNum];
        }

        public Node getParent(){
            return parent;
        }

        public boolean isLeaf(){
            return (childArray[0] == null)?true:false;
        }

        public int getNumItems(){
            return numItems;
        }

        public DataItem getItem(int index){
            return itemArray[index];
        }

        public boolean isFull(){
            return (numItems == ORDER-1) ? true:false;
        }

        //find the position of dataItem in a node
        public int findItem(long key){
            for(int j = 0 ; j < ORDER-1 ; j++){
                if(itemArray[j]==null){
                    break;
                }else if(itemArray[j].dData == key){
                    return j;
                }
            }
            return -1;
        }


        public int insertItem(DataItem newItem){
            numItems++;
            long newKey = newItem.dData;
            for(int j = ORDER-2 ; j >= 0 ; j--){
                if(itemArray[j] == null){
                    continue;
                }else{
                    long itsKey = itemArray[j].dData;
                    if(newKey < itsKey){//if newKey smaller than current item
                        itemArray[j+1] = itemArray[j];//move the current item one step back
                    }else{
                        itemArray[j+1] = newItem;//if newKey bigger than current item, directly insert into next position
                        return j+1;
                    }
                }
            }
            //if all null or all bigger than newKey
            itemArray[0] = newItem;
            return 0;
        }

        public DataItem removeItem(){
            DataItem temp = itemArray[numItems-1];
            itemArray[numItems-1] = null;
            numItems--;
            return temp;
        }
        //display all item.data in node
        public void displayNode(){
            for(int j = 0 ; j < numItems ; j++){
                itemArray[j].displayItem();
            }
            System.out.println("/");
        }
    }


    /**
     * search key
     * @param key
     * @return
     */
    public int find(long key){
        Node curNode = root;
        int childNumber ;
        while(true){
            //if key is in current node, return childNumber
            if((childNumber = curNode.findItem(key))!=-1){
                return childNumber;
            }else if(curNode.isLeaf()){//if key is not in current node and current node is leaf node
                return -1;
            }else{//find key in child of current node
                curNode = getNextChild(curNode,key);
            }
        }
    }

    //use to find a direction in search method
    public Node getNextChild(Node theNode,long theValue){
        int j;
        int numItems = theNode.getNumItems();
        for(j = 0 ; j < numItems ; j++){
            //if key is smaller than item[j].key, then should keep search in child[j]
            if(theValue < theNode.getItem(j).dData){
                return theNode.getChild(j);
            }
        }
        //if key is bigger than all items in node, then should search child[numItems]
        return theNode.getChild(j);
    }

    /**
     * insert new node
     * only insert in leaf node
     * @param dValue
     */
    public void insert(long dValue){
        Node curNode = root;
        DataItem tempItem = new DataItem(dValue);
        while(true){
            //check if current is full
            if(curNode.isFull()){
                // split the node if full
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, dValue);
            }else if(curNode.isLeaf()){//check if current node is leaf
                break;//break to insert data if is leaf
            }else{
                //keep going to find the next correct node to recheck
                curNode = getNextChild(curNode, dValue);
            }
        }//end while
        curNode.insertItem(tempItem);
    }

    //deal with full node, use in insert method
    public void split(Node thisNode){
        DataItem itemB,itemC;
        Node parent,child2,child3;
        //remove item C, which is going to move in new brother node
        itemC = thisNode.removeItem();
        //remove item B, which is going to move in new parent node
        itemB = thisNode.removeItem();
        //disconnect child 2&3, which is going to move in new brother node
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);

        if(thisNode == root){
            /*do root split if current node is root
             *      A   B   C                   B  _  _
             *    /   |   |   \   --->        /   \
             *   0    1   2    3          A _ _      C _ _
             *                          /  |       /  |
             *                         0   1       2  3
             */
            root = new Node(); //create a new root node
            parent = root;
            root.connectChild(0, thisNode);
        }else{
            /*do root split if current node is not root
             *
             *
             *     20  30  _                    20  B   30
             *   /   |    |                   /   |    |    \
             *  *   ABC   *                 *    A_ _  C_ _  *
             *    / | | \      --->             / |   / |
             *   0  1 2  3                      0 1   2  3
             *
             *
             */

            parent = thisNode.getParent();
        }
        int itemIndex;
        //move item B to parent
        itemIndex = parent.insertItem(itemB);
        //if in parent node, still have item after item B
        //need to adjust the position of children
        int n = parent.getNumItems();
        for(int j = n-1; j > itemIndex ; j--){
            Node temp = parent.disconnectChild(j);
            parent.connectChild(j+1, temp);
        }
        Node newRight = new Node();//create a new brother node
        //connect brother node to parent
        parent.connectChild(itemIndex+1, newRight);
        //move item C to brother
        newRight.insertItem(itemC);
        //move child 2&3 in new brother node
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    public void displayTree(){
        recDisplayTree(root,0,0);
    }
    private void recDisplayTree(Node thisNode,int level,int childNumber){
        System.out.println("levle="+level+" child="+childNumber+" ");
        thisNode.displayNode();
        int numItems = thisNode.getNumItems();
        for(int j = 0; j < numItems+1 ; j++){
            Node nextNode = thisNode.getChild(j);
            if(nextNode != null){
                recDisplayTree(nextNode, level+1, j);
            }else{
                return;
            }
        }
    }
}