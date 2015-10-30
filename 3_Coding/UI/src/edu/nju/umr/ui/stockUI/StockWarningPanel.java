package edu.nju.umr.ui.stockUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class StockWarningPanel extends JPanel {
	private JTextField planeField;
	private JTextField trainField;
	private JTextField vanField;
	private JTextField maneuverField;

	/**
	 * Create the panel.
	 */
	public StockWarningPanel() {
		setLayout(null);
		
		JLabel warningLabel = new JLabel("库存报警设置");
		warningLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		warningLabel.setBounds(486, 25, 132, 24);
		add(warningLabel);
		
		JLabel planeLabel = new JLabel("航运区警戒线（%）");
		planeLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		planeLabel.setBounds(389, 85, 132, 24);
		add(planeLabel);
		
		JLabel trainLabel = new JLabel("铁运区警戒线（%）");
		trainLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		trainLabel.setBounds(389, 145, 132, 24);
		add(trainLabel);
		
		JLabel vanLabel = new JLabel("汽运区警戒线（%）");
		vanLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		vanLabel.setBounds(389, 205, 132, 24);
		add(vanLabel);
		
		JLabel maneuverLabel = new JLabel("机动区警戒线（%）");
		maneuverLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		maneuverLabel.setBounds(389, 265, 132, 24);
		add(maneuverLabel);
		
		planeField = new JTextField();
		planeField.setBounds(555, 85, 132, 22);
		add(planeField);
		planeField.setColumns(10);
		
		trainField = new JTextField();
		trainField.setBounds(555, 145, 132, 24);
		add(trainField);
		trainField.setColumns(10);
		
		vanField = new JTextField();
		vanField.setBounds(555, 205, 132, 24);
		add(vanField);
		vanField.setColumns(10);
		
		maneuverField = new JTextField();
		maneuverField.setBounds(555, 265, 132, 24);
		add(maneuverField);
		maneuverField.setColumns(10);
		
		JButton confirmButton = new JButton("确认修改");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 12));
		confirmButton.setBounds(428, 407, 93, 23);
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消修改");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 12));
		cancelButton.setBounds(555, 407, 93, 23);
		add(cancelButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(746, 407, 93, 23);
		add(exitButton);

	}

}
