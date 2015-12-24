package edu.nju.umr.ui.component;

import javax.swing.JLabel;

public class ELabel extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ELabel(String s){
		setText(s);
		setForeground(Utils.STD_COLOR);
	}

	public void setStdFont() {
		// TODO Auto-generated method stub
		setFont(Utils.STD_FONT);
	}

	public void setMinFont() {
		// TODO Auto-generated method stub
		setFont(Utils.COMBO_FONT);
	}

}
