package edu.nju.umr.ui.workOrgManUI;

import javax.swing.JPanel;

import edu.nju.umr.ui.Constants;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class OrgListPanel extends JPanel {
	private JTable listTable;
	private JTextField textFieldSearch;
	private JTextField textFieldName;
	private JTextField textFieldAddr;

	/**
	 * Create the panel.
	 */
	public OrgListPanel() {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		
		JLabel nameLabel = new JLabel("机构信息列表");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN ,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH+20, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(Constants.TABLE_X,Constants.TABLE_Y, 770, 21);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton search = new JButton("搜索");
		search.setBounds(textFieldSearch.getX()+textFieldSearch.getWidth()+20,textFieldSearch.getY(), 90, 21);
		add(search);
		
		listTable = new JTable();
		listTable.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		add(listTable);
		
		JLabel orgName = new JLabel("机构名称");
		orgName.setBounds(Constants.TABLE_X, listTable.getY()+listTable.getHeight()+20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(orgName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(orgName.getX()+orgName.getWidth(), orgName.getY()+3,Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel type = new JLabel("机构种类");
		type.setBounds(this.getWidth()/2+100, orgName.getY(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(type);
		
		JComboBox orgType = new JComboBox();
		orgType.setBounds(type.getWidth()+type.getX(), type.getY()+5, 150, 21);
		add(orgType);
		
		JLabel address = new JLabel("机构地址");
		address.setBounds(orgName.getX(), orgName.getY()+orgName.getHeight()+20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(address);
		
		textFieldAddr = new JTextField();
		textFieldAddr.setBounds(textFieldName.getX(), address.getY()+3, 400, 21);
		add(textFieldAddr);
		textFieldAddr.setColumns(10);
		
		JButton add = new JButton("新增");
		add.setBounds(listTable.getX()+100, textFieldAddr.getY()+textFieldAddr.getHeight()+30, 93, 23);
		add(add);
		
		JButton delete = new JButton("删除");
		delete.setBounds(add.getX()+add.getWidth()+50, add.getY(), 93, 23);
		add(delete);
		
		JButton modify = new JButton("确认修改");
		modify.setBounds(delete.getX()+delete.getWidth()+50, add.getY(), 93, 23);
		add(modify);
		
		JButton confirmMod = new JButton("取消修改");
		confirmMod.setBounds(modify.getX()+modify.getWidth()+50, add.getY(), 93, 23);
		add(confirmMod);
		
//		JButton forDetail = new JButton("查看详细");
//		forDetail.setBounds(confirmMod.getX()+confirmMod.getWidth()+50, add.getY(), 93, 23);
//		add(forDetail);
		
		JButton out = new JButton("退出");
		out.setBounds(confirmMod.getX()+confirmMod.getWidth()+50+confirmMod.getWidth()+50, add.getY(), 93, 23);
		add(out);
		
		JButton workMan = new JButton("人员管理");
		workMan.setBounds(confirmMod.getX()+confirmMod.getWidth()+50, add.getY(), 93, 23);
		add(workMan);
	}

}
