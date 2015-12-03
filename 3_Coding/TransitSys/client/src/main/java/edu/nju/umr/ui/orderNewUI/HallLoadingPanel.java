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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
//import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
//import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.orderNewLogic.HallLoadingOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.HallLoadingOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;
import edu.nju.umr.vo.VanVO;
import edu.nju.umr.vo.order.HallLoadingVO;

public class HallLoadingPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 165564419345172819L;
	private JTextField transitIdField;
	private JTextField superviseField;
	private JTextField guardField;
	private JTextField expressIdField;
	private JLabel priceLabel;
	private Table table;
	private DefaultTableModel model;
	private JFrame frame;
	private DatePanel datePanel;
	private ArrayList<OrgVO> destinationList;
	private HallLoadingOrderLSer serv;
	private JComboBox<String> comboBoxDestination;
	private ArrayList<VanVO> vanList;
	private JComboBox<String> comboBoxVan;
	private ArrayList<String> expressIdList=new ArrayList<String>();
	private double cost;
	private String userName;
	private String orgId;
	private String userId;
	/**
	 * Create the panel.
	 */
	public HallLoadingPanel(JFrame fr,HallLoadingVO vo)
	{
		this(fr,vo.getOpName(),vo.getUserId(),vo.getHallId());
		for(Component co:this.getComponents())
		{
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
	}
	public HallLoadingPanel(JFrame fr,String userName,String userId,String orgId) {
		frame=fr;
		this.userName=userName;
		this.orgId=orgId;
		this.userId=userId;
		setLayout(null);
		
		JLabel themeLabel = new JLabel("营业厅装车单");
		themeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		themeLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		themeLabel.setBounds(392+75, 10, 243, 67);
		add(themeLabel);
		
		JLabel transitIdLabel = new JLabel("汽运编号");
		transitIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transitIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		transitIdLabel.setBounds(355+75, 87, 120, 24);
		add(transitIdLabel);
		
		transitIdField = new JTextField();
		transitIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		transitIdField.setBounds(485+75, 87, 165, 25);
		add(transitIdField);
		transitIdField.setColumns(10);
		
		JLabel loadDateLabel = new JLabel("装车日期");
		loadDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loadDateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		loadDateLabel.setBounds(297+75, 121, 120, 24);
		add(loadDateLabel);
		
//		JSpinner spinner = new JSpinner();
//		spinner.setModel(new SpinnerNumberModel(new Integer(2015), new Integer(0), null, new Integer(1)));
//		spinner.setFont(new Font("宋体", Font.PLAIN, 20));
//		spinner.setBounds(411+75, 121, 85, 26);
//		add(spinner);
//		
//		JLabel label = new JLabel("年");
//		label.setFont(new Font("宋体", Font.PLAIN, 20));
//		label.setBounds(506+75, 122, 25, 22);
//		add(label);
//		
//		JSpinner spinner_1 = new JSpinner();
//		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
//		spinner_1.setFont(new Font("宋体", Font.PLAIN, 20));
//		spinner_1.setBounds(541+75, 122, 48, 26);
//		add(spinner_1);
//		
//		JLabel label_1 = new JLabel("月");
//		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
//		label_1.setBounds(599+75, 122, 25, 22);
//		add(label_1);
//		
//		JSpinner spinner_2 = new JSpinner();
//		spinner_2.setModel(new SpinnerNumberModel(1, 1, 31, 1));
//		spinner_2.setFont(new Font("宋体", Font.PLAIN, 20));
//		spinner_2.setBounds(634+75, 122, 48, 26);
//		add(spinner_2);
//		
//		JLabel label_2 = new JLabel("日");
//		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
//		label_2.setBounds(692+75, 122, 25, 22);
//		add(label_2);
		
		datePanel=new DatePanel();
		datePanel.setDate(Calendar.getInstance());
		datePanel.setBounds(411+75,121, 275, 26);
		add(datePanel);
		
		JLabel destinationLabel = new JLabel("到达地");
		destinationLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		destinationLabel.setBounds(242+75, 155, 85, 24);
		add(destinationLabel);
		
		comboBoxDestination = new JComboBox<String>();
		comboBoxDestination.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBoxDestination.setBounds(307+75, 155, 87, 25);
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
		
//		textField = new JTextField();
//		textField.setFont(new Font("宋体", Font.PLAIN, 20));
//		textField.setColumns(10);
//		textField.setBounds(328+75, 203, 165, 25);
//		add(textField);
		
		comboBoxVan=new JComboBox<String>();
		comboBoxVan.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBoxVan.setBounds(328+75, 203, 165, 25);
		add(comboBoxVan);
		
		priceLabel = new JLabel("运费：");
		priceLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		priceLabel.setBounds(599+75, 204, 232, 24);
		add(priceLabel);
		
		JLabel expressIdLabel = new JLabel("订单条形码号");
		expressIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		expressIdLabel.setBounds(220+75, 255, 130, 24);
		add(expressIdLabel);
		
		expressIdField = new JTextField();
		expressIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		expressIdField.setColumns(10);
		expressIdField.setBounds(355+75, 254, 280, 25);
		add(expressIdField);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(656+75, 256, 93, 23);
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.addRow(new String[]{expressIdField.getText()});
				expressIdList.add(expressIdField.getText());
				expressIdField.setText("");
			}
		});
		add(btnNewButton);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 20));
		deleteButton.setBounds(656+75+93, 256, 93, 23);
		deleteButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				
				model.removeRow(row);
				expressIdList.remove(row);
				expressIdField.setText("");
			}
		});
		add(deleteButton);
		
		JLabel tableHeadLabel = new JLabel("已输入订单");
		tableHeadLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tableHeadLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		tableHeadLabel.setBounds(401+75, 289, 130, 24);
		add(tableHeadLabel);
		
