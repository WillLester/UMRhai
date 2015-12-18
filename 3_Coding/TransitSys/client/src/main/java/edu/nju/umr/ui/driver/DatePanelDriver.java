package edu.nju.umr.ui.driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import edu.nju.umr.ui.DateTimePanel;

public class DatePanelDriver {
	public void drive(){
		JFrame frame=new JFrame();
		DateTimePanel p=new DateTimePanel();
		p.setBounds(20, 20, 700, 200);
		frame.setLayout(null);
		frame.setSize(1200,800);
		frame.add(p);
		JButton button=new JButton("按一按");
		button.setBounds(500, 500, 30, 30);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(p.getCalendar().toString());
			}
			
		});
		frame.add(button);
		frame.setVisible(true);
	}
	public static void main(String[] args){
		DatePanelDriver dd=new DatePanelDriver();
		dd.drive();
	}
}
