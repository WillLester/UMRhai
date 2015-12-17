package edu.nju.umr.ui.userPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.orderNewUI.ArrivePanel;
import edu.nju.umr.ui.orderNewUI.CenterLoadingPanel;
import edu.nju.umr.ui.orderNewUI.TransitPanel;
import edu.nju.umr.vo.UserVO;

public class TransitCenterPanel extends UserPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4764722362354952480L;

	public TransitCenterPanel(UserVO user,MainFrame fr) {
		
		super(user,fr);
		
		JButton receiveButton = new JButton("生成到达单");
		receiveButton.setFont(new Font("宋体", Font.PLAIN, 12));
		receiveButton.setBounds(299, 192, 112, 83);
		this.add(receiveButton);
		receiveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("生成到达单");
				ffr.setContentPane(new  ArrivePanel(ffr,user.getName(),user.getOrgId(),user.getId()));
				fr.sonFrames.add(ffr);
			}
		});
		
		JButton loadingButton = new JButton("生成装车单");
		loadingButton.setFont(new Font("宋体", Font.PLAIN, 12));
		loadingButton.setBounds(546, 192, 112, 83);
		this.add(loadingButton);
		loadingButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("生成装车单");
				ffr.setContentPane(new CenterLoadingPanel(ffr,user.getName(),user.getId(),user.getOrg(),user.getOrgId()));
				fr.sonFrames.add(ffr);
			}
		});
		
		JButton transitButton = new JButton("生成中转单");
		transitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		transitButton.setBounds(790, 192, 112, 83);
		this.add(transitButton);
		transitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("生成中转单");
				ffr.setContentPane(new TransitPanel(ffr,user.getOrg(),user.getName(),user.getId(),user.getOrgId()));
				fr.sonFrames.add(ffr);
			}
		});
		
		UnpassedOrderMessagePanel upo = new UnpassedOrderMessagePanel(user.getId());
		upo.setBounds(853, 10, 200, 30);
		add(upo);
	}

}
