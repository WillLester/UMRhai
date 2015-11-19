package edu.nju.umr.ui.stockUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.Table;

public class StockDividePanel extends JPanel{
	private JTextField searchField;
	private JTextField idField;
	private JTextField rowField;
	private JTextField placeField;
	private JFrame frame;
	
	private Table table;
	private DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public StockDividePanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		JLabel divideLabel = new JLabel("库存分区");
		divideLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		divideLabel.setBounds(508, 36, 88, 24);
		add(divideLabel);
		
		searchField = new JTextField();
		searchField.setText("请输入架的编号");
		searchField.setBounds(233, 67, 542, 24);
		add(searchField);
		searchField.setColumns(10);
		
		
		JButton searchButton = new JButton("搜索");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 12));
		searchButton.setBounds(827, 66, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(searchButton);
		
		JLabel idLabel = new JLabel("编号");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		idLabel.setBounds(206, 500, 54, 24);
		add(idLabel);
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(253, 500, 98, 22);
		add(idField);
		idField.setColumns(10);
		
		JLabel rowLabel = new JLabel("排数");
		rowLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		rowLabel.setBounds(370, 500, 54, 24);
		add(rowLabel);
		
		rowField = new JTextField();
		rowField.setBounds(416, 500, 98, 22);
		add(rowField);
		rowField.setColumns(10);
		
		JLabel placeLabel = new JLabel("每排位数");
		placeLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		placeLabel.setBounds(541, 500, 71, 24);
		add(placeLabel);
		
		placeField = new JTextField();
		placeField.setBounds(617, 500, 98, 22);
		add(placeField);
		placeField.setColumns(10);
		
		JLabel partLabel = new JLabel("所在区");
		partLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		partLabel.setBounds(742, 500, 54, 24);
		add(partLabel);
		
		JComboBox partCombo = new JComboBox();
		partCombo.setBounds(803, 500, 98, 21);
		add(partCombo);
		
		JButton addButton = new JButton("新增");
		addButton.setFont(new Font("宋体", Font.PLAIN, 12));
		addButton.setBounds(332, 541, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(addButton);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 12));
		deleteButton.setBounds(455, 541, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(deleteButton);
		
		JButton confirmButton = new JButton("确认修改");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 12));
		confirmButton.setBounds(578, 541, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消修改");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 12));
		cancelButton.setBounds(701, 541, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(cancelButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(881, 541, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
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
		table.setBounds(233, 109, 638, 371);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(233, 109, 638, 371);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"分区名称","大小"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
}
