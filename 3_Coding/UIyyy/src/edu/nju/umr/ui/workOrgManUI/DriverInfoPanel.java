package edu.nju.umr.ui.workOrgManUI;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.nju.umr.checkUI.DatePanel;
import edu.nju.umr.ui.Constants;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.JButton;

public class DriverInfoPanel extends JPanel {
	private JTextField textFieldNum;
	private JTextField textFieldName;
	private JTextField textFieldIden;
	private JTextField textFieldMobile;

	/**
	 * Create the panel.
	 */
	public DriverInfoPanel() {
		setLayout(null);
		this.setSize(Constants.INFO_WIDTH,Constants.INFO_HEIGHT);
		JLabel nameLabel = new JLabel("司机信息");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN ,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2,0,Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		JLabel driverNum = new JLabel("司机编号");
		driverNum.setBounds(Constants.INFOTABLE_X, Constants.INFOTABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(driverNum);
		
		textFieldNum = new JTextField();
		textFieldNum.setBounds(driverNum.getX()+driverNum.getWidth(), driverNum.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldNum);
		textFieldNum.setColumns(10);
		
		JLabel driverName = new JLabel("姓名");
		driverName.setBounds(driverNum.getX(), driverNum.getY()+driverNum.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(driverName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(textFieldNum.getX(), driverName.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel driverSex = new JLabel("性别");
		driverSex.setBounds(driverNum.getX(), driverName.getY()+driverName.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(driverSex);
		
		JComboBox comboBoxSex = new JComboBox();
		comboBoxSex.setBounds(textFieldNum.getX(), driverSex.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(comboBoxSex);
		
		JLabel bornDate = new JLabel("出生日期");
		bornDate.setBounds(driverNum.getX(), driverSex.getY()+driverSex.getHeight()+30,Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(bornDate);
		
		DatePanel born=new DatePanel();
		born.setBounds(textFieldNum.getX(), bornDate.getY()+3,Constants.DATE_WIDTH, Constants.DATE_HEIGHT);
		add(born);
		
		JLabel identity = new JLabel("身份证号");
		identity.setBounds(driverNum.getX(), bornDate.getY()+bornDate.getHeight()+30,Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(identity);
		
		textFieldIden = new JTextField();
		textFieldIden.setBounds(textFieldNum.getX(), identity.getY()+3, Constants.TEXTFIELD_WIDTH_S*2, Constants.TEXTFIELD_HEIGHT);
		add(textFieldIden);
		textFieldIden.setColumns(10);
		
		JLabel mobile = new JLabel("手机");
		mobile.setBounds(this.getWidth()/2+40, driverNum.getY(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(mobile);
		
		textFieldMobile = new JTextField();
		textFieldMobile.setBounds(mobile.getX()+mobile.getWidth(), mobile.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldMobile);
		textFieldMobile.setColumns(10);
		
		JLabel term = new JLabel("行驶证期限");
		term.setBounds(mobile.getX(), mobile.getY()+mobile.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(term);
		
		JLabel labely = new JLabel("由");
		labely.setBounds(textFieldMobile.getX(), term.getY()+8, 19, 15);
		add(labely);
		
		DatePanel start=new DatePanel();
		start.setBounds(labely.getX()+20, term.getY()+3, Constants.DATE_WIDTH, Constants.DATE_HEIGHT);
		add(start);
		
		JLabel labelz = new JLabel("至");
		labelz.setBounds(textFieldMobile.getX(), term.getY()+30, 19, 15);
		add(labelz);
		
		DatePanel deadline=new DatePanel();
		deadline.setBounds(labelz.getX()+20, labelz.getY(), Constants.DATE_WIDTH, Constants.DATE_HEIGHT);
		add(deadline);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(this.getWidth()/10*9, this.getHeight()/10*7, Constants.BUTTON_WIDTH_S, Constants.BUTTON_HEIGHT);
		add(cancel);
		
		JButton confirm = new JButton("确认");
		confirm.setBounds(cancel.getX()-Constants.BUTTON_WIDTH_S-40, cancel.getY(), Constants.BUTTON_WIDTH_S, Constants.BUTTON_HEIGHT);
		add(confirm);

	}
}
