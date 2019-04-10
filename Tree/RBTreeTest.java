package com.tree;


public class RBTreeTest {

    private static final int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
    private static final boolean mDebugInsert = true;    // switch of insert(false，close；true，open)
    private static final boolean mDebugDelete = true;    // switch of delete(false，close；true，open)

    public static void main(String[] args) {
        int i, ilen = a.length;
        RBTree<Integer> tree = new RBTree<Integer>();

        System.out.printf("== original data: ");
        for(i=0; i<ilen; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        for(i=0; i<ilen; i++) {
            tree.insert(a[i]);
            // set mDebugInsert=true, test insert function
            if (mDebugInsert) {
                System.out.printf("== insert node: %d\n", a[i]);
                System.out.printf("== details about tree: \n");
                tree.print();
                System.out.printf("\n");
            }
        }

        System.out.printf("== preOrder: ");
        tree.preOrder();

        System.out.printf("\n== inOrder: ");
        tree.inOrder();

        System.out.printf("\n== postOrder: ");
        tree.postOrder();
        System.out.printf("\n");

        System.out.printf("== Minimum Value: %s\n", tree.minValue());
        System.out.printf("== Maximum Value: %s\n", tree.maxValue());
        System.out.printf("== details about tree: \n");
        tree.print();
        System.out.printf("\n");

        // set mDebugDelete=true, test delete function
        if (mDebugDelete) {
            for(i=0; i<ilen; i++)
            {
                tree.remove(a[i]);

                System.out.printf("== delete node: %d\n", a[i]);
                System.out.printf("== details about tree: \n");
                tree.print();
                System.out.printf("\n");
            }
        }


    }

}