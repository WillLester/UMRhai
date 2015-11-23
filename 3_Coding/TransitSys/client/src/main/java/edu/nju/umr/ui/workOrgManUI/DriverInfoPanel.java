package edu.nju.umr.ui.workOrgManUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.nju.umr.po.enums.Gender;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.checkUI.DatePanel;
import edu.nju.umr.vo.DriverVO;

import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;

public class DriverInfoPanel extends JPanel {
	private JTextField textFieldNum;
	private JTextField textFieldName;
	private JTextField textFieldIden;
	private JTextField textFieldMobile;
	private JFrame frame;
	private DriverListPanel panel;
	private JComboBox comboBoxSex;
	private DatePanel born;
	private DatePanel start;
	private DatePanel deadline;

	/**
	 * Create the panel.
	 */
	public DriverInfoPanel(JFrame fr,DriverListPanel pa,DriverVO driver) {
		setLayout(null);
		frame=fr;
		panel=pa;
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
		textFieldNum.setEditable(false);
		textFieldNum.setText(driver.getId());
		textFieldNum.setColumns(10);
		
		JLabel driverName = new JLabel("姓名");
		driverName.setBounds(driverNum.getX(), driverNum.getY()+driverNum.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(driverName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(textFieldNum.getX(), driverName.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldName);
		textFieldName.setText(driver.getName());
		textFieldName.setColumns(10);
		
		JLabel driverSex = new JLabel("性别");
		driverSex.setBounds(driverNum.getX(), driverName.getY()+driverName.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(driverSex);
		
		comboBoxSex = new JComboBox();
		comboBoxSex.setBounds(textFieldNum.getX(), driverSex.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[]{"男","女"}));
		if(driver.getSex().equals(Gender.MAN))
		comboBoxSex.setSelectedIndex(0);
		else comboBoxSex.setSelectedIndex(1);
		add(comboBoxSex);
		
		JLabel bornDate = new JLabel("出生日期");
		bornDate.setBounds(driverNum.getX(), driverSex.getY()+driverSex.getHeight()+30,Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(bornDate);
		
		born=new DatePanel();
		born.setBounds(textFieldNum.getX(), bornDate.getY()+3,Constants.DATE_WIDTH, Constants.DATE_HEIGHT);
		born.setDate(driver.getBirthday());
		add(born);
		
		JLabel identity = new JLabel("身份证号");
		identity.setBounds(driverNum.getX(), bornDate.getY()+bornDate.getHeight()+30,Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(identity);
		
		textFieldIden = new JTextField();
		textFieldIden.setBounds(textFieldNum.getX(), identity.getY()+3, Constants.TEXTFIELD_WIDTH_S*2, Constants.TEXTFIELD_HEIGHT);
		add(textFieldIden);
		textFieldIden.setText(driver.getIdNum());
		textFieldIden.setColumns(10);
		
		JLabel mobile = new JLabel("手机");
		mobile.setBounds(this.getWidth()/2+40, driverNum.getY(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(mobile);
		
		textFieldMobile = new JTextField();
		textFieldMobile.setBounds(mobile.getX()+mobile.getWidth(), mobile.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		textFieldMobile.setText(driver.getMobile());
		add(textFieldMobile);
		textFieldMobile.setColumns(10);
		
		JLabel term = new JLabel("行驶证期限");
		term.setBounds(mobile.getX(), mobile.getY()+mobile.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(term);
		
		JLabel labely = new JLabel("由");
		labely.setBounds(textFieldMobile.getX(), term.getY()+8, 19, 15);
		add(labely);
		
		start=new DatePanel();
		start.setBounds(labely.getX()+20, term.getY()+3, Constants.DATE_WIDTH, Constants.DATE_HEIGHT);
		start.setDate(driver.getDriveStart());
		add(start);
		
		JLabel labelz = new JLabel("至");
		labelz.setBounds(textFieldMobile.getX(), term.getY()+30, 19, 15);
		add(labelz);
		
		deadline=new DatePanel();
		deadline.setBounds(labelz.getX()+20, labelz.getY(), Constants.DATE_WIDTH, Constants.DATE_HEIGHT);
		deadline.setDate(driver.getDriveEnd());
		add(deadline);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(this.getWidth()/10*9, this.getHeight()/10*7, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancel);
		
		JButton confirm = new JButton("确认");
		confirm.setBounds(cancel.getX()-Constants.BUTTON_WIDTH-40, cancel.getY(), Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				Gender sex;
				if(comboBoxSex.getSelectedIndex()==0)sex=Gender.MAN;
				else sex=Gender.WOMAN;
				DriverVO newDriver=new DriverVO(textFieldNum.getText(),textFieldName.getText(),born.getCalendar(),textFieldIden.getText(),
						textFieldMobile.getText(),sex,start.getCalendar(),deadline.getCalendar());
				Result result=panel.Modify(newDriver);
				if(!result.equals(Result.SUCCESS))
				{
					new HintFrame(result,frame.getX()+frame.getWidth()/2,frame.getY()+frame.getHeight()/2);
				}
				else frame.dispose();
			}
		});
		add(confirm);
	}
//	public static void main(String[] args){
//		JFrame f=new JFrame();
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setSize(1300,800);
//		//f.setContentPane(new DriverInfoPanel(f,null,new DriverVO("1","制杖",Calendar.getInstance(),"111","321312312312",Gender.WOMAN,Calendar.getInstance(),Calendar.getInstance())));
//		f.setVisible(true);
//	}
}
