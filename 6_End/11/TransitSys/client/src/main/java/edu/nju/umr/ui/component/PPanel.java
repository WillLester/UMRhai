package edu.nju.umr.ui.component;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PPanel(){
		setLayout(null);
		setSize(1106,622);
	}
	
	protected void paintComponent(Graphics g){
		Image background=new ImageIcon("ui/frame/function.png").getImage();
		g.drawImage(background, 0, 0, null);
	}

}
