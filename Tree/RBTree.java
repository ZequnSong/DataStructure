package com.tree;

/**
 * Red-Black Tree
 * @author Zequn Song
 * Email : zsong73@gwu.edu
 *
 * @param <T>
 */
public class RBTree<T extends Comparable<T>>{
    private RBNode<T> root; //root node
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    //Node Class
    public class RBNode<T extends Comparable<T>>{
        boolean color; //RED = false, BLACK = true
        T key; //key data
        RBNode<T> left;
        RBNode<T> right;
        RBNode<T> parent;

        public RBNode(T key, boolean color, RBNode<T> parent, RBNode<T> left, RBNode<T> right) {
            this.key = key;
            this.color = color;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public T getKey() {
            return key;
        }

       public String toString() {
            return "" + key + (this.color == RED ? "R" : "B");
        }
    }

    public RBTree(){
        root = null;
    }

    public RBNode<T> parentOf(RBNode<T> node) { //get parent of node
        return node != null? node.parent : null;
    }

    public void setParent(RBNode<T> node, RBNode<T> parent) { //set parent of node
        if(node != null)
            node.parent = parent;
    }

    public boolean colorOf(RBNode<T> node) { //get color of node
        return node != null? node.color : BLACK;
    }

    public boolean isRed(RBNode<T> node) { //return true if node is red
        return (node != null)&&(node.color == RED)? true : false;
    }

    public boolean isBlack(RBNode<T> node) {
        return !isRed(node);
    }

    public void setRed(RBNode<T> node) { //set color of node = red
        if(node != null)
            node.color = RED;
    }

    public void setBlack(RBNode<T> node) {//set color of node = red
        if(node != null) {
            node.color = BLACK;
        }
    }

    public void setColor(RBNode<T> node, boolean color) {
        if(node != null)
            node.color = color;
    }

