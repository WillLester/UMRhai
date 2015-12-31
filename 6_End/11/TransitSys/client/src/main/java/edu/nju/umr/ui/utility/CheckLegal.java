package edu.nju.umr.ui.utility;



public class CheckLegal {
	public static String isExpressLegal(String express){
		if(express.equals("")){
			return Hints.EXPRESS_NULL;
		}
		if(!Utility.isNumberic(express)){
			return Hints.EXPRESS_ILLEGAL;
		} else if(express.length() != 10){
			return Hints.EXPRESS_LENGTH;
		} else {
			return null;
		}
	}
	public static String isTransitLegal(String transit){
		if(transit.equals("")){
			return Hints.TRANSIT_NULL;
		}
		if(!Utility.isNumberic(transit)){
			return Hints.TRANSIT_ILLEGAL;
		} else if((transit.length() != 19)&&(transit.length() != 20)){
			return Hints.TRANSIT_LENGTH;
		} else {
			return null;
		}
	}
}
