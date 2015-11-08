package helper;

import java.io.*;

import edu.nju.umr.po.AccountPO;

public class SerializeHelper {
	public static boolean writeToFile(Object ob,String loc)
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
		return isSuc;
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
		return ob;
	}
	public static void main(String[] args)
	{
		AccountPO po=null;
		po=new AccountPO("序列化测试","蛤蛤蛤",2333333);
		writeToFile(po,"abcd.ser");
		po=null;
		po=(AccountPO)readFromFile("abcd.ser");
		System.out.println(po.getId());
		
	}

}
