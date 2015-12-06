package edu.nju.umr.ui.userUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.userLogic.UserManLogic;
import edu.nju.umr.logicService.userLogicSer.UserManLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;


public class UserListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3156670290800175855L;
	private JTextField textField;
	private JTextField idField;
	private JTextField passwordField;
	private JTextField nameField;
	private JTextField mobileField;
	private JTextField orgIdField;
	private JTextField orgField;
	private Table table;
	private DefaultTableModel model;
	private JComboBox<String> juriBox;
	
	private JButton confirmButton;
	private JButton addButton;
	
	private JFrame frame;
	private UserManLSer serv;
	
	private ArrayList<UserVO> users;
	/**
	 * Create the panel.
	 */
	public UserListPanel(JFrame fr) {
		serv=new UserManLogic();
		frame=fr;
		setLayout(null);
		
		JLabel accountLabel = new JLabel("用户管理");
		accountLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		accountLabel.setBounds(504, 6, 129, 60);
		add(accountLabel);
		
		textField = new JTextField();
		textField.setText("请输入关键字");
		textField.setBounds(133, 67, 442, 24);
		add(textField);
		textField.setColumns(10);
		
		
		JButton searchButton = new JButton("搜索");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 12));
		searchButton.setBounds(577, 66, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				users=getUsers(textField.getText());
				displayUsers();
			}
		});
		add(searchButton);
		
		JButton allButton = new JButton("显示全部");
		allButton.setFont(new Font("宋体", Font.PLAIN, 12));
		allButton.setBounds(577+100, 66, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		allButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				users=getUsers(null);
				displayUsers();
			}
		});
		add(allButton);
		
		addButton = new JButton("新增");
		addButton.setFont(new Font("宋体", Font.PLAIN, 12));
		addButton.setBounds(283, 487, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				addButton.setEnabled(false);
				addUser();
			}
		});
		add(addButton);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 12));
		deleteButton.setBounds(525, 487, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		deleteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				int n = JOptionPane.showConfirmDialog(frame, "确认删除吗?", "确认删除框", JOptionPane.YES_NO_OPTION);  
		        if (n == JOptionPane.YES_OPTION) {  
		        	deleteUser();
		        }
			}
		});
		add(deleteButton);
		
		confirmButton = new JButton("确认修改");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 12));
		confirmButton.setBounds(895, 487-100, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				confirmChange();
			}
		});
		add(confirmButton);
