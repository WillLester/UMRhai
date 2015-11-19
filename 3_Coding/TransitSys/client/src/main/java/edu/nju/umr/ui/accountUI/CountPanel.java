package edu.nju.umr.ui.accountUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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

import edu.nju.umr.logic.accountLogic.CountLogic;
import edu.nju.umr.logicService.accountLogicSer.CountLSer;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.Table;
import edu.nju.umr.vo.CountVO;

public class CountPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6592881582489810248L;
//	private JTextField searchField;
	private Table table;
	private DefaultTableModel model;
	private ArrayList<CountVO> countList;
	private JFrame frame;
	private CountLSer serv;
	/**
	 * Create the panel.
	 */
	public CountPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		serv=new CountLogic();
		
		JLabel countLabel = new JLabel("期初建账");
		countLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		countLabel.setBounds(6*Constants.WIDTH_DIV_15, Constants.HEIGHT_DIV_10/10, 2*Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(countLabel);
		
//		searchField = new JTextField();
//		searchField.setText("请输入关键字");
//		searchField.setBounds(Constants.WIDTH_DIV_9*13/10, Constants.HEIGHT_DIV_10*11/10, Constants.TEXTFIELD_WIDTH_L, Constants.TEXTFIELD_HEIGHT);
//		add(searchField);
//		searchField.setColumns(10);
//		
//		
//		JButton searchButton = new JButton("搜索");
//		searchButton.setFont(new Font("宋体", Font.PLAIN, 12));
//		searchButton.setBounds(Constants.WIDTH_DIV_9*13/10+620, Constants.HEIGHT_DIV_10*11/10, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
//		add(searchButton);
		
//		JLabel addLabel = new JLabel("新增账");
//		addLabel.setFont(new Font("华文新魏", Font.PLAIN, 17));
//		addLabel.setBounds(Constants.WIDTH_DIV_9*69/10, Constants.HEIGHT_DIV_10*17/10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
//		add(addLabel);
//		
//		JLabel orgLabel = new JLabel("选择机构");
//		orgLabel.setFont(new Font("宋体", Font.PLAIN, 15));
//		orgLabel.setBounds(Constants.WIDTH_DIV_9*62/10, Constants.HEIGHT_DIV_10*23/10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
//		add(orgLabel);
//		
//		JLabel stockLabel = new JLabel("选择库存");
//		stockLabel.setFont(new Font("宋体", Font.PLAIN, 15));
//		stockLabel.setBounds(Constants.WIDTH_DIV_9*62/10, Constants.HEIGHT_DIV_10*29/10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
//		add(stockLabel);
//		
//		JLabel accountLabel = new JLabel("选择账户");
//		accountLabel.setFont(new Font("宋体", Font.PLAIN, 15));
//		accountLabel.setBounds(Constants.WIDTH_DIV_9*62/10, Constants.HEIGHT_DIV_10*35/10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
//		add(accountLabel);
//		
//		JComboBox orgList = new JComboBox();
//		orgList.setBounds(Constants.WIDTH_DIV_9*67/10, Constants.HEIGHT_DIV_10*23/10+7, Constants.TEXTFIELD_WIDTH_S*9/8, Constants.TEXTFIELD_HEIGHT*5/6);
//		add(orgList);
//		
//		JComboBox stockList = new JComboBox();
//		stockList.setBounds(Constants.WIDTH_DIV_9*67/10, Constants.HEIGHT_DIV_10*29/10+7, Constants.TEXTFIELD_WIDTH_S*9/8, Constants.TEXTFIELD_HEIGHT*5/6);
//		add(stockList);
//		
//		JComboBox accountList = new JComboBox();
//		accountList.setBounds(Constants.WIDTH_DIV_9*67/10, Constants.HEIGHT_DIV_10*35/10+7, Constants.TEXTFIELD_WIDTH_S*9/8, Constants.TEXTFIELD_HEIGHT*5/6);
//		add(accountList);
		
		JButton addButton = new JButton("新增");
		addButton.setFont(new Font("宋体", Font.PLAIN, 12));
		addButton.setBounds(Constants.WIDTH_DIV_9*17/10, Constants.HEIGHT_DIV_10*74/10, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(addButton);
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 12));
		deleteButton.setBounds(Constants.WIDTH_DIV_9*27/10, Constants.HEIGHT_DIV_10*74/10, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(deleteButton);
		
		JButton checkButton = new JButton("查看");
		checkButton.setFont(new Font("宋体", Font.PLAIN, 12));
		checkButton.setBounds(Constants.WIDTH_DIV_9*37/10, Constants.HEIGHT_DIV_10*74/10, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(checkButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(Constants.WIDTH_DIV_9*57/10, Constants.HEIGHT_DIV_10*74/10, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(exitButton);
		
		tableInit();
		//countList=getCounts();
		

	}
	void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setBounds(Constants.WIDTH_DIV_9*13/10, Constants.HEIGHT_DIV_10*17/10, Constants.TEXTFIELD_WIDTH_L*21/20, 14*Constants.TEXTFIELD_HEIGHT);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(Constants.WIDTH_DIV_9*13/10, Constants.HEIGHT_DIV_10*17/10, Constants.TEXTFIELD_WIDTH_L*21/20, 14*Constants.TEXTFIELD_HEIGHT);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"名称","余额"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
//	ArrayList<CountVO> getCounts(){
//		return serv.checkInitInfo(id);
//	}
	void displayCounts(){
		
	}
}
