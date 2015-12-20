package edu.nju.umr.logic.stub;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.utilityDSer.ConstantGetDSer;
import edu.nju.umr.po.ConstantPO;
public class ConstantGetLogicStub implements ConstantGetDSer{
@Override
public ConstantPO getConstant() throws RemoteException {
	// TODO Auto-generated method stub
	System.out.println("now you get it!");
	return new ConstantPO(null, null, null, null, null, null, null, null, null);
}
}
