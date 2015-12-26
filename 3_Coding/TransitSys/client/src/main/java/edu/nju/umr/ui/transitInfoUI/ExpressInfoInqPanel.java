package edu.nju.umr.ui.transitInfoUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.transitInfoLogic.CourierLogic;
import edu.nju.umr.logicService.transitInfoLogicSer.CourierLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.button.SearchButton;
import edu.nju.umr.ui.orderNewUI.ExpressPanel;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ExpressVO;

public class ExpressInfoInqPanel extends ExpressPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6608025281059459114L;
	protected Button searchButton;
	private CourierLSer logicSer;
	public closeAction ca;
	/**
	 * Create the panel.
	 */
	private class closeAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
		
	}
	public ExpressInfoInqPanel(JFrame fr) {
		super(fr,"","","");
		logicSer = new CourierLogic();
		titleLabel.setText("订单查询");
		searchButton = new SearchButton();
		searchButton.addActionListener(new InqListener());
		searchButton.setBounds(532, 83, 100, 30);
		add(searchButton);
		setEnabled();
		
		confirmButton.removeActionListener(conListener);
		confirmButton.setLocation(getWidth()/2, confirmButton.getY());
		ca=new closeAction();
		confirmButton.addActionListener(ca);
		remove(cancelButton);
	}
	protected void setEnabled(){
		senderField.setEnabled(false);
		senderCompanyField.setEnabled(false);
		senderMobileField.setEnabled(false);
		senderPhoneField.setEnabled(false);
		receiverField.setEnabled(false);
		receiverCompanyField.setEnabled(false);
		receiverMobileField.setEnabled(false);
		receiverPhoneField.setEnabled(false);
		volumnField.setEnabled(false);
		weightField.setEnabled(false);
		nameField.setEnabled(false);
		costField.setEnabled(false);
		lengthField.setEnabled(false);
		widthField.setEnabled(false);
		heightField.setEnabled(false);
		numSpinner.setEnabled(false);
		datePanel.setEnabled(false);
		pakKindCombo.setEnabled(false);
		expressKindCombo.setEnabled(false);
		senderLoc.setEnabled(false);
		receiverLoc.setEnabled(false);
		arriveField.setEnabled(false);
	}
	protected boolean isLegal(){
		String result = CheckLegal.isExpressLegal(barcodeField.getText());
		if(result != null){
			DoHint.hint(result, frame);
			return false;
		} 
		return true;
	}
	protected void display(ExpressVO vo){
		senderField.setText(vo.getSender());
		senderLoc.setLoc(vo.getSendLoc());
		senderMobileField.setText(vo.getSendMobile());
		senderPhoneField.setText(vo.getSendPhone());
		senderCompanyField.setText(vo.getSendUnit());
		receiverField.setText(vo.getReceiver());
		receiverLoc.setLoc(vo.getReceiveLoc());
		receiverMobileField.setText(vo.getReceiveMobile());
		receiverCompanyField.setText(vo.getReceiveUnit());
		receiverPhoneField.setText(vo.getReceivePhone());
		volumnField.setText(vo.getVolumn()+"");
		weightField.setText(vo.getWeight()+"");
		nameField.setText(vo.getName());
		costField.setText(vo.getCost()+"");
		lengthField.setText(vo.getLength()+"");
		widthField.setText(vo.getWidth()+"");
		heightField.setText(vo.getHeight()+"");
		numSpinner.setValue(vo.getNum());
		datePanel.setDate(vo.getCreateDate());
		pakKindCombo.setSelectedIndex(vo.getParse().ordinal());
		expressKindCombo.setSelectedIndex(vo.getKind().ordinal());
		arriveField.setText(DateFormat.DATE.format(vo.getArrive().getTime()));
		senderLoc.setProvinceText(vo.getSendProvince());
		senderLoc.setCityText(vo.getSendCity());
		receiverLoc.setProvinceText(vo.getReceiveProvince());
		receiverLoc.setCityText(vo.getReceiveCity());
	}
	public class InqListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(isLegal()){
				ResultMessage message = logicSer.enterBarcodeCourier(barcodeField.getText());
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
