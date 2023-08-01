package me.yangjun.study.集合类.collection.list;

import me.yangjun.study.集合类.collection.CollectionErgodicProblem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * <p>ArrayList</p>
 * <p>特征：操作速度慢，访问速度快，线程不安全</p>
 * @author yangjun
 * @since 2018-11-19 11:13:21
 * @version 0.1
 */

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
	 * <p>在所选下标左边插入，右边的对象全部右移一位</p>
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
	 * <p>遍历数据 -- Iterator</p>
	 * @see CollectionErgodicProblem
	 */
	@Test
	public void dealErgodic() {
		this.addData();
		Iterator<String> it = this.list1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	/**
	 * <p>遍历数据 -- ListIterator</p>
	 */
	@Test
	public void dealListErgodic() {
		this.addData();
		ListIterator<String> lit = ((ArrayList<String>) this.list1).listIterator();
		while (lit.hasNext()) {
			System.out.println("previousIndex = " + lit.previousIndex());// 获取游标前面一个位置
			System.out.println("hasPrevious = " + lit.hasPrevious());
			String currData = lit.next();
			System.out.println("currData = " + currData);
			if ("aa".equals(currData)) {
				lit.add("oo");// 在当前元素后面插入
			}
			if ("bb".equals(currData)) {
				lit.set("vv");// 修改当前元素
			}
			if ("cc".equals(currData)) {
				lit.remove();// 删除当前元素，需要注意的是，remove方法调用之前必须调用next方法
			}
			System.out.println("nextIndex = " + lit.nextIndex());// 获取游标后面一个位置
			System.out.println("------------------------------");
		}
		System.out.println(this.list1);
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
