package ui.myui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 * 表格类
 * 
 * @author zsq
 * @time 2015/11/17 20:04
 */
public class MyJTable extends JTable {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private Boolean isCellEditable;
	private String[] headers;
	private String[][] cellData;

	/**
	 * @param headers
	 *            表格标题
	 * @param isCellEditable
	 *            是否可以对表格内容进行修改
	 */
	public MyJTable(String[] headers, boolean isCellEditable, MyJPanel panel) {
		this.isCellEditable = isCellEditable;
		this.headers = headers;
		cellData = null;

		this.setCellEditable();
		this.setBackground(new Color(0, 0, 0, 0.3f));
		this.setForeground(Color.WHITE);
		this.setFont(new MyFont(14));
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				panel.repaint();
			}
		});
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(JLabel.CENTER);
		this.setDefaultRenderer(Object.class, tcr);
		this.setRowSelectionAllowed(true);
		JTableHeader head = this.getTableHeader();
		head.setBackground(new Color(0.1f, 0.19f, 0.54f, 0.2f));
		head.setFont(new MyFont(14));
		head.setForeground(Color.BLACK);
		head.setDefaultRenderer(tcr);
		head.setResizingAllowed(true);
		head.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				panel.repaint();
			}
		});
		head.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				panel.repaint();
			}
		});
	}

	/**
	 * 设置表格内容能否修改
	 * 
	 * @param cellData
	 * @param headers
	 * @param cellEditable
	 */
	private void setCellEditable() {
		model = new DefaultTableModel(cellData, headers) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return MyJTable.this.isCellEditable;
			}
		};
		this.setModel(model);
	}

	public void addRow(String[] rowData) {
		model.addRow(rowData);
		this.setModel(model);
	}

	public void removeRow() {
		int[] selectedRows = this.getSelectedRows();
		int j = 0;

		for (int i : selectedRows) {
			model.removeRow(i - j);
			j++;
		}
		this.clearSelection();
		this.setModel(model);
	}

	public void clear() {
		model = new DefaultTableModel(null, this.headers) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return MyJTable.this.isCellEditable;
			}
		};
		this.setModel(model);
	}

	public String[][] getData() {
		int row = this.getRowCount();
		int column = this.getColumnCount();

		if (row == 0)
			return null;

		String[][] data = new String[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = (String) this.getValueAt(i, j);
			}
		}

		return data;
	}

	/**
	 * 得到某一行的数据
	 */
	public String[] getData(int row) {
		String[] data = new String[this.getColumnCount()];
		for (int i = 0; i < data.length; i++) {
			data[i] = (String) this.getValueAt(row, i);
		}
		return data;
	}
}