package edu.nju.umr.ui.userUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import edu.nju.umr.logic.userLogic.LoginLogic;
import edu.nju.umr.logicService.userLogicSer.LoginLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.button.LoginButton;
import edu.nju.umr.ui.transitInfoUI.TransitInfoInqPanel;
import edu.nju.umr.ui.userPanel.AdministerPanel;
import edu.nju.umr.ui.userPanel.BusinessHallPanel;
import edu.nju.umr.ui.userPanel.CourierPanel;
import edu.nju.umr.ui.userPanel.FinancePanel;
import edu.nju.umr.ui.userPanel.FinanceSuperPanel;
import edu.nju.umr.ui.userPanel.ManagerPanel;
import edu.nju.umr.ui.userPanel.StockManagerPanel;
import edu.nju.umr.ui.userPanel.TransitCenterPanel;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;

public class LoginPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1627754805290859013L;
	private JTextField idField;
	private JPasswordField password;
	private MainFrame frame;
	private LoginLSer logicSer;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unused")
	public LoginPanel(MainFrame fr) {
		setLayout(null);
		frame=fr;
		try {
			logicSer = new LoginLogic();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			HintFrame hint = new HintFrame(Result.NET_INTERRUPT, frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
		}
		this.setBounds(0, 0, frame.getWidth(), frame.getHeight());
	
		Button inquiryButton = new Button();
		inquiryButton.setIcon(new ImageIcon("ui/button/buttonTrInfo.png"));
		inquiryButton.setRolloverIcon(new ImageIcon("ui/button/buttonTrInfoSt.png"));
		inquiryButton.setPressedIcon(new ImageIcon("ui/button/buttonTrInfoP.png"));
		inquiryButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			frame.setContentPane(new TransitInfoInqPanel(frame));
		}
		});
		inquiryButton.setBounds(464, 233, 280, 45);
		add(inquiryButton);
		
		idField = new TextField();
		idField.setBounds(530, 340, 200, 25);
		add(idField);
		idField.setColumns(10);
		
		JLabel idLabel = new JLabel("账号");
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idLabel.setBounds(469, 340, 40, 24);
		Color color = new Color(57, 152,214);
		idLabel.setForeground(color);
		add(idLabel);
		
		JLabel passwordLabel = new JLabel("密码");
		passwordLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		passwordLabel.setForeground(color);
		passwordLabel.setBounds(469, 385, 40, 24);
		add(passwordLabel);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(530, 385,210, 24);
		add(password);
	
		Button loginButton = new LoginButton();
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultMessage re=logicSer.login(idField.getText(), new String(password.getPassword()));
				if(re.getReInfo()==Result.SUCCESS)
				{
					UserVO user=(UserVO)re.getMessage();
					switch(user.getJuri())
					{
					case COURIER:frame.setContentPane(new CourierPanel(user,frame));break;
					case HALL:frame.setContentPane(new BusinessHallPanel(user,frame));break;
					case CENTER:frame.setContentPane(new TransitCenterPanel(user,frame));break;
					case STOCK:frame.setContentPane(new StockManagerPanel(user,frame));break;
					case FINANCE_SUPE:frame.setContentPane(new FinanceSuperPanel(user,frame));break;
					case FINANCE:frame.setContentPane(new FinancePanel(user,frame));break;
					case MANAGER:frame.setContentPane(new ManagerPanel(user,frame));break;
					case ADMIN:frame.setContentPane(new AdministerPanel(user,frame));break;
					}
				}
				else{
					new HintFrame(re.getReInfo(),frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
				}
				
			}
		});
		loginButton.setBounds(452, 450, 150, 45);
		add(loginButton);
		
		Button closeButton = new Button();
		closeButton.setIcon(new ImageIcon("ui/button/buttonExit.png"));
		closeButton.setRolloverIcon(new ImageIcon("ui/button/buttonExitSt.png"));
		closeButton.setPressedIcon(new ImageIcon("ui/button/buttonExitP.png"));
		closeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
				
			}
		});
		closeButton.setBounds(625, 450, 150, 45);
		add(closeButton);

	}
	protected void paintComponent(Graphics g){
		Image backGround = new ImageIcon("ui/frame/main.png").getImage();
		g.drawImage(backGround, 0,0,null);
	}

}
