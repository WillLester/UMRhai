package edu.nju.umr.ui.stockUI;

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

import edu.nju.umr.logic.stockLogic.StockDivideLogic;
import edu.nju.umr.logicService.stockLogicSer.StockDivideLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.UMRScrollPane;
import edu.nju.umr.ui.component.Utils;
import edu.nju.umr.ui.component.button.AddButton;
import edu.nju.umr.ui.component.button.CanModButton;
import edu.nju.umr.ui.component.button.ConfirmModButton;
import edu.nju.umr.ui.component.button.DelButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.component.button.SearchButton;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;

public class StockDividePanel extends PPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3564861686953328781L;
	private TextField searchField;
	private TextField idField;
	private TextField rowField;
	private TextField placeField;
	private UMRComboBox<String> partCombo;
	private JFrame frame;
	private Table table;
	private DefaultTableModel model;
	private StockDivideLSer logicSer;
	private ArrayList<ShelfVO> shelfList;
	private String orgId;
	private static final int y=25;
	/**
	 * Create the panel.
	 */
	public StockDividePanel(JFrame fr,String orgId,String name) {
		setLayout(null);
		frame=fr;
		try {
			logicSer = new StockDivideLogic();
		} catch (RemoteException e1) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
		this.orgId = orgId;
		
		TitleLabel divideLabel = new TitleLabel("库存分区");
		add(divideLabel);
		
		searchField = new TextField();
		searchField.setBounds(233, y+67, 542, 24);
		add(searchField);
		searchField.setColumns(10);
		
		
		Button searchButton = new SearchButton();
		searchButton.setBounds(827, y+66, 100, 30);
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
		
		UMRLabel idLabel = new UMRLabel("编号");
		idLabel.setFont(Utils.COMBO_FONT);
		idLabel.setBounds(206, y+500, 54, 24);
		add(idLabel);
		
		idField = new TextField();
		idField.setEditable(false);
		idField.setBounds(253, y+500, 98, 22);
		add(idField);
		idField.setColumns(10);
		
		UMRLabel rowLabel = new UMRLabel("排数");
		rowLabel.setFont(Utils.COMBO_FONT);
		rowLabel.setBounds(370, y+500, 54, 24);
		add(rowLabel);
		
		rowField = new TextField();
		rowField.setBounds(416, y+500, 98, 22);
		add(rowField);
		rowField.setEditable(false);
		rowField.setColumns(10);
		
		UMRLabel placeLabel = new UMRLabel("每排位数");
		placeLabel.setFont(Utils.COMBO_FONT);
		placeLabel.setBounds(541, y+500, 71, 24);
		add(placeLabel);
		
		placeField = new TextField();
		placeField.setBounds(617, y+500, 98, 22);
		add(placeField);
		placeField.setEditable(false);
		placeField.setColumns(10);
		
		UMRLabel partLabel = new UMRLabel("所在区");
		partLabel.setFont(Utils.COMBO_FONT);
		partLabel.setBounds(742, y+500, 54, 24);
		add(partLabel);
		
		partCombo = new UMRComboBox<String>();
		partCombo.setBounds(803, y+500, 98, 22);
		partCombo.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		partCombo.setModel(new DefaultComboBoxModel<String>(new String[]{"航运区","铁运区","汽运区","机动区"}));
		add(partCombo);
		partCombo.setEnabled(false);
		
		Button addButton = new AddButton();
		addButton.setBounds(332, y+541, 100, 30);
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
		
		Button deleteButton = new DelButton();
		deleteButton.setBounds(455, y+541, 100, 30);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int n = JOptionPane.showConfirmDialog(frame, "确认删除吗?", "确认删除框", JOptionPane.YES_NO_OPTION);  
		        if (n == JOptionPane.YES_OPTION) {  
		        	Result result = logicSer.deleteShelf(shelfList.get(table.getSelectedRow()).getId(),name);
		        	fresh(result);
		        }
			}
		});
		add(deleteButton);
		
		Button confirmButton = new ConfirmModButton();
		confirmButton.setBounds(578, y+541,100, 30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					ShelfVO shelf = new ShelfVO(idField.getText(), Integer.parseInt(rowField.getText()), Integer.parseInt(placeField.getText()), EnumTransFactory.getPart((String)partCombo.getSelectedItem()));
					if(table.getSelectedRow() >= shelfList.size()){				
						Result result = logicSer.addShelf(shelf,name,orgId);
						fresh(result);
					} else {
						Result result = logicSer.reviseShelf(shelf,name,orgId);
						fresh(result);
					}
				}
			}
		});
		add(confirmButton);
		
		Button cancelButton = new CanModButton();
		cancelButton.setBounds(701, y+541, 100,30);
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
		
		Button exitButton = new ExitButton();
		exitButton.setBounds(881, y+541, 100,30);
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
				if(e.getValueIsAdjusting()==false){
					if(table.getSelectedRow() >= 0){
						rowField.setEditable(true);
						placeField.setEditable(true);
						partCombo.setEnabled(true);
					}
					if((table.getSelectedRow() < shelfList.size())&&(table.getSelectedRow() >= 0)){
						ShelfVO shelf = shelfList.get(table.getSelectedRow());
						idField.setText(shelf.getId());
						rowField.setText(shelf.getRow()+"");
						placeField.setText(shelf.getPlace()+"");
						partCombo.setSelectedIndex(shelf.getPart().ordinal());
					}
				}
			}
		});
		table.setBounds(233, y+109, 638, 371);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		UMRScrollPane scroll=new UMRScrollPane(table);
		scroll.setBounds(233, y+109, 638, 371);
		scroll.setVerticalScrollBarPolicy(UMRScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"架号","所属区","排数","每排位数"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
		
		getAll();
	}
	private void tableDisplay(){
		rowField.setText("");
		placeField.setText("");
		idField.setText("");
		partCombo.setSelectedIndex(0);
		rowField.setEditable(false);
		placeField.setEditable(false);
		partCombo.setEnabled(false);
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
