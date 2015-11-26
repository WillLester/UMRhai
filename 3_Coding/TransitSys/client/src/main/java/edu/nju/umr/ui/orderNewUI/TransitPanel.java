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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.orderNewLogic.TransitOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.TransitOrderLSer;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.Table;
import edu.nju.umr.vo.UserVO;

public class TransitPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7708522688857811718L;
	private JTextField idField;
	private JTextField supervisionField;
	private JTextField planeIdField;
	private JTextField expressIdField;
	private Table expressList;
	private DefaultTableModel model;
	private JTextField containerField;
	private JFrame frame;
	private DatePanel datePanel;
	private TransitOrderLSer logicSer;
	private UserVO user;
	/**
	 * Create the panel.
	 */
	public TransitPanel(JFrame fr,UserVO user) {
		setLayout(null);
		frame = fr;
		logicSer = new TransitOrderLogic();
		this.user = user;
		
		JLabel titleLabel = new JLabel("生成中转单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setBounds(392, 10, 243, 67);
		add(titleLabel);
		
		JLabel idLabel = new JLabel("中转单编号");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		idLabel.setBounds(355, 87, 120, 24);
		add(idLabel);
		
		idField = new JTextField();
		idField.setFont(new Font("宋体", Font.PLAIN, 20));
		idField.setBounds(485, 87, 165, 25);
		add(idField);
		idField.setColumns(10);
		
		JLabel dateLabel = new JLabel("装车日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dateLabel.setBounds(297, 121, 120, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(452, 121, 285, 26);
		add(datePanel);
		
		JLabel startLabel = new JLabel("出发地");
		startLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		startLabel.setBounds(242, 155, 85, 24);
		add(startLabel);
		
		JComboBox startCombo = new JComboBox();
		startCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		startCombo.setBounds(307, 155, 87, 25);
		add(startCombo);
		
		JLabel supervisionLabel = new JLabel("监装员");
		supervisionLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		supervisionLabel.setBounds(609, 157, 85, 24);
		add(supervisionLabel);
		
		supervisionField = new JTextField();
		supervisionField.setFont(new Font("宋体", Font.PLAIN, 20));
		supervisionField.setColumns(10);
		supervisionField.setBounds(674, 158, 85, 25);
		add(supervisionField);
		
		JLabel planeIdLabel = new JLabel("航班号");
		planeIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		planeIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		planeIdLabel.setBounds(220, 204, 120, 24);
		add(planeIdLabel);
		
		planeIdField = new JTextField();
		planeIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		planeIdField.setColumns(10);
		planeIdField.setBounds(328, 203, 165, 25);
		add(planeIdField);
		
		JLabel costField = new JLabel("运费：");
		costField.setFont(new Font("宋体", Font.PLAIN, 20));
		costField.setBounds(696, 204, 232, 24);
		add(costField);
		
		JLabel expressIdLabel = new JLabel("订单条形码号");
		expressIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		expressIdLabel.setBounds(220, 255, 130, 24);
		add(expressIdLabel);
		
		expressIdField = new JTextField();
		expressIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		expressIdField.setColumns(10);
		expressIdField.setBounds(355, 254, 280, 25);
		add(expressIdField);
		
		JButton newButton = new JButton("新增");
		newButton.setFont(new Font("宋体", Font.PLAIN, 20));
		newButton.setBounds(656, 256, 93, 23);
		add(newButton);
		
		JLabel expressListLabel = new JLabel("已输入订单");
		expressListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressListLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		expressListLabel.setBounds(401, 289, 130, 24);
		add(expressListLabel);
		
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(342, 499, 93, 23);
		add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				
			}
		});
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(542, 499, 93, 23);
		add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				frame.dispose();
			}
		});
		
		JLabel arriveLabel = new JLabel("到达地");
		arriveLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		arriveLabel.setBounds(421, 155, 85, 24);
		add(arriveLabel);
		
		JComboBox arriveCombo = new JComboBox();
		arriveCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		arriveCombo.setBounds(485, 157, 87, 25);
		add(arriveCombo);
		
		JLabel containerLabel = new JLabel("货柜号");
		containerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		containerLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		containerLabel.setBounds(506, 204, 120, 24);
		add(containerLabel);
		
		containerField = new JTextField();
		containerField.setFont(new Font("宋体", Font.PLAIN, 20));
		containerField.setColumns(10);
		containerField.setBounds(609, 203, 69, 25);
		add(containerField);
		
		tableInit();
		

	}
	void tableInit(){
		expressList = new Table(new DefaultTableModel());
		model=(DefaultTableModel)expressList.getModel();
		expressList.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		expressList.setFont(new Font("宋体", Font.PLAIN, 20));
		expressList.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		expressList.setBounds(220, 313, 529, 176);
		expressList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		expressList.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(expressList);
		scroll.setBounds(220, 313, 529, 176);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"订单号"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
}
