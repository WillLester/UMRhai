package edu.nju.umr.ui.workOrgManUI;

import javax.swing.JPanel;

import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.Table;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class WorkWageListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7764066933710729156L;
	private JTable listTable;
	private JTextField textFieldSearch;
	private JTextField textFieldwt;
	private JTextField textFieldwc;
	private JTextField textFieldwi;
	private JTextField textFieldBound;
	private JTextField textFieldwm;
	private JFrame frame;
	private Table table;
	private DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public WorkWageListPanel(JFrame fr) {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		frame=fr;
		
		JLabel nameLabel = new JLabel("人员薪水信息列表");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN ,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH+60, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setText("请输入关键字");
		textFieldSearch.setBounds(Constants.TABLE_X,Constants.TABLE_Y, 300, 21);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton search = new JButton("搜索");
		search.setBounds(textFieldSearch.getX()+textFieldSearch.getWidth()+20,textFieldSearch.getY(), 90, 21);
		add(search);
		
		JLabel wageType = new JLabel("计薪方式");
		wageType.setBounds(Constants.TABLE_X, textFieldSearch.getY()+textFieldSearch.getHeight()+20+ Constants.TABLE_HEIGHT*4+40, 54, 15);
		add(wageType);
		
		textFieldwt = new JTextField();
		textFieldwt.setBounds(wageType.getX()+wageType.getWidth()+10, wageType.getY(),90, 21);
		add(textFieldwt);
		textFieldwt.setColumns(10);
		
		JLabel wageMonth = new JLabel("月薪");
		wageMonth.setBounds(textFieldwt.getX()+textFieldwt.getWidth()+40, wageType.getY(), 54, 15);
		add(wageMonth);
		
		textFieldwm = new JTextField();
		textFieldwm.setBounds(wageMonth.getX()+wageMonth.getWidth()+10, wageMonth.getY(),90, 21);
		add(textFieldwm);
		textFieldwm.setColumns(10);
		
		JLabel wageCount = new JLabel("次薪");
		wageCount.setBounds(textFieldwm.getX()+textFieldwm.getWidth()+40, wageType.getY(), 54, 15);
		add(wageCount);
		
		textFieldwc = new JTextField();
		textFieldwc.setBounds(wageCount.getX()+wageCount.getWidth()+10, wageMonth.getY(),90, 21);
		add(textFieldwc);
		textFieldwc.setColumns(10);
		
		JLabel wageInit = new JLabel("基本工资");
		wageInit.setBounds(wageMonth.getX(), wageMonth.getY()+wageMonth.getHeight()+30, 54, 15);
		add(wageInit);
		
		
		
		textFieldwi = new JTextField();
		textFieldwi.setBounds(textFieldwm.getX(), wageInit.getY(),90, 21);
		add(textFieldwi);
		textFieldwi.setColumns(10);
		
		JLabel bound = new JLabel("提成份额");
		bound.setBounds(wageCount.getX(), wageInit.getY(), 54, 15);
		add(bound);
		
		textFieldBound = new JTextField();
		textFieldBound.setBounds(textFieldwc.getX(), wageInit.getY(), 90, 21);
		add(textFieldBound);
		textFieldBound.setColumns(10);
		
		
		
		JButton make = new JButton("制定薪水策略");
		make.setBounds(getWidth()-300, wageInit.getY(), 150, 23);
		make.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("制定薪水策略");
				ffr.setContentPane(new WageDraftPanel(ffr));
			}
		});
		add(make);
		
		JButton out = new JButton("退出");
		out.setBounds(make.getX(), make.getY()+make.getHeight()+30, 93, 23);
		out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(out);
		tableInit();
		
	}
	void tableInit(){
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
		String[] columnNames={"姓名","机构","职位"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}

}
