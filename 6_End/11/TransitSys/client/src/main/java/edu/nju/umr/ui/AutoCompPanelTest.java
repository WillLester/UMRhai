package edu.nju.umr.ui;

import java.util.ArrayList;

import javax.swing.JFrame;

public class AutoCompPanelTest {
public static void main(String[] args){
	AutoCompPanel p =new AutoCompPanel();
	p.setBounds(10, 10, 100, 24);
	JFrame frame=new JFrame();
	frame.setLayout(null);
	frame.setSize(1200,800);
	frame.add(p);
	frame.setVisible(true);
	ArrayList<String> ar =new ArrayList<String>();
	ar.add("1111");
	ar.add("1112");
	ar.add("2111");
	ar.add("2222");
	ar.add("2333");
	p.setAllItem(ar);
	
}
}
