package edu.nju.umr.ui.userPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.orderNewUI.ExpressPanel;
import edu.nju.umr.ui.orderNewUI.ReceivePanel;
import edu.nju.umr.ui.transitInfoUI.ExpressInfoInqPanel;
import edu.nju.umr.vo.UserVO;


public class CourierPanel extends UserPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4332309242600582994L;

	public CourierPanel(UserVO user,JFrame fr) {
		
		super(user,fr);
		
		JButton receive = new JButton("收件");
		receive.setFont(new Font("宋体", Font.PLAIN, 12));
		receive.setBounds(314, 227, 93, 83);
		receive.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("收件信息输入");
				ffr.setContentPane(new ReceivePanel(ffr,user.getOrg(),user.getName()));
			}
		});
		this.add(receive);
		
		JButton button = new JButton("订单查询");
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		button.setBounds(505, 227, 93, 83);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("订单查询");
				ffr.setContentPane(new ExpressInfoInqPanel(ffr));
			}
		});
		this.add(button);
		
		JButton button_1 = new JButton("订单创建");
		button_1.setFont(new Font("宋体", Font.PLAIN, 12));
		button_1.setBounds(695, 227, 93, 83);
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("订单创建");
				ffr.setContentPane(new ExpressPanel(ffr,user.getName(),user.getId(),user.getOrg()));
			}
		});
		this.add(button_1);
		
		UnpassedOrderMessagePanel upo = new UnpassedOrderMessagePanel(user.getId());
		upo.setBounds(853, 10, 200, 30);
		add(upo);
	}

}

