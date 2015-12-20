package edu.nju.umr.logic.stub;
import java.util.ArrayList;

import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;
public class UtilityLogicStub {
	public ResultMessage getCities(){
		ArrayList<CityVO> ar=new ArrayList<CityVO>();
		ar.add(new CityVO("2","3","4"));
		return new ResultMessage(Result.SUCCESS,ar);
	}
	public ArrayList<CityPO> cities(){
		ArrayList<CityPO> ar=new ArrayList<CityPO>();
		ar.add(new CityPO("2","3","4", 1));
		return ar;
	}
}
