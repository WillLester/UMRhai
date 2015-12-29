package edu.nju.umr.ui.component.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import edu.nju.umr.ui.component.Utils;

public class UMRTableHeadRenderer extends JLabel implements TableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8213569965273694814L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO 自动生成的方法存根
		setForeground(Utils.STD_COLOR);
		setBackground(Utils.STD_COLOR);
		setFont(Utils.COMBO_FONT);
		setOpaque(false);
		return this;
	}

}
