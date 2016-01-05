package edu.nju.umr.ui.checkUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
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
import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.UMRScrollPane;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;
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
	private UMRLabel listLabel;
	private JFrame frame;
	private IncomeListLSer serv;
	private UMRComboBox<Object> cbHall;
	private DatePanel date;
	private static final int y=25;
	private static final Color color = new Color(57, 152,214);
	
	/**
	 * Create the panel.用以查看收款记录
	 */
	public IncomeListPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		//设置panel大小
		this.setSize(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT);
		
		date=new DatePanel();
		date.setBounds(Constants.TABLE_X+120, y+Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+5, 267, 21);
		date.setEnabled(false);
		add(date);
		
		JCheckBox checkDate = new JCheckBox("日期");
		checkDate.setBackground(Color.WHITE);
		checkDate.setForeground(color);
		checkDate.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		checkDate.setBounds(Constants.TABLE_X+120, y+Constants.TABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
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
		checkHall.setBackground(Color.WHITE);
		checkHall.setForeground(color);
		checkHall.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		checkHall.setBounds(Constants.TABLE_X+400, y+Constants.TABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
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
		
		
		UMRLabel hallLabel = new UMRLabel("营业厅");
		hallLabel.setForeground(color);
		hallLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		hallLabel.setBounds(Constants.TABLE_X+400, y+Constants.TABLE_Y+Constants.LABEL_HEIGHT_S, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(hallLabel);
		
		cbHall=new UMRComboBox<Object>();
		cbHall.setBounds(hallLabel.getX()+hallLabel.getWidth()/2,y+Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+5, Constants.LABEL_WIDTH-10, Constants.LABEL_HEIGHT_S-10);
		cbHall.setEnabled(false);
		add(cbHall);

		Button cancel = new CanButton();
		cancel.setBounds(this.getWidth()/10*8, y+Constants.TABLE_Y+Constants.LABEL_HEIGHT_S*3-5,100,30);
//		add(cancel);
		
		Button confirm = new ConfirmButton();
		confirm.setBounds(770, y+Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+5,100,30);
		confirm.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			getIncomeList();
		}});
		add(confirm);
		
		TitleLabel nameLabel = new TitleLabel("收款记录");
//		hallLabel.setForeground(Color.white);
		add(nameLabel);
		
		
		listLabel = new UMRLabel("收款记录");
		listLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
		listLabel.setBounds(120+Constants.TABLE_X, y+Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+5+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(listLabel);
		tableInit();
		
		
		
		Button out = new ExitButton();
		out.setBounds(770, 60+IncomeTable.getY()+IncomeTable.getHeight()+25, 100,30);
		out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(out);
		
		try {
			serv = new IncomeListLogic();
		} catch (RemoteException e1) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
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
		IncomeTable.setBounds(233, 101+y, 637, 335);
		IncomeTable.setBounds(Constants.TABLE_X, listLabel.getY()+Constants.LABEL_HEIGHT_S+5, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*4);
		IncomeTable.getTableHeader().setReorderingAllowed(false);
		UMRScrollPane scroll=new UMRScrollPane(IncomeTable);
		scroll.setBounds(233, 181+y, 637, 335);
		scroll.setVerticalScrollBarPolicy(UMRScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"时间","金额","快递员","合计"};
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
		BigDecimal total=new BigDecimal(0);
		for(int i=0;i<incomeList.size();i++){
			IncomeVO temp=incomeList.get(i);
			String time = DateFormat.TIME.format(temp.getDate().getTime());
			total=total.add(temp.getCost());
			String []data=new String[]{time,temp.getCost().toString(),temp.getCourier(),total.toString()};
			model.addRow(data);
		}
	}
}
