package edu.nju.umr.ui.component;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String path="ui/frame/info.png";
	
	public InfoPanel(){
		setLayout(null);
		setSize(995,558);
	}
	
	protected void paintComponent(Graphics g){
		Image background=new ImageIcon(path).getImage();
		g.drawImage(background, 0, 0, null);
	}

}
