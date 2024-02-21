package com.life.algorithm;

import com.life.algorithm.dataStructure.TreeNode;

import java.util.HashMap;

/**
 * @author T596
 * @date 2024/2/21
 */
public class LeetCode106 {

    // 用于存储中序遍历结果中值与索引的对应关系
    private final HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 填充中序遍历结果的值与索引的对应关系
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(postorder, 0, postorder.length - 1, 0);
    }

    private TreeNode buildTreeHelper(int[] postorder, int postStart, int postEnd, int inStart) {
        // 递归结束条件
        if (postStart > postEnd) {
            return null;
        }

        // 后序遍历结果中最后一个元素即为根节点
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // 在中序遍历结果中查找根节点的索引
        int rootIndex = inorderMap.get(rootVal);

        // 根据中序遍历结果划分出左子树和右子树的范围
        int leftSize = rootIndex - inStart; // 左子树节点数量

        // 递归构建左子树和右子树
        root.left = buildTreeHelper(postorder, postStart, postStart + leftSize - 1, inStart);
        root.right = buildTreeHelper(postorder, postStart + leftSize, postEnd - 1, rootIndex + 1);

        return root;
    }
}
