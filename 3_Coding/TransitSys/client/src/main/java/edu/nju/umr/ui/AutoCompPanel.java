package edu.nju.umr.ui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AutoCompPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7950844264752430637L;
	JComboBox<String> jc;
	JTextField jt;
	ArrayList<String> allItem=new ArrayList<String>();
	ArrayList<String> toDisplayItem = new ArrayList<String>();
	public AutoCompPanel(){
		setLayout(null);
		jt=new JTextField();
		jc=new JComboBox<String>();
		jt.setBounds(0, 0, 100, 24);
		jc.setBounds(0, 22, 100, 0);
		add(jt);
		add(jc);
		
		jt.getDocument().addDocumentListener(new DocumentListener(){@Override
		public void changedUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			getToDisplayItem();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			// TODO Auto-generated method stub
			getToDisplayItem();
		}});
		
		jc.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(jc.getSelectedIndex()>-1){
					jt.setText(jc.getSelectedItem().toString());
				}
			}});
	}
	public void setAllItem(ArrayList<String> ar){
		allItem.clear();
		allItem.addAll(ar);
		jc.setSelectedIndex(-1);
	}
	private void getToDisplayItem(){
		toDisplayItem.clear();
		String temp=jt.getText();
		DefaultComboBoxModel<String> m=new DefaultComboBoxModel<String>();
		for(String all:allItem){
			if(all.substring(0,Math.min(temp.length(), all.length())).equals(temp)){
				m.addElement(all);
			}
		}
		jc.setModel(m);
		jc.setSelectedIndex(-1);
		jc.showPopup();
	}
	public void setBounds(int x,int y,int width,int height){
		super.setBounds(x, y, width, height);
		jt.setBounds(0, 0, width, height);
		jc.setBounds(0, height-2, width, 0);
	}
}
