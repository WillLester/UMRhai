package edu.nju.umr.ui.checkUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;

import edu.nju.umr.ui.Constants;

import java.awt.Font;

import javax.swing.JButton;
/*
 * yyy
 * 20151029
 * 成本收益表
 */
public class CostBenePanel extends JPanel {
	private JTable collectTable;

	/**
	 * Create the panel.
	 */
	public CostBenePanel() {
		setLayout(null);
		
		this.setSize(1104,621);
		
		JLabel nameLabel = new JLabel("成本收益表");
		nameLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
//		nameLabel.setBounds(this.getWidth()/2-this.getWidth()/14, this.getHeight()/20, this.getWidth()/7, this.getHeight()/15);
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		collectTable = new JTable();
		collectTable.setBounds(this.getWidth()/10, this.getHeight()/9, this.getWidth()/10*8, this.getHeight()/9*6);
		add(collectTable);
		
		JButton out = new JButton("退出");
		out.setBounds(this.getWidth()/10*9-Constants.BUTTON_WIDTH, this.getHeight()/10*8, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(out);

	}
}
