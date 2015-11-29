package edu.nju.umr.ui.transitInfoUI;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import edu.nju.umr.ui.DatePanel;

public class ExpressInfoInqPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6608025281059459114L;
	private JTextField barcodeField;
	private JTextField senderNameField;
	private JTextField senderLocField;
	private JTextField senderCompanyField;
	private JTextField senderMobileField;
	private JTextField senderPhoneField;
	private JTextField receiverNameField;
	private JTextField receiverLocField;
	private JTextField receiverCompanyField;
	private JTextField receiverMobileField;
	private JTextField receiverPhoneField;
	private JTextField costField;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JFrame frame;
	private DatePanel datePanel;

	/**
	 * Create the panel.
	 */
	public ExpressInfoInqPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		JLabel titleLabel = new JLabel("订单查询");
		titleLabel.setBounds(537, 21, 120, 35);
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
		datePanel.setEnabled(false);
		add(datePanel);
		
		JLabel senderLabel = new JLabel("寄件人");
		senderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderLabel.setBounds(84+75, 101, 120, 24);
		add(senderLabel);
		
		JLabel senderNameLabel = new JLabel("姓名");
		senderNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderNameLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderNameLabel.setBounds(178+75, 135, 120, 24);
		add(senderNameLabel);
		
		senderNameField = new JTextField();
		senderNameField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderNameField.setColumns(10);
		senderNameField.setBounds(268+75, 134, 83, 25);
		add(senderNameField);
		
		JLabel senderLocLabel = new JLabel("住址");
		senderLocLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderLocLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderLocLabel.setBounds(378+75, 135, 62, 24);
		add(senderLocLabel);
		
		senderLocField = new JTextField();
		senderLocField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderLocField.setColumns(10);
		senderLocField.setBounds(437+75, 135, 165, 25);
		add(senderLocField);
		
		JLabel senderCompanyLabel = new JLabel("单位");
		senderCompanyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderCompanyLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderCompanyLabel.setBounds(615+75, 135, 62, 24);
		add(senderCompanyLabel);
		
		senderCompanyField = new JTextField();
		senderCompanyField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderCompanyField.setColumns(10);
		senderCompanyField.setBounds(676+75, 134, 165, 25);
		add(senderCompanyField);
		
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
		
		JLabel receiverLabel = new JLabel("收件人");
		receiverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverLabel.setBounds(84+75, 214, 120, 24);
		add(receiverLabel);
		
		JLabel receiverNameLabel = new JLabel("姓名");
		receiverNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverNameLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverNameLabel.setBounds(178+75, 248, 120, 24);
		add(receiverNameLabel);
		
		receiverNameField = new JTextField();
		receiverNameField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverNameField.setColumns(10);
		receiverNameField.setBounds(268+75, 247, 83, 25);
		add(receiverNameField);
		
		JLabel receiveLocLabel = new JLabel("住址");
		receiveLocLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiveLocLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiveLocLabel.setBounds(378+75, 248, 62, 24);
		add(receiveLocLabel);
		
		receiverLocField = new JTextField();
		receiverLocField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverLocField.setColumns(10);
		receiverLocField.setBounds(437+75, 248, 165, 25);
		add(receiverLocField);
		
		JLabel receiverCompanyLabel = new JLabel("单位");
		receiverCompanyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverCompanyLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverCompanyLabel.setBounds(615+75, 248, 62, 24);
		add(receiverCompanyLabel);
		
		receiverCompanyField = new JTextField();
		receiverCompanyField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverCompanyField.setColumns(10);
		receiverCompanyField.setBounds(676+75, 248, 165, 25);
		add(receiverCompanyField);
		
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
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner.setBounds(268+75, 362, 48, 26);
		spinner.setEnabled(false);
		add(spinner);
		
		JLabel label_16 = new JLabel("体积");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setFont(new Font("宋体", Font.PLAIN, 20));
		label_16.setBounds(335+75, 362, 62, 24);
		add(label_16);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_11.setColumns(10);
		textField_11.setBounds(397+75, 362, 41, 25);
		add(textField_11);
		
		JLabel lblM = new JLabel("m³");
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setFont(new Font("宋体", Font.PLAIN, 20));
		lblM.setBounds(437+75, 362, 41, 24);
		add(lblM);
		
		JLabel label_17 = new JLabel("重量");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setFont(new Font("宋体", Font.PLAIN, 20));
		label_17.setBounds(479+75, 362, 62, 24);
		add(label_17);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_12.setColumns(10);
		textField_12.setBounds(531+75, 361, 41, 25);
		add(textField_12);
		
		JLabel lblKg = new JLabel("kg");
		lblKg.setHorizontalAlignment(SwingConstants.CENTER);
		lblKg.setFont(new Font("宋体", Font.PLAIN, 20));
		lblKg.setBounds(567+75, 362, 41, 24);
		add(lblKg);
		
		JLabel label_18 = new JLabel("内件品名");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setFont(new Font("宋体", Font.PLAIN, 20));
		label_18.setBounds(597+75, 362, 120, 24);
		add(label_18);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_13.setColumns(10);
		textField_13.setBounds(704+75, 361, 193, 25);
		add(textField_13);
		
		JLabel label_19 = new JLabel("包装种类");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setFont(new Font("宋体", Font.PLAIN, 20));
		label_19.setBounds(196+75, 411, 120, 24);
		add(label_19);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"纸箱", "木箱", "快递袋"}));
		comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox.setBounds(314+75, 411, 103, 25);
		comboBox.setEnabled(false);
		add(comboBox);
		
		JLabel label_20 = new JLabel("快递种类");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setFont(new Font("宋体", Font.PLAIN, 20));
		label_20.setBounds(437+75, 411, 120, 24);
		add(label_20);
		
		JComboBox<String> expressKind = new JComboBox<String>();
		expressKind.setModel(new DefaultComboBoxModel<String>(new String[] {"经济快递", "标准快递", "特快专递"}));
		expressKind.setFont(new Font("宋体", Font.PLAIN, 20));
		expressKind.setBounds(554+75, 411, 123, 25);
		expressKind.setEnabled(false);
		add(expressKind);
		
		JLabel costLabel = new JLabel("费用：");
		costLabel.setHorizontalAlignment(SwingConstants.LEFT);
		costLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		costLabel.setBounds(704+75, 411, 120, 24);
		add(costLabel);
		
		costField = new JTextField();
		costField.setEditable(false);
		costField.setBounds(836, 411, 66, 21);
		add(costField);
		costField.setColumns(10);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(525, 66, 80, 23);
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(537, 484, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancelButton);
		
		senderNameField.setEnabled(false);
		senderLocField.setEnabled(false);
		senderCompanyField.setEnabled(false);
		senderMobileField.setEnabled(false);
		senderPhoneField.setEnabled(false);
		receiverNameField.setEnabled(false);
		receiverLocField.setEnabled(false);
		receiverCompanyField.setEnabled(false);
		receiverMobileField.setEnabled(false);
		receiverPhoneField.setEnabled(false);
		textField_11.setEnabled(false);
		textField_12.setEnabled(false);
		textField_13.setEnabled(false);
		

	}
	
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setSize(1200,800);
		frame.setContentPane(new ExpressInfoInqPanel(frame));
		frame.setVisible(true);
	}

}
