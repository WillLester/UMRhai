package edu.nju.umr.logic.workOrgManLogic;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.logicService.workOrgManLogicSer.VanManLSer;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.VanVO;

public class VanManLogic implements VanManLSer{

	public boolean addVan(VanVO Van) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteVan(String id) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseVan(VanVO Van) {
		// TODO 自动生成的方法存根
		return true;
	}

	public ResultMessage checkVan(String id) {
		// TODO 自动生成的方法存根
		VanVO van=new VanVO("1","11111",new Date(),null,"1");
		ResultMessage message = new ResultMessage(true, van);
		return message;
	}

	public ResultMessage VanList() {
		// TODO 自动生成的方法存根
		VanVO van1=new VanVO("1","11111",new Date(),null,"1");
		VanVO van2=new VanVO("2","22222",new Date(),null,"2");
		ArrayList<VanVO> ar=new ArrayList<VanVO>();
		ar.add(van1);
		ar.add(van2);
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

	public ResultMessage searchVan(String keyword) {
		// TODO 自动生成的方法存根
		VanVO van=new VanVO("1","11111",new Date(),null,"1");
		ResultMessage message = new ResultMessage(true, van);
		return message;
	}

}
