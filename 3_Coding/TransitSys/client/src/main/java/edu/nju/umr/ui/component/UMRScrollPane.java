package edu.nju.umr.ui.component;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollPane;

import org.apache.poi.ss.formula.functions.T;

public class UMRScrollPane extends JScrollPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4389222058954063250L;
	
	public UMRScrollPane() {
		super();
		init();
	}
	
	public UMRScrollPane(JComponent view){
		super(view);
		init();
	}
	
	public UMRScrollPane(JList<T> list, int verticalScrollbarAsNeeded,
			int horizontalScrollbarNever) {
		// TODO 自动生成的构造函数存根
		super(list,verticalScrollbarAsNeeded,horizontalScrollbarNever);
		init();
	}

	private void init(){
		setOpaque(false);
		getViewport().setOpaque(false);
		getVerticalScrollBar().setUI(new UMRScrollBarUI());
		setBackground(Utils.STD_COLOR.brighter());
	}

}
