package edu.nju.umr.ui.userPanel;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.userUI.UserListPanel;
import edu.nju.umr.vo.UserVO;

public class AdministerPanel extends UserPanel {

/**
	 * 
	 */
	private static final long serialVersionUID = 4725198975118222690L;
	public AdministerPanel(UserVO user,MainFrame fr) {
		super(user,fr);
		Button userMangButton=new Button();
		userMangButton.setNewImages("Administer/userMan", "Administer/userManSt", "Administer/userManP");
//		JButton userMangButton = new JButton("用户管理");
		userMangButton.setFont(new Font("宋体", Font.PLAIN, 12));
		userMangButton.setBounds(Constants.FIRST_X, Constants.SINGLE_Y, 95, 95);
		userMangButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("用户管理");
				ffr.setContentPane(new UserListPanel(ffr,user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		this.add(userMangButton);
	}
}
