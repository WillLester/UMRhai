package edu.nju.umr.ui.userPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.checkUI.BusiCircumPanel;
import edu.nju.umr.ui.checkUI.CostBenePanel;
import edu.nju.umr.ui.checkUI.DiaryListPanel;
import edu.nju.umr.ui.cityUI.CityListPanel;
import edu.nju.umr.ui.cityUI.ConstantPanel;
import edu.nju.umr.ui.orderApproveUI.OrderApprovePanel;
import edu.nju.umr.ui.workOrgManUI.OrgListPanel;
import edu.nju.umr.ui.workOrgManUI.WageDraftPanel;
import edu.nju.umr.ui.workOrgManUI.WorkListPanel;
import edu.nju.umr.vo.UserVO;

public class ManagerPanel extends UserPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2151583811822292521L;

	public ManagerPanel(UserVO user,JFrame fr) {
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
//		vertical.setBounds(140, 78, 9, 545);
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
//		nameTxt.setBounds(66, 116, 54, 21);
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
//		levelTxt.setText("总经理");
//		levelTxt.setFont(new Font("宋体", Font.PLAIN, 15));
//		levelTxt.setBounds(66, 156, 54, 21);
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
		
		JButton approveButton = new JButton("单据审批");
		approveButton.setFont(new Font("宋体", Font.PLAIN, 12));
		approveButton.setBounds(269, 192, 112, 83);
		this.add(approveButton);
		approveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("单据审批");
				fr.setContentPane(new OrderApprovePanel());
			}
		});
		
		JButton cityButton = new JButton("城市管理");
		cityButton.setFont(new Font("宋体", Font.PLAIN, 12));
		cityButton.setBounds(516, 192, 112, 83);
		this.add(cityButton);
		cityButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("城市管理");
				fr.setContentPane(new CityListPanel());
			}
		});
		
		JButton constantButton = new JButton("常量制定");
		constantButton.setFont(new Font("宋体", Font.PLAIN, 12));
		constantButton.setBounds(760, 192, 112, 83);
		this.add(constantButton);
		constantButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("常量制定");
				fr.setContentPane(new ConstantPanel());
			}
		});
		
		JButton workerButton = new JButton("人员管理");
		workerButton.setFont(new Font("宋体", Font.PLAIN, 12));
		workerButton.setBounds(269, 192, 112, 83);
		this.add(workerButton);
		workerButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("人员管理");
				fr.setContentPane(new WorkListPanel());
			}
		});
		
		JButton orgButton = new JButton("机构管理");
		orgButton.setFont(new Font("宋体", Font.PLAIN, 12));
		orgButton.setBounds(516, 333, 112, 83);
		this.add(orgButton);
		orgButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("机构管理");
				fr.setContentPane(new OrgListPanel());
			}
		});
		
		JButton wageButton = new JButton("薪水策略管理");
		wageButton.setFont(new Font("宋体", Font.PLAIN, 12));
		wageButton.setBounds(760, 333, 112, 83);
		this.add(wageButton);
		wageButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("薪水管理");
				fr.setContentPane(new WageDraftPanel());
			}
		});
		
		JButton busiCircumButton = new JButton("查看经营情况表");
		busiCircumButton.setFont(new Font("宋体", Font.PLAIN, 12));
		busiCircumButton.setBounds(269, 477, 112, 83);
		this.add(busiCircumButton);
		busiCircumButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("查看经营情况表");
				fr.setContentPane(new BusiCircumPanel(fr));
			}
		});
		
		JButton costBeneButton = new JButton("查看成本收益表");
		costBeneButton.setFont(new Font("宋体", Font.PLAIN, 12));
		costBeneButton.setBounds(516, 477, 112, 83);
		this.add(costBeneButton);
		costBeneButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("查看成本收益表");
				fr.setContentPane(new CostBenePanel(fr));
			}
		});
		
		JButton diaryButton = new JButton("日志查询");
		diaryButton.setFont(new Font("宋体", Font.PLAIN, 12));
		diaryButton.setBounds(760, 477, 112, 83);
		this.add(diaryButton);
		diaryButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("查看日志记录");
				fr.setContentPane(new DiaryListPanel(fr));
			}
		});
		
	}

}

