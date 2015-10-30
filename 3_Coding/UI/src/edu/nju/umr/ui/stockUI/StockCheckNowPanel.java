package edu.nju.umr.ui.stockUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;

public class StockCheckNowPanel extends JPanel {
	private JTable goodList;

	/**
	 * Create the panel.
	 */
	public StockCheckNowPanel() {
		setLayout(null);
		
		JLabel checkLabel = new JLabel("库存盘点");
		checkLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		checkLabel.setBounds(504, 31, 95, 24);
		add(checkLabel);
		
		goodList = new JTable();
		goodList.setBounds(186, 84, 731, 442);
		add(goodList);
		
		JButton checkButton = new JButton("盘点");
		checkButton.setFont(new Font("宋体", Font.PLAIN, 12));
		checkButton.setBounds(947, 150, 93, 23);
		add(checkButton);
		
		JButton confirmButton = new JButton("确认盘点");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 12));
		confirmButton.setBounds(947, 213, 93, 23);
		add(confirmButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(947, 276, 93, 23);
		add(exitButton);

	}

}
