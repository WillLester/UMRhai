package edu.nju.umr.ui;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.nju.umr.ui.utility.CheckLegal;

public class ExpressListPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4053236284290729766L;
	private JTextField expressField;
	private JList<String> expressList;
	private DefaultListModel<String> model;
	private JFrame frame;
	public ExpressListPanel(JFrame fr) {
		// TODO 自动生成的构造函数存根
		frame = fr;
		setLayout(null);
		
		JLabel expressId = new JLabel("订单条形码号");
		expressId.setHorizontalAlignment(SwingConstants.CENTER);
		expressId.setFont(new Font("宋体", Font.PLAIN, 20));
		expressId.setBounds(47, 35, 130, 24);
		add(expressId);
		
		expressField = new JTextField();
		expressField.setFont(new Font("宋体", Font.PLAIN, 20));
		expressField.setColumns(10);
		expressField.setBounds(182, 34, 280, 25);
		add(expressField);
		
		JButton newExpButton = new JButton("新增");
		newExpButton.setFont(new Font("宋体", Font.PLAIN, 20));
		newExpButton.setBounds(476, 36, 93, 23);
		add(newExpButton);
		newExpButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(isExpressLegal()){
					model.addElement(expressField.getText());
				}
			}
		});
		
		JLabel expressListLabel = new JLabel("已输入订单");
		expressListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressListLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		expressListLabel.setBounds(232, 69, 130, 24);
		add(expressListLabel);
		
		JButton deleteButton = new JButton("删除");
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 20));
		deleteButton.setBounds(575, 146, 93, 23);
		deleteButton.setEnabled(false);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				model.remove(expressList.getSelectedIndex());
			}
		});
		add(deleteButton);
		
		JButton modifyButton = new JButton("修改");
		modifyButton.setFont(new Font("宋体", Font.PLAIN, 20));
		modifyButton.setBounds(575, 179, 93, 23);
		modifyButton.setEnabled(false);
		modifyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(isExpressLegal()){
					model.set(expressList.getSelectedIndex(), expressField.getText());
				}
			}
		});
		add(modifyButton);
		
		JScrollPane scroll = new JScrollPane();
		expressList = new JList<String>();
		expressList.setBounds(306, 320, 489, 165);
		model = new DefaultListModel<String>();
		expressList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		expressList.setModel(model);
		expressList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO 自动生成的方法存根
				if(arg0.getValueIsAdjusting() == false){
					if(expressList.getSelectedIndex() == -1){
						deleteButton.setEnabled(false);
						modifyButton.setEnabled(false);
					} else {
						deleteButton.setEnabled(true);
						modifyButton.setEnabled(true);
						expressField.setText(model.get(expressList.getSelectedIndex()));
					}
				}
			}
		});
		scroll.setBounds(66, 103, 489, 165);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scroll);
	}
	private boolean isExpressLegal(){
		String info = CheckLegal.isExpressLegal(expressField.getText());
		if(!info.equals(null)){
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(info, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		return true;
	}
	public ArrayList<String> getExpresses(){
		ArrayList<String> expresses = new ArrayList<String>();
		for(int i = 0;i < expressList.getVisibleRowCount();i++){
			expresses.add(model.get(i));
		}
		return expresses;
	}
	public boolean isEmpty(){
		if(model.getSize() == 0){
			return true;
		} else {
			return false;
		}
	}
	public void setEnabled(boolean isEnabled){
		for(Component co:this.getComponents())
		{
			co.setEnabled(isEnabled);
		}
	}
	public void showExpressList(ArrayList<String> expressList){
		for(int i=0;i<expressList.size();i++)
		{
			model.addElement(expressList.get(i));
		}
	}
}
