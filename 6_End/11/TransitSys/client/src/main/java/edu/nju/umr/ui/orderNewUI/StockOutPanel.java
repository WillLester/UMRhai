package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderNewLogic.StockOutOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.StockOutOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.ui.AutoCompPanel;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
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
import edu.nju.umr.ui.utility.Utility;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockOutVO;

public class StockOutPanel extends PPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4807982962712921033L;
	private AutoCompPanel expressField;
	private AutoCompPanel transitIdField;
	private UMRComboBox<String> targetCombo;
	private UMRComboBox<String> transitCombo;
	private JFrame frame;
	private DatePanel datePanel;
	private StockOutOrderLSer logicSer;
	private String name;
	private String orgId;
	private String userId;
	private TextField idField;
	/**
	 * Create the panel.
	 */
	public StockOutPanel(JFrame fr,StockOutVO vo)
	{
		this(fr,vo.getOpName(),vo.getStockId(),vo.getUserId(),null);
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		expressField.setText(vo.getExpressId());
		transitIdField.setText(vo.getTransitId());
		targetCombo.setSelectedItem(vo.getArrivePlace());
		transitCombo.setSelectedItem(EnumTransFactory.checkTransit(vo.getKind()));
		datePanel.setDate(vo.getDate());
		
	}
	/**
	 * @wbp.parser.constructor
	 */
	@SuppressWarnings("unchecked")
	public StockOutPanel(JFrame fr,String name,String orgId,String userId,String org) {
		setLayout(null);
		frame=fr;
		logicSer = new StockOutOrderLogic();
		this.name = name;
		this.orgId = orgId;
		this.userId=userId;
		
		TitleLabel titleLabel = new TitleLabel("出库单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titleLabel.setBounds(392, 10, 243, 67);
		add(titleLabel);
		
		UMRLabel idLabel = new UMRLabel("出库单编号");
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idLabel.setBounds(359, 122, 120, 24);
		add(idLabel);
		
		idField = new TextField();
		idField.setEditable(false);
		idField.setBounds(485, 122, 165, 25);
		idField.setEnabled(false);
		add(idField);
		idField.setColumns(10);
		
		UMRLabel expressLabel = new UMRLabel("快递编号");
		expressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		expressLabel.setBounds(340, 164, 120, 24);
		add(expressLabel);
		
		expressField = new AutoCompPanel();
		expressField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		expressField.setBounds(485, 164, 165, 25);
		add(expressField);
		
		UMRLabel dateLabel = new UMRLabel("出库日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		dateLabel.setBounds(340, 210, 120, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(485, 210, 285, 26);
		add(datePanel);
		
		String targetList[] = null;
		ResultMessage result = logicSer.getOrgs();
		if(result.getReInfo() == Result.SUCCESS){
			targetList = (String[]) result.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(result.getReInfo(), frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			
		}
		UMRLabel targetLabel = new UMRLabel("目的地");
		targetLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		targetLabel.setBounds(359, 253, 85, 24);
		add(targetLabel);
		
		targetCombo = new UMRComboBox<String>();
		targetCombo.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		targetCombo.setModel(new DefaultComboBoxModel<String>(targetList));
		targetCombo.setBounds(485, 254, 190, 25);
		add(targetCombo);
		
		UMRLabel transitLabel = new UMRLabel("装运形式");
		transitLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		transitLabel.setBounds(359, 300, 85, 24);
		add(transitLabel);
		
		transitCombo = new UMRComboBox<String>();
		transitCombo.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		transitCombo.setBounds(485, 300, 87, 25);
		transitCombo.setModel(new DefaultComboBoxModel<String>(new String[]{"飞机","铁路","公路"}));
		add(transitCombo);
		
		UMRLabel transitIdLabel = new UMRLabel("中转单/汽运编号");
		transitIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transitIdLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		transitIdLabel.setBounds(330, 346, 160, 24);
		add(transitIdLabel);
		
		transitIdField = new AutoCompPanel();
		transitIdField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		transitIdField.setBounds(485, 346, 233, 25);
		add(transitIdField);
		
		Button confirmButton = new ConfirmButton();
		confirmButton.setBounds(347, 464, 100,30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
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
		add(confirmButton);
		
		Button cancelButton = new CanButton();
		cancelButton.setName("cancel");
		cancelButton.setBounds(541, 464, 100, 30);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancelButton);
	
		if(orgId!=null)
		{
			ResultMessage messagee=logicSer.getNextId(orgId);
			Result resultt=messagee.getReInfo();
			if(!resultt.equals(Result.SUCCESS))
			{
				DoHint.hint(resultt, frame);
			}
			else
			{
				int num=(Integer)messagee.getMessage();
				String temp=Integer.toString(num);
				while(temp.length()<5)
				{
					temp="0"+temp;
				}
				idField.setText(orgId+DateFormat.DATESTRING.format(Calendar.getInstance().getTime())+temp);
			}
		}
		
		if(org!=null){
			ResultMessage message=logicSer.getGoingOrders(org,orgId);
			Result resultt=message.getReInfo();
			if(resultt.equals(Result.SUCCESS))
			{
				ArrayList<String> ar =(ArrayList<String>)message.getMessage();
				transitIdField.setAllItem(ar);
			}
			
			transitIdField.getjt().getDocument().addDocumentListener(new DocumentListener(){

				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					ResultMessage messagee=logicSer.getGoingExpress(transitIdField.getText(),orgId);
					if(!message.getReInfo().equals(Result.SUCCESS)){
						return;
					}
					ArrayList<String> ex=(ArrayList<String>)messagee.getMessage();
					expressField.setAllItem(ex);
				}

				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					ResultMessage messagee=logicSer.getGoingExpress(transitIdField.getText(),orgId);
					if(!message.getReInfo().equals(Result.SUCCESS)){
						return;
					}
					ArrayList<String> ex=(ArrayList<String>)messagee.getMessage();
					expressField.setAllItem(ex);
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					ResultMessage messagee=logicSer.getGoingExpress(transitIdField.getText(),orgId);
					if(!message.getReInfo().equals(Result.SUCCESS)){
						return;
					}
					ArrayList<String> ex=(ArrayList<String>)messagee.getMessage();
					expressField.setAllItem(ex);
				}
			});

		}
	}
	@SuppressWarnings("unused")
	private boolean isLegal(){
		if(datePanel.getCalendar().after(Calendar.getInstance())){
			HintFrame hint = new HintFrame(Hints.OUT_OF_DATE, frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		String expressResult = CheckLegal.isExpressLegal(expressField.getText());
		if(expressResult != null){
			HintFrame hint = new HintFrame(expressResult, frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		if(transitIdField.getText().equals("")){
			HintFrame hint = new HintFrame("中转单或汽运编号未输入！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		if(!Utility.isNumberic(transitIdField.getText())){
			HintFrame hint = new HintFrame("中转单或汽运编号含有非数字字符！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		} else if((transitIdField.getText().length() != 19)&&(transitIdField.getText().length() != 20)){
			HintFrame hint = new HintFrame("中转单或汽运编号长度错误！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		if(!logicSer.isExpressValid(expressField.getText())){
			DoHint.hint("快递单不存在！", frame);
			return false;
		}
		return true;
	}
	private StockOutVO createVO(){
		Transit transits[] = Transit.values();
		StockOutVO vo = new StockOutVO(idField.getText(),expressField.getText(), datePanel.getCalendar(), transits[transitCombo.getSelectedIndex()], 
				(String) targetCombo.getSelectedItem(),transitIdField.getText(), name, orgId,userId);
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
