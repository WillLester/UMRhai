package edu.nju.umr.ui.userPanel;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.userUI.UserListPanel;
import edu.nju.umr.vo.UserVO;

public class AdministerPanel extends UserPanel {

/**
	 * 
	 */
	private static final long serialVersionUID = 4725198975118222690L;
	public AdministerPanel(UserVO user,JFrame fr) {
		super(user,fr);
		JButton userMangButton = new JButton("用户管理");
		userMangButton.setFont(new Font("宋体", Font.PLAIN, 12));
		userMangButton.setBounds(369, 250, 93, 83);
		userMangButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("用户管理");
				ffr.setContentPane(new UserListPanel(ffr));
			}
		});
		this.add(userMangButton);
	}
}
