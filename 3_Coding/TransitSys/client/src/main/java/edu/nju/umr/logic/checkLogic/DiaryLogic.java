package edu.nju.umr.logic.checkLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.checkDSer.DiaryDSer;
import edu.nju.umr.dataService.dataFactory.DiaryDFacSer;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.checkLogicSer.DiaryLSer;
import edu.nju.umr.po.DiaryPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.DiaryVO;
import edu.nju.umr.vo.ResultMessage;

public class DiaryLogic implements DiaryLSer{
	DiaryDFacSer dataFac;
	DiaryDSer diaryData;
	public DiaryLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (DiaryDFacSer)Naming.lookup(Url.URL);
			diaryData = dataFac.getDiary();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public ResultMessage seeDiary(Calendar start, Calendar end) {
		// TODO 自动生成的方法存根
		ArrayList<DiaryVO> diaryList = new ArrayList<DiaryVO>();
		try {
			ArrayList<DiaryPO> diary = diaryData.seeDiary(start, end);
			for(DiaryPO po:diary){
				DiaryVO vo =VPFactory.toDiaryVO(po);
				diaryList.add(vo);
			}

		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		
		return new ResultMessage(Result.SUCCESS, diaryList);
	}

}
