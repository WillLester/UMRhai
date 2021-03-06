package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;

import edu.nju.umr.logic.orderNewLogic.ReceiveOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.ReceiveOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.transitInfoUI.ExpressInfoInqPanel;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ExpressVO;
import edu.nju.umr.vo.order.ReceiveVO;

public class ReceivePanel extends ExpressInfoInqPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3052576244031029859L;
	private TextField receiveField;
	private DatePanel receiveDate;
	private UMRLabel timelabel;
	private ReceiveOrderLSer logicSer;
	private String org;
	private String name;
	/**
	 * Create the panel.
	 */
	public ReceivePanel(JFrame fr,String org,String name) {
		super(fr);
		titleLabel.setText("收件录入");
		this.org = org;
		this.name = name;
		try {
			logicSer = new ReceiveOrderLogic();
		} catch (RemoteException e1) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
		cancelButton.setLocation(942, 564+10);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				frame.dispose();
			}
		});
		add(cancelButton);
		confirmButton.setLocation(518, 564+10);
		confirmButton.removeActionListener(ca);
		confirmButton.addActionListener(new ConfirmListener());
		
		searchButton.removeActionListener(searchButton.getActionListeners()[0]);
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					ResultMessage message = logicSer.getExpress(barcodeField.getText());
					if(message.getReInfo() == Result.SUCCESS){
						display((ExpressVO) message.getMessage());
					} else {
						DoHint.hint(message.getReInfo(), fr);
					}
				}
			}
		});
		
		receiveField = new TextField();
		receiveField.setBounds(370, 540, 103, 25);
		add(receiveField);
		receiveField.setColumns(10);
		
		UMRLabel receivelabel = new UMRLabel("收件人");
		receivelabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		receivelabel.setBounds(294, 540, 80, 24);
		add(receivelabel);
		
		receiveDate = new DatePanel();
		receiveDate.setBounds(603, 541, 400, 24);
		add(receiveDate);
		
		timelabel = new UMRLabel("收件时间");
		timelabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		timelabel.setBounds(503, 540, 99, 24);
		add(timelabel);
	}
	@SuppressWarnings("unused")
	protected boolean isReceiveLegal(){
		if(receiveField.getText().equals("")){
			HintFrame hint = new HintFrame("收件人未输入！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		if(barcodeField.getText().equals("")){
			HintFrame hint = new HintFrame("收件编号未输入！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		if(senderField.getText().equals("")){
			DoHint.hint("订单还未获得！", frame);
			return false;
		}
		return true;
	}
	private class ConfirmListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(isReceiveLegal()){
				Result result = logicSer.create(createVO(),org,name);
				DoHint.hint(result, frame,true);
				if(result.equals(Result.SUCCESS)){
					confirmButton.setEnabled(false);
				}
			}
		}
	}
	private ReceiveVO createVO(){
		ReceiveVO vo = new ReceiveVO(receiveField.getText(), receiveDate.getCalendar());
		return vo;
	}
	protected class checkListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(isLegal()){
				ResultMessage message = logicSer.getExpress((barcodeField.getText()));
				if(message.getReInfo().equals(Result.SUCCESS)){
					ExpressVO vo = (ExpressVO) message.getMessage();
					display(vo);
				} else {
					DoHint.hint(message.getReInfo(), frame);
				}
			}
		}
		
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
