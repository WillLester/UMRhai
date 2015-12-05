package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.nju.umr.logic.orderNewLogic.ReceiveOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.ReceiveOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
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
	private JTextField receiveField;
	private DatePanel receiveDate;
	private JLabel timelabel;
	private ReceiveOrderLSer logicSer;
	private String org;
	/**
	 * Create the panel.
	 */
	public ReceivePanel(JFrame fr,String org) {
		super(fr);
		this.org = org;
		logicSer = new ReceiveOrderLogic();
		cancelButton.setLocation(642, 564);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				frame.dispose();
			}
		});
		confirmButton.setLocation(418, 564);
		confirmButton.addActionListener(new ConfirmListener());
		
		checkButton.removeActionListener(new InqListener());
		
		receiveField = new JTextField();
		receiveField.setBounds(370, 517, 103, 25);
		add(receiveField);
		receiveField.setColumns(10);
		
		JLabel receivelabel = new JLabel("收件人");
		receivelabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receivelabel.setBounds(294, 517, 80, 24);
		add(receivelabel);
		
		receiveDate = new DatePanel();
		receiveDate.setBounds(603, 518, 400, 24);
		add(receiveDate);
		
		timelabel = new JLabel("收件时间");
		timelabel.setFont(new Font("宋体", Font.PLAIN, 20));
		timelabel.setBounds(503, 517, 99, 24);
		add(timelabel);
	}
	@SuppressWarnings("unused")
	protected boolean isLegal(){
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
			if(isLegal()){
				Result result = logicSer.create(createVO(),org);
				if(result.equals(Result.SUCCESS)){
					
				} else {
					DoHint.hint(result, frame);
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
}
