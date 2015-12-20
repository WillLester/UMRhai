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

public class ExcitedFrame extends JFrame {

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
	
	public ExcitedFrame(int width,int height){
		setLayout(null);
		setUndecorated(true);
		setSize(width,height);
		close.setNewImages("close", "closeSt", "closeP");
		toMin.setNewImages("mini", "miniSt", "miniP");
		toMax.setIcon(new ImageIcon("ui/button/maxP.png"));
		
		getContentPane().add(close);
		getContentPane().add(toMin);
		getContentPane().add(toMax);
		
		close.setBounds(width-50, 0, 50, 50);
		toMax.setBounds(width-50*2, 0, 50, 50);
		toMin.setBounds(width-50*3, 0, 50, 50);
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
	
	protected void setDragable(final ExcitedFrame ef){
		this.addMouseListener(new MouseAdapter(){
			@SuppressWarnings("unused")
			public void MouseReleased(MouseEvent e){
				isMoved=false;//鼠标释放后不能进行拖拽
				ef.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@SuppressWarnings("unused")
			public void MousePressed(MouseEvent e){
				isMoved=true;
				pre=new Point(e.getX(),e.getY());//得到鼠标按下的位置
				ef.setCursor(new Cursor(Cursor.MOVE_CURSOR));
			}
		});
		//拖动时坐标减去鼠标按下去的坐标，是界面要移动的向量
		this.addMouseMotionListener(new MouseMotionAdapter(){
			@SuppressWarnings("unused")
			public void MouseDragged(MouseEvent e){
				if(isMoved){
					end=new Point(ef.getLocation().x+e.getX()-pre.x,ef.getLocation().y+e.getY()-pre.y);
					ef.setLocation(end);
				}
			}
		});
	}
	
	public static void main(String[] args){
		ExcitedFrame frame=new ExcitedFrame(1000,700);
	}
}
