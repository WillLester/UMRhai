package edu.nju.umr.constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Url {
	public static String URL = null;
	private Url(){
		
	}
	/**
	 * 初始化url，Url类是被封装的
	 * @param loc url的txt文件地址
	 * @return boolean 初始化是否成功
	 */
	public static boolean initialize(String loc){
		File file = new File(loc);
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			URL = "rmi://"+reader.readLine()+"/DataFactory";
			reader.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			return false;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}
}
