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
import edu.nju.umr.ui.workOrgManUI.WorkListPanel;
import edu.nju.umr.ui.workOrgManUI.WorkWageListPanel;
import edu.nju.umr.vo.UserVO;

public class ManagerPanel extends UserPanel{
	/**
	 * 总经理的界面
	 */
	private static final long serialVersionUID = 2151583811822292521L;

	public ManagerPanel(UserVO user,JFrame fr) {
		
		super(user,fr);
		
		JButton approveButton = new JButton("单据审批");
		approveButton.setFont(new Font("宋体", Font.PLAIN, 12));
		approveButton.setBounds(269, 192, 112, 83);
		this.add(approveButton);
		approveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("单据审批");
				fr.setContentPane(new OrderApprovePanel(fr,user.getName()));
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
				fr.setContentPane(new CityListPanel(fr,user.getName()));
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
				fr.setContentPane(new ConstantPanel(fr,user.getName()));
			}
		});
		
		JButton workerButton = new JButton("人员管理");
		workerButton.setFont(new Font("宋体", Font.PLAIN, 12));
		workerButton.setBounds(269, 333, 112, 83);
		this.add(workerButton);
		workerButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("人员管理");
				fr.setContentPane(new WorkListPanel(fr));
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
				fr.setContentPane(new OrgListPanel(fr));
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
				fr.setContentPane(new WorkWageListPanel(fr));
			}
		});
		
		JButton busiCircumButton = new JButton("经营情况表");
		busiCircumButton.setFont(new Font("宋体", Font.PLAIN, 12));
		busiCircumButton.setBounds(269, 477, 112, 83);
		this.add(busiCircumButton);
		busiCircumButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("经营情况表");
				fr.setContentPane(new BusiCircumPanel(fr));
			}
		});
		
		JButton costBeneButton = new JButton("成本收益表");
		costBeneButton.setFont(new Font("宋体", Font.PLAIN, 12));
		costBeneButton.setBounds(516, 477, 112, 83);
		this.add(costBeneButton);
		costBeneButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame fr = new FunctionFrame("成本收益表");
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
				FunctionFrame fr = new FunctionFrame("日志记录");
				fr.setContentPane(new DiaryListPanel(fr));
			}
		});
		
	}

}

