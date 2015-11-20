package edu.nju.umr.ui.userPanel;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import edu.nju.umr.vo.UserVO;
import edu.nju.umr.ui.userUI.LoginPanel;

public class UserPanel extends JPanel{
	private JTextField nameTxt;
	private JTextField levelTxt;
	static private UserVO user;
	private JFrame frame;
	public UserPanel(UserVO user,JFrame fr) {
		this.user=user;
		this.frame=fr;
		setBounds(0, 0, 1229, 691);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		JLabel title = new JLabel("快递物流管理系统");
		title.setFont(new Font("华文新魏", Font.PLAIN, 22));
		title.setBounds(29, 10, 250, 38);
		this.add(title);
		
		JSeparator horizen = new JSeparator();
		horizen.setBounds(18, 78, 1158, 2);
		this.add(horizen);
		
		JSeparator vertical = new JSeparator();
		vertical.setOrientation(SwingConstants.VERTICAL);
		vertical.setBounds(240, 78, 9, 545);
		this.add(vertical);
		
		JLabel nameLabel = new JLabel("姓名");
		nameLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		nameLabel.setBounds(18, 120, 54, 15);
		this.add(nameLabel);
		
		nameTxt = new JTextField();
		nameTxt.setText(user.getName());
		nameTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		nameTxt.setEditable(false);
		nameTxt.setBounds(66, 116, user.getName().length()*16, 21);
		this.add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel levelLabel = new JLabel("身份");
		levelLabel.setFont(new Font("华文新魏", Font.PLAIN, 15));
		levelLabel.setBounds(18, 160, 54, 15);
		this.add(levelLabel);
		
		levelTxt = new JTextField();
		levelTxt.setEditable(false);
		String lv=null;
		switch(user.getJuri())
		{
		case COURIER:lv="快递员";break;
		case HALL:lv="营业厅业务员";break;
		case CENTER:lv="中转中心业务员";break;
		case STOCK:lv="库存管理员";break;
		case FINANCE_SUPE:lv="高级财务";break;
		case FINANCE:lv="普通财务";break;
		case MANAGER:lv="总经理";break;
		case ADMIN:lv="管理员";break;
		}
		levelTxt.setText(lv);
		levelTxt.setFont(new Font("宋体", Font.PLAIN, 15));
		levelTxt.setBounds(66, 156, lv.length()*16, 21);
		this.add(levelTxt);
		levelTxt.setColumns(10);
		
		
		
		JButton logoutButton = new JButton("注销");
		logoutButton.setFont(new Font("宋体", Font.PLAIN, 12));
		logoutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setContentPane(new LoginPanel(frame));
			}
		});
		logoutButton.setBounds(1083, 10, 93, 23);
		this.add(logoutButton);
		
		JButton existButton = new JButton("退出");
		existButton.setFont(new Font("宋体", Font.PLAIN, 12));
		existButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		existButton.setBounds(1083, 603, 93, 23);
		this.add(existButton);
	}
	public static UserVO getUser(){
		return user;
	}
}
