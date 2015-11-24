package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.ui.Table;

public class HallLoadingPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 165564419345172819L;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_4;
	private Table table;
	private DefaultTableModel model;
	private JFrame frame;
	/**
	 * Create the panel.
	 */
	public HallLoadingPanel(JFrame fr) {
		frame=fr;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("营业厅装车单");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(392+75, 10, 243, 67);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("汽运编号");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(355+75, 87, 120, 24);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setBounds(485+75, 87, 165, 25);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("装车日期");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(297+75, 121, 120, 24);
		add(lblNewLabel_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(2015), new Integer(0), null, new Integer(1)));
		spinner.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner.setBounds(411+75, 121, 85, 26);
		add(spinner);
		
		JLabel label = new JLabel("年");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(506+75, 122, 25, 22);
		add(label);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		spinner_1.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner_1.setBounds(541+75, 122, 48, 26);
		add(spinner_1);
		
		JLabel label_1 = new JLabel("月");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(599+75, 122, 25, 22);
		add(label_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		spinner_2.setFont(new Font("宋体", Font.PLAIN, 20));
		spinner_2.setBounds(634+75, 122, 48, 26);
		add(spinner_2);
		
		JLabel label_2 = new JLabel("日");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(692+75, 122, 25, 22);
		add(label_2);
		
		JLabel lblNewLabel_4 = new JLabel("到达地");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(242+75, 155, 85, 24);
		add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("宋体", Font.PLAIN, 20));
		comboBox.setBounds(307+75, 155, 87, 25);
		add(comboBox);
		
		JLabel label_3 = new JLabel("监装员");
		label_3.setFont(new Font("宋体", Font.PLAIN, 20));
		label_3.setBounds(421+75, 157, 85, 24);
		add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(485+75, 157, 85, 25);
		add(textField_2);
		
		JLabel label_4 = new JLabel("押运员");
		label_4.setFont(new Font("宋体", Font.PLAIN, 20));
		label_4.setBounds(609+75, 157, 85, 24);
		add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(674+75, 158, 85, 25);
		add(textField_3);
		
		JLabel label_5 = new JLabel("车辆代号");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("宋体", Font.PLAIN, 20));
		label_5.setBounds(220+75, 204, 120, 24);
		add(label_5);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(328+75, 203, 165, 25);
		add(textField);
		
		JLabel label_6 = new JLabel("运费：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 20));
		label_6.setBounds(599+75, 204, 232, 24);
		add(label_6);
		
		JLabel label_7 = new JLabel("订单条形码号");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("宋体", Font.PLAIN, 20));
		label_7.setBounds(220+75, 255, 130, 24);
		add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_4.setColumns(10);
		textField_4.setBounds(355+75, 254, 280, 25);
		add(textField_4);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(656+75, 256, 93, 23);
		add(btnNewButton);
		
		JLabel label_8 = new JLabel("已输入订单");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("宋体", Font.PLAIN, 20));
		label_8.setBounds(401+75, 289, 130, 24);
		add(label_8);
		
//		table = new JTable();
//		table.setFont(new Font("宋体", Font.PLAIN, 20));
//		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
//		table.setBounds(220+75, 313, 529, 176);
//		add(table);
		
		JButton button = new JButton("确定");
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(342+75, 499, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(542+75, 499, 93, 23);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(button_1);
		tableInit();

	}
	void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setBounds(220+75, 313, 529, 176);
		table.setFont(new Font("宋体", Font.PLAIN, 20));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(220+75, 313, 529, 176);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"订单号"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
}
