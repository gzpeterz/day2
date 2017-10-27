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
		// 生成 Random 对象
		rd = new Random();
	}
	
	// 取得  start 和 end  之间的值
	public int nextBetween(int start, int end) {
		int ret = start + rd.nextInt(end - start + 1);
		return ret;
	}

}
