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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderNewLogic.HallLoadingOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.HallLoadingOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.AutoCompPanel;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.component.*;
import edu.nju.umr.ui.component.button.AddButton;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.component.button.DelButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.HallLoadingVO;

public class HallLoadingPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 165564419345172819L;
	private JTextField transitIdField;
	private JTextField superviseField;
	private JTextField guardField;
	private AutoCompPanel expressIdField;
	private JLabel priceLabel;
	private Table table;
	private DefaultTableModel model;
	private JFrame frame;
	private DatePanel datePanel;
	private HallLoadingOrderLSer serv;
	private JComboBox<String> comboBoxDestination;
	private JComboBox<String> comboBoxVan;
	private ArrayList<String> expressIdList=new ArrayList<String>();
	private String userName;
	private String orgId;
	private String userId;
	private String org;
	private JTextField costField;
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
		model.setRowCount(0);
		for(int i=0;i<vo.getExpress().size();i++)
		{
			model.addRow(new String[]{vo.getExpress().get(i)});
		}
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
		
		JLabel themeLabel = new JLabel("营业厅装车单");
		themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		themeLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		themeLabel.setBounds(392+75, 10, 243, 67);
		add(themeLabel);
		
		JLabel transitIdLabel = new JLabel("汽运编号");
		transitIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transitIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		transitIdLabel.setBounds(355, 87, 120, 24);
		add(transitIdLabel);
		
		transitIdField = new JTextField();
		transitIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		transitIdField.setBounds(485, 87, 250, 25);
		transitIdField.setEditable(false);
		add(transitIdField);
		transitIdField.setColumns(10);
		
		JLabel loadDateLabel = new JLabel("装车日期");
		loadDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loadDateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		loadDateLabel.setBounds(297+75, 121, 120, 24);
		add(loadDateLabel);
		
		datePanel=new DatePanel();
		datePanel.setDate(Calendar.getInstance());
		datePanel.setBounds(411+75,121, 275, 26);
		add(datePanel);
		
		JLabel destinationLabel = new JLabel("到达地");
		destinationLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		destinationLabel.setBounds(242, 155, 85, 24);
		add(destinationLabel);
		
		comboBoxDestination = new JComboBox<String>();
		comboBoxDestination.setFont(new Font("宋体", Font.PLAIN, 15));
		comboBoxDestination.setBounds(307, 155, 160, 25);
		comboBoxDestination.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				getPrice();
			}});
		add(comboBoxDestination);
		
		JLabel superviseLabel = new JLabel("监装员");
		superviseLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		superviseLabel.setBounds(421+75, 157, 85, 24);
		add(superviseLabel);
		
		superviseField = new JTextField();
		superviseField.setFont(new Font("宋体", Font.PLAIN, 20));
		superviseField.setColumns(10);
		superviseField.setBounds(485+75, 157, 85, 25);
		add(superviseField);
		
		JLabel guardLabel = new JLabel("押运员");
		guardLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		guardLabel.setBounds(609+75, 157, 85, 24);
		add(guardLabel);
		
		guardField = new JTextField();
		guardField.setFont(new Font("宋体", Font.PLAIN, 20));
		guardField.setColumns(10);
		guardField.setBounds(674+75, 158, 85, 25);
		add(guardField);
		
		JLabel vanIdLabel = new JLabel("车辆代号");
		vanIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vanIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		vanIdLabel.setBounds(220+75, 204, 120, 24);
		add(vanIdLabel);
		
		comboBoxVan=new JComboBox<String>();
		comboBoxVan.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBoxVan.setBounds(328+75, 203, 165, 25);
		add(comboBoxVan);
		
		priceLabel = new JLabel("运费/元");
		priceLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		priceLabel.setBounds(656, 204, 70, 24);
		add(priceLabel);
		
		JLabel expressIdLabel = new JLabel("订单条形码号");
		expressIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		expressIdLabel.setBounds(220+75, 255, 130, 24);
		add(expressIdLabel);
		
		expressIdField = new AutoCompPanel();
		expressIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		expressIdField.setBounds(355+75, 254, 280, 25);
		add(expressIdField);
		
		Button btnNewButton = new AddButton();
		btnNewButton.setBounds(656+75, 256, 100, 30);
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(serv.isLegal(expressIdField.getText()))
				{
					model.addRow(new String[]{expressIdField.getText()});
					expressIdList.add(expressIdField.getText());
					expressIdField.setText("");
					table.getSelectionModel().setSelectionInterval(table.getRowCount()-1, table.getRowCount()-1);
					if(!getPrice())
					{
						System.out.println("Invalid!");
						int row=table.getSelectedRow();
						model.removeRow(row);
						expressIdList.remove(row);
						expressIdField.setText("");
					}
				}
				else
				{
					DoHint.hint("订单号非法!", frame);
				}
			}
		});
		add(btnNewButton);
		
		Button deleteButton = new DelButton();
		deleteButton.setBounds(656+75+93, 256, 100, 30);
		deleteButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteExpress();
			}
		});
		add(deleteButton);
		
		JLabel tableHeadLabel = new JLabel("已输入订单");
		tableHeadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tableHeadLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		tableHeadLabel.setBounds(401+75, 289, 130, 24);
		add(tableHeadLabel);
		
		confirmButton = new ConfirmButton();
		confirmButton.setBounds(342+75, 499, 100, 30);
		confirmButton.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			createOrder();
		}});
		add(confirmButton);
		
		Button cancelButton = new CanButton();
		cancelButton.setName("cancel");
		cancelButton.setBounds(542+75, 499, 100, 30);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancelButton);
		tableInit();
		dataInit();
	}
	protected void createOrder() {
		// TODO Auto-generated method stub
		HallLoadingVO vo=new HallLoadingVO(orgId,transitIdField.getText(),comboBoxDestination.getSelectedItem().toString(),comboBoxVan.getSelectedItem().toString(),
				superviseField.getText(),guardField.getText(),expressIdList,Double.parseDouble(costField.getText()),datePanel.getCalendar(),userName,userId,false);
		Result result=serv.create(vo);
		DoHint.hint(result, frame,true);
		if(result.equals(Result.SUCCESS)){
			confirmButton.setEnabled(false);
		}
		return;
	}
	private void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false){
					if(table.getSelectedRow() >= 0){
						expressIdField.setText(table.getValueAt(table.getSelectedRow(),0).toString());
					}
				};
			}
		});
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(220+75, 313, 529, 176);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"订单号"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
		
		costField = new JTextField();
		costField.setEnabled(false);
		costField.setBounds(731, 204, 106, 25);
		add(costField);
		costField.setColumns(10);
	}
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
	}
	private void deleteExpress(){
		int row=table.getSelectedRow();
		if(row<0||row>=table.getRowCount())return;
		model.removeRow(row);
		expressIdList.remove(row);
		expressIdField.setText("");
		getPrice();
	}
	private boolean getPrice(){
		String des=(String)comboBoxDestination.getSelectedItem();
		if(des==null||des.isEmpty())return false;
		if(org==null)return false;
		ResultMessage message=serv.getPrice(org, des,expressIdList);
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			DoHint.hint(result, frame);
			return false;
		}
		BigDecimal price=(BigDecimal)message.getMessage();
		costField.setText(price.toString());
		return true;
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
