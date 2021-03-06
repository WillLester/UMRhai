package edu.nju.umr.ui.workOrgManUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.workOrgManLogic.OrgManLogic;
import edu.nju.umr.logicService.workOrgManLogicSer.OrgManLSer;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.UMRScrollPane;
import edu.nju.umr.ui.component.button.AddButton;
import edu.nju.umr.ui.component.button.AllButton;
import edu.nju.umr.ui.component.button.CanModButton;
import edu.nju.umr.ui.component.button.ConfirmModButton;
import edu.nju.umr.ui.component.button.DelButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.component.button.SearchButton;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;

public class OrgListPanel extends PPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9120059892438869471L;
	private TextField textFieldSearch;
	private TextField textFieldName;
	private TextField textFieldAddr;
	private TextField idField;
	private JFrame frame;
	private Table table;
	private DefaultTableModel model;
	private ArrayList<CityVO> cityList;
	private ArrayList<OrgVO> orgList;
	private UMRComboBox<String> orgType;
	private OrgManLSer serv;
	private UMRComboBox<String> cityComboBox;
	private Button modify;
	private Button workMan;
	private Button confirmMod;
	private Button delete;
	private String name;
	private Button add;
	private static final int y=20;
	/**
	 * Create the panel.
	 */
	public OrgListPanel(JFrame fr,String name) {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		frame=fr;
		orgList=new ArrayList<OrgVO>();
		try {
			serv=new OrgManLogic();
		} catch (RemoteException e1) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
		this.name = name;
		
		JLabel nameLabel = new TitleLabel("机构信息");
		add(nameLabel);
		
		textFieldSearch = new TextField();
		textFieldSearch.setBounds(Constants.TABLE_X,y+Constants.TABLE_Y+20, 600, 21);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		Button search = new SearchButton();
		search.setBounds(textFieldSearch.getX()+textFieldSearch.getWidth()+Constants.INTERVAL,textFieldSearch.getY()-5, 100, 30);
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				orgList=getOrgs(textFieldSearch.getText());
				displayOrgs();
			}
		});
		add(search);
		
		Button all = new AllButton();
		all.setBounds(textFieldSearch.getX()+textFieldSearch.getWidth()+100+Constants.INTERVAL*2,textFieldSearch.getY()-5, 100, 30);
		all.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				orgList=getOrgs("");
				displayOrgs();
			}
		});
		add(all);
		
		
		UMRLabel orgName = new UMRLabel("机构名称");
		orgName.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20+Constants.TABLE_HEIGHT*4+20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(orgName);
		
		textFieldName = new TextField();
		textFieldName.setBounds(orgName.getX()+orgName.getWidth(), orgName.getY()+3,Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldName);
		textFieldName.setColumns(10);
		
		UMRLabel type = new UMRLabel("机构种类");
		type.setBounds(this.getWidth()/2-130, orgName.getY(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(type);
		
		orgType = new UMRComboBox<String>();
		orgType.setBounds(type.getWidth()+type.getX()-70, type.getY()+5, 150, 21);
		orgType.setModel(new DefaultComboBoxModel<String>(new String[]{"营业厅","中转中心","总部"}));
		orgType.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				getId();
			}});
		add(orgType);
		
		UMRLabel address = new UMRLabel("机构地址");
		address.setBounds(orgName.getX(), orgName.getY()+orgName.getHeight()+20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(address);
		
		textFieldAddr = new TextField();
		textFieldAddr.setBounds(textFieldName.getX()+200, address.getY()+3, 400, 21);
		add(textFieldAddr);
		textFieldAddr.setColumns(10);
		
		add = new AddButton();
		add.setBounds(Constants.TABLE_X+100, textFieldAddr.getY()+textFieldAddr.getHeight()+30, 100, 30);
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addOrg();
//				textFieldAddr.setText("");
//				textFieldName.setText("");
//				idField.setText("");
//				orgType.setSelectedIndex(0);
//				cityComboBox.setSelectedIndex(0);
			}
		});
		add(add);
		
		delete = new DelButton();
		delete.setBounds(add.getX()+add.getWidth()+50, add.getY(), 100, 30);
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				if(table.getRowCount()>orgList.size()&&table.getSelectedRow()==table.getRowCount()-1)
				{
					displayOrgs();
					add.setEnabled(true);
					return;
				}
				int n = JOptionPane.showConfirmDialog(frame, "确认删除吗?", "确认删除框", JOptionPane.YES_NO_OPTION);  
		        if (n == JOptionPane.YES_OPTION)
		        {
		        	deleteOrg(table.getSelectedRow());
		        }
			}
		});
		add(delete);
		
		modify = new ConfirmModButton();
		modify.setBounds(delete.getX()+delete.getWidth()+50, add.getY(), 100, 30);
		modify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				Modify();
			}
		});
		add(modify);
		
		confirmMod = new CanModButton();
		confirmMod.setBounds(modify.getX()+modify.getWidth()+50, add.getY(), 100, 30);
