package edu.nju.umr.ui.userPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.accountUI.AccountManPanel;
import edu.nju.umr.ui.accountUI.CountPanel;
import edu.nju.umr.ui.checkUI.BusiCircumPanel;
import edu.nju.umr.ui.checkUI.CostBenePanel;
import edu.nju.umr.ui.checkUI.DiaryListPanel;
import edu.nju.umr.ui.checkUI.IncomeListPanel;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.orderNewUI.PaymentPanel;
import edu.nju.umr.vo.UserVO;

public class FinanceSuperPanel extends UserPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6829798067793603996L;
	private static final String pathb="finance&manager/";
	private static final String path="finance/";
	public FinanceSuperPanel(UserVO user,MainFrame fr) {
		super(user,fr);
		
		Button diaryButton = new Button();
		diaryButton.setNewImages(pathb+"diary", pathb+"diarySt", pathb+"diaryP");
		diaryButton.setBounds(Constants.FIRST_X, Constants.THERE_Y, 95, 95);
		this.add(diaryButton);
		diaryButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("查看日志");
				ffr.setContentPane(new DiaryListPanel(ffr));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button busiCircumButton = new Button();
		busiCircumButton.setNewImages(pathb+"busiCircum", pathb+"busiCircumSt", pathb+"busiCircumP");
		busiCircumButton.setBounds(Constants.SECOND_X, Constants.THERE_Y, 95, 95);
		this.add(busiCircumButton);
		busiCircumButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("查看经营情况表");
				ffr.setContentPane(new BusiCircumPanel(ffr));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button costBeneButton = new Button();
		costBeneButton.setNewImages(pathb+"costBene", pathb+"costBeneSt", pathb+"costBeneP");
		costBeneButton.setBounds(Constants.THIRD_X, Constants.THERE_Y, 95, 95);
		this.add(costBeneButton);
		costBeneButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("查看成本收益表");
				ffr.setContentPane(new CostBenePanel(ffr));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button incomeButton = new Button();
		incomeButton.setNewImages(path+"incomeList", path+"incomeListSt",path+"incomeListP");
		incomeButton.setBounds(Constants.FIRST_X, Constants.THERE_SEC_Y, 95,95);
		this.add(incomeButton);
		incomeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("查看收款记录");
				ffr.setContentPane(new IncomeListPanel(ffr));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button countButton = new Button();
		countButton.setNewImages(path+"count", path+"countSt", path+"countP");
		countButton.setBounds(Constants.SECOND_X, Constants.THERE_SEC_Y, 95, 95);
		this.add(countButton);
		countButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("期初建账");
				ffr.setContentPane(new CountPanel(ffr,user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button paymentButton = new Button();
		paymentButton.setNewImages(path+"payment", path+"paymentSt",path+"paymentP");
		paymentButton.setBounds(Constants.FIRST_X, Constants.THERE_THI_Y, 95,95);
		this.add(paymentButton);
		paymentButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("生成付款单");
				ffr.setContentPane(new PaymentPanel(ffr,user.getName(),user.getId()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button accountButton = new Button();
		accountButton.setNewImages(path+"account", path+"accountSt", path+"accountP");
		accountButton.setBounds(Constants.THIRD_X, Constants.THERE_SEC_Y, 95, 95);
		this.add(accountButton);
		accountButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("账户管理");
				ffr.setContentPane(new AccountManPanel(ffr,user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		
		UnpassedOrderMessagePanel upo = new UnpassedOrderMessagePanel(user.getId());
		upo.setBounds(Constants.UNPASSED_X, Constants.UNPASSED_Y, 200, 30);
		add(upo);
	}


}
