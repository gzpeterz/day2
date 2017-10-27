/**
 * 
 */
package com.hc.db;
import java.io.*;

/**
 * @author Administrator
 *
 */
public class SQLGen {
	int lineNum = 0;
	FieldGen fieldGen = null;
	
	public SQLGen(int lineNum) { this.lineNum = lineNum;
		fieldGen = new FieldGen();
	}

	public static void main(String[] args) {
		SQLGen gen = new SQLGen(1000000);
		// SQLGen gen = new SQLGen(1000);
		
		// gen.generateFile();
		gen.generateTXT();
	}
	
	public StringBuffer getOneSql(int start, int end) {
		StringBuffer str = new StringBuffer(" ");
		String sql;
		sql =  "insert into student(id, name, age, chinese, english, math) values ";
		str.append(sql);
		for(int i = start; i<= end; i++) {
			sql =  " ( " + i
				+ ", '" + fieldGen.getName() + "', "  
				+ fieldGen.getAge() + ", "  
				+ fieldGen.getScore() + "," 
				+ fieldGen.getScore() + "," 
				+ fieldGen.getScore() + ")" ;
			str.append(sql);
			if (i == end) {
				str.append(";\n");
			} else {
				str.append(",\n ");
			}
			// System.out.println(sql);
		}
		
		return str;
	}

	public void generateTXT() {
		// insert into student(id, name, age, chinese, english, math) values (6, "张三丰2243", 20, 89, 59, 92);
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("c:/tmp/student.txt");
			bw = new BufferedWriter(fw);
			String sql;
			for(int i = 1; i<= lineNum; i++) {
				sql =  " " + i + "\t" 
						+  fieldGen.getName() + "\t"  
						+  fieldGen.getAge() + "\t"  
						+  fieldGen.getScore() + "\t"  
						+  fieldGen.getScore() + "\t"  
						+  fieldGen.getScore()  + "\n";
				bw.write(sql);
			}
			System.out.println("write file ok");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//  生成 sql 文件
	public void generateFile() {
		// insert into student(id, name, age, chinese, english, math) values (6, "张三丰2243", 20, 89, 59, 92);
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("c:/tmp/student.sql");
			bw = new BufferedWriter(fw);
			bw.write("lock tables student write;\n");
			for(int i=1; i<= lineNum/10000+1; i++) {
				int start = (i-1) * 10000 + 1;
				int end = i*10000;
				if (start > lineNum) {
					break;
				}
				if (end > lineNum)  {
					end = lineNum;
				}
				StringBuffer sql = getOneSql(start, end);
				bw.write(sql.toString());
			}
			/*
			String sql;
			sql =  "insert into student(id, name, age, chinese, english, math) values ";
			bw.write(sql);
			for(int i = 1; i<= lineNum; i++) {
				// sql =  "insert into student(id, name, age, chinese, english, math) values ( " + i
				sql =  " ( " + i
					+ ", '" + fg.getName() + "', "  
					+ fg.getAge() + ", "  
					+ fg.getScore() + "," 
					+ fg.getScore() + "," 
					+ fg.getScore() + ")" ;
				bw.write(sql);
				if (i == lineNum) {
					bw.write(";\n");
				} else {
					bw.write(",\n ");
				}
				// System.out.println(sql);
			}
			*/
			bw.write("unlock tables;\n");
			System.out.println("write file ok");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
