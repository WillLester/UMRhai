package edu.nju.umr.ui.utility;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SuccessPanel extends JPanel{
	private JFrame frame;
	private int x,y;
	public SuccessPanel(JFrame fr){
		frame=fr;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.fillRect(x, y-16, frame.getWidth()/6, frame.getHeight()/6);
		g.setColor(Color.white);
		g.drawString("操作成功!", x, y);
	}
	public void show()
	{
		y=frame.getY()+frame.getHeight()-50-frame.getHeight()/6;
		x=frame.getX()+frame.getWidth();
		for(int i=0;i<=30;i++)
		{
			x=x-7;
			try
			{
				Thread.sleep(50);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			repaint();
		}
		
		for(int i=0;i<=30;i++)
		{
			x=x+7;
			try
			{
				Thread.sleep(50);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			repaint();
		}
	}
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setSize(1200,800);
		frame.setLayout(null);
		SuccessPanel panel= new SuccessPanel(frame);
		frame.setContentPane(panel);
		frame.setVisible(true);
		panel.show();
		frame.remove(panel);
	}

}
