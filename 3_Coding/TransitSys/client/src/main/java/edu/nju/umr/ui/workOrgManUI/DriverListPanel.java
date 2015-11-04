package edu.nju.umr.ui.workOrgManUI;

import javax.swing.JPanel;

import edu.nju.umr.ui.Constants;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

public class DriverListPanel extends JPanel {
	private JTable listTable;
	private JTextField textFieldSearch;

	/**
	 * Create the panel.
	 */
	public DriverListPanel() {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		
		JLabel nameLabel = new JLabel("司机信息列表");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN ,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH+20, Constants.LABEL_HEIGHT_S);
		add(nameLabel);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setText("请输入关键字或司机编号");
		textFieldSearch.setBounds(Constants.TABLE_X, Constants.TABLE_Y,300, 21);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton search = new JButton("搜索");
		search.setBounds(textFieldSearch.getX()+300+20, textFieldSearch.getY(), 90, 21);
		add(search);

		listTable = new JTable();
		listTable.setBounds(Constants.TABLE_X, textFieldSearch.getY()+40, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		add(listTable);
		
		JButton add = new JButton("新增");
		add.setBounds(this.getWidth()/2-250, Constants.TABLE_HEIGHT*7, 90, 21);
		add(add);
		
		JButton delete = new JButton("删除");
		delete.setBounds(add.getX()+add.getWidth()+50, add.getY(), 90, 21);
		add(delete);
		
		JButton modify = new JButton("修改");
		modify.setBounds(delete.getX()+delete.getWidth()+50, add.getY(), 90, 21);
		add(modify);
		
		JButton forDetail = new JButton("查看详细");
		forDetail.setBounds(modify.getX()+modify.getWidth()+50, add.getY(), 90, 21);
		add(forDetail);
		
		JButton out = new JButton("退出");
//		out.setBounds(forDetail.getX(), forDetail.getY()+forDetail.getHeight()+30, 90, 21);
		out.setBounds(forDetail.getX()+forDetail.getWidth()+50,add.getY(),90,21);
		add(out);
		
		
	}
}
