package edu.nju.umr.ui.utility;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SuccessPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7114950449550231951L;
	private JPanel fa;
	private int x,y;
	private int locx,locy;
	public SuccessPanel(JPanel panel){
		System.out.println(panel.getWidth()+" "+panel.getHeight());
		fa=panel;
		x=fa.getWidth()*5/6;
		y=fa.getHeight()*5/6-50;
		setBounds(x,y,fa.getWidth()/6,fa.getHeight()/6);
		
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.fillRect(locx, locy-16, fa.getWidth()/6, fa.getHeight()/6);
		g.setColor(Color.white);
		g.drawString("操作成功!", locx,locy+60);
	}
	public void show()
	{
		locx=getWidth();
		locy=0;
		for(int i=0;i<=30;i++)
		{
			locx=locx-fa.getWidth()/6/30;
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
			locx=locx+fa.getWidth()/6/30;
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
//	public static void main(String [] args)
//	{
//		JFrame frame=new JFrame();
//		frame.setSize(1200,800);
//		frame.setLocation(10, 10);
//		JPanel panel=new JPanel();
//		frame.setContentPane(panel);
//		frame.setVisible(true);
//		SuccessPanel suc=new SuccessPanel(panel);
//		panel.setLayout(null);
//		panel.add(suc);
//		suc.show();
//		panel.remove(suc);
//	}

}
