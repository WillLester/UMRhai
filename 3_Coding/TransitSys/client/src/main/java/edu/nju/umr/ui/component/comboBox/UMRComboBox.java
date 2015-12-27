package edu.nju.umr.ui.component.comboBox;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class UMRComboBox<E> extends JComboBox<E>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4206098001011002404L;
	
	
	public UMRComboBox() {
		super();
		init();
	}
	
	public UMRComboBox(ComboBoxModel<E> model){
		super(model);
		init();
	}
	
	public UMRComboBox(E[] items){
		super(items);
		init();
	}
	
	public UMRComboBox(Vector<E> items){
		super(items);
		init();
	}

	private void init(){
		setPreferredSize(new Dimension(200, 30));
		setOpaque(false);
		UMRComboBoxUI ui = new UMRComboBoxUI(30);
		setUI(ui);
		setRenderer(new UMRComboBoxRenderer<E>());
		setBackground(null);
	}
	
	public Dimension getPreferredSize(){
		return super.getPreferredSize();
	}
	
	@Override
	public void setSize(int width,int height){
		super.setSize(width, height);
		UMRComboBoxUI ui = new UMRComboBoxUI(height);
		setUI(ui);
	}
	
	@Override
	public void setBounds(int x, int y,int width,int height){
		super.setBounds(x,y,width, height);
		UMRComboBoxUI ui = new UMRComboBoxUI(height);
		setUI(ui);
	}
}
