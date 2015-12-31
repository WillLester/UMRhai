package edu.nju.umr.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class UMRTextArea extends JTextArea{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7908387263032252442L;
	private static final int arcWidth = 15;
	private static final int arcHeight = 15;
	
	public UMRTextArea() {
		setBorder(null);
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder());
		setFont(new Font("微软雅黑", Font.PLAIN, 16));
		setMargin(new Insets(0, 5, 0, 0));
		setOpaque(false);
		setLineWrap(true);;
		setBackground(null);
	}
	
	protected void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Utils.STD_COLOR);
		g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arcWidth, arcHeight);
		g2.setColor(Color.WHITE);
		g2.fillRoundRect(1, 1, getWidth()-2, getHeight()-2, arcWidth, arcHeight);
		super.paintComponent(g);
	}
}
