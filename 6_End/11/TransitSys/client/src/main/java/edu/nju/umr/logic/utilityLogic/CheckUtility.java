package edu.nju.umr.logic.utilityLogic;

import edu.nju.umr.po.enums.Result;

public class CheckUtility {
	public static boolean isSuc(Result result){
		if(result == Result.SUCCESS){
			return true;
		} else {
			return false;
		}
	}
}
