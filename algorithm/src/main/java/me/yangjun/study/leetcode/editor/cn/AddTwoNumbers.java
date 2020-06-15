//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

package me.yangjun.study.leetcode.editor.cn;

public class AddTwoNumbers{
    public static void main(String[] args) {
       Solution solution = new AddTwoNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Long sum = toLong(l1) + toLong(l2);
        return toListNode(sum);
    }

    public Long toLong(ListNode listNode) {
        StringBuilder result = new StringBuilder("" + listNode.val);

        ListNode nextNode = listNode;
        while (nextNode.next != null) {
            nextNode = nextNode.next;
            result.insert(0, nextNode.val);
        }
        return Long.parseLong(result.toString());
    }

    public ListNode toListNode(Long value) {
        char[] arr = String.valueOf(value).toCharArray();
        ListNode node = new ListNode(Integer.parseInt(String.valueOf(arr[arr.length - 1])));
        ListNode curNode = node;
        for (int i = arr.length - 2; i >= 0; i--) {
            int indexValue = Integer.parseInt(String.valueOf(arr[i]));
            ListNode thisNode = new ListNode(indexValue);
            curNode.next = thisNode;
            curNode = thisNode;
        }
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}