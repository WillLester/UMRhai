package edu.nju.umr.utility;

import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.GoodState;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.Parse;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.po.enums.Wage;

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
	public static String checkParse(Parse parse)
	{
		String par=null;
		switch(parse)
		{
			case WOOD:par="木箱";break;
			case PAPER:par="纸箱";break;
			case BAG:par="快递袋";break;
			default:par="其他";
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
	public static String checkExpress(Express express)
	{
		String exp=null;
		switch(express)
		{
		case ECONOMIC:exp="经济快递";break;
		case NORMAL:exp="标准快递";break;
		case FAST:exp="特快专递";break;
		}
		return exp;
	}
	public static String checkWage(Wage wage){
		String wag = null;
		switch(wage){
		case MONTH:wag = "按月发薪";break;
		case TIME:wag = "按次发薪";break;
		case COMMISSION:wag = "提成发薪";break;
		}
		return wag;
	}
	public static Pay getPay(String pa)
	{
		Pay pay=null;
		switch(pa)
		{
		case "租金/年":pay=Pay.RENT;break;
		case "运费/次":pay=Pay.FREIGHT;break;
		case "工资/月":pay=Pay.WAGE;break;
		case "奖励":pay=Pay.BONUS;break;
		}
		return pay;
	}
	public static String checkPay(Pay pa)
	{
		String pay=null;
		switch(pa)
		{
		case RENT:pay="租金/年";break;
		case FREIGHT :pay="运费/次";break;
		case WAGE:pay="工资/月";break;
		case BONUS:pay="奖励";break;
		}
		return pay;
	}
	public static GoodState getGoodState(String sta)
	{
		GoodState state=null;
		switch(sta)
		{
		case "完整":state=GoodState.INTACT;break;
		case "损坏":state=GoodState.DAMAGED;break;
		case "丢失":state=GoodState.LOSED;break;
		}
		return state;
	}
	public static String checkGoodState(GoodState sta)
	{
		String state=null;
		switch(sta)
		{
		case INTACT:state="完整";break;
		case DAMAGED:state="损坏";break;
		case LOSED:state="丢失";break;
		}
		return state;
	}
	public static Transit getTransit(String tran)
	{
		Transit transit=null;
		switch(tran)
		{
		case "飞机":transit=Transit.PLANE;break;
		case "铁路":transit=Transit.TRAIN;break;
		case "公路":transit=Transit.VAN;break;
		}
		return transit;
	}
	public static String checkTransit(Transit tran)
	{
		String transit=null;
		switch(tran)
		{
		case PLANE:transit="飞机";break;
		case TRAIN:transit="火车";break;
		case VAN:transit="公路";break;
		}
		return transit;
	}
	
}
