package edu.nju.umr.ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PersonalInfoPanel extends JPanel{
	public PersonalInfoPanel() {
		setLayout(null);
		this.setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		System.out.println(this.getWidth() + " " + this.getHeight());
		JLabel personalInfo = new JLabel("个人信息");
		personalInfo.setFont(new Font("华文新魏", Font.PLAIN, 25));
		personalInfo.setBounds(this.getWidth()/9, this.getHeight()/10, this.getWidth()/9, this.getHeight()/7);
		add(personalInfo);
		
		JLabel name = new JLabel("姓名");
		name.setFont(new Font("华文新魏", Font.PLAIN, 20));
		name.setBounds(this.getWidth()/9, this.getHeight()/10 + 2 * this.getHeight()/10, this.getWidth()/9, this.getHeight()/20);
		add(name);
		
		JLabel org = new JLabel("机构");
		org.setFont(new Font("华文新魏", Font.PLAIN, 20));
		org.setBounds(this.getWidth()/9, this.getHeight()/10 + 3 * this.getHeight()/10, this.getWidth()/9, this.getHeight()/20);
		add(org);
		
		JLabel post = new JLabel("职务");
		post.setFont(new Font("华文新魏", Font.PLAIN, 20));
		post.setBounds(this.getWidth()/9, this.getHeight()/10 + 4 * this.getHeight()/10, this.getWidth()/9, this.getHeight()/20);
		add(post);
		
		JLabel mobile = new JLabel("手机号");
		mobile.setFont(new Font("华文新魏", Font.PLAIN, 20));
		mobile.setBounds(this.getWidth()/9, this.getHeight()/10 + 5 * this.getHeight()/10, this.getWidth()/9, this.getHeight()/20);
		add(mobile);
		
		JButton logoutButton = new JButton("注销");
		logoutButton.setBounds(8 * this.getWidth()/10, this.getHeight()/20, this.getWidth()/18, this.getHeight()/20);
		add(logoutButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setBounds(7 * this.getWidth()/8, this.getHeight()/20, this.getWidth()/18, this.getHeight()/20);
		add(exitButton);
		
		JButton button = new JButton("返回主界面");
		button.setBounds(8 * this.getWidth()/10, 8*this.getHeight()/10, this.getWidth()/10, this.getHeight()/20);
		add(button);

	}
}
