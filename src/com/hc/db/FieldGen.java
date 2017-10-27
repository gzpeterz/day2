
package com.hc.db;
import java.util.*;

public class FieldGen {
	List<String> list = null;
	MyRandom2 my = null;
	
	public FieldGen() {
		my = new MyRandom2();
		list = new ArrayList<String>();
		list.add("张氏");
		list.add("刘易斯");
		list.add("无名氏");
		list.add("张氏2");
		list.add("张氏3");
		list.add("张氏4");
		list.add("张氏5");
		list.add("张氏7");
		list.add("张氏8");
		list.add("张氏9");
		
		
		
	}
	
	public String getName() {
		String ret = null;
		//  list 的 下标
		int index = my.nextBetween(0, 9);
		int back  = my.nextBetween(1000, 9999);
		ret = list.get(index) + "_" +  back;
		return ret;
	}
	
	public int getAge() {
		return my.nextBetween(18, 25);
	}

	public int getScore() {
		return my.nextBetween(50, 100);
	}
}
