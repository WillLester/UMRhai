package edu.nju.umr.ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SuccessPanel extends JPanel implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7114950449550231951L;
	private int x,y;
	private SuccessThread thread;
	private JFrame frame;
	private boolean toClose;
	public SuccessPanel(JFrame frame){
		this(frame,false);
	}
	public SuccessPanel(JFrame frame,boolean close){
		this.frame=frame;
		x=frame.getWidth()/6;
		y=frame.getHeight()/6;
		setBounds(x*6,y*5-50,x,y);
		toClose=close;
		thread=new SuccessThread(this);
		thread.start();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		ImageIcon success = new ImageIcon("ui/frame/success.png");
		success = new ImageIcon(success.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
		g.drawImage(success.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
	public void run(){
		int changeX=x/100+1;
		while(this.getX()+x>frame.getWidth()){
			try{
				SuccessThread.sleep(2);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
			this.setBounds(this.getX()-changeX,this.getY(), x, y);
			if(frame.isVisible()){
				frame.setVisible(true);
			}
			repaint();
		}
		try{
			SuccessThread.sleep(200);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
		while(this.getX()<frame.getWidth()){
			try {
				SuccessThread.sleep(2);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			this.setBounds(this.getX()+changeX,this.getY(), x, y);
			if(frame.isVisible()){
				frame.setVisible(true);
			}
			repaint();
		}
		frame.remove(this);
		if(toClose)frame.dispose();
	}
	
	private class SuccessThread extends Thread{
		public SuccessThread(SuccessPanel panel) {
			// TODO 自动生成的构造函数存根
			super(panel);
		}
	}
}
