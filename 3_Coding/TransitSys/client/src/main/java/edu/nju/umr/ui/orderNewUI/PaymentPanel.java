package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.logic.orderNewLogic.PaymentOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.PaymentOrderLSer;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.utility.Utility;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;
import edu.nju.umr.vo.order.PaymentVO;

public class PaymentPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3000345225479799005L;
	private JTextField payerField;
	private JTextField costField;
	private JFrame frame;
	private DatePanel datePanel;
	private String[] accountList;
	private PaymentOrderLSer logicSer;
	private UserVO user;
	private JComboBox<String> accountCombo;
	private JComboBox<String> reasonCombo;
	private JTextArea remarkArea;
	/**
	 * Create the panel.
	 */
	public PaymentPanel(JFrame fr,UserVO user) {
		setLayout(null);
		frame=fr;
		this.user = user;
		logicSer = new PaymentOrderLogic();
		
		JLabel titleLabel = new JLabel("付款单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setBounds(392, 10, 243, 67);
		add(titleLabel);
		
		JLabel dateLabel = new JLabel("付款日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dateLabel.setBounds(286, 98, 120, 24);
		add(dateLabel);	
		
		JLabel payerLabel = new JLabel("付款人");
		payerLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		payerLabel.setBounds(235, 175, 85, 24);
		add(payerLabel);
		
		payerField = new JTextField();
		payerField.setFont(new Font("宋体", Font.PLAIN, 20));
		payerField.setColumns(10);
		payerField.setBounds(302, 174, 85, 25);
		add(payerField);
		
		JLabel amountLabel = new JLabel("付款金额");
		amountLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		amountLabel.setBounds(397, 175, 85, 24);
		add(amountLabel);
		
		costField = new JTextField();
		costField.setFont(new Font("宋体", Font.PLAIN, 20));
		costField.setColumns(10);
		costField.setBounds(487, 174, 85, 25);
		add(costField);
		
		JLabel remarkLabel = new JLabel("备注");
		remarkLabel.setHorizontalAlignment(SwingConstants.CENTER);
		remarkLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		remarkLabel.setBounds(429, 291, 130, 24);
		add(remarkLabel);
		
		JLabel accountLabel = new JLabel("付款账号");
		accountLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		accountLabel.setBounds(597, 175, 85, 24);
		add(accountLabel);
		
		remarkArea = new JTextArea();
		remarkArea.setBounds(274, 325, 435, 154);
		add(remarkArea);
		
		JLabel reasonLabel = new JLabel("条目");
		reasonLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		reasonLabel.setBounds(437, 237, 59, 24);
		add(reasonLabel);
		
		reasonCombo = new JComboBox<String>();
		reasonCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		reasonCombo.setModel(new DefaultComboBoxModel<String>(new String[]{"租金/年","运费/次","工资/月","奖励"}));
		reasonCombo.setBounds(499, 237, 87, 25);
		add(reasonCombo);
		
		datePanel=new DatePanel();
		datePanel.setBounds(474, 98, 285, 26);
		add(datePanel);
		
		getAccount();
		accountCombo = new JComboBox<String>();
		accountCombo.setBounds(692, 175, 111, 21);
		accountCombo.setModel(new DefaultComboBoxModel<String>(accountList));
		add(accountCombo);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(342, 499, 93, 23);
		confirmButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					Result result = logicSer.create(createVO());
					if(result.equals(Result.SUCCESS)){
						
					} else {
						HintFrame hint = new HintFrame(result, frame.getX(), frame.getY());
					}
				}
			}
		});
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(542, 499, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancelButton);
		
		

	}
	private void getAccount(){
		ResultMessage result = logicSer.getAccount();
		if(result.getReInfo().equals(Result.SUCCESS)){
			accountList = (String[]) result.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(result.getReInfo(), frame.getX(), frame.getY());
		}
	}
	@SuppressWarnings("unused")
	private boolean isLegal(){
		if(costField.getText().equals("")){
			HintFrame hint = new HintFrame("付款金额未输入！", frame.getX(), frame.getY());
			return false;
		}
		if(payerField.getText().equals("")){
			HintFrame hint = new HintFrame("付款人未输入！", frame.getX(), frame.getY());
			return false;
		}
		try {
			Double.parseDouble(costField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("付款金额格式错误！", frame.getX(), frame.getY());
			return false;
		}
		if(Utility.isOutOfDate(datePanel.getCalendar())){
			HintFrame hint = new HintFrame("日期超出当前日期！", frame.getX(), frame.getY());
			return false;
		}
		return true;
	}
	private PaymentVO createVO(){
		Calendar date = datePanel.getCalendar();
		Pay pays[] = Pay.values();
		PaymentVO payment = new PaymentVO(date, payerField.getText(), (String)accountCombo.getSelectedItem(), pays[reasonCombo.getSelectedIndex()], Double.parseDouble(costField.getText()), remarkArea.getText(), user.getName());
		return payment;
	}
}
