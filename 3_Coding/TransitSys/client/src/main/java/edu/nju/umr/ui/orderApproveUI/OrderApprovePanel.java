package edu.nju.umr.ui.orderApproveUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
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
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.button.CheckButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.OrderVO;
import edu.nju.umr.vo.order.ShowOrder;

public class OrderApprovePanel extends PPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApproveTable table;
	private DefaultTableModel model;
	private FunctionFrame frame;
	private OrderApproveLSer serv;
	private ArrayList<OrderVO> orderList;
	private String name;
	private Button checkButton;
	private Button passedButton;
	private Button unpassedButton;
	private static final int dis=56;
	private static final int this_y=125;
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
	public OrderApprovePanel(FunctionFrame fr,String name) {
		setLayout(null);
		frame=fr;
		serv=new OrderApproveLogic();
//		serv=new OrderApprovePanelStub();
		this.name = name;
		
		TitleLabel approveLabel = new TitleLabel("审批单据");
		add(approveLabel);
		
		Button allButton = new Button();
		allButton.setIcon(new ImageIcon("ui/button/buttonAllSelect.png"));
		allButton.setRolloverIcon(new ImageIcon("ui/button/buttonAllSelectSt.png"));
		allButton.setPressedIcon(new ImageIcon("ui/button/buttonAllSelectP.png"));
		allButton.setBounds(927, this_y,100, 30);
		allButton.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			chooseAll();
		}});
		add(allButton);
		
		passedButton = new Button();
		passedButton.setIcon(new ImageIcon("ui/button/buttonPassed.png"));
		passedButton.setRolloverIcon(new ImageIcon("ui/button/buttonPassedSt.png"));
		passedButton.setPressedIcon(new ImageIcon("ui/button/buttonPassedP.png"));
		passedButton.setBounds(927, this_y+dis, 100,30);
		passedButton.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			approve(true);
			dataInit();
		}});
		add(passedButton);
		
		unpassedButton = new Button();
		unpassedButton.setIcon(new ImageIcon("ui/button/buttonUnpa.png"));
		unpassedButton.setRolloverIcon(new ImageIcon("ui/button/buttonUnpaSt.png"));
		unpassedButton.setPressedIcon(new ImageIcon("ui/button/buttonUnpaP.png"));
		unpassedButton.setBounds(927, this_y+2*dis,100,30);
		unpassedButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				approve(false);
				dataInit();
			}
		});
		add(unpassedButton);
		
		checkButton = new CheckButton();
		checkButton.setBounds(927, this_y+3*dis,100, 30);
		checkButton.setEnabled(false);
		checkButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checkOrder();
			}
		});
		add(checkButton);
		
		Button refreshButton = new Button();
		refreshButton.setIcon(new ImageIcon("ui/button/buttonFresh.png"));
		refreshButton.setRolloverIcon(new ImageIcon("ui/button/buttonFreshSt.png"));
		refreshButton.setPressedIcon(new ImageIcon("ui/button/buttonFreshP.png"));
		refreshButton.setBounds(927, this_y+4*dis, 100, 30);
		refreshButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				dataInit();
			}
		});
		add(refreshButton);
		
		Button exitButton = new ExitButton();
		exitButton.setBounds(927, this_y+5*dis+100,100,30);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(exitButton);
		tableInit();
		dataInit();
		
		passedButton.setEnabled(false);
		unpassedButton.setEnabled(false);

	}
	private void tableInit(){
		table = new ApproveTable(new MyTableModel());
		model=(MyTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false){
					int count=0;
					for(int row:table.getSelectedRows())
					{
						if(((Boolean)table.getValueAt(row,0)).booleanValue()){
							table.setValueAt(false,row, 0);
						}
						else
						{
							table.setValueAt(true,row, 0);
						}
					}
					for(int i=0;i<table.getRowCount();i++){
						if((Boolean)table.getValueAt(i, 0)){
							count++;
						}
					}
					if(count==0){
						passedButton.setEnabled(false);
						unpassedButton.setEnabled(false);
						checkButton.setEnabled(false);
					}
					else{
						passedButton.setEnabled(true);
						unpassedButton.setEnabled(true);
						if(count==1){
							checkButton.setEnabled(true);
						}else{
							checkButton.setEnabled(false);
						}
					}
					table.clearSelection();
				}
			}
		});
		table.setBounds(180, Constants.LAYOUT_FIR_Y, 717, 421);
		table.getTableHeader().setReorderingAllowed(false);
		UMRScrollPane scroll=new UMRScrollPane(table);
		scroll.setBounds(180, Constants.LAYOUT_FIR_Y, 717, 421);
		scroll.setVerticalScrollBarPolicy(UMRScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
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
		String[] kind=new String[]{"中转中心到达单","中转中心装车单","快递单","营业厅装车单","入款单","付款单",
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
		
		passedButton.setEnabled(false);
		unpassedButton.setEnabled(false);
		checkButton.setEnabled(false);
	}
	private void chooseAll(){
		for(int i=0;i<orderList.size();i++)
		{
			table.setValueAt(true,i,0);
			passedButton.setEnabled(true);
			unpassedButton.setEnabled(true);
			checkButton.setEnabled(true);
			if(i>0){
				checkButton.setEnabled(false);
			}
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