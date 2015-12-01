package edu.nju.umr.ui.transitInfoUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.transitInfoLogic.CourierLogic;
import edu.nju.umr.logicService.transitInfoLogicSer.CourierLSer;
import edu.nju.umr.po.enums.Result;
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
	protected JButton checkButton;
	private CourierLSer logicSer;
	/**
	 * Create the panel.
	 */
	public ExpressInfoInqPanel(JFrame fr) {
		super(fr,null);
		logicSer = new CourierLogic();
		checkButton = new JButton("查询");
		checkButton.setFont(new Font("宋体", Font.PLAIN, 20));
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isLegal()){
					ResultMessage message = logicSer.enterBarcodeCourier(barcodeField.getText());
					if(message.getReInfo().equals(Result.SUCCESS)){
						ExpressVO vo = (ExpressVO) message.getMessage();
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
						senderLoc.setProvince(vo.getSendProvince());
						senderLoc.setCity(vo.getSendCity());
						receiverLoc.setProvince(vo.getReceiveProvince());
						receiverLoc.setCity(vo.getReceiveCity());
					} else {
						DoHint.hint(message.getReInfo(), frame);
					}
				}
			}
		});
		checkButton.setBounds(518, 66, 93, 23);
		add(checkButton);
		setEnabled();
		
		confirmButton.removeActionListener(new ConfirmListener());
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				frame.dispose();
			}
		});
		remove(cancelButton);
	}
	protected void setEnabled(){
		barcodeField.setEnabled(false);
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
}
