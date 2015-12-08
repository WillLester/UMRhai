package edu.nju.umr.logic.utilityLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.DiaryUpdateDFacSer;
import edu.nju.umr.dataService.utilityDSer.DiaryUpdateDSer;
import edu.nju.umr.po.DiaryPO;
import edu.nju.umr.po.enums.Result;

public class DiaryUpdateLogic implements DiaryUpdateLSer{
	private DiaryUpdateDSer dataSer;
	private DiaryUpdateDFacSer dataFac;
	public DiaryUpdateLogic() {
		// TODO 自动生成的构造函数存根
		try {
			dataFac = (DiaryUpdateDFacSer) Naming.lookup(Url.URL);
			dataSer = dataFac.getDiaryUpdate();
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public Result addDiary(String op, String name){
		DiaryPO diary = new DiaryPO(op, Calendar.getInstance(), name);
		try {
			return dataSer.addDiary(diary);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return Result.NET_INTERRUPT;
		}
	}
}
