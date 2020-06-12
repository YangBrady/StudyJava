////给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
////
//// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
////
//// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
////
//// 示例：
////
//// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
////输出：7 -> 0 -> 8
////原因：342 + 465 = 807
////
//// Related Topics 链表 数学
//
//package me.yangjun.modules.leetcode.editor.cn.test;
//
//import org.junit.Test;
//
//public class AddTwoNumbers {
//
//	@Test
//	public void demo() {
//		ListNode l1 = new ListNode(2);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(3);
//
//		ListNode l2 = new ListNode(5);
//		l2.next = new ListNode(6);
//		l2.next.next = new ListNode(4);
//
//		ListNode l3 = addTwoNumbers(l1, l2);
//		System.out.println(l3);
//	}
//
//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//		int sum = toInt(l1) + toInt(l2);
//		return toListNode(sum);
//	}
//
//	public int toInt(ListNode listNode) {
//		StringBuilder result = new StringBuilder("" + listNode.val);
//
//		ListNode nextNode = listNode;
//		while (nextNode.next != null) {
//			nextNode = nextNode.next;
//			result.insert(0, nextNode.val);
//		}
//		return Integer.parseInt(result.toString());
//	}
//
//	public ListNode toListNode(int value) {
//		String str = String.valueOf(value);
//		char[] arr = str.toCharArray();
//		ListNode node = new ListNode(Integer.parseInt(String.valueOf(arr[arr.length-1])));
//		ListNode curNode = node;
//		for (int i = arr.length - 2; i >= 0; i--) {
//			int indexValue = Integer.parseInt(String.valueOf(arr[i]));
//			ListNode thisNode = new ListNode(indexValue);
//			curNode.next = thisNode;
//			curNode = thisNode;
//		}
//		return node;
//	}
//
////	class ListNode {
////		int val;
////		ListNode next;
////
////		ListNode(int x) {
////			val = x;
////		}
////
////		@Override
////		public String toString() {
////			StringBuilder sb = new StringBuilder(val);
////			ListNode nextNode = this.next;
////			while (nextNode != null) {
////				sb.append(" -> ");
////				sb.append(nextNode.val);
////				nextNode = nextNode.next;
////			}
////			return sb.toString();
////		}
////	}
//}