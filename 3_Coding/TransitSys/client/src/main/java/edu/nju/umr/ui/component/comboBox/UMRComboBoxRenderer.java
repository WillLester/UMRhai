package edu.nju.umr.ui.component.comboBox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import edu.nju.umr.ui.component.Utils;

public class UMRComboBoxRenderer<E> implements ListCellRenderer<E>{

	private DefaultListCellRenderer defaultCellRenderer = new DefaultListCellRenderer();
	
	public UMRComboBoxRenderer() {
		super();
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends E> list,
			E value, int index, boolean isSelected, boolean cellHasFocus) {
		// TODO 自动生成的方法存根
		JLabel renderer = (JLabel) defaultCellRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		if(isSelected){
			renderer.setBackground(Utils.STD_COLOR);
			renderer.setForeground(Color.WHITE);
		} else {
			renderer.setBackground(Color.WHITE);
		}
		list.setSelectionBackground(Utils.STD_COLOR);
		renderer.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		renderer.setHorizontalAlignment(JLabel.CENTER);
		return renderer;
	}

}
