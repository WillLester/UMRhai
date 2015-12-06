package edu.nju.umr.logic.checkLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.checkDSer.BusiCircumDSer;
import edu.nju.umr.dataService.dataFactory.StatementSheetDFacSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.checkLogicSer.BusiCircumLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.vo.BusiCircumVO;
import edu.nju.umr.vo.ResultMessage;

public class BusiCircumLogic implements BusiCircumLSer{
	private StatementSheetDFacSer dataFac;
	private BusiCircumDSer statementData;
	private UtilityLogic uti=new UtilityLogic();
	private ArrayList<BusiCircumVO> busiList=new ArrayList<BusiCircumVO>();
	
	public BusiCircumLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (StatementSheetDFacSer)Naming.lookup(Url.URL);
			statementData = dataFac.getStatement();
			uti=new UtilityLogic();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public ResultMessage getBusiCircum(Calendar start, Calendar end) {
		
		try {
			ArrayList<IncomePO> incomePOs=statementData.findIncome(start, end);
			ArrayList<PaymentPO> paymentPOs=statementData.findPayment(start, end);
			
			for(IncomePO po:incomePOs){
				BusiCircumVO bc=new BusiCircumVO(0,po.getDate(),po.getCost(),null);
				busiList.add(bc);
			}
			
			for(PaymentPO po:paymentPOs){
				BusiCircumVO bc=new BusiCircumVO(1,po.getDate(),po.getAmount(),po.getKind());
				busiList.add(bc);
			}
			
			for(int i=0;i<busiList.size();i++){
				for(int j=0;j<busiList.size()-1;j++){
					BusiCircumVO b1=busiList.get(j);
					BusiCircumVO b2=busiList.get(j+1);
					if(b1.getDate().compareTo(b2.getDate())>0){
						BusiCircumVO temp=b1;
						busiList.set(j, b2);
						busiList.set(j+1, temp);
					}
				}
			}
		} catch (RemoteException e) {
			return new ResultMessage(Result.NET_INTERRUPT,null);
		} 
		
		return new ResultMessage(Result.SUCCESS,busiList);
	}
	
	public Result outputExcel(String name, String location) {
		String data[][]=new String[1+busiList.size()][4];
		data[0][0]="单据种类";
		data[0][1]="日期";
		data[0][2]="金额";
		data[0][3]="缘由";
		
		for(int i=0;i<busiList.size();i++){
			data[i+1][0]=busiList.get(i).getAmount()+"";
			Calendar c=busiList.get(i).getDate();
			data[i+1][1]=(c.get(Calendar.YEAR)+"")+"."+((c.get(Calendar.MONTH)+1)+"")+"."+(c.get(Calendar.DATE)+"");
			data[i+1][2]=busiList.get(i).getAmount()+"";
			data[i+1][3]=String.valueOf(busiList.get(i).getRemark());
		}
		
		
		return uti.outputExcel(data, name, location);
	}
}
