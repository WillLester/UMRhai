package edu.nju.umr.ui.userPanel;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.nju.umr.vo.UserVO;

public class FinanceSuperPanel extends JPanel{
	
	private UserVO user;
	
	public FinanceSuperPanel(UserVO user) {
		setBounds(0, 0, 1229, 691);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		JLabel title = new JLabel("快递物流管理系统");
		title.setFont(new Font("华文新魏", Font.PLAIN, 22));
		title.setBounds(29, 10, 250, 38);
		this.add(title);
		
		JSeparator horizen = new JSeparator();
		horizen.setBounds(18, 78, 1158, 2);
		this.add(horizen);
		
		JSeparator vertical = new JSeparator();
		vertical.setOrientation(SwingConstants.VERTICAL);
		vertical.setBounds(165, 78, 9, 545);
		this.add(vertical);
		
		JLabel nameLabel = new JLabel("姓名");
		nameLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		nameLabel.setBounds(18, 120, 54, 15);
		this.add(nameLabel);
		
		JTextField nameTxt = new JTextField();
		nameTxt.setText("袁楚宏");
		nameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		nameTxt.setEditable(false);
		nameTxt.setBounds(56, 116, 54, 21);
		this.add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel levelLabel = new JLabel("身份");
		levelLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		levelLabel.setBounds(18, 160, 54, 15);
		this.add(levelLabel);
		
		JTextField levelTxt = new JTextField();
		levelTxt.setEditable(false);
		levelTxt.setText("高级财务人员");
		levelTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		levelTxt.setBounds(56, 156,100, 21);
		this.add(levelTxt);
		levelTxt.setColumns(10);
		
		JButton logoutButton = new JButton("注销");
		logoutButton.setFont(new Font("宋体", Font.PLAIN, 12));
		logoutButton.setBounds(1083, 10, 93, 23);
		this.add(logoutButton);
		
		JButton existButton = new JButton("退出");
		existButton.setFont(new Font("宋体", Font.PLAIN, 12));
		existButton.setBounds(1083, 603, 93, 23);
		this.add(existButton);
		
		JButton userMangButton = new JButton("查询日志");
		userMangButton.setFont(new Font("宋体", Font.PLAIN, 12));
		userMangButton.setBounds(269, 192, 112, 83);
		this.add(userMangButton);
		
		JButton button = new JButton("经营情况表");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(516, 192, 112, 83);
		this.add(button);
		
		JButton button_1 = new JButton("成本收益表");
		button_1.setFont(new Font("宋体", Font.PLAIN, 12));
		button_1.setBounds(760, 192, 112, 83);
		this.add(button_1);
		
		JButton button_2 = new JButton("期初建账");
		button_2.setFont(new Font("宋体", Font.PLAIN, 12));
		button_2.setBounds(269, 333, 112, 83);
		this.add(button_2);
		
		JButton button_3 = new JButton("期初信息查询");
		button_3.setFont(new Font("宋体", Font.PLAIN, 12));
		button_3.setBounds(516, 333, 112, 83);
		this.add(button_3);
		
		JButton button_4 = new JButton("付款单");
		button_4.setFont(new Font("宋体", Font.PLAIN, 12));
		button_4.setBounds(269, 477, 112, 83);
		this.add(button_4);
		
		JButton button_5 = new JButton("收款单");
		button_5.setFont(new Font("宋体", Font.PLAIN, 12));
		button_5.setBounds(516, 477, 112, 83);
		this.add(button_5);
		
		JButton button_6 = new JButton("账户管理");
		button_6.setFont(new Font("宋体", Font.PLAIN, 12));
		button_6.setBounds(760, 333, 112, 83);
		this.add(button_6);
		
		
	}


}
