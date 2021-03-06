package edu.nju.umr.ui.workOrgManUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.nju.umr.po.enums.Gender;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.InfoPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.Utils;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.DriverVO;

public class DriverInfoPanel extends InfoPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2610622329584659171L;
	private JTextField textFieldNum;
	private JTextField textFieldName;
	private JTextField textFieldIden;
	private JTextField textFieldMobile;
	private JFrame frame;
	private DriverListPanel panel;
	private JComboBox<String> comboBoxSex;
	private DatePanel born;
	private DatePanel start;
	private DatePanel deadline;
	private static final int y=35;
	/**
	 * Create the panel.
	 */
	public DriverInfoPanel(JFrame fr,DriverListPanel pa,DriverVO driver,String orgId) {
		setLayout(null);
		frame=fr;
		panel=pa;
		this.setSize(Constants.INFO_WIDTH,Constants.INFO_HEIGHT);
		
		TitleLabel nameLabel = new TitleLabel("司机信息");
		nameLabel.setLocation(995/2-nameLabel.getWidth()/2+50,nameLabel.getY());;
		add(nameLabel);
		
		UMRLabel driverNum = new UMRLabel("司机编号");
		driverNum.setFont(Utils.COMBO_FONT);
		driverNum.setForeground(Utils.STD_COLOR);
		driverNum.setBounds(Constants.INFOTABLE_X, y+Constants.INFOTABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(driverNum);
		
		textFieldNum = new TextField();
		textFieldNum.setBounds(driverNum.getX()+driverNum.getWidth(), driverNum.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldNum);
		textFieldNum.setEditable(false);
		textFieldNum.setText(driver.getId());
		textFieldNum.setColumns(10);
		
		JLabel driverName = new UMRLabel("姓名");
		driverName.setFont(Utils.COMBO_FONT);
		driverName.setForeground(Utils.STD_COLOR);
		driverName.setBounds(driverNum.getX(), driverNum.getY()+driverNum.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(driverName);
		
		textFieldName = new TextField();
		textFieldName.setBounds(textFieldNum.getX(), driverName.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldName);
		textFieldName.setText(driver.getName());
		textFieldName.setColumns(10);
		
		JLabel driverSex = new UMRLabel("性别");
		driverSex.setFont(Utils.COMBO_FONT);
		driverSex.setForeground(Utils.STD_COLOR);
		driverSex.setBounds(driverNum.getX(), driverName.getY()+driverName.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(driverSex);
		
		comboBoxSex = new UMRComboBox<String>();
		comboBoxSex.setBounds(textFieldNum.getX(), driverSex.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		comboBoxSex.setModel(new DefaultComboBoxModel<String>(new String[]{"男","女"}));
		if(driver.getSex().equals(Gender.MAN))
		comboBoxSex.setSelectedIndex(0);
		else comboBoxSex.setSelectedIndex(1);
		add(comboBoxSex);
		
		JLabel bornDate = new JLabel("出生日期");
		bornDate.setFont(Utils.COMBO_FONT);
		bornDate.setForeground(Utils.STD_COLOR);
		bornDate.setBounds(driverNum.getX(), driverSex.getY()+driverSex.getHeight()+30,Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(bornDate);
		
		born=new DatePanel();
		born.setBounds(textFieldNum.getX(), bornDate.getY()+3,Constants.DATE_WIDTH, Constants.DATE_HEIGHT);
		born.setDate(driver.getBirthday());
		add(born);
		
		JLabel identity = new JLabel("身份证号");
		identity.setFont(Utils.COMBO_FONT);
		identity.setForeground(Utils.STD_COLOR);
		identity.setBounds(driverNum.getX(), bornDate.getY()+bornDate.getHeight()+30,Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(identity);
		
		textFieldIden = new TextField();
		textFieldIden.setBounds(textFieldNum.getX(), identity.getY()+3, Constants.TEXTFIELD_WIDTH_S*2, Constants.TEXTFIELD_HEIGHT);
		add(textFieldIden);
		textFieldIden.setText(driver.getIdNum());
		textFieldIden.setColumns(10);
		
		JLabel mobile = new JLabel("手机");
		mobile.setFont(Utils.COMBO_FONT);
		mobile.setForeground(Utils.STD_COLOR);
		mobile.setBounds(this.getWidth()/2+40, driverNum.getY(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(mobile);
		
		textFieldMobile = new TextField();
		textFieldMobile.setBounds(mobile.getX()+mobile.getWidth(), mobile.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		textFieldMobile.setText(driver.getMobile());
		add(textFieldMobile);
		textFieldMobile.setColumns(10);
		
		JLabel term = new JLabel("行驶证期限");
		term.setFont(Utils.COMBO_FONT);
		term.setForeground(Utils.STD_COLOR);
		term.setBounds(mobile.getX(), mobile.getY()+mobile.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(term);
		
		JLabel labely = new JLabel("由");
		labely.setFont(Utils.COMBO_FONT);
		labely.setForeground(Utils.STD_COLOR);
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
		
		Button cancel = new CanButton();
		cancel.setBounds(this.getWidth()/10*9-100, this.getHeight()/10*7, 100, 30);
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancel);
		
		Button confirm = new ConfirmButton();
		confirm.setBounds(cancel.getX()-Constants.BUTTON_WIDTH-40, cancel.getY(),100, 30);
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Gender sex;
				if(comboBoxSex.getSelectedIndex()==0)sex=Gender.MAN;
				else sex=Gender.WOMAN;
				
				if(checked()){
					DriverVO newDriver=new DriverVO(textFieldNum.getText(),textFieldName.getText(),born.getCalendar(),textFieldIden.getText(),
						textFieldMobile.getText(),sex,start.getCalendar(),deadline.getCalendar(),orgId);
					Result result=panel.Modify(newDriver);
					DoHint.hint(result, frame,true);
					if(result.equals(Result.SUCCESS)){
						confirm.setEnabled(false);
					}
				}
			}
		});
		add(confirm);
	}
	 private boolean checked(){
		 boolean passed=true;
			String num=textFieldNum.getText();
			String name=textFieldName.getText();
			String idNum=textFieldIden.getText();
			String mobile=textFieldMobile.getText();
			if(num.isEmpty()){
				passed=false;
				new HintFrame("司机编号未输入！",frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
				return passed;
				
			}
			for(int i=0;i<num.length();i++){
				if(!(num.charAt(i)>='0'&&num.charAt(i)<='9')){
					passed=false;
					new HintFrame("司机编号含有非数字字符！",frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
					return passed;
				}
			}
			if(name.isEmpty()){
				passed=false;
				new HintFrame("司机姓名未输入！",frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
				return passed;
				
			}
			if(idNum.isEmpty()){
				passed=false;
				new HintFrame("身份证号未输入！",frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
				return passed;
				
			}
			if(idNum.length()!=15&&idNum.length()!=18){
				passed=false;
				new HintFrame("身份证号格式错误！",frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
				return passed;
			}
			for(int i=0;i<idNum.length();i++){
				if(!((idNum.charAt(i)>='0'&&idNum.charAt(i)<='9')||(idNum.charAt(i)!='x'&&idNum.charAt(i)!='X'))){
					passed=false;
					new HintFrame("司机编号含有非法字符！",frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
					return passed;
				}
			}
			if(mobile.isEmpty()){
				passed=false;
				new HintFrame("手机号未输入！",frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
				return passed;
				
			}
			for(int i=0;i<mobile.length();i++){
				if(!(mobile.charAt(i)>='0'&&mobile.charAt(i)<='9')){
					passed=false;
					new HintFrame("手机号含有非数字字符！",frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
					return passed;
				}
			}
			if(start.getCalendar().after(deadline.getCalendar())){
				passed=false;
				new HintFrame("行驶期限错误！",frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
				return passed;
			}
		 return passed;
	 }
	 
}
