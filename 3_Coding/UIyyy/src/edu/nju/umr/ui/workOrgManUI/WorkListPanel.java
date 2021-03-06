package edu.nju.umr.ui.workOrgManUI;

import javax.swing.JPanel;

import edu.nju.umr.ui.Constants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class WorkListPanel extends JPanel {
	private JTextField textFieldSearch;
	private JTable listTable;
	private JTextField textFieldName;
	private JTextField textFieldMobile;

	/**
	 * Create the panel.
	 */
	public WorkListPanel() {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		
		JLabel nameLabel = new JLabel("人员信息列表");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN ,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH+20, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setText("请输入关键字");
		textFieldSearch.setBounds(Constants.TABLE_X,Constants.TABLE_Y, 300, 21);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton search = new JButton("搜索");
		search.setBounds(textFieldSearch.getX()+textFieldSearch.getWidth()+20,textFieldSearch.getY(), 90, 21);
		add(search);
		
		listTable = new JTable();
		listTable.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		add(listTable);
		
		JLabel workName = new JLabel("姓名");
		workName.setBounds(Constants.TABLE_X, listTable.getY()+listTable.getHeight()+20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(workName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(workName.getX()+workName.getWidth(), workName.getY()+3,Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel type = new JLabel("所属机构");
		type.setBounds(this.getWidth()/2+100, workName.getY(), Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(type);
		
		JComboBox orgType = new JComboBox();
		orgType.setBounds(type.getWidth()+type.getX(), type.getY()+5, 150, 21);
		add(orgType);
		
		JLabel mobile = new JLabel("手机");
		mobile.setBounds(workName.getX(), workName.getY()+workName.getHeight()+20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(mobile);
		
		textFieldMobile = new JTextField();
		textFieldMobile.setBounds(textFieldName.getX(), mobile.getY()+3, 250, 23);
		add(textFieldMobile);
		textFieldMobile.setColumns(10);
		
		JLabel position = new JLabel("职位");
		position.setBounds(type.getX(), type.getY()+type.getHeight()+20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(position);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(orgType.getX(), position.getY()+3, 150, 21);
		add(comboBox);
		
		JButton add = new JButton("新增");
		add.setBounds(listTable.getX()+100, textFieldMobile.getY()+textFieldMobile.getHeight()+30, 93, 23);
		add(add);
		
		JButton delete = new JButton("删除");
		delete.setBounds(add.getX()+add.getWidth()+50, add.getY(), 93, 23);
		add(delete);
		
		JButton modify = new JButton("修改");
		modify.setBounds(delete.getX()+delete.getWidth()+50, add.getY(), 93, 23);
		add(modify);
		
		JButton confirmMod = new JButton("确认修改");
		confirmMod.setBounds(modify.getX()+modify.getWidth()+50, add.getY(), 93, 23);
		add(confirmMod);
		
//		JButton forDetail = new JButton("查看详细");
//		forDetail.setBounds(confirmMod.getX()+confirmMod.getWidth()+50, add.getY(), 93, 23);
//		add(forDetail);
		
		JButton out = new JButton("退出");
		out.setBounds(confirmMod.getX()+confirmMod.getWidth()+50, add.getY(), 93, 23);
		add(out);
		
		
		
		
		
	}

}