//		table = new JTable();
//		table.setFont(new Font("宋体", Font.PLAIN, 20));
//		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
//		table.setBounds(220+75, 313, 529, 176);
//		add(table);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(342+75, 499, 93, 23);
		confirmButton.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			createOrder();
		}});
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(542+75, 499, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancelButton);
		tableInit();
//		dataInit();

	}
	protected void createOrder() {
		// TODO Auto-generated method stub
//		String hallId,String convertId,String arriveLoc,String vanId,String supervision, String escort,ArrayList<String> express,double cost
		HallLoadingVO vo=new HallLoadingVO(orgId,transitIdField.getText(),comboBoxDestination.getSelectedItem().toString(),comboBoxVan.getSelectedItem().toString(),
				superviseField.getText(),guardField.getText(),expressIdList,cost,datePanel.getCalendar(),userName,userId);
		Result result=serv.create(vo);
		if(!result.equals(Result.SUCCESS))
		{
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
		}
		return;
		
	}
	private void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false){
					expressIdField.setText(table.getValueAt(table.getSelectedRow(),0).toString());
				};
			}
		});
		table.setBounds(220+75, 313, 529, 176);
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(220+75, 313, 529, 176);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"订单号"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	@SuppressWarnings({ "unchecked", "unused" })
	private void dataInit(){
		serv=new HallLoadingOrderLogic();
		
		ResultMessage message=serv.getLocalHallAndAllCenter(orgId);
		Result result = message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		destinationList=(ArrayList<OrgVO>)message.getMessage();
		String[] destinationListString=new String[destinationList.size()];
		for(int i=0;i<destinationList.size();i++)
		{
			destinationListString[i]=destinationList.get(i).getName();
		}
		comboBoxDestination.setModel(new DefaultComboBoxModel<String>(destinationListString));
		
		comboBoxDestination.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				ResultMessage message=serv.getPrice(orgId,destinationList.get(comboBoxDestination.getSelectedIndex()).getId());
				Result result=message.getReInfo();
				if(!result.equals(Result.SUCCESS))
				{
					new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
				}
				else
				{
					cost=(double)message.getMessage();
					priceLabel.setText("运费："+cost);
				}
			}
		});
		
		message=serv.getVans(orgId);
		result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
		}
		else
		{
			vanList=(ArrayList<VanVO>)message.getMessage();
		}
		String[] vanListString=new String[vanList.size()];
		for(int i=0;i<vanList.size();i++)
		{
			vanListString[i]=vanList.get(i).getId();
		}
		comboBoxVan.setModel(new DefaultComboBoxModel<String>(vanListString));
		
		
		
	}
	public static void main(String[] args){
		JFrame frame=new JFrame();
		frame.setContentPane(new HallLoadingPanel(frame,null));
		frame.setSize(1200, 800);
		frame.setVisible(true);
	}
}
