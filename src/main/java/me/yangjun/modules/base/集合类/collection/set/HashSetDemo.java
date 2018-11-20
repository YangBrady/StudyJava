package me.yangjun.modules.base.集合类.collection.set;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;

/**
 * <p>HashSet</p>
 * <p>特征：查询速度快</p>
 * @author yangjun
 * @since 2018-11-19 11:26:17
 * @version 0.1
 */
public class HashSetDemo {
	private HashSet<String> set1 = new HashSet<String>();

	private void addData() {
		this.set1.add("aa");
		this.set1.add("bb");
		this.set1.add("cc");
		this.set1.add("cc");
		this.set1.add("dd");
	}
	
	/**
	 * <p>HashSet输入顺序和输出顺序不一定一样？</p>
	 */
	@Test
	public void testSort() {
		this.addData();
		System.out.println("set1:" + set1 );
		Iterator<String> it = this.set1.iterator();
		while(it.hasNext()) {
			System.out.println("iterator: " + it.next());
		}
		for(String str : this.set1) {
			System.out.println("for: " + str);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