//		add(confirmMod);
		
		Button out = new ExitButton();
		out.setBounds(confirmMod.getX()+confirmMod.getWidth()+50+confirmMod.getWidth()+50, add.getY(), 150, 45);
		out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(out);
		
		workMan = new Button();
		workMan.setNewImages("buttonWorkMan", "buttonWorkManSt", "buttonWorkManP");
		workMan.setBounds(confirmMod.getX()+confirmMod.getWidth()+50, add.getY(), 100, 30);
		workMan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				FunctionFrame ffr=new FunctionFrame("人员管理");
				OrgVO org = orgList.get(table.getSelectedRow());
				ffr.setContentPane(new WorkListPanel(ffr,org.getName(),name));
			}
		});
		add(workMan);
		
		UMRLabel idLabel=new UMRLabel("机构编号");
		idLabel.setBounds(orgType.getX()+200, orgType.getY(), 100, 24);
		add(idLabel);
		
		idField=new TextField();
		idField.setBounds(idLabel.getX()+80, idLabel.getY(),200, 24);
		idField.setEditable(false);
		add(idField);
		
		UMRLabel cityLabel=new UMRLabel("城市");
		cityLabel.setBounds(address.getX()+120, address.getY(),  Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(cityLabel);
		
		cityList=getCities();
		String []cityListString=new String[cityList.size()];
		for(int i=0;i<cityList.size();i++)
		{
			cityListString[i]=cityList.get(i).getName();
		}
		cityComboBox =new UMRComboBox<String>(new DefaultComboBoxModel<String>(cityListString));
		cityComboBox.setBounds(cityLabel.getX()+50, cityLabel.getY(),  Constants.LABEL_WIDTH, 24);
		cityComboBox.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				getId();
			}});
		add(cityComboBox);
		
		tableInit();
		orgList=getOrgs("");
		displayOrgs();
		modify.setEnabled(false);
		workMan.setEnabled(false);
		confirmMod.setEnabled(false);
		delete.setEnabled(false);
		
	}
	private void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false)
					displayOrg(table.getSelectedRow());
				if(table.getRowCount()>orgList.size()){add.setEnabled(false);workMan.setEnabled(false);}
				if(table.getRowCount()==orgList.size()){add.setEnabled(true);workMan.setEnabled(true);}
				if(table.getSelectedRow()<0)
				{
					modify.setEnabled(false);
					workMan.setEnabled(false);
					confirmMod.setEnabled(false);
					delete.setEnabled(false);
				}
				else
				{
					modify.setEnabled(true);
					if(add.isEnabled()==false&&table.getSelectedRow()==table.getRowCount()-1)workMan.setEnabled(false);
					else workMan.setEnabled(true);
					confirmMod.setEnabled(true);
					delete.setEnabled(true);
				}
			}
		});
		table.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new UMRScrollPane(table);
		scroll.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"编号","名称","种类","地址"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	@SuppressWarnings("unchecked")
	private ArrayList<OrgVO> getOrgs(String keyword){
		ArrayList<OrgVO> temp=new ArrayList<OrgVO>();
		if(keyword.isEmpty())keyword=null;
		ResultMessage message=serv.searchOrg(keyword);
		if(message.getReInfo()!=Result.SUCCESS)
		{
			new HintFrame(message.getReInfo(),frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
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
			String kind=null;
			switch(temp.getKind()){
			case HALL:kind="营业厅";break;
			case CENTER:kind="中转中心";break;
			case HEADQUARTER:kind="总部";break;
			}
			String[] data={temp.getId(),temp.getName(),kind,temp.getCity()+temp.getLocation()};
			model.addRow(data);
		}
	}
	private void displayOrg(int row){
		if(row<0||row>=orgList.size()){
			textFieldName.setText("");
			orgType.setSelectedIndex(0);
			idField.setText("");
			cityComboBox.setSelectedIndex(0);
			textFieldAddr.setText("");
			return;
		}
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
		idField.setText(temp.getId());
		for(int i=0;i<cityList.size();i++){
			if(cityList.get(i).getName().equals(temp.getCity()))
			{
				cityComboBox.setSelectedIndex(i);
				break;
			}
		}
	}
	private void addOrg(){
		if(table.getRowCount()>orgList.size()){add.setEnabled(false);workMan.setEnabled(false);return;}
		orgType.setSelectedIndex(0);
		if(cityList.size()>0){
			cityComboBox.setSelectedIndex(0);
		}
		String[] data={"","","",""};
		model.addRow(data);
		table.getSelectionModel().setSelectionInterval(model.getRowCount()-1, model.getRowCount()-1);
		getId();
	}
	private void deleteOrg(int row){
		if(row<0||row>=orgList.size())return;
		OrgVO temp=orgList.get(row);
		Result result=serv.deleteOrg(temp.getId(),name);
		DoHint.hint(result, frame);
		if(result.equals(Result.SUCCESS)){
			orgList.remove(row);
			displayOrgs();
		}
	}
	private void Modify(){
		Organization kind=Organization.HALL;
		switch(orgType.getSelectedIndex()){
		case 0:kind=Organization.HALL;break;
		case 1:kind=Organization.CENTER;break;
		case 2:kind=Organization.HEADQUARTER;break;
		}
		
		String id=idField.getText();
		String name=textFieldName.getText();
		String location=textFieldAddr.getText();
		String city=(String)cityComboBox.getSelectedItem();
		String cityId=cityList.get(cityComboBox.getSelectedIndex()).getId();
		
		
		if(name.equals("")){
			new HintFrame("机构名称未输入!",frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		if(location.equals("")){
			new HintFrame("机构地址未输入!",frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		
		if(!name.endsWith(orgType.getSelectedItem().toString())){
			name+=orgType.getSelectedItem().toString();
		}
		
		OrgVO temp=new OrgVO(id,name,kind,location,city,cityId);
		if(table.getSelectedRow()==orgList.size())
		{
			Result result=serv.addOrg(temp,this.name);
			DoHint.hint(result, frame);
			if(result.equals(Result.SUCCESS))
			{
				orgList.add(temp);
				displayOrgs();
			}
		}
		else
		{
			Result result=serv.reviseOrg(temp,this.name);
			DoHint.hint(result, frame);
			if(result.equals(Result.SUCCESS)){
				orgList.set(table.getSelectedRow(), temp);
				displayOrgs();
			}
		}
	}
	@SuppressWarnings("unchecked")
	private ArrayList<CityVO> getCities(){
		ArrayList<CityVO> temp=new ArrayList<CityVO>();
		ResultMessage message=serv.getCities();
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
		}
		else 
		{
			temp=(ArrayList<CityVO>)message.getMessage();
		}
		return temp;
	}
	private void getId(){
		if(table.getSelectedRow()<orgList.size())return;
		String temp="";
		switch(orgType.getSelectedItem().toString()){
			case "营业厅":temp=Organization.HALL.toString();break;
			case "中转中心":temp=Organization.CENTER.toString();break;
			case "总部":temp=Organization.HEADQUARTER.toString();break;
		}
		idField.setText(serv.getId(cityList.get(cityComboBox.getSelectedIndex()), temp));
	}

}
