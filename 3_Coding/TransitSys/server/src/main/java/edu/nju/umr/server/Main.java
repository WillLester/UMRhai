package edu.nju.umr.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import edu.nju.umr.data.dataFactory.DataFactory;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try{
			DataFactory dataFactory = new DataFactory();
			LocateRegistry.createRegistry(8885);
			Naming.bind("rmi://localhost:8885/DataFactory", dataFactory);
		} catch (RemoteException e) { 
            System.out.println("创建远程对象发生异常！"); 
            e.printStackTrace(); 
        } catch (AlreadyBoundException e) { 
            System.out.println("发生重复绑定对象异常！"); 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            System.out.println("发生URL畸形异常！"); 
            e.printStackTrace(); 
        }
	}

}
