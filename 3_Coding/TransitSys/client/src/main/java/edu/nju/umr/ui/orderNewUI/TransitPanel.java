package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderNewLogic.TransitOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.TransitOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Transit;
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
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Hints;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.TransitVO;

public class TransitPanel extends PPanel implements PriceCount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3747167346049866099L;
	private TextField idField;
	private TextField supervisionField;
	private TextField planeIdField;
	private TextField containerField;
	private UMRComboBox<String> startCombo;
	private UMRComboBox<String> arriveCombo;
	private UMRComboBox<String> kindCombo;
	private ExpressListPanel expressList;
	private TextField costField;
	private JFrame frame;
	private DatePanel datePanel;
	private TransitOrderLSer logicSer;
	private String name;
	private String userId;
	private String orgId;
	/**
	 * Create the panel.
	 */
	public TransitPanel(JFrame fr,TransitVO vo)
	{
		this(fr,"",vo.getOpName(),vo.getUserId(),"");
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		idField.setText(vo.getId());
		supervisionField.setText(vo.getSupervision());
		planeIdField.setText(vo.getPlaneId());
		containerField.setText(vo.getContainerId());
		startCombo.setSelectedItem(vo.getStartPlace());
		arriveCombo.setSelectedItem(vo.getArrivePlace());
		expressList.showExpressList(vo.getExpress());
		kindCombo.setSelectedIndex(vo.getTransit().ordinal());
		costField.setText(Double.toString(vo.getCost()));
		datePanel.setDate(vo.getDate());
	}
	/**
	 * @wbp.parser.constructor
	 */
	public TransitPanel(JFrame fr,String org,String name,String userId,String orgId) {
		setLayout(null);
		frame = fr;
		this.name = name;
		this.userId=userId;
		this.orgId=orgId;
		try {
			logicSer = new TransitOrderLogic();
		} catch (RemoteException e1) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
//		logicSer = new TransitPanelStub(); 
		
		TitleLabel titleLabel = new TitleLabel("中转单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titleLabel.setBounds(392, 10, 243, 67);
		add(titleLabel);
		
		UMRLabel idLabel = new UMRLabel("中转单编号");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idLabel.setBounds(355, 87, 120, 24);
		add(idLabel);
		
		idField = new TextField();
		idField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idField.setBounds(485, 87, 165, 25);
		idField.setEditable(false);
		add(idField);
		idField.setColumns(10);
		
		UMRLabel dateLabel = new UMRLabel("装车日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		dateLabel.setBounds(296, 121, 120, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(452, 121, 285, 26);
		add(datePanel);
		
		UMRLabel startLabel = new UMRLabel("出发地");
		startLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		startLabel.setBounds(140, 157, 85, 24);
		add(startLabel);
		
		arriveCombo = new UMRComboBox<String>();
		arriveCombo.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		arriveCombo.setBounds(432, 157, 140, 25);
		arriveCombo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				getPrice();
			}
		});
		add(arriveCombo);
		
		startCombo = new UMRComboBox<String>();
		startCombo.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		startCombo.setBounds(214, 157, 148, 25);
		ResultMessage message = logicSer.getCenters();
		if(message.getReInfo().equals(Result.SUCCESS)){
			String[] centers = (String[]) message.getMessage();
			startCombo.setModel(new DefaultComboBoxModel<String>(centers));
			for(int i = 0;i < centers.length;i++){
				if(centers[i].equals(org)){
					startCombo.setSelectedIndex(i);
					String[] arrives = new String[centers.length - 1];
					System.arraycopy(centers, 0, arrives, 0, i);
					System.arraycopy(centers, i+1, arrives, i, centers.length - 1 - i);
					arriveCombo.setModel(new DefaultComboBoxModel<String>(arrives));
					arriveCombo.setSelectedIndex(0);
					break;
				}
			}
			if(arriveCombo.getModel().getSize() == 0){
				arriveCombo.setModel(new DefaultComboBoxModel<String>(centers));
			}
		} else {
			DoHint.hint(message.getReInfo(), frame);
		}
		startCombo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				getPrice();
			}
		});
		add(startCombo);
		
		UMRLabel supervisionLabel = new UMRLabel("监装员");
		supervisionLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		supervisionLabel.setBounds(582, 157, 85, 24);
		add(supervisionLabel);
		
		supervisionField = new TextField();
		supervisionField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		supervisionField.setColumns(10);
		supervisionField.setBounds(646, 157, 85, 25);
		add(supervisionField);
		
		UMRLabel planeIdLabel = new UMRLabel("航班号");
		planeIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		planeIdLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		planeIdLabel.setBounds(220, 204, 120, 24);
		add(planeIdLabel);
		
		planeIdField = new TextField();
		planeIdField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		planeIdField.setColumns(10);
		planeIdField.setBounds(328, 203, 165, 25);
		add(planeIdField);
		
		UMRLabel costLabel = new UMRLabel("运费/元");
		costLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		costLabel.setBounds(661, 204, 100, 24);
		add(costLabel);
		
		costField = new TextField();
		costField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		costField.setBounds(748,203,165,25);
		costField.setEditable(false);
		add(costField);
		
		Button confirmButton = new ConfirmButton();
		confirmButton.setBounds(342, 499, 100, 30);
		add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			
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
		
		Button cancelButton = new CanButton();
		cancelButton.setName("cancel");
		cancelButton.setBounds(542, 499, 100, 30);
		add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				frame.dispose();
			}
		});
		
		UMRLabel kindLabel = new UMRLabel("运输方式");
		kindLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		kindLabel.setBounds(741, 157, 80, 24);
		add(kindLabel);
		
		UMRLabel arriveLabel = new UMRLabel("到达地");
		arriveLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		arriveLabel.setBounds(366, 157, 85, 24);
		add(arriveLabel);
		
		UMRLabel containerLabel = new UMRLabel("货柜号");
		containerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		containerLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		containerLabel.setBounds(485, 204, 120, 24);
		add(containerLabel);
		
		containerField = new TextField();
		containerField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		containerField.setColumns(10);
		containerField.setBounds(582, 204, 69, 25);
		add(containerField);
		
		try {
			expressList = new ExpressListPanel(frame,this);
		} catch (RemoteException e1) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
		expressList.setBounds(206, 212, 683, 297);
		add(expressList);
		
		kindCombo = new UMRComboBox<String>();
		kindCombo.setBounds(827, 157, 62, 25);
		String kind[] = {"飞机","铁路","公路"};
		kindCombo.setModel(new DefaultComboBoxModel<String>(kind));
		kindCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					if(kindCombo.getSelectedIndex() == 0){
						planeIdField.setEnabled(true);
					} else {
						planeIdField.setEnabled(false);
					}
				}
				getPrice();
			}
		});
		kindCombo.setSelectedIndex(0);
		add(kindCombo);
		
		if(orgId!=null){
			message=logicSer.getNextId(orgId);
			Result result=message.getReInfo();
			if(!result.equals(Result.SUCCESS)){
				DoHint.hint(result, frame);
			} else{
				int num=(Integer)message.getMessage();
				String temp=Integer.toString(num);
				while(temp.length()<7){
					temp="0"+temp;
				}
				idField.setText(orgId+DateFormat.DATESTRING.format(Calendar.getInstance().getTime())+temp);
			}
			
			message=logicSer.getGoingExpresses(orgId+"*");
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
		String result = CheckLegal.isTransitLegal(idField.getText());
		if(result != null){
			DoHint.hint(result, frame);
			return false;
		}
		if(expressList.isEmpty()){
			DoHint.hint(Hints.EXPRESSLIST_NULL, frame);
			return false;
		}
		if(supervisionField.getText().equals("")){
			DoHint.hint("请输入监装员！", frame);
			return false;
		}
		if(kindCombo.getSelectedIndex() == 0){
			if(planeIdField.getText().equals("")){
				DoHint.hint("请输入航班号！", frame);
				return false;
			}
		}
		if(containerField.getText().equals("")){
			DoHint.hint("请输入货柜号！", frame);
			return false;
		}
		return true;
	}
	private TransitVO createVO(){
		if(kindCombo.getSelectedIndex() == 0){
			TransitVO vo = new TransitVO(idField.getText(),planeIdField.getText(), (String)startCombo.getSelectedItem(), 
					(String)arriveCombo.getSelectedItem(), containerField.getText(), supervisionField.getText(), expressList.getExpresses(),
					name,Double.parseDouble(costField.getText()),datePanel.getCalendar(),userId,Transit.values()[kindCombo.getSelectedIndex()],false,orgId);
			return vo;
		} else {
			TransitVO vo = new TransitVO(idField.getText(),null, (String)startCombo.getSelectedItem(), 
					(String)arriveCombo.getSelectedItem(), containerField.getText(), supervisionField.getText(),
					expressList.getExpresses(), name,Double.parseDouble(costField.getText()),datePanel.getCalendar(),userId,
					Transit.values()[kindCombo.getSelectedIndex()],false,orgId);
			return vo;
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
	@Override
	public void getPrice() {
		String start=(String)startCombo.getSelectedItem();
		String des=(String)arriveCombo.getSelectedItem();
		int tran=kindCombo.getSelectedIndex();
		if(tran<0)return;
		if(start.isEmpty())return;
		if(des.isEmpty())return;
		ResultMessage message=logicSer.getPrice(start, des, tran, expressList.getExpresses());
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			DoHint.hint(result, frame);
			return;
		}
		BigDecimal price=(BigDecimal)message.getMessage();
		costField.setText(price.toString());
	}

}
