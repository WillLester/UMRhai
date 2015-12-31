package edu.nju.umr.ui.component;

import java.awt.Font;

import javax.swing.JLabel;

public class UMRLabel extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UMRLabel(String s){
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
	public void setMidFont() {
		// TODO Auto-generated method stub
		setFont(new Font("微软雅黑", Font.PLAIN, 18));
	}
}
