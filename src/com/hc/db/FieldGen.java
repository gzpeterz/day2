
package com.hc.db;
import java.util.*;

public class FieldGen {
	List<String> list = null;
	MyRandom2 my = null;
	
	public FieldGen() {
		my = new MyRandom2();
		list = new ArrayList<String>();
		list.add("����");
		list.add("����˹");
		list.add("������");
		list.add("����2");
		list.add("����3");
		list.add("����4");
		list.add("����5");
		list.add("����7");
		list.add("����8");
		list.add("����9");
		
		
		
	}
	
	public String getName() {
		String ret = null;
		//  list �� �±�
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
