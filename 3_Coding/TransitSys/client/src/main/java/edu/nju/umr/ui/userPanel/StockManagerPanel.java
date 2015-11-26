package edu.nju.umr.ui.userPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.nju.umr.ui.FunctionFrame;
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

	public StockManagerPanel(UserVO user,JFrame fr) {
//		this.user=user;
//		setBounds(0, 0, 1229, 691);
//		this.setBorder(new EmptyBorder(5, 5, 5, 5));
//		this.setLayout(null);
//		
//		JLabel title = new JLabel("快递物流管理系统");
//		title.setFont(new Font("华文新魏", Font.PLAIN, 22));
//		title.setBounds(29, 10, 250, 38);
//		this.add(title);
//		
//		JSeparator horizen = new JSeparator();
//		horizen.setBounds(18, 78, 1158, 2);
//		this.add(horizen);
//		
//		JSeparator vertical = new JSeparator();
//		vertical.setOrientation(SwingConstants.VERTICAL);
//		vertical.setBounds(165, 78, 9, 545);
//		this.add(vertical);
//		
//		JLabel nameLabel = new JLabel("姓名");
//		nameLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
//		nameLabel.setBounds(18, 120, 54, 15);
//		this.add(nameLabel);
//		
//		JTextField nameTxt = new JTextField();
//		nameTxt.setText("袁楚宏");
//		nameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
//		nameTxt.setEditable(false);
//		nameTxt.setBounds(56, 116, 54, 21);
//		this.add(nameTxt);
//		nameTxt.setColumns(10);
//		
//		JLabel levelLabel = new JLabel("身份");
//		levelLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
//		levelLabel.setBounds(18, 160, 54, 15);
//		this.add(levelLabel);
//		
//		JTextField levelTxt = new JTextField();
//		levelTxt.setEditable(false);
//		levelTxt.setText("库存管理人员");
//		levelTxt.setFont(new Font("宋体", Font.PLAIN, 15));
//		levelTxt.setBounds(56, 156, 100, 21);
//		this.add(levelTxt);
//		levelTxt.setColumns(10);
//		
//		JButton logoutButton = new JButton("注销");
//		logoutButton.setFont(new Font("宋体", Font.PLAIN, 12));
//		logoutButton.setBounds(1083, 10, 93, 23);
//		this.add(logoutButton);
//		
//		JButton existButton = new JButton("退出");
//		existButton.setFont(new Font("宋体", Font.PLAIN, 12));
//		existButton.setBounds(1083, 603, 93, 23);
//		this.add(existButton);
		
		super(user,fr);
		
		JButton stockCheckButton = new JButton("库存查看");
		stockCheckButton.setFont(new Font("宋体", Font.PLAIN, 12));
		stockCheckButton.setBounds(269, 192, 112, 83);
		this.add(stockCheckButton);
		stockCheckButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				FunctionFrame fr = new FunctionFrame("库存查看");
				fr.setContentPane(new StockCheckPanel(fr));
			}
		});
		
		JButton divideButton = new JButton("库存分区");
		divideButton.setFont(new Font("宋体", Font.PLAIN, 12));
		divideButton.setBounds(516, 192, 112, 83);
		this.add(divideButton);
		divideButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("库存分区");
				fr.setContentPane(new StockDividePanel(fr));
			}
		});
		
		JButton warnButton = new JButton("设置警戒线");
		warnButton.setFont(new Font("宋体", Font.PLAIN, 12));
		warnButton.setBounds(760, 192, 112, 83);
		this.add(warnButton);
		warnButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("设置警戒线");
				fr.setContentPane(new StockWarningPanel(fr,user.getOrgId()));
			}
		});
		
		JButton checkNowButton = new JButton("库存盘点");
		checkNowButton.setFont(new Font("宋体", Font.PLAIN, 12));
		checkNowButton.setBounds(269, 333, 112, 83);
		this.add(checkNowButton);
		checkNowButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("库存盘点");
				fr.setContentPane(new StockCheckNowPanel(fr,user.getOrgId()));
			}
		});
		
		JButton stockOutButton = new JButton("生成出库单");
		stockOutButton.setFont(new Font("宋体", Font.PLAIN, 12));
		stockOutButton.setBounds(516, 333, 112, 83);
		this.add(stockOutButton);
		stockOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("生成出库单");
				fr.setContentPane(new StockOutPanel(fr,user.getName(),user.getOrgId()));
			}
		});
		
		JButton stockInButton = new JButton("生成入库单");
		stockInButton.setFont(new Font("宋体", Font.PLAIN, 12));
		stockInButton.setBounds(760, 333, 112, 83);
		this.add(stockInButton);
		stockInButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("生成入库单");
				fr.setContentPane(new StockInPanel(fr,user.getName(),user.getOrgId()));
			}
		});
	}

}
