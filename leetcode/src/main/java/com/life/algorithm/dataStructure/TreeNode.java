package com.life.algorithm.dataStructure;

public class TreeNode {

    private int val;
    private TreeNode left;
    private TreeNode right;
    public TreeNode(){

    }
    public TreeNode(TreeNode left, TreeNode right, int val) {

        this.left = left;
        this.right = right;
        this.val = val;

    }

    public TreeNode(int val){
        this.val = val;
    }
}
