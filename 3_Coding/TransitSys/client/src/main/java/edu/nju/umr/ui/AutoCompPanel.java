package edu.nju.umr.ui;

import java.awt.Font;
import java.awt.IllegalComponentStateException;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;

public class AutoCompPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7950844264752430637L;
	private UMRComboBox<String> jc=new UMRComboBox<String>();
	private TextField jt=new TextField();
	private ArrayList<String> allItem=new ArrayList<String>();
	private ArrayList<String> toDisplayItem = new ArrayList<String>();
	public AutoCompPanel(){
		setLayout(null);
		jt=new TextField();
		jc=new UMRComboBox<String>();
		jt.setBounds(0, 0, 100, 24);
		jc.setBounds(0, 22, 100, 0);
		add(jt);
		add(jc);
		
		jt.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				getToDisplayItem();
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}});
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
		try{
			jc.showPopup();
		}catch(IllegalComponentStateException e){
			
		}
	}
	public void setBounds(int x,int y,int width,int height){
		super.setBounds(x, y, width, height);
		jt.setBounds(0, 0, width, height);
		jc.setBounds(0, height-2, width, 0);
	}
	public void setText(String temp){
		jt.setText(temp);
	}
	public String getText(){
		return jt.getText();
	}
	public void setMyFont(Font font){
		jt.setFont(font);
		jc.setFont(font);
	}
	public void setEnabled(boolean enabled){
		super.setEnabled(enabled);
		jt.setEnabled(enabled);
		jc.setEnabled(enabled);
	}
	public TextField getjt(){
		return jt;
	}
}
