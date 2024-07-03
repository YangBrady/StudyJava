package me.yangjun.study.algo.data.struct.tree;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinarySearchTreeDemo {

    public static void main(String[] args) {
        BinarySearchTreeNode binarySearchTreeNode = BinarySearchTreeNode.initBinarySearchTree();

//        BinarySearchTreeNode search = binarySearchTreeNode.search("7");
//        log.info("search = {}", search);
//
//        binarySearchTreeNode.insert("16");

        binarySearchTreeNode.delete("10");
        log.info("");
    }

}
