package edu.nju.umr.ui.accountUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.accountLogic.AccountLogic;
import edu.nju.umr.logicService.accountLogicSer.AccountLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.ELabel;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.UMRScrollPane;
import edu.nju.umr.ui.component.button.AddButton;
import edu.nju.umr.ui.component.button.CanModButton;
import edu.nju.umr.ui.component.button.ConfirmModButton;
import edu.nju.umr.ui.component.button.DelButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.component.button.SearchButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.ResultMessage;

public class AccountManPanel extends PPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5046945253769534297L;
	private TextField searchField;
	private TextField nameField;
	private TextField balanceField;
	private Table table;
	private DefaultTableModel model;
	private AccountLSer accountLSer;
	private JFrame frame;
	private ArrayList<AccountVO> accountList;
	private AccountLSer logicSer;
	private static final int y=20;
	private static final int sec_y=10;
	/**
	 * Create the panel.
	 */
	public AccountManPanel(JFrame fr,String name) {
		setLayout(null);
		logicSer=new AccountLogic();
			
		TitleLabel accountLabel = new TitleLabel("账户管理");
		add(accountLabel);
		frame = fr;
		
		searchField = new TextField();
		searchField.setBounds(233,sec_y+ y+67, 402, 24);
		add(searchField);
		searchField.setColumns(10);
		accountLSer = new AccountLogic();
		
		Button searchButton = new SearchButton();
		searchButton.setBounds(233+442-20,sec_y+ y+65,100, 30);
		add(searchButton);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(isSearchLegal()){
					getAccounts(searchField.getText());
					displayAccounts();
				}
			}
		});
		
		Button allButton = new Button();
		allButton.setIcon(new ImageIcon("ui/button/buttonAll.png"));
		allButton.setRolloverIcon(new ImageIcon("ui/button/buttonAllSt.png"));
		allButton.setPressedIcon(new ImageIcon("ui/button/buttonAllP.png"));
		allButton.setBounds(233+442+100, sec_y+y+65, 100, 30);
		add(allButton);
		allButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				getAccounts(null);
				displayAccounts();
			}
		});
		
		nameField = new TextField();
		nameField.setBounds(360, sec_y+y+468, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(nameField);
		nameField.setColumns(10);
		
		ELabel nameLabel = new ELabel("账户名称");
		nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		nameLabel.setBounds(283, sec_y+y+465, 67, 30);
		add(nameLabel);
		
		ELabel balanceLabel = new ELabel("账户余额");
		balanceLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		balanceLabel.setBounds(566, sec_y+ y+465,67, 30);
		add(balanceLabel);
		
		balanceField = new TextField();
		balanceField.setEditable(false);
		balanceField.setBounds(643, sec_y+ y+468,Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(balanceField);
		balanceField.setColumns(10);
		
		Button addButton = new AddButton();
		addButton.setBounds(326, y+525, 100, 30);
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addAccount();
			}
		});
		add(addButton);
		
		Button deleteButton = new DelButton();
		deleteButton.setBounds(435, y+525,100,30);
		add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int n = JOptionPane.showConfirmDialog(frame, "确认删除吗?", "确认删除框", JOptionPane.YES_NO_OPTION);  
		        if (n == JOptionPane.YES_OPTION) {  
		        	Result result = accountLSer.deleteAccount(table.getSelectedRow(),name);
		        	if(result.equals(Result.SUCCESS)){
		        		fresh();
		        		DoHint.hint(result, frame);
		        	}
		        	else {
		        		@SuppressWarnings("unused")
		        		HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
		        	}
		        }
			}
		});
		
		Button confirmButton = new ConfirmModButton();
		confirmButton.setBounds(546,y+ 525,100, 30);
		add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(isModifyLegal()){
					Result result;
					if(table.getSelectedRow() >= accountList.size()){
						result = logicSer.addAccount(new AccountVO(nameField.getText(), new BigDecimal(0)),name);
					} else {
						result = logicSer.reviseAccount(new AccountVO(nameField.getText(), new BigDecimal(balanceField.getText())), table.getSelectedRow(),name);
					}
					if(result.equals(Result.SUCCESS)){
						fresh();
						DoHint.hint(result, frame);
					} else {
						@SuppressWarnings("unused")
						HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
					}
				}
			}
		});
		
		Button cancelButton = new CanModButton();
		cancelButton.setBounds(656, y+525,100,30);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				AccountVO account = accountList.get(table.getSelectedRow());
				nameField.setText(account.getName());
				balanceField.setText(account.getBalance()+"");
			}
		});
		add(cancelButton);
		
		Button exitButton = new ExitButton();
		exitButton.setBounds(798, y+525, 100, 30);
		add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				frame.dispose();
			}
		});

		tableInit();
		getAccounts(null);
		displayAccounts();
		
	}
	private void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false){
					if((table.getSelectedRow() >= 0)&&(table.getSelectedRow() < accountList.size())){
						AccountVO vo = accountList.get(table.getSelectedRow());
						nameField.setText(vo.getName());
						balanceField.setText(vo.getBalance().toString());
					}
				}
			}
		});
		table.setBounds(233, sec_y+y+101, 637, 335);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		UMRScrollPane scroll=new UMRScrollPane(table);
		scroll.setBounds(233, sec_y+y+101, 637, 335);
		scroll.setVerticalScrollBarPolicy(UMRScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"名称","余额"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	@SuppressWarnings("unchecked")
	private void getAccounts(String keyword){
		ResultMessage message = logicSer.searchAccount(keyword);
		if(message.getReInfo().equals(Result.SUCCESS)){
			accountList = (ArrayList<AccountVO>) logicSer.searchAccount(keyword).getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(message.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			accountList = new ArrayList<AccountVO>();
		}
		
	}
	private void displayAccounts(){
		model.setRowCount(0);
		table.clearSelection();
		nameField.setText("");
		balanceField.setText("");
		for(int i=0;i<accountList.size();i++){
			AccountVO account=accountList.get(i);
			String[] data={account.getName(),""+account.getBalance()};
			model.addRow(data);
		}
	}
	private void addAccount(){
		String info[] = {"",""};
		model.addRow(info);
		table.getSelectionModel().setSelectionInterval(table.getRowCount()-1, table.getRowCount()-1);
		nameField.setText("");
		balanceField.setText("0");
	}
	private boolean isSearchLegal(){
		if(searchField.getText().equals("")){
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame("请输入关键字！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		return true;
	}
	private void fresh(){
		if(searchField.getText().equals("")){
			getAccounts(null);
		} else {
			getAccounts(searchField.getText());
		}
		displayAccounts();
	}
	private boolean isModifyLegal(){
		if(nameField.getText().equals("")){
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame("请输入账户名称！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		return true;
	}
}
