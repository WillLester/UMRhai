package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.logic.orderNewLogic.CenterLoadingOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.CenterLoadingOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.ExpressListPanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.CenterLoadingVO;

public class CenterLoadingPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7266319701610335832L;
	private JTextField transitIdField;
	private JTextField supervisionField;
	private JTextField escortField;
	private JTextField vanIdField;
//	private JTextField expressField;
//	private JList<String> expressList;
	private JFrame frame;
	private CenterLoadingOrderLSer logicSer;
	private DatePanel datePanel;
	private JTextField costField;
	private JComboBox<String> arriveCombo;
//	private DefaultListModel<String> model;
	private String name;
	private ExpressListPanel expressList;
	/**
	 * Create the panel.
	 */
	public CenterLoadingPanel(JFrame fr,String name) {
		setLayout(null);
		
		JLabel titleLabel = new JLabel("中转中心装车单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setBounds(392+75, 10, 243, 67);
		add(titleLabel);
		frame = fr;
		logicSer = new CenterLoadingOrderLogic();
		this.name = name;
		
		JLabel transitIdLabel = new JLabel("汽运编号");
		transitIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transitIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		transitIdLabel.setBounds(355+75, 87, 120, 24);
		add(transitIdLabel);
		
		transitIdField = new JTextField();
		transitIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		transitIdField.setBounds(485+75, 87, 165, 25);
		add(transitIdField);
		transitIdField.setColumns(10);
		
		JLabel dateLabel = new JLabel("装车日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dateLabel.setBounds(297+75, 121, 120, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(522, 121, 285, 26);
		add(datePanel);
		
		JLabel arriveLabel = new JLabel("到达地");
		arriveLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		arriveLabel.setBounds(242+75, 155, 85, 24);
		add(arriveLabel);
		
		arriveCombo = new JComboBox<String>();
		arriveCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		arriveCombo.setBounds(307+75, 155, 87, 25);
		ResultMessage message = logicSer.getHalls();
		if(message.getReInfo().equals(Result.SUCCESS)){
			String halls[] = (String[]) message.getMessage();
			arriveCombo.setModel(new DefaultComboBoxModel<String>(halls));;
		} else {
			hint(message.getReInfo());
		}
		add(arriveCombo);
		
		JLabel supervisionLabel = new JLabel("监装员");
		supervisionLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		supervisionLabel.setBounds(421+75, 157, 85, 24);
		add(supervisionLabel);
		
		supervisionField = new JTextField();
		supervisionField.setFont(new Font("宋体", Font.PLAIN, 20));
		supervisionField.setColumns(10);
		supervisionField.setBounds(485+75, 157, 85, 25);
		add(supervisionField);
		
		JLabel escortLabel = new JLabel("押运员");
		escortLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		escortLabel.setBounds(609+75, 157, 85, 24);
		add(escortLabel);
		
		escortField = new JTextField();
		escortField.setFont(new Font("宋体", Font.PLAIN, 20));
		escortField.setColumns(10);
		escortField.setBounds(674+75, 158, 85, 25);
		add(escortField);
		
		JLabel vanIdLabel = new JLabel("车辆代号");
		vanIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vanIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		vanIdLabel.setBounds(220+75, 204, 120, 24);
		add(vanIdLabel);
		
		vanIdField = new JTextField();
		vanIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		vanIdField.setColumns(10);
		vanIdField.setBounds(328+75, 203, 165, 25);
		add(vanIdField);
		
		JLabel costLabel = new JLabel("运费：");
		costLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		costLabel.setBounds(674, 204, 60, 24);
		add(costLabel);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(342+75, 499, 93, 23);
		add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					Result result = logicSer.create(createVO());
					if(result.equals(Result.SUCCESS)){
						
					} else {
						hint(result);
					}
				}
			}
		});
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(542+75, 499, 93, 23);
		cancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				frame.dispose();
			}
		});
		add(cancelButton);
		
		costField = new JTextField();
		costField.setEditable(false);
		costField.setBounds(731, 208, 66, 21);
		add(costField);
		costField.setColumns(10);
		
		expressList = new ExpressListPanel(frame);
		expressList.setBounds(frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
		add(expressList);
	}
	private void hint(Result result){
		@SuppressWarnings("unused")
		HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
	}
	private void hint(String hint){
		@SuppressWarnings("unused")
		HintFrame hintF = new HintFrame(hint, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
	}
//	private boolean isExpressLegal(){
//		String info = CheckLegal.isExpressLegal(expressField.getText());
//		if(!info.equals(null)){
//			hint(info);
//			return false;
//		}
//		return true;
//	}
	private CenterLoadingVO createVO(){
		ArrayList<String> expresses = expressList.getExpresses();
		CenterLoadingVO vo = new CenterLoadingVO(datePanel.getCalendar(), (String)arriveCombo.getSelectedItem(), vanIdField.getText(), supervisionField.getText(), escortField.getText(), expresses, Double.parseDouble(costField.getText()), name);
		return vo;
	}
	private boolean isLegal(){
		String info = CheckLegal.isTransitLegal(transitIdField.getText());
		if(!info.equals(null)){
			hint(info);
			return false;
		}
		if(supervisionField.getText().equals("")){
			hint("监装员未输入！");
			return false;
		}
		if(escortField.getText().equals("")){
			hint("押运员未输入！");
			return false;
		}
		if(vanIdField.getText().equals("")){
			hint("车辆代号未输入！");
			return false;
		}
		if(expressList.isEmpty()){
			hint("订单号未输入！");
			return false;
		}
		return true;
	}
}
