package com.recursion;

/**
 * Hanoi Tower
 * The goal is to move all the disks from tower A to tower C
 * each move can only move one disk at A time
 * and no disk can be placed on another smaller disk
 * recursion version
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class Hanoi {
    static int nDisks = 3;

    /**
     * suppose there are n disks
     * consider these disks as two disks:
     * one disk is 1--（n-1) disk
     * another disk is n-th disk
     * @param diskNum
     * @param from A initial position
     * @param inter B internal position
     * @param to C goal position
     */
    public static void doHanoi(int diskNum, char from, char inter, char to) {
        //if only have one disk, from A move to C directly
        if (diskNum == 1)
            System.out.println("Disk 1 from " + from + " to " + to);
        else {
            //if only have N disk, move (N-1) disk from A to B through C(A->C->B)
            doHanoi(diskNum - 1, from, to, inter);
            //then move n-th disk from A to C directly
            System.out.println("Disk " + diskNum + " from " + from + " to " + to);
            //then move (n-1) disk from B to C through A(B->A->C)
            doHanoi(diskNum - 1, inter, from, to);
        }
    }

    public static void main(String[] args){
        doHanoi(nDisks,'A','B','C');
    }



}
