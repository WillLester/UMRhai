package edu.nju.umr.ui.checkUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.vo.CostBeneVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.logic.checkLogic.CostBeneLogic;
import edu.nju.umr.logicService.checkLogicSer.CostBeneLSer;
import edu.nju.umr.po.enums.Result;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/*
 * yyy
 * 20151029
 * 成本收益表
 */
public class CostBenePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Table table;
	private DefaultTableModel model;
	private CostBeneLSer serv;
	/**
	 * Create the panel.
	 */
	public CostBenePanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		serv = new CostBeneLogic();
		this.setSize(1104,621);
		
		JLabel nameLabel = new JLabel("成本收益");
		nameLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
//		nameLabel.setBounds(this.getWidth()/2-this.getWidth()/14, this.getHeight()/20, this.getWidth()/7, this.getHeight()/15);
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
//		collectTable = new JTable();
//		collectTable.setBounds(this.getWidth()/10, this.getHeight()/9, this.getWidth()/10*8, this.getHeight()/9*6);
//		add(collectTable);
		
//		JButton export = new JButton("导出");
//		export.setBounds(550-Constants.BUTTON_WIDTH/2, this.getHeight()/10*8, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
//		
//		add(export);
		
		JButton out = new JButton("退出");
		out.setBounds(this.getWidth()/10*9-Constants.BUTTON_WIDTH, this.getHeight()/10*8, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(out);
		tableInit();
		showData();

	}
	void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setBounds(this.getWidth()/10, this.getHeight()/9, this.getWidth()/10*8, this.getHeight()/9*6);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(this.getWidth()/10, this.getHeight()/9, this.getWidth()/10*8, this.getHeight()/9*6);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"收入","支出","利润"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	private void showData(){
		ResultMessage message=serv.getCostBene();
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		CostBeneVO temp=(CostBeneVO)message.getMessage();
		String[] data=new String[]{Double.toString(temp.getIncome()),Double.toString(temp.getPayment()),Double.toString(temp.getBenefit())};
		model.setRowCount(0);
		model.addRow(data);
	}
//	public static void main(String[] args)
//	{
//		JFrame frame=new JFrame();
//		frame.setContentPane(new CostBenePanel(frame));
//		frame.setSize(1200,800);
//		frame.setVisible(true);
//	}
}
