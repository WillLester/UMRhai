package edu.nju.umr.ui.checkUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logicService.checkLogicSer.IncomeListLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JScrollPane;

/*
 * yyy 
 * 20151028
 * 查看收款记录的panel
 */
public class IncomeListPanel extends JPanel {
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
	
	/**
	 * Create the panel.用以查看收款记录
	 */
	public IncomeListPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		//设置panel大小
		this.setSize(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT);
		
		JRadioButton radioButtonDate = new JRadioButton("日期");
//		JLabel radioButtonDate=new JLabel("日期");
		radioButtonDate.setBounds(Constants.TABLE_X+120, Constants.TABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(radioButtonDate);
		
		DatePanel date=new DatePanel();
		date.setBounds(Constants.TABLE_X+120, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+5, 267, 21);
		date.setEnabled(false);
		add(date);
		
		radioButtonDate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(date.isEnabled())
				{
					date.setEnabled(false);
				}
				else
				{
					date.setEnabled(true);
				}
			}
		});
		
		
//		JRadioButton radioButtonHall = new JRadioButton("按营业厅查看");
//		radioButtonHall.setBounds(Constants.TABLE_X+400, Constants.TABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
//		add(radioButtonHall);
		
		JLabel hallLabel = new JLabel("营业厅");
		hallLabel.setBounds(Constants.TABLE_X+400, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(hallLabel);
		
		cbHall=new JComboBox<Object>();
		cbHall.setBounds(hallLabel.getX()+hallLabel.getWidth()/2,Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+5, Constants.LABEL_WIDTH-10, Constants.LABEL_HEIGHT_S-10);
		add(cbHall);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(this.getWidth()/10*8, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S*3-5, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
//		add(cancel);
		
		JButton confirm = new JButton("确认");
		confirm.setBounds(cancel.getX()-Constants.BUTTON_WIDTH-40, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+5, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
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
//		add(listLabel);
		
		tableInit();
		
		
		
		JButton out = new JButton("退出");
		out.setBounds(500, IncomeTable.getY()+IncomeTable.getHeight()+50, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
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
		String [] hallString=new String[hallList.size()+1];
		hallString[0]="所有";
		for(int i=1;i<=hallList.size();i++)
		{
			hallString[i]=hallList.get(i-1).getName();
		}
		cbHall.setModel(new DefaultComboBoxModel(hallString));
		

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
		String[] columnNames={"时间","金额","快递员","合计"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	@SuppressWarnings("unchecked")
	private void getIncomeList(){
		Calendar date=null;
		String id=cbHall.getSelectedIndex()==0?null:hallList.get(cbHall.getSelectedIndex()-1).getName();
		ResultMessage message=serv.seeIncomeList(date, id);
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		incomeList=(ArrayList<IncomeVO>)message.getMessage();
		displayIncomes();
	}
	private void displayIncomes(){
		BigDecimal total= new BigDecimal(0);
		for(int i=0;i<incomeList.size();i++){
			IncomeVO temp=incomeList.get(i);
			total = total.add(temp.getCost());
			String time=temp.getDate().get(Calendar.YEAR)+"年"+(temp.getDate().get(Calendar.MONTH)+1)+"月"+temp.getDate().get(Calendar.DATE)+"日";
			String []data=new String[]{time,temp.getCost().toString(),temp.getCourier(),total.toString()};
			model.addRow(data);
		}
	}
}