    /*****************  pre-order iterate *********************/
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(RBNode<T> tree) {
        if(tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    /***************** infix order iterate *********************/
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(RBNode<T> tree) {
        if(tree != null) {
            preOrder(tree.left);
            System.out.print(tree.key + " ");
            preOrder(tree.right);
        }
    }

    /***************** post-order iterate *********************/
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(RBNode<T> tree) {
        if(tree != null) {
            preOrder(tree.left);
            preOrder(tree.right);
            System.out.print(tree.key + " ");
        }
    }

    /**************** search for Node with data key ***************/
    public RBNode<T> search(T key) {
        return search1(key);
//		return search2(root, key); //recursive version
    }

    private RBNode<T> search1(T key) {
        RBNode<T> current = this.root;
        while(current != null) {
            int cmp = key.compareTo(current.key);
            if(cmp < 0)//if key is smaller than current data, then search left subtree
                current = current.left;
            else if(cmp > 0)//if key is bigger than current data, then search right subtree
                current = current.right;
            else//if key is equal to current data, then find it
                return current;
        }
        //return null because cannot find the key
        return null;
    }
    //recursive version
    private RBNode<T> search2(RBNode<T> x, T key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            return search2(x.left, key);
        else if(cmp > 0)
            return search2(x.right, key);
        else
            return x;
    }

    /**************** Find Min  **********************/
    public T minValue() {
        RBNode<T> node = minNode(root);
        if(node != null)
            return node.key;
        return null;
    }

    private RBNode<T> minNode(RBNode<T> tree) {
        if(tree == null)
            return null;
        while(tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    /******************** Find Max *******************/
    public T maxValue() {
        RBNode<T> node = maxNode(root);
        if(node != null)
            return node.key;
        return null;
    }

    private RBNode<T> maxNode(RBNode<T> tree) {
        if(tree == null)
            return null;
        while(tree.right != null)
            tree = tree.right;
        return tree;
    }

    /********* get successor of current node, which is the smallest node bigger than current node ***********/
    public RBNode<T> successor(RBNode<T> x) {
        //if current node have rightChild, then successor is the smallest node in a tree with the root of x.right
        if(x.right != null)
            return minNode(x.right);
        //if x have no rightChild, there are two cases:
        //1. x is the leftChild of parent, then successor is parent
        //2. x is the rightChild of parent, then find parent, evaluate parent with these two cases again
        RBNode<T> p = x.parent;
        /*    8
         *   / \
         *  4   9   successor(9) = null
         *  p=8, x=9 -> p!=null, x=p.right -> x=8, p=null ->return null
         *         20
         *        /
         *      10
         *     /  \
         *    8    14
         *   / \
         *  4   9   successor(9) = 10
         *  p=8, x=9 -> p!=null, x=p.right -> x=8, p=10 -> x!=p.right -> return 10
         */
        while((p != null) && (x == p.right)) { //case 2
            x = p;
            p = x.parent;
        }
        return p; //case 1

    }

    /********* get predecessor of current node, which is the biggest node smaller than current node ************/
    public RBNode<T> predecessor(RBNode<T> x) {
        //if current node have leftChild, then predecessor is the biggest node in a tree with the root of x.left
        if(x.left != null)
            return maxNode(x.left);
        //if x have no leftChild, there are two cases:
        //1. x is the rightChild of parent, then predecessor is parent
        //2.  x is the leftChild of parent, then find parent, evaluate parent with these two cases again
        RBNode<T> p = x.parent;
        while((p != null) && (x == p.left)) { //case2
            x = p;
            p = x.parent;
        }
        return p; //case1
    }

    /************* Left Rotate Operation from Node x ******************
     * node x must have rightChild
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     *
     * Left Rotate Operation includes three steps:
     * ---------------------------------------------------------------
     * 1. deal with y's leftChild, move it to x's rightChild:
     *    update x's rightChild as y's leftChild
     *    update y.left.parent as x (only y.left is not null)
     *
     *     p                        p
     *    /                        /
     *   x                        x             y  <-y.parent=x, y.left=ly
     *  / \                      / \            \
     * lx  y      ----->       lx   ly           ry
     *    / \
     *   ly ry
     * ---------------------------------------------------------------
     * 2. deal with parent of x, move y to x's position
     *    update y's parent as x's parent
     *    update parent's left(or right, according to x)Child as y
     *
     *     p                                                             p
     *    /                                                             /
     *   x        y  <-y.parent=x, y.left=ly      x <-x.parent=p       y  <-y.left=ly
     *  / \        \                             / \                   \
     * lx  ly       ry         ----->           lx  ly                 ry
     * ---------------------------------------------------------------
     * 3. update y.left as x, update x.parent as y
     *                          p                         p
     *                         /                         /
     *    x <-x.parent=p      y  <-y.left=ly            y
     *   / \                   \          ----->      / \
     * lx  ly                  ry                   x   ry
     *                                            / \
     *                                           lx ly
     * ---------------------------------------------------------------
     * @param x
     *
     */
    private void leftRotate(RBNode<T> x) {
        // node x must have rightChild
        RBNode<T> y = x.right;

        //1. deal with y's leftChild, move it to x's rightChild:
        //    update x's rightChild as y's leftChild
        x.right = y.left;

        //   update y.left.parent as x (only y.left is not null)
        if(y.left != null)
            y.left.parent = x;

        //2. deal with parent of x, move y to x's position
        //   update y's parent as x's parent
        y.parent = x.parent;
        //   if x.parent = null, set root = y
        if(x.parent == null) {
            this.root = y;
        } else {
            //if x is leftChild of parent, assign y as parent's leftChild
            if(x == x.parent.left)
                x.parent.left = y;
            else//if x is rightChild of parent, assign y as parent's rightChild
                x.parent.right = y;
        }

        //3. update y.left as x, update x.parent as y
        y.left = x;
        x.parent = y;
    }

    /************* Right Rotate Operation from Node y ******************
     * node y must have leftChild
     *        p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
     *
     * Left Rotate Operation includes three steps:
     * ---------------------------------------------------------------
     * 1. deal with x's rightChild, move it to y's leftChild:
     *    update y's leftChild as x's rightChild,
     *    update x.right.parent as y (only x.right is not null)
     *
     *        p                   p
     *       /                   /
     *      y                   y              x <-x.parent=y, x.right=rx
     *     / \                 / \            /
     *    x  ry   ----->     ry   ry         lx
     *   / \
     * lx  rx
     * ---------------------------------------------------------------
     * 2. deal with parent of y, move x to y's position
     *    update x's parent as y's parent
     *    update parent's left(or right, according to y)Child as x
     *
     *           p                            p
     *          /                            /                 y <- y.parent = p
     *         y        x <-x.parent=y      x <-x.right=rx    / \
     *       / \       /    x.right=rx     /                ry   ry
     *    ry   ry     lx        ----->   lx
     *  ---------------------------------------------------------------
     * 3. update x.right as y, update y.parent as x
     *      p                                         p
     *     /                 y <- y.parent = p       /
     *    x <-x.right=rx    / \                     x
     *   /                ry   ry     ----->       / \
     *  lx                                       lx   y
     *                                               / \
     *                                             ry  ry
     * ---------------------------------------------------------------
     * @param y
     *
     */
    private void rightRotate(RBNode<T> y) {

        //node y must have leftChild
        RBNode<T> x = y.left;
        //1. deal with x's rightChild, move it to y's leftChild:
        // update y's leftChild as x's rightChild,
        y.left = x.right;

        //update x.right.parent as y (only x.right is not null)
        if(x.right != null)
            x.right.parent = y;

        //2. deal with parent of y, move x to y's position
        //   update x's parent as y's parent
        x.parent = y.parent;
        //   if y.parent = null, set root = x
        if(y.parent == null) {
            this.root = x;
        } else {
            //if y is rightChild of parent, update x as parent's rightChild
            if(y == y.parent.right)
                y.parent.right = x;
            else//if y is leftChild of parent, update x as parent's leftChild
                y.parent.left = x;
        }

        //3. update x.right as y, update y.parent as x
        x.right = y;
        y.parent = x;
    }

    /*********************** insertion **********************/
    /**
     * insert new node
     * @param key insert data
     */
    public void insert(T key) {
        RBNode<T> node = new RBNode<>(key, RED, null, null, null);
        if(node != null)
            insert(node);
    }


    /**
     * insert new node into the RBTree, same as BTree
     * @param node
     */
    private void insert(RBNode<T> node) {
        RBNode<T> current = this.root;
        //need to save the information of parentNode
        //because need the parentNode to connect the new node to the tree
        RBNode<T> parentNode = null;

        //1. find the insert position
        while(current != null) {
            parentNode = current;//store the parent of current, because current is going to move
            int cmp = node.key.compareTo(current.key);
            if(cmp < 0)//if insert data is smaller than current data, then go into left subtree
                current = current.left;
            else//if insert data is bigger than or equal to current data, then go into right subtree
                current = current.right;
        }

        //find the position, let parentNode as the parent of newNode
        node.parent = parentNode;

        //2.  connect newNode to parentNode
        if(parentNode != null) {
            int cmp = node.key.compareTo(parentNode.key);
            if(cmp < 0)
                parentNode.left = node;
            else
                parentNode.right = node;
        } else {
            //if parentNode is null, means tree was empty, let root = newNode
            this.root = node;
        }

        //3. fix the current tree to be a RBTree again
        insertFixUp(node);
    }

    private void insertFixUp(RBNode<T> node) {
        RBNode<T> parent, gparent;

        //if parent of node is red ---- condition that requiring fixing
        while(((parent = parentOf(node)) != null) && isRed(parent)) {
            gparent = parentOf(parent);//get grandparent node

            //case 1: if parent is leftChild of g-parent
            if(parent == gparent.left) {
                RBNode<T> uncle = gparent.right; //get uncle node

                //case 1.1: uncle is red
                //exchange the color of grandparent and parent&uncle
                if(uncle != null && isRed(uncle)) {
                    setBlack(parent); //set black to parent and uncle
                    setBlack(uncle);
                    setRed(gparent); //set red to g-parent
                    node = gparent; //move current node to grandparent
                    continue; //continue while，keep fixing if parent of grandparent is red
                }

                //case 1.2: uncle is black, current node is rightChild of parent
                if(node == parent.right) {
                    leftRotate(parent); //left rotate from parent node
                    //exchange the pointer of parent and currentNode
                    //prepare for entering in case 1.3 to rightRotate
                    RBNode<T> tmp = parent;
                    parent = node;
                    node = tmp;
                }

                //case 1.3: uncle is black, current node is leftChild of parent
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {//case 2: if parent is rightChild of g-parent
                RBNode<T> uncle = gparent.left; //get uncle node

                //case 2.1:  uncle is red
                //exchange the color of grandparent and parent&uncle
                if(uncle != null & isRed(uncle)) {
                    setBlack(parent);
                    setBlack(uncle);
                    setRed(gparent);
                    node = gparent;//move current node to grandparent
                    continue;//continue while，keep fixing if parent of grandparent is red
                }

                //case 2.2:  uncle is black, current node is leftChild of parent
                if(node == parent.left) {
                    rightRotate(parent);//right rotate from parent node
                    //exchange the pointer of parent and currentNode
                    //prepare for entering in case 2.3 to rightRotate
                    RBNode<T> tmp = parent;
                    parent = node;
                    node = tmp;
                }

                //case 2.3:  uncle is black, current node is rightChild of parent
                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        //set root node to black (rule 2)
        setBlack(this.root);
    }

    /*********************** deletion **********************/
    public void remove(T key) {
        RBNode<T> node;
        if((node = search(key)) != null)
            remove(node);
    }

    private void remove(RBNode<T> node) {
        RBNode<T> child, parent;
        boolean color;

        //1. delete node have both left and right childs
        if ((node.left != null) && (node.right != null)) {
            //find the successor of delete node, use for replace the position of delete node
            RBNode<T> replace = node;
            //  1). get successor
            replace = replace.right;
            while (replace.left != null)
                replace = replace.left;

            //  2). Handles the relationship between a successor node and the parent of a deleted node
            if (parentOf(node) != null) {
                if (node == parentOf(node).left)
                    parentOf(node).left = replace;
                else
                    parentOf(node).right = replace;
            } else {
                this.root = replace;
            }

            //  3).Handles the relationship between child nodes of a successor node and child nodes of a deleted node
            child = replace.right; //There must be no left child on the successor node!
            parent = parentOf(replace);
            color = colorOf(replace);//Saves the color of the successor nodes
            if (parent == node) { //The successor node is the child of the deleted node
                parent = replace;
            } else {
                if (child != null)
                    setParent(child, parent);
                parent.left = child;
                replace.right = node.right;
                setParent(node.right, replace);
            }
            replace.parent = node.parent;
            replace.color = node.color; //Keep the same color
            replace.left = node.left;
            node.left.parent = replace;

            if (color == BLACK) { //4. If the removed successor is black, trim the red-black tree
                removeFixUp(child, parent);//Pass in the child and parent of the descendant node
            }
            node = null;
            return;
        }
    }
    //Node represents the node to be modified, that is, the child node of the successor node
    // (because the successor node has been moved to the place where the node was deleted).
    private void removeFixUp(RBNode<T> node, RBNode<T> parent) {
        RBNode<T> other;

        while((node == null || isBlack(node)) && (node != this.root)) {
            if(parent.left == node) { //node is leftChild
                other = parent.right; //brother of node
                if(isRed(other)) { //case1: brother is red
                    setBlack(other);
                    setRed(parent);
                    leftRotate(parent);
                    other = parent.right;
                }

                //case2: brother is black, both children of brother is black
                if((other.left == null || isBlack(other.left)) &&
                        (other.right == null || isBlack(other.right))) {
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {
                    //case3: brother is black, left red right black
                    if(other.right == null || isBlack(other.right)) {
                        setBlack(other.left);
                        setRed(other);
                        rightRotate(other);
                        other = parent.right;
                    }

                    //case4: brother is black, right red left any color
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.right);
                    leftRotate(parent);
                    node = this.root;
                    break;
                }
            } else {
                other = parent.left;

                if (isRed(other)) {
                    //case1: brother is red
                    setBlack(other);
                    setRed(parent);
                    rightRotate(parent);
                    other = parent.left;
                }

                if ((other.left==null || isBlack(other.left)) &&
                        (other.right==null || isBlack(other.right))) {
                    //case2: brother is black, both children of brother is black
                    setRed(other);
                    node = parent;
                    parent = parentOf(node);
                } else {

                    if (other.left==null || isBlack(other.left)) {
                        //case3: brother is black, left red right black
                        setBlack(other.right);
                        setRed(other);
                        leftRotate(other);
                        other = parent.left;
                    }

                    //case4: brother is black, left red right any color
                    setColor(other, colorOf(parent));
                    setBlack(parent);
                    setBlack(other.left);
                    rightRotate(parent);
                    node = this.root;
                    break;
                }
            }
        }
        if (node!=null)
            setBlack(node);
    }

    /****************** destroy RBTree *********************/
    public void clear() {
        destroy(root);
        root = null;
    }

    private void destroy(RBNode<T> tree) {
        if(tree == null)
            return;
        if(tree.left != null)
            destroy(tree.left);
        if(tree.right != null)
            destroy(tree.right);
        tree = null;
    }

    /******************* print RBTree *********************/
    public void print() {
        if(root != null) {
            print(root, root.key, 0);
        }
    }
    /*
     * key---data of node
     * direction--- 0:current node is  root
     *              1:current node is parent.left
     *              2:current node is parent.right
     */
    private void print(RBNode<T> tree, T key, int direction) {
        if(tree != null) {
            if(0 == direction)
                System.out.printf("%2d(B) is root\n", tree.key);
            else
                System.out.printf("%2d(%s) is %2d's %6s child\n",
                        tree.key, isRed(tree)?"R":"b", key, direction == 1?"right":"left");
            print(tree.left, tree.key, -1);
            print(tree.right, tree.key, 1);
        }
    }
}
