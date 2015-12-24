package edu.nju.umr.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import edu.nju.umr.logic.utilityLogic.OrderInfoLogic;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.button.AddButton;
import edu.nju.umr.ui.component.button.DelButton;
import edu.nju.umr.ui.orderNewUI.PriceCount;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.ui.utility.DoHint;

public class ExpressListPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4053236284290729766L;
	private AutoCompPanel expressField;
	private JList<String> expressList;
	private ArrayList<String> toAddExpresses;
	private DefaultListModel<String> model;
	private JFrame frame;
	private PriceCount faPanel;
	private Button newExpButton;
	public ExpressListPanel(JFrame fr,PriceCount fa)
	{
		this(fr);
		faPanel=fa;
		model.addListDataListener(new ListDataListener(){@Override
		public void contentsChanged(ListDataEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void intervalAdded(ListDataEvent e) {
			faPanel.getPrice();
		}

		@Override
		public void intervalRemoved(ListDataEvent e) {
		}});
		
	}
	public ExpressListPanel(JFrame fr) {
		frame = fr;
		setLayout(null);
		
		Color color = new Color(57, 152,214);
		
		JLabel expressId = new JLabel("订单条形码号");
		expressId.setHorizontalAlignment(SwingConstants.CENTER);
		expressId.setBounds(47, 35, 130, 24);
		expressId.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		expressId.setForeground(color);
		add(expressId);
		
		expressField = new AutoCompPanel();
		expressField.setBounds(182, 34, 280, 25);
		add(expressField);
		
		newExpButton = new AddButton();
		newExpButton.setBounds(expressField.getX()+280+Constants.INTERVAL, 32, 100, 30);
		add(newExpButton);
		newExpButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(isExpressLegal()){
					OrderInfoLSer orderServ=new OrderInfoLogic();
//					OrderInfoLSer orderServ=new OrderInfoLogicStub();
					if(!orderServ.isExpressValid(expressField.getText()))
					{
						DoHint.hint("订单不存在!", frame);
					}
					model.addElement(expressField.getText());
					expressList.setModel(model);
					toAddExpresses.remove(expressField.getText());
					expressField.setAllItem(toAddExpresses);
					expressField.setText("");
					
				}
			}
		});
		
		JLabel expressListLabel = new JLabel("已输入订单");
		expressListLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressListLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		expressListLabel.setForeground(color);
		expressListLabel.setBounds(232, 69, 130, 24);
		add(expressListLabel);
		
		Button deleteButton = new DelButton();
		deleteButton.setBounds(575, 146, 100, 30);
		deleteButton.setEnabled(false);
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				toAddExpresses.add(expressList.getSelectedValue());
				expressField.setAllItem(toAddExpresses);
				expressField.setText("");
				model.remove(expressList.getSelectedIndex());
				
			}
		});
		add(deleteButton);
		
		Button modifyButton = new Button();
		modifyButton.setIcon(new ImageIcon("ui/button/buttonRev.png"));
		modifyButton.setRolloverIcon(new ImageIcon("ui/button/buttonRevSt.png"));
		modifyButton.setPressedIcon(new ImageIcon("ui/button/buttonRevP.png"));
		modifyButton.setBounds(575, 179, 100, 30);
		modifyButton.setEnabled(false);
		modifyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isExpressLegal()){
					model.set(expressList.getSelectedIndex(), expressField.getText());
				}
			}
		});
//		add(modifyButton);
		
		model = new DefaultListModel<String>();
		expressList = new JList<String>(model);
		JScrollPane scroll = new JScrollPane(expressList);
		expressList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		expressList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(arg0.getValueIsAdjusting() == false){
					if(expressList.getSelectedIndex() == -1){
						deleteButton.setEnabled(false);
						modifyButton.setEnabled(false);
					} else if(newExpButton.isEnabled()){
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
		if(info!=null){
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(info, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		for(int i=0;i<expressList.getModel().getSize();i++)
		{
			if(expressField.getText().equals(expressList.getModel().getElementAt(i)))
			{
				DoHint.hint("单据已输入！", frame);
				return false;
			}
		}
		return true;
	}
	public ArrayList<String> getExpresses(){
		ArrayList<String> expresses = new ArrayList<String>();
		for(int i = 0;i < model.getSize();i++){
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
	public void setAllItem(ArrayList<String> ar){
		toAddExpresses=new ArrayList<String>();
		toAddExpresses.addAll(ar);
		expressField.setAllItem(toAddExpresses);
	}
}
