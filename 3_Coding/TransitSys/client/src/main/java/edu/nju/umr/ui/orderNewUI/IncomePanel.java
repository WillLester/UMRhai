package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.orderNewLogic.IncomeOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.IncomeOrderLSer;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.Table;

public class IncomePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6715113587313316552L;
	private JComboBox<String> courierCombo;
	private JTextField amountField;
	private JTextField expressField;
	private Table table;
	private JList<String> expressList;
	private IncomeOrderLSer logicSer;
	private DefaultTableModel model;
	private JFrame frame;
	private DatePanel datePanel;
	/**  
	 * Create the panel.
	 */
	public IncomePanel(JFrame fr,String orgId) {
		setLayout(null);
		frame=fr;
		logicSer = new IncomeOrderLogic();
		
		JLabel titleLabel = new JLabel("收款单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setBounds(392+40, 10, 243, 67);
		add(titleLabel);
		
		JLabel dateLabel = new JLabel("收款日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dateLabel.setBounds(297+40, 98, 120, 24);
		add(dateLabel);
		
		datePanel=new DatePanel();
		datePanel.setBounds(474, 98, 285, 26);
		add(datePanel);
		
		JLabel courierLabel = new JLabel("快递员");
		courierLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		courierLabel.setBounds(286+40, 175, 85, 24);
		add(courierLabel);
		
		courierCombo = new JComboBox<String>();
		courierCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		courierCombo.setBounds(355+40, 174, 85, 25);
		add(courierCombo);
		
		JLabel amountLabel = new JLabel("金额");
		amountLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		amountLabel.setBounds(560+40, 175, 85, 24);
		add(amountLabel);
		
		amountField = new JTextField();
		amountField.setFont(new Font("宋体", Font.PLAIN, 20));
		amountField.setColumns(10);
		amountField.setBounds(612+40, 174, 85, 25);
		add(amountField);
		
		JLabel expressLabel = new JLabel("订单条形码号");
		expressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		expressLabel.setBounds(220+40, 255, 130, 24);
		add(expressLabel);
		
		expressField = new JTextField();
		expressField.setFont(new Font("宋体", Font.PLAIN, 20));
		expressField.setColumns(10);
		expressField.setBounds(355+40, 254, 280, 25);
		add(expressField);
		
		JButton addButton = new JButton("新增");
		addButton.setFont(new Font("宋体", Font.PLAIN, 20));
		addButton.setBounds(656+40, 256, 93, 23);
		add(addButton);
		
		JLabel listLabel = new JLabel("已输入订单");
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);
		listLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		listLabel.setBounds(401+40, 289, 130, 24);
		add(listLabel);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(342+40, 499, 93, 23);
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(542+40, 499, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancelButton);
		
		expressList = new JList<String>();
		expressList.setBounds(220+40, 313, 529, 176);
		expressList.setFont(new Font("宋体", Font.PLAIN, 20));
		expressList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(220+40, 313, 529, 176);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.add(expressList);
		add(scroll);

	}
}
