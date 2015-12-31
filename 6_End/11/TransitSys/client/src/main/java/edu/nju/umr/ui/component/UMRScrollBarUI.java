package edu.nju.umr.ui.component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class UMRScrollBarUI extends BasicScrollBarUI{
	
	private Image arrowDown;
	private Image arrowUp;
	
	public UMRScrollBarUI() {
		super();
		arrowDown = new ImageIcon("ui/button/arrow.png").getImage();
		arrowUp = new ImageIcon("ui/button/arrowUp.png").getImage();
	}
	
	protected void paintThumb(Graphics g,JComponent c,Rectangle thumbBound){
		int width = thumbBound.width;
		int height = thumbBound.height;
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.translate(thumbBound.x, thumbBound.y);
		g2.setColor(Utils.STD_COLOR);
		g2.drawRoundRect(1,1,width-2, height-2,5,5);
		g2.fillRoundRect(2, 2, width-3, height-3, 5, 5);
		g2.setColor(Color.WHITE);
		g2.drawLine(3,height/2,width-4,height/2);
		g2.drawLine(3,height/2+3,width-4,height/2+3);
		g2.translate(-thumbBound.x, -thumbBound.y);
	}
	
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		g.setColor(Utils.STD_COLOR.brighter());
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
	
	protected void paintDecreaseHighlight(Graphics g){
		g.setColor(Color.green);  
        int x = this.getTrackBounds().x;  
        int y = this.getTrackBounds().y;  
        int w = 0, h = 0;  
        if (this.scrollbar.getOrientation() == JScrollBar.VERTICAL){  
            w = this.getThumbBounds().width;  
            h = this.getThumbBounds().y - y;  
  
        }  
        if (this.scrollbar.getOrientation() == JScrollBar.HORIZONTAL){  
            w = this.getThumbBounds().x - x;  
            h = this.getThumbBounds().height;  
        }  
        g.fillRect(x, y, w, h); 
	}
	
	protected void paintIncreaseHighlight(Graphics g){  
        g.setColor(Color.BLUE);  
        int x = this.getThumbBounds().x;  
        int y = this.getThumbBounds().y;  
        int w = this.getTrackBounds().width;  
        int h = this.getTrackBounds().height;  
        g.fillRect(x, y, w, h);  
    }  
  
    protected JButton createIncreaseButton(int orientation){  
        return new BasicArrowButton(orientation){  

            /**
			 * 
			 */
			private static final long serialVersionUID = 1542400866007689830L;

			public void paintTriangle(Graphics g, int x, int y, int size, int direction, boolean isEnabled){  
                Graphics2D g2 = (Graphics2D) g;  
                g2.fillRect(0, 0, getWidth(), getHeight());  
                g2.setColor(Utils.STD_COLOR);  
                g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);  
                g2.drawImage(arrowDown, (getWidth() - 2) / 2 - 5, (getHeight() - 2) / 2 - 5, 13, 13, null);  
            }  
        };  
    }  
  
    protected JButton createDecreaseButton(int orientation){  
        return new BasicArrowButton(orientation){  
            /**
			 * 
			 */
			private static final long serialVersionUID = -6496393723280832883L;

			public void paintTriangle(Graphics g, int x, int y, int size, int direction, boolean isEnabled){  
                Graphics2D g2 = (Graphics2D) g;  
                g2.fillRect(0, 0, getWidth(), getHeight());  
                g2.setColor(Utils.STD_COLOR);  
                g2.drawRect(0, 0, getWidth() - 1, getHeight() - 1);  
                g2.drawImage(arrowUp, (getWidth() - 2) / 2 - 5, (getHeight() - 2) / 2 - 5, 13, 13, null);  
            }  
        };  
    }  
}
