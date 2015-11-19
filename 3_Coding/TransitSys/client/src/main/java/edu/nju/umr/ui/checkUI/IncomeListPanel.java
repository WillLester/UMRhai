package edu.nju.umr.ui.checkUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.Table;

import javax.swing.JRadioButton;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/*
 * yyy 
 * 20151028
 * 查看收款记录的panel
 */
public class IncomeListPanel extends JPanel {
//	private JTable IncomeTable;
	private Table IncomeTable;
	private DefaultTableModel model;
	JLabel listLabel;
	
	/**
	 * Create the panel.用以查看收款记录
	 */
	public IncomeListPanel() {
		setLayout(null);
		
		//设置panel大小
		this.setSize(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT);
		
		JRadioButton radioButtonDate = new JRadioButton("按日期查看");
		radioButtonDate.setBounds(Constants.TABLE_X, Constants.TABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(radioButtonDate);
		
		DatePanel date=new DatePanel();
		date.setBounds(Constants.TABLE_X, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S, 267, 21);
		add(date);
		
		
		JRadioButton radioButtonHall = new JRadioButton("按营业厅查看");
		radioButtonHall.setBounds(Constants.TABLE_X, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S*2, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(radioButtonHall);
		
		JLabel hallLabel = new JLabel("营业厅");
		hallLabel.setBounds(Constants.TABLE_X, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S*3, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(hallLabel);
		
		JComboBox cbHall=new JComboBox();
		cbHall.setBounds(hallLabel.getX()+hallLabel.getWidth()/2, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S*3+4, Constants.LABEL_WIDTH-10, Constants.LABEL_HEIGHT_S-10);
		add(cbHall);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(this.getWidth()/10*8, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S*3-5, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(cancel);
		
		JButton confirm = new JButton("确认");
		confirm.setBounds(cancel.getX()-Constants.BUTTON_WIDTH-40, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S*3-5, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(confirm);
		
		
		
		
		
		
		JLabel nameLabel = new JLabel("收款记录");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		
		listLabel = new JLabel("收款记录");
		listLabel.setFont(new Font("华文新魏",Font.PLAIN,15));
		listLabel.setBounds(Constants.TABLE_X, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S*4+10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(listLabel);
		
		JButton out = new JButton("退出");
		out.setBounds(this.getWidth()/10*8, IncomeTable.getY()+IncomeTable.getHeight()+20, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(out);
		tableInit();

	}
	void tableInit(){
		IncomeTable = new Table(new DefaultTableModel());
		model=(DefaultTableModel)IncomeTable.getModel();
		IncomeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		IncomeTable.setBounds(233, 101, 637, 335);
		IncomeTable.setBounds(Constants.TABLE_X, listLabel.getY()+Constants.LABEL_HEIGHT_S+5, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		IncomeTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(IncomeTable);
		scroll.setBounds(233, 101, 637, 335);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"时间","金额","快递员","快递编号"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
}
