package edu.nju.umr.utility;

import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.Parse;
import edu.nju.umr.po.enums.Part;

public class EnumTransFactory {
	public static String checkJuri(Jurisdiction juri){
		String result = null;
		switch(juri){
		case COURIER:result="快递员";break;
		case HALL:result = "营业厅业务员";break;
		case CENTER:result = "中转中心业务员";break;
		case STOCK:result = "仓库管理员";break;
		case FINANCE_SUPE:result = "高级财务人员";break;
		case FINANCE:result = "普通财务人员";break;
		case MANAGER:result = "总经理";break;
		case ADMIN:result = "管理员";break;
		}
		return result;
	}
	public static Jurisdiction getJuri(String juri){
		Jurisdiction jur = null;
		switch(juri){
		case "总经理":jur=Jurisdiction.MANAGER;break;
		case "高级财务人员":jur=Jurisdiction.FINANCE_SUPE;break;
		case "普通财务人员":jur=Jurisdiction.FINANCE;break;
		case "快递员":jur=Jurisdiction.COURIER;break;
		case "营业厅业务员":jur=Jurisdiction.HALL;break;
		case "中转中心业务员":jur=Jurisdiction.CENTER;break;
		case "仓库管理员":jur=Jurisdiction.STOCK;break;
		case "管理员":jur=Jurisdiction.ADMIN;break;
		}
		return jur;
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
	public static String checkPart(Part part){
		String pa = null;
		switch(part){
		case PLANE:pa = "航运区";break;
		case TRAIN:pa = "铁运区";break;
		case VAN:pa = "汽运区";break;
		case MANEUVER:pa = "机动区";break;
		}
		return pa;
	}
	public static Part getPart(String part){
		Part pa = null;
		switch(part){
		case "航运区":pa = Part.PLANE;break;
		case "铁运区":pa = Part.TRAIN;break;
		case "汽运区":pa = Part.VAN;break;
		case "机动区":pa = Part.MANEUVER;break;
		}
		return pa;
	}
	public static Parse getParse(String parse){
		Parse par = null;
		switch(parse){
		case "纸箱":par = Parse.PAPER;break;
		case "木箱":par = Parse.WOOD;break;
		case "快递袋":par = Parse.BAG;break;
		case "其它":par = Parse.OTHER;break;
		}
		return par;
	}
	public static Express getExpress(String express){
		Express exp = null;
		switch(express){
		case "经济快递":exp = Express.ECONOMIC;break;
		case "标准快递":exp = Express.NORMAL;break;
		case "特快专递":exp = Express.FAST;break;
		}
		return exp;
	}
}
