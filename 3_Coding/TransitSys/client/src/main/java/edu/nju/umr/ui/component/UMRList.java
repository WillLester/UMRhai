package edu.nju.umr.ui.component;

import java.util.Vector;

import javax.swing.JList;
import javax.swing.ListModel;

import edu.nju.umr.ui.component.comboBox.UMRComboBoxRenderer;

public class UMRList<E> extends JList<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1329636350575774045L;

	public UMRList() {
		super();
		init();
	}
	
	public UMRList(ListModel<E> model){
		super(model);
		init();
	}
	
	public UMRList(E[] items){
		super(items);
		init();
	}
	
	public UMRList(Vector<E> items){
		super(items);
		init();
	}
	
	private void init(){
		setOpaque(false);
		setCellRenderer(new UMRComboBoxRenderer<E>());
		setBackground(null);
	}
}
