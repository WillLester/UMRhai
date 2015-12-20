package edu.nju.umr.ui.stockUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.stockLogic.StockCheckNowLogic;
import edu.nju.umr.logicService.stockLogicSer.StockCheckNowLSer;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.stub.StockCheckNowPanelStub;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.GoodVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.StockVO;

public class StockCheckNowPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8556287226068932490L;
	private JFrame frame;
	private Table table;
	private DefaultTableModel model;
	private StockCheckNowLSer logicSer;
	private ArrayList<GoodVO> goodList;
	private String orgId;
	public StockCheckNowPanel(JFrame fr,String orgId) {
		setLayout(null);
		frame=fr;
		this.orgId = orgId;
		logicSer = new StockCheckNowLogic();
//		logicSer = new StockCheckNowPanelStub();
		
		JLabel checkLabel = new JLabel("库存盘点");
		checkLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		checkLabel.setBounds(504, 31, 95, 24);
		add(checkLabel);
		
		JButton outputButton = new JButton("导出为Excel");
		outputButton.setFont(new Font("宋体", Font.PLAIN, 12));
		outputButton.setBounds(947, 150, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		outputButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				JFileChooser chooser = new javax.swing.JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("表格","xls","xlsx");
				chooser.setFileFilter(filter);
				chooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY); 
				int returnVal = chooser.showSaveDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					 File file = chooser.getSelectedFile();
					 if (file.exists()) {
					 int copy = JOptionPane.showConfirmDialog(null,"是否要覆盖当前文件？", "保存", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					     if (copy == JOptionPane.YES_OPTION){
					     chooser.approveSelection();
					     }
					 }
					 else
					 chooser.approveSelection();
					 Result result= logicSer.outputExcel(chooser.getSelectedFile().getParent(), chooser.getSelectedFile().getName());
					 DoHint.hint(result, frame);
						if(result.equals(Result.SUCCESS)){
							outputButton.setEnabled(false);
							try{
								Thread.sleep(300);
							}catch(Exception ex)
							{
								ex.printStackTrace();
							}
							frame.dispose();
						}
				}
			}
		});
		add(outputButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(947, 276, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(exitButton);

		tableInit();
		
	}
	void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setBounds(186, 84, 731, 442);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(186, 84, 731, 442);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"快递编号","入库日期","目的地","区号","架号","排号","位号"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
		
		displayTable();
	}
	private void displayTable(){
		ResultMessage message = logicSer.checkNow(orgId);
		model.setRowCount(0);
		if(message.getReInfo().equals(Result.SUCCESS)){
			StockVO stock = (StockVO)message.getMessage();
			goodList = stock.getGoods();
			for(GoodVO good:goodList){
				String info[] = new String[7];
				info[0] = good.getId();
				info[1] = DateFormat.DATE.format(good.getDate().getTime());
				info[2] = good.getCity();
				info[3] = getPart(good.getPart());
				info[4] = good.getShelf();
				info[5] = ""+good.getRow();
				info[6] = ""+good.getPlace();
				model.addRow(info);
			}
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(message.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
		}
	}
	private String getPart(Part part){
		String result = null;
		switch(part){
		case PLANE:result = "航运区";break;
		case TRAIN:result = "铁运区";break;
		case VAN:result = "汽运区";break;
		case MANEUVER:result = "机动区";break;
		}
		return result;
	}
}
