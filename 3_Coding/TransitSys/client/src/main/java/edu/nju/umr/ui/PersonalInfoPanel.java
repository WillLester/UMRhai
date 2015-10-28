package edu.nju.umr.ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonalInfoPanel extends JPanel{
	private JTextField nameField;
	private JTextField orgField;
	private JTextField dutyField;
	private JTextField mobileField;
	
	public PersonalInfoPanel() {
		setLayout(null);
		this.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
//		System.out.println(this.getWidth() + " " + this.getHeight());
		JLabel personalInfo = new JLabel("个人信息");
		personalInfo.setFont(new Font("华文新魏", Font.PLAIN, 25));
		personalInfo.setBounds(Constants.LABEL_X, Constants.LABEL_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(personalInfo);
		
		JLabel name = new JLabel("姓名");
		name.setFont(new Font("华文新魏", Font.PLAIN, 20));
		name.setBounds(Constants.LABEL_X, 3*Constants.LABEL_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(name);
		
		JLabel org = new JLabel("机构");
		org.setFont(new Font("华文新魏", Font.PLAIN, 20));
		org.setBounds(Constants.LABEL_X, 4*Constants.LABEL_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(org);
		
		JLabel post = new JLabel("职务");
		post.setFont(new Font("华文新魏", Font.PLAIN, 20));
		post.setBounds(Constants.LABEL_X, 5*Constants.LABEL_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(post);
		
		JLabel mobile = new JLabel("手机号");
		mobile.setFont(new Font("华文新魏", Font.PLAIN, 20));
		mobile.setBounds(Constants.LABEL_X, 6*Constants.LABEL_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(mobile);
		
		JButton logoutButton = new JButton("注销");
		logoutButton.setBounds(12 * Constants.BUTTON_X, Constants.BUTTON_Y, Constants.BUTTON_WIDTH_S, Constants.BUTTON_HEIGHT);
		add(logoutButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setBounds(13 * Constants.BUTTON_X, Constants.BUTTON_Y, Constants.BUTTON_WIDTH_S, Constants.BUTTON_HEIGHT);
		add(exitButton);
		
		JButton returnButton = new JButton("返回主界面");
		returnButton.setBounds(12 * Constants.BUTTON_X, 8*Constants.BUTTON_Y, Constants.BUTTON_WIDTH_L, Constants.BUTTON_HEIGHT);
		add(returnButton);
		
		nameField = new JTextField();
		nameField.setEditable(false);
		nameField.setBounds(Constants.TEXTFIELD_X, 3*Constants.TEXTFIELD_Y, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(nameField);
		nameField.setColumns(10);
		
		orgField = new JTextField();
		orgField.setEditable(false);
		orgField.setBounds(Constants.TEXTFIELD_X, 4*Constants.TEXTFIELD_Y, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(orgField);
		orgField.setColumns(10);
		
		dutyField = new JTextField();
		dutyField.setEditable(false);
		dutyField.setBounds(Constants.TEXTFIELD_X, 5*Constants.TEXTFIELD_Y, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(dutyField);
		dutyField.setColumns(10);
		
		mobileField = new JTextField();
		mobileField.setEditable(false);
		mobileField.setBounds(Constants.TEXTFIELD_X, 6*Constants.TEXTFIELD_Y, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(mobileField);
		mobileField.setColumns(10);

	}
}
