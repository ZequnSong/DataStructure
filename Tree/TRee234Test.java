package com.tree;

public class TRee234Test {
    private static final int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
    private static final boolean mDebugInsert = true;    // switch of insert(false，close；true，open)

    public static void main(String[] args) {
        Tree234 tree = new Tree234();
        for(int i=0; i<a.length; i++) {
            tree.insert(a[i]);
            // set mDebugInsert=true, test insert function
            if (mDebugInsert) {
                System.out.printf("== insert node: %d\n", a[i]);
                System.out.printf("== details about tree: \n");
                tree.displayTree();
                System.out.printf("\n");
            }
        }
        System.out.println("location of value=30 : " + tree.find(30));





    }
}
