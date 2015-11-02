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

public class CourierPanel extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourierPanel frame = new CourierPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CourierPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1229, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("快递物流管理系统");
		title.setFont(new Font("华文新魏", Font.PLAIN, 22));
		title.setBounds(29, 10, 250, 38);
		contentPane.add(title);
		
		JSeparator horizen = new JSeparator();
		horizen.setBounds(18, 78, 1158, 2);
		contentPane.add(horizen);
		
		JSeparator vertical = new JSeparator();
		vertical.setOrientation(SwingConstants.VERTICAL);
		vertical.setBounds(140, 78, 9, 545);
		contentPane.add(vertical);
		
		JLabel nameLabel = new JLabel("姓名");
		nameLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		nameLabel.setBounds(18, 120, 54, 15);
		contentPane.add(nameLabel);
		
		JTextField nameTxt = new JTextField();
		nameTxt.setText("袁楚宏");
		nameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		nameTxt.setEditable(false);
		nameTxt.setBounds(66, 116, 54, 21);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel levelLabel = new JLabel("身份");
		levelLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		levelLabel.setBounds(18, 160, 54, 15);
		contentPane.add(levelLabel);
		
		JTextField levelTxt = new JTextField();
		levelTxt.setEditable(false);
		levelTxt.setText("快递员");
		levelTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		levelTxt.setBounds(66, 156, 54, 21);
		contentPane.add(levelTxt);
		levelTxt.setColumns(10);
		
		JButton logoutButton = new JButton("注销");
		logoutButton.setFont(new Font("宋体", Font.PLAIN, 12));
		logoutButton.setBounds(1083, 10, 93, 23);
		contentPane.add(logoutButton);
		
		JButton existButton = new JButton("退出");
		existButton.setFont(new Font("宋体", Font.PLAIN, 12));
		existButton.setBounds(1083, 603, 93, 23);
		contentPane.add(existButton);
		
		JButton userMangButton = new JButton("收件");
		userMangButton.setFont(new Font("宋体", Font.PLAIN, 12));
		userMangButton.setBounds(314, 227, 93, 83);
		contentPane.add(userMangButton);
		
		JButton button = new JButton("订单查询");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(505, 227, 93, 83);
		contentPane.add(button);
		
		JButton button_1 = new JButton("订单创建");
		button_1.setFont(new Font("宋体", Font.PLAIN, 12));
		button_1.setBounds(695, 227, 93, 83);
		contentPane.add(button_1);
		
	}

}

