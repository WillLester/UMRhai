package edu.nju.umr.ui.utility;

import java.util.Calendar;
import java.util.regex.Pattern;

public class Utility {
	public static boolean isOutOfDate(Calendar date){
		Calendar now = Calendar.getInstance();
		if(date.get(Calendar.YEAR) > now.get(Calendar.YEAR)){
			return false;
		} else if(date.get(Calendar.MONTH) > now.get(Calendar.MONTH)){
			return false;
		} else if(date.get(Calendar.DATE) > now.get(Calendar.DATE)){
			return false;
		}
		return true;
	}
	public static boolean isNumberic(String str){
		Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches(); 
	}
}
