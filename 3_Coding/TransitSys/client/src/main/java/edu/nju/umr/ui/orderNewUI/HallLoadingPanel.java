package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderNewLogic.HallLoadingOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.HallLoadingOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.ExpressListPanel;
import edu.nju.umr.ui.HintFrame;
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
import edu.nju.umr.vo.order.HallLoadingVO;

public class HallLoadingPanel extends PPanel implements PriceCount {
	/**
	 * 
	 */
	private static final long serialVersionUID = 165564419345172819L;
	private TextField transitIdField;
	private TextField superviseField;
	private TextField guardField;
	private UMRLabel priceLabel;
	private JFrame frame;
	private DatePanel datePanel;
	private HallLoadingOrderLSer serv;
	private UMRComboBox<String> comboBoxDestination;
	private UMRComboBox<String> comboBoxVan;
	private ExpressListPanel expressList;
	private ArrayList<String> allExpresses=new ArrayList<String>();
	private String userName;
	private String orgId;
	private String userId;
	private String org;
	private TextField costField;
	private Button confirmButton;
	/**
	 * Create the panel.
	 */
	public HallLoadingPanel(JFrame fr,HallLoadingVO vo)
	{
		this(fr,vo.getOpName(),vo.getUserId(),vo.getHallId(),null);
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		transitIdField.setText(vo.getConvertId());
		superviseField.setText(vo.getSupervision());
		guardField.setText(vo.getEscort());
		expressList.showExpressList(vo.getExpress());
		datePanel.setDate(vo.getDate());
		comboBoxDestination.setSelectedItem(vo.getArriveLoc());
		comboBoxVan.setSelectedItem(vo.getVanId());
		costField.setText(vo.getCost()+"");
		
	}
	public HallLoadingPanel(JFrame fr,String userName,String userId,String orgId,String org) {
		frame=fr;
		this.userName=userName;
		this.orgId=orgId;
		this.userId=userId;
		this.org=org;
		serv=new HallLoadingOrderLogic();
		setLayout(null);
		
		TitleLabel themeLabel = new TitleLabel("营业厅装车单");
		themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		themeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		themeLabel.setBounds(392+75, 10, 243, 67);
		add(themeLabel);
		
		UMRLabel transitIdLabel = new UMRLabel("汽运编号");
//		transitIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transitIdLabel.setStdFont();
		transitIdLabel.setBounds(355, 107, 120, 24);
		add(transitIdLabel);
		
		transitIdField = new TextField();
		transitIdField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		transitIdField.setBounds(485, 107, 250, 25);
		transitIdField.setEditable(false);
		add(transitIdField);
		transitIdField.setColumns(10);
		
		UMRLabel loadDateLabel = new UMRLabel("装车日期");
//		loadDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loadDateLabel.setStdFont();
		loadDateLabel.setBounds(355, 141, 120, 24);
		add(loadDateLabel);
		
		datePanel=new DatePanel();
		datePanel.setDate(Calendar.getInstance());
		datePanel.setBounds(410+75,141, 275, 26);
		add(datePanel);
		
		UMRLabel destinationLabel = new UMRLabel("到达地");
		destinationLabel.setStdFont();
		destinationLabel.setBounds(242, 175, 85, 24);
		add(destinationLabel);
		
		comboBoxDestination = new UMRComboBox<String>();
		comboBoxDestination.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		comboBoxDestination.setBounds(307, 175, 160, 25);
		comboBoxDestination.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				getPrice();
			}});
		add(comboBoxDestination);
		
		UMRLabel superviseLabel = new UMRLabel("监装员");
		superviseLabel.setStdFont();
		superviseLabel.setBounds(421+75, 177, 85, 24);
		add(superviseLabel);
		
		superviseField = new TextField();
		superviseField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		superviseField.setColumns(10);
		superviseField.setBounds(485+75, 177, 85, 25);
		add(superviseField);
		
		UMRLabel guardLabel = new UMRLabel("押运员");
		guardLabel.setStdFont();
		guardLabel.setBounds(609+75, 177, 85, 24);
		add(guardLabel);
		
		guardField = new TextField();
		guardField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		guardField.setColumns(10);
		guardField.setBounds(674+75, 178, 85, 25);
		add(guardField);
		
		UMRLabel vanIdLabel = new UMRLabel("车辆代号");
		vanIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vanIdLabel.setStdFont();
		vanIdLabel.setBounds(220+75, 224, 120, 24);
		add(vanIdLabel);
		
		comboBoxVan=new UMRComboBox<String>();
		comboBoxVan.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		comboBoxVan.setBounds(328+75, 223, 165, 25);
		add(comboBoxVan);
		
		priceLabel = new UMRLabel("运费/元");
		priceLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		priceLabel.setBounds(656, 224, 70, 24);
		add(priceLabel);
		
		costField = new TextField();
		costField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		costField.setBounds(726, 224, 70, 24);
		costField.setEditable(false);
		costField.setText("0");
		add(costField);
		costField.setColumns(10);
		
		expressList = new ExpressListPanel(frame,this);
		expressList.setBounds(266, 236, 677, 273);
		add(expressList);
		
		confirmButton = new ConfirmButton();
		confirmButton.setBounds(342+75, 539, 100, 30);
		confirmButton.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			createOrder();
		}});
		add(confirmButton);
		
		Button cancelButton = new CanButton();
		cancelButton.setName("cancel");
		cancelButton.setBounds(542+75, 539, 100, 30);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancelButton);
		dataInit();
	}
	protected void createOrder() {
		// TODO Auto-generated method stub
		if(superviseField.getText().equals("")){
			DoHint.hint("监装员未输入！", frame);
			return;
		}
		if(guardField.getText().equals("")){
			DoHint.hint("押运员未输入！", frame);
			return;
		}
		if(expressList.getExpresses().size()==0){
			DoHint.hint("无订单输入！", frame);
			return;
		}
		HallLoadingVO vo=new HallLoadingVO(orgId,transitIdField.getText(),comboBoxDestination.getSelectedItem().toString(),comboBoxVan.getSelectedItem().toString(),
				superviseField.getText(),guardField.getText(),expressList.getExpresses(),Double.parseDouble(costField.getText()),datePanel.getCalendar(),userName,userId,false);
		Result result=serv.create(vo);
		DoHint.hint(result, frame,true);
		if(result.equals(Result.SUCCESS)){
			confirmButton.setEnabled(false);
		}
		return;
	}
	@SuppressWarnings("unchecked")
	private void dataInit(){
		serv=new HallLoadingOrderLogic();
		
		ResultMessage message=serv.getLocalHallAndAllCenter(orgId);
		Result result = message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		String[] destinationListString = (String[]) message.getMessage();
		comboBoxDestination.setModel(new DefaultComboBoxModel<String>(destinationListString));
		
		comboBoxDestination.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				getPrice();
			}
		});
		
		message=serv.getVans(orgId);
		result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
		}
		String[] vanListString = (String[]) message.getMessage();
		comboBoxVan.setModel(new DefaultComboBoxModel<String>(vanListString));
		
		if(orgId==null)return;
		message = serv.getNextId(orgId);
		result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			DoHint.hint(result, frame);
			return;
		}
		int num=(Integer)message.getMessage();
		if(num==-1)
		{
			DoHint.hint(Result.DATABASE_ERROR, frame);
			return;
		}
		String temp=Integer.toString(num);
		while(temp.length()<5)temp="0"+temp;
		transitIdField.setText(orgId+DateFormat.DATESTRING.format(Calendar.getInstance().getTime())+temp);
		
		message=serv.getUnloadExpresses(orgId);
		result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			DoHint.hint(result, frame);
			return;
		}
		allExpresses=(ArrayList<String>)message.getMessage();
		expressList.setAllItem(allExpresses);
	}
	public void getPrice(){
		String des=(String)comboBoxDestination.getSelectedItem();
		if(des==null||des.isEmpty())return;
		if(org==null)return;
		ResultMessage message=serv.getPrice(org, des,expressList.getExpresses());
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			DoHint.hint(result, frame);
			return;
		}
		BigDecimal price=(BigDecimal)message.getMessage();
		costField.setText(price.toString());
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
