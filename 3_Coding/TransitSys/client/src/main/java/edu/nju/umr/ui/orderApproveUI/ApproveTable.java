package edu.nju.umr.ui.orderApproveUI;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class ApproveTable extends JTable {					
	/**
	 * 
	 */
	private static final long serialVersionUID = 1037716965543621738L;
	public ApproveTable(DefaultTableModel tableModel) {
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
//	public TableCellRenderer getDefaultRenderer(Class<?> columnClass) {
//		DefaultTableCellRenderer cr = (DefaultTableCellRenderer) super.getDefaultRenderer(columnClass); 						
//		cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER); 	
//		return cr;
//	}
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}