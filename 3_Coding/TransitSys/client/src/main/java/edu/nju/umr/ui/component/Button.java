package edu.nju.umr.ui.component;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String path="ui/button/";//待确定！

	public Button(){
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
			
	}
	protected void setNewImages(String before,String on,String after){
		
		setIcon(new ImageIcon(path+before+".png"));
		setRolloverIcon(new ImageIcon(path+on+".png"));
		setPressedIcon(new ImageIcon(path+after+".png"));
	}
}
