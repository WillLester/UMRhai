package edu.nju.umr.ui.transitInfoUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class TransitInfoInqPanel extends JPanel {
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TransitInfoInqPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("物流历史轨迹查询");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(364, 10, 242, 67);
		add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("订单编号");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(305, 107, 120, 24);
		add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(408, 110, 193, 24);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(638, 108, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("关闭");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(455, 431, 93, 23);
		add(button_1);
		
		table = new JTable();
		table.setBounds(305, 191, 431, 190);
		add(table);

	}
}
