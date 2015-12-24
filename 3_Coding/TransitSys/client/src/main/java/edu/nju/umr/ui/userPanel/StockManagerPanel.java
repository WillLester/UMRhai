package edu.nju.umr.ui.userPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.orderNewUI.StockInPanel;
import edu.nju.umr.ui.orderNewUI.StockOutPanel;
import edu.nju.umr.ui.stockUI.StockCheckNowPanel;
import edu.nju.umr.ui.stockUI.StockCheckPanel;
import edu.nju.umr.ui.stockUI.StockDividePanel;
import edu.nju.umr.ui.stockUI.StockWarningPanel;
import edu.nju.umr.vo.UserVO;

public class StockManagerPanel extends UserPanel{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7789564793624015310L;
	public StockManagerPanel(UserVO user,MainFrame fr) {
		
		super(user,fr);
		
		Button stockCheckButton = new Button();
		stockCheckButton.setNewImages("stockmanager/stockCheck", "stockmanager/stockCheckSt", "stockmanager/stockCheckP");
		stockCheckButton.setFont(new Font("宋体", Font.PLAIN, 12));
		stockCheckButton.setBounds(Constants.FIRST_X, Constants.DOUBLE_Y, 95, 95);
		this.add(stockCheckButton);
		stockCheckButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				FunctionFrame ffr = new FunctionFrame("库存查看");
				ffr.setContentPane(new StockCheckPanel(ffr,user.getOrgId()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button divideButton = new Button();
		divideButton.setNewImages("stockmanager/stockDivide", "stockmanager/stockDivideSt", "stockmanager/stockDivideP");
		divideButton.setFont(new Font("宋体", Font.PLAIN, 12));
		divideButton.setBounds(Constants.SECOND_X, Constants.DOUBLE_Y, 95, 95);
		this.add(divideButton);
		divideButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("库存分区");
				ffr.setContentPane(new StockDividePanel(ffr,user.getOrgId(),user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button warnButton = new Button();
		warnButton.setNewImages("stockmanager/stockWarn", "stockmanager/stockWarnSt", "stockmanager/stockWarnP");
		warnButton.setFont(new Font("宋体", Font.PLAIN, 12));
		warnButton.setBounds(Constants.THIRD_X,Constants.DOUBLE_Y, 95, 95);
		this.add(warnButton);
		warnButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("设置警戒线");
				ffr.setContentPane(new StockWarningPanel(ffr,user.getOrgId(),user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button checkNowButton = new Button();
		checkNowButton.setNewImages("stockmanager/stockCheckNow", "stockmanager/stockCheckNowSt", "stockmanager/stockCheckNowP");
		checkNowButton.setFont(new Font("宋体", Font.PLAIN, 12));
		checkNowButton.setBounds(Constants.FIRST_X, Constants.SECOND_Y, 95, 95);
		this.add(checkNowButton);
		checkNowButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("库存盘点");
				ffr.setContentPane(new StockCheckNowPanel(ffr,user.getOrgId()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button stockOutButton = new Button();
		stockOutButton.setNewImages("stockmanager/stockOut", "stockmanager/stockOutSt", "stockmanager/stockOutP");
		stockOutButton.setFont(new Font("宋体", Font.PLAIN, 12));
		stockOutButton.setBounds(Constants.SECOND_X, Constants.SECOND_Y, 95, 95);
		this.add(stockOutButton);
		stockOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("生成出库单");
				ffr.setContentPane(new StockOutPanel(ffr,user.getName(),user.getOrgId(),user.getId(),user.getOrg()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button stockInButton = new Button();
		stockInButton.setNewImages("stockmanager/stockIn", "stockmanager/stockInSt", "stockmanager/stockInP");
		stockInButton.setFont(new Font("宋体", Font.PLAIN, 12));
		stockInButton.setBounds(Constants.THIRD_X, Constants.SECOND_Y, 95, 95);
		this.add(stockInButton);
		stockInButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("生成入库单");
				ffr.setContentPane(new StockInPanel(ffr,user.getName(),user.getOrgId(),user.getId()));
				fr.sonFrames.add(ffr);
			}
		});
		
		UnpassedOrderMessagePanel upo = new UnpassedOrderMessagePanel(user.getId());
		upo.setBounds(Constants.UNPASSED_X, Constants.UNPASSED_Y, 200, 30);
		add(upo);
	}

}
