package edu.nju.umr.ui.accountUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.umr.ui.Constants;
import javax.swing.JTabbedPane;

public class CountInfoPanel extends JPanel {
	private JTextField nameField;
	private JTextField mobileField;
	private JTextField dutyField;
	private JTextField idField;
	private JTextField plateField;
	private JTextField dateField;
	private JTextField expressField;
	private JTextField inDateField;
	private JTextField destinationField;
	private JTextField partField;
	private JTextField shelfField;
	private JTextField rowField;
	private JTextField placeField;
	private JTextField accountNameField;
	private JTextField balanceField;

	/**
	 * Create the panel.
	 */
	public CountInfoPanel() {
		setLayout(null);
		
		JLabel countLabel = new JLabel("期初信息查看");
		countLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		countLabel.setBounds(483, 6, 137, 98);
		add(countLabel);
		
		JLabel orgLabel = new JLabel("机构信息");
		orgLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		orgLabel.setBounds(234, 82, 67, 17);
		add(orgLabel);
		
		JComboBox orgCombo = new JComboBox();
		orgCombo.setBounds(150, 102, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(orgCombo);
		
		JLabel stockLabel = new JLabel("库存信息");
		stockLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		stockLabel.setBounds(518, 82, 67, 17);
		add(stockLabel);
		
		JComboBox stockCombo = new JComboBox();
		stockCombo.setBounds(437, 102, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(stockCombo);
		
		JLabel accountLabel = new JLabel("账户信息");
		accountLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		accountLabel.setBounds(808, 82, 67, 17);
		add(accountLabel);
		
		JComboBox accountCombo = new JComboBox();
		accountCombo.setBounds(723, 102, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(accountCombo);
		
		JLabel workerLabel = new JLabel("人员信息");
		workerLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		workerLabel.setBounds(234, 138, 67, 17);
		add(workerLabel);
		
		JComboBox workerCombo = new JComboBox();
		workerCombo.setBounds(150, 158, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(workerCombo);
		
		JLabel nameLabel = new JLabel("姓名");
		nameLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		nameLabel.setBounds(155, 186, 45, 34);
		add(nameLabel);
		
		nameField = new JTextField();
		nameField.setEditable(false);
		nameField.setBounds(210, 193, 169, 20);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel mobileLabel = new JLabel("手机号");
		mobileLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mobileLabel.setBounds(155, 220, 53, 34);
		add(mobileLabel);
		
		mobileField = new JTextField();
		mobileField.setEditable(false);
		mobileField.setBounds(210, 227, 169, 20);
		add(mobileField);
		mobileField.setColumns(10);
		
		JLabel dutyLabel = new JLabel("职务");
		dutyLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		dutyLabel.setBounds(155, 255, 45, 34);
		add(dutyLabel);
		
		dutyField = new JTextField();
		dutyField.setEditable(false);
		dutyField.setBounds(210, 262, 169, 20);
		add(dutyField);
		dutyField.setColumns(10);
		
		JComboBox vanCombo = new JComboBox();
		vanCombo.setBounds(150, 320, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(vanCombo);
		
		JLabel vanLabel = new JLabel("车辆信息");
		vanLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		vanLabel.setBounds(234, 299, 67, 17);
		add(vanLabel);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		idLabel.setBounds(155, 357, 45, 34);
		add(idLabel);
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(210, 364, 169, 20);
		add(idField);
		idField.setColumns(10);
		
		JLabel plateLabel = new JLabel("车牌号");
		plateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		plateLabel.setBounds(155, 392, 53, 34);
		add(plateLabel);
		
		plateField = new JTextField();
		plateField.setEditable(false);
		plateField.setBounds(210, 399, 169, 20);
		add(plateField);
		plateField.setColumns(10);
		
		JLabel dateLabel = new JLabel("服役时间");
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		dateLabel.setBounds(155, 428, 67, 34);
		add(dateLabel);
		
		dateField = new JTextField();
		dateField.setEditable(false);
		dateField.setBounds(220, 435, 159, 20);
		add(dateField);
		dateField.setColumns(10);
		
		JLabel goodLabel = new JLabel("货物信息");
		goodLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		goodLabel.setBounds(518, 138, 67, 17);
		add(goodLabel);
		
		JComboBox goodCombo = new JComboBox();
		goodCombo.setBounds(437, 158, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(goodCombo);
		
		JLabel expressLabel = new JLabel("快递单号");
		expressLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		expressLabel.setBounds(437, 186, 67, 34);
		add(expressLabel);
		
		expressField = new JTextField();
		expressField.setEditable(false);
		expressField.setBounds(513, 193, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(expressField);
		expressField.setColumns(10);
		
		JLabel inDateLabel = new JLabel("入库时间");
		inDateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		inDateLabel.setBounds(437, 220, 67, 34);
		add(inDateLabel);
		
		inDateField = new JTextField();
		inDateField.setEditable(false);
		inDateField.setBounds(513, 227, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(inDateField);
		inDateField.setColumns(10);
		
		JLabel destinationLabel = new JLabel("到达地");
		destinationLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		destinationLabel.setBounds(437, 255, 59, 34);
		add(destinationLabel);
		
		destinationField = new JTextField();
		destinationField.setEditable(false);
		destinationField.setBounds(513, 262, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(destinationField);
		destinationField.setColumns(10);
		
		JLabel partLabel = new JLabel("区");
		partLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		partLabel.setBounds(437, 289, 45, 34);
		add(partLabel);
		
		partField = new JTextField();
		partField.setEditable(false);
		partField.setBounds(513, 296, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(partField);
		partField.setColumns(10);
		
		JLabel shelfLabel = new JLabel("架");
		shelfLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		shelfLabel.setBounds(437, 321, 59, 34);
		add(shelfLabel);
		
		shelfField = new JTextField();
		shelfField.setEditable(false);
		shelfField.setBounds(513, 327, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(shelfField);
		shelfField.setColumns(10);
		
		JLabel rowLabel = new JLabel("排");
		rowLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		rowLabel.setBounds(437, 357, 59, 34);
		add(rowLabel);
		
		rowField = new JTextField();
		rowField.setEditable(false);
		rowField.setBounds(513, 364, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(rowField);
		rowField.setColumns(10);
		
		JLabel placeLabel = new JLabel("位");
		placeLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		placeLabel.setBounds(437, 392, 59, 34);
		add(placeLabel);
		
		placeField = new JTextField();
		placeField.setEditable(false);
		placeField.setBounds(513, 399, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(placeField);
		placeField.setColumns(10);
		
		JLabel accountNameLabel = new JLabel("账户名称");
		accountNameLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		accountNameLabel.setBounds(723, 135, 67, 34);
		add(accountNameLabel);
		
		accountNameField = new JTextField();
		accountNameField.setEditable(false);
		accountNameField.setBounds(799, 142, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(accountNameField);
		accountNameField.setColumns(10);
		
		JLabel balanceLabel = new JLabel("账户余额");
		balanceLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		balanceLabel.setBounds(723, 172, 67, 34);
		add(balanceLabel);
		
		balanceField = new JTextField();
		balanceField.setEditable(false);
		balanceField.setBounds(799, 179, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(balanceField);
		balanceField.setColumns(10);
		
		JButton button = new JButton("确认查看");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(854, 432, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(button);

	}
}
