package edu.nju.umr.ui.cityUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.constants.Province;
import edu.nju.umr.logic.cityLogic.CityLogic;
import edu.nju.umr.logicService.cityLogicSer.CityLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.utility.Utility;
import edu.nju.umr.vo.CitiesVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;

public class CityListPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3824777437901838141L;
	private Table cityTable1;
	private Table cityTable2;
	private DefaultTableModel model1;
	private DefaultTableModel model2;
	private JTextField nameField;
	private JTextField idField;
	private JComboBox<String> provinceCombo;
	private JTextField distanceField;
	private JFrame frame;
	private ArrayList<CityVO> cityList;
	private ArrayList<CitiesVO> citiesList;
	private CityLSer logicSer;
	/**
	 * Create the panel.
	 */
	public CityListPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		logicSer = new CityLogic();
		
		JLabel cityLabel = new JLabel("城市管理");
		cityLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		cityLabel.setBounds(508, 35, 88, 29);
		add(cityLabel);
		
		JLabel nameLabel = new JLabel("城市名");
		nameLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		nameLabel.setBounds(313, 471, 54, 23);
		add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(377, 472, 106, 22);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel idLabel = new JLabel("区号");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		idLabel.setBounds(493, 473, 54, 19);
		add(idLabel);
		
		idField = new JTextField();
		idField.setBounds(531, 471, 106, 23);
		add(idField);
		idField.setColumns(10);
		
		JLabel provinceLabel = new JLabel("所属省份");
		provinceLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		provinceLabel.setBounds(647, 473, 74, 19);
		add(provinceLabel);
		
		provinceCombo = new JComboBox<String>();
		provinceCombo.setBounds(716, 472, 106, 22);
		provinceCombo.setModel(new DefaultComboBoxModel<String>(Province.PROVINCES));
		add(provinceCombo);
		
		JLabel distanceLabel = new JLabel("距离");
		distanceLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		distanceLabel.setBounds(567, 525, 54, 19);
		add(distanceLabel);
		
		distanceField = new JTextField();
		distanceField.setBounds(606, 523, 106, 23);
		add(distanceField);
		distanceField.setColumns(10);
		
		JButton addButton = new JButton("新增城市");
		addButton.setBounds(334, 566, 93, 23);
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String newInfo[] = new String[3];
				for(int i = 0;i < 3;i++){
					newInfo[i] = "";
				}
				model1.addRow(newInfo);
				cityTable1.getSelectionModel().setSelectionInterval(model1.getRowCount()-1, model1.getRowCount()-1);
				model2.addRow(newInfo);
				cityTable2.getSelectionModel().setSelectionInterval(model2.getRowCount()-1, model2.getRowCount()-1);
			}
		});
		add(addButton);
		
		JButton deleteButton = new JButton("删除城市");
		deleteButton.setBounds(450, 566, 93, 23);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				Result result = logicSer.deleteCity(cityList.get(cityTable1.getSelectedRow()).getName());
				if(result.equals(Result.SUCCESS)){
					initialize();
				} else {
					@SuppressWarnings("unused")
					HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
				}
			}
		});
		add(deleteButton);
		
		JButton confirmButton = new JButton("确认修改");
		confirmButton.setBounds(567, 566, 93, 23);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if((cityTable1.getSelectedRow() > 0)&&(cityTable2.getSelectedRow() > 0)&&(cityTable1.getSelectedRow() != cityTable2.getSelectedRow())){
					if(isCitiesLegal()){
						String city1 = cityList.get(cityTable1.getSelectedRow()).getName();
						String city2 = cityList.get(cityTable2.getSelectedRow()).getName();
						Result result = logicSer.reviseCities(new CitiesVO(city1, city2, Double.parseDouble(distanceField.getText())));
						if(result.equals(Result.SUCCESS)){
							initialize();
						} else {
							@SuppressWarnings("unused")
							HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
						}
					}
				} else {
					if(isCityLegal()){
						Result result;
						if(cityTable1.getSelectedRow() >= cityList.size()){
							result = logicSer.addCity(new CityVO(nameField.getText(), idField.getText(), (String)provinceCombo.getSelectedItem()));
						} else {
							if(cityTable1.getSelectedRow() < 0){
								result = logicSer.reviseCity(new CityVO(nameField.getText(), idField.getText(), (String)provinceCombo.getSelectedItem()), cityTable1.getSelectedRow());
							} else {
								result = logicSer.reviseCity(new CityVO(nameField.getText(), idField.getText(), (String)provinceCombo.getSelectedItem()), cityTable2.getSelectedRow());
							}
						}
						if(result.equals(Result.SUCCESS)){
							initialize();
						} else {
							@SuppressWarnings("unused")
							HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
						}
					}
				}
			}
		});
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消修改");
		cancelButton.setBounds(683, 566, 93, 23);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if((cityTable1.getSelectedRow() > 0)&&(cityTable2.getSelectedRow() > 0)&&(cityTable1.getSelectedRow() != cityTable2.getSelectedRow())){
					getDistance();
				} else {
					String name = "";
					String id = "";
					String province = "";
					CityVO city = null;
					if(cityTable1.getSelectedRow() > 0){
						city = cityList.get(cityTable1.getSelectedRow());
					} else if(cityTable2.getSelectedRow() > 0){
						city = cityList.get(cityTable2.getSelectedRow());
					} else {
						return;
					}
					name = city.getName();
					id = city.getId();
					province = city.getProvince();
					nameField.setText(name);
					idField.setText(id);
					provinceCombo.setSelectedItem(province);;
				}
			}
		});
		add(cancelButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setBounds(871, 566, 93, 23);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(exitButton);
		
		cityTable1 = new Table(new DefaultTableModel());
		model1=(DefaultTableModel)cityTable1.getModel();
		cityTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false){
					if((cityTable2.getSelectedRow() == -1)||cityTable2.getSelectedRow() == cityTable1.getSelectedRow()){
						addButton.setEnabled(true);
						deleteButton.setEnabled(true);
						nameField.setEnabled(true);
						idField.setEnabled(true);
						provinceCombo.setEnabled(true);
						distanceField.setEnabled(false);
						CityVO citySelected = cityList.get(cityTable1.getSelectedRow());
						nameField.setText(citySelected.getName());
						idField.setText(citySelected.getId());
						provinceCombo.setSelectedItem(citySelected.getProvince());;
					} else {
						addButton.setEnabled(false);
						deleteButton.setEnabled(false);
						nameField.setEnabled(false);
						idField.setEnabled(false);
						provinceCombo.setEnabled(false);
						distanceField.setEnabled(true);
						getDistance();
					}
				}
			}
		});
		cityTable1.setBounds(140, 80, 403, 367);
		cityTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cityTable1.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll1=new JScrollPane(cityTable1);
		scroll1.setBounds(140, 80, 403, 367);
		scroll1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"城市名","区号","省份"};
		model1.setColumnIdentifiers(columnNames);
		add(scroll1);
		
		cityTable2 = new Table(new DefaultTableModel());
		model2=(DefaultTableModel)cityTable2.getModel();
		cityTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false){
					if((cityTable1.getSelectedRow() == -1)||cityTable1.getSelectedRow() == cityTable2.getSelectedRow()){
						addButton.setEnabled(true);
						deleteButton.setEnabled(true);
						nameField.setEnabled(true);
						idField.setEnabled(true);
						provinceCombo.setEnabled(true);
						distanceField.setEnabled(false);
						CityVO citySelected = cityList.get(cityTable2.getSelectedRow());
						nameField.setText(citySelected.getName());
						idField.setText(citySelected.getId());
						provinceCombo.setSelectedItem(citySelected.getProvince());
					} else {
						addButton.setEnabled(false);
						deleteButton.setEnabled(false);
						nameField.setEnabled(false);
						idField.setEnabled(false);
						provinceCombo.setEnabled(false);
						distanceField.setEnabled(true);
						getDistance();
					}
				}
			}
		});
		cityTable2.setBounds(567, 80, 403, 367);
		cityTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cityTable2.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll2=new JScrollPane(cityTable2);
		scroll2.setBounds(567, 80, 403, 367);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		model2.setColumnIdentifiers(columnNames);
		add(scroll2);
		initialize();
	}
	@SuppressWarnings("unchecked")
	private void initialize(){
		ResultMessage cityResult = logicSer.cityList();
		if(cityResult.equals(Result.SUCCESS)){
			cityList = (ArrayList<CityVO>) cityResult.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(cityResult.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
		}
		displayTable();
		ResultMessage citiesResult = logicSer.citiesList();
		if(citiesResult.equals(Result.SUCCESS)){
			citiesList = (ArrayList<CitiesVO>) citiesResult.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(citiesResult.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
		}
	}
	private void displayTable(){
		model1.setRowCount(0);
		model2.setRowCount(0);
		for(CityVO city:cityList){
			String cityInfo[] = new String[3];
			cityInfo[0] = city.getName();
			cityInfo[1] = city.getId();
			cityInfo[2] = city.getProvince();	
			model1.addRow(cityInfo);
			model2.addRow(cityInfo);
		}
	}
	@SuppressWarnings("unused")
	private boolean isCityLegal(){
		if(nameField.getText().equals("")){
			HintFrame hint = new HintFrame("城市名称未填写！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if(idField.getText().equals("")){
			HintFrame hint = new HintFrame("区号未填写！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if(!Utility.isNumberic(idField.getText())){
			HintFrame hint = new HintFrame("区号含有非数字字符！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if((idField.getText().length() > 5)||(idField.getText().length() < 3)){
			HintFrame hint = new HintFrame("区号位数不正确！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		return true;
	}
	private boolean isCitiesLegal(){
		try {
			Double.parseDouble(distanceField.getText());
		} catch (NumberFormatException e){
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame("距离格式不正确！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		return true;
	}
	private void getDistance(){
		String city1 = cityList.get(cityTable1.getSelectedRow()).getName();
		String city2 = cityList.get(cityTable2.getSelectedRow()).getName();
		for(CitiesVO cities:citiesList){
			if((cities.getCity1().equals(city1))&&(cities.getCity2().equals(city2))){
				distanceField.setText(""+cities.getDistance());
			} else if((cities.getCity1().equals(city2))&&(cities.getCity2().equals(city1))){
				distanceField.setText(""+cities.getDistance());
			}
		}
	}
}
