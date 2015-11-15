package edu.nju.umr.ui.userPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.orderNewUI.CenterLoadingPanel;
import edu.nju.umr.ui.orderNewUI.RecipientPanel;
import edu.nju.umr.ui.orderNewUI.TransitPanel;
import edu.nju.umr.vo.UserVO;

public class TransitCenterPanel extends UserPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4764722362354952480L;

	public TransitCenterPanel(UserVO user,JFrame fr) {
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
//		vertical.setBounds(180, 78, 9, 545);
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
//		levelTxt.setText("中转中心业务员");
//		levelTxt.setFont(new Font("宋体", Font.PLAIN, 15));
//		levelTxt.setBounds(56, 156, 110, 21);
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
		
		JButton receiveButton = new JButton("接收快递并派件");
		receiveButton.setFont(new Font("宋体", Font.PLAIN, 12));
		receiveButton.setBounds(299, 192, 112, 83);
		this.add(receiveButton);
		receiveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("生成接收单");
				fr.setContentPane(new RecipientPanel(fr));
			}
		});
		
		JButton loadingButton = new JButton("生成装车单");
		loadingButton.setFont(new Font("宋体", Font.PLAIN, 12));
		loadingButton.setBounds(546, 192, 112, 83);
		this.add(loadingButton);
		loadingButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("生成装车单");
				fr.setContentPane(new CenterLoadingPanel());
			}
		});
		
		JButton transitButton = new JButton("生成中转单");
		transitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		transitButton.setBounds(790, 192, 112, 83);
		this.add(transitButton);
		transitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("生成中转单");
				fr.setContentPane(new TransitPanel());
			}
		});
	}

}
