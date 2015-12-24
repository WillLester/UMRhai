package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderNewLogic.SendOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.SendOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Hints;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.SendVO;

public class SendPanel extends PPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8991812902473293357L;
	private JTextField barcodeField;
	private JComboBox<String> courierCombo;
	private JFrame frame;
	private DatePanel datePanel;
	private String name;
	private String[] courierList;
	private SendOrderLSer logicSer;
	private String userId;
	private String orgId;
	private LinkedList<String> express;
	private JTextField idField;
	/**
	 * Create the panel.
	 */
	public SendPanel(JFrame fr,SendVO vo)
	{
		this(fr, vo.getOpName(),null ,vo.getUserId());
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		idField.setText(vo.getId());
		barcodeField.setText(vo.getExpressId());
		courierCombo.setSelectedItem(vo.getCourier());
		datePanel.setDate(vo.getDate());
	}
	public SendPanel(JFrame fr,String name,String orgId,String userId,LinkedList<String> express) {
		// TODO 自动生成的构造函数存根
		this(fr,name,orgId,userId);
		barcodeField.setText(express.get(0));
		barcodeField.setEditable(false);
	}
	/**
	 * @wbp.parser.constructor
	 */
	public SendPanel(JFrame fr,String name,String orgId,String userId) {
		setLayout(null);
		frame=fr;
		this.name = name;
		this.userId=userId;
		this.orgId = orgId;
		logicSer = new SendOrderLogic();
		express = new LinkedList<String>();
		
		JLabel titleLabel = new JLabel("派件单");
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(382, 45, 242, 67);
		add(titleLabel);
		
		JLabel barcodeLabel = new JLabel("托运单条形码号");
		barcodeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		barcodeLabel.setBounds(342, 216, 140, 24);
		add(barcodeLabel);
		
		barcodeField = new JTextField();
		barcodeField.setFont(new Font("宋体", Font.PLAIN, 20));
		barcodeField.setBounds(487, 216, 193, 24);
		add(barcodeField);
		barcodeField.setColumns(10);
		
		JLabel dateLabel = new JLabel("到达日期");
		dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		dateLabel.setBounds(342, 268, 107, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(483, 268, 285, 26);
		add(datePanel);
		
		JLabel courierLabel = new JLabel("派送员");
		courierLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		courierLabel.setBounds(342, 162, 107, 24);
		add(courierLabel);
		
		ResultMessage result = logicSer.getCouriers(orgId);
		if(result.getReInfo().equals(Result.SUCCESS)){
			courierList = (String[]) result.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(result.getReInfo(), frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
		}
		
		courierCombo = new JComboBox<String>();
		courierCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		courierCombo.setBounds(487, 162, 193, 24);
		courierCombo.setModel(new DefaultComboBoxModel<String>(courierList));
		add(courierCombo);
		
		Button confirmButton = new ConfirmButton();
		confirmButton.setBounds(364, 434, 100, 30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					Result result = logicSer.create(createVO());
					if(!result.equals(Result.SUCCESS)){
						DoHint.hint(result, frame);
						return;
					}
					if(result.equals(Result.SUCCESS)){
						confirmButton.setEnabled(false);
					}
						if(!express.isEmpty()){
							DoHint.hint(result, frame);
							express.removeFirst();
							frame.setContentPane(new SendPanel(fr, name, orgId, userId,express));
						} else {
							DoHint.hint(result, frame, true);
						}
					}
			}
		});
		add(confirmButton);
		
		Button cancelButton = new CanButton();
		cancelButton.setName("cancel");
		cancelButton.setBounds(548, 436, 100, 30);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancelButton);
		
		JLabel idLabel = new JLabel("单据编号");
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idLabel.setBounds(342, 122, 107, 24);
		add(idLabel);
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(487, 122, 193, 24);
		add(idField);
		idField.setColumns(10);
		
		if(orgId != null){
			getId();
			ResultMessage message=logicSer.getGoingExpress(orgId+"*");
			Result resultt=message.getReInfo();
			if(!resultt.equals(Result.SUCCESS)){
				DoHint.hint(resultt, frame);
			}else{
				express.clear();
				@SuppressWarnings("unchecked")
				ArrayList<String> ar=((ArrayList<String>)message.getMessage());
				for(String exp:ar){
					express.add(exp);
				}
				if(express.size()>0){
					barcodeField.setText(express.get(0));
					barcodeField.setEditable(false);
				}
			}
		}
	}
	
	private void getId(){
		ResultMessage message = logicSer.getNextId(orgId);
		if(message.getReInfo() == Result.SUCCESS){
			String re = orgId + DateFormat.DATESTRING.format(Calendar.getInstance().getTime());
			int size = (int) message.getMessage();
			String id = "" + size;
			while(id.length() < 7){
				id = "0" + id;
			}
			re += id;
			idField.setText(re);
		} else {
			DoHint.hint(message.getReInfo(), frame);
		}
	}
	
	@SuppressWarnings("unused")
	private boolean isLegal(){
		if(datePanel.getCalendar().after(Calendar.getInstance())){
			HintFrame hint = new HintFrame(Hints.OUT_OF_DATE, frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		return true;
	}
	private SendVO createVO(){
		SendVO vo = new SendVO(datePanel.getCalendar(), barcodeField.getText(), idField.getText(),(String) courierCombo.getSelectedItem(), name,userId);
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
