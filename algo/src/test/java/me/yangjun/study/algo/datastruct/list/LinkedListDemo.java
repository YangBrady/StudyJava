package me.yangjun.study.algo.datastruct.list;

public class LinkedListDemo {

    public static void main(String[] args) {
        BradyHeadNode<Integer> headNode = new BradyHeadNode<>(0);
        BradyHeadNode<Integer> node1 = new BradyHeadNode<>(1);
        headNode.setNext(node1);
        BradyHeadNode<Integer> node2 = new BradyHeadNode<>(2);
        node1.setNext(node2);
        BradyHeadNode<Integer> node3 = new BradyHeadNode<>(3);
        node2.setNext(node3);
        BradyHeadNode<Integer> node4 = new BradyHeadNode<>(4);
        node3.setNext(node4);

        BradyHeadNode<Integer> reversedNode = headNode.reverse();
    }
}
