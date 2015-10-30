package edu.nju.umr.ui.orderApproveUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

public class orderApprovePanel extends JPanel {
	private JTable orderList;

	/**
	 * Create the panel.
	 */
	public orderApprovePanel() {
		setLayout(null);
		
		JLabel approveLabel = new JLabel("审批单据");
		approveLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		approveLabel.setBounds(505, 40, 93, 24);
		add(approveLabel);
		
		orderList = new JTable();
		orderList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		orderList.setBounds(193, 71, 717, 421);
		add(orderList);
		
		JButton allButton = new JButton("全选");
		allButton.setFont(new Font("宋体", Font.PLAIN, 12));
		allButton.setBounds(927, 103, 93, 23);
		add(allButton);
		
		JButton passedButton = new JButton("通过审批");
		passedButton.setFont(new Font("宋体", Font.PLAIN, 12));
		passedButton.setBounds(927, 159, 93, 23);
		add(passedButton);
		
		JButton unpassedButton = new JButton("不通过审批");
		unpassedButton.setFont(new Font("宋体", Font.PLAIN, 12));
		unpassedButton.setBounds(927, 215, 93, 23);
		add(unpassedButton);
		
		JButton checkButton = new JButton("查看详细");
		checkButton.setFont(new Font("宋体", Font.PLAIN, 12));
		checkButton.setBounds(927, 271, 93, 23);
		add(checkButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(927, 327, 93, 23);
		add(exitButton);

	}
}
