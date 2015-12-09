package edu.nju.umr.ui.userPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.accountUI.AccountManPanel;
import edu.nju.umr.ui.accountUI.CountPanel;
import edu.nju.umr.ui.checkUI.BusiCircumPanel;
import edu.nju.umr.ui.checkUI.CostBenePanel;
import edu.nju.umr.ui.checkUI.DiaryListPanel;
import edu.nju.umr.ui.orderNewUI.PaymentPanel;
import edu.nju.umr.vo.UserVO;

public class FinanceSuperPanel extends UserPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6829798067793603996L;
	public FinanceSuperPanel(UserVO user,JFrame fr) {
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
//		vertical.setBounds(165, 78, 9, 545);
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
//		nameTxt.setBounds(56, 116, 54, 21);
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
//		levelTxt.setText("高级财务人员");
//		levelTxt.setFont(new Font("宋体", Font.PLAIN, 15));
//		levelTxt.setBounds(56, 156,100, 21);
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
		
		JButton countButton = new JButton("期初建账");
		countButton.setFont(new Font("宋体", Font.PLAIN, 12));
		countButton.setBounds(269, 333, 112, 83);
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
		paymentButton.setBounds(269, 477, 112, 83);
		this.add(paymentButton);
		paymentButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("生成付款单");
				fr.setContentPane(new PaymentPanel(fr,user.getName(),user.getId()));
			}
		});
		
		JButton accountButton = new JButton("账户管理");
		accountButton.setFont(new Font("宋体", Font.PLAIN, 12));
		accountButton.setBounds(516, 333, 112, 83);
		this.add(accountButton);
		accountButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("账户管理");
				fr.setContentPane(new AccountManPanel(fr,user.getName()));
			}
		});
		
		UnpassedOrderMessagePanel upo = new UnpassedOrderMessagePanel(user.getId());
		upo.setBounds(853, 10, 200, 30);
		add(upo);
	}


}
