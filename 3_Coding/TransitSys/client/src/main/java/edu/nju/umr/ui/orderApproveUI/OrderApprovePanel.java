package edu.nju.umr.ui.orderApproveUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderApproveLogic.OrderApproveLogic;
import edu.nju.umr.logicService.orderApproveLogicSer.OrderApproveLSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.OrderVO;
import edu.nju.umr.vo.order.ShowOrder;

public class OrderApprovePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApproveTable table;
	private DefaultTableModel model;
	private JFrame frame;
	private OrderApproveLSer serv;
	private ArrayList<OrderVO> orderList;
	private String name;
	private JButton checkButton;
	private int count;
	
	class MyTableModel extends DefaultTableModel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Class getColumnClass(int c) {
	        if(c==0)return new Boolean(true).getClass();
	        return new String().getClass();
	        
	    }
	}
	/**
	 * Create the panel.
	 */
	public OrderApprovePanel(JFrame fr,String name) {
		setLayout(null);
		frame=fr;
		serv=new OrderApproveLogic();
		this.name = name;
		count=0;
		
		JLabel approveLabel = new JLabel("审批单据");
		approveLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		approveLabel.setBounds(505, 40, 93, 24);
		add(approveLabel);
		
		JButton allButton = new JButton("全选");
		allButton.setFont(new Font("宋体", Font.PLAIN, 12));
		allButton.setBounds(927, 103, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		allButton.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			chooseAll();
		}});
		add(allButton);
		
		JButton passedButton = new JButton("通过审批");
		passedButton.setFont(new Font("宋体", Font.PLAIN, 12));
		passedButton.setBounds(927, 159, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		passedButton.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			approve(true);
			dataInit();
		}});
		add(passedButton);
		
		JButton unpassedButton = new JButton("不通过审批");
		unpassedButton.setFont(new Font("宋体", Font.PLAIN, 12));
		unpassedButton.setBounds(927, 215, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		unpassedButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				approve(false);
				dataInit();
			}
		});
		add(unpassedButton);
		
		checkButton = new JButton("查看详细");
		checkButton.setFont(new Font("宋体", Font.PLAIN, 12));
		checkButton.setBounds(927, 271, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		checkButton.setEnabled(false);
		checkButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checkOrder();
			}
		});
		add(checkButton);
		
		JButton refreshButton = new JButton("刷新");
		refreshButton.setFont(new Font("宋体", Font.PLAIN, 12));
		refreshButton.setBounds(927, 327, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		refreshButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				dataInit();
			}
		});
		add(refreshButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(927, 383, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(exitButton);
		tableInit();
		dataInit();

	}
	private void tableInit(){
		table = new ApproveTable(new MyTableModel());
		model=(MyTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false){
					for(int row:table.getSelectedRows())
					{
						if(((Boolean)table.getValueAt(row,0)).booleanValue()){
							table.setValueAt(false,row, 0);
							count--;
						}
						else
						{
							table.setValueAt(true,row, 0);
							count++;
						}
					}
					if(count==1)
					{
						checkButton.setEnabled(true);
					}
					else
					{
						checkButton.setEnabled(false);
					}
					table.clearSelection();
				}
			}
		});
		table.setBounds(193, 71, 717, 421);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(193, 71, 717, 421);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"是否选中","时间","种类","编号","提交人"};
		model.setColumnIdentifiers(columnNames);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
		add(scroll);
	}
	@SuppressWarnings("unchecked")
	private void dataInit(){
		ResultMessage message=serv.askExamine();
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		orderList=(ArrayList<OrderVO>)message.getMessage();
		displayOrders();
	}
	private void displayOrders(){
		model.setRowCount(0);
		String[] kind=new String[]{"中转中心到达单","中转中心装车单","快递单","营业厅装车单","入款单","付款单","收件单",
				"营业厅到达单","派件单","入库单","出库单","中转单"};
		for(int i=0;i<orderList.size();i++){
			OrderVO temp=orderList.get(i);
			int k=0;
			for(Order order:Order.values())
			{
				if(temp.getKind().equals(order))break;
				k++;
			}
			Calendar time=temp.getTime();
			model.addRow(new Object[]{new Boolean(false),DateFormat.TIME.format(time.getTime()),kind[k],temp.getId(),temp.getOperator()});
		}
	}
	private void approve(boolean ispassed){
		ArrayList<Integer> idList=new ArrayList<Integer>();
		for(int i=0;i<table.getRowCount();i++)
		{
			if((boolean)table.getValueAt(i, 0))
			{
				idList.add(i);
			}
		}
		Result result=serv.examine(ispassed, idList,name);
		DoHint.hint(result, frame);
		count=0;
	}
	private void chooseAll(){
		for(int i=0;i<orderList.size();i++)
		{
			table.setValueAt(true,i,0);
		}
	}
	private void checkOrder(){
		int row=-1;
		for(int i=0;i<table.getRowCount();i++)
		{
			if((Boolean)table.getValueAt(i, 0))
			{
				row=i;
				break;
			}
		}
		if(row==-1)return;
		
		OrderVO order=orderList.get(row);
		Order kind=order.getKind();
		String id=order.getId();
		ResultMessage message=serv.chooseOrder(id, kind);
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		ShowOrder orderToShow=(ShowOrder)message.getMessage();
		orderToShow.Show(false);
	}
}