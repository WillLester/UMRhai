package edu.nju.umr.ui.stockUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.stockLogic.StockCheckLogic;
import edu.nju.umr.logicService.stockLogicSer.StockCheckLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DateTimePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockInOutVO;

public class StockCheckPanel extends PPanel{
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
	private ArrayList<StockInOutVO> stockInOutList;
	/**
	 * Create the panel.
	 */
	public StockCheckPanel(JFrame fr,String orgId) {
		setLayout(null);
		frame=fr;
		logicSer = new StockCheckLogic();
		tableInit();
		
		JLabel checkLabel = new JLabel("库存查看");
		checkLabel.setFont(new Font("微软雅黑", Font.PLAIN, 22));
		checkLabel.setBounds(503, 32, 97, 24);
		add(checkLabel);
		
		Color color = new Color(57, 152,214);
		
		JLabel startLabel = new JLabel("开始时间");
		startLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		startLabel.setForeground(color);
		startLabel.setBounds(210, 71, 71, 24);
		add(startLabel);
		
		dateTimeS = new DateTimePanel();
		dateTimeS.setBounds(281, 71, 750, 25);
		add(dateTimeS);
		
		JLabel endLabel = new JLabel("结束时间");
		endLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		endLabel.setForeground(color);
		endLabel.setBounds(210, 116, 71, 19);
		add(endLabel);
		
		dateTimeE = new DateTimePanel();
		dateTimeE.setBounds(281, 116, 750, 25);
		add(dateTimeE);
		
		Button confirmButton = new ConfirmButton();
		confirmButton.setBounds(700, 550, 100,30);
		confirmButton.addActionListener(new ActionListener(){
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if(isLegal()){
					ResultMessage message = logicSer.orderStock(dateTimeS.getCalendar(), dateTimeE.getCalendar(), orgId);
					if(message.getReInfo().equals(Result.SUCCESS)){
						stockInOutList = (ArrayList<StockInOutVO>) message.getMessage();
					} else {
						DoHint.hint(message.getReInfo(), fr);
						stockInOutList = new ArrayList<StockInOutVO>();
					}
					displayTable();
				}
			}
		});
		add(confirmButton);
		
		Button exitButton = new ExitButton();
		exitButton.setBounds(816, 550, 100, 30);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
			}
		});
		add(exitButton);


		
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
		String[] columnNames={"编号","时间","操作","订单号","架号","排号","位号"};
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
		model.setRowCount(0);
		for(StockInOutVO inOut:stockInOutList){
			String info[] = new String[7];
			info[0] = inOut.getId();
			info[1] = DateFormat.TIME.format(inOut.getTime().getTime());
			info[2] = inOut.getType();
			info[3] = inOut.getExpressId();
			info[4] = inOut.getShelfId();
			info[5] = inOut.getRow()+"";
			info[6] = inOut.getPlace()+"";
			model.addRow(info);
		}
	}
}
