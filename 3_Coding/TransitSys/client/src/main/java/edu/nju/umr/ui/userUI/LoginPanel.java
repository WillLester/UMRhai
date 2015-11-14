package edu.nju.umr.ui.userUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

import edu.nju.umr.logicService.userLogicSer.LoginLSer;
import edu.nju.umr.logic.userLogic.LoginLogic;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.userPanel.*;
import edu.nju.umr.ui.transitInfoUI.TransitInfoInqPanel;

public class LoginPanel extends JPanel {
	private JTextField id;
	private JTextField password;
	private JFrame frame;
	/**
	 * Create the panel.
	 */
	public LoginPanel(JFrame fr) {
		setLayout(null);
		this.frame=fr;
		this.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		
		JLabel lblNewLabel = new JLabel("快递物流系统");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(464, 10, 242, 67);
		add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("账号");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(464, 104, 40, 24);
		add(lblNewLabel_3);
		
		id = new JTextField();
		id.setBounds(525, 107, 193, 24);
		add(id);
		id.setColumns(10);
		
		JButton button = new JButton("登陆");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginLSer log=new LoginLogic();
				ResultMessage re=log.login(id.getText(), password.getText());
				if(re.getReInfo()==Result.SUCCESS)
				{
					UserVO user=(UserVO)re.getMessage();
					System.out.println(user.getJuri());
					switch(user.getJuri())
					{
					case COURIER:frame.setContentPane(new CourierPanel(user));break;
					case HALL:frame.setContentPane(new BusinessHallPanel(user));break;
					case CENTER:frame.setContentPane(new TransitCenterPanel(user));break;
					case STOCK:frame.setContentPane(new StockManagerPanel(user));break;
					case FINANCE_SUPE:frame.setContentPane(new FinanceSuperPanel(user));break;
					case FINANCE:frame.setContentPane(new FinancePanel(user));break;
					case MANAGER:frame.setContentPane(new ManagerPanel(user));break;
					case ADMIN:frame.setContentPane(new AdministerPanel(user));break;
					}
				}
				else
				{
					if(re.getReInfo()==Result.ID_WRONG)
					{
						new HintFrame("账号不存在!",(frame.getWidth()-HintFrame.FRAME_WIDTH)/2,(frame.getHeight()-HintFrame.FRAME_HEIGHT)/2);
					}
					if(re.getReInfo()==Result.PASSWORD_WRONG)
					{
						new HintFrame("密码错误!",(frame.getWidth()-HintFrame.FRAME_WIDTH)/2,(frame.getHeight()-HintFrame.FRAME_HEIGHT)/2);
					}
					if(re.getReInfo()==Result.NET_INTERRUPT)
					{
						new HintFrame("网络异常!",(frame.getWidth()-HintFrame.FRAME_WIDTH)/2,(frame.getHeight()-HintFrame.FRAME_HEIGHT)/2);
					}
				}
				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		button.setBounds(464, 295, 93, 23);
		add(button);
		
		JButton button_1 = new JButton("关闭");
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
				
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(625, 295, 93, 23);
		add(button_1);
		
		JLabel label = new JLabel("密码");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(464, 162, 40, 24);
		add(label);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(525, 162, 193, 24);
		add(password);
		
		JButton button_2 = new JButton("物流信息查询");
		button_2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e)
		{
			frame.setContentPane(new TransitInfoInqPanel());
		}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 20));
		button_2.setBounds(493, 233, 199, 24);
		add(button_2);

	}
}
