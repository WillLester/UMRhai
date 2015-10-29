package edu.nju.umr.ui.accountUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.umr.ui.Constants;

public class CountInfoPanel extends JPanel{
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
		countLabel.setBounds(3*Constants.WIDTH_DIV_9, Constants.HEIGHT_DIV_10/10, 2*Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(countLabel);
		
		JLabel orgLabel = new JLabel("机构信息");
		orgLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		orgLabel.setBounds(Constants.WIDTH_DIV_15*9/5, Constants.HEIGHT_DIV_10*13/10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S/2);
		add(orgLabel);
		
		JComboBox orgCombo = new JComboBox();
		orgCombo.setBounds(Constants.WIDTH_DIV_15*5/6, Constants.HEIGHT_DIV_10*17/10, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(orgCombo);
		
		JLabel stockLabel = new JLabel("库存信息");
		stockLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		stockLabel.setBounds(Constants.WIDTH_DIV_15*6*19/20, Constants.HEIGHT_DIV_10*13/10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S/2);
		add(stockLabel);
		
		JComboBox stockCombo = new JComboBox();
		stockCombo.setBounds(Constants.WIDTH_DIV_15*5*19/20, Constants.HEIGHT_DIV_10*17/10, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(stockCombo);
		
		JLabel accountLabel = new JLabel("账户信息");
		accountLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		accountLabel.setBounds(Constants.WIDTH_DIV_15*10*24/25, Constants.HEIGHT_DIV_10*13/10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S/2);
		add(accountLabel);
		
		JComboBox accountCombo = new JComboBox();
		accountCombo.setBounds(645, Constants.HEIGHT_DIV_10*17/10, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(accountCombo);
		
		JLabel workerLabel = new JLabel("人员信息");
		workerLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		workerLabel.setBounds(Constants.WIDTH_DIV_15*9/5, Constants.HEIGHT_DIV_10*2*11/10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S/2);
		add(workerLabel);
		
		JComboBox workerCombo = new JComboBox();
		workerCombo.setBounds(Constants.WIDTH_DIV_15*5/6, 158, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(workerCombo);
		
		JLabel nameLabel = new JLabel("姓名");
		nameLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		nameLabel.setBounds(Constants.WIDTH_DIV_15*4/5, 189, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(nameLabel);
		
		nameField = new JTextField();
		nameField.setEditable(false);
		nameField.setBounds(109, 192, 154, 21);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel mobileLabel = new JLabel("手机号");
		mobileLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mobileLabel.setBounds(Constants.WIDTH_DIV_15*4/5, 226, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(mobileLabel);
		
		mobileField = new JTextField();
		mobileField.setEditable(false);
		mobileField.setBounds(109, 229, 154, 21);
		add(mobileField);
		mobileField.setColumns(10);
		
		JLabel dutyLabel = new JLabel("职务");
		dutyLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		dutyLabel.setBounds(Constants.WIDTH_DIV_15*4/5, 263, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(dutyLabel);
		
		dutyField = new JTextField();
		dutyField.setEditable(false);
		dutyField.setBounds(109, 266, 154, 21);
		add(dutyField);
		dutyField.setColumns(10);
		
		JComboBox vanCombo = new JComboBox();
		vanCombo.setBounds(Constants.WIDTH_DIV_15*5/6, 333, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(vanCombo);
		
		JLabel vanLabel = new JLabel("车辆信息");
		vanLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		vanLabel.setBounds(Constants.WIDTH_DIV_15*9/5, 308, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S/2);
		add(vanLabel);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		idLabel.setBounds(54, 367, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(idLabel);
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(109, 364, 154, 21);
		add(idField);
		idField.setColumns(10);
		
		JLabel plateLabel = new JLabel("车牌号");
		plateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		plateLabel.setBounds(54, 392, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(plateLabel);
		
		plateField = new JTextField();
		plateField.setEditable(false);
		plateField.setBounds(109, 395, 154, 21);
		add(plateField);
		plateField.setColumns(10);
		
		JLabel dateLabel = new JLabel("服役时间");
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		dateLabel.setBounds(54, 426, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(dateLabel);
		
		dateField = new JTextField();
		dateField.setEditable(false);
		dateField.setBounds(119, 426, 144, 21);
		add(dateField);
		dateField.setColumns(10);
		
		JLabel goodLabel = new JLabel("货物信息");
		goodLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		goodLabel.setBounds(Constants.WIDTH_DIV_15*6*19/20, Constants.HEIGHT_DIV_10*2*11/10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S/2);
		add(goodLabel);
		
		JComboBox goodCombo = new JComboBox();
		goodCombo.setBounds(Constants.WIDTH_DIV_15*5*19/20, 158, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(goodCombo);
		
		JLabel expressLabel = new JLabel("快递单号");
		expressLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		expressLabel.setBounds(322, 192, 60, 21);
		add(expressLabel);
		
		expressField = new JTextField();
		expressField.setEditable(false);
		expressField.setBounds(392, 192, 154, 21);
		add(expressField);
		expressField.setColumns(10);
		
		JLabel inDateLabel = new JLabel("入库时间");
		inDateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		inDateLabel.setBounds(322, 229, 60, 21);
		add(inDateLabel);
		
		inDateField = new JTextField();
		inDateField.setEditable(false);
		inDateField.setBounds(392, 229, 154, 21);
		add(inDateField);
		inDateField.setColumns(10);
		
		JLabel destinationLabel = new JLabel("到达地");
		destinationLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		destinationLabel.setBounds(322, 266, 54, 21);
		add(destinationLabel);
		
		destinationField = new JTextField();
		destinationField.setEditable(false);
		destinationField.setBounds(392, 266, 154, 21);
		add(destinationField);
		destinationField.setColumns(10);
		
		JLabel partLabel = new JLabel("区");
		partLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		partLabel.setBounds(322, 304, 54, 21);
		add(partLabel);
		
		partField = new JTextField();
		partField.setEditable(false);
		partField.setBounds(392, 305, 154, 19);
		add(partField);
		partField.setColumns(10);
		
		JLabel shelfLabel = new JLabel("架");
		shelfLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		shelfLabel.setBounds(322, 341, 54, 21);
		add(shelfLabel);
		
		shelfField = new JTextField();
		shelfField.setEditable(false);
		shelfField.setBounds(392, 341, 154, 21);
		add(shelfField);
		shelfField.setColumns(10);
		
		JLabel rowLabel = new JLabel("排");
		rowLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		rowLabel.setBounds(322, 378, 54, 21);
		add(rowLabel);
		
		rowField = new JTextField();
		rowField.setEditable(false);
		rowField.setBounds(392, 378, 154, 21);
		add(rowField);
		rowField.setColumns(10);
		
		JLabel placeLabel = new JLabel("位");
		placeLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		placeLabel.setBounds(322, 415, 54, 21);
		add(placeLabel);
		
		placeField = new JTextField();
		placeField.setEditable(false);
		placeField.setBounds(392, 415, 154, 21);
		add(placeField);
		placeField.setColumns(10);
		
		JLabel accountNameLabel = new JLabel("账户名称");
		accountNameLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		accountNameLabel.setBounds(615, 136, 65, 21);
		add(accountNameLabel);
		
		accountNameField = new JTextField();
		accountNameField.setEditable(false);
		accountNameField.setBounds(689, 136, 156, 21);
		add(accountNameField);
		accountNameField.setColumns(10);
		
		JLabel balanceLabel = new JLabel("账户余额");
		balanceLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		balanceLabel.setBounds(615, 167, 65, 21);
		add(balanceLabel);
		
		balanceField = new JTextField();
		balanceField.setEditable(false);
		balanceField.setBounds(689, 167, 156, 24);
		add(balanceField);
		balanceField.setColumns(10);
		
		JButton button = new JButton("确认查看");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(693, 414, 93, 23);
		add(button);

	}
}
