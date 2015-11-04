package edu.nju.umr.ui.workOrgManUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.checkUI.DatePanel;

public class VanInfoPanel extends JPanel {
	private JTextField textFieldNum;
	private JTextField textFieldPlate;

	/**
	 * Create the panel.
	 */
	public VanInfoPanel() {
		this.setSize(Constants.INFO_WIDTH,Constants.INFO_HEIGHT);
		setLayout(null);
		
		JLabel nameLabel = new JLabel("车辆信息");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		JLabel vanNum = new JLabel("车辆代号");
		vanNum.setBounds(Constants.INFOTABLE_X, Constants.INFOTABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(vanNum);
		
		textFieldNum = new JTextField();
		textFieldNum.setBounds(vanNum.getX()+vanNum.getWidth(), vanNum.getY(), Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldNum);
		textFieldNum.setColumns(10);
		
		JLabel plateNum = new JLabel("车牌号");
		plateNum.setBounds(vanNum.getX(), vanNum.getY()+vanNum.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(plateNum);
		
		textFieldPlate = new JTextField();
		textFieldPlate.setBounds(textFieldNum.getX(), plateNum.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldPlate);
		textFieldPlate.setColumns(10);
		
		JLabel workTime = new JLabel("服役时间");
		workTime.setBounds(vanNum.getX(), plateNum.getY()+plateNum.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(workTime);
		
		JLabel labely = new JLabel("由");
		labely.setBounds(textFieldNum.getX(), workTime.getY()+8, 19, 15);
		add(labely);
		
		DatePanel start=new DatePanel();
		start.setBounds(labely.getX()+20, workTime.getY()+3, Constants.DATE_WIDTH, Constants.DATE_HEIGHT);
		add(start);
		
		JLabel labelz = new JLabel("至");
		labelz.setBounds(labely.getX(), labely.getY()+30, 19, 15);
		add(labelz);
		
		DatePanel end=new DatePanel();
		end.setBounds(labelz.getX()+20, labelz.getY()+3, Constants.DATE_WIDTH, Constants.DATE_HEIGHT);
		add(end);
		
		JLabel picture = new JLabel("车辆图片");
		picture.setBounds(vanNum.getX(), labelz.getY()+20+40, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(picture);
		
		JLabel pic = new JLabel("图片label");
		pic.setBounds(textFieldNum.getX(), picture.getY(), 350, 180);
		add(pic);
		
		JButton upload = new JButton("上传");
		upload.setBounds(pic.getX()+pic.getWidth()-100, pic.getY()+pic.getHeight()+15, 93, 23);
		add(upload);
		
		JButton confirm = new JButton("确定");
		confirm.setBounds(upload.getX()+200, upload.getY(), 93, 23);
		add(confirm);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(confirm.getX()+confirm.getWidth()+50, confirm.getY(), 93, 23);
		add(cancel);
		
		
	}

}
