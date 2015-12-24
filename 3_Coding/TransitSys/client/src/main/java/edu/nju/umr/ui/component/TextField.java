package edu.nju.umr.ui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.geom.RoundRectangle2D;
import com.sun.javafx.geom.Shape;

public class TextField extends JTextField{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3381742775192974151L;
	private static final int arcWidth = 15;
	private static final int arcHeight = 15;
	private Shape shape;
	
	public TextField() {
		setBorder(null);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(200, 25));
		Border empty = new EmptyBorder(0, 5, 0, 0);
		CompoundBorder border = new CompoundBorder(this.getBorder(), empty);
		setBorder(border);
		setFont(new Font("微软雅黑", Font.PLAIN, 16));
		setMargin(new Insets(0, 5, 0, 0));
		setOpaque(false);
	}
	
	public boolean contains(int x ,int y){
		shape = new RoundRectangle2D(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
		return shape.contains(x,y);
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
