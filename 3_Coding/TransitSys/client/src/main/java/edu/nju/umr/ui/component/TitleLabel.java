package edu.nju.umr.ui.component;

import java.awt.Color;

import javax.swing.JLabel;

import edu.nju.umr.ui.Constants;


public class TitleLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TitleLabel(String title){
		setText(title);
		setFont(Utils.TITLE_FONT);
		this.setForeground(Color.WHITE);
		setBounds(Constants.TITLE_X,Constants.TITLE_Y,Constants.TITLE_WIDTH,Constants.TABLE_HEIGHT);
		
	}

}
