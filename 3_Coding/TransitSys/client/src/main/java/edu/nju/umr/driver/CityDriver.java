package edu.nju.umr.driver;

import java.util.ArrayList;

import edu.nju.umr.logic.cityLogic.CityLogic;
import edu.nju.umr.logicService.cityLogicSer.CityLSer;
import edu.nju.umr.logicService.cityLogicSer.ConstantLSer;
import edu.nju.umr.logic.cityLogic.ConstantLogic;
import edu.nju.umr.vo.ConstantVO;
import edu.nju.umr.vo.CitiesVO;
import edu.nju.umr.vo.CityVO;

public class CityDriver {
	CityLSer city = new CityLogic();
	ConstantLSer constant=new ConstantLogic();
	public static void main(String[] args) {
		CityDriver driver = new CityDriver();
		CitiesVO cvo = new CitiesVO("北京", "天津", 150, 20);
		CityVO vo = new CityVO("北京", "010","北京");
		System.out.println(driver.city.addCity(vo));
		System.out.println(driver.city.reviseCity(vo));
		System.out.println(driver.city.reviseCities(cvo));
		@SuppressWarnings("unchecked")
		ArrayList<CityVO> cities = (ArrayList<CityVO>) driver.city.cityList().getMessage();
		for(CityVO city:cities){
			System.out.println(city.getName() + " " + city.getId());
		}
		System.out.println(driver.constant.setConstant(new ConstantVO(9,8,7,6,5,4,3,2,1)));
		ConstantVO voo=(ConstantVO)driver.constant.getConstant().getMessage();
		System.out.println(voo.getMaxLoadPlane());
	}
}
