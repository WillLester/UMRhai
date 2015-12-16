package edu.nju.umr.ui.userPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.accountUI.CountPanel;
import edu.nju.umr.ui.checkUI.BusiCircumPanel;
import edu.nju.umr.ui.checkUI.CostBenePanel;
import edu.nju.umr.ui.checkUI.DiaryListPanel;
import edu.nju.umr.ui.checkUI.IncomeListPanel;
import edu.nju.umr.ui.orderNewUI.PaymentPanel;
import edu.nju.umr.vo.UserVO;

public class FinancePanel extends UserPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5651667612499627695L;

	public FinancePanel(UserVO user,JFrame fr) {
		
		super(user,fr);
		
		JButton diaryButton = new JButton("查询日志");
		diaryButton.setFont(new Font("宋体", Font.PLAIN, 12));
		diaryButton.setBounds(269, 192, 112, 83);
		this.add(diaryButton);
		diaryButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("查看日志");
				fr.setContentPane(new DiaryListPanel(fr));
			}
		});
		
		JButton busiCircumButton = new JButton("经营情况表");
		busiCircumButton.setFont(new Font("宋体", Font.PLAIN, 12));
		busiCircumButton.setBounds(516, 192, 112, 83);
		this.add(busiCircumButton);
		busiCircumButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("查看经营情况表");
				fr.setContentPane(new BusiCircumPanel(fr));
			}
		});
		
		JButton costBeneButton = new JButton("成本收益表");
		costBeneButton.setFont(new Font("宋体", Font.PLAIN, 12));
		costBeneButton.setBounds(760, 192, 112, 83);
		this.add(costBeneButton);
		costBeneButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("查看成本收益表");
				fr.setContentPane(new CostBenePanel(fr));
			}
		});
		
		JButton incomeButton = new JButton("查看收款记录");
		incomeButton.setFont(new Font("宋体", Font.PLAIN, 12));
		incomeButton.setBounds(269, 333, 112, 83);
		this.add(incomeButton);
		incomeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("查看收款记录");
				fr.setContentPane(new IncomeListPanel(fr));
			}
		});
		
		JButton countButton = new JButton("期初建账");
		countButton.setFont(new Font("宋体", Font.PLAIN, 12));
		countButton.setBounds(516, 333, 112, 83);
		this.add(countButton);
		countButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("期初建账");
				fr.setContentPane(new CountPanel(fr,user.getName()));
			}
		});
		
		JButton paymentButton = new JButton("生成付款单");
		paymentButton.setFont(new Font("宋体", Font.PLAIN, 12));
		paymentButton.setBounds(516, 333, 112, 83);
		this.add(paymentButton);
		paymentButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("生成付款单");
				fr.setContentPane(new PaymentPanel(fr,user.getName(),user.getId()));
			}
		});
		
		UnpassedOrderMessagePanel upo = new UnpassedOrderMessagePanel(user.getId());
		upo.setBounds(853, 10, 200, 30);
		add(upo);
	}


}

