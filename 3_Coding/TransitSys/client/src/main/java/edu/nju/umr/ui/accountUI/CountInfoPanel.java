package edu.nju.umr.ui.accountUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.ELabel;
import edu.nju.umr.ui.component.InfoPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.CountVO;
import edu.nju.umr.vo.GoodVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.StockVO;
import edu.nju.umr.vo.VanVO;
import edu.nju.umr.vo.WorkVO;

public class CountInfoPanel extends InfoPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5928970050302258436L;
	private TextField mobileField;
	private TextField dutyField;
	private TextField plateField;
	private TextField dateField;
	private TextField inDateField;
	private TextField destinationField;
	private TextField partField;
	private TextField shelfField;
	private TextField rowField;
	private TextField placeField;
	private TextField balanceField;
	private UMRComboBox<String> orgCombo;
	private UMRComboBox<String> stockCombo;
	private UMRComboBox<String> accountCombo;
	private UMRComboBox<String> workerCombo;
	private UMRComboBox<String> vanCombo;
	private UMRComboBox<String> goodCombo;
	private ArrayList<OrgVO> orgList;
	private ArrayList<WorkVO> workerList;
	private ArrayList<WorkVO> workerPresented;
	private ArrayList<VanVO> vanList;
	private ArrayList<VanVO> vanPresented;
	private ArrayList<StockVO> stockList;
	private ArrayList<GoodVO> goodPresented;
	private ArrayList<AccountVO> accountList;
	private JFrame frame;
	private static final int all_y=25;

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
		
		TitleLabel countLabel = new TitleLabel("期初信息查看");
		countLabel.setLocation(995/2-countLabel.getWidth()/2,countLabel.getY());
		add(countLabel);
		
		ELabel orgLabel = new ELabel("机构信息");
		orgLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		orgLabel.setBounds(234, 82+all_y, 67, 17);
		add(orgLabel);
		
		orgCombo = new UMRComboBox<String>();
		orgCombo.setBounds(150, 102+all_y, Constants.TEXTFIELD_WIDTH_S*3/2, 30);
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
					setWorkCombo(org.getName());
					if(org.getKind().equals(Organization.HALL)){
						setVanCombo(org.getId());
					}
				}
			}
		});
		add(orgCombo);
		
		
		ELabel stockLabel = new ELabel("库存信息");
		stockLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		stockLabel.setBounds(518, 82+all_y, 67, 17);
		add(stockLabel);
		
		stockCombo = new UMRComboBox<String>();
		stockCombo.setBounds(437, 102+all_y, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		String stocks[] = new String[stockList.size()];
		for(int i = 0;i < stocks.length;i++){
			StockVO stock = stockList.get(i);
			stocks[i] = stock.getName();
		}
		stockCombo.setModel(new DefaultComboBoxModel<String>(stocks));
		stockCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO 自动生成的方法存根
				if(arg0.getStateChange() == ItemEvent.SELECTED){
					setGoodCombo(stockCombo.getSelectedIndex());
				}
			}
		});
		add(stockCombo);
		
		
		
		ELabel accountLabel = new ELabel("账户信息");
		accountLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		accountLabel.setBounds(808, 82+all_y, 67, 17);
		add(accountLabel);
		
		accountCombo = new UMRComboBox<String>();
		accountCombo.setBounds(723, 102+all_y, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
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
					setAccountInfo(accountCombo.getSelectedIndex());
				}
			}
		});
		add(accountCombo);
		
		
		ELabel workerLabel = new ELabel("人员信息");
		workerLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		workerLabel.setBounds(234, 138+all_y, 67, 17);
		add(workerLabel);
		
		workerCombo = new UMRComboBox<String>();
		workerCombo.setBounds(150, 158+all_y, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		workerCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					setWorkInfo(workerCombo.getSelectedIndex());
				}
			}
		});
		add(workerCombo);
		
		ELabel mobileLabel = new ELabel("手机号");
		mobileLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		mobileLabel.setBounds(155, 200+all_y, 53, 34);
		add(mobileLabel);
		
		mobileField = new TextField();
		mobileField.setEditable(false);
		mobileField.setBounds(210, 207+all_y, 169, 20);
		add(mobileField);
		mobileField.setColumns(10);
		
		ELabel dutyLabel = new ELabel("职务");
		dutyLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		dutyLabel.setBounds(155, 235+all_y, 45, 34);
		add(dutyLabel);
		
		dutyField = new TextField();
		dutyField.setEditable(false);
		dutyField.setBounds(210, 242+all_y, 169, 20);
		add(dutyField);
		dutyField.setColumns(10);
		
		vanCombo = new UMRComboBox<String>();
		vanCombo.setBounds(150, 300+all_y, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		vanCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					setVanInfo(vanCombo.getSelectedIndex());
				}
			}
		});
		add(vanCombo);
		
		ELabel vanLabel = new ELabel("车辆信息");
		vanLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		vanLabel.setBounds(234, 279+all_y, 67, 17);
		add(vanLabel);
		
		ELabel plateLabel = new ELabel("车牌号");
		plateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		plateLabel.setBounds(155, 342+all_y, 53, 34);
		add(plateLabel);
		
		plateField = new TextField();
		plateField.setEditable(false);
		plateField.setBounds(210, 349+all_y, 169, 20);
		add(plateField);
		plateField.setColumns(10);
		
		ELabel dateLabel = new ELabel("服役时间");
		dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		dateLabel.setBounds(155, 378+all_y, 67, 34);
		add(dateLabel);
		
		dateField = new TextField();
		dateField.setEditable(false);
		dateField.setBounds(220, 385+all_y, 159, 20);
		add(dateField);
		dateField.setColumns(10);
		
		ELabel goodLabel = new ELabel("货物信息");
		goodLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		goodLabel.setBounds(518, 138+all_y, 67, 17);
		add(goodLabel);
		
		goodCombo = new UMRComboBox<String>();
		goodCombo.setBounds(437, 158+all_y, Constants.TEXTFIELD_WIDTH_S*3/2, Constants.TEXTFIELD_HEIGHT);
		goodCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					setGoodInfo(goodCombo.getSelectedIndex());
				}
			}
		});
		add(goodCombo);
		
		ELabel inDateLabel = new ELabel("入库时间");
		inDateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		inDateLabel.setBounds(437, 200+all_y, 67, 34);
		add(inDateLabel);
		
		inDateField = new TextField();
		inDateField.setEditable(false);
		inDateField.setBounds(513, 207+all_y, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(inDateField);
		inDateField.setColumns(10);
		
		ELabel destinationLabel = new ELabel("到达地");
		destinationLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		destinationLabel.setBounds(437, 235+all_y, 59, 34);
		add(destinationLabel);
		
		destinationField = new TextField();
		destinationField.setEditable(false);
		destinationField.setBounds(513, 242+all_y, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(destinationField);
		destinationField.setColumns(10);
		
		ELabel partLabel = new ELabel("区");
		partLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		partLabel.setBounds(437, 270+all_y, 45, 34);
		add(partLabel);
		
		partField = new TextField();
		partField.setEditable(false);
		partField.setBounds(513, 277+all_y, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(partField);
		partField.setColumns(10);
		
		ELabel shelfLabel = new ELabel("架");
		shelfLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		shelfLabel.setBounds(437, 305+all_y, 59, 34);
		add(shelfLabel);
		
		shelfField = new TextField();
		shelfField.setEditable(false);
		shelfField.setBounds(513, 312+all_y, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(shelfField);
		shelfField.setColumns(10);
		
		ELabel rowLabel = new ELabel("排");
		rowLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		rowLabel.setBounds(437, 340+all_y, 59, 34);
		add(rowLabel);
		
		rowField = new TextField();
		rowField.setEditable(false);
		rowField.setBounds(513, 347+all_y, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(rowField);
		rowField.setColumns(10);
		
		ELabel placeLabel = new ELabel("位");
		placeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		placeLabel.setBounds(437, 375+all_y, 59, 34);
		add(placeLabel);
		
		placeField = new TextField();
		placeField.setEditable(false);
		placeField.setBounds(513, 382+all_y, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(placeField);
		placeField.setColumns(10);
		
		ELabel balanceLabel = new ELabel("账户余额");
		balanceLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		balanceLabel.setBounds(723, 135+all_y, 67, 34);
		add(balanceLabel);
		
		balanceField = new TextField();
		balanceField.setEditable(false);
		balanceField.setBounds(799, 142+all_y, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT*3/4);
		add(balanceField);
		balanceField.setColumns(10);
		
		Button confirmButton = new ConfirmButton();
		confirmButton.setBounds(854, 432+all_y,100,30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				frame.dispose();
			}
		});
		add(confirmButton);
		
		dataInit();
	}
	
	private void dataInit(){
		OrgVO org = orgList.get(0);
		setWorkCombo(org.getName());
		if(workerPresented.size() > 0){
			setWorkInfo(0);
		}
		if(org.getKind() == Organization.HALL){
			setVanCombo(org.getId());
		}
		setGoodCombo(0);
		if(goodPresented.size() > 0){
			setGoodInfo(0);
		}
		if(accountList.size() > 0){
			setAccountInfo(0);
		}
	}
	
	private void setWorkCombo(String orgName){
		workerPresented = new ArrayList<WorkVO>();
		for(WorkVO worker:workerList){
			if(worker.getOrg().equals(orgName)){
				workerPresented.add(worker);
			}
		}
		String workers[] = new String[workerPresented.size()];
		for(int i = 0;i < workers.length;i++){
			WorkVO worker = workerPresented.get(i);
			workers[i] = worker.getName();
		}
		workerCombo.setModel(new DefaultComboBoxModel<String>(workers));
	}
	
	private void setVanCombo(String orgId){
		vanPresented = new ArrayList<VanVO>();
		for(VanVO van:vanList){
			if(van.getHallId().equals(orgId)){
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
	
	private void setGoodCombo(int stockIndex){
		StockVO stock = stockList.get(stockIndex);
		goodPresented = stock.getGoods();
		String goods[] = new String[goodPresented.size()];
		for(int i = 0;i < goods.length;i++){
			GoodVO good = goodPresented.get(i);
			goods[i] = good.getId();
		}
		goodCombo.setModel(new DefaultComboBoxModel<String>(goods));
	}
	
	private void setWorkInfo(int index){
		WorkVO worker = workerPresented.get(index);
		mobileField.setText(worker.getMobile());
		dutyField.setText(EnumTransFactory.checkJuri(worker.getJuri()));
	}
	
	private void setVanInfo(int index){
		VanVO van = vanPresented.get(index);
		plateField.setText(van.getPlateNum());
		dateField.setText(DateFormat.DATE.format(van.getServTime().getTime()));
	}
	
	private void setGoodInfo(int index){
		GoodVO good = goodPresented.get(index);
		inDateField.setText(DateFormat.DATE.format(good.getDate().getTime()));
		destinationField.setText(good.getCity());
		partField.setText(EnumTransFactory.checkPart(good.getPart()));
		shelfField.setText(good.getShelf());
		rowField.setText(good.getRow()+"");
		placeField.setText(good.getPlace()+"");
	}
	
	private void setAccountInfo(int index){
		AccountVO account = accountList.get(index);
		balanceField.setText(account.getBalance()+"");
	}
}
