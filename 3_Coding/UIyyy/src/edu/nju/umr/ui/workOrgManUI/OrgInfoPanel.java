package edu.nju.umr.ui.workOrgManUI;

import javax.swing.JPanel;

import edu.nju.umr.ui.Constants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class OrgInfoPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public OrgInfoPanel() {
		this.setSize(Constants.FRAME_WIDTH,Constants.FRAME_HEIGHT);
		setLayout(null);
		
		JLabel label = new JLabel("机构信息");
		label.setBounds(519, 10, 54, 15);
		add(label);
		
		JLabel label_1 = new JLabel("机构名称");
		label_1.setBounds(150, 59, 54, 15);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(256, 56, 66, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("机构种类");
		label_2.setBounds(150, 112, 54, 15);
		add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(256, 109, 66, 21);
		add(comboBox);
		
		JLabel label_3 = new JLabel("机构地址");
		label_3.setBounds(150, 173, 54, 15);
		add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(256, 170, 262, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("确认");
		button.setBounds(857, 272, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setBounds(702, 272, 93, 23);
		add(button_1);
	}

}
