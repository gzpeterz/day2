package com.hc.db;

import java.util.Random;

public class MyRandom2 extends Random {
	
	private static final long serialVersionUID = 3775885849862321458L;

	public MyRandom2() {
		super();
	}
	
	// ȡ��  start �� end  ֮���ֵ
	public int nextBetween(int start, int end) {
		int ret = start + nextInt(end - start + 1);
		return ret;
	}
}
