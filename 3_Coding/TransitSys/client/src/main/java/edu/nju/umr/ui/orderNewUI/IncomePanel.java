package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.logic.orderNewLogic.IncomeOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.IncomeOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.ExpressListPanel;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public class IncomePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8051086541274712984L;
	private JComboBox<String> courierCombo;
	private JComboBox<String> accountCombo;
	private JTextField amountField;
	private IncomeOrderLSer logicSer;
	private JFrame frame;
	private DatePanel datePanel;
	private ExpressListPanel expressList;
	private String orgId;
	private String name;
	private String userId;
	private JButton confirmButton;
	/**  
	 * Create the panel.
	 */
	public IncomePanel(JFrame fr,IncomeVO vo)
	{
		this(fr,vo.getOrgId(),vo.getOpName(),vo.getUserId());
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		courierCombo.setSelectedItem(vo.getCourier());
		amountField.setText(vo.getCost().toString());
		datePanel.setDate(vo.getDate());
		expressList.showExpressList(vo.getExpress());
		
	}
	public IncomePanel(JFrame fr,String orgId,String name,String userId) {
		setLayout(null);
		frame=fr;
		this.orgId = orgId;
		this.name = name;
		this.userId = userId;
		logicSer = new IncomeOrderLogic();
		
		JLabel titleLabel = new JLabel("收款单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setBounds(392+40, 10, 243, 67);
		add(titleLabel);
		
		JLabel dateLabel = new JLabel("收款日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dateLabel.setBounds(297+40, 98, 120, 24);
		add(dateLabel);
		
		datePanel=new DatePanel();
		datePanel.setBounds(474, 98, 285, 26);
		add(datePanel);
		
		JLabel courierLabel = new JLabel("快递员");
		courierLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		courierLabel.setBounds(286+40, 175, 85, 24);
		add(courierLabel);
		
		courierCombo = new JComboBox<String>();
		courierCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		courierCombo.setBounds(355+40, 174, 85, 25);
		ResultMessage message = logicSer.getCouriers(orgId);
		if(message.getReInfo().equals(Result.SUCCESS)){
			String[] couriers = (String[]) message.getMessage();
			courierCombo.setModel(new DefaultComboBoxModel<String>(couriers));
		} else {
			DoHint.hint(message.getReInfo(), frame);
		}
		add(courierCombo);
		
		JLabel amountLabel = new JLabel("金额/元");
		amountLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		amountLabel.setBounds(490, 175, 85, 24);
		add(amountLabel);
		
		amountField = new JTextField();
		amountField.setFont(new Font("宋体", Font.PLAIN, 20));
		amountField.setColumns(10);
		amountField.setBounds(569, 174, 85, 25);
		add(amountField);

		expressList = new ExpressListPanel(frame);
		expressList.setBounds(280, 200, 700, 290);
		add(expressList);
		
		confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(342+40, 499, 93, 23);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setName("cancel");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(542+40, 499, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancelButton);
		
		JLabel accountLabel = new JLabel("账户");
		accountLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		accountLabel.setBounds(664, 175, 65, 22);
		add(accountLabel);
		
		accountCombo = new JComboBox<String>();
		accountCombo.setBounds(714, 175, 110, 25);
		ResultMessage messageA = logicSer.getAccount();
		if(messageA.getReInfo() == Result.SUCCESS){
			String[] accountList = (String[]) messageA.getMessage();
			accountCombo.setModel(new DefaultComboBoxModel<String>(accountList));
		} else {
			DoHint.hint(messageA.getReInfo(), fr);
		}
		add(accountCombo);
	}
	private boolean isLegal(){
		if(expressList.isEmpty()){
			DoHint.hint("请输入订单号！", frame);
			return false;
		}
		try{
			Double.parseDouble(amountField.getText());
		} catch(NumberFormatException e){
			DoHint.hint("请输入金额！", frame);
			return false;
		}
		
		return true;
	}
	private IncomeVO createVO(){
		IncomeVO vo = new IncomeVO(datePanel.getCalendar(), (String)courierCombo.getSelectedItem(), new BigDecimal(amountField.getText()), 
				expressList.getExpresses(), name, orgId,userId,(String)accountCombo.getSelectedItem());
		return vo;
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
