package edu.nju.umr.ui.userPanel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.nju.umr.logic.orderApproveLogic.OrderResubmitLogic;
import edu.nju.umr.logicService.orderApproveLogicSer.OrderResubmitLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.orderApproveUI.OrderRevisePanel;
import edu.nju.umr.vo.ResultMessage;

public class UnpassedOrderMessagePanel extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5981143743109420285L;
	private int x;
	private String userId;
	private OrderResubmitLSer serv;
	private Thread thread;
	public UnpassedOrderMessagePanel(){
		
	}
	public UnpassedOrderMessagePanel(String userId){
		x=0;
		this.userId=userId;
		serv=new OrderResubmitLogic();
		
		this.setLayout(null);
		JButton button = new JButton("查看未通过单据");
		button.setBounds(0, 0, 150, 30);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				FunctionFrame frame=new FunctionFrame("查看未通过单据");
				frame.setContentPane(new OrderRevisePanel(frame,userId));
			}
		});
		add(button);
		
		thread=new Thread(this);
//		thread.start();
	}
	public void run(){
		while(true)
		{
			try{
				Thread.sleep(5000);
				ResultMessage message=serv.getUnpassed(userId);
				if(message.getReInfo().equals(Result.SUCCESS))
				{
					x=(Integer)message.getMessage();
				}
				repaint();
			}catch(Exception e)
			{
				
			}
		}
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawString(Integer.toString(x), 150, 20);
	}
	public void stop(){
		thread.interrupt();
	}
//	public static void main(String [] args)
//	{
//		JFrame frame=new JFrame();
//		frame.setContentPane(new UnpassedOrderMessagePanel(null));
//		frame.setSize(1200,800);
//		frame.setVisible(true);
//	}
}
