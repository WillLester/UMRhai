package edu.nju.umr.logic.driver;
import edu.nju.umr.logic.cityLogic.CityLogic;
import edu.nju.umr.vo.CityVO;
public class CityLogicDriver {
	public void drive(){
		CityLogic l = new CityLogic();
		l.cityList();
		l.citiesList();
		l.addCity(new CityVO("2", "3", "4"), "1");
		l.addCity(new CityVO("5", "6", "7"), "1");
		l.reviseCity(new CityVO("8","9","10"), 0, "1");
	}
	public static void main(String[] args){
		CityLogicDriver d=new CityLogicDriver();
		d.drive();
	}

}
