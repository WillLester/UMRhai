package edu.nju.umr.ui.orderNewUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderNewLogic.IncomeOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.IncomeOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.ExpressListPanel;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public class IncomePanel extends PPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5845767449951861001L;
	private UMRComboBox<String> courierCombo;
	private UMRComboBox<String> accountCombo;
	private TextField amountField;
	private IncomeOrderLSer logicSer;
	private JFrame frame;
	private DatePanel datePanel;
	private ExpressListPanel expressList;
	private String orgId;
	private String name;
	private String userId;
	private Button confirmButton;
	private UMRLabel idLabel;
	private TextField idField;
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
		idField.setText(vo.getId());
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
		try {
			logicSer = new IncomeOrderLogic();
		} catch (RemoteException e2) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
		
		TitleLabel titleLabel = new TitleLabel("收款单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titleLabel.setBounds(392+40, 10, 243, 67);
		add(titleLabel);
		
		UMRLabel dateLabel = new UMRLabel("收款日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		dateLabel.setBounds(338, 158, 120, 24);
		add(dateLabel);
		
		datePanel=new DatePanel();
		datePanel.setBounds(474, 158, 285, 26);
		add(datePanel);
		
		UMRLabel courierLabel = new UMRLabel("快递员");
		courierLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		courierLabel.setBounds(286+40, 205, 85, 24);
		add(courierLabel);
		
		courierCombo = new UMRComboBox<String>();
		courierCombo.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		courierCombo.setBounds(355+40, 204, 85, 25);
		ResultMessage message = logicSer.getCouriers(orgId);
		if(message.getReInfo().equals(Result.SUCCESS)){
			String[] couriers = (String[]) message.getMessage();
			courierCombo.setModel(new DefaultComboBoxModel<String>(couriers));
		} else {
			DoHint.hint(message.getReInfo(), frame);
		}
		add(courierCombo);
		
		UMRLabel amountLabel = new UMRLabel("金额/元");
		amountLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		amountLabel.setBounds(490, 205, 85, 24);
		add(amountLabel);
		
		amountField = new TextField();
		amountField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		amountField.setColumns(10);
		amountField.setBounds(569, 204, 85, 25);
		add(amountField);

		try {
			expressList = new ExpressListPanel(frame);
		} catch (RemoteException e1) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
		expressList.setBounds(280, 230, 700, 290);
		add(expressList);
		
		confirmButton = new ConfirmButton();
		confirmButton.setBounds(342+40, 529, 100, 30);
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
		
		Button cancelButton = new CanButton();
		cancelButton.setName("cancel");
		cancelButton.setBounds(542+40, 529, 100, 30);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancelButton);
		
		UMRLabel accountLabel = new UMRLabel("账户");
		accountLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		accountLabel.setBounds(664, 205, 65, 22);
		add(accountLabel);
		
		accountCombo = new UMRComboBox<String>();
		accountCombo.setBounds(714, 205, 110, 25);
		ResultMessage messageA = logicSer.getAccount();
		if(messageA.getReInfo() == Result.SUCCESS){
			String[] accountList = (String[]) messageA.getMessage();
			accountCombo.setModel(new DefaultComboBoxModel<String>(accountList));
		} else {
			DoHint.hint(messageA.getReInfo(), fr);
		}
		add(accountCombo);
		
		idLabel = new UMRLabel("收款单编号");
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idLabel.setBounds(357, 111, 120, 24);
		add(idLabel);
		
		idField = new TextField();
		idField.setEditable(false);
		idField.setBounds(473, 111, 252, 25);
		idField.setForeground(Color.black);
		idField.setColumns(10);
		add(idField);
		
		
		if(orgId!=null){
			message=logicSer.getNextId(orgId);
			Result result=message.getReInfo();
			if(!result.equals(Result.SUCCESS)){
				DoHint.hint(result, frame);
			} else{
				int num=(Integer)message.getMessage();
				String temp=Integer.toString(num);
				while(temp.length()<5){
					temp="0"+temp;
				}
				idField.setText(orgId+DateFormat.DATESTRING.format(Calendar.getInstance().getTime())+temp);
			}
			
			message=logicSer.expressAvaliable(orgId);
			result=message.getReInfo();
			if(!result.equals(Result.SUCCESS)){
				DoHint.hint(result, frame);
			} else{
				@SuppressWarnings("unchecked")
				ArrayList<String> ar=(ArrayList<String>)message.getMessage();
				expressList.setAllItem(ar);
			}
		}
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
		IncomeVO vo = new IncomeVO(idField.getText(),datePanel.getCalendar(), (String)courierCombo.getSelectedItem(), new BigDecimal(amountField.getText()), 
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
