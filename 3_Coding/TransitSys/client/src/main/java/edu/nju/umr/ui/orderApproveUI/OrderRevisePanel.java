package edu.nju.umr.ui.orderApproveUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import edu.nju.umr.ui.Constants;

public class OrderRevisePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private ApproveTable table;
	private DefaultTableModel model;
	private JFrame frame;

	
	
	class MyTableModel extends DefaultTableModel {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public Class getColumnClass(int c) {
	        if(c==0)return new Boolean(true).getClass();
	        return new String().getClass();
	        
	    }
	}
	/**
	 * Create the panel.
	 */
	public OrderRevisePanel(JFrame fr) {
		setLayout(null);
		frame=fr;

		JLabel reviseLabel = new JLabel("未通过单据");
		reviseLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		reviseLabel.setBounds(505, 40, 93, 24);
		add(reviseLabel);
		
	
		JButton reviseButton = new JButton("修改");
		reviseButton.setFont(new Font("宋体", Font.PLAIN, 12));
		reviseButton.setBounds(927, 271, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		reviseButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub


				
			}
		});
		add(reviseButton);
		
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(927, 383, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(exitButton);
		tableInit();
	

	}
	private void tableInit(){
		table = new ApproveTable(new MyTableModel());
		model=(MyTableModel)table.getModel();
//		table.addMouseListener(new MouseAdapter(){
//			public void mouseClicked(MouseEvent e){
//				if(e.getClickCount()>= 1&&table.columnAtPoint(e.getPoint())==0){
//				int row = table.rowAtPoint(e.getPoint()); 
//					if(((Boolean)table.getValueAt(row,0)).booleanValue()){
//						table.setValueAt(false,row, 0);
//					}
//					else
//						table.setValueAt(true,row, 0);
//			}}});
		table.setBounds(193, 71, 717, 421);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(193, 71, 717, 421);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"时间","种类"};
		model.setColumnIdentifiers(columnNames);
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
		add(scroll);
	}
	public static void main(String[] args)
	{
		JFrame frame=new JFrame();
		frame.setSize(1200,800);
		frame.setContentPane(new OrderRevisePanel(frame));
		frame.setVisible(true);
	}

}
