package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.orderNewLogic.CenterLoadingOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.CenterLoadingOrderLSer;
import edu.nju.umr.vo.order.CenterLoadingVO;

public class CenterLoadingPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7266319701610335832L;
	private JTextField transitIdField;
	private JTextField supervisionField;
	private JTextField escortField;
	private JTextField vanIdField;
	private JTextField expressField;
	private JTable expressList;
	private JFrame frame;
	private CenterLoadingOrderLSer logicSer;
	/**
	 * Create the panel.
	 */
	public CenterLoadingPanel(JFrame fr) {
		setLayout(null);
		
		JLabel titleLabel = new JLabel("中转中心装车单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setBounds(392+75, 10, 243, 67);
		add(titleLabel);
		frame = fr;
		logicSer = new CenterLoadingOrderLogic();
		
		JLabel transitIdLabel = new JLabel("汽运编号");
		transitIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transitIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		transitIdLabel.setBounds(355+75, 87, 120, 24);
		add(transitIdLabel);
		
		transitIdField = new JTextField();
		transitIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		transitIdField.setBounds(485+75, 87, 165, 25);
		add(transitIdField);
		transitIdField.setColumns(10);
		
		JLabel dateLabel = new JLabel("装车日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dateLabel.setBounds(297+75, 121, 120, 24);
		add(dateLabel);
		
		JSpinner yearSpinner = new JSpinner();
		yearSpinner.setModel(new SpinnerNumberModel(new Integer(2015), new Integer(0), null, new Integer(1)));
		yearSpinner.setFont(new Font("宋体", Font.PLAIN, 20));
		yearSpinner.setBounds(411+75, 121, 85, 26);
		add(yearSpinner);
		
		JLabel yearLabel = new JLabel("年");
		yearLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		yearLabel.setBounds(506+75, 122, 25, 22);
		add(yearLabel);
		
		JSpinner monthSpinner = new JSpinner();
		monthSpinner.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		monthSpinner.setFont(new Font("宋体", Font.PLAIN, 20));
		monthSpinner.setBounds(541+75, 122, 48, 26);
		add(monthSpinner);
		
		JLabel monthLabel = new JLabel("月");
		monthLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		monthLabel.setBounds(599+75, 122, 25, 22);
		add(monthLabel);
		
		JSpinner daySpinner = new JSpinner();
		daySpinner.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		daySpinner.setFont(new Font("宋体", Font.PLAIN, 20));
		daySpinner.setBounds(634+75, 122, 48, 26);
		add(daySpinner);
		
		JLabel dayLabel = new JLabel("日");
		dayLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dayLabel.setBounds(692+75, 122, 25, 22);
		add(dayLabel);
		
		JLabel arriveLabel = new JLabel("到达地");
		arriveLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		arriveLabel.setBounds(242+75, 155, 85, 24);
		add(arriveLabel);
		
		JComboBox arriveCombo = new JComboBox();
		arriveCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		arriveCombo.setBounds(307+75, 155, 87, 25);
		add(arriveCombo);
		
		JLabel supervisionLabel = new JLabel("监装员");
		supervisionLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		supervisionLabel.setBounds(421+75, 157, 85, 24);
		add(supervisionLabel);
		
		supervisionField = new JTextField();
		supervisionField.setFont(new Font("宋体", Font.PLAIN, 20));
		supervisionField.setColumns(10);
		supervisionField.setBounds(485+75, 157, 85, 25);
		add(supervisionField);
		
		JLabel escortLabel = new JLabel("押运员");
		escortLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		escortLabel.setBounds(609+75, 157, 85, 24);
		add(escortLabel);
		
		escortField = new JTextField();
		escortField.setFont(new Font("宋体", Font.PLAIN, 20));
		escortField.setColumns(10);
		escortField.setBounds(674+75, 158, 85, 25);
		add(escortField);
		
		JLabel vanIdLabel = new JLabel("车辆代号");
		vanIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vanIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		vanIdLabel.setBounds(220+75, 204, 120, 24);
		add(vanIdLabel);
		
		vanIdField = new JTextField();
		vanIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		vanIdField.setColumns(10);
		vanIdField.setBounds(328+75, 203, 165, 25);
		add(vanIdField);
		
		JLabel costLabel = new JLabel("运费：");
		costLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		costLabel.setBounds(599+75, 204, 232, 24);
		add(costLabel);
		
		JLabel expressId = new JLabel("订单条形码号");
		expressId.setHorizontalAlignment(SwingConstants.CENTER);
		expressId.setFont(new Font("宋体", Font.PLAIN, 20));
		expressId.setBounds(220+75, 255, 130, 24);
		add(expressId);
		
		expressField = new JTextField();
		expressField.setFont(new Font("宋体", Font.PLAIN, 20));
		expressField.setColumns(10);
		expressField.setBounds(355+75, 254, 280, 25);
		add(expressField);
		
		JButton newExpButton = new JButton("新增");
		newExpButton.setFont(new Font("宋体", Font.PLAIN, 20));
		newExpButton.setBounds(656+75, 256, 93, 23);
		add(newExpButton);
		newExpButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		
		JLabel expressListLabel = new JLabel("已输入订单");
		expressListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressListLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		expressListLabel.setBounds(401+75, 289, 130, 24);
		add(expressListLabel);
		
		expressList = new JTable();
		expressList.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		expressList.setFont(new Font("宋体", Font.PLAIN, 20));
		expressList.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		expressList.setBounds(220+75, 313, 529, 176);
		//this.add(new JScrollPane(table));
		add(expressList);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(342+75, 499, 93, 23);
		add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				
			}
		});
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(542+75, 499, 93, 23);
		add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				frame.dispose();
			}
		});
		

	}
}
