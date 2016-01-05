package edu.nju.umr.ui.workOrgManUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.workOrgManLogic.WageManLogic;
import edu.nju.umr.logicService.workOrgManLogicSer.WageManLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Wage;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.InfoFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.UMRScrollPane;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.component.button.SearchButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Hints;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WageVO;

public class WorkWageListPanel extends PPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7764066933710729156L;
	private TextField textFieldSearch;
	private TextField textFieldtype;
	private TextField textFieldwCount;
	private TextField textFieldwInit;
	private TextField textFieldBound;
	private TextField textFieldwMonth;
	private FunctionFrame frame;
	private Table table;
	private DefaultTableModel model;
	private WageManLSer logicSer;
	private ArrayList<WageVO> wageList;
	private String name;
	private static final int y=20;
	/**
	 * Create the panel.
	 */
	public WorkWageListPanel(FunctionFrame fr,String name) {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		frame=fr;
		this.name = name;
		try {
			logicSer = new WageManLogic();
		} catch (RemoteException e1) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
//		logicSer = new WorkWageListPanelStub();
		wageList = new ArrayList<WageVO>();
		
		JLabel nameLabel = new TitleLabel("薪水管理");
		add(nameLabel);
		
		textFieldSearch = new TextField();
		textFieldSearch.setBounds(Constants.TABLE_X,y+Constants.TABLE_Y+20, 600, 21);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		Button search = new SearchButton();
		search.setBounds(textFieldSearch.getX()+textFieldSearch.getWidth()+20+Constants.INTERVAL,textFieldSearch.getY()-5, 100, 30);
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(textFieldSearch.getText().equals("")){
					DoHint.hint(Hints.KEYWORD_NULL, fr);
				} else {
					search();
				}
			}
		});
		add(search);
		
		UMRLabel wageType = new UMRLabel("计薪方式");
		wageType.setMinFont();
		wageType.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20+ Constants.TABLE_HEIGHT*4+40, 70, 15);
		add(wageType);
		
		textFieldtype = new TextField();
		textFieldtype.setBounds(wageType.getX()+wageType.getWidth()+10, wageType.getY(),90, 21);
		add(textFieldtype);
		textFieldtype.setEnabled(false);
		textFieldtype.setColumns(10);
		
		UMRLabel wageMonth = new UMRLabel("月薪");
		wageMonth.setMinFont();
		wageMonth.setBounds(textFieldtype.getX()+textFieldtype.getWidth()+40, wageType.getY(), 54, 15);
		add(wageMonth);
		
		textFieldwMonth = new TextField();
		textFieldwMonth.setBounds(wageMonth.getX()+wageMonth.getWidth()+10, wageMonth.getY(),90, 21);
		add(textFieldwMonth);
		textFieldwMonth.setEnabled(false);
		textFieldwMonth.setColumns(10);
		
		UMRLabel wageCount = new UMRLabel("次薪");
		wageCount.setMinFont();
		wageCount.setBounds(textFieldwMonth.getX()+textFieldwMonth.getWidth()+40, wageType.getY(), 54, 15);
		add(wageCount);
		
		textFieldwCount = new TextField();
		textFieldwCount.setBounds(wageCount.getX()+wageCount.getWidth()+10, wageMonth.getY(),90, 21);
		add(textFieldwCount);
		textFieldwCount.setEnabled(false);
		textFieldwCount.setColumns(10);
		
		UMRLabel wageInit = new UMRLabel("基本工资");
		wageInit.setMinFont();
		wageInit.setBounds(wageMonth.getX(), wageMonth.getY()+wageMonth.getHeight()+30, 80, 15);
		add(wageInit);
		
		textFieldwInit = new TextField();
		textFieldwInit.setBounds(textFieldwMonth.getX(), wageInit.getY(),90, 21);
		add(textFieldwInit);
		textFieldwInit.setEnabled(false);
		textFieldwInit.setColumns(10);
		
		UMRLabel bound = new UMRLabel("提成份额");
		bound.setMinFont();
		bound.setBounds(wageCount.getX(), wageInit.getY(), 80, 15);
		add(bound);
		
		textFieldBound = new TextField();
		textFieldBound.setBounds(textFieldwCount.getX(), wageInit.getY(), 90, 21);
		add(textFieldBound);
		textFieldBound.setEnabled(false);
		textFieldBound.setColumns(10);
		
		
		
		Button make = new Button();
		make.setNewImages("buttonWage", "buttonWageSt", "buttonWageP");
		make.setBounds(getWidth()-300, wageInit.getY(), 100, 30);
		make.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				InfoFrame ffr=new InfoFrame("制定薪水策略");
				ffr.setContentPane(new WageDraftPanel(ffr,getSelf()));
				frame.sonFrames.add(ffr);
			}
		});
		add(make);
		
		Button out = new ExitButton();
		out.setBounds(make.getX(), make.getY()+make.getHeight()+30, 100, 30);
		out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(out);
		tableInit();
		getAll();
	}
	private void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false){
					if(table.getSelectedRowCount() == 1){
						WageVO wage = wageList.get(table.getSelectedRow());
						textFieldtype.setText(EnumTransFactory.checkWage(wage.getKind()));
						displayWage(wage);
					} else if(table.getSelectedRowCount() > 1){
						int[] selected = table.getSelectedRows();
						ArrayList<WageVO> temp = new ArrayList<WageVO>();
						for(int i = 0;i < selected.length;i++){
							WageVO vo = wageList.get(selected[i]);
							temp.add(vo);
						}
						boolean isSame = true;
						Wage kind = temp.get(0).getKind();
						for(int i = 1;i < temp.size();i++){
							if(temp.get(i).getKind() != kind){
								isSame = false;
								break;
							}
						}
						if(isSame){
							displayWage(temp.get(0));
						}
					}
				}
			}
		});
		table.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new UMRScrollPane(table);
		scroll.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"姓名","职务","薪水策略","金额","提成"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	private void displayTable(){
		model.setRowCount(0);
		for(WageVO wage:wageList){
			String[] info = new String[5];
			info[0] = wage.getName();
			info[1] = EnumTransFactory.checkJuri(wage.getJuri());
			info[2] = EnumTransFactory.checkWage(wage.getKind());
			info[3] = wage.getWage()+"";
			info[4] = wage.getCommission()+"";
			model.addRow(info);
		}
	}
	private void search(){
		ResultMessage message = logicSer.searchWorks(textFieldSearch.getText());
		executeMessage(message);
	}
	private void fresh(){
		if(textFieldSearch.getText().equals("")){
			getAll();
		} else {
			search();
		}
	}
	private void displayWage(WageVO vo){
		switch(vo.getKind()){
		case MONTH:textFieldwMonth.setText(vo.getWage()+"");
		textFieldwCount.setText("");
		textFieldwInit.setText("");
		textFieldBound.setText("");
		break;
		case TIME:textFieldwCount.setText(vo.getWage()+"");
		textFieldwMonth.setText("");
		textFieldwInit.setText("");
		textFieldBound.setText("");
		break;
		case COMMISSION:textFieldwInit.setText(vo.getWage()+"");
		textFieldBound.setText(vo.getCommission()+"");
		textFieldwMonth.setText("");
		textFieldwCount.setText("");
		break;
		}
	}
	private void getAll(){
		ResultMessage message = logicSer.searchWorks(null);
		executeMessage(message);
	}
	@SuppressWarnings("unchecked")
	private void executeMessage(ResultMessage message){
		if(message.getReInfo().equals(Result.SUCCESS)){
			wageList = (ArrayList<WageVO>) message.getMessage();
			displayTable();
		} else {
			DoHint.hint(message.getReInfo(), frame);
		}
	}
	
	Result setWage(Wage kind,int money,int commission){
		ArrayList<WageVO> temp = new ArrayList<WageVO>();
		int[] selected = table.getSelectedRows();
		for(int i = 0;i < selected.length;i++){
			WageVO wage = wageList.get(selected[i]);
			WageVO vo = new WageVO(wage.getName(), wage.getJuri(), kind, money, commission);
			temp.add(vo);
		}
		Result result = logicSer.setWage(temp, selected,name);
		if(result.equals(Result.SUCCESS)){
			fresh();
		} else {
			DoHint.hint(result, frame);
		}
		return result;
	}
	
	private WorkWageListPanel getSelf(){
		return this;
	}
}
