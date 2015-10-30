package edu.nju.umr.ui.userPanel;


import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class BusinessHallPanel extends JFrame {

	private JPanel contentPane;
	private JTextField nameTxt;
	private JTextField levelTxt;
	

	public BusinessHallPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1229, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("快递物流管理系统");
		title.setBounds(29, 10, 250, 38);
		title.setFont(new Font("华文新魏", Font.PLAIN, 22));
		contentPane.add(title);
		
		JSeparator horizen = new JSeparator();
		horizen.setBounds(18, 78, 1158, 2);
		contentPane.add(horizen);
		
		JSeparator vertical = new JSeparator();
		vertical.setBounds(174, 81, 9, 545);
		vertical.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(vertical);
		
		JLabel nameLabel = new JLabel("姓名");
		nameLabel.setBounds(18, 120, 54, 15);
		nameLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		contentPane.add(nameLabel);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(57, 115, 54, 21);
		nameTxt.setText("袁楚宏");
		nameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		nameTxt.setEditable(false);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel levelLabel = new JLabel("身份");
		levelLabel.setBounds(18, 160, 54, 15);
		levelLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		contentPane.add(levelLabel);
		
		levelTxt = new JTextField();
		levelTxt.setBounds(57, 155, 107, 21);
		levelTxt.setEditable(false);
		levelTxt.setText("营业厅业务员");
		levelTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		contentPane.add(levelTxt);
		levelTxt.setColumns(10);
		
		
		
		JButton logoutButton = new JButton("注销");
		logoutButton.setBounds(1083, 10, 93, 23);
		logoutButton.setFont(new Font("宋体", Font.PLAIN, 12));
		contentPane.add(logoutButton);
		
		JButton existButton = new JButton("退出");
		existButton.setBounds(1083, 603, 93, 23);
		existButton.setFont(new Font("宋体", Font.PLAIN, 12));
		contentPane.add(existButton);
		
		JButton userMangButton = new JButton("接收单");
		userMangButton.setBounds(282, 231, 112, 83);
		userMangButton.setFont(new Font("宋体", Font.PLAIN, 12));
		contentPane.add(userMangButton);
		
		JButton button = new JButton("派件单");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(489, 231, 113, 83);
		contentPane.add(button);
		
		JButton button_1 = new JButton("装车单");
//		button_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 12));
		button_1.setBounds(679, 231, 112, 83);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("收款单");
		button_2.setFont(new Font("宋体", Font.PLAIN, 12));
		button_2.setBounds(849, 231, 112, 83);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("司机信息管理");
		button_3.setFont(new Font("宋体", Font.PLAIN, 12));
		button_3.setBounds(598, 420, 113, 83);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("车辆信息管理");
		button_4.setFont(new Font("宋体", Font.PLAIN, 12));
		button_4.setBounds(389, 420, 113, 83);
		contentPane.add(button_4);
		

	
	
	}
}
