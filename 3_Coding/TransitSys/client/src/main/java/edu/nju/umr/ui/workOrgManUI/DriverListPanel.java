package edu.nju.umr.ui.workOrgManUI;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import edu.nju.umr.logic.workOrgManLogic.DriverManLogic;
import edu.nju.umr.logicService.workOrgManLogicSer.DriverManLSer;
import edu.nju.umr.po.enums.Gender;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.InfoFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.userPanel.UserPanel;
import edu.nju.umr.vo.DriverVO;
import edu.nju.umr.vo.UserVO;

import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class DriverListPanel extends JPanel {
	private JTextField textFieldSearch;
	private JFrame frame;
	private DriverListPanel panel;
	private Table table;
	private DefaultTableModel model;
	private DriverManLSer serv;
	private ArrayList<DriverVO> driverList;
	private UserVO user;
	
	/**
	 * Create the panel.
	 */
	public DriverListPanel(JFrame fr) {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		frame=fr;
		panel=this;
		user=UserPanel.getUser();
		serv=new DriverManLogic();
		
		JLabel nameLabel = new JLabel("司机信息列表");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN ,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH+20, Constants.LABEL_HEIGHT_S);
		add(nameLabel);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setText("请输入关键字或司机编号");
		textFieldSearch.setBounds(Constants.TABLE_X, Constants.TABLE_Y,300, 21);
		//add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton search = new JButton("搜索");
		search.setBounds(textFieldSearch.getX()+300+20, textFieldSearch.getY(), 90, 21);
		//add(search);
		
		JButton add = new JButton("新增");
		add.setBounds(this.getWidth()/2-250, Constants.TABLE_HEIGHT*7, 90, 21);
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				InfoFrame fr=new InfoFrame("新增司机信息输入");
				fr.setContentPane(new DriverInfoPanel(fr,panel,new DriverVO("","",Calendar.getInstance(),"","",Gender.MAN,Calendar.getInstance(),Calendar.getInstance())));
			}
		});
		add(add);
		
		JButton delete = new JButton("删除");
		delete.setBounds(add.getX()+add.getWidth()+50, add.getY(), 90, 21);
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				serv.deleteDriver(driverList.get(table.getSelectedRow()).getId());
				driverList.remove(table.getSelectedRow());
				displayDrivers();
			}
		});
		add(delete);
		
		JButton modify = new JButton("修改");
		modify.setBounds(delete.getX()+delete.getWidth()+50, add.getY(), 90, 21);
		modify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				InfoFrame fr=new InfoFrame("修改司机信息");
				fr.setContentPane(new DriverInfoPanel(fr,panel,driverList.get(table.getSelectedRow())));
			}
		});
		add(modify);
		
		JButton forDetail = new JButton("查看详细");
		forDetail.setBounds(modify.getX()+modify.getWidth()+50, add.getY(), 90, 21);
//		add(forDetail);
		
		JButton out = new JButton("退出");
		out.setBounds(forDetail.getX()+forDetail.getWidth()+50,add.getY(),90,21);
		out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(out);
		
		tableInit();
		driverList=(ArrayList<DriverVO>)serv.searchDriver(/*user.getOrg()*/"").getMessage();
		displayDrivers();
		
	}
	void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setBounds(Constants.TABLE_X, textFieldSearch.getY()+40, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(Constants.TABLE_X, textFieldSearch.getY()+40, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"编号","姓名","出生日期","身份证号","手机号","性别","行驶证期限"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	void displayDrivers(){
		model.setRowCount(0);
		for(int i=0;i<driverList.size();i++)
		{
			DriverVO driver=driverList.get(i);
			String [] data=driver.getData();
			model.addRow(data);
		}
	}
	void addDriver(DriverVO driver){
		
	}
	public void Modify(DriverVO driver){
		int index;
		for(index=0;index<driverList.size();index++)
		{
			DriverVO dr=driverList.get(index);
			if(dr.getId().equals(driver.getId()))
			{
				serv.reviseDriver(driver);
				driverList.remove(index);
				driverList.add(driver);
				break;
			}
		}
		if(index==driverList.size())
		{
			driverList.add(driver);
			serv.addDriver(driver);
		}
		displayDrivers();
	}
//	public static void main(String[] args){
//		JFrame f=new JFrame();
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setSize(1300,800);
//		f.setContentPane(new DriverListPanel(f));
//		f.setVisible(true);
//	}
}
