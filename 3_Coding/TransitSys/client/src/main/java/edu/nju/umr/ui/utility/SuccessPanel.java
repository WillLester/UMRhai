package edu.nju.umr.ui.utility;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SuccessPanel extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7114950449550231951L;
	private int x,y;
	private Thread thread;
	private JFrame frame;
	public SuccessPanel(JFrame frame){
		this.frame=frame;
		x=frame.getWidth()/6;
		y=frame.getHeight()/6;
		setBounds(x*6,y*5-50,x,y);
		thread=new Thread(this);
		thread.start();
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.fillRect(0,0, x, y);
		g.setColor(Color.white);
		g.drawString("操作成功!", 0,60);
	}
	public void run()
	{
		int changeX=x/30;
		for(int i=0;i<=30;i++)
		{
			try
			{
				Thread.sleep(50);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			this.setBounds(this.getX()-changeX,this.getY(), x, y);
			if(frame.isVisible())
			{
				frame.setVisible(true);
			}
			repaint();
		}
		
		for(int i=0;i<=30;i++)
		{
			try
			{
				Thread.sleep(50);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			this.setBounds(this.getX()+changeX,this.getY(), x, y);
			if(frame.isVisible())
			{
				frame.setVisible(true);
			}
			repaint();
		}
		frame.remove(this);
	}
}
