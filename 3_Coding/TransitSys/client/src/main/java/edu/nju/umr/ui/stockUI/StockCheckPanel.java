package edu.nju.umr.ui.stockUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.stockLogic.StockCheckLogic;
import edu.nju.umr.logicService.stockLogicSer.StockCheckLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.DateTimePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockInVO;
import edu.nju.umr.vo.order.StockOutVO;

public class StockCheckPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7371287481571430690L;
	private JFrame frame;
	private Table table;
	private DefaultTableModel model;
	private DateTimePanel dateTimeS;
	private DateTimePanel dateTimeE;
	private StockCheckLSer logicSer;
	private ArrayList<StockInVO> stockInList;
	private ArrayList<StockOutVO> stockOutList;
	/**
	 * Create the panel.
	 */
	public StockCheckPanel(JFrame fr,String orgId) {
		setLayout(null);
		frame=fr;
		logicSer = new StockCheckLogic();
		
		JLabel checkLabel = new JLabel("库存查看");
		checkLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		checkLabel.setBounds(503, 32, 97, 24);
		add(checkLabel);
		
		JLabel startLabel = new JLabel("开始时间");
		startLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		startLabel.setBounds(210, 71, 71, 24);
		add(startLabel);
		
		dateTimeS = new DateTimePanel();
		dateTimeS.setBounds(281, 71, 450, 24);
		add(dateTimeS);
		
		JLabel endLabel = new JLabel("结束时间");
		endLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		endLabel.setBounds(210, 116, 71, 19);
		add(endLabel);
		
		dateTimeE = new DateTimePanel();
		dateTimeE.setBounds(281, 116, 71, 19);
		add(dateTimeE);
		
		JButton confirmButton = new JButton("查看");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 12));
		confirmButton.setBounds(736, 550, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		confirmButton.addActionListener(new ActionListener(){
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if(isLegal()){
					ResultMessage messageIn = logicSer.checkStockIn(dateTimeS.getCalendar(), dateTimeE.getCalendar(), orgId);
					if(messageIn.getReInfo().equals(Result.SUCCESS)){
						stockInList = (ArrayList<StockInVO>) messageIn.getMessage();
					} else {
						@SuppressWarnings("unused")
						HintFrame hint = new HintFrame(messageIn.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
					}
					ResultMessage messageOut = logicSer.checkStockOut(dateTimeS.getCalendar(), dateTimeE.getCalendar(), orgId);
					if(messageOut.getReInfo().equals(Result.SUCCESS)){
						stockOutList = (ArrayList<StockOutVO>) messageOut.getMessage();
					} else {
						@SuppressWarnings("unused")
						HintFrame hint = new HintFrame(messageOut.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
					}
					displayTable();
				}
			}
		});
		add(confirmButton);
		
		JButton exitButton = new JButton("退出查看");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(816, 550, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
			}
		});
		add(exitButton);

		tableInit();
		
	}
	private void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setBounds(219, 156, 665, 372);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(219, 156, 665, 372);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"时间","操作","订单号","架号","排号","位号"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	private boolean isLegal(){
		if(dateTimeS.getCalendar().after(dateTimeE.getCalendar())){
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame("开始时间不能晚于结束时间！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		return true;
	}
	private void displayTable(){
		
	}
}
