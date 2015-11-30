package edu.nju.umr.ui.transitInfoUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.nju.umr.ui.orderNewUI.ExpressPanel;

public class ExpressInfoInqPanel extends ExpressPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6608025281059459114L;
	protected JButton checkButton;
	/**
	 * Create the panel.
	 */
	public ExpressInfoInqPanel(JFrame fr) {
		super(fr);
		checkButton = new JButton("查询");
		checkButton.setFont(new Font("宋体", Font.PLAIN, 20));
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		checkButton.setBounds(518, 66, 93, 23);
		add(checkButton);
	}

}
