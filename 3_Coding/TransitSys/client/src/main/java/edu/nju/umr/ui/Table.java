package edu.nju.umr.ui;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import edu.nju.umr.ui.component.table.UMRTableHeadRenderer;

public class Table extends JTable {					
	/**
	 * 
	 */
	private static final long serialVersionUID = 1037716965543621738L;
	public Table(DefaultTableModel tableModel) {
		super(tableModel);						
	}
	public JTableHeader getTableHeader() {				
		JTableHeader tableHeader = super.getTableHeader();	
		tableHeader.setReorderingAllowed(false);			
		tableHeader.setDefaultRenderer(new UMRTableHeadRenderer());
		UMRTableHeadRenderer hr = (UMRTableHeadRenderer) tableHeader
				.getDefaultRenderer();
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);		
		return tableHeader;
	}
	public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
		DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super.getDefaultRenderer(columnClass); 						
		cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER); 	
		return cr;
	}
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}