//		
//		JButton cancelButton = new JButton("查看");
//		cancelButton.setFont(new Font("宋体", Font.PLAIN, 12));
//		cancelButton.setBounds(626, 487, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
//		add(cancelButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(895, 537, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(exitButton);
		
		JLabel idLabel=new JLabel("账号");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		idLabel.setBounds(805,121, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(idLabel);
		
		JLabel passwordLabel=new JLabel("密码");
		passwordLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		passwordLabel.setBounds(805,171, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(passwordLabel);
		
		JLabel juriLabel=new JLabel("权限");
		juriLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		juriLabel.setBounds(805,221, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(juriLabel);
		
		JLabel nameLabel=new JLabel("姓名");
		nameLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		nameLabel.setBounds(805,271, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(nameLabel);
		
		JLabel orgLabel=new JLabel("机构");
		orgLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		orgLabel.setBounds(805,321, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
//		add(orgLabel);
		
		JLabel orgIdLabel=new JLabel("机构编号");
		orgIdLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		orgIdLabel.setBounds(805,371, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
//		add(orgIdLabel);
		
		JLabel mobileIdLabel=new JLabel("手机号");
		mobileIdLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		mobileIdLabel.setBounds(805,421-100, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(mobileIdLabel);
		
		idField=new JTextField("账号");
		idField.setFont(new Font("宋体", Font.PLAIN, 12));
		idField.setBounds(855,121,200,24);
		add(idField);
		
		passwordField=new JTextField("密码");
		passwordField.setFont(new Font("宋体", Font.PLAIN, 12));
		passwordField.setBounds(855,171,200,24);
		add(passwordField);
		
//		JTextField juriField=new JTextField("权限");
//		juriField.setFont(new Font("宋体", Font.PLAIN, 12));
//		juriField.setBounds(855,221,200,24);
//		add(juriField);
		
		juriBox = new JComboBox<String>();
		juriBox.setModel(new DefaultComboBoxModel<String>(new String[] {"总经理", "高级财务人员", "普通财务人员","快递员","营业厅业务员","中转中心业务员","中转中心仓库管理人员"}));
		juriBox.setFont(new Font("宋体", Font.PLAIN, 12));
		juriBox.setBounds(855, 221, 200, 24);
		add(juriBox);
		
		nameField=new JTextField("姓名");
		nameField.setFont(new Font("宋体", Font.PLAIN, 12));
		nameField.setBounds(855,271,200,24);
		add(nameField);
		
		orgField=new JTextField("机构");
		orgField.setFont(new Font("宋体", Font.PLAIN, 12));
		orgField.setBounds(855,321,200,24);
//		add(orgField);
		
//		JComboBox comboBox_2 = new JComboBox();
//		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {}));
//		comboBox_2.setFont(new Font("宋体", Font.PLAIN, 12));
//		comboBox_2.setBounds(855, 321, 200, 24);
//		add(comboBox_2);
		
		orgIdField=new JTextField("机构编号");
		orgIdField.setFont(new Font("宋体", Font.PLAIN, 12));
		orgIdField.setBounds(855,371,200,24);
//		add(orgIdField);

		mobileField=new JTextField("手机号");
		mobileField.setFont(new Font("宋体", Font.PLAIN, 12));
		mobileField.setBounds(855,421-100,200,24);
		add(mobileField);
		
		tableInit();
		users=getUsers(null);
		displayUsers();
	}
	private void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false)
				displayUser(table.getSelectedRow());
			}
		});
		table.setBounds(133, 121, 637, 335);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(133, 121, 637, 335);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"账号","密码","权限","姓名","手机号"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	@SuppressWarnings("unchecked")
	private ArrayList<UserVO> getUsers(String keyword)
	{
		ArrayList<UserVO> temp=new ArrayList<UserVO>();
		ResultMessage message;
		message=serv.findUser(keyword);
		if(message.getReInfo().equals(Result.SUCCESS))
		{
			temp=(ArrayList<UserVO>)message.getMessage();
		}
		else reportWrong(message.getReInfo());
		return temp;
	}
	private void displayUsers(){
		model.setRowCount(0);
		for(int i=0;i<users.size();i++)
		{
			UserVO user=users.get(i);
			String lv=null;
			lv = EnumTransFactory.checkJuri(user.getJuri());
			String[] rowData={user.getId(),user.getPassword(),lv,user.getName(),user.getMobile()};
			model.addRow(rowData);
		}
	}
	private void addUser(){
		String[] rowData={"","","","","",""};
		model.addRow(rowData);
		table.getSelectionModel().setSelectionInterval(model.getRowCount()-1, model.getRowCount()-1);
	}
	private void displayUser(int row)
	{
		if(row<0||row>=table.getRowCount())return;
		String []data=new String[5];
		for(int i=0;i<5;i++)
		{
			data[i]=(String)table.getValueAt(row, i);
		}
		idField.setText(data[0]);
		passwordField.setText(data[1]);
		juriBox.getModel().setSelectedItem(data[2]);
		nameField.setText(data[3]);
		mobileField.setText(data[4]);
	}
	private void confirmChange(){
		int row=table.getSelectedRow();
		if(row<0||row>=table.getRowCount())return;
		Jurisdiction jur=null;
		String temp=(String)juriBox.getModel().getSelectedItem();
		if(temp.isEmpty())
		{
			DoHint.hint("权限未选择!", frame);return;
		}
		jur = EnumTransFactory.getJuri(temp);
		String id=idField.getText();
		String password=passwordField.getText();
		String name=nameField.getText();
		String mobile=mobileField.getText();
		if(id.isEmpty()){DoHint.hint("账号未输入!", frame);return;}
		if(password.isEmpty()){DoHint.hint("密码未输入!", frame);return;}
		if(name.isEmpty()){DoHint.hint("姓名未输入!", frame);return;}
		if(mobile.isEmpty()){DoHint.hint("手机号未输入!", frame);return;}
		
		if(row<users.size()){
			UserVO now=new UserVO(idField.getText(),passwordField.getText(),jur,nameField.getText(),mobileField.getText(),orgField.getText(),orgIdField.getText());
			Result result=serv.reviseUser(now,row);
			if(result.equals(Result.SUCCESS)){
			    users.set(row, now);
			    displayUsers();
			}
			else {
				reportWrong(result);
			}
		}
		else
		{
			UserVO now=new UserVO(idField.getText(),passwordField.getText(),jur,nameField.getText(),mobileField.getText(),orgField.getText(),orgIdField.getText());
			Result result=serv.newUser(now);
			if(result.equals(Result.SUCCESS)){
			users.add(now);
			displayUsers();
			addButton.setEnabled(true);
			}
			else {
				reportWrong(result);
			}
		}
	}
	private void deleteUser(){
		int row=table.getSelectedRow();
		if(row<0||row>=users.size())return;
		Result result=serv.deleteUser(users.get(row).getId());
		if(result.equals(Result.SUCCESS)){
		users.remove(row);
		table.getSelectionModel().setSelectionInterval(row-1, row-1);
		displayUsers();
		}
		else reportWrong(result);
	}
	private void reportWrong(Result result){
		DoHint.hint(result, frame);
	}
	
	
	
}
