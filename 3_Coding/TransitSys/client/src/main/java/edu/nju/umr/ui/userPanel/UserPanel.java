package edu.nju.umr.ui.userPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.component.button.LogoutButton;
import edu.nju.umr.ui.userUI.LoginPanel;
import edu.nju.umr.vo.UserVO;

public class UserPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1833841005604801589L;
	private JLabel nameTxt;
	private JLabel levelTxt;
	private UserVO user;
	public MainFrame frame;
	public UserPanel(UserVO user,MainFrame fr) {
		this.user=user;
		this.frame=fr;
		setBounds(0, 0, 1229, 691);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
	
		JLabel nameLabel = new JLabel("姓名");
		nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(18, 119, 54, 15);
		this.add(nameLabel);
		
		nameTxt = new JLabel();
		nameTxt.setText(user.getName());
		nameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		nameTxt.setForeground(Color.WHITE);
		nameTxt.setBounds(66, 116, user.getName().length()*16, 21);
		this.add(nameTxt);
	
		
		JLabel levelLabel = new JLabel("身份");
		levelLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		levelLabel.setForeground(Color.WHITE);
		levelLabel.setBounds(18, 159, 54, 15);
		this.add(levelLabel);
		
		levelTxt = new JLabel();
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
		levelTxt.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		levelTxt.setForeground(Color.WHITE);
		levelTxt.setBounds(66, 156, lv.length()*16, 21);
		this.add(levelTxt);
		
		JLabel orgLabel = new JLabel("机构");
		orgLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		orgLabel.setForeground(Color.WHITE);
		orgLabel.setBounds(18, 192, 54, 15);
		this.add(orgLabel);
		
		JLabel orgTxt=new JLabel();
		String orgl=user.getOrg();
		orgTxt.setText(orgl);
		orgTxt.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		orgTxt.setForeground(Color.WHITE);
		orgTxt.setBounds(66, 189, orgl.length()*16, 21);
		this.add(orgTxt);
		
		Button logoutButton = new LogoutButton();
		logoutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setContentPane(new LoginPanel(frame));
				for(JFrame frr:fr.sonFrames)
				{
					frr.dispose();
				}
			}
		});
		logoutButton.setBounds(1121, 85, 100, 30);
		this.add(logoutButton);
		
		Button existButton = new ExitButton();
		existButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		existButton.setBounds(1070, 606, 150, 45);
		this.add(existButton);
	}

	public UserVO getUser(){
		return user;
	}
	protected void paintComponent(Graphics g){
		Image background = new ImageIcon("ui/frame/user.png").getImage();
		g.drawImage(background, 0, 0, null);
	}
}
