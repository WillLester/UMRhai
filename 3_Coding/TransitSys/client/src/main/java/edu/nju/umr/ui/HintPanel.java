package edu.nju.umr.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class HintPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private JDialog dialog=new JDialog();
	public HintPanel(){
//		this.dialog=dialog;
		setLayout(null);
		setSize(409,230);
	}
	
	protected void paintComponent(Graphics g){
		Image background=new ImageIcon("ui/frame/hint.png").getImage();
		g.drawImage(background, 0, 0, null);
	}

}
