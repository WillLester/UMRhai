package edu.nju.umr.ui.driver;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;

import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.ui.accountUI.CountInfoPanel;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.CountVO;
import edu.nju.umr.vo.GoodVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.StockVO;
import edu.nju.umr.vo.VanVO;
import edu.nju.umr.vo.WorkVO;

public class CountInfoPanelDriver {
	public void drive(){
		JFrame frame=new JFrame();
		OrgVO org = new OrgVO("021000", "赛艇", Organization.HALL, "谜", "上海", "021");
		ArrayList<OrgVO> orgs = new ArrayList<OrgVO>();
		orgs.add(org);
		WorkVO work = new WorkVO("蛤", "12314131421", "总部", Jurisdiction.MANAGER);
		ArrayList<WorkVO> works = new ArrayList<WorkVO>();
		works.add(work);
		ArrayList<VanVO> vans = new ArrayList<VanVO>();
		VanVO van = new VanVO("02100000000", "沪A-00000", Calendar.getInstance(), null, "021000");
		vans.add(van);
		GoodVO good = new GoodVO("1111111111", Calendar.getInstance(), "赛艇", Part.PLANE, "021000000", 3, 6);
		ArrayList<GoodVO> goods = new ArrayList<GoodVO>();
		goods.add(good);
		StockVO stock = new StockVO(goods,"0210");
		ArrayList<StockVO> stocks = new ArrayList<StockVO>();
		stocks.add(stock);
		AccountVO account = new AccountVO("批判一番", new BigDecimal(300));
		ArrayList<AccountVO> accounts = new ArrayList<AccountVO>();
		accounts.add(account);
		CountVO count = new CountVO(3, orgs, works, vans, stocks, accounts, Calendar.getInstance());
		CountInfoPanel p = new CountInfoPanel(count,frame);
		frame.add(p);
		frame.setSize(1200,800);
		frame.setVisible(true);
	}
	public static void main(String[] args){
		CountInfoPanelDriver cd=new CountInfoPanelDriver();
		cd.drive();
	}

}
