package edu.nju.umr.data.databaseUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.nju.umr.po.enums.Result;

public class SerialHelper {
	public static Result writeToFile(Object ob,String loc)
	{
		try{
			ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(loc));
			os.writeObject(ob);
			os.close();
			return Result.SUCCESS;
		}catch(IOException e){
			return Result.SERIAL_FAIL;
		}
	}
	public static Object readFromFile(String loc)
	{
		Object ob=null;
		try
		{
			ObjectInputStream is=new ObjectInputStream(new FileInputStream(loc));
			ob=is.readObject();
			is.close();
		}catch(Exception e){
			return null;
		}
		return ob;
	}
}
