package edu.nju.umr.ui.userPanel;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.nju.umr.vo.UserVO;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.accountUI.CountPanel;
import edu.nju.umr.ui.checkUI.BusiCircumPanel;
import edu.nju.umr.ui.checkUI.CostBenePanel;
import edu.nju.umr.ui.checkUI.DiaryListPanel;
import edu.nju.umr.ui.orderNewUI.IncomePanel;
import edu.nju.umr.ui.orderNewUI.PaymentPanel;

public class FinancePanel extends UserPanel{

	
	public FinancePanel(UserVO user,JFrame fr) {
//		this.user=user;
//		setBounds(0, 0, 1229, 691);
//		this.setBorder(new EmptyBorder(5, 5, 5, 5));
//		this.setLayout(null);
//		
//		JLabel title = new JLabel("快递物流管理系统");
//		title.setFont(new Font("华文新魏", Font.PLAIN, 22));
//		title.setBounds(29, 10, 250, 38);
//		this.add(title);
//		
//		JSeparator horizen = new JSeparator();
//		horizen.setBounds(18, 78, 1158, 2);
//		this.add(horizen);
//		
//		JSeparator vertical = new JSeparator();
//		vertical.setOrientation(SwingConstants.VERTICAL);
//		vertical.setBounds(150, 78, 9, 545);
//		this.add(vertical);
//		
//		JLabel nameLabel = new JLabel("姓名");
//		nameLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
//		nameLabel.setBounds(18, 120, 54, 15);
//		this.add(nameLabel);
//		
//		JTextField nameTxt = new JTextField();
//		nameTxt.setText("袁楚宏");
//		nameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
//		nameTxt.setEditable(false);
//		nameTxt.setBounds(66, 116, 54, 21);
//		this.add(nameTxt);
//		nameTxt.setColumns(10);
//		
//		JLabel levelLabel = new JLabel("身份");
//		levelLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
//		levelLabel.setBounds(18, 160, 54, 15);
//		this.add(levelLabel);
//		
//		JTextField levelTxt = new JTextField();
//		levelTxt.setEditable(false);
//		levelTxt.setText("财务人员");
//		levelTxt.setFont(new Font("宋体", Font.PLAIN, 15));
//		levelTxt.setBounds(66, 156, 70, 21);
//		this.add(levelTxt);
//		levelTxt.setColumns(10);
//		
//		JButton logoutButton = new JButton("注销");
//		logoutButton.setFont(new Font("宋体", Font.PLAIN, 12));
//		logoutButton.setBounds(1083, 10, 93, 23);
//		this.add(logoutButton);
//		
//		JButton existButton = new JButton("退出");
//		existButton.setFont(new Font("宋体", Font.PLAIN, 12));
//		existButton.setBounds(1083, 603, 93, 23);
//		this.add(existButton);
		
		super(user,fr);
		
		JButton diaryButton = new JButton("查询日志");
		diaryButton.setFont(new Font("宋体", Font.PLAIN, 12));
		diaryButton.setBounds(269, 192, 112, 83);
		this.add(diaryButton);
		diaryButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("查看日志");
				fr.setContentPane(new DiaryListPanel());
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
				fr.setContentPane(new BusiCircumPanel());
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
				fr.setContentPane(new CostBenePanel());
			}
		});
		
		JButton countButton = new JButton("期初建账");
		countButton.setFont(new Font("宋体", Font.PLAIN, 12));
		countButton.setBounds(269, 333, 112, 83);
		this.add(countButton);
		countButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("期初建账");
				fr.setContentPane(new CountPanel());
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
				fr.setContentPane(new PaymentPanel());
			}
		});
		
		JButton incomeButton = new JButton("生成收款单");
		incomeButton.setFont(new Font("宋体", Font.PLAIN, 12));
		incomeButton.setBounds(760, 333, 112, 83);
		this.add(incomeButton);
		incomeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("生成收款单");
				fr.setContentPane(new IncomePanel(fr));
			}
		});
	}


}

