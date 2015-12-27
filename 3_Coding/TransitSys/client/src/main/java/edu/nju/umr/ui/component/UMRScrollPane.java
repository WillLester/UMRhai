package edu.nju.umr.ui.component;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

public class UMRScrollPane extends JScrollPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4389222058954063250L;
	
	public UMRScrollPane() {
		super();
		init();
	}
	
	public UMRScrollPane(JComponent view){
		super(view);
		init();
	}
	
	private void init(){
		setOpaque(false);
		getViewport().setOpaque(false);
		getVerticalScrollBar().setUI(new UMRScrollBarUI());
	}

}
