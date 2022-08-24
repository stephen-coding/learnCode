package com.life.algorithm.dataStructure;

public class BinaryTree {

    private int val;
    private BinaryTree left;
    private BinaryTree right;
    public BinaryTree(){

    }
    public BinaryTree(BinaryTree left, BinaryTree right, int val) {

        this.left = left;
        this.right = right;
        this.val = val;

    }

    public BinaryTree(int val){
        this.val = val;
    }
}
