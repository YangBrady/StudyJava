package me.yangjun.study.algo.data.struct.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树 Demo
 *
 * @author Brady
 * @date 2024/07/03
 */
@Slf4j
public class BinaryTreeDemo {
    public static void main(String[] args) {
//        BinaryTreeDemo.breadthFirstTraversal001(TreeNode.initDefaultTree());
        BinaryTreeDemo.breadthFirstTraversal002(TreeNode.initDefaultTree());
//        BinaryTreeDemo.depthFirstTraversal(TreeNode.initDefaultTree());
    }

    /**
     * BFS 第一种方式，最简单，但是没有记录深度
     */
    public static void breadthFirstTraversal001(TreeNode root) {
        // 定义一个队列，先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            log.info("node={}", node);
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
    }

    /**
     * BFS 第二种方式，最常用
     */
    public static void breadthFirstTraversal002(TreeNode root) {
        // 定义一个队列，先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 1;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                log.info("depth={}, node={}", depth, node);
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
            depth++;
        }
    }

    /**
     * DFS 深度优先遍历，基于递归
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
        if (root == null) {
            return;
        }
        // 前序遍历 log.info("node={}", root);
        if (root.getLeft() != null) {
            depthFirstTraversal(root.getLeft());
        }
        // 中序遍历 log.info("node={}", root);
        if (root.getRight() != null) {
            depthFirstTraversal(root.getRight());
        }
        // 后序遍历 log.info("node={}", root);
    }
}
