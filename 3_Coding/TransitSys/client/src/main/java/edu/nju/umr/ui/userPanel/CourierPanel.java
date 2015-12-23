package edu.nju.umr.ui.userPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.orderNewUI.ExpressPanel;
import edu.nju.umr.ui.orderNewUI.ReceivePanel;
import edu.nju.umr.ui.transitInfoUI.ExpressInfoInqPanel;
import edu.nju.umr.vo.UserVO;


public class CourierPanel extends UserPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4332309242600582994L;
	public CourierPanel(UserVO user,MainFrame fr) {
		
		super(user,fr);
		
		Button receive = new Button();
		receive.setNewImages("courier/receive","courier/receiveSt", "courier/receiveP");
		receive.setFont(new Font("宋体", Font.PLAIN, 12));
		receive.setBounds(Constants.FIRST_X, Constants.SINGLE_Y, 95, 95);
		receive.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("收件信息输入");
				ffr.setContentPane(new ReceivePanel(ffr,user.getOrg(),user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		this.add(receive);
		
		Button expressInq = new Button();//订单查询
		expressInq.setNewImages("courier/expressNewInq", "courier/expressNewInqSt", "courier/expressNewInqP");
		expressInq.setFont(new Font("宋体", Font.PLAIN, 12));
		expressInq.setBounds(Constants.SECOND_X, Constants.SINGLE_Y, 95, 95);
		expressInq.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("订单查询");
				ffr.setContentPane(new ExpressInfoInqPanel(ffr));
				fr.sonFrames.add(ffr);
			}
		});
		this.add(expressInq);
		
		Button expressNew = new Button();
		expressNew.setNewImages("courier/expressNew", "courier/expressNewSt", "courier/expressNewP");
		expressNew.setFont(new Font("宋体", Font.PLAIN, 12));
		expressNew.setBounds(Constants.THIRD_X, Constants.SINGLE_Y, 95, 95);
		expressNew.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame ffr=new FunctionFrame("订单创建");
				ffr.setContentPane(new ExpressPanel(ffr,user.getName(),user.getId(),user.getOrgId()));
				fr.sonFrames.add(ffr);
			}
		});
		this.add(expressNew);
		
		UnpassedOrderMessagePanel upo = new UnpassedOrderMessagePanel(user.getId());
		upo.setBounds(Constants.UNPASSED_X, Constants.UNPASSED_Y, 200, 30);
		add(upo);
	}

}

