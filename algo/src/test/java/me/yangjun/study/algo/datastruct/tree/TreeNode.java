package me.yangjun.study.algo.datastruct.tree;

import lombok.Data;

@Data
public class TreeNode {
    protected String val;
    protected TreeNode left;
    protected TreeNode right;

    public TreeNode(String val) {
        this.val = val;
    }

    public static TreeNode initDefaultTree() {
        TreeNode tn1 = new TreeNode("1");
        TreeNode tn2 = new TreeNode("2");
        TreeNode tn3 = new TreeNode("3");
        TreeNode tn4 = new TreeNode("4");
        TreeNode tn5 = new TreeNode("5");

        tn1.left = tn2;
        tn1.right = tn3;

        tn2.left = tn4;
        tn2.right = tn5;

        return tn1;
    }

    @Override
    public String toString() {
        return "TreeNode{" + "val='" + val + '\'' + '}';
    }
}
