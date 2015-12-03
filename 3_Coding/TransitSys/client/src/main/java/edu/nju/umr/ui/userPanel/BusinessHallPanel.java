package edu.nju.umr.ui.userPanel;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.orderNewUI.HallLoadingPanel;
import edu.nju.umr.ui.orderNewUI.IncomePanel;
import edu.nju.umr.ui.orderNewUI.RecipientPanel;
import edu.nju.umr.ui.workOrgManUI.DriverListPanel;
import edu.nju.umr.ui.workOrgManUI.VanListPanel;
import edu.nju.umr.vo.UserVO;


public class BusinessHallPanel extends UserPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 4435831268900821861L;

	//	private JTextField nameTxt;
//	private JTextField levelTxt;
//	private UserVO user;
//	
	public BusinessHallPanel(UserVO user,JFrame fr) {
//		setBounds(0, 0, 1229, 691);
//		this.setBorder(new EmptyBorder(5, 5, 5, 5));
//		this.setLayout(null);
//		this.user=user;
//		
//		JLabel title = new JLabel("快递物流管理系统");
//		title.setBounds(29, 10, 250, 38);
//		title.setFont(new Font("华文新魏", Font.PLAIN, 22));
//		this.add(title);
//		
//		JSeparator horizen = new JSeparator();
//		horizen.setBounds(18, 78, 1158, 2);
//		this.add(horizen);
//		
//		JSeparator vertical = new JSeparator();
//		vertical.setBounds(174, 81, 9, 545);
//		vertical.setOrientation(SwingConstants.VERTICAL);
//		this.add(vertical);
//		
//		JLabel nameLabel = new JLabel("姓名");
//		nameLabel.setBounds(18, 120, 54, 15);
//		nameLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
//		this.add(nameLabel);
//		
//		nameTxt = new JTextField();
//		nameTxt.setBounds(57, 115, 54, 21);
//		nameTxt.setText(user.getName());
//		nameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
//		nameTxt.setEditable(false);
//		this.add(nameTxt);
//		nameTxt.setColumns(10);
//		
//		JLabel levelLabel = new JLabel("身份");
//		levelLabel.setBounds(18, 160, 54, 15);
//		levelLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
//		this.add(levelLabel);
//		
//		levelTxt = new JTextField();
//		levelTxt.setBounds(57, 155, 107, 21);
//		levelTxt.setEditable(false);
//		levelTxt.setText("营业厅业务员");
//		levelTxt.setFont(new Font("宋体", Font.PLAIN, 15));
//		this.add(levelTxt);
//		levelTxt.setColumns(10);
		
		super(user,fr);
		
		JButton recipient = new JButton("到达单");
		recipient.setBounds(282, 231, 112, 83);
		recipient.setFont(new Font("宋体", Font.PLAIN, 12));
		recipient.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("单据创建");
				ffr.setContentPane(new RecipientPanel(ffr,user.getName(),user.getOrgId()));
			}
		});
		this.add(recipient);
		
		JButton hallLoading = new JButton("装车单");
		hallLoading.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("单据创建");
				ffr.setContentPane(new HallLoadingPanel(ffr,user.getName(),user.getId(),user.getOrgId()));
			}
		});
		hallLoading.setFont(new Font("宋体", Font.PLAIN, 12));
		hallLoading.setBounds(679, 231, 112, 83);
		this.add(hallLoading);
		
		JButton income = new JButton("收款单");
		income.setFont(new Font("宋体", Font.PLAIN, 12));
		income.setBounds(849, 231, 112, 83);
		income.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("收款单生成");
				ffr.setContentPane(new IncomePanel(ffr,user.getOrgId(),user.getName(),user.getId()));
			}
		});
		this.add(income);
		
		JButton driverMan = new JButton("司机信息管理");
		driverMan.setFont(new Font("宋体", Font.PLAIN, 12));
		driverMan.setBounds(598, 420, 113, 83);
		driverMan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("司机管理 ");
				ffr.setContentPane(new DriverListPanel(ffr,user));
			}
		});
		this.add(driverMan);
		
		JButton vanMan = new JButton("车辆信息管理");
		vanMan.setFont(new Font("宋体", Font.PLAIN, 12));
		vanMan.setBounds(389, 420, 113, 83);
		vanMan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("车辆管理 ");
				ffr.setContentPane(new VanListPanel(ffr,user));
			}
		});
		this.add(vanMan);
		

	
	
	}
}
