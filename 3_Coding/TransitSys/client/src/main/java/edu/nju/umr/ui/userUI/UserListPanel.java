package edu.nju.umr.ui.userUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.userLogic.UserManLogic;
import edu.nju.umr.logicService.userLogicSer.UserManLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.component.AddButton;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.ConfirmModButton;
import edu.nju.umr.ui.component.DelButton;
import edu.nju.umr.ui.component.ExitButton;
import edu.nju.umr.ui.component.SearchButton;
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
	private Table table;
	private DefaultTableModel model;
	private JComboBox<String> juriBox;
	private Button deleteButton;
	private Button confirmButton;
	private Button addButton;
	
	private FunctionFrame frame;
	private UserManLSer serv;
	
	private ArrayList<UserVO> users;
	private String name;
	/**
	 * Create the panel.
	 */
	public UserListPanel(FunctionFrame fr,String name){
		serv=new UserManLogic();
//		serv=new UserListPanelStub();
		frame=fr;
		setLayout(null);
		this.name = name;
		
		JLabel accountLabel = new JLabel("用户管理");
		accountLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		accountLabel.setBounds(504, 6, 129, 60);
		add(accountLabel);
		
		textField = new JTextField();
		textField.setText("请输入关键字");
		textField.setBounds(133, 67, 442, 24);
		add(textField);
		textField.setColumns(10);
		
		
		Button searchButton = new SearchButton();
		searchButton.setBounds(577, 66, 100, 30);
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
			public void actionPerformed(ActionEvent e){
				users=getUsers(null);
				displayUsers();
			}
		});
		add(allButton);
		
		addButton = new AddButton();
		addButton.setBounds(283, 487,100, 30);
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addUser();
			}
		});
		add(addButton);
		
		deleteButton = new DelButton();
		deleteButton.setBounds(525, 487, 100,30);
		deleteButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int n = JOptionPane.showConfirmDialog(frame, "确认删除吗?", "确认删除框", JOptionPane.YES_NO_OPTION);  
		        if (n == JOptionPane.YES_OPTION) {  
		        	deleteUser();
		        }
			}
		});
		deleteButton.setEnabled(false);
		add(deleteButton);
		
		confirmButton = new ConfirmModButton();
		confirmButton.setBounds(895, 487-100, 100, 30);
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				confirmChange();
			}
		});
		confirmButton.setEnabled(false);
		add(confirmButton);
		
		Button exitButton = new ExitButton();
		exitButton.setBounds(895, 537, 100,30);
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
		
		juriBox = new JComboBox<String>();
		juriBox.setModel(new DefaultComboBoxModel<String>(new String[] {"总经理", "高级财务人员", "普通财务人员","快递员","营业厅业务员","中转中心业务员","仓库管理员"}));
		juriBox.setFont(new Font("宋体", Font.PLAIN, 12));
		juriBox.setBounds(855, 221, 200, 24);
		add(juriBox);
		
		nameField=new JTextField("姓名");
		nameField.setFont(new Font("宋体", Font.PLAIN, 12));
		nameField.setBounds(855,271,200,24);
		add(nameField);

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
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false){
					if(table.getModel().getRowCount()==users.size()+1){
						addButton.setEnabled(false);
						deleteButton.setEnabled(false);
					}else{
						addButton.setEnabled(true);
						deleteButton.setEnabled(true);
					}
					if(table.getSelectedRow() >= 0){
						displayUser(table.getSelectedRow());
						if(table.getModel().getRowCount()!=users.size()+1)
							deleteButton.setEnabled(true);
						confirmButton.setEnabled(true);
						if(table.getSelectedRow()<users.size())
						{
							UserVO user = users.get(table.getSelectedRow());
							if(user.getJuri().equals(Jurisdiction.ADMIN)){
								deleteButton.setEnabled(false);
							}
						}
					} else {
						deleteButton.setEnabled(false);
						confirmButton.setEnabled(false);
					}
				}
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
	private ArrayList<UserVO> getUsers(String keyword){
		ArrayList<UserVO> temp=new ArrayList<UserVO>();
		ResultMessage message;
		message = serv.findUser(keyword);
		if(message.getReInfo().equals(Result.SUCCESS)){
			temp=(ArrayList<UserVO>)message.getMessage();
		} else {
			reportWrong(message.getReInfo());
		}
		return temp;
	}
	
	private void displayUsers(){
		model.setRowCount(0);
		for(int i=0;i<users.size();i++){
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
		if(row<0||row>=table.getRowCount()){
			return;
		}
		String []data=new String[5];
		for(int i=0;i<5;i++){
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
		if(row<0||row>=table.getRowCount()){
			return;
		}
		Jurisdiction jur=null;
		String temp=(String)juriBox.getModel().getSelectedItem();
		if(temp.isEmpty()){
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
			UserVO user = users.get(table.getSelectedRow());
			UserVO now=new UserVO(idField.getText(),passwordField.getText(),jur,nameField.getText(),mobileField.getText(),user.getOrg(),user.getOrgId());
			Result result=serv.reviseUser(now,row,this.name);
			if(result.equals(Result.SUCCESS)){
			    users.set(row, now);
			    displayUsers();
			    DoHint.hint(result, frame);
			} else {
				reportWrong(result);
			}
		} else {
			UserVO now=new UserVO(idField.getText(),passwordField.getText(),jur,nameField.getText(),mobileField.getText(),null,null);
			Result result=serv.newUser(now,this.name);
			if(result.equals(Result.SUCCESS)){
				users.add(now);
				displayUsers();
				addButton.setEnabled(true);
				DoHint.hint(Result.SUCCESS,frame);
			} else {
				reportWrong(result);
			}
		}
	}
	
	private void deleteUser(){
		int row=table.getSelectedRow();
		if(row<0||row>=users.size()){
			return;
		}
		Result result=serv.deleteUser(users.get(row).getId(),name,row);
		if(result.equals(Result.SUCCESS)){
			users.remove(row);
			table.getSelectionModel().setSelectionInterval(row-1, row-1);
			displayUsers();
			DoHint.hint(Result.SUCCESS,frame);
		}
		else reportWrong(result);
	}
	private void reportWrong(Result result){
		DoHint.hint(result, frame);
	}
}
