package edu.nju.umr.ui.component;

import javax.swing.JFrame;

public class ExcitedFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Button close=new Button();
	private Button toMin=new Button();
	private Button toMax=new Button();
	
	public ExcitedFrame(){
		close.setNewImages("close", "closeSt", "closeP");
	}

}
