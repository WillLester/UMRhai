package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderNewLogic.StockInOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.StockInOrderLSer;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.AutoCompPanel;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.component.*;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Hints;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;
import edu.nju.umr.vo.order.StockInVO;

public class StockInPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1734951723422352793L;
	private AutoCompPanel expressField;
	private JComboBox<String> partCombo;
	private JComboBox<Integer> rowCombo;
	private JComboBox<String> shelfCombo;
	private JComboBox<Integer> placeCombo;
	private JFrame frame;
	private DatePanel datePanel;
	private String name;
	private String orgId;
	private StockInOrderLSer logicSer;
	private ArrayList<ShelfVO> shelfList;
	private ArrayList<ShelfVO> shelfPart;
	private JComboBox<String> targetCombo;
	private String userId;
	private JTextField idField;
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
		expressField.setText(vo.getExpressId());
		partCombo.setSelectedItem(vo.getPart());
		rowCombo.setSelectedItem(vo.getRow());
		shelfCombo.setSelectedItem(vo.getShelfId());
		placeCombo.setSelectedItem(vo.getPlace());
		datePanel.setDate(vo.getDate());
		targetCombo.setSelectedItem(vo.getArrivePlace());
	}

	@SuppressWarnings("unchecked")
	public StockInPanel(JFrame fr,String name,String orgId,String userId) {
		setLayout(null);
		frame=fr;
		logicSer = new StockInOrderLogic();
		this.name = name;
		this.orgId = orgId;
		this.userId=userId;
		
		JLabel titleLabel = new JLabel("入库单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setBounds(392, 10, 243, 67);
		add(titleLabel);
		
		JLabel expressLabel = new JLabel("快递单号");
		expressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		expressLabel.setBounds(359, 137, 120, 24);
		add(expressLabel);
		
		expressField = new AutoCompPanel();
		expressField.setFont(new Font("宋体", Font.PLAIN, 20));
		expressField.setBounds(483, 136, 165, 25);
		add(expressField);
		
		JLabel dateLabel = new JLabel("入库日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dateLabel.setBounds(297, 188, 120, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(452, 186, 285, 26);
		add(datePanel);
		
		String orgList[] = null;
		ResultMessage orgResult = logicSer.getOrgs();
		if(orgResult.getReInfo().equals(Result.SUCCESS)){
			orgList = (String[]) orgResult.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(orgResult.getReInfo(), frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
		}
		
		JLabel destiLabel = new JLabel("目的地");
		destiLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		destiLabel.setBounds(378, 222, 85, 24);
		add(destiLabel);
		
		targetCombo = new JComboBox<String>();
		targetCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		targetCombo.setBounds(455, 222, 165, 25);
		targetCombo.setModel(new DefaultComboBoxModel<String>(orgList));
		add(targetCombo);
		
		ResultMessage shelfResult = logicSer.getShelves(orgId);
		if(shelfResult.getReInfo().equals(Result.SUCCESS)){
			shelfList = (ArrayList<ShelfVO>) shelfResult.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(shelfResult.getReInfo(), frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
		}
		
		JLabel partLabel = new JLabel("区号");
		partLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		partLabel.setBounds(332, 276, 85, 24);
		add(partLabel);
		
		partCombo = new JComboBox<String>();
		partCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		partCombo.setBounds(378, 276, 123, 25);
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
		
		JLabel shelfLabel = new JLabel("架号");
		shelfLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		shelfLabel.setBounds(332, 326, 85, 24);
		add(shelfLabel);
		
		shelfCombo = new JComboBox<String>();
		shelfCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		shelfCombo.setBounds(378, 326, 123, 25);
		shelfCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					setRowAndPlaceModel();
				}
			}
		});
		add(shelfCombo);
		
		JLabel rowLabel = new JLabel("排号");
		rowLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		rowLabel.setBounds(535, 276, 85, 24);
		add(rowLabel);
		
		rowCombo = new JComboBox<Integer>();
		rowCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		rowCombo.setBounds(587, 276, 90, 25);
		add(rowCombo);
		
		JLabel placeLabel = new JLabel("位号");
		placeLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		placeLabel.setBounds(535, 326, 85, 24);
		add(placeLabel);
		
		placeCombo = new JComboBox<Integer>();
		placeCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		placeCombo.setBounds(587, 326, 90, 25);
		add(placeCombo);
		
		Button confirmButton = new ConfirmButton();
		confirmButton.setBounds(347, 453, 100, 30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
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
		add(confirmButton);
		
		Button cancelButton = new CanButton();
		cancelButton.setName("cancel");
		cancelButton.setBounds(542, 453, 100, 30);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancelButton);
		
		JLabel label = new JLabel("入库单编号");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label.setBounds(359, 92, 123, 24);
		add(label);
		
		idField = new JTextField();
		idField.setBounds(483, 92, 165, 25);
		idField.setEditable(false);
		add(idField);
		idField.setColumns(10);
		
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
				rowCombo.getSelectedIndex()+1, placeCombo.getSelectedIndex()+1, name, orgId,userId);
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
		setRowAndPlaceModel();
	}
	
	private void setRowAndPlaceModel(){
		if(shelfCombo.getSelectedIndex() < 0){
			return;
		}
		ShelfVO shelf = shelfPart.get(shelfCombo.getSelectedIndex());
		Integer rows[] = new Integer[shelf.getRow()];
		for(int i = 1;i <= rows.length;i++){
			rows[i-1] = i;
		}
		Integer places[] = new Integer[shelf.getPlace()];
		for(int i = 1;i <= places.length;i++){
			places[i-1] = i;
		}
		rowCombo.setModel(new DefaultComboBoxModel<Integer>(rows));
		placeCombo.setModel(new DefaultComboBoxModel<Integer>(places));
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
