package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Preprocess {
	
	public static void appendMethodA(String fileName,  
			  
			String content){  
			try {  
			// 打开一个随机访问文件流，按读写方式  
			RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");  
			// 文件长度，字节数  
			long fileLength = randomFile.length();  
			//将写文件指针移到文件尾。  
			randomFile.seek(fileLength);  
			randomFile.writeBytes(content);  
			randomFile.close();  
			} catch (IOException e){  
			e.printStackTrace();  
			}  
	}
	
	public static void readFileByLines(String fileName){  
		File file = new File(fileName);  
		BufferedReader reader = null; 
		try {  
		System.out.println("以行为单位读取文件内容，一次读一整行：");  
		reader = new BufferedReader(new FileReader(file));  
		String tempString = null;  
		int line = 1;  
		//一次读入一行，直到读入null为文件结束  
		while ((tempString = reader.readLine()) != null){  
		//显示行号  
		//System.out.println("line " + line + ": " + tempString);  
		//line++;  
		//写入到文件中
		String filename = "out.txt";
		String[] strarr = tempString.split("::");
		String deststr = strarr[0]+","+strarr[1]+","+strarr[2]+"\n";
		
		appendMethodA(filename,deststr);
		}  
		reader.close();  
		} catch (IOException e) {  
		e.printStackTrace();  
		} finally {  
		if (reader != null){  
		try {  
		reader.close();  
		} catch (IOException e1) {  
		}  
		}  
		}  
		}
	
	public static void main(String[] args) throws Exception{
		//FileReader fr = new FileReader("ratings.dat");
		readFileByLines("ratings.dat");
	}
	
}
