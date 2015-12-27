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
import edu.nju.umr.logic.orderNewLogic.CenterLoadingOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.CenterLoadingOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.ExpressListPanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.ELabel;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.CenterLoadingVO;

public class CenterLoadingPanel extends PPanel implements PriceCount{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6510869696757978208L;
	private TextField transitIdField;
	private TextField supervisionField;
	private TextField escortField;
	private TextField vanIdField;
	private JFrame frame;
	private CenterLoadingOrderLSer logicSer;
	private DatePanel datePanel;
	private TextField costField;
	private UMRComboBox<String> arriveCombo;
	private String name;
	private ExpressListPanel expressList;
	private String userId;
	private String org;
	private String orgId;
	/**
	 * Create the panel.
	 */
	public CenterLoadingPanel(JFrame fr,CenterLoadingVO vo)
	{
		this(fr,vo.getOpName(),vo.getUserId(),vo.getStartPlace(),vo.getStartOrgId());
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		transitIdField.setText(vo.getTransitId());
		supervisionField.setText(vo.getSupervision());
		escortField.setText(vo.getEscort());
		vanIdField.setText(vo.getVanId());
		datePanel.setDate(vo.getDate());
		costField.setText(Double.toString(vo.getCost()));
		arriveCombo.setSelectedItem((String)vo.getTarget());
		expressList.showExpressList(vo.getExpress());
	}
	/**
	 * @wbp.parser.constructor
	 */
	public CenterLoadingPanel(JFrame fr,String name,String userId,String org,String orgId) {
		setLayout(null);
		TitleLabel titleLabel = new TitleLabel("中转中心装车单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titleLabel.setBounds(392+75, 10, 243, 67);
		add(titleLabel);
		frame = fr;
		logicSer = new CenterLoadingOrderLogic();
		this.name = name;
		this.userId = userId;
		this.org = org;
		this.orgId=orgId;
		
		ELabel transitIdLabel = new ELabel("汽运编号");
		transitIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transitIdLabel.setStdFont();
		transitIdLabel.setBounds(375, 107, 130, 24);
		add(transitIdLabel);
		
		transitIdField = new TextField();
		transitIdField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		transitIdField.setBounds(519, 107, 219, 24);
		transitIdField.setEditable(false);
		add(transitIdField);
		transitIdField.setColumns(10);
		
		ELabel dateLabel = new ELabel("装车日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setStdFont();
		dateLabel.setBounds(375, 141, 120, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(522, 141, 285, 26);
		add(datePanel);
		
		ELabel arriveLabel = new ELabel("到达地");
		arriveLabel.setStdFont();
		arriveLabel.setBounds(295, 175, 85, 24);
		add(arriveLabel);
		
		arriveCombo = new UMRComboBox<String>();
		arriveCombo.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		arriveCombo.setBounds(380, 175, 150, 25);
		ResultMessage message = logicSer.getHalls();
		if(message.getReInfo().equals(Result.SUCCESS)){
			String halls[] = (String[]) message.getMessage();
			arriveCombo.setModel(new DefaultComboBoxModel<String>(halls));;
		} else {
			hint(message.getReInfo());
		}
		arriveCombo.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent e) {
			getPrice();
		}});
		add(arriveCombo);
		
		ELabel supervisionLabel = new ELabel("监装员");
		supervisionLabel.setStdFont();
		supervisionLabel.setBounds(540, 177, 70, 24);
		add(supervisionLabel);
		
		supervisionField = new TextField();
		supervisionField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		supervisionField.setColumns(10);
		supervisionField.setBounds(610, 177, 85, 25);
		add(supervisionField);
		
		ELabel escortLabel = new ELabel("押运员");
		escortLabel.setStdFont();
		escortLabel.setBounds(700, 177, 70, 24);
		add(escortLabel);
		
		escortField = new TextField();
		escortField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		escortField.setColumns(10);
		escortField.setBounds(770, 178, 85, 25);
		add(escortField);
		
		ELabel vanIdLabel = new ELabel("车辆代号");
		vanIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vanIdLabel.setStdFont();
		vanIdLabel.setBounds(220+75, 224, 120, 24);
		add(vanIdLabel);
		
		vanIdField = new TextField();
		vanIdField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		vanIdField.setColumns(10);
		vanIdField.setBounds(328+75, 223, 165, 25);
		add(vanIdField);
		
		ELabel costLabel = new ELabel("运费/元");
		costLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		costLabel.setBounds(655, 224, 79, 24);
		add(costLabel);
		
		Button confirmButton = new ConfirmButton();
		confirmButton.setBounds(342+75, 530, 100, 30);
		add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			
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
		
		Button cancelButton = new CanButton();
		cancelButton.setName("cancel");
		cancelButton.setBounds(542+75, 530, 100, 30);
		cancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				frame.dispose();
			}
		});
		add(cancelButton);
		
		costField = new TextField();
		costField.setEditable(false);
		costField.setBounds(731, 228, 66, 21);
		costField.setEnabled(false);
		add(costField);
		costField.setColumns(10);
		
		expressList = new ExpressListPanel(frame,this);
		expressList.setBounds(266, 236, 677, 273);
		add(expressList);
		
		if(orgId!=null){
			message = logicSer.getNextId(orgId);
			Result result=message.getReInfo();
			if(result.equals(Result.SUCCESS))
			{
				int num=(Integer)message.getMessage();
				if(num==-1){
					DoHint.hint(Result.DATABASE_ERROR, frame);
				}
				else{
					String temp=Integer.toString(num);
					while(temp.length()<7)
					{
						temp="0"+temp;
					}
					temp=orgId+DateFormat.DATESTRING.format(Calendar.getInstance().getTime())+temp;
					transitIdField.setText(temp);
				}
			}
			message = logicSer.getExpressList(orgId+"*");
			result=message.getReInfo();
			if(result.equals(Result.SUCCESS)){
				@SuppressWarnings("unchecked")
				ArrayList<String> ar = (ArrayList<String>)message.getMessage();
				expressList.setAllItem(ar);
			}
		}
	}
	private void hint(Result result){
		@SuppressWarnings("unused")
		HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
	}
	private void hint(String hint){
		@SuppressWarnings("unused")
		HintFrame hintF = new HintFrame(hint, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
	}
	private CenterLoadingVO createVO(){
		ArrayList<String> expresses = expressList.getExpresses();
		CenterLoadingVO vo = new CenterLoadingVO(datePanel.getCalendar(), transitIdField.getText(),(String)arriveCombo.getSelectedItem(), vanIdField.getText(), 
				supervisionField.getText(), escortField.getText(), 
				expresses, Double.parseDouble(costField.getText()), name,userId,false,org,orgId);
		return vo;
	}
	private boolean isLegal(){
		if(supervisionField.getText().equals("")){
			hint("监装员未输入！");
			return false;
		}
		if(escortField.getText().equals("")){
			hint("押运员未输入！");
			return false;
		}
		if(vanIdField.getText().equals("")){
			hint("车辆代号未输入！");
			return false;
		}
		if(expressList.isEmpty()){
			hint("订单号未输入！");
			return false;
		}
		return true;
	}
	public void getPrice(){
		if(org==null)return;
		if(arriveCombo.getSelectedIndex()<0)return;
		ResultMessage message=logicSer.getPrice(org,(String)arriveCombo.getSelectedItem(),expressList.getExpresses());
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
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
