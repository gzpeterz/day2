/**
 * 
 */
package com.hc.db;

import java.util.Random;

/**
 * @author Administrator
 *
 */
public class MyRandom1 {
	private Random rd = null;
	
	public MyRandom1() {
		// ���� Random ����
		rd = new Random();
	}
	
	// ȡ��  start �� end  ֮���ֵ
	public int nextBetween(int start, int end) {
		int ret = start + rd.nextInt(end - start + 1);
		return ret;
	}

}
