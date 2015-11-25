package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.logic.orderNewLogic.StockOutOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.StockOutOrderLSer;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.vo.UserVO;

public class StockOutPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6797076136600769054L;
	private JTextField expressField;
	private JTextField textField;
	private JComboBox<String> cityCombo;
	private JComboBox<String> transitCombo;
	private JFrame frame;
	private DatePanel datePanel;
	private StockOutOrderLSer logicSer;
	private UserVO user;
	/**
	 * Create the panel.
	 */
	public StockOutPanel(JFrame fr,UserVO user) {
		setLayout(null);
		frame=fr;
		logicSer = new StockOutOrderLogic();
		this.user = user;
		
		JLabel titleLabel = new JLabel("出库单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setBounds(392, 10, 243, 67);
		add(titleLabel);
		
		JLabel expressLabel = new JLabel("快递编号");
		expressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		expressLabel.setBounds(355, 87, 120, 24);
		add(expressLabel);
		
		expressField = new JTextField();
		expressField.setFont(new Font("宋体", Font.PLAIN, 20));
		expressField.setBounds(485, 87, 165, 25);
		add(expressField);
		expressField.setColumns(10);
		
		JLabel dateLabel = new JLabel("出库日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dateLabel.setBounds(297, 134, 120, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(452, 134, 285, 26);
		add(datePanel);
		
		JLabel cityLabel = new JLabel("目的地");
		cityLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		cityLabel.setBounds(355, 179, 85, 24);
		add(cityLabel);
		
		cityCombo = new JComboBox<String>();
		cityCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		cityCombo.setBounds(431, 179, 87, 25);
		add(cityCombo);
		
		JLabel transitLabel = new JLabel("装运形式");
		transitLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		transitLabel.setBounds(541, 179, 85, 24);
		add(transitLabel);
		
		transitCombo = new JComboBox<String>();
		transitCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		transitCombo.setBounds(634, 179, 87, 25);
		add(transitCombo);
		
		JLabel label_3 = new JLabel("中转单/汽运编号");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(315, 282, 160, 24);
		add(label_3);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(485, 281, 233, 25);
		add(textField);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(347, 434, 93, 23);
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(541, 434, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancelButton);
	}
}
