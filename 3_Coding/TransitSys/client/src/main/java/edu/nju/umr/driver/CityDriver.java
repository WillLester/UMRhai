package edu.nju.umr.driver;

import java.util.ArrayList;

import edu.nju.umr.logic.cityLogic.CityLogic;
import edu.nju.umr.logicService.cityLogicSer.CityLSer;
import edu.nju.umr.vo.CitiesVO;
import edu.nju.umr.vo.CityVO;

public class CityDriver {
	CityLSer city = new CityLogic();
	public static void main(String[] args) {
		CityDriver driver = new CityDriver();
		CitiesVO cvo = new CitiesVO("北京", "天津", 150, 20);
		CityVO vo = new CityVO("北京", "010");
		System.out.println(driver.city.addCity(vo));
		System.out.println(driver.city.reviseCity(vo));
		System.out.println(driver.city.reviseCities(cvo));
		ArrayList<CityVO> cities = (ArrayList<CityVO>) driver.city.cityList().getMessage();
		for(CityVO city:cities){
			System.out.println(city.getName() + " " + city.getId());
		}
	}
}
