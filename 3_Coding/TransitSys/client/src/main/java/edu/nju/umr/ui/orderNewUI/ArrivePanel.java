package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.ui.DatePanel;

public class ArrivePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7454707708911829194L;
	private JTextField idField;
	private JTextField centerField;
	private JFrame frame;
	private DatePanel datePanel;
	/**
	 * Create the panel.
	 */
	public ArrivePanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		JLabel titleLabel = new JLabel("中转中心到达单");
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(364+75+25, 10, 242, 67);
		add(titleLabel);
		
		JLabel idLabel = new JLabel("中转单编号");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		idLabel.setBounds(342+75, 216, 107, 24);
		add(idLabel);
		
		idField = new JTextField();
		idField.setFont(new Font("宋体", Font.PLAIN, 20));
		idField.setBounds(474+75+25, 216, 193, 24);
		add(idField);
		idField.setColumns(10);
		
		JLabel arriveDateLabel = new JLabel("到达日期");
		arriveDateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		arriveDateLabel.setBounds(342+75+25, 268, 107, 24);
		add(arriveDateLabel);
		
		JLabel centerLabel = new JLabel("中转中心编号");
		centerLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		centerLabel.setBounds(329+75, 107, 120, 24);
		add(centerLabel);
		
		centerField = new JTextField();
		centerField.setBounds(474+75+25, 110, 193, 24);
		add(centerField);
		centerField.setColumns(10);
		
		JLabel startLabel = new JLabel("出发地");
		startLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		startLabel.setBounds(342+75+25, 162, 107, 24);
		add(startLabel);
		
		JComboBox<String> cityCombo = new JComboBox<String>();
		cityCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		cityCombo.setBounds(474+75+25, 166, 193, 21);
		add(cityCombo);
		
//		JSpinner spinner = new JSpinner();
//		spinner.setModel(new SpinnerNumberModel(new Integer(2015), new Integer(0), null, new Integer(1)));
//		spinner.setFont(new Font("宋体", Font.PLAIN, 20));
//		spinner.setBounds(474+75+25, 268, 85, 26);
//		add(spinner);
//		
//		JLabel lblNewLabel_5 = new JLabel("年");
//		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));
//		lblNewLabel_5.setBounds(569+75+25, 269, 25, 22);
//		add(lblNewLabel_5);
//		
//		JSpinner spinner_1 = new JSpinner();
//		spinner_1.setFont(new Font("宋体", Font.PLAIN, 20));
//		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
//		spinner_1.setBounds(597+75+25, 268, 48, 26);
//		add(spinner_1);
//		
//		JLabel lblNewLabel_6 = new JLabel("月");
//		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 20));
//		lblNewLabel_6.setBounds(655+75+25, 268, 25, 22);
//		add(lblNewLabel_6);
//		
//		JSpinner spinner_2 = new JSpinner();
//		spinner_2.setModel(new SpinnerNumberModel(1, 1, 31, 1));
//		spinner_2.setFont(new Font("宋体", Font.PLAIN, 20));
//		spinner_2.setBounds(679+75+25, 268, 48, 26);
//		add(spinner_2);
//		
//		JLabel lblNewLabel_7 = new JLabel("日");
//		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 20));
//		lblNewLabel_7.setBounds(737+75+25, 269, 25, 22);
//		add(lblNewLabel_7);
		
		datePanel=new DatePanel();
		datePanel.setBounds(474+75+25, 268, 285, 26);
		add(datePanel);
		
		
		JLabel stateLabel = new JLabel("货物到达状态");
		stateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		stateLabel.setBounds(329+75+25, 327, 120, 45);
		add(stateLabel);
		
		JComboBox<String> stateCombo = new JComboBox<String>();
		stateCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"完整", "损坏", "丢失"}));
		stateCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		stateCombo.setBounds(474+75+25, 338, 193, 24);
		add(stateCombo);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(364+75+25, 434, 93, 23);
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(548+75+25, 436, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancelButton);

	}
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setContentPane(new ArrivePanel(frame));
		frame.setSize(1200,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
