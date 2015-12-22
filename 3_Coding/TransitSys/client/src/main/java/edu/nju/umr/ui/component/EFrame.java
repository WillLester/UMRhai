package edu.nju.umr.ui.component;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class EFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Button close=new Button();
	private Button toMin=new Button();
	private Button toMax=new Button();
	private boolean isMoved=false;
	private Point pre=null;
	private Point end=null;
	
	public EFrame(int width,int height){
		setLayout(null);
		setUndecorated(true);
		setSize(width,height);
//		setAlwaysOnTop(true);
		
		close.setNewImages("close", "closeSt", "closeP");
		toMin.setNewImages("mini", "miniSt", "miniP");
		toMax.setIcon(new ImageIcon("ui/button/maxP.png"));
		
		close.setBounds(width-30, 0, 30, 30);
		toMax.setBounds(width-30*2, 0, 30, 30);
		toMin.setBounds(width-30*3, 0, 30, 30);
		setVisible(true);
		setDragable(this);
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
			
		});
		
		toMin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setExtendedState(ICONIFIED);	
			}	
		});
		
	}
	
	protected void setDragable(EFrame ef){
		ef.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e) {  
                isMoved = false;// 鼠标释放了以后，是不能再拖拽的了  
                ef.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  
            }  
			public void mousePressed(MouseEvent e){
				isMoved=true;
				pre=new Point(e.getX(),e.getY());//得到鼠标按下的位置
				ef.setCursor(new Cursor(Cursor.MOVE_CURSOR));
			}
			
		});
		//拖动时坐标减去鼠标按下去的坐标，是界面要移动的向量
		this.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				if(isMoved){
					end=new Point(ef.getLocation().x+e.getX()-pre.x,ef.getLocation().y+e.getY()-pre.y);
					ef.setLocation(end);
				}
			}
		});
	}
	public void setAttach(){
		getContentPane().add(close);
		getContentPane().add(toMin);
		getContentPane().add(toMax);
	}
//	public static void main(String[] args){
//		ExcitedFrame ef=new ExcitedFrame(1200,700);
//	}
}
