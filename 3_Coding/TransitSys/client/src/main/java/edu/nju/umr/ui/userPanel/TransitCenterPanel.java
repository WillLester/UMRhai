package edu.nju.umr.ui.userPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.orderNewUI.ArrivePanel;
import edu.nju.umr.ui.orderNewUI.CenterLoadingPanel;
import edu.nju.umr.ui.orderNewUI.TransitPanel;
import edu.nju.umr.vo.UserVO;

public class TransitCenterPanel extends UserPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4764722362354952480L;
	String path="transitcenter/";

	public TransitCenterPanel(UserVO user,MainFrame fr) {
		
		super(user,fr);
		
		Button receiveButton = new Button();
		receiveButton.setNewImages(path+"arrive", path+"arriveSt", path+"arriveP");
		receiveButton.setFont(new Font("宋体", Font.PLAIN, 12));
		receiveButton.setBounds(Constants.FIRST_X, Constants.SINGLE_Y, 95, 95);
		this.add(receiveButton);
		receiveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("生成到达单");
				ffr.setContentPane(new  ArrivePanel(ffr,user.getName(),user.getOrgId(),user.getId(),user.getOrg()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button loadingButton = new Button();
		loadingButton.setNewImages(path+"centerloading", path+"centerloadingSt", path+"centerloadingP");
		loadingButton.setFont(new Font("宋体", Font.PLAIN, 12));
		loadingButton.setBounds(Constants.SECOND_X,Constants.SINGLE_Y, 95, 95);
		this.add(loadingButton);
		loadingButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("生成装车单");
				ffr.setContentPane(new CenterLoadingPanel(ffr,user.getName(),user.getId(),user.getOrg(),user.getOrgId()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button transitButton = new Button();
		transitButton.setNewImages(path+"transit", path+"transitSt", path+"transitP");
		transitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		transitButton.setBounds(Constants.THIRD_X, Constants.SINGLE_Y, 95, 95);
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
		upo.setBounds(Constants.UNPASSED_X, Constants.UNPASSED_Y, 200, 30);
		add(upo);
	}

}
