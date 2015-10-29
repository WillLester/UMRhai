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
		orgLabel.setBounds(Constants.WIDTH_DIV_15*17/10, Constants.HEIGHT_DIV_10*12/10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S/2);
		add(orgLabel);
		
		JComboBox orgCombo = new JComboBox();
		orgCombo.setBounds(Constants.WIDTH_DIV_15*3/4, Constants.HEIGHT_DIV_10*12/10+20, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(orgCombo);
		
		JLabel stockLabel = new JLabel("库存信息");
		stockLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		stockLabel.setBounds(Constants.WIDTH_DIV_15*6*19/20, Constants.HEIGHT_DIV_10*12/10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S/2);
		add(stockLabel);
		
		JComboBox stockCombo = new JComboBox();
		stockCombo.setBounds(Constants.WIDTH_DIV_15*5*19/20, Constants.HEIGHT_DIV_10*12/10+20, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(stockCombo);
		
		JLabel accountLabel = new JLabel("账户信息");
		accountLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		accountLabel.setBounds(Constants.WIDTH_DIV_15*10*24/25, Constants.HEIGHT_DIV_10*12/10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S/2);
		add(accountLabel);
		
		JComboBox accountCombo = new JComboBox();
		accountCombo.setBounds(Constants.WIDTH_DIV_15*9*19/20, Constants.HEIGHT_DIV_10*12/10+20, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(accountCombo);
		
		JLabel workerLabel = new JLabel("人员信息");
		workerLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		workerLabel.setBounds(Constants.WIDTH_DIV_15*17/10, Constants.HEIGHT_DIV_10*2, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S/2);
		add(workerLabel);
		
		JComboBox workerCombo = new JComboBox();
		workerCombo.setBounds(Constants.WIDTH_DIV_15*3/4, Constants.HEIGHT_DIV_10*2+20, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(workerCombo);
		
		JLabel nameLabel = new JLabel("姓名");
		nameLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		nameLabel.setBounds(Constants.WIDTH_DIV_15*4/5, Constants.HEIGHT_DIV_10*2*27/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(nameLabel);
		
		nameField = new JTextField();
		nameField.setEditable(false);
		nameField.setBounds(Constants.WIDTH_DIV_15*4/5+60, Constants.HEIGHT_DIV_10*2*27/20+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel mobileLabel = new JLabel("手机号");
		mobileLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mobileLabel.setBounds(Constants.WIDTH_DIV_15*4/5, Constants.HEIGHT_DIV_10*2*32/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(mobileLabel);
		
		mobileField = new JTextField();
		mobileField.setEditable(false);
		mobileField.setBounds(Constants.WIDTH_DIV_15*4/5+60, Constants.HEIGHT_DIV_10*2*32/20+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(mobileField);
		mobileField.setColumns(10);
		
		JLabel dutyLabel = new JLabel("职务");
		dutyLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		dutyLabel.setBounds(Constants.WIDTH_DIV_15*4/5, Constants.HEIGHT_DIV_10*2*37/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(dutyLabel);
		
		dutyField = new JTextField();
		dutyField.setEditable(false);
		dutyField.setBounds(Constants.WIDTH_DIV_15*4/5+60, Constants.HEIGHT_DIV_10*2*37/20+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(dutyField);
		dutyField.setColumns(10);
		
		JComboBox vanCombo = new JComboBox();
		vanCombo.setBounds(Constants.WIDTH_DIV_15*3/4, Constants.HEIGHT_DIV_10*3*31/20, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(vanCombo);
		
		JLabel vanLabel = new JLabel("车辆信息");
		vanLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		vanLabel.setBounds(Constants.WIDTH_DIV_15*17/10, Constants.HEIGHT_DIV_10*3*29/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S/2);
		add(vanLabel);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		idLabel.setBounds(Constants.WIDTH_DIV_15*4/5, Constants.HEIGHT_DIV_20*7*15/10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(idLabel);
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(Constants.WIDTH_DIV_15*4/5+60, Constants.HEIGHT_DIV_20*7*15/10+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(idField);
		idField.setColumns(10);
		
		JLabel plateLabel = new JLabel("车牌号");
		plateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		plateLabel.setBounds(Constants.WIDTH_DIV_15*4/5, Constants.HEIGHT_DIV_20*7*33/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(plateLabel);
		
		plateField = new JTextField();
		plateField.setEditable(false);
		plateField.setBounds(Constants.WIDTH_DIV_15*4/5+60, Constants.HEIGHT_DIV_20*7*33/20+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(plateField);
		plateField.setColumns(10);
		
		JLabel dateLabel = new JLabel("服役时间");
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		dateLabel.setBounds(Constants.WIDTH_DIV_15*4/5, Constants.HEIGHT_DIV_20*7*36/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(dateLabel);
		
		dateField = new JTextField();
		dateField.setEditable(false);
		dateField.setBounds(Constants.WIDTH_DIV_15*4/5+Constants.TEXTFIELD_WIDTH_S/10+60, Constants.HEIGHT_DIV_20*7*36/20+7, Constants.TEXTFIELD_WIDTH_S*9/10, Constants.TEXTFIELD_HEIGHT*3/4);
		add(dateField);
		dateField.setColumns(10);
		
		JLabel goodLabel = new JLabel("货物信息");
		goodLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		goodLabel.setBounds(Constants.WIDTH_DIV_15*6*19/20, Constants.HEIGHT_DIV_10*2, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S/2);
		add(goodLabel);
		
		JComboBox goodCombo = new JComboBox();
		goodCombo.setBounds(Constants.WIDTH_DIV_15*5*19/20, Constants.HEIGHT_DIV_10*2+20, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		add(goodCombo);
		
		JLabel expressLabel = new JLabel("快递单号");
		expressLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		expressLabel.setBounds(Constants.WIDTH_DIV_15*6*4/5, Constants.HEIGHT_DIV_10*2*27/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(expressLabel);
		
		expressField = new JTextField();
		expressField.setEditable(false);
		expressField.setBounds(Constants.WIDTH_DIV_15*6*4/5+70, Constants.HEIGHT_DIV_10*2*27/20+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(expressField);
		expressField.setColumns(10);
		
		JLabel inDateLabel = new JLabel("入库时间");
		inDateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		inDateLabel.setBounds(Constants.WIDTH_DIV_15*6*4/5, Constants.HEIGHT_DIV_10*2*32/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(inDateLabel);
		
		inDateField = new JTextField();
		inDateField.setEditable(false);
		inDateField.setBounds(Constants.WIDTH_DIV_15*6*4/5+70, Constants.HEIGHT_DIV_10*2*32/20+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(inDateField);
		inDateField.setColumns(10);
		
		JLabel destinationLabel = new JLabel("到达地");
		destinationLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		destinationLabel.setBounds(Constants.WIDTH_DIV_15*6*4/5, Constants.HEIGHT_DIV_10*2*37/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(destinationLabel);
		
		destinationField = new JTextField();
		destinationField.setEditable(false);
		destinationField.setBounds(Constants.WIDTH_DIV_15*6*4/5+70, Constants.HEIGHT_DIV_10*2*37/20+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(destinationField);
		destinationField.setColumns(10);
		
		JLabel partLabel = new JLabel("区");
		partLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		partLabel.setBounds(Constants.WIDTH_DIV_15*6*4/5, Constants.HEIGHT_DIV_10*2*42/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(partLabel);
		
		partField = new JTextField();
		partField.setEditable(false);
		partField.setBounds(Constants.WIDTH_DIV_15*6*4/5+70, Constants.HEIGHT_DIV_10*2*42/20+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(partField);
		partField.setColumns(10);
		
		JLabel shelfLabel = new JLabel("架");
		shelfLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		shelfLabel.setBounds(Constants.WIDTH_DIV_15*6*4/5, Constants.HEIGHT_DIV_10*2*47/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(shelfLabel);
		
		shelfField = new JTextField();
		shelfField.setEditable(false);
		shelfField.setBounds(Constants.WIDTH_DIV_15*6*4/5+70, Constants.HEIGHT_DIV_10*2*47/20+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(shelfField);
		shelfField.setColumns(10);
		
		JLabel rowLabel = new JLabel("排");
		rowLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		rowLabel.setBounds(Constants.WIDTH_DIV_15*6*4/5, Constants.HEIGHT_DIV_10*2*52/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(rowLabel);
		
		rowField = new JTextField();
		rowField.setEditable(false);
		rowField.setBounds(Constants.WIDTH_DIV_15*6*4/5+70, Constants.HEIGHT_DIV_10*2*52/20+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(rowField);
		rowField.setColumns(10);
		
		JLabel placeLabel = new JLabel("位");
		placeLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		placeLabel.setBounds(Constants.WIDTH_DIV_15*6*4/5, Constants.HEIGHT_DIV_10*2*57/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(placeLabel);
		
		placeField = new JTextField();
		placeField.setEditable(false);
		placeField.setBounds(Constants.WIDTH_DIV_15*6*4/5+70, Constants.HEIGHT_DIV_10*2*57/20+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(placeField);
		placeField.setColumns(10);
		
		JLabel accountNameLabel = new JLabel("账户名称");
		accountNameLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		accountNameLabel.setBounds(Constants.WIDTH_DIV_15*9*19/20, Constants.HEIGHT_DIV_10*2, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(accountNameLabel);
		
		accountNameField = new JTextField();
		accountNameField.setEditable(false);
		accountNameField.setBounds(Constants.WIDTH_DIV_15*9*19/20+70, Constants.HEIGHT_DIV_10*2+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(accountNameField);
		accountNameField.setColumns(10);
		
		JLabel balanceLabel = new JLabel("账户余额");
		balanceLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		balanceLabel.setBounds(Constants.WIDTH_DIV_15*9*19/20, Constants.HEIGHT_DIV_10*2*25/20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(balanceLabel);
		
		balanceField = new JTextField();
		balanceField.setEditable(false);
		balanceField.setBounds(Constants.WIDTH_DIV_15*9*19/20+70, Constants.HEIGHT_DIV_10*2*25/20+7, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(balanceField);
		balanceField.setColumns(10);
		
		JButton button = new JButton("确认查看");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(Constants.WIDTH_DIV_15*9*19/20, Constants.HEIGHT_DIV_10*2*62/20, Constants.BUTTON_WIDTH_S*2, Constants.BUTTON_HEIGHT);
		add(button);

	}
}
