package me.yangjun.modules.base.集合类.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class ArrayListDemo {
	private List<String> list1 = new ArrayList<String>();

	private void addData() {
		this.list1.add("aa");
		this.list1.add("bb");
		this.list1.add("cc");
		this.list1.add("ee");
		this.list1.add("ff");
		this.list1.add("gg");
	}

	/**
	 * <p>测试add(int index, E element)方法</p>
	 * <p>在所选下边左边插入，右边的对象全部右移一位</p>
	 */
	@Test
	public void testFuncAdd() {
		this.addData();
		System.out.println(this.list1);
		this.list1.add(0, "oo");
		System.out.println(this.list1);// [oo, aa, bb, cc, ee, ff, gg]
		this.list1.add(4, "dd");
		System.out.println(this.list1);// [oo, aa, bb, cc, dd, ee, ff, gg]
	}
	
	/**
	 * <p>测试Index(E element)方法</p>
	 * <p>存在的话返回下标，不存在返回-1</p>
	 */
	@Test
	public void testFuncIndex() {
		this.addData();
		System.out.println(this.list1.indexOf("cc"));// 2
		System.out.println(this.list1.indexOf("oo"));// -1
	}
	
	/**
	 * <p>遍历数据 -- Collection的迭代器</p>
	 * @see ArrayListProblem
	 */
	@Test
	public void dealErgodic() {
		this.addData();
		Iterator<String> it = this.list1.iterator();
		while(it.hasNext()) {
			// 过程中不能修改List
			System.out.println(it.next());
		}
	}
	
	/**
	 * <p>遍历数据 -- List专有迭代器</p>
	 */
	@Test
	public void dealListErgodic() {
		//TODO ListIterator 
	}
	
	/**
	 * <p>线程不安全，不同步</p>
	 */
	@Test
	public void testSynch() {
		//TODO synchronization test 
	}
	
	/**
	 * <p>交换两个下标对应的对象</p>
	 */
	@Test
	public void skilSwap() {
		this.addData();
		this.list1.set(1, this.list1.set(3, this.list1.get(1)));
		System.out.println(this.list1);// [aa, ee, cc, bb, ff, gg]
	}
}
