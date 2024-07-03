package me.yangjun.study.algo.data.struct.tree;

import java.util.LinkedList;
import java.util.Queue;

import lombok.extern.slf4j.Slf4j;

/**
 * 二叉树 Demo
 *
 * @author Brady
 * @date 2024/07/03
 */
@Slf4j
public class BinaryTreeDemo {
    public static void main(String[] args) {
        // BinaryTreeDemo.breadthFirstTraversal(TreeNode.initDefaultTree());
        BinaryTreeDemo.depthFirstTraversal(TreeNode.initDefaultTree());
    }

    /**
     * BFT 广度优先遍历，基于队列
     *
     * @param root 根节点
     */
    public static void breadthFirstTraversal(TreeNode root) {
        // 定义一个队列，先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
            log.info("node={}", node);
        }
    }

    /**
     * DFT 深度优先遍历，基于递归
     * 
     * <pre>
     *     前序遍历：根->左->右
     *     中序遍历：左->根->右
     *     后序遍历：左->右->根
     * </pre>
     *
     * @param root 根节点
     */
    public static void depthFirstTraversal(TreeNode root) {
        // 先遍历当前节点
        log.info("node={}", root);
        // 判断是否有左节点
        if (root.getLeft() != null) {
            depthFirstTraversal(root.getLeft());
        }
        // 判断是否有有节点
        if (root.getRight() != null) {
            depthFirstTraversal(root.getRight());
        }
    }
}
