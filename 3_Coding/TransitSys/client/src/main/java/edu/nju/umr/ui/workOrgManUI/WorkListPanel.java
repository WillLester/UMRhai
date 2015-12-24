package edu.nju.umr.ui.workOrgManUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.workOrgManLogic.WorkManLogic;
import edu.nju.umr.logicService.workOrgManLogicSer.WorkManLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.ELabel;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.button.AddButton;
import edu.nju.umr.ui.component.button.AllButton;
import edu.nju.umr.ui.component.button.CanModButton;
import edu.nju.umr.ui.component.button.ConfirmModButton;
import edu.nju.umr.ui.component.button.DelButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.component.button.SearchButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Hints;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WorkVO;

public class WorkListPanel extends PPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6812540125291862768L;
	private TextField textFieldSearch;
	private TextField textFieldName;
	private TextField textFieldMobile;
	private JComboBox<String> orgCombo;
	private JComboBox<String> juriCombo;
	private ArrayList<WorkVO> workList;
	private Button delete;
	private Button modify;
	private Button cancelMod;
	private FunctionFrame frame;
	private Table table;
	private DefaultTableModel model;
	private WorkManLSer logicSer;
	/**
	 * Create the panel.
	 */
	public WorkListPanel(FunctionFrame fr,String name) {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		frame=fr;
		logicSer = new WorkManLogic();
		workList = new ArrayList<WorkVO>();
		
		JLabel nameLabel = new JLabel("人员信息列表");
		nameLabel.setFont(new Font("微软雅黑",Font.PLAIN ,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH+20, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		textFieldSearch = new TextField();
		textFieldSearch.setBounds(Constants.TABLE_X,Constants.TABLE_Y+20, 600, 21);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		Button search = new SearchButton();
		search.setBounds(textFieldSearch.getX()+600+30, textFieldSearch.getY()-5, 100, 30);
		search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(textFieldSearch.getText().equals("")){
					DoHint.hint(Hints.KEYWORD_NULL, fr);
				}  else {
					search();
				}
			}
		});
		add(search);

		Button all = new AllButton();
		all.setBounds(textFieldSearch.getX()+700+60, textFieldSearch.getY()-5, 100, 30);
		all.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				getAll();
			}
		});
		add(all);
		
		ELabel workName = new ELabel("姓名");
		workName.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20+Constants.TABLE_HEIGHT*4+20,50,24);
		add(workName);
		
		textFieldName = new TextField();
		textFieldName.setBounds(workName.getX()+workName.getWidth(), workName.getY(),150, 24);
		textFieldName.setEnabled(false);
		add(textFieldName);
		
		ELabel type = new ELabel("所属机构");
		type.setBounds(380, workName.getY(),60,24);
		add(type);
		
		orgCombo = new JComboBox<String>();
		orgCombo.setBounds(type.getWidth()+type.getX(), type.getY(), 150, 21);
		ResultMessage message = logicSer.orgList();
		if(message.getReInfo().equals(Result.SUCCESS)){
			String orgs[] = (String[]) message.getMessage();
			orgCombo.setModel(new DefaultComboBoxModel<String>(orgs));
		}
		orgCombo.setEnabled(false);
		add(orgCombo);
		
		ELabel mobile = new ELabel("手机");
		mobile.setBounds(workName.getX(), workName.getY()+workName.getHeight()+20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(mobile);
		
		textFieldMobile = new TextField();
		textFieldMobile.setBounds(textFieldName.getX(), mobile.getY(), 150, 24);
		textFieldMobile.setEnabled(false);
		add(textFieldMobile);
		
		ELabel position = new ELabel("职位");
		position.setBounds(type.getX(), type.getY()+type.getHeight()+20,60,24);
		add(position);
		
		juriCombo = new JComboBox<String>();
		juriCombo.setBounds(orgCombo.getX(), position.getY()+3, 150, 21);
		String[] juris = {"快递员","营业厅业务员","中转中心业务员","仓库管理员","高级财务人员","普通财务人员","总经理","管理员"};
		juriCombo.setModel(new DefaultComboBoxModel<String>(juris));
		juriCombo.setEnabled(false);
		add(juriCombo);
		
		Button add = new AddButton();
		add.setBounds(Constants.TABLE_X, textFieldMobile.getY()+textFieldMobile.getHeight()+30, 100, 30);
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				model.setRowCount(workList.size()+1);
				table.getSelectionModel().setSelectionInterval(model.getRowCount()-1, model.getRowCount()-1);
			}
		});
		add(add);
		
		delete = new DelButton();
		delete.setBounds(add.getX()+add.getWidth()+50, add.getY(), 100, 30);
		delete.setEnabled(false);
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				int n = JOptionPane.showConfirmDialog(frame, "确认删除吗?", "确认删除框", JOptionPane.YES_NO_OPTION);  
		        if (n == JOptionPane.YES_OPTION)
		        {  
		        	Result result = logicSer.deleteWork(table.getSelectedRow(),name);
		        	DoHint.hint(result, frame);
		        	if(result.equals(Result.SUCCESS))
		        	{
		        		fresh();
					}
		        }
			}
		});
		add(delete);
		
		modify = new ConfirmModButton();
		modify.setBounds(delete.getX()+delete.getWidth()+50, add.getY(), 100, 30);
		modify.setEnabled(false);
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(table.getSelectedRow() >= workList.size()){
					Result result = logicSer.addWork(createVO(),name);
					DoHint.hint(result, frame);
					if(result.equals(Result.SUCCESS)){
						fresh();
					}
				} else {
					Result result = logicSer.reviseWork(createVO(),table.getSelectedRow(),name);
					DoHint.hint(result, frame);
					if(result.equals(Result.SUCCESS)){
						fresh();
					}
				}
			}
		});
		add(modify);
		
		cancelMod = new CanModButton();
		cancelMod.setBounds(modify.getX()+modify.getWidth()+50, add.getY(), 100, 30);
		cancelMod.setEnabled(false);
		cancelMod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				WorkVO work = workList.get(table.getSelectedRow());
				textFieldName.setText(work.getName());
				textFieldMobile.setText(work.getMobile());
				juriCombo.setSelectedItem(EnumTransFactory.checkJuri(work.getJuri()));
				orgCombo.setSelectedItem(work.getOrg());
			}
		});
		add(cancelMod);
		
		Button out = new ExitButton();
		out.setBounds(cancelMod.getX()+cancelMod.getWidth()+50+cancelMod.getWidth()+50, add.getY(), 100, 30);
		out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(out);
		
		tableInit();
		getAll();
		
	}
	@SuppressWarnings("unchecked")
	public WorkListPanel(FunctionFrame fr,String org,String name) {
		// TODO 自动生成的构造函数存根
		this(fr,name);
		ResultMessage message = logicSer.searchWork(org);
		if(message.getReInfo().equals(Result.SUCCESS)){
			workList = (ArrayList<WorkVO>) message.getMessage();
			displayTable();
		} else {
			DoHint.hint("未能获得该机构人员！", fr);
		}
	}
	private void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false){
					if(table.getSelectedRow() >= 0){
						textFieldName.setEnabled(true);
						textFieldMobile.setEnabled(true);
						orgCombo.setEnabled(true);
						delete.setEnabled(true);
						modify.setEnabled(true);
						cancelMod.setEnabled(true);
						if(table.getSelectedRow() >= workList.size()){
							textFieldMobile.setText("");
							textFieldName.setText("");
							orgCombo.setSelectedIndex(0);
							juriCombo.setSelectedIndex(0);
						} else {
							WorkVO work = workList.get(table.getSelectedRow());
							textFieldName.setText(work.getName());
							textFieldMobile.setText(work.getMobile());
							orgCombo.setSelectedItem(work.getOrg());
							juriCombo.setSelectedItem(EnumTransFactory.checkJuri(work.getJuri()));
							if(work.getJuri().equals(Jurisdiction.ADMIN)){
								delete.setEnabled(false);
							}
						}
					} else {
						textFieldName.setEnabled(false);
						textFieldMobile.setEnabled(false);
						orgCombo.setEnabled(false);
						delete.setEnabled(false);
						modify.setEnabled(false);
						cancelMod.setEnabled(false);
					}
				}
			}
		});
		table.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"姓名","手机号","职务","机构"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	private void displayTable(){
		model.setRowCount(0);
		for(WorkVO work:workList){
			String[] info = new String[4];
			info[0] = work.getName();
			info[1] = work.getMobile();
			info[2] = EnumTransFactory.checkJuri(work.getJuri());
			info[3] = work.getOrg();
			model.addRow(info);
		}
	}
	private WorkVO createVO(){
		WorkVO vo = new WorkVO(textFieldName.getText(), textFieldMobile.getText(), (String)orgCombo.getSelectedItem(), EnumTransFactory.getJuri((String)juriCombo.getSelectedItem()));
		return vo;
	}
	@SuppressWarnings("unchecked")
	private void getAll(){
		ResultMessage message = logicSer.searchWork(null);
		if(message.getReInfo().equals(Result.SUCCESS)){
			workList = (ArrayList<WorkVO>) message.getMessage();
			displayTable();
		} else {
			DoHint.hint(message.getReInfo(), frame);
		}
	}
	@SuppressWarnings("unchecked")
	private void search(){
		ResultMessage message = logicSer.searchWork(textFieldSearch.getText());
		if(message.getReInfo().equals(Result.SUCCESS)){
			workList = (ArrayList<WorkVO>) message.getMessage();
			displayTable();
		} else {
			DoHint.hint(message.getReInfo(), frame);
		}
	}
	private void fresh(){
		if(textFieldSearch.getText().equals("")){
			getAll();
		} else {
			search();
		}
	}
}
