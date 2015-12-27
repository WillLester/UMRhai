package edu.nju.umr.ui.component.comboBox;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.UMRScrollBarUI;
import edu.nju.umr.ui.component.Utils;

public class UMRComboBoxUI extends BasicComboBoxUI {
	private boolean boundsLight = false;
	private static final int arcWidth = 15;
	private static final int arcHeight = 15;
	private Button arrow;
	private ImageIcon arrowI;
	
	public UMRComboBoxUI() {
		super();
	}

	protected JButton createArrowButton() {
		arrow = new Button();
		arrow.setNewImages("arrow", "arrowSt", "arrowP");
		arrow.setBorder(null);
		arrow.setBackground(Utils.STD_COLOR);
		arrow.setOpaque(false);
		arrow.setContentAreaFilled(false);
		return arrow;
	}

	public void paint(Graphics g, JComponent c) {
		hasFocus = comboBox.hasFocus();
		Graphics2D g2 = (Graphics2D) g;
		if(!comboBox.isEditable()) {
			Rectangle r = rectangleForCurrentValue();
			paintCurrentValueBackground(g2, r, hasFocus);
			paintCurrentValue(g2, r, hasFocus);
		}
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int width = (int) comboBox.getWidth()*87/100;
		int height = (int) comboBox.getHeight();
		if (comboBox.isPopupVisible()) {
			arrow.setIcon(new ImageIcon("ui/button/arrowP.png"));
		} else {
			arrow.setIcon(new ImageIcon("ui/button/arrow.png"));
		}
		if (comboBox.isFocusable()) {
			g2.setColor(Utils.STD_COLOR);
		}
		g2.drawRoundRect(0, 0, width-1, height-1,arcWidth,arcHeight);
	}

	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
		comboBox.setFont(Utils.COMBO_FONT);
		super.paintCurrentValue(g, bounds, hasFocus);
	}

	public Dimension getPreferredSize(JComponent c) {
		return super.getPreferredSize(c);
	}

	public boolean isBoundsLight() {
		return boundsLight;
	}

	public void setBoundsLight(boolean boundsLight) {
		this.boundsLight = boundsLight;
	}

	protected ComboPopup createPopup() {
		ComboPopup popup = new BasicComboPopup(comboBox) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 2521901655055728829L;
			protected JScrollPane createScroller() {
				JScrollPane sp = new JScrollPane(list,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				sp.getHorizontalScrollBar().setUI(new UMRScrollBarUI());
				return sp;
			}
			public void paintBorder(Graphics g){
				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2.setColor(Utils.STD_COLOR);
				g2.drawRoundRect(0,arrow.getHeight(),getWidth(),getHeight(),arcWidth,arcHeight);
			}
		};
		return popup;
	}
}
