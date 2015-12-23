package edu.nju.umr.ui.userPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.checkUI.BusiCircumPanel;
import edu.nju.umr.ui.checkUI.CostBenePanel;
import edu.nju.umr.ui.checkUI.DiaryListPanel;
import edu.nju.umr.ui.cityUI.CityListPanel;
import edu.nju.umr.ui.cityUI.ConstantPanel;
import edu.nju.umr.ui.component.Button;
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
    private static final String pathb="finance&manager/";
    private static final String path="manager/";
	public ManagerPanel(UserVO user,MainFrame fr) {
		
		super(user,fr);
		
		Button approveButton = new Button();
		approveButton.setNewImages(path+"approve", path+"approveSt", path+"approveP");
		approveButton.setFont(new Font("宋体", Font.PLAIN, 12));
		approveButton.setBounds(Constants.FIRST_X, Constants.THERE_Y, 95, 95);
		this.add(approveButton);
		approveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("单据审批");
				ffr.setContentPane(new OrderApprovePanel(ffr,user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button cityButton = new Button();
		cityButton.setNewImages(path+"city", path+"citySt", path+"cityP");
		cityButton.setFont(new Font("宋体", Font.PLAIN, 12));
		cityButton.setBounds(Constants.SECOND_X, Constants.THERE_Y, 95, 95);
		this.add(cityButton);
		cityButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("城市管理");
				ffr.setContentPane(new CityListPanel(ffr,user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button constantButton = new Button();
		constantButton.setNewImages(path+"constant", path+"constantSt", path+"constantP");
		constantButton.setFont(new Font("宋体", Font.PLAIN, 12));
		constantButton.setBounds(Constants.THIRD_X, Constants.THERE_Y, 95, 95);
		this.add(constantButton);
		constantButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("常量制定");
				ffr.setContentPane(new ConstantPanel(ffr,user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button workerButton = new Button();
		workerButton.setNewImages(path+"workMan", path+"workManSt", path+"workManP");
		workerButton.setFont(new Font("宋体", Font.PLAIN, 12));
		workerButton.setBounds(Constants.FIRST_X, Constants.THERE_SEC_Y, 95, 95);
		this.add(workerButton);
		workerButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("人员管理");
				ffr.setContentPane(new WorkListPanel(ffr,user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button orgButton = new Button();
		orgButton.setNewImages(path+"orgMan", path+"orgManSt", path+"orgManP");
		orgButton.setFont(new Font("宋体", Font.PLAIN, 12));
		orgButton.setBounds(Constants.SECOND_X, Constants.THERE_SEC_Y, 95, 95);
		this.add(orgButton);
		orgButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("机构管理");
				ffr.setContentPane(new OrgListPanel(ffr,user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button wageButton = new Button();
		wageButton.setNewImages(path+"wageMan", path+"wageManSt", path+"wageManP");
		wageButton.setFont(new Font("宋体", Font.PLAIN, 12));
		wageButton.setBounds(Constants.THIRD_X, Constants.THERE_SEC_Y, 95, 95);
		this.add(wageButton);
		wageButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("薪水管理");
				ffr.setContentPane(new WorkWageListPanel(ffr,user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button busiCircumButton = new Button();
		busiCircumButton.setNewImages(pathb+"busiCircum", pathb+"busiCircumSt", pathb+"busiCircumP");
		busiCircumButton.setFont(new Font("宋体", Font.PLAIN, 12));
		busiCircumButton.setBounds(Constants.FIRST_X, Constants.THERE_THI_Y, 95, 95);
		this.add(busiCircumButton);
		busiCircumButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("经营情况表");
				ffr.setContentPane(new BusiCircumPanel(ffr));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button costBeneButton = new Button();
		costBeneButton.setNewImages(pathb+"costBene", pathb+"costBeneSt", pathb+"costBeneP");
		costBeneButton.setFont(new Font("宋体", Font.PLAIN, 12));
		costBeneButton.setBounds(Constants.SECOND_X, Constants.THERE_THI_Y, 95, 95);
		this.add(costBeneButton);
		costBeneButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("成本收益表");
				ffr.setContentPane(new CostBenePanel(ffr));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button diaryButton = new Button();
		diaryButton.setNewImages(pathb+"diary", pathb+"diarySt", pathb+"diaryP");
		diaryButton.setFont(new Font("宋体", Font.PLAIN, 12));
		diaryButton.setBounds(Constants.THIRD_X, Constants.THERE_THI_Y, 95, 95);
		this.add(diaryButton);
		diaryButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("日志记录");
				ffr.setContentPane(new DiaryListPanel(ffr));
				fr.sonFrames.add(ffr);
			}
		});
		
	}

}

