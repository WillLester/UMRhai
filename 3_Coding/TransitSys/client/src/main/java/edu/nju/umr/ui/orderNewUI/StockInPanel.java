package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderNewLogic.StockInOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.StockInOrderLSer;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Result;
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
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;
import edu.nju.umr.vo.order.StockInVO;

public class StockInPanel extends PPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1734951723422352793L;
	private AutoCompPanel expressField;
	private UMRComboBox<String> partCombo;
	private UMRComboBox<Integer> rowCombo;
	private UMRComboBox<String> shelfCombo;
	private UMRComboBox<Integer> placeCombo;
	private JFrame frame;
	private DatePanel datePanel;
	private String name;
	private String orgId;
	private StockInOrderLSer logicSer;
	private ArrayList<ShelfVO> shelfList;
	private ArrayList<ShelfVO> shelfPart;
	private UMRComboBox<String> targetCombo;
	private String userId;
	private TextField idField;
	/**
	 * Create the panel.
	 */
	public StockInPanel(JFrame fr,StockInVO vo)
	{
		this(fr,vo.getOpName(),vo.getStockId(),vo.getUserId());
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		idField.setText(vo.getId());
		expressField.setText(vo.getExpressId());
		partCombo.setSelectedItem(vo.getPart());
		shelfCombo.setSelectedItem(vo.getShelfId());
		datePanel.setDate(vo.getDate());
		targetCombo.setSelectedItem(vo.getArrivePlace());
		Integer [] t= new Integer[1];
		t[0]=vo.getRow();
		rowCombo.setModel(new DefaultComboBoxModel<Integer>(t));
		t[0]=vo.getPlace();
		placeCombo.setModel(new DefaultComboBoxModel<Integer>(t));
	}

	@SuppressWarnings("unchecked")
	public StockInPanel(JFrame fr,String name,String orgId,String userId) {
		setLayout(null);
		frame=fr;
		try {
			logicSer = new StockInOrderLogic();
		} catch (RemoteException e1) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
		this.name = name;
		this.orgId = orgId;
		this.userId=userId;
		
		TitleLabel titleLabel = new TitleLabel("入库单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titleLabel.setBounds(392, 10, 243, 67);
		add(titleLabel);
				
		UMRLabel label = new UMRLabel("入库单编号");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label.setBounds(359, 112, 123, 24);
		add(label);
		
		idField = new TextField();
		idField.setBounds(483, 112, 165, 25);
		idField.setEditable(false);
		add(idField);
		idField.setColumns(10);
		
		UMRLabel expressLabel = new UMRLabel("快递单号");
		expressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		expressLabel.setBounds(340, 157, 123, 24);
		add(expressLabel);
		
		expressField = new AutoCompPanel();
		expressField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		expressField.setBounds(483, 156, 165, 25);
		add(expressField);
		
		UMRLabel dateLabel = new UMRLabel("入库日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		dateLabel.setBounds(340, 202, 120, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(480, 202, 285, 26);
		add(datePanel);
		
		String orgList[] = null;
		ResultMessage orgResult = logicSer.getOrgs();
		if(orgResult.getReInfo().equals(Result.SUCCESS)){
			orgList = (String[]) orgResult.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(orgResult.getReInfo(), frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
		}
		
		UMRLabel destiLabel = new UMRLabel("目的地");
		destiLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		destiLabel.setBounds(359, 247, 85, 24);
		add(destiLabel);
		
		targetCombo = new UMRComboBox<String>();
		targetCombo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		targetCombo.setBounds(480, 247, 190, 25);
		targetCombo.setModel(new DefaultComboBoxModel<String>(orgList));
		add(targetCombo);
		
		ResultMessage shelfResult = logicSer.getShelves(orgId);
		if(shelfResult.getReInfo().equals(Result.SUCCESS)){
			shelfList = (ArrayList<ShelfVO>) shelfResult.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(shelfResult.getReInfo(), frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			frame.dispose();
		}
		
		UMRLabel partLabel = new UMRLabel("区号");
		partLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		partLabel.setBounds(332, 296, 85, 24);
		add(partLabel);
		
		partCombo = new UMRComboBox<String>();
		partCombo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		partCombo.setBounds(378, 296, 140, 25);
		partCombo.setModel(new DefaultComboBoxModel<String>(new String[]{"航运区","铁运区","汽运区","机动区"}));
		partCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				
				if(e.getStateChange() == ItemEvent.SELECTED){
					setShelfModel();
				}
			}
		});
		add(partCombo);
		
		UMRLabel shelfLabel = new UMRLabel("架号");
		shelfLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		shelfLabel.setBounds(332, 346, 85, 24);
		add(shelfLabel);
		
		shelfCombo = new UMRComboBox<String>();
		shelfCombo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		shelfCombo.setBounds(378, 346, 140, 25);
		shelfCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					setRow();
				}
			}
		});
		add(shelfCombo);
		
		UMRLabel rowLabel = new UMRLabel("排号");
		rowLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		rowLabel.setBounds(552, 296, 85, 24);
		add(rowLabel);
		
		rowCombo = new UMRComboBox<Integer>();
		rowCombo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		rowCombo.setBounds(604, 296, 90, 25);
		rowCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					setPlace();
				}
			}
		});
		add(rowCombo);
		
		UMRLabel placeLabel = new UMRLabel("位号");
		placeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		placeLabel.setBounds(552, 346, 85, 24);
		add(placeLabel);
		
		placeCombo = new UMRComboBox<Integer>();
		placeCombo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		placeCombo.setBounds(604, 346, 90, 25);
		add(placeCombo);
		
		Button confirmButton = new ConfirmButton();
		confirmButton.setBounds(347, 473, 100, 30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					Result result = logicSer.create(createVO());
					DoHint.hint(result, frame,true);
					if((result == Result.OUT_OF_STOCK_VAN)||(result == Result.OUT_OF_STOCK_PLANE)||(result == Result.OUT_OF_STOCK_TRAIN)||
							(result == Result.OUT_OF_STOCK_MANEUVER)){
						DoHint.hint(Result.SUCCESS, fr);
					}
					if(result.equals(Result.SUCCESS)){
						confirmButton.setEnabled(false);
					}
				}
			}
		});
		add(confirmButton);
		
		Button cancelButton = new CanButton();
		cancelButton.setName("cancel");
		cancelButton.setBounds(542, 473, 100, 30);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancelButton);
	
		
		setShelfModel();
		
		if(orgId!=null)
		{
			ResultMessage message=logicSer.getNextId(orgId);
			Result result=message.getReInfo();
			if(!result.equals(Result.SUCCESS))
			{
				DoHint.hint(result, frame);
			}
			else
			{
				int num=(Integer)message.getMessage();
				String temp=Integer.toString(num);
				while(temp.length()<5)
				{
					temp="0"+temp;
				}
				idField.setText(orgId+DateFormat.DATESTRING.format(Calendar.getInstance().getTime())+temp);
			}
			
			message=logicSer.getComingExpresses(orgId);
			result=message.getReInfo();
			if(!result.equals(Result.SUCCESS))
			{
				DoHint.hint(result, frame);
			}
			else{
				ArrayList<String> ar = (ArrayList<String>) message.getMessage();
				expressField.setAllItem(ar);
			}
		}
		
		
	}
	private void getShelfPart(Part part){
		shelfPart = new ArrayList<ShelfVO>();
		if(shelfList==null)return;
		for(ShelfVO shelf:shelfList){
			if(shelf.getPart().equals(part)){
				shelfPart.add(shelf);
			}
		}
	}
	@SuppressWarnings("unused")
	private boolean isLegal(){
		if(datePanel.getCalendar().after(Calendar.getInstance())){
			HintFrame hint = new HintFrame(Hints.OUT_OF_DATE, frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		String result = CheckLegal.isExpressLegal(expressField.getText());
		if(result != null){
			HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		if(!logicSer.isExpressValid(expressField.getText())){
			DoHint.hint("快递单不存在！", frame);
			return false;
		}
		return true;
	}
	private StockInVO createVO(){
		Part parts[] = Part.values();
		StockInVO vo = new StockInVO(idField.getText(),expressField.getText(), datePanel.getCalendar(), (String) targetCombo.getSelectedItem(),
				parts[partCombo.getSelectedIndex()], (String)shelfCombo.getSelectedItem(),
				Integer.parseInt(rowCombo.getSelectedItem().toString()), Integer.parseInt(placeCombo.getSelectedItem().toString()), name, orgId,userId);
		return vo;
	}
	
	private void setShelfModel(){
		Part parts[] = Part.values();
		getShelfPart(parts[partCombo.getSelectedIndex()]);
		String shelves[] = new String[shelfPart.size()];
		for(int i = 0;i < shelfPart.size();i++){
			ShelfVO shelf = shelfPart.get(i);
			shelves[i] = shelf.getId();
		}
		shelfCombo.setModel(new DefaultComboBoxModel<String>(shelves));
		setRow();
	}
	
	private void setRow(){
		if(shelfCombo.getSelectedIndex()<0){rowCombo.setModel(new DefaultComboBoxModel<Integer>());setPlace();return;}
		Integer [] t= logicSer.getRow(shelfCombo.getSelectedItem().toString());
		rowCombo.setModel(new DefaultComboBoxModel<Integer>(t));
		setPlace();
	}
	private void setPlace(){
		if(rowCombo.getSelectedIndex()<0){placeCombo.setModel(new DefaultComboBoxModel<Integer>());return;}
		Integer [] t= logicSer.getPlace(shelfCombo.getSelectedItem().toString(),Integer.parseInt((rowCombo.getSelectedItem().toString())));
		placeCombo.setModel(new DefaultComboBoxModel<Integer>(t));
		
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
