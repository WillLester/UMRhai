package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;

public class ReceivePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3052576244031029859L;
	private JTextField receiverField;
	private JTextField idField;
	private JFrame frame;
	private DatePanel datePanel;
	/**
	 * Create the panel.
	 */
	public ReceivePanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		
		JLabel titleLabel = new JLabel("收件信息输入");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setBounds(392, 42, 243, 67);
		add(titleLabel);
		
		JLabel dateLabel = new JLabel("收件日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dateLabel.setBounds(427, 293, 120, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(594, 293, 285, 26);
		add(datePanel);
		
		JLabel receiverLabel = new JLabel("收件人");
		receiverLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverLabel.setBounds(227, 293, 85, 24);
		add(receiverLabel);
		
		receiverField = new JTextField();
		receiverField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverField.setColumns(10);
		receiverField.setBounds(293, 292, 85, 25);
		add(receiverField);
		
		JLabel idLabel = new JLabel("收件编号");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		idLabel.setBounds(227, 172, 85, 24);
		add(idLabel);
		
		idField = new JTextField();
		idField.setFont(new Font("宋体", Font.PLAIN, 20));
		idField.setColumns(10);
		idField.setBounds(327, 172, 221, 25);
		add(idField);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(340, 431, 93, 23);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(isIllegal()){
					
				}
			}
		});;
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(542, 431, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancelButton);
	}
	@SuppressWarnings("unused")
	private boolean isIllegal(){
		if(receiverField.getText().equals("")){
			HintFrame hint = new HintFrame("收件人未输入！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		if(idField.getText().equals("")){
			HintFrame hint = new HintFrame("收件编号未输入！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		JFrame frame=new JFrame();
		frame.setContentPane(new ReceivePanel(frame));
		frame.setSize(1200,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
