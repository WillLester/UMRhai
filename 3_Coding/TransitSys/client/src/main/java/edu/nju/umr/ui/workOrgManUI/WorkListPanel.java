package edu.nju.umr.ui.workOrgManUI;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.workOrgManLogic.WorkManLogic;
import edu.nju.umr.logicService.workOrgManLogicSer.WorkManLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.InfoFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Hints;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WorkVO;

public class WorkListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6812540125291862768L;
	private JTextField textFieldSearch;
	private JTable listTable;
	private JTextField textFieldName;
	private JTextField textFieldMobile;
	private JTextField textFieldWage;
	private JTextField textFieldWageNum;
	private JTextField textFieldWageCom;
	private JComboBox<String> orgCombo;
	private JComboBox<String> juriCombo;
	private ArrayList<WorkVO> workList;
	private JFrame frame;
	private Table table;
	private DefaultTableModel model;
	private WorkManLSer logicSer;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public WorkListPanel(JFrame fr) {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		frame=fr;
		logicSer = new WorkManLogic();
		workList = new ArrayList<WorkVO>();
		
		JLabel nameLabel = new JLabel("人员信息列表");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN ,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH+20, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setText("请输入关键字");
		textFieldSearch.setBounds(Constants.TABLE_X,Constants.TABLE_Y, 600, 21);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton search = new JButton("搜索");
		search.setBounds(textFieldSearch.getX()+600+20, textFieldSearch.getY(), 90, 21);
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

		JButton all = new JButton("显示全部");
		all.setBounds(textFieldSearch.getX()+700+20, textFieldSearch.getY(), 90, 21);
		all.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				getAll();
			}
		});
		add(all);
		
		JLabel workName = new JLabel("姓名");
		workName.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20+Constants.TABLE_HEIGHT*4+20,50,24);
		add(workName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(workName.getX()+workName.getWidth(), workName.getY(),150, 24);
		textFieldName.setEnabled(false);
		add(textFieldName);
		
		JLabel wage = new JLabel("薪水策略");
		wage.setBounds(700, textFieldSearch.getY()+textFieldSearch.getHeight()+20+Constants.TABLE_HEIGHT*4+20,60,24);
		add(wage);
		
		textFieldWage = new JTextField();
		textFieldWage.setBounds(760, workName.getY(),150, 24);
		textFieldWage.setEnabled(false);
		add(textFieldWage);
		
		JLabel type = new JLabel("所属机构");
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
		
		JLabel mobile = new JLabel("手机");
		mobile.setBounds(workName.getX(), workName.getY()+workName.getHeight()+20, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(mobile);
		
		textFieldMobile = new JTextField();
		textFieldMobile.setBounds(textFieldName.getX(), mobile.getY(), 150, 24);
		textFieldMobile.setEnabled(false);
		add(textFieldMobile);
		
		JLabel wageNum1 = new JLabel("薪水数额");
		wageNum1.setBounds(700,mobile.getY(),60,24);
		add(wageNum1);
		
		textFieldWageNum = new JTextField();
		textFieldWageNum.setBounds(760,mobile.getY(),80, 24);
		textFieldWageNum.setEnabled(false);
		add(textFieldWageNum);
		
		JLabel wageNum2 = new JLabel("提成");
		wageNum2.setBounds(840,mobile.getY(),60,24);
		add(wageNum2);
		
		textFieldWageCom = new JTextField();
		textFieldWageCom.setBounds(870,mobile.getY(),40, 24);
		textFieldWageCom.setEnabled(false);
		add(textFieldWageCom);
		
		JLabel position = new JLabel("职位");
		position.setBounds(type.getX(), type.getY()+type.getHeight()+20,60,24);
		add(position);
		
		juriCombo = new JComboBox<String>();
		juriCombo.setBounds(orgCombo.getX(), position.getY()+3, 150, 21);
		String[] juris = {"快递员","营业厅业务员","中转中心业务员","仓库管理员","高级财务人员","普通财务人员","总经理","管理员"};
		juriCombo.setModel(new DefaultComboBoxModel<String>(juris));
		juriCombo.setEnabled(false);
		add(juriCombo);
		
		JButton add = new JButton("新增");
		add.setBounds(listTable.getX(), textFieldMobile.getY()+textFieldMobile.getHeight()+30, 93, 23);
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				model.setRowCount(workList.size()+1);
				table.getSelectionModel().setSelectionInterval(model.getRowCount()-1, model.getRowCount()-1);
			}
		});
		add(add);
		
		JButton delete = new JButton("删除");
		delete.setBounds(add.getX()+add.getWidth()+50, add.getY(), 93, 23);
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				Result result = logicSer.deleteWork(table.getSelectedRow());
				if(result.equals(Result.SUCCESS)){
					fresh();
				} else {
					DoHint.hint(result, frame);
				}
			}
		});
		add(delete);
		
		JButton modify = new JButton("确认修改");
		modify.setBounds(delete.getX()+delete.getWidth()+50, add.getY(), 93, 23);
		modify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					if(table.getSelectedRow() >= workList.size()){
						Result result = logicSer.addWork(createVO());
						if(result.equals(Result.SUCCESS)){
							fresh();
						} else {
							DoHint.hint(result, frame);
						}
					} else {
						Result result = logicSer.reviseWork(createVO(),table.getSelectedRow());
						if(result.equals(Result.SUCCESS)){
							fresh();
						} else {
							DoHint.hint(result, frame);
						}
					}
				}
			}
		});
		add(modify);
		
		JButton confirmMod = new JButton("取消修改");
		confirmMod.setBounds(modify.getX()+modify.getWidth()+50, add.getY(), 93, 23);
		add(confirmMod);
		
		JButton wageMan = new JButton("薪水制定");
		wageMan.setBounds(confirmMod.getX()+confirmMod.getWidth()+50, add.getY(), 93, 23);
		wageMan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				InfoFrame inFr = new InfoFrame("薪水制定");
				inFr.setContentPane(new WageDraftPanel(inFr));
			}
		});
		add(wageMan);
		
		JButton out = new JButton("退出");
		out.setBounds(confirmMod.getX()+confirmMod.getWidth()+50+confirmMod.getWidth()+50, add.getY(), 93, 23);
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
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"名称","余额"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	private void displayTable(){
		
	}
	private WorkVO createVO(){
		return null;
	}
	private boolean isLegal(){
		return true;
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
