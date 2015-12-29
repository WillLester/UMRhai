package edu.nju.umr.ui.component.table;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
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
		JTableHeader head = table.getTableHeader();
		head.setForeground(Color.WHITE);
		head.setBackground(Utils.STD_COLOR);
		head.setFont(Utils.COMBO_FONT);
		head.setOpaque(false);
		return head;
	}

}
