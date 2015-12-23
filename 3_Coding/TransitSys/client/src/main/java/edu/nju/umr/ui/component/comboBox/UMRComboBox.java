package edu.nju.umr.ui.component.comboBox;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class UMRComboBox extends JComboBox<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4206098001011002404L;
	
	public UMRComboBox() {
		super();
		init();
	}
	
	public UMRComboBox(ComboBoxModel<Object> model){
		super(model);
		init();
	}
	
	public UMRComboBox(Object[] items){
		super(items);
		init();
	}
	
	public UMRComboBox(Vector<Object> items){
		super(items);
		init();
	}

	private void init(){
		setOpaque(false);
		setUI(new UMRComboBoxUI());
		setRenderer(new UMRComboBoxRenderer());
		setBackground(Color.WHITE);
	}
	
	public Dimension getPreferredSize(){
		return super.getPreferredSize();
	}
}
