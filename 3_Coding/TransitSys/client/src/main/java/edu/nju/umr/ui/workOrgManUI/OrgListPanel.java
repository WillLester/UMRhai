package edu.nju.umr.ui.workOrgManUI;

import javax.swing.JPanel;

import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.logicService.workOrgManLogicSer.OrgManLSer;
import edu.nju.umr.logic.workOrgManLogic.OrgManLogic;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.Result;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class OrgListPanel extends JPanel {
	private JTextField textFieldSearch;
	private JTextField textFieldName;
	private JTextField textFieldAddr;
	private JFrame frame;
	private Table table;
	private DefaultTableModel model;
	private ArrayList<OrgVO> orgList;
	private JComboBox orgType;
	private OrgManLSer serv;
	/**
	 * Create the panel.
	 */
	public OrgListPanel(JFrame fr) {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		frame=fr;
		orgList=new ArrayList<OrgVO>();
		//serv=new OrgManLogic();
		
		JLabel nameLabel = new JLabel("机构信息列表");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN ,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH+20, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(Constants.TABLE_X,Constants.TABLE_Y, 670, 21);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton search = new JButton("搜索");
		search.setBounds(textFieldSearch.getX()+textFieldSearch.getWidth()+20,textFieldSearch.getY(), 90, 21);
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				orgList=getOrgs(textFieldSearch.getText());
				displayOrgs();
			}
		});
		add(search);
		
		JButton all = new JButton("显示全部");
		all.setBounds(textFieldSearch.getX()+textFieldSearch.getWidth()+120,textFieldSearch.getY(), 90, 21);
		all.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				orgList=getOrgs("");
				displayOrgs();
			}
		});
		add(all);
		
		
		JLabel orgName = new JLabel("机构名称");
		orgName.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20+Constants.TABLE_HEIGHT*4+20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(orgName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(orgName.getX()+orgName.getWidth(), orgName.getY()+3,Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel type = new JLabel("机构种类");
		type.setBounds(this.getWidth()/2+100, orgName.getY(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(type);
		
		orgType = new JComboBox();
		orgType.setBounds(type.getWidth()+type.getX(), type.getY()+5, 150, 21);
		orgType.setModel(new DefaultComboBoxModel(new String[]{"营业厅","中转中心","总部"}));
		add(orgType);
		
		JLabel address = new JLabel("机构地址");
		address.setBounds(orgName.getX(), orgName.getY()+orgName.getHeight()+20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(address);
		
		textFieldAddr = new JTextField();
		textFieldAddr.setBounds(textFieldName.getX(), address.getY()+3, 400, 21);
		add(textFieldAddr);
		textFieldAddr.setColumns(10);
		
		JButton add = new JButton("新增");
		add.setBounds(Constants.TABLE_X+100, textFieldAddr.getY()+textFieldAddr.getHeight()+30, 93, 23);
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				addOrg();
			}
		});
		add(add);
		
		JButton delete = new JButton("删除");
		delete.setBounds(add.getX()+add.getWidth()+50, add.getY(), 93, 23);
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				deleteOrg(table.getSelectedRow());
			}
		});
		add(delete);
		
		JButton modify = new JButton("确认修改");
		modify.setBounds(delete.getX()+delete.getWidth()+50, add.getY(), 93, 23);
		modify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				Modify();
			}
		});
		add(modify);
		
		JButton confirmMod = new JButton("取消修改");
		confirmMod.setBounds(modify.getX()+modify.getWidth()+50, add.getY(), 93, 23);
		add(confirmMod);
		
//		JButton forDetail = new JButton("查看详细");
//		forDetail.setBounds(confirmMod.getX()+confirmMod.getWidth()+50, add.getY(), 93, 23);
//		add(forDetail);
		
		JButton out = new JButton("退出");
		out.setBounds(confirmMod.getX()+confirmMod.getWidth()+50+confirmMod.getWidth()+50, add.getY(), 93, 23);
		out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(out);
		
		JButton workMan = new JButton("人员管理");
		workMan.setBounds(confirmMod.getX()+confirmMod.getWidth()+50, add.getY(), 93, 23);
		workMan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("人员管理");
				ffr.setContentPane(new WorkListPanel(ffr));
			}
		});
		add(workMan);
		
		tableInit();
		//orgList=getOrgs("");
		//displayOrgs();
		
	}
	private void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false)
					displayOrg(table.getSelectedRow());
			}
		});
		table.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"名称","种类","地址"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	private ArrayList<OrgVO> getOrgs(String keyword){
		ArrayList<OrgVO> temp=new ArrayList<OrgVO>();
		ResultMessage message=serv.searchOrg(keyword);
		if(message.getReInfo()!=Result.SUCCESS)
		{
			new HintFrame(message.getReInfo(),frame.getX()+frame.getWidth()/2,frame.getY()+frame.getHeight()/2);
			return temp;
		}
		else temp=(ArrayList<OrgVO>)message.getMessage();
		return temp;
	}
	private void displayOrgs(){
		model.setRowCount(0);
		for(int i=0;i<orgList.size();i++)
		{
			OrgVO temp=orgList.get(i);
			String[] data={temp.getName(),temp.getKind().toString(),temp.getLocation()};
			model.addRow(data);
		}
	}
	private void displayOrg(int row){
		OrgVO temp=orgList.get(table.getSelectedRow());
		textFieldName.setText(temp.getName());
		textFieldAddr.setText(temp.getLocation());
		int kind=0;
		switch(temp.getKind()){
		case HALL:kind=0;break;
		case CENTER:kind=1;break;
		case HEADQUARTER:kind=2;break;
		}
		orgType.setSelectedIndex(kind);
	}
	private void addOrg(){
		String[] data={};
		model.addRow(data);
		table.getSelectionModel().setSelectionInterval(model.getRowCount()-1, model.getRowCount()-1);
	}
	private void deleteOrg(int row){
		OrgVO temp=orgList.get(row);
		Result result=serv.deleteOrg(temp.getId());
		if(!result.equals(Result.SUCCESS)){
			new HintFrame(result,frame.getX()+frame.getWidth()/2,frame.getY()+frame.getHeight()/2);
		}
	}
	private void Modify(){
		Organization kind;
		switch(orgType.getSelectedIndex()){
		case 0:kind=Organization.HALL;break;
		case 1:kind=Organization.CENTER;break;
		case 2:kind=Organization.HEADQUARTER;break;
		}
		//OrgVO temp=new OrgVO(textFieldName.getText(),kind,textFieldAddr.getText());
		
	}
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setContentPane(new OrgListPanel(frame));
		frame.setSize(1200,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

}
