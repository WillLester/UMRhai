package edu.nju.umr.ui.accountUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.CountVO;
import edu.nju.umr.vo.GoodVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.StockVO;
import edu.nju.umr.vo.VanVO;
import edu.nju.umr.vo.WorkVO;

public class CountInfoPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5928970050302258436L;
	private JTextField mobileField;
	private JTextField dutyField;
	private JTextField plateField;
	private JTextField dateField;
	private JTextField inDateField;
	private JTextField destinationField;
	private JTextField partField;
	private JTextField shelfField;
	private JTextField rowField;
	private JTextField placeField;
	private JTextField balanceField;
	private JComboBox<String> orgCombo;
	private JComboBox<String> stockCombo;
	private JComboBox<String> accountCombo;
	private JComboBox<String> workerCombo;
	private JComboBox<String> vanCombo;
	private JComboBox<String> goodCombo;
	private ArrayList<OrgVO> orgList;
	private ArrayList<WorkVO> workerList;
	private ArrayList<WorkVO> workerPresented;
	private ArrayList<VanVO> vanList;
	private ArrayList<VanVO> vanPresented;
	private ArrayList<StockVO> stockList;
	private ArrayList<GoodVO> goodPresented;
	private ArrayList<AccountVO> accountList;
	private JFrame frame;

	/**
	 * Create the panel.
	 */
	public CountInfoPanel(CountVO count,JFrame fr) {
		setLayout(null);
		frame = fr;
		orgList = count.getOrganizations();
		workerList = count.getWorkers();
		vanList = count.getVans();
		stockList = count.getStocks();
		accountList = count.getAccounts();
		
		JLabel countLabel = new JLabel("期初信息查看");
		countLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		countLabel.setBounds(483, 6, 137, 98);
		add(countLabel);
		
		JLabel orgLabel = new JLabel("机构信息");
		orgLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		orgLabel.setBounds(234, 82, 67, 17);
		add(orgLabel);
		
		orgCombo = new JComboBox<String>();
		orgCombo.setBounds(150, 102, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		String orgs[] = new String[orgList.size()];
		for(int i = 0;i < orgs.length;i++){
			OrgVO org = orgList.get(i);
			orgs[i] = org.getName();
		}
		orgCombo.setModel(new DefaultComboBoxModel<String>(orgs));
		orgCombo.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					OrgVO org = orgList.get(orgCombo.getSelectedIndex());
					workerPresented = new ArrayList<WorkVO>();
					for(WorkVO worker:workerList){
						if(worker.getOrg().equals(org.getName())){
							workerPresented.add(worker);
						}
					}
					String workers[] = new String[workerPresented.size()];
					for(int i = 0;i < workers.length;i++){
						WorkVO worker = workerPresented.get(i);
						workers[i] = worker.getName();
					}
					workerCombo.setModel(new DefaultComboBoxModel<String>(workers));
					if(org.getKind().equals(Organization.HALL)){
						vanPresented = new ArrayList<VanVO>();
						for(VanVO van:vanList){
							if(van.getHallId().equals(org.getId())){
								vanPresented.add(van);
							}
						}
						String vans[] = new String[vanPresented.size()];
						for(int i = 0;i < vans.length;i++){
							VanVO van = vanPresented.get(i);
							vans[i] = van.getId();
						}
						vanCombo.setModel(new DefaultComboBoxModel<String>(vans));
					}
				}
			}
		});
		add(orgCombo);
		
		
		JLabel stockLabel = new JLabel("库存信息");
		stockLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		stockLabel.setBounds(518, 82, 67, 17);
		add(stockLabel);
		
		stockCombo = new JComboBox<String>();
		stockCombo.setBounds(437, 102, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		String stocks[] = new String[stockList.size()];
		for(int i = 0;i < stocks.length;i++){
			StockVO stock = stockList.get(i);
			stocks[i] = stock.getStockId();
		}
		stockCombo.setModel(new DefaultComboBoxModel<String>(stocks));
		stockCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO 自动生成的方法存根
				if(arg0.getStateChange() == ItemEvent.SELECTED){
					StockVO stock = stockList.get(stockCombo.getSelectedIndex());
					goodPresented = stock.getGoods();
					String goods[] = new String[goodPresented.size()];
					for(int i = 0;i < goods.length;i++){
						GoodVO good = goodPresented.get(i);
						goods[i] = good.getId();
					}
					goodCombo.setModel(new DefaultComboBoxModel<String>(goods));
				}
			}
		});
		add(stockCombo);
		
		
		
		JLabel accountLabel = new JLabel("账户信息");
		accountLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		accountLabel.setBounds(808, 82, 67, 17);
		add(accountLabel);
		
		accountCombo = new JComboBox<String>();
		accountCombo.setBounds(723, 102, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		String accounts[] = new String[accountList.size()];
		for(int i = 0;i < accounts.length;i++){
			AccountVO account = accountList.get(i);
			accounts[i] = account.getName();
		}
		accountCombo.setModel(new DefaultComboBoxModel<String>(accounts));
		accountCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO 自动生成的方法存根
				if(arg0.getStateChange() == ItemEvent.SELECTED){
					AccountVO account = accountList.get(accountCombo.getSelectedIndex());
					balanceField.setText(account.getBalance()+"");
				}
			}
		});
		add(accountCombo);
		
		
		JLabel workerLabel = new JLabel("人员信息");
		workerLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		workerLabel.setBounds(234, 138, 67, 17);
		add(workerLabel);
		
		workerCombo = new JComboBox<String>();
		workerCombo.setBounds(150, 158, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		workerCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					WorkVO worker = workerPresented.get(workerCombo.getSelectedIndex());
					mobileField.setText(worker.getMobile());
					dutyField.setText(EnumTransFactory.checkJuri(worker.getJuri()));
				}
			}
		});
		add(workerCombo);
		
		JLabel mobileLabel = new JLabel("手机号");
		mobileLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		mobileLabel.setBounds(155, 200, 53, 34);
		add(mobileLabel);
		
		mobileField = new JTextField();
		mobileField.setEditable(false);
		mobileField.setBounds(210, 207, 169, 20);
		add(mobileField);
		mobileField.setColumns(10);
		
		JLabel dutyLabel = new JLabel("职务");
		dutyLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		dutyLabel.setBounds(155, 235, 45, 34);
		add(dutyLabel);
		
		dutyField = new JTextField();
		dutyField.setEditable(false);
		dutyField.setBounds(210, 242, 169, 20);
		add(dutyField);
		dutyField.setColumns(10);
		
		vanCombo = new JComboBox<String>();
		vanCombo.setBounds(150, 300, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		vanCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					VanVO van = vanPresented.get(vanCombo.getSelectedIndex());
					plateField.setText(van.getPlateNum());
					dateField.setText(DateFormat.DATE.format(van.getServTime().getTime()));
				}
			}
		});
		add(vanCombo);
		
		JLabel vanLabel = new JLabel("车辆信息");
		vanLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		vanLabel.setBounds(234, 279, 67, 17);
		add(vanLabel);
		
		JLabel plateLabel = new JLabel("车牌号");
		plateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		plateLabel.setBounds(155, 342, 53, 34);
		add(plateLabel);
		
		plateField = new JTextField();
		plateField.setEditable(false);
		plateField.setBounds(210, 349, 169, 20);
		add(plateField);
		plateField.setColumns(10);
		
		JLabel dateLabel = new JLabel("服役时间");
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		dateLabel.setBounds(155, 378, 67, 34);
		add(dateLabel);
		
		dateField = new JTextField();
		dateField.setEditable(false);
		dateField.setBounds(220, 385, 159, 20);
		add(dateField);
		dateField.setColumns(10);
		
		JLabel goodLabel = new JLabel("货物信息");
		goodLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		goodLabel.setBounds(518, 138, 67, 17);
		add(goodLabel);
		
		goodCombo = new JComboBox<String>();
		goodCombo.setBounds(437, 158, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		goodCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					GoodVO good = goodPresented.get(goodCombo.getSelectedIndex());
					inDateField.setText(DateFormat.DATE.format(good.getDate().getTime()));
					destinationField.setText(good.getCity());
					partField.setText(EnumTransFactory.checkPart(good.getPart()));
					shelfField.setText(good.getShelf());
					rowField.setText(good.getRow()+"");
					placeField.setText(good.getPlace()+"");
				}
			}
		});
		add(goodCombo);
		
		JLabel inDateLabel = new JLabel("入库时间");
		inDateLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		inDateLabel.setBounds(437, 185, 67, 34);
		add(inDateLabel);
		
		inDateField = new JTextField();
		inDateField.setEditable(false);
		inDateField.setBounds(513, 192, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(inDateField);
		inDateField.setColumns(10);
		
		JLabel destinationLabel = new JLabel("到达地");
		destinationLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		destinationLabel.setBounds(437, 220, 59, 34);
		add(destinationLabel);
		
		destinationField = new JTextField();
		destinationField.setEditable(false);
		destinationField.setBounds(513, 227, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(destinationField);
		destinationField.setColumns(10);
		
		JLabel partLabel = new JLabel("区");
		partLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		partLabel.setBounds(437, 254, 45, 34);
		add(partLabel);
		
		partField = new JTextField();
		partField.setEditable(false);
		partField.setBounds(513, 261, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(partField);
		partField.setColumns(10);
		
		JLabel shelfLabel = new JLabel("架");
		shelfLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		shelfLabel.setBounds(437, 286, 59, 34);
		add(shelfLabel);
		
		shelfField = new JTextField();
		shelfField.setEditable(false);
		shelfField.setBounds(513, 292, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(shelfField);
		shelfField.setColumns(10);
		
		JLabel rowLabel = new JLabel("排");
		rowLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		rowLabel.setBounds(437, 322, 59, 34);
		add(rowLabel);
		
		rowField = new JTextField();
		rowField.setEditable(false);
		rowField.setBounds(513, 329, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(rowField);
		rowField.setColumns(10);
		
		JLabel placeLabel = new JLabel("位");
		placeLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		placeLabel.setBounds(437, 357, 59, 34);
		add(placeLabel);
		
		placeField = new JTextField();
		placeField.setEditable(false);
		placeField.setBounds(513, 364, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(placeField);
		placeField.setColumns(10);
		
		JLabel balanceLabel = new JLabel("账户余额");
		balanceLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		balanceLabel.setBounds(723, 135, 67, 34);
		add(balanceLabel);
		
		balanceField = new JTextField();
		balanceField.setEditable(false);
		balanceField.setBounds(799, 142, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(balanceField);
		balanceField.setColumns(10);
		
		Button confirmButton = new ConfirmButton();
		confirmButton.setBounds(854, 432,100,30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				frame.dispose();
			}
		});
		add(confirmButton);

		
//		orgCombo.setSelectedIndex(0);
//		stockCombo.setSelectedIndex(0);
//		accountCombo.setSelectedIndex(0);
	}
}
