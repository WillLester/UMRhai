package edu.nju.umr.ui.component.comboBox;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import edu.nju.umr.ui.component.Utils;

public class UMRComboBoxRenderer implements ListCellRenderer<Object>{

	private DefaultListCellRenderer defaultCellRenderer = new DefaultListCellRenderer();
	
	public UMRComboBoxRenderer() {
		super();
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list,
			Object value, int index, boolean isSelected, boolean cellHasFocus) {
		// TODO 自动生成的方法存根
		JLabel renderer = (JLabel) defaultCellRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if(isSelected){
			renderer.setBackground(Utils.STD_COLOR);
		}
		return null;
	}

}
