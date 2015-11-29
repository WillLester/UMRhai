package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.Table;

public class IncomePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6715113587313316552L;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Table table;
	private JList<String> expressList;
	
	private DefaultTableModel model;
	private JFrame frame;
	private DatePanel datePanel;
	/**  
	 * Create the panel.
	 */
	public IncomePanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		JLabel lblNewLabel = new JLabel("收款单");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(392+40, 10, 243, 67);
		add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("收款日期");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(297+40, 98, 120, 24);
		add(lblNewLabel_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(2015), new Integer(0), null, new Integer(1)));
		spinner.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner.setBounds(411+40, 97, 85, 26);
		add(spinner);
		
		datePanel=new DatePanel();
		datePanel.setBounds(474+75+25, 268, 285, 26);
		add(datePanel);
		
		JLabel label_3 = new JLabel("快递员");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(286+40, 175, 85, 24);
		add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(355+40, 174, 85, 25);
		add(textField_2);
		
		JLabel label_4 = new JLabel("金额");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(560+40, 175, 85, 24);
		add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(612+40, 174, 85, 25);
		add(textField_3);
		
		JLabel label_7 = new JLabel("订单条形码号");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("宋体", Font.PLAIN, 20));
		label_7.setBounds(220+40, 255, 130, 24);
		add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(355+40, 254, 280, 25);
		add(textField_4);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(656+40, 256, 93, 23);
		add(btnNewButton);
		
		JLabel label_8 = new JLabel("已输入订单");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("宋体", Font.PLAIN, 20));
		label_8.setBounds(401+40, 289, 130, 24);
		add(label_8);
		
		
		JButton button = new JButton("确定");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(342+40, 499, 93, 23);
		add(button);
		
		JButton cancel = new JButton("取消");
		cancel.setFont(new Font("宋体", Font.PLAIN, 20));
		cancel.setBounds(542+40, 499, 93, 23);
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancel);
		tableInit();

	}	
	void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		table.setBounds(220+40, 313, 529, 176);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(220+40, 313, 529, 176);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"订单号"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
}
