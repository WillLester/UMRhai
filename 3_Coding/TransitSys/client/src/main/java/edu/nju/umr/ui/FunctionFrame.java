package edu.nju.umr.ui;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import edu.nju.umr.ui.accountUI.*;
import edu.nju.umr.ui.workOrgManUI.*;
import edu.nju.umr.ui.stockUI.*;
import edu.nju.umr.ui.userUI.*;
import edu.nju.umr.ui.orderNewUI.*;
import edu.nju.umr.ui.cityUI.*;
import edu.nju.umr.ui.orderApproveUI.*;

public class FunctionFrame extends JInternalFrame{
	static final int FRAME_X = MainFrame.FRAME_WIDTH/20;
	static final int FRAME_Y = MainFrame.FRAME_HEIGHT/40;
	static final int FRAME_WIDTH = (int)(MainFrame.FRAME_WIDTH*0.9);
	static final int FRAME_HEIGHT = (int)(MainFrame.FRAME_HEIGHT*0.9);
	private JDesktopPane desktop;
	public FunctionFrame(String title) {
		desktop = new JDesktopPane();
		this.getContentPane().add(desktop);
		setTitle(title);
		setResizable(false);
		setClosable(true);
		setIconifiable(true);
		setBounds(FRAME_X,FRAME_Y,FRAME_WIDTH,FRAME_HEIGHT);
		System.out.println(this.getWidth()+" " + this.getHeight());
		this.setVisible(true);
		this.getContentPane().add(new WorkListPanel());
//		InfoFrame info = new InfoFrame("期初信息");
//		desktop.add(info);
//		info.setVisible(true);
	}
}
