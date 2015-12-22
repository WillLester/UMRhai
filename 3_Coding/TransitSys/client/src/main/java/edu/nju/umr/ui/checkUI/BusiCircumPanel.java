package edu.nju.umr.ui.checkUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.checkLogic.BusiCircumLogic;
import edu.nju.umr.logicService.checkLogicSer.BusiCircumLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.component.*;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.BusiCircumVO;
import edu.nju.umr.vo.ResultMessage;
/*
 * yyy
 * 20151029
 * 经营情况表
 */
public class BusiCircumPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Table statementTable;
	private DefaultTableModel model;
	private ArrayList<BusiCircumVO> orderList;
	private BusiCircumLSer serv;
	/**
	 * Create the panel.
	 */
	public BusiCircumPanel(JFrame fr) {
        setLayout(null);
        frame=fr;
		serv = new BusiCircumLogic();
//        serv = new BusiCircumPanelStub();
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		
		JLabel start = new JLabel("开始日期");
		start.setBounds(Constants.TABLE_X, Constants.TABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(start);
		
		DatePanel startDate=new DatePanel();
		startDate.setBounds(Constants.TABLE_X+Constants.LABEL_WIDTH, Constants.TABLE_Y+4, 267, 21);
		add(startDate);
		
		JLabel end = new JLabel("结束日期");
		end.setBounds(Constants.TABLE_X, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(end);
		
		DatePanel endDate=new DatePanel();
		endDate.setBounds(Constants.TABLE_X+Constants.LABEL_WIDTH, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+4, 267, 21);
		add(endDate);
		
		Button exportButton = new OutputButton();
		exportButton.setBounds(Constants.PANEL_WIDTH/10*8, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+4, 100, 30);
		exportButton.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			export();
		}});
		add(exportButton);
		
		Button confirm = new ConfirmButton();
		confirm.setBounds(Constants.PANEL_WIDTH/10*7, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+4,100, 30);
		confirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				getOrders(startDate.getCalendar(),endDate.getCalendar());
			}
		});
		add(confirm);
		
		JLabel statementLabel = new JLabel("经营情况表");
		statementLabel.setFont(new Font("华文新魏",Font.PLAIN,15));
		statementLabel.setBounds(Constants.TABLE_X, Constants.TABLE_Y+Constants.LABEL_HEIGHT_S*2+10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(statementLabel);
		
		JLabel nameLabel = new JLabel("经营情况表");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		Button button = new ExitButton();
		button.setBounds(Constants.PANEL_WIDTH/10*8, this.getHeight()/10*9, 100,30);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(button);
		
		tableInit();

	}
	private void tableInit(){
		statementTable = new Table(new DefaultTableModel());
		model=(DefaultTableModel)statementTable.getModel();
		statementTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		statementTable.setBounds(Constants.TABLE_X, Constants.LABEL_Y*3, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		statementTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		statementTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(statementTable);
		scroll.setBounds(Constants.TABLE_X, Constants.LABEL_Y*3, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"单据种类","日期","金额","缘由"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	@SuppressWarnings("unchecked")
	private void getOrders(Calendar start,Calendar end){
		if(start.after(end))
		{
			new HintFrame("时间有误！",frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		ResultMessage message=serv.getBusiCircum(start, end);
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		orderList=(ArrayList<BusiCircumVO>)message.getMessage();
		displayOrders();
	}
	private void displayOrders(){
		model.setRowCount(0);
		for(int i=0;i<orderList.size();i++)
		{
			BusiCircumVO temp=orderList.get(i);
			String kind="付款单";
			if(temp.getKind()==1)kind="入款单";
			Calendar time=temp.getDate();
			String timeString=time.get(Calendar.YEAR)+"年"+(time.get(Calendar.MONTH)+1)+"月"+time.get(Calendar.DATE)+"日";
			String reason=null;
			if(temp.getRemark() == null){
				reason="运费收入";
			}
			else 
				switch(temp.getRemark()){
				case RENT:reason="租金";break;
				case FREIGHT:reason="运费";break;
				case WAGE:reason="工资";break;
				case BONUS:reason="奖励";break;
				}
			String[] data=new String[]{kind,timeString,temp.getAmount().toString(),reason};
			model.addRow(data);
		}
	}
	private void export(){
		JFileChooser chooser = new javax.swing.JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("表格","xls","xlsx");
		chooser.setFileFilter(filter);
		chooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY); 
		int returnVal = chooser.showSaveDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			 File file = chooser.getSelectedFile();
			 if (file.exists()) {
			 int copy = JOptionPane.showConfirmDialog(null,"是否要覆盖当前文件？", "保存", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			     if (copy == JOptionPane.YES_OPTION){
			     chooser.approveSelection();
			     }
			 }
			 else
			 chooser.approveSelection();
			 Result result= serv.outputExcel(chooser.getSelectedFile().getName(), chooser.getSelectedFile().getPath());
			 DoHint.hint(result, frame);
		}
	}

}
