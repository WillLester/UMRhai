package edu.nju.umr.ui.utility;

import java.util.regex.Pattern;

public class Utility {
	public static boolean isNumberic(String str){
		Pattern pattern = Pattern.compile("[0-9]*"); 
	    return pattern.matcher(str).matches(); 
	}
}
