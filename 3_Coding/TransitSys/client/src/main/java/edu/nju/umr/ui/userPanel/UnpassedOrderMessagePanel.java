package edu.nju.umr.ui.userPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import edu.nju.umr.logic.orderApproveLogic.OrderResubmitLogic;
import edu.nju.umr.logicService.orderApproveLogicSer.OrderResubmitLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.component.Button;
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
		this.setBackground(Color.WHITE);
		this.userId=userId;
		serv=new OrderResubmitLogic();
		
		this.setLayout(null);
		Button button = new Button();
		button.setNewImages("buttonUnpassed", "buttonUnpassedSt", "buttonUnpassedP");
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
		thread.start();
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
		if(x==0)return;
		String temp=Integer.toString(x);
		if(x>9){
			temp="9+";
		}
		try{
			File file=new File("ui/button/unpassedNum.png");
			BufferedImage img=ImageIO.read(file);
			g.drawImage(img, 152, 5, null);
			if(x>9){
				g.drawImage(img, 155, 5, null);
				g.drawImage(img, 159, 5, null);
			}
		}catch(Exception e){
			g.setColor(Color.red);
			g.fillOval(152, 5, 20, 20);
		}
		g.setColor(Color.white);
		g.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		x=9;
		g.drawString(temp, 158, 21);
	}
	public void stop(){
		thread.interrupt();
	}
}
