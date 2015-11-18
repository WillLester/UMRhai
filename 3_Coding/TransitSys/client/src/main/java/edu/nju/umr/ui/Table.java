package edu.nju.umr.ui;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class Table extends JTable {					
	public Table(DefaultTableModel tableModel) {
		super(tableModel);						
	}
	public JTableHeader getTableHeader() {				
		JTableHeader tableHeader = super.getTableHeader();	
		tableHeader.setReorderingAllowed(false);			
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader
				.getDefaultRenderer(); 					
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);		
		return tableHeader;
	}
	public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
		DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super
				.getDefaultRenderer(columnClass); 						
		cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER); 	
		return cr;
	}
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}