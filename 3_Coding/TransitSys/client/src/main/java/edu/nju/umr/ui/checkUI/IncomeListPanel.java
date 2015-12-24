package edu.nju.umr.ui.checkUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.checkLogic.IncomeListLogic;
import edu.nju.umr.logicService.checkLogicSer.IncomeListLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

/*
 * yyy 
 * 20151028
 * 查看收款记录的panel
 */
public class IncomeListPanel extends PPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Table IncomeTable;
	private DefaultTableModel model;
	private ArrayList<IncomeVO> incomeList;
	private ArrayList<OrgVO> hallList;
	private JLabel listLabel;
	private JFrame frame;
	private IncomeListLSer serv;
	private JComboBox<Object> cbHall;
	private DatePanel date;
	
	/**
	 * Create the panel.用以查看收款记录
	 */
	public IncomeListPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		serv = new IncomeListLogic();
		
		//设置panel大小
		this.setSize(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT);
		
		date=new DatePanel();
		date.setBounds(Constants.TABLE_X+120, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+5, 267, 21);
		date.setEnabled(false);
		add(date);
		
		JCheckBox checkDate = new JCheckBox("日期");
		checkDate.setBounds(Constants.TABLE_X+120, Constants.TABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(checkDate);
		
		checkDate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(date.isEnabled()){
					date.setEnabled(false);
				} else {
					date.setEnabled(true);
				}
			}
		});
		
		JCheckBox checkHall = new JCheckBox("营业厅");
		checkHall.setBounds(Constants.TABLE_X+400, Constants.TABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(checkHall);
		
		checkHall.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(cbHall.isEnabled()){
					cbHall.setEnabled(false);
				} else {
					cbHall.setEnabled(true);
				}
			}
		});
		
		JLabel hallLabel = new JLabel("营业厅");
		hallLabel.setBounds(Constants.TABLE_X+400, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(hallLabel);
		
		cbHall=new JComboBox<Object>();
		cbHall.setBounds(hallLabel.getX()+hallLabel.getWidth()/2,Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+5, Constants.LABEL_WIDTH-10, Constants.LABEL_HEIGHT_S-10);
		cbHall.setEnabled(false);
		add(cbHall);

		Button cancel = new CanButton();
		cancel.setBounds(this.getWidth()/10*8, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S*3-5,100,30);
//		add(cancel);
		
		Button confirm = new ConfirmButton();
		confirm.setBounds(cancel.getX()-Constants.BUTTON_WIDTH-40, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+5,100,30);
		confirm.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			getIncomeList();
		}});
		add(confirm);
		
		JLabel nameLabel = new JLabel("收款记录");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		
		listLabel = new JLabel("收款记录");
		listLabel.setFont(new Font("华文新魏",Font.PLAIN,15));
		listLabel.setBounds(Constants.TABLE_X, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S*4+10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		
		tableInit();
		
		
		
		Button out = new ExitButton();
		out.setBounds(500, IncomeTable.getY()+IncomeTable.getHeight()+20, 100,30);
		out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(out);
		
		
		dataInit();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void dataInit(){
		ResultMessage message=serv.getHall();
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		hallList=(ArrayList<OrgVO>)message.getMessage();
		String [] hallString=new String[hallList.size()];
		for(int i = 0;i < hallList.size();i++){
			hallString[i] = hallList.get(i).getName();
		}
		cbHall.setModel(new DefaultComboBoxModel(hallString));
		cbHall.setSelectedIndex(0);
	}
	private void tableInit(){
		IncomeTable = new Table(new DefaultTableModel());
		model=(DefaultTableModel)IncomeTable.getModel();
		IncomeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		IncomeTable.setBounds(233, 101, 637, 335);
		IncomeTable.setBounds(Constants.TABLE_X, listLabel.getY()+Constants.LABEL_HEIGHT_S+5, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		IncomeTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(IncomeTable);
		scroll.setBounds(233, 181, 637, 335);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"时间","金额","快递员"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	@SuppressWarnings("unchecked")
	private void getIncomeList(){
		Calendar date = null;
		String id = null;
		ResultMessage message;
		if(this.date.isEnabled()){
			date = this.date.getCalendar();
		} else if(!cbHall.isEnabled()){
			DoHint.hint("请选择日期或营业厅！", frame);
			return;
		}
		if(cbHall.isEnabled()){
			id = hallList.get(cbHall.getSelectedIndex()).getId();
		}
		message = serv.seeIncomeList(date, id);
		Result result = message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		incomeList=(ArrayList<IncomeVO>)message.getMessage();
		displayIncomes();
	}
	private void displayIncomes(){
		model.setRowCount(0);
		for(int i=0;i<incomeList.size();i++){
			IncomeVO temp=incomeList.get(i);
			String time = DateFormat.TIME.format(temp.getDate().getTime());
			String []data=new String[]{time,temp.getCost().toString(),temp.getCourier()};
			model.addRow(data);
		}
	}
}
