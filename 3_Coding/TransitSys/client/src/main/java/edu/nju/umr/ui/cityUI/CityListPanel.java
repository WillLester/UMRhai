package edu.nju.umr.ui.cityUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logicService.cityLogicSer.CityLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
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
	private JTextField provinceField;
	private JTextField priceField;
	private JTextField distanceField;
	private JFrame frame;
	private ArrayList<CityVO> cityList;
	private ArrayList<CitiesVO> citiesList;
	private CityLSer logicSer;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public CityListPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
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
		
		provinceField = new JTextField();
		provinceField.setBounds(716, 472, 106, 22);
		add(provinceField);
		provinceField.setColumns(10);
		
		JLabel priceLabel = new JLabel("价格");
		priceLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		priceLabel.setBounds(400, 520, 43, 29);
		add(priceLabel);
		
		priceField = new JTextField();
		priceField.setBounds(437, 524, 106, 22);
		add(priceField);
		priceField.setColumns(10);
		
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
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(cityTable1.getSelectedRow() == -1){
					
				}
			}
		});
		add(deleteButton);
		
		JButton confirmButton = new JButton("确认修改");
		confirmButton.setBounds(567, 566, 93, 23);
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消修改");
		cancelButton.setBounds(683, 566, 93, 23);
		add(cancelButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setBounds(871, 566, 93, 23);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(exitButton);
		
		cityTable1 = new Table(new DefaultTableModel());
		model1=(DefaultTableModel)cityTable1.getModel();
		cityTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false){
					if(cityTable2.getSelectedRow() == -1){
						addButton.setEnabled(true);
						deleteButton.setEnabled(true);
						nameField.setEnabled(true);
						idField.setEnabled(true);
						provinceField.setEnabled(true);
						distanceField.setEnabled(false);
						priceField.setEnabled(false);
					} else {
						addButton.setEnabled(false);
						deleteButton.setEnabled(false);
						nameField.setEnabled(false);
						idField.setEnabled(false);
						provinceField.setEnabled(false);
						distanceField.setEnabled(false);
						priceField.setEnabled(false);
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
				if(e.getValueIsAdjusting()==false);
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
		for(CityVO city:cityList){
			String cityInfo[] = new String[3];
			cityInfo[0] = city.getName();
			cityInfo[1] = city.getId();
			cityInfo[2] = city.getProvince();	
			model1.addRow(cityInfo);
			model2.addRow(cityInfo);
		}
	}
}
