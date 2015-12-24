package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderNewLogic.PaymentOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.PaymentOrderLSer;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.PaymentVO;

public class PaymentPanel extends PPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3964332892070986657L;
	private TextField payerField;
	private TextField costField;
	private JFrame frame;
	private DatePanel datePanel;
	private String[] accountList;
	private PaymentOrderLSer logicSer;
	private String name;
	private JComboBox<String> accountCombo;
	private JComboBox<String> reasonCombo;
	private JTextArea remarkArea;
	private String userId;
	private TextField idField;
	/**
	 * Create the panel.
	 */
	public PaymentPanel(JFrame fr,PaymentVO vo)
	{
		this(fr,vo.getOpName(),vo.getUserId());
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		payerField.setText(vo.getPayer());
		costField.setText(vo.getAmount().toString());
		datePanel.setDate(vo.getDate());
		accountCombo.setSelectedItem(vo.getAccount());
		reasonCombo.setSelectedItem(EnumTransFactory.checkPay(vo.getKind()));
		remarkArea.setText(vo.getRemarks());
	}
	/**
	 * @wbp.parser.constructor
	 */
	public PaymentPanel(JFrame fr,String name,String userId) {
		setLayout(null);
		frame=fr;
		this.name = name;
		this.userId=userId;
		logicSer = new PaymentOrderLogic();
		
		JLabel titleLabel = new JLabel("付款单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titleLabel.setBounds(392, 10, 243, 67);
		add(titleLabel);
		
		JLabel dateLabel = new JLabel("付款日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		dateLabel.setBounds(286, 116, 120, 24);
		add(dateLabel);	
		
		JLabel payerLabel = new JLabel("付款人");
		payerLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		payerLabel.setBounds(235, 175, 85, 24);
		add(payerLabel);
		
		payerField = new TextField();
		payerField.setFont(new Font("宋体", Font.PLAIN, 20));
		payerField.setColumns(10);
		payerField.setBounds(302, 174, 85, 25);
		add(payerField);
		
		JLabel amountLabel = new JLabel("付款金额");
		amountLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		amountLabel.setBounds(397, 175, 85, 24);
		add(amountLabel);
		
		costField = new TextField();
		costField.setFont(new Font("宋体", Font.PLAIN, 20));
		costField.setColumns(10);
		costField.setBounds(487, 174, 85, 25);
		add(costField);
		
		JLabel remarkLabel = new JLabel("备注");
		remarkLabel.setHorizontalAlignment(SwingConstants.CENTER);
		remarkLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		remarkLabel.setBounds(429, 291, 130, 24);
		add(remarkLabel);
		
		JLabel accountLabel = new JLabel("付款账号");
		accountLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		accountLabel.setBounds(597, 175, 85, 24);
		add(accountLabel);
		
		remarkArea = new JTextArea();
		remarkArea.setBounds(274, 325, 435, 154);
		add(remarkArea);
		
		JLabel reasonLabel = new JLabel("条目");
		reasonLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		reasonLabel.setBounds(437, 237, 59, 24);
		add(reasonLabel);
		
		reasonCombo = new JComboBox<String>();
		reasonCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		reasonCombo.setModel(new DefaultComboBoxModel<String>(new String[]{"租金/年","运费/次","工资/月","奖励"}));
		reasonCombo.setBounds(499, 237, 111, 25);
		add(reasonCombo);
		
		datePanel=new DatePanel();
		datePanel.setBounds(472, 116, 285, 26);
		add(datePanel);
		
		getAccount();
		accountCombo = new JComboBox<String>();
		accountCombo.setBounds(692, 175, 111, 21);
		accountCombo.setModel(new DefaultComboBoxModel<String>(accountList));
		add(accountCombo);
		
		Button confirmButton = new ConfirmButton();
		confirmButton.setBounds(342, 499, 100, 30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					Result result = logicSer.create(createVO());
					DoHint.hint(result, frame,true);
					if(result.equals(Result.SUCCESS)){
						confirmButton.setEnabled(false);
					}
				}
			}
		});
		add(confirmButton);
		
		Button cancelButton = new CanButton();
		cancelButton.setName("cancel");
		cancelButton.setBounds(542, 499, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancelButton);
		
		JLabel idLabel = new JLabel("单据编号");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idLabel.setBounds(286, 66, 120, 24);
		add(idLabel);
		
		idField = new TextField();
		idField.setEditable(false);
		idField.setBounds(458, 66, 251, 25);
		add(idField);
		idField.setColumns(10);
		
		ResultMessage message=logicSer.getNextId();
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			DoHint.hint(result, frame);
		} else
		{
			int num=(Integer)message.getMessage();
			String temp=Integer.toString(num);
			while(temp.length()<5){
				temp="0"+temp;
			}
			idField.setText(DateFormat.DATESTRING.format(Calendar.getInstance().getTime())+temp);
		}
		
		

	}
	private void getAccount(){
		ResultMessage result = logicSer.getAccount();
		if(result.getReInfo().equals(Result.SUCCESS)){
			accountList = (String[]) result.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(result.getReInfo(), frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
		}
	}
	@SuppressWarnings("unused")
	private boolean isLegal(){
		if(costField.getText().equals("")){
			HintFrame hint = new HintFrame("付款金额未输入！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		if(payerField.getText().equals("")){
			HintFrame hint = new HintFrame("付款人未输入！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		try {
			Double.parseDouble(costField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("付款金额格式错误！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		if(datePanel.getCalendar().after(Calendar.getInstance())){
			HintFrame hint = new HintFrame("日期超出当前日期！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		return true;
	}
	private PaymentVO createVO(){
		Calendar date = datePanel.getCalendar();
		Pay pays[] = Pay.values();
		PaymentVO payment = new PaymentVO(idField.getText(),date, payerField.getText(), (String)accountCombo.getSelectedItem(), pays[reasonCombo.getSelectedIndex()],
				new BigDecimal(costField.getText()), remarkArea.getText(), name,userId);
		return payment;
	}
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(enabled);
		}
	}
}
