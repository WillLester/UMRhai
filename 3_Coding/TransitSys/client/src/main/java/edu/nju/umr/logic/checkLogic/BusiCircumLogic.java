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
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.BusiCircumVO;

public class BusiCircumLogic implements BusiCircumLSer{
	StatementSheetDFacSer dataFac;
	BusiCircumDSer statementData;
	UtilityLogic uti=new UtilityLogic();
	ArrayList<BusiCircumVO> busiList=new ArrayList<BusiCircumVO>();
//	ArrayList<IncomePO> incomePOs=null;
//	ArrayList<PaymentPO> paymentPOs=null;
	
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
		} catch(NullPointerException e){
			return new ResultMessage(Result.DATA_NOT_FOUND,null);
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
			data[i+1][1]=(c.YEAR+"")+"."+(c.MONTH+"")+"."+(c.DATE+"");
			data[i+1][2]=busiList.get(i).getAmount()+"";
			data[i+1][3]=String.valueOf(busiList.get(i).getRemark());
		}
		
		
		return uti.outputExcel(data, name, location);
	}
//	//返回收款单list
//	public ResultMessage seeIncome(Calendar start, Calendar end) {
//		// TODO 自动生成的方法存根
//		ArrayList<IncomeVO> incomeList = new ArrayList<IncomeVO>();
//		try {
//			incomePOs = statementData.findIncome(start, end);
//			for(IncomePO po:incomePOs){
//				IncomeVO vo = new IncomeVO(po.getDate(), po.getCourier(), po.getCost(), po.getExpress());
//				incomeList.add(vo);
//			}
//		} catch (RemoteException e) {
//			return new ResultMessage(Result.NET_INTERRUPT,null);
//		} catch (NullPointerException e){
//			return new ResultMessage(Result.Data_Not_Found,null);
//		}
//		
//		return new ResultMessage(Result.SUCCESS, incomeList);
//	}
//	//返回付款单list
//	public ResultMessage seePayment(Calendar start, Calendar end){
//		ArrayList<PaymentVO> paymentList=new ArrayList<PaymentVO>();
//		try {
//			paymentPOs=statementData.findPayment(start, end);
//			for(PaymentPO po:paymentPOs){
//				PaymentVO vo=new PaymentVO(po.getDate(), po.getPayer(), po.getAccount(), po.getKind(), po.getAmount(), po.getRemarks());
//				paymentList.add(vo);
//			}
//		} catch (RemoteException e) {
//			return new ResultMessage(Result.NET_INTERRUPT,null);
//		} catch(NullPointerException e){
//			return new ResultMessage(Result.Data_Not_Found,null);
//		}
//		
//		return new ResultMessage(Result.SUCCESS,paymentList);
//		
//	}

//	public ResultMessage getHall() {
		// TODO 自动生成的方法存根
//		ArrayList<OrgVO> hallList = new ArrayList<OrgVO>();
//		try {
//			ArrayList<OrgPO> halls = statementData.getHall();
//			for(OrgPO hall:halls){
//				CityVO city = new CityVO(hall.getCity().getName(), hall.getCity().getId(),hall.getCity().getProvince());
//				OrgVO vo = new OrgVO(hall.getId(), hall.getName(), hall.getKind(), hall.getLocation(), city);
//				hallList.add(vo);
//			}
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		return new ResultMessage(Result.SUCCESS, hallList);
//		return uti.getHall();
//	}

	

	
	

}
