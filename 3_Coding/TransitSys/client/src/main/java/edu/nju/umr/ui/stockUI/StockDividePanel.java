package edu.nju.umr.ui.stockUI;

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

import edu.nju.umr.logic.stockLogic.StockDivideLogic;
import edu.nju.umr.logicService.stockLogicSer.StockDivideLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;

public class StockDividePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3564861686953328781L;
	private JTextField searchField;
	private JTextField idField;
	private JTextField rowField;
	private JTextField placeField;
	private JFrame frame;
	private Table table;
	private DefaultTableModel model;
	private StockDivideLSer logicSer;
	private ArrayList<ShelfVO> shelfList;
	private String orgId;
	/**
	 * Create the panel.
	 */
	public StockDividePanel(JFrame fr,String orgId,String name) {
		setLayout(null);
		frame=fr;
		logicSer = new StockDivideLogic();
		this.orgId = orgId;
		
		JLabel divideLabel = new JLabel("库存分区");
		divideLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		divideLabel.setBounds(508, 36, 88, 24);
		add(divideLabel);
		
		searchField = new JTextField();
		searchField.setText("请输入架的编号");
		searchField.setBounds(233, 67, 542, 24);
		add(searchField);
		searchField.setColumns(10);
		
		
		JButton searchButton = new JButton("搜索");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 12));
		searchButton.setBounds(827, 66, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		searchButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings({ "unused" })
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(searchField.getText().equals("")){
					HintFrame hint = new HintFrame("请输入关键字！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
				} else {
					search();
				}
			}
		});
		add(searchButton);
		
		JLabel idLabel = new JLabel("编号");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		idLabel.setBounds(206, 500, 54, 24);
		add(idLabel);
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(253, 500, 98, 22);
		add(idField);
		idField.setColumns(10);
		
		JLabel rowLabel = new JLabel("排数");
		rowLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		rowLabel.setBounds(370, 500, 54, 24);
		add(rowLabel);
		
		rowField = new JTextField();
		rowField.setBounds(416, 500, 98, 22);
		add(rowField);
		rowField.setColumns(10);
		
		JLabel placeLabel = new JLabel("每排位数");
		placeLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		placeLabel.setBounds(541, 500, 71, 24);
		add(placeLabel);
		
		placeField = new JTextField();
		placeField.setBounds(617, 500, 98, 22);
		add(placeField);
		placeField.setColumns(10);
		
		JLabel partLabel = new JLabel("所在区");
		partLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		partLabel.setBounds(742, 500, 54, 24);
		add(partLabel);
		
		JComboBox<String> partCombo = new JComboBox<String>();
		partCombo.setBounds(803, 500, 98, 21);
		partCombo.setModel(new DefaultComboBoxModel<String>(new String[]{"航运区","铁运区","汽运区","机动区"}));
		add(partCombo);
		
		JButton addButton = new JButton("新增");
		addButton.setFont(new Font("宋体", Font.PLAIN, 12));
		addButton.setBounds(332, 541, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				String blank[] = new String[4];
				for(int i = 0;i < 4;i++){
					blank[i] = "";
				}
				model.addRow(blank);
				table.getSelectionModel().setSelectionInterval(table.getRowCount()-1, table.getRowCount()-1);
				idField.setText(logicSer.getNextId(orgId));
			}
		});
		add(addButton);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 12));
		deleteButton.setBounds(455, 541, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Result result = logicSer.deleteShelf(shelfList.get(table.getSelectedRow()).getId(),name);
				fresh(result);
			}
		});
		add(deleteButton);
		
		JButton confirmButton = new JButton("确认修改");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 12));
		confirmButton.setBounds(578, 541, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					ShelfVO shelf = new ShelfVO(idField.getText(), Integer.parseInt(rowField.getText()), Integer.parseInt(placeField.getText()), EnumTransFactory.getPart((String)partCombo.getSelectedItem()));
					if(table.getSelectedRow() >= shelfList.size()){				
						Result result = logicSer.addShelf(shelf,name);
						fresh(result);
					} else {
						Result result = logicSer.reviseShelf(shelf,name);
						fresh(result);
					}
				}
			}
		});
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消修改");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 12));
		cancelButton.setBounds(701, 541, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		cancelButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(table.getSelectedRow() < shelfList.size()){
					ShelfVO shelf = shelfList.get(table.getSelectedRow());
					idField.setText(shelf.getId());
					partCombo.setSelectedIndex(shelf.getPart().ordinal());
					rowField.setText(""+shelf.getRow());
					placeField.setText(""+shelf.getPlace());
				} else {
					model.setRowCount(model.getRowCount() - 1);
					idField.setText("");
					rowField.setText("");
					placeField.setText("");
					partCombo.setSelectedIndex(0);
				}
			}
		});
		add(cancelButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(881, 541, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(exitButton);
		tableInit();
		
	}
	private void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setBounds(233, 109, 638, 371);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(233, 109, 638, 371);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"架号","所属区","排数","每排位数"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
		
		getAll();
	}
	private void tableDisplay(){
		model.setRowCount(0);
		for(ShelfVO shelf:shelfList){
			String info[] = getRow(shelf);
			model.addRow(info);
		}
	}
	private String[] getRow(ShelfVO shelf){
		String info[] = new String[4];
		info[0] = shelf.getId();
		info[1] = EnumTransFactory.checkPart(shelf.getPart());
		info[2] = ""+shelf.getRow();
		info[3] = ""+shelf.getPlace();
		return info;
	}
	private void fresh(Result result){
		if(result.equals(Result.SUCCESS)){
			if(searchField.getText().equals("")){
				getAll();
			} else {
				search();
			}
			DoHint.hint(result, frame);
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
		}
	}
	@SuppressWarnings("unchecked")
	private void search(){
		ResultMessage message = logicSer.searchShelf(orgId, searchField.getText());
		if(message.getReInfo().equals(Result.SUCCESS)){
			shelfList = (ArrayList<ShelfVO>) message.getMessage();
			tableDisplay();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(message.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
		}
	}
	@SuppressWarnings("unchecked")
	private void getAll(){
		ResultMessage message = logicSer.searchShelf(orgId, null);
		if(message.getReInfo().equals(Result.SUCCESS)){
			shelfList = (ArrayList<ShelfVO>) message.getMessage();
			tableDisplay();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(message.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
		}
	}
	@SuppressWarnings("unused")
	private boolean isLegal(){
		try {
			int row = Integer.parseInt(rowField.getText());
			if(row <= 0){
				HintFrame hint = new HintFrame("排数必须为正！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
				return false;
			}
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("排数格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		try {
			int place = Integer.parseInt(placeField.getText());
			if(place <= 0){
				HintFrame hint = new HintFrame("每排位数必须为正！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
				return false;
			}
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("每排位数格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		return true;
	}
}
