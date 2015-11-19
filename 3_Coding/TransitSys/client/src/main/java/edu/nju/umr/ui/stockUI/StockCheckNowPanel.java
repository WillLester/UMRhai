package edu.nju.umr.ui.stockUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.Table;

public class StockCheckNowPanel extends JPanel{
	private JFrame frame;
	private Table table;
	private DefaultTableModel model;
	public StockCheckNowPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		JLabel checkLabel = new JLabel("库存盘点");
		checkLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		checkLabel.setBounds(504, 31, 95, 24);
		add(checkLabel);
		
		JButton checkButton = new JButton("盘点");
		checkButton.setFont(new Font("宋体", Font.PLAIN, 12));
		checkButton.setBounds(947, 150, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(checkButton);
		
		JButton confirmButton = new JButton("确认盘点");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 12));
		confirmButton.setBounds(947, 213, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(confirmButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(947, 276, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(exitButton);

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
		table.setBounds(186, 84, 731, 442);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(186, 84, 731, 442);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"快递编号","入库日期","目的地","区号","排号","架号","位号"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
}
