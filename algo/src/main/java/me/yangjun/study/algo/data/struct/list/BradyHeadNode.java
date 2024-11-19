package me.yangjun.study.algo.data.struct.list;

import lombok.Data;

@Data
public class BradyHeadNode<T> {
    private T value;
    private BradyHeadNode<T> next;

    public BradyHeadNode(T value) {
        this.value = value;
    }

    /**
     * 反转
     */
    public BradyHeadNode<T> reverse() {
        BradyHeadNode<T> indexNode = this.next;
        BradyHeadNode<T> restNode;
        this.next = null;

        BradyHeadNode<T> result = new BradyHeadNode<>(null);

        while (indexNode != null) {
            // 剩余部分
            restNode = indexNode.next;
            // 反转
            indexNode.next = result;
            // 指向新的链表头
            result = indexNode;
            indexNode = restNode;
        }
        return result.next;
    }
}
