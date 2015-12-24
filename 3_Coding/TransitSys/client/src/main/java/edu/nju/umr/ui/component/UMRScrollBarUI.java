package edu.nju.umr.ui.component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class UMRScrollBarUI extends BasicScrollBarUI{
	public UMRScrollBarUI() {
		super();
	}
	
	protected void paintThumb(Graphics g,JComponent c,Rectangle thumbBound){
		int width = thumbBound.width;
		int height = thumbBound.height;
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.translate(thumbBound.x, thumbBound.y);
		g2.setColor(Utils.STD_COLOR);
		g2.drawRoundRect(1,1,width-2, height-2,5,5);
		g2.setColor(Color.WHITE);
		g2.drawLine(3,height/2,width-4,height/2);
		g2.drawLine(3,height/2+3,width-4,height/2+3);
		g2.translate(-thumbBound.x, -thumbBound.y);
	}
	
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		g.setColor(Color.WHITE);
		int x = trackBounds.x;
		int y = trackBounds.y;
		int width = trackBounds.width;
		int height = trackBounds.height;
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.1f));
		g2.fill3DRect(x, y, width, height, true);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		g2.setColor(Utils.STD_COLOR.brighter());
		g2.fill3DRect(x, y, 1, height+1, true);
		if(trackHighlight == DECREASE_HIGHLIGHT) {
			paintDecreaseHighlight(g);
		} else if(trackHighlight == INCREASE_HIGHLIGHT)  {
			paintIncreaseHighlight(g);
		}
	}
}
