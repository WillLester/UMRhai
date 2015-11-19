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

import edu.nju.umr.logic.accountLogic.AccountLogic;
import edu.nju.umr.logicService.accountLogicSer.AccountLSer;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.Table;

public class AccountManPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5046945253769534297L;
	private JTextField textField;
	private JTextField nameField;
	private JTextField balanceField;
	private Table table;
	private DefaultTableModel model;
	private AccountLSer accountLSer;
	private JFrame frame;
	private ArrayList<AccountVO> accountList;
	private AccountLSer serv;
	/**
	 * Create the panel.
	 */
	public AccountManPanel(JFrame fr) {
		setLayout(null);
		serv=new AccountLogic();
		
		JLabel accountLabel = new JLabel("账户管理");
		accountLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		accountLabel.setBounds(504, 6, 96, 60);
		add(accountLabel);
		frame = fr;
		
		textField = new JTextField();
		textField.setText("请输入关键字");
		textField.setBounds(233, 67, 442, 24);
		add(textField);
		textField.setColumns(10);
		accountLSer = new AccountLogic();
		
		JButton searchButton = new JButton("搜索");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 12));
		searchButton.setBounds(233+442, 65, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(searchButton);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				accountList=getAccounts(textField.getText());
				displayAccounts();
			}
		});
		
		JButton allButton = new JButton("显示全部");
		allButton.setFont(new Font("宋体", Font.PLAIN, 12));
		allButton.setBounds(233+442+100, 65, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(allButton);
		allButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				accountList=getAccounts("");
				displayAccounts();
			}
		});
		
		nameField = new JTextField();
		nameField.setBounds(360, 468, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel nameLabel = new JLabel("账户名称");
		nameLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		nameLabel.setBounds(283, 465, 67, 30);
		add(nameLabel);
		
		JLabel balanceLabel = new JLabel("账户余额");
		balanceLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		balanceLabel.setBounds(566, 465, 67, 30);
		add(balanceLabel);
		
		balanceField = new JTextField();
		balanceField.setEditable(false);
		balanceField.setBounds(643, 468, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(balanceField);
		balanceField.setColumns(10);
		
		JButton addButton = new JButton("新增");
		addButton.setFont(new Font("宋体", Font.PLAIN, 12));
		addButton.setBounds(326, 525, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				addAccount();
			}
		});
		add(addButton);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 12));
		deleteButton.setBounds(435, 525, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				accountLSer.deleteAccount(null);
			}
		});
		
		JButton confirmButton = new JButton("确认修改");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 12));
		confirmButton.setBounds(546, 525, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		
		JButton cancelButton = new JButton("取消修改");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 12));
		cancelButton.setBounds(656, 525, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(cancelButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(798, 525, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				frame.dispose();
			}
		});

		tableInit();
		//accountList=getAccounts("");
		//displayAccounts();
		
	}
	void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setBounds(233, 101, 637, 335);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(233, 101, 637, 335);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"名称","余额"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	ArrayList<AccountVO> getAccounts(String keyword){
		return (ArrayList<AccountVO>)serv.searchAccount(keyword).getMessage();
	}
	void displayAccounts(){
		model.setRowCount(0);
		for(int i=0;i<accountList.size();i++)
		{
			AccountVO ac=accountList.get(i);
			String[] data={ac.getName(),Integer.toString(ac.getBalance())};
			model.addRow(data);
		}
	}
	void addAccount(){
		
	}
	
}
