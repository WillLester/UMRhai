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
	private JTextField barcodeField;
	private JTextField senderField;
	private JTextField senderLocField;
	private JTextField sendUnitField;
	private JTextField senderMobileField;
	private JTextField senderPhoneField;
	private JTextField receiverField;
	private JTextField receiverLocField;
	private JTextField receiverUnitField;
	private JTextField receiverMobileField;
	private JTextField receiverPhoneField;
	private JTextField volumnField;
	private JTextField weightField;
	private JTextField nameField;
	private JFrame frame;
	private JTextField costField;
	private JTextField lengthField;
	private JTextField widthField;
	private JTextField heightField;
	
	private DatePanel datePanel;
	/**
	 * Create the panel.
	 */
	public ExpressPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		JLabel titleLabel = new JLabel("订单创建");
		titleLabel.setBounds(437, 21, 120, 35);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		add(titleLabel);
		
		JLabel barcodeLabel = new JLabel("订单条形码号");
		barcodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		barcodeLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		barcodeLabel.setBounds(189, 66, 120, 24);
		add(barcodeLabel);
		
		barcodeField = new JTextField();
		barcodeField.setFont(new Font("宋体", Font.PLAIN, 20));
		barcodeField.setColumns(10);
		barcodeField.setBounds(337, 65, 165, 25);
		add(barcodeField);
		
		JLabel date=new JLabel("日期");
		date.setBounds(620, 66,120, 24);
		date.setFont(new Font("宋体", Font.PLAIN, 20));
		add(date);
		
		datePanel = new DatePanel();
		datePanel.setBounds(670, 66, 500, 24);
		add(datePanel);
		
		JLabel sender = new JLabel("寄件人");
		sender.setHorizontalAlignment(SwingConstants.CENTER);
		sender.setFont(new Font("宋体", Font.PLAIN, 20));
		sender.setBounds(84+75, 101, 120, 24);
		add(sender);
		
		JLabel senderLabel = new JLabel("姓名");
		senderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderLabel.setBounds(178+75, 135, 120, 24);
		add(senderLabel);
		
		senderField = new JTextField();
		senderField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderField.setColumns(10);
		senderField.setBounds(268+75, 134, 83, 25);
		add(senderField);
		
		JLabel senderLocLabel = new JLabel("地址");
		senderLocLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderLocLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderLocLabel.setBounds(378+75, 135, 62, 24);
		add(senderLocLabel);
		
		senderLocField = new JTextField();
		senderLocField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderLocField.setColumns(10);
		senderLocField.setBounds(437+75, 135, 165, 25);
		add(senderLocField);
		
		JLabel senderUnitLabel = new JLabel("单位");
		senderUnitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderUnitLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderUnitLabel.setBounds(615+75, 135, 62, 24);
		add(senderUnitLabel);
		
		sendUnitField = new JTextField();
		sendUnitField.setFont(new Font("宋体", Font.PLAIN, 20));
		sendUnitField.setColumns(10);
		sendUnitField.setBounds(676+75, 134, 165, 25);
		add(sendUnitField);
		
		JLabel senderMobileLabel = new JLabel("手机");
		senderMobileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderMobileLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderMobileLabel.setBounds(178+75, 180, 120, 24);
		add(senderMobileLabel);
		
		senderMobileField = new JTextField();
		senderMobileField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderMobileField.setColumns(10);
		senderMobileField.setBounds(268+75, 179, 193, 25);
		add(senderMobileField);
		
		JLabel senderPhoneLabel = new JLabel("电话");
		senderPhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderPhoneLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderPhoneLabel.setBounds(510+75, 180, 62, 24);
		add(senderPhoneLabel);
		
		senderPhoneField = new JTextField();
		senderPhoneField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderPhoneField.setColumns(10);
		senderPhoneField.setBounds(567+75, 179, 216, 25);
		add(senderPhoneField);
		
		JLabel receiver = new JLabel("收件人");
		receiver.setHorizontalAlignment(SwingConstants.CENTER);
		receiver.setFont(new Font("宋体", Font.PLAIN, 20));
		receiver.setBounds(84+75, 214, 120, 24);
		add(receiver);
		
		JLabel receiverLabel = new JLabel("姓名");
		receiverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverLabel.setBounds(178+75, 248, 120, 24);
		add(receiverLabel);
		
		receiverField = new JTextField();
		receiverField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverField.setColumns(10);
		receiverField.setBounds(268+75, 247, 83, 25);
		add(receiverField);
		
		JLabel receiverLocLabel = new JLabel("地址");
		receiverLocLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverLocLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverLocLabel.setBounds(378+75, 248, 62, 24);
		add(receiverLocLabel);
		
		receiverLocField = new JTextField();
		receiverLocField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverLocField.setColumns(10);
		receiverLocField.setBounds(437+75, 248, 165, 25);
		add(receiverLocField);
		
		JLabel receiverUnitLabel = new JLabel("单位");
		receiverUnitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverUnitLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverUnitLabel.setBounds(615+75, 248, 62, 24);
		add(receiverUnitLabel);
		
		receiverUnitField = new JTextField();
		receiverUnitField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverUnitField.setColumns(10);
		receiverUnitField.setBounds(676+75, 248, 165, 25);
		add(receiverUnitField);
		
		JLabel receiverMobileLabel = new JLabel("手机");
		receiverMobileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverMobileLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverMobileLabel.setBounds(178+75, 294, 120, 24);
		add(receiverMobileLabel);
		
		receiverMobileField = new JTextField();
		receiverMobileField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverMobileField.setColumns(10);
		receiverMobileField.setBounds(268+75, 293, 193, 25);
		add(receiverMobileField);
		
		JLabel receiverPhoneLabel = new JLabel("电话");
		receiverPhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverPhoneLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverPhoneLabel.setBounds(510+75, 294, 62, 24);
		add(receiverPhoneLabel);
		
		receiverPhoneField = new JTextField();
		receiverPhoneField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverPhoneField.setColumns(10);
		receiverPhoneField.setBounds(567+75, 293, 216, 25);
		add(receiverPhoneField);
		
		JLabel goodLabel = new JLabel("货物信息");
		goodLabel.setHorizontalAlignment(SwingConstants.CENTER);
		goodLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		goodLabel.setBounds(84+75, 328, 120, 24);
		add(goodLabel);
		
		JLabel numLabel = new JLabel("件数");
		numLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		numLabel.setBounds(178+75, 362, 120, 24);
		add(numLabel);
		
		JSpinner numSpinner = new JSpinner();
		numSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		numSpinner.setFont(new Font("宋体", Font.PLAIN, 20));
		numSpinner.setBounds(268+75, 362, 48, 26);
		add(numSpinner);
		
		JLabel volumnLabel = new JLabel("体积");
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
		
		JLabel cubeMLabel = new JLabel("m³");
		cubeMLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cubeMLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		cubeMLabel.setBounds(833, 362, 41, 24);
		add(cubeMLabel);
		
		JLabel weightLabel = new JLabel("重量");
		weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weightLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		weightLabel.setBounds(854, 362, 62, 25);
		add(weightLabel);
		
		weightField = new JTextField();
		weightField.setFont(new Font("宋体", Font.PLAIN, 20));
		weightField.setColumns(10);
		weightField.setBounds(914, 362, 50, 25);
		add(weightField);
		
		JLabel kgLabel = new JLabel("kg");
		kgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		kgLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		kgLabel.setBounds(962, 362, 41, 24);
		add(kgLabel);
		
		JLabel nameLabel = new JLabel("内件品名");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		nameLabel.setBounds(271, 412, 120, 24);
		add(nameLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("宋体", Font.PLAIN, 20));
		nameField.setColumns(10);
		nameField.setBounds(389, 411, 193, 25);
		add(nameField);
		
		JLabel pakKindLabel = new JLabel("包装种类");
		pakKindLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pakKindLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		pakKindLabel.setBounds(271, 448, 120, 24);
		add(pakKindLabel);
		
		JComboBox<String> pakKindCombo = new JComboBox<String>();
		pakKindCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"纸箱", "木箱", "快递袋"}));
		pakKindCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		pakKindCombo.setBounds(389, 448, 103, 25);
		add(pakKindCombo);
		
		JLabel expressKindLabel = new JLabel("快递种类");
		expressKindLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressKindLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		expressKindLabel.setBounds(512, 448, 120, 24);
		add(expressKindLabel);
		
		JComboBox<String> expressKindCombo = new JComboBox<String>();
		expressKindCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"经济快递", "标准快递", "特快专递"}));
		expressKindCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		expressKindCombo.setBounds(629, 448, 123, 25);
		add(expressKindCombo);
		
		JLabel costLabel = new JLabel("费用：");
		costLabel.setHorizontalAlignment(SwingConstants.LEFT);
		costLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		costLabel.setBounds(779, 448, 83, 24);
		add(costLabel);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(416, 497, 93, 23);
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
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
		
		JLabel lengthLabel = new JLabel("长");
		lengthLabel.setBounds(408, 362, 41, 24);
		lengthLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		add(lengthLabel);
		
		lengthField = new JTextField();
		lengthField.setBounds(442, 362, 50, 25);
		add(lengthField);
		lengthField.setColumns(10);
		
		JLabel mLabelL = new JLabel("m");
		mLabelL.setBounds(503, 362, 32, 24);
		mLabelL.setFont(new Font("宋体", Font.PLAIN, 20));
		add(mLabelL);
		
		JLabel widthLabel = new JLabel("宽");
		widthLabel.setBounds(520, 362, 62, 24);
		widthLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		add(widthLabel);
		
		widthField = new JTextField();
		widthField.setBounds(549, 362, 50, 25);
		add(widthField);
		widthField.setColumns(10);
		
		JLabel mLabelW = new JLabel("m");
		mLabelW.setBounds(609, 362, 32, 24);
		mLabelW.setFont(new Font("宋体", Font.PLAIN, 20));
		add(mLabelW);
		
		JLabel heightLabel = new JLabel("高");
		heightLabel.setBounds(625, 362, 62, 24);
		heightLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		add(heightLabel);
		
		heightField = new JTextField();
		heightField.setBounds(651, 362, 50, 25);
		add(heightField);
		heightField.setColumns(10);
		
		JLabel mLabelH = new JLabel("m");
		mLabelH.setBounds(711, 362, 41, 24);
		mLabelH.setFont(new Font("宋体", Font.PLAIN, 20));
		add(mLabelH);

	}
	
//	public static void main(String[] args)
//	{
//		JFrame frame=new JFrame();
//		frame.setSize(1200,800);
//		frame.setContentPane(new ExpressPanel(frame));
//		frame.setVisible(true);
//	}
	

}
