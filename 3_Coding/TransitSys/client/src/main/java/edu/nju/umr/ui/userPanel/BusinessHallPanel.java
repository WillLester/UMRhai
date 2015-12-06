package edu.nju.umr.ui.userPanel;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.orderNewUI.HallLoadingPanel;
import edu.nju.umr.ui.orderNewUI.IncomePanel;
import edu.nju.umr.ui.orderNewUI.RecipientPanel;
import edu.nju.umr.ui.workOrgManUI.DriverListPanel;
import edu.nju.umr.ui.workOrgManUI.VanListPanel;
import edu.nju.umr.vo.UserVO;


public class BusinessHallPanel extends UserPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 4435831268900821861L;
	public BusinessHallPanel(UserVO user,JFrame fr) {
		
		super(user,fr);
		
		JButton recipient = new JButton("到达单");
		recipient.setBounds(269, 192, 112, 83);
		recipient.setFont(new Font("宋体", Font.PLAIN, 12));
		recipient.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("单据创建");
				ffr.setContentPane(new RecipientPanel(ffr,user.getName(),user.getOrgId(),user.getId(),user.getOrg()));
			}
		});
		this.add(recipient);
		
		JButton hallLoading = new JButton("装车单");
		hallLoading.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("单据创建");
				ffr.setContentPane(new HallLoadingPanel(ffr,user.getName(),user.getId(),user.getOrgId(),user.getOrg()));
			}
		});
		hallLoading.setFont(new Font("宋体", Font.PLAIN, 12));
		hallLoading.setBounds(516, 192, 112, 83);
		this.add(hallLoading);
		
		JButton income = new JButton("收款单");
		income.setFont(new Font("宋体", Font.PLAIN, 12));
		income.setBounds(760, 192, 112, 83);
		income.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("收款单生成");
				ffr.setContentPane(new IncomePanel(ffr,user.getOrgId(),user.getName(),user.getId()));
			}
		});
		this.add(income);
		
		JButton driverMan = new JButton("司机信息管理");
		driverMan.setFont(new Font("宋体", Font.PLAIN, 12));
		driverMan.setBounds(269, 333, 112, 83);
		driverMan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("司机管理 ");
				ffr.setContentPane(new DriverListPanel(ffr,user));
			}
		});
		this.add(driverMan);
		
		JButton vanMan = new JButton("车辆信息管理");
		vanMan.setFont(new Font("宋体", Font.PLAIN, 12));
		vanMan.setBounds(516, 333, 112, 83);
		vanMan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("车辆管理 ");
				ffr.setContentPane(new VanListPanel(ffr,user));
			}
		});
		this.add(vanMan);
		

	
	
	}
}
