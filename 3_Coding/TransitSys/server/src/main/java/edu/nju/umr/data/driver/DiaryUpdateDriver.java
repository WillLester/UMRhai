package edu.nju.umr.data.driver;

import java.rmi.RemoteException;
import java.util.Calendar;

import edu.nju.umr.data.utilityData.DiaryUpdateData;
import edu.nju.umr.dataService.utilityDSer.DiaryUpdateDSer;
import edu.nju.umr.po.DiaryPO;
import edu.nju.umr.po.enums.Result;

public class DiaryUpdateDriver {
	private DiaryUpdateDSer serv;
	public DiaryUpdateDriver() {
		try {
			serv = DiaryUpdateData.getDiaryUpdate();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		DiaryPO diary = new DiaryPO("搞个大新闻", Calendar.getInstance(), "香港记者");
		try {
			Result re = serv.addDiary(diary);
			System.out.println(re);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
