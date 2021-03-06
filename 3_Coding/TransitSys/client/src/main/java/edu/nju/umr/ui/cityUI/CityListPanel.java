package edu.nju.umr.ui.cityUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.constants.Province;
import edu.nju.umr.logic.cityLogic.CityLogic;
import edu.nju.umr.logicService.cityLogicSer.CityLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.UMRScrollPane;
import edu.nju.umr.ui.component.button.AddButton;
import edu.nju.umr.ui.component.button.CanModButton;
import edu.nju.umr.ui.component.button.ConfirmModButton;
import edu.nju.umr.ui.component.button.DelButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Utility;
import edu.nju.umr.vo.CitiesVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;

public class CityListPanel extends PPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3824777437901838141L;
	private Table cityTable1;
	private Table cityTable2;
	private DefaultTableModel model1;
	private DefaultTableModel model2;
	private TextField nameField;
	private TextField idField;
	private UMRComboBox<String> provinceCombo;
	private TextField distanceField;
	private JFrame frame;
	private ArrayList<CityVO> cityList;
	private ArrayList<CitiesVO> citiesList;
	private CityLSer logicSer;
	private Button deleteButton;
	private Button cancelButton;
	private Button confirmButton;
	/**
	 * Create the panel.
	 */
	public CityListPanel(JFrame fr,String name) {
		setLayout(null);
		frame=fr;
		try {
			logicSer = new CityLogic();
		} catch (RemoteException e1) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
		cityList = new ArrayList<CityVO>();
		citiesList = new ArrayList<CitiesVO>();
		
		TitleLabel cityLabel = new TitleLabel("城市管理");
		add(cityLabel);
		
		UMRLabel nameLabel = new UMRLabel("城市名");
		nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		nameLabel.setBounds(313, 485, 54, 23);
		add(nameLabel);
		
		nameField = new TextField();
		nameField.setBounds(377, 485, 106, 23);
		add(nameField);
		nameField.setEnabled(false);;
		nameField.setColumns(10);
		
		UMRLabel idLabel = new UMRLabel("区号");
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		idLabel.setBounds(493, 485, 54, 23);
		add(idLabel);
		
		idField = new TextField();
		idField.setBounds(531, 485, 106, 23);
		add(idField);
		idField.setEnabled(false);
		idField.setColumns(10);
		
		UMRLabel provinceLabel = new UMRLabel("所属省份");
		provinceLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		provinceLabel.setBounds(647, 485, 74, 23);
		add(provinceLabel);
		
		provinceCombo = new UMRComboBox<String>();
		provinceCombo.setBounds(716, 485, 106, 23);
		provinceCombo.setModel(new DefaultComboBoxModel<String>(Province.PROVINCES));
		provinceCombo.setEnabled(false);
		add(provinceCombo);
		
		UMRLabel distanceLabel = new UMRLabel("距离km");
		distanceLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		distanceLabel.setBounds(480, 525, 54, 23);
		add(distanceLabel);
		
		distanceField = new TextField();
		distanceField.setBounds(531, 523, 106, 23);
		add(distanceField);
		distanceField.setEnabled(false);
		distanceField.setColumns(10);
		
		Button addButton = new AddButton();
		addButton.setBounds(334, 566, 100, 30);
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				model1.setRowCount(model1.getRowCount()+1);
				cityTable1.getSelectionModel().setSelectionInterval(model1.getRowCount()-1, model1.getRowCount()-1);
				model2.setRowCount(model2.getRowCount()+1);
				cityTable2.getSelectionModel().setSelectionInterval(model2.getRowCount()-1, model2.getRowCount()-1);
				nameField.setText("");
				idField.setText("");
				provinceCombo.setSelectedIndex(0);
				distanceField.setText("");
			}
		});
		add(addButton);
		
		deleteButton = new DelButton();
		deleteButton.setBounds(450, 566, 100, 30);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// TODO 自动生成的方法存根
				int n = JOptionPane.showConfirmDialog(frame, "确认删除吗?", "确认删除框", JOptionPane.YES_NO_OPTION);  
		        if (n == JOptionPane.YES_OPTION)  {  
		        	Result result = logicSer.deleteCity(cityList.get(cityTable1.getSelectedRow()).getName(),name);
		        	if(result.equals(Result.SUCCESS)){
		        		initialize();
		        		DoHint.hint(result, frame);
					}
		        	else{
		        		@SuppressWarnings("unused")
		        		HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
		        	}
		        }
			}
		});
		deleteButton.setEnabled(false);
		add(deleteButton);
		
		confirmButton = new ConfirmModButton();
		confirmButton.setBounds(567, 566, 100, 30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if((cityTable1.getSelectedRow() >= 0)&&(cityTable2.getSelectedRow() >= 0)&&(cityTable1.getSelectedRow() != cityTable2.getSelectedRow())){
					if(isCitiesLegal()){;
						String city1 = cityList.get(cityTable1.getSelectedRow()).getName();
						String city2 = cityList.get(cityTable2.getSelectedRow()).getName();
						Result result = logicSer.reviseCities(new CitiesVO(city1, city2, Double.parseDouble(distanceField.getText())),name);
						if(result.equals(Result.SUCCESS)){
							initialize();
							cityTable1.clearSelection();
							cityTable2.clearSelection();
							DoHint.hint(result, frame,false);
						} else {
							@SuppressWarnings("unused")
							HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
						}
					}
				} else {
					if(isCityLegal()){
						Result result;
						if(cityTable1.getSelectedRow() >= cityList.size()){
							result = logicSer.addCity(new CityVO(nameField.getText(), idField.getText(), (String)provinceCombo.getSelectedItem()),name);
						} else {
							if(cityTable1.getSelectedRow() < 0){
								result = logicSer.reviseCity(new CityVO(nameField.getText(), idField.getText(), (String)provinceCombo.getSelectedItem()), cityTable2.getSelectedRow(),name);
							} else {
								result = logicSer.reviseCity(new CityVO(nameField.getText(), idField.getText(), (String)provinceCombo.getSelectedItem()), cityTable1.getSelectedRow(),name);
							}
						}
						if(result.equals(Result.SUCCESS)){
							initialize();
							cityTable1.clearSelection();
							cityTable2.clearSelection();
							DoHint.hint(result, frame);
						} else {
							@SuppressWarnings("unused")
							HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
						}
					}
				}
			}
		});
		add(confirmButton);
		
		cancelButton = new CanModButton();
		cancelButton.setBounds(683, 566, 100, 30);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if((cityTable1.getSelectedRow() >= 0)&&(cityTable2.getSelectedRow() >= 0)&&(cityTable1.getSelectedRow() != cityTable2.getSelectedRow())){
					getDistance();
				} else {
					String name = "";
					String id = "";
					String province = "";
					CityVO city = null;
					if(cityTable1.getSelectedRow() >= 0){
						city = cityList.get(cityTable1.getSelectedRow());
					} else if(cityTable2.getSelectedRow() >= 0){
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
		
		Button exitButton = new ExitButton();
		exitButton.setBounds(871, 566, 100, 30);
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
					if(cityTable1.getSelectedRow()==-1&&cityTable2.getSelectedRow()==-1){
						confirmButton.setEnabled(false);
						cancelButton.setEnabled(false);
						deleteButton.setEnabled(false);
					} else {
						confirmButton.setEnabled(true);
						cancelButton.setEnabled(true);
						deleteButton.setEnabled(true);
					}
					
					if(cityTable1.getSelectedRow()>=cityList.size()||cityTable2.getSelectedRow()>=cityList.size()){
						addButton.setEnabled(true);
						deleteButton.setEnabled(true);
						nameField.setEnabled(true);
						idField.setEnabled(true);
						provinceCombo.setEnabled(true);
					} else if(((cityTable2.getSelectedRow() == -1)||cityTable2.getSelectedRow() == cityTable1.getSelectedRow())&&(cityTable1.getSelectedRow() >= 0)){
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
					} else if((cityTable1.getSelectedRow() >= 0)&&(cityTable2.getSelectedRow() >= 0)){
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
		cityTable1.setBounds(140, Constants.LAYOUT_FIR_Y-20, 403, 367);
		cityTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cityTable1.getTableHeader().setReorderingAllowed(false);
		UMRScrollPane scroll1=new UMRScrollPane(cityTable1);
		scroll1.setBounds(140,Constants.LAYOUT_FIR_Y-20, 403, 367);
		scroll1.setVerticalScrollBarPolicy(UMRScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"城市名","区号","省份"};
		model1.setColumnIdentifiers(columnNames);
		add(scroll1);
		
		cityTable2 = new Table(new DefaultTableModel());
		model2=(DefaultTableModel)cityTable2.getModel();
		cityTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false){
					if(cityTable1.getSelectedRow()>=cityList.size()||cityTable2.getSelectedRow()>=cityList.size())
					{
						
					}else if(((cityTable1.getSelectedRow() == -1)||cityTable1.getSelectedRow() == cityTable2.getSelectedRow())&&(cityTable2.getSelectedRow() >= 0)){
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
					} else if((cityTable1.getSelectedRow() >= 0)&&(cityTable2.getSelectedRow() >= 0)){
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
		cityTable2.setBounds(567, Constants.LAYOUT_FIR_Y-20, 403, 367);
		cityTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cityTable2.getTableHeader().setReorderingAllowed(false);
		UMRScrollPane scroll2=new UMRScrollPane(cityTable2);
		scroll2.setBounds(567, Constants.LAYOUT_FIR_Y-20, 403, 367);
		scroll2.setVerticalScrollBarPolicy(UMRScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		model2.setColumnIdentifiers(columnNames);
		add(scroll2);
		
		
		
		initialize();
		
	}
	@SuppressWarnings("unchecked")
	private void initialize(){
		ResultMessage cityResult = logicSer.cityList();
		if(cityResult.getReInfo().equals(Result.SUCCESS)){
			cityList = (ArrayList<CityVO>) cityResult.getMessage();
			displayTable();
			confirmButton.setEnabled(false);
			cancelButton.setEnabled(false);
			deleteButton.setEnabled(false);
			nameField.setText("");
			nameField.setEnabled(false);
			idField.setText("");
			idField.setEnabled(false);;
			provinceCombo.setSelectedIndex(0);
			provinceCombo.setEnabled(false);
			distanceField.setText("");
			distanceField.setEnabled(false);;
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(cityResult.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return;
		}
		ResultMessage citiesResult = logicSer.citiesList();
		if(citiesResult.getReInfo().equals(Result.SUCCESS)){
			citiesList = (ArrayList<CitiesVO>) citiesResult.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(citiesResult.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
		}
	}
	private void displayTable(){
		cityTable1.clearSelection();
		cityTable2.clearSelection();
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
