package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import edu.nju.umr.ui.DatePanel;

public class ExpressPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 472329397579383210L;
	protected JTextField barcodeField;
	protected JTextField senderField;
	protected JTextField senderLocField;
	protected JTextField sendCompanyField;
	protected JTextField senderMobileField;
	protected JTextField senderPhoneField;
	protected JTextField receiverField;
	protected JTextField receiverLocField;
	protected JTextField receiverCompanyField;
	protected JTextField receiverMobileField;
	protected JTextField receiverPhoneField;
	protected JTextField volumnField;
	protected JTextField weightField;
	protected JTextField nameField;
	protected JFrame frame;
	protected JTextField costField;
	protected JTextField lengthField;
	protected JTextField widthField;
	protected JTextField heightField;
	protected JLabel titleLabel;
	protected JLabel barcodeLabel;
	protected JLabel dateLabel;
	protected JLabel sender;
	protected JLabel senderLabel;
	protected JLabel senderLocLabel;
	protected JLabel senderCompanyLabel;
	protected JLabel senderMobileLabel;
	protected JLabel senderPhoneLabel;
	protected JLabel receiver;
	protected JLabel receiverLabel;
	protected JLabel receiverLocLabel;
	protected JLabel receiverCompanyLabel;
	protected JLabel receiverMobileLabel;
	protected JLabel receiverPhoneLabel;
	protected JLabel goodLabel;
	protected JLabel numLabel;
	protected JSpinner numSpinner;
	protected JLabel volumnLabel;
	protected JLabel cubeMLabel;
	protected JLabel weightLabel;
	protected JLabel kgLabel;
	protected JLabel nameLabel;
	protected JLabel pakKindLabel;
	protected JLabel expressKindLabel;
	protected JLabel lengthLabel;
	protected JLabel mLabelL;
	protected JLabel widthLabel;
	protected JLabel mLabelW;
	protected JLabel heightLabel;
	protected JLabel mLabelH;
	protected DatePanel datePanel;
	protected JComboBox<String> pakKindCombo;
	protected JComboBox<String> expressKindCombo;
	protected JLabel costLabel;
	protected JButton confirmButton;
	protected JButton cancelButton;
	/**
	 * Create the panel.
	 */
	public ExpressPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		titleLabel = new JLabel("订单创建");
		titleLabel.setBounds(437, 21, 120, 35);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		add(titleLabel);
		
		barcodeLabel = new JLabel("订单条形码号");
		barcodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		barcodeLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		barcodeLabel.setBounds(189, 66, 120, 24);
		add(barcodeLabel);
		
		barcodeField = new JTextField();
		barcodeField.setFont(new Font("宋体", Font.PLAIN, 20));
		barcodeField.setColumns(10);
		barcodeField.setBounds(337, 65, 165, 25);
		add(barcodeField);
		
		dateLabel=new JLabel("日期");
		dateLabel.setBounds(620, 66,120, 24);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(670, 66, 500, 24);
		add(datePanel);
		
		sender = new JLabel("寄件人");
		sender.setHorizontalAlignment(SwingConstants.CENTER);
		sender.setFont(new Font("宋体", Font.PLAIN, 20));
		sender.setBounds(84+75, 101, 120, 24);
		add(sender);
		
		senderLabel = new JLabel("姓名");
		senderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderLabel.setBounds(178+75, 135, 120, 24);
		add(senderLabel);
		
		senderField = new JTextField();
		senderField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderField.setColumns(10);
		senderField.setBounds(268+75, 134, 83, 25);
		add(senderField);
		
		senderLocLabel = new JLabel("地址");
		senderLocLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderLocLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderLocLabel.setBounds(378+75, 135, 62, 24);
		add(senderLocLabel);
		
		senderLocField = new JTextField();
		senderLocField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderLocField.setColumns(10);
		senderLocField.setBounds(437+75, 135, 165, 25);
		add(senderLocField);
		
		senderCompanyLabel = new JLabel("单位");
		senderCompanyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderCompanyLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderCompanyLabel.setBounds(615+75, 135, 62, 24);
		add(senderCompanyLabel);
		
		sendCompanyField = new JTextField();
		sendCompanyField.setFont(new Font("宋体", Font.PLAIN, 20));
		sendCompanyField.setColumns(10);
		sendCompanyField.setBounds(676+75, 134, 165, 25);
		add(sendCompanyField);
		
		senderMobileLabel = new JLabel("手机");
		senderMobileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderMobileLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderMobileLabel.setBounds(178+75, 180, 120, 24);
		add(senderMobileLabel);
		
		senderMobileField = new JTextField();
		senderMobileField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderMobileField.setColumns(10);
		senderMobileField.setBounds(268+75, 179, 193, 25);
		add(senderMobileField);
		
		senderPhoneLabel = new JLabel("电话");
		senderPhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderPhoneLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderPhoneLabel.setBounds(510+75, 180, 62, 24);
		add(senderPhoneLabel);
		
		senderPhoneField = new JTextField();
		senderPhoneField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderPhoneField.setColumns(10);
		senderPhoneField.setBounds(567+75, 179, 216, 25);
		add(senderPhoneField);
		
		receiver = new JLabel("收件人");
		receiver.setHorizontalAlignment(SwingConstants.CENTER);
		receiver.setFont(new Font("宋体", Font.PLAIN, 20));
		receiver.setBounds(84+75, 214, 120, 24);
		add(receiver);
		
		receiverLabel = new JLabel("姓名");
		receiverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverLabel.setBounds(178+75, 248, 120, 24);
		add(receiverLabel);
		
		receiverField = new JTextField();
		receiverField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverField.setColumns(10);
		receiverField.setBounds(268+75, 247, 83, 25);
		add(receiverField);
		
		receiverLocLabel = new JLabel("地址");
		receiverLocLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverLocLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverLocLabel.setBounds(378+75, 248, 62, 24);
		add(receiverLocLabel);
		
		receiverLocField = new JTextField();
		receiverLocField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverLocField.setColumns(10);
		receiverLocField.setBounds(437+75, 248, 165, 25);
		add(receiverLocField);
		
		receiverCompanyLabel = new JLabel("单位");
		receiverCompanyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverCompanyLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverCompanyLabel.setBounds(615+75, 248, 62, 24);
		add(receiverCompanyLabel);
		
		receiverCompanyField = new JTextField();
		receiverCompanyField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverCompanyField.setColumns(10);
		receiverCompanyField.setBounds(676+75, 248, 165, 25);
		add(receiverCompanyField);
		
		receiverMobileLabel = new JLabel("手机");
		receiverMobileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverMobileLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverMobileLabel.setBounds(178+75, 294, 120, 24);
		add(receiverMobileLabel);
		
		receiverMobileField = new JTextField();
		receiverMobileField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverMobileField.setColumns(10);
		receiverMobileField.setBounds(268+75, 293, 193, 25);
		add(receiverMobileField);
		
		receiverPhoneLabel = new JLabel("电话");
		receiverPhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverPhoneLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverPhoneLabel.setBounds(510+75, 294, 62, 24);
		add(receiverPhoneLabel);
		
		receiverPhoneField = new JTextField();
		receiverPhoneField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverPhoneField.setColumns(10);
		receiverPhoneField.setBounds(567+75, 293, 216, 25);
		add(receiverPhoneField);
		
		goodLabel = new JLabel("货物信息");
		goodLabel.setHorizontalAlignment(SwingConstants.CENTER);
		goodLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		goodLabel.setBounds(84+75, 328, 120, 24);
		add(goodLabel);
		
		numLabel = new JLabel("件数");
		numLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		numLabel.setBounds(178+75, 362, 120, 24);
		add(numLabel);
		
		numSpinner = new JSpinner();
		numSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		numSpinner.setFont(new Font("宋体", Font.PLAIN, 20));
		numSpinner.setBounds(268+75, 362, 48, 26);
		add(numSpinner);
		
		volumnLabel = new JLabel("体积");
		volumnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		volumnLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		volumnLabel.setBounds(724, 362, 62, 24);
		add(volumnLabel);
		
		volumnField = new JTextField();
		volumnField.setEditable(false);
		volumnField.setFont(new Font("宋体", Font.PLAIN, 20));
		volumnField.setColumns(10);
		volumnField.setBounds(779, 362, 50, 25);
		add(volumnField);
		
		cubeMLabel = new JLabel("m³");
		cubeMLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cubeMLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		cubeMLabel.setBounds(833, 362, 41, 24);
		add(cubeMLabel);
		
		weightLabel = new JLabel("重量");
		weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weightLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		weightLabel.setBounds(854, 362, 62, 25);
		add(weightLabel);
		
		weightField = new JTextField();
		weightField.setFont(new Font("宋体", Font.PLAIN, 20));
		weightField.setColumns(10);
		weightField.setBounds(914, 362, 50, 25);
		add(weightField);
		
		kgLabel = new JLabel("kg");
		kgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		kgLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		kgLabel.setBounds(962, 362, 41, 24);
		add(kgLabel);
		
		nameLabel = new JLabel("内件品名");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		nameLabel.setBounds(271, 412, 120, 24);
		add(nameLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("宋体", Font.PLAIN, 20));
		nameField.setColumns(10);
		nameField.setBounds(389, 411, 193, 25);
		add(nameField);
		
		pakKindLabel = new JLabel("包装种类");
		pakKindLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pakKindLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		pakKindLabel.setBounds(271, 448, 120, 24);
		add(pakKindLabel);
		
		pakKindCombo = new JComboBox<String>();
		pakKindCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"纸箱", "木箱", "快递袋"}));
		pakKindCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		pakKindCombo.setBounds(389, 448, 103, 25);
		add(pakKindCombo);
		
		expressKindLabel = new JLabel("快递种类");
		expressKindLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressKindLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		expressKindLabel.setBounds(512, 448, 120, 24);
		add(expressKindLabel);
		
		expressKindCombo = new JComboBox<String>();
		expressKindCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"经济快递", "标准快递", "特快专递"}));
		expressKindCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		expressKindCombo.setBounds(629, 448, 123, 25);
		add(expressKindCombo);
		
		costLabel = new JLabel("费用：");
		costLabel.setHorizontalAlignment(SwingConstants.LEFT);
		costLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		costLabel.setBounds(779, 448, 83, 24);
		add(costLabel);
		
		confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(416, 497, 93, 23);
		add(confirmButton);
		
		cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(636, 497, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancelButton);
		
		costField = new JTextField();
		costField.setEditable(false);
		costField.setBounds(836, 448, 66, 21);
		add(costField);
		costField.setColumns(10);
		
		lengthLabel = new JLabel("长");
		lengthLabel.setBounds(408, 362, 41, 24);
		lengthLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		add(lengthLabel);
		
		lengthField = new JTextField();
		lengthField.setBounds(442, 362, 50, 25);
		add(lengthField);
		lengthField.setColumns(10);
		
		mLabelL = new JLabel("m");
		mLabelL.setBounds(503, 362, 32, 24);
		mLabelL.setFont(new Font("宋体", Font.PLAIN, 20));
		add(mLabelL);
		
		widthLabel = new JLabel("宽");
		widthLabel.setBounds(520, 362, 62, 24);
		widthLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		add(widthLabel);
		
		widthField = new JTextField();
		widthField.setBounds(549, 362, 50, 25);
		add(widthField);
		widthField.setColumns(10);
		
		mLabelW = new JLabel("m");
		mLabelW.setBounds(609, 362, 32, 24);
		mLabelW.setFont(new Font("宋体", Font.PLAIN, 20));
		add(mLabelW);
		
		heightLabel = new JLabel("高");
		heightLabel.setBounds(625, 362, 62, 24);
		heightLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		add(heightLabel);
		
		heightField = new JTextField();
		heightField.setBounds(651, 362, 50, 25);
		add(heightField);
		heightField.setColumns(10);
		
		mLabelH = new JLabel("m");
		mLabelH.setBounds(711, 362, 41, 24);
		mLabelH.setFont(new Font("宋体", Font.PLAIN, 20));
		add(mLabelH);

	}
	

}
