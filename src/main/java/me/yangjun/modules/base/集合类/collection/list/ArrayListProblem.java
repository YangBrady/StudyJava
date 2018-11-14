package me.yangjun.modules.base.集合类.collection.list;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayListProblem {
	private List<String> list1 = new ArrayList<String>();

	private void addData() {
		this.list1.add("abcd1");
		this.list1.add("abcd2");
		this.list1.add("abcd3");
		this.list1.add("abcd4");
		this.list1.add("abcd5");
	}
	
	/**
	 * <p>使用Collection的迭代器遍历的时候修改原集合</p>
	 * <p>remove或者add方法会导致集合中其他元素的下标改变</p>
	 */
	@Test
	public void removeWhileErgodic() {
		this.addData();
		System.out.println(this.list1.size()); // 5
		System.out.println(this.list1);// [abcd1, abcd2, abcd3, abcd4, abcd5]

		for (int i = 0; i < this.list1.size(); i++) {
			if ((this.list1.get(i)).startsWith("abcd")) {
				this.list1.remove(i);
			}
		}

		System.out.println(this.list1.size());// 2
		System.out.println(this.list1);// [abcd2, abcd4]
	}
}
