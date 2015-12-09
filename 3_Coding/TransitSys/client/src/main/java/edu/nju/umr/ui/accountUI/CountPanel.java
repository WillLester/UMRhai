package edu.nju.umr.ui.accountUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.accountLogic.CountLogic;
import edu.nju.umr.logicService.accountLogicSer.CountLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.InfoFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.vo.CountVO;
import edu.nju.umr.vo.ResultMessage;

public class CountPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6592881582489810248L;
	private Table table;
	private DefaultTableModel model;
	private ArrayList<CountVO> countList;
	private JFrame frame;
	private CountLSer logicSer;
	/**
	 * Create the panel.
	 */
	public CountPanel(JFrame fr,String name) {
		setLayout(null);
		frame=fr;
		logicSer=new CountLogic();
		
		JLabel countLabel = new JLabel("期初建账");
		countLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		countLabel.setBounds(6*Constants.WIDTH_DIV_15, Constants.HEIGHT_DIV_10/10, 2*Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(countLabel);
		
		JButton addButton = new JButton("新增");
		addButton.setFont(new Font("宋体", Font.PLAIN, 12));
		addButton.setBounds(Constants.WIDTH_DIV_9*17/10, Constants.HEIGHT_DIV_10*74/10, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		add(addButton);
		addButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Result result = logicSer.newCount(name);
				if(result.equals(Result.SUCCESS)){
					fresh();
				} else {
					hint(result);
				}
			}
		});
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 12));
		deleteButton.setBounds(Constants.WIDTH_DIV_9*27/10, Constants.HEIGHT_DIV_10*74/10, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Result result = logicSer.deleteCount(table.getSelectedRow(),name);
				if(result.equals(Result.SUCCESS)){
					fresh();
				} else {
					hint(result);
				}
			}
		});
		add(deleteButton);
		
		JButton checkButton = new JButton("查看");
		checkButton.setFont(new Font("宋体", Font.PLAIN, 12));
		checkButton.setBounds(Constants.WIDTH_DIV_9*37/10, Constants.HEIGHT_DIV_10*74/10, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		checkButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				InfoFrame fr = new InfoFrame("期初信息查看");
				fr.setContentPane(new CountInfoPanel(countList.get(table.getSelectedRow()), fr));
			}
		});
		add(checkButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(Constants.WIDTH_DIV_9*57/10, Constants.HEIGHT_DIV_10*74/10, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(exitButton);
		
		tableInit();
		fresh();

	}
	private void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setBounds(Constants.WIDTH_DIV_9*13/10, Constants.HEIGHT_DIV_10*17/10, Constants.TEXTFIELD_WIDTH_L*21/20, 14*Constants.TEXTFIELD_HEIGHT);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(Constants.WIDTH_DIV_9*13/10, Constants.HEIGHT_DIV_10*17/10, Constants.TEXTFIELD_WIDTH_L*21/20, 14*Constants.TEXTFIELD_HEIGHT);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"编号","生成时间"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	private void displayCounts(){
		model.setRowCount(0);
		for(CountVO count:countList){
			String info[] = {count.getId()+"",DateFormat.TIME.format(count.getTime().getTime())};
			model.addRow(info);
		}
	}
	@SuppressWarnings("unchecked")
	private void fresh(){
		ResultMessage message = logicSer.getCount();
		if(message.getReInfo().equals(Result.SUCCESS)){
			countList = (ArrayList<CountVO>) message.getMessage();
			displayCounts();
		} else {
			hint(message.getReInfo());
		}
	}
	private void hint(Result result){
		@SuppressWarnings("unused")
		HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
	}
}
