package edu.nju.umr.ui.userPanel;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.orderNewUI.HallLoadingPanel;
import edu.nju.umr.ui.orderNewUI.IncomePanel;
import edu.nju.umr.ui.orderNewUI.RecipientPanel;
import edu.nju.umr.ui.orderNewUI.SendPanel;
import edu.nju.umr.ui.workOrgManUI.DriverListPanel;
import edu.nju.umr.ui.workOrgManUI.VanListPanel;
import edu.nju.umr.vo.UserVO;


public class BusinessHallPanel extends UserPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 4435831268900821861L;
	
	public BusinessHallPanel(UserVO user,MainFrame fr) {
		
		super(user,fr);
		
		Button recipient = new Button();
		recipient.setNewImages("businesshall/recipient", "businesshall/recipientSt", "businesshall/recipientP");
		recipient.setBounds(Constants.FIRST_X, Constants.DOUBLE_Y, 95, 95);
		recipient.setFont(new Font("宋体", Font.PLAIN, 12));
		recipient.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("单据创建");
				ffr.setContentPane(new RecipientPanel(ffr,user.getName(),user.getOrgId(),user.getId()));
				fr.sonFrames.add(ffr);
			}
		});
		this.add(recipient);
		
		Button send = new Button();
		send.setNewImages("businesshall/send", "businesshall/sendSt", "businesshall/sendP");
		send.setBounds(Constants.SECOND_X, Constants.DOUBLE_Y, 95, 95);
		send.setFont(new Font("宋体", Font.PLAIN, 12));
		send.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("单据创建");
				ffr.setContentPane(new SendPanel(ffr,user.getName(),user.getOrgId(),user.getId()));
			}
		});
		this.add(send);
		
		Button hallLoading = new Button();
		hallLoading.setNewImages("businesshall/hallloading", "businesshall/hallloadingSt", "businesshall/hallloadingP");
		hallLoading.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("单据创建");
				ffr.setContentPane(new HallLoadingPanel(ffr,user.getName(),user.getId(),user.getOrgId(),user.getOrg()));
				fr.sonFrames.add(ffr);
			}
		});
		hallLoading.setFont(new Font("宋体", Font.PLAIN, 12));
		hallLoading.setBounds(Constants.THIRD_X, Constants.DOUBLE_Y, 95, 95);
		this.add(hallLoading);
		
		Button income = new Button();
		income.setNewImages("businesshall/income", "businesshall/incomeSt", "businesshall/incomeP");
		income.setFont(new Font("宋体", Font.PLAIN, 12));
		income.setBounds(Constants.FIRST_X, Constants.SECOND_Y, 95, 95);
		income.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("收款单生成");
				ffr.setContentPane(new IncomePanel(ffr,user.getOrgId(),user.getName(),user.getId()));
				fr.sonFrames.add(ffr);
			}
		});
		this.add(income);
		
		Button driverMan = new Button();
		driverMan.setNewImages("businesshall/driverMan", "businesshall/driverManSt", "businesshall/driverManP");
		driverMan.setFont(new Font("宋体", Font.PLAIN, 12));
		driverMan.setBounds(Constants.SECOND_X, Constants.SECOND_Y, 95, 95);
		driverMan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("司机管理 ");
				ffr.setContentPane(new DriverListPanel(ffr,user.getOrgId(),user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		this.add(driverMan);
		
		Button vanMan = new Button();
		vanMan.setNewImages("businesshall/vanMan", "businesshall/vanManSt", "businesshall/vanManP");
		vanMan.setFont(new Font("宋体", Font.PLAIN, 12));
		vanMan.setBounds(Constants.THIRD_X, Constants.SECOND_Y, 95,95);
		vanMan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("车辆管理 ");
				ffr.setContentPane(new VanListPanel(ffr,user.getOrgId(),user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		this.add(vanMan);
		
		UnpassedOrderMessagePanel upo = new UnpassedOrderMessagePanel(user.getId());
		upo.setBounds(Constants.UNPASSED_X, Constants.UNPASSED_Y, 200, 30);
		add(upo);
		

	
	
	}
}
