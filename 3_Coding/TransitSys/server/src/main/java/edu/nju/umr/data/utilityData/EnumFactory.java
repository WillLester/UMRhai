package edu.nju.umr.data.utilityData;

import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;

public class EnumFactory {
	public static Jurisdiction getJuri(String value){
		Jurisdiction juri = null;
		switch(value){
		case "快递员":juri = Jurisdiction.COURIER;break;
		case "营业厅业务员":juri = Jurisdiction.HALL;break;
		case "中转中心业务员":juri = Jurisdiction.CENTER;break;
		case "仓库管理员":juri = Jurisdiction.STOCK;break;
		case "高级财务人员":juri = Jurisdiction.FINANCE_SUPE;break;
		case "普通财务人员":juri = Jurisdiction.FINANCE;break;
		case "总经理":juri = Jurisdiction.MANAGER;break;
		case "管理员":juri = Jurisdiction.ADMIN;break;
		}
		return juri;
	}
	public static Organization getOrg(String value){
		Organization kind = null;
		switch(value){
		case "营业厅":kind = Organization.HALL;break;
		case "中转中心":kind = Organization.CENTER;break;
		case "总部":kind = Organization.HEADQUARTER;break;
		}
		return kind;
	}
}
