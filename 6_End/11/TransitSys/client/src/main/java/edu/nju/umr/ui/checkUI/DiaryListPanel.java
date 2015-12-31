package edu.nju.umr.ui.checkUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.checkLogic.DiaryLogic;
import edu.nju.umr.logicService.checkLogicSer.DiaryLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.DateTimePanel;
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
import edu.nju.umr.vo.DiaryVO;
import edu.nju.umr.vo.ResultMessage;
/*
 * yyy
 * 20151028
 * 查看日志记录panel
 */
public class DiaryListPanel extends PPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Table table;
	private DefaultTableModel model;
	private DiaryLSer serv;
	private ArrayList<DiaryVO> diaryList;
	private static final int y=20;
	/**
	 * Create the panel.
	 */
	public DiaryListPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		serv = new DiaryLogic();
		
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		
		
		UMRLabel start = new UMRLabel("开始日期");
		start.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		start.setBounds(Constants.TABLE_X, y+Constants.TABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(start);
		
		DateTimePanel startDate=new DateTimePanel();
		startDate.setBounds(Constants.TABLE_X+Constants.LABEL_WIDTH, y+Constants.TABLE_Y+4+3, 530, 21);
		add(startDate);
		
		UMRLabel end = new UMRLabel("结束日期");
		end.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		end.setBounds(Constants.TABLE_X, y+Constants.TABLE_Y+Constants.LABEL_HEIGHT_S, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(end);
		
		DateTimePanel endDate=new DateTimePanel();
		endDate.setBounds(Constants.TABLE_X+Constants.LABEL_WIDTH, y+Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+4+3, 530, 21);
		add(endDate);
		
		Button cancel = new CanButton();
		cancel.setBounds(Constants.PANEL_WIDTH/10*8+10, y+Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+4,100,30);
		cancel.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			startDate.setDate(Calendar.getInstance());
			endDate.setDate(Calendar.getInstance());
			model.setRowCount(0);
		}});
		add(cancel);
		
		Button confirm = new ConfirmButton();
		confirm.setBounds(Constants.PANEL_WIDTH/10*7+10, y+Constants.TABLE_Y+Constants.LABEL_HEIGHT_S+4,100, 30);
		confirm.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(startDate.getCalendar().after(endDate.getCalendar()))
			{
				new HintFrame("日期非法!",frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			}
			else
			{
				getDiaries(startDate.getCalendar(),endDate.getCalendar());
			}
		}});
		add(confirm);
		
//	    diaryTable = new JTable();
//		diaryTable.setBounds(Constants.TABLE_X, Constants.LABEL_Y*3, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
//		add(diaryTable);
		
		UMRLabel diaryLable = new UMRLabel("日志记录");
		diaryLable.setFont(new Font("微软雅黑",Font.PLAIN,15));
		diaryLable.setBounds(Constants.TABLE_X, y+Constants.TABLE_Y+Constants.LABEL_HEIGHT_S*2+10, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(diaryLable);
		
		TitleLabel nameLabel = new TitleLabel("日志记录");
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
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setBounds(Constants.TABLE_X, Constants.LABEL_Y*3, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		UMRScrollPane scroll=new UMRScrollPane(table);
		scroll.setBounds(Constants.TABLE_X, Constants.LABEL_Y*3, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		scroll.setVerticalScrollBarPolicy(UMRScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"操作人","操作","操作时间"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	@SuppressWarnings("unchecked")
	private void getDiaries(Calendar start,Calendar end){
		ResultMessage message=serv.seeDiary(start, end);
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		else
		{
			diaryList=(ArrayList<DiaryVO>)message.getMessage();
			displayDiaries();
		}
	}
	private void displayDiaries(){
		model.setRowCount(0);
		for(int i=0;i<diaryList.size();i++)
		{
			DiaryVO temp=diaryList.get(i);
			String [] data=new String[]{temp.getOperator(),temp.getOperation(),DateFormat.TIME.format(temp.getTime().getTime())};
			model.addRow(data);
		}
	}
}
