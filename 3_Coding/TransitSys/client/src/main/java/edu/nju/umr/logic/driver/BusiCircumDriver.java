package edu.nju.umr.logic.driver;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.checkLogic.BusiCircumLogic;
import edu.nju.umr.logicService.checkLogicSer.BusiCircumLSer;
import edu.nju.umr.vo.BusiCircumVO;
import edu.nju.umr.vo.ResultMessage;

public class BusiCircumDriver {
	private BusiCircumLSer serv;
	public BusiCircumDriver() {
		// TODO 自动生成的构造函数存根
		serv = new BusiCircumLogic();
	}
	public void drive(){
		Calendar start = Calendar.getInstance();
		String s = "2015-12-15 00:00:00";
		try {
			start.setTime(DateFormat.TIME.parse(s));
		} catch (ParseException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		String e = "2015-12-18 00:00:00";
		Calendar end = Calendar.getInstance();
		try {
			end.setTime(DateFormat.TIME.parse(e));
		} catch (ParseException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		ResultMessage message = serv.getBusiCircum(start, end);
		@SuppressWarnings("unchecked")
		List<BusiCircumVO> list = (List<BusiCircumVO>) message.getMessage();
		for(BusiCircumVO vo:list){
			System.out.println(vo.getKind());
			System.out.println(vo.getAmount());
		}
	}
}
