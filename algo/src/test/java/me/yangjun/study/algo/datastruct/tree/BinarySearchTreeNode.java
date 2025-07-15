package me.yangjun.study.algo.datastruct.tree;

import lombok.Data;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 二叉搜索树
 * <p>
 * <li>1.对于根节点，左子树中所有节点的值 < 根节点的值 < 右子树中所有节点的值</li>
 * <li>2.任意节点的左、右子树也是二叉搜索树，即同样满足条件1</li>
 * </p>
 * 
 * @author Brady
 * @date 2024/07/03
 */
@Data
public class BinarySearchTreeNode {
    protected String val;
    protected BinarySearchTreeNode left;
    protected BinarySearchTreeNode right;

    public BinarySearchTreeNode(String val) {
        this.val = val;
    }

    public BinarySearchTreeNode search(String target) {
        BinarySearchTreeNode treeNode = this;
        while (treeNode != null) {
            if (NumberUtils.toInt(treeNode.getVal()) == NumberUtils.toInt(target)) {
                return treeNode;
            }
            if (NumberUtils.toInt(treeNode.getVal()) < NumberUtils.toInt(target)) {
                treeNode = treeNode.getRight();
                continue;
            }
            if (NumberUtils.toInt(treeNode.getVal()) > NumberUtils.toInt(target)) {
                treeNode = treeNode.getLeft();
            }
        }
        return null;
    }

    public void insert(String target) {
        BinarySearchTreeNode treeNode = this;
        BinarySearchTreeNode pre = null;
        while (treeNode != null) {
            if (NumberUtils.toInt(treeNode.getVal()) == NumberUtils.toInt(target)) {
                // 找到重复节点直接返回，违反了二叉搜索树定义
                return;
            }
            pre = treeNode;
            if (NumberUtils.toInt(treeNode.getVal()) < NumberUtils.toInt(target)) {
                treeNode = treeNode.getRight();
                continue;
            }
            if (NumberUtils.toInt(treeNode.getVal()) > NumberUtils.toInt(target)) {
                treeNode = treeNode.getLeft();
            }
        }

        // 插入
        if (NumberUtils.toInt(pre.getVal()) < NumberUtils.toInt(target)) {
            pre.setRight(new BinarySearchTreeNode(target));
        } else {
            pre.setLeft(new BinarySearchTreeNode(target));
        }
    }

    /**
     * TODO 删除
     *
     * @param target 目标
     */
    public void delete(String target) {
        BinarySearchTreeNode targetNode = this;
        BinarySearchTreeNode pre = null;
        while (targetNode != null) {
            if (NumberUtils.toInt(targetNode.getVal()) == NumberUtils.toInt(target)) {
                break;
            }
            pre = targetNode;
            if (NumberUtils.toInt(targetNode.getVal()) < NumberUtils.toInt(target)) {
                targetNode = targetNode.getRight();
                continue;
            }
            if (NumberUtils.toInt(targetNode.getVal()) > NumberUtils.toInt(target)) {
                targetNode = targetNode.getLeft();
            }
        }

        // 没有这个节点直接返回
        if (targetNode == null) {
            return;
        }

        int degree = this.degree();
        if (degree == 0) {
            // 节点存在0个度，直接删除
            if (targetNode.equals(pre.getLeft())) {
                pre.setLeft(null);
            } else {
                pre.setRight(null);
            }
        } else if (degree == 1) {
            // 节点存在1个度，将要删除的节点的子节点挂在前置节点上
            BinarySearchTreeNode targetDegreeNode =
                (targetNode.getLeft() != null ? targetNode.getLeft() : targetNode.getRight());
            if (targetNode.equals(pre.getLeft())) {
                pre.setLeft(targetDegreeNode);
            } else {
                pre.setRight(targetDegreeNode);
            }
        } else {
            // 节点存在2个度，要删除的节点的左侧最大值或者右侧最小值挂在当前要删除的节点的位置上
            BinarySearchTreeNode minNode = targetNode.searchMin();
            if (targetNode.equals(pre.getLeft())) {
                pre.setLeft(minNode);
            } else {
                pre.setRight(minNode);
            }
        }
    }

    public BinarySearchTreeNode searchMin() {
        BinarySearchTreeNode treeNode = this;
        if (treeNode.degree() == 0) {
            return treeNode;
        }
        if (treeNode.getLeft() != null) {
            treeNode = treeNode.getLeft();
            return treeNode.searchMin();
        }
        if (treeNode.getRight() != null) {
            treeNode = treeNode.getRight();
            return treeNode.searchMin();
        }
        return null;
    }

    public int degree() {
        int degree = 0;
        if (this.getLeft() != null) {
            degree++;
        }
        if (this.getRight() != null) {
            degree++;
        }
        return degree;
    }

    public static BinarySearchTreeNode initBinarySearchTree() {
        BinarySearchTreeNode tn1 = new BinarySearchTreeNode("1");
        BinarySearchTreeNode tn2 = new BinarySearchTreeNode("2");
        BinarySearchTreeNode tn3 = new BinarySearchTreeNode("3");
        BinarySearchTreeNode tn4 = new BinarySearchTreeNode("4");
        BinarySearchTreeNode tn5 = new BinarySearchTreeNode("5");
        BinarySearchTreeNode tn6 = new BinarySearchTreeNode("6");
        BinarySearchTreeNode tn7 = new BinarySearchTreeNode("7");
        BinarySearchTreeNode tn8 = new BinarySearchTreeNode("8");
        BinarySearchTreeNode tn9 = new BinarySearchTreeNode("9");
        BinarySearchTreeNode tn10 = new BinarySearchTreeNode("10");
        BinarySearchTreeNode tn11 = new BinarySearchTreeNode("11");
        BinarySearchTreeNode tn12 = new BinarySearchTreeNode("12");
        BinarySearchTreeNode tn13 = new BinarySearchTreeNode("13");
        BinarySearchTreeNode tn14 = new BinarySearchTreeNode("14");
        BinarySearchTreeNode tn15 = new BinarySearchTreeNode("15");

        tn2.left = tn1;
        tn2.right = tn3;

        tn6.left = tn5;
        tn6.right = tn7;

        tn10.left = tn9;
        tn10.right = tn11;

        tn14.left = tn13;
        tn14.right = tn15;

        tn4.left = tn2;
        tn4.right = tn6;

        tn12.left = tn10;
        tn12.right = tn14;

        tn8.left = tn4;
        tn8.right = tn12;
        return tn8;
    }

    @Override
    public String toString() {
        return "BinarySearchTreeNode{" + "val='" + val + '\'' + '}';
    }
}
