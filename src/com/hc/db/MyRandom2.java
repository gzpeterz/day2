package com.hc.db;

import java.util.Random;

public class MyRandom2 extends Random {
	
	private static final long serialVersionUID = 3775885849862321458L;

	public MyRandom2() {
		super();
	}
	
	// 取得  start 和 end  之间的值
	public int nextBetween(int start, int end) {
		int ret = start + nextInt(end - start + 1);
		return ret;
	}
}
