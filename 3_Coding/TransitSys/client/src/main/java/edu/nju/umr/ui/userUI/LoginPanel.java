package edu.nju.umr.ui.userUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.logic.userLogic.LoginLogic;
import edu.nju.umr.logicService.userLogicSer.LoginLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.HintFrame;
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
	private static final long serialVersionUID = 3358515981326880681L;
	private JTextField idField;
	private JPasswordField password;
	private JFrame frame;
	private LoginLSer logicSer;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unused")
	public LoginPanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		try {
			logicSer = new LoginLogic();
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			HintFrame hint = new HintFrame(Result.NET_INTERRUPT, frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
		}
		this.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		
		JLabel titleLabel = new JLabel("快递物流系统");
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(464, 10, 242, 67);
		add(titleLabel);
		
		JLabel idLabel = new JLabel("账号");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		idLabel.setBounds(464, 104, 40, 24);
		add(idLabel);
		
		idField = new JTextField();
		idField.setBounds(525, 107, 193, 24);
		add(idField);
		idField.setColumns(10);
		
		JButton loginButton = new JButton("登陆");
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
		loginButton.setFont(new Font("宋体", Font.PLAIN, 20));
		loginButton.setBounds(464, 295, 93, 23);
		add(loginButton);
		
		JButton closeButton = new JButton("关闭");
		closeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
				
			}
		});
		closeButton.setFont(new Font("宋体", Font.PLAIN, 20));
		closeButton.setBounds(625, 295, 93, 23);
		add(closeButton);
		
		JLabel passwordLabel = new JLabel("密码");
		passwordLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		passwordLabel.setBounds(464, 162, 40, 24);
		add(passwordLabel);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(525, 162, 193, 24);
		add(password);
		
		JButton inquiryButton = new JButton("物流信息查询");
		inquiryButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			frame.setContentPane(new TransitInfoInqPanel(frame));
		}
		});
		inquiryButton.setFont(new Font("宋体", Font.PLAIN, 20));
		inquiryButton.setBounds(493, 233, 199, 24);
		add(inquiryButton);

	}
}
