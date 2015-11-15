package edu.nju.umr.data.databaseUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.nju.umr.po.enums.Result;

public class SerialHelper {
	public static Result writeToFile(Object ob,String loc)
	{
		boolean isSuc=false;
		try
		{
			ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(loc));
			os.writeObject(ob);
			os.close();
			isSuc=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return Result.SERIAL_FAIL;
	}
	public static Object readFromFile(String loc)
	{
		Object ob=null;
		try
		{
			ObjectInputStream is=new ObjectInputStream(new FileInputStream(loc));
			ob=is.readObject();
			is.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return Result.FILE_NOT_FOUND;
	}
//	public static void main(String[] args)
//	{
//		AccountPO po=null;
//		po=new AccountPO("序列化测试","蛤蛤蛤",2333333);
//		writeToFile(po,"abcd.ser");
//		po=null;
//		po=(AccountPO)readFromFile("abcd.ser");
//		System.out.println(po.getId());
//		
//	}
}
