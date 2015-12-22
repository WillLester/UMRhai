package edu.nju.umr.ui.orderApproveUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import edu.nju.umr.logic.orderApproveLogic.OrderResubmitLogic;
import edu.nju.umr.logicService.orderApproveLogicSer.OrderResubmitLSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.component.*;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.OrderVO;
import edu.nju.umr.vo.order.ShowOrder;

public class OrderRevisePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private ApproveTable table;
	private DefaultTableModel model;
	private JFrame frame;
	private OrderResubmitLSer serv;
	private ArrayList<OrderVO> orderList;
	private String userId;
	/**
	 * Create the panel.
	 */
	public OrderRevisePanel(JFrame fr,String userId) {
		setLayout(null);
		frame=fr;
		serv=new OrderResubmitLogic();
//		serv=new OrderRevisePanelStub();
		this.userId = userId;

		JLabel reviseLabel = new JLabel("未通过单据");
		reviseLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		reviseLabel.setBounds(485, 40, 120, 24);
		add(reviseLabel);
		
		JButton refreshButton=new JButton("刷新");
		refreshButton.setFont(new Font("宋体", Font.PLAIN, 12));
		refreshButton.setBounds(927, 159, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		refreshButton.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			getOrderList();
			displayOrders();
		}});
		add(refreshButton);
	
		Button reviseButton = new Button();
		reviseButton.setIcon(new ImageIcon("ui/button/buttonRev.png"));
		reviseButton.setRolloverIcon(new ImageIcon("ui/button/buttonRevSt.png"));
		reviseButton.setPressedIcon(new ImageIcon("ui/button/buttonRevP.png"));
		reviseButton.setBounds(927, 271, 100, 30);
		reviseButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				displayOrder();
			}
		});
		add(reviseButton);
		
		
		Button exitButton = new ExitButton();
		exitButton.setBounds(927, 383, 100,30);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(exitButton);
		
		tableInit();
		getOrderList();
		displayOrders();
		
	}
	private void tableInit(){
		table = new ApproveTable(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.setBounds(193, 71, 717, 421);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(193, 71, 717, 421);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"时间","种类"};
		model.setColumnIdentifiers(columnNames);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
		add(scroll);
	}
	@SuppressWarnings("unchecked")
	private void getOrderList(){
		orderList=new ArrayList<OrderVO>();
		try
		{
			ResultMessage message = serv.getUnpassed(userId);
			Result result=message.getReInfo();
			if(!result.equals(Result.SUCCESS))
			{
				DoHint.hint(result, frame);
				return;
			}
			message= serv.getOrdersDisplay();
			result=message.getReInfo();
			if(!result.equals(Result.SUCCESS))
			{
				DoHint.hint(result, frame);
				return;
			}
			orderList=(ArrayList<OrderVO>)message.getMessage();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private void displayOrders(){
		model.setRowCount(0);
		String[] kind=new String[]{"中转中心到达单","中转中心装车单","快递单","营业厅装车单","入款单","付款单","收件单",
				"营业厅到达单","派件单","入库单","出库单","中转单"};
		for(OrderVO vo:orderList)
		{
			int k=0;
			for(Order order:Order.values())
			{
				if(vo.getKind().equals(order))break;
				k++;
			}
			String [] data=new String[]{new SimpleDateFormat("yyyy-MM-dd").format(vo.getTime().getTime()),kind[k]};
			model.addRow(data);
		}
	}
	private void displayOrder(){
		int row=table.getSelectedRow();
		if(row<0||row>=orderList.size())return;
		ResultMessage message=serv.getOrder(row);
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			DoHint.hint(result, frame);
			return;
		}
		ShowOrder order=(ShowOrder)message.getMessage();
		order.Show(true);
	}
}
