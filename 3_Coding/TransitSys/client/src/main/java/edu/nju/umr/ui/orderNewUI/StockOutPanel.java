package edu.nju.umr.ui.orderNewUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.logic.orderNewLogic.StockOutOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.StockOutOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.ui.utility.Hints;
import edu.nju.umr.ui.utility.Utility;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockOutVO;

public class StockOutPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6797076136600769054L;
	private JTextField expressField;
	private JTextField transitIdField;
	private JComboBox<String> cityCombo;
	private JComboBox<String> transitCombo;
	private JFrame frame;
	private DatePanel datePanel;
	private StockOutOrderLSer logicSer;
	private String name;
	private String orgId;
	/**
	 * Create the panel.
	 */
	public StockOutPanel(JFrame fr,String name,String orgId) {
		setLayout(null);
		frame=fr;
		logicSer = new StockOutOrderLogic();
		this.name = name;
		this.orgId = orgId;
		
		JLabel titleLabel = new JLabel("出库单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setBounds(392, 10, 243, 67);
		add(titleLabel);
		
		JLabel expressLabel = new JLabel("快递编号");
		expressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		expressLabel.setBounds(355, 87, 120, 24);
		add(expressLabel);
		
		expressField = new JTextField();
		expressField.setFont(new Font("宋体", Font.PLAIN, 20));
		expressField.setBounds(485, 87, 165, 25);
		add(expressField);
		expressField.setColumns(10);
		
		JLabel dateLabel = new JLabel("出库日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dateLabel.setBounds(297, 134, 120, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(452, 134, 285, 26);
		add(datePanel);
		
		String cityList[] = null;
		ResultMessage result = logicSer.getCities();
		if(result.equals(Result.SUCCESS)){
			cityList = (String[]) result.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(result.getReInfo(), frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			
		}
		JLabel cityLabel = new JLabel("目的地");
		cityLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		cityLabel.setBounds(355, 179, 85, 24);
		add(cityLabel);
		
		cityCombo = new JComboBox<String>();
		cityCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		cityCombo.setModel(new DefaultComboBoxModel<String>(cityList));
		cityCombo.setBounds(431, 179, 87, 25);
		add(cityCombo);
		
		JLabel transitLabel = new JLabel("装运形式");
		transitLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		transitLabel.setBounds(541, 179, 85, 24);
		add(transitLabel);
		
		transitCombo = new JComboBox<String>();
		transitCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		transitCombo.setBounds(634, 179, 87, 25);
		transitCombo.setModel(new DefaultComboBoxModel<String>(new String[]{"飞机","铁路","公路"}));
		add(transitCombo);
		
		JLabel transitIdLabel = new JLabel("中转单/汽运编号");
		transitIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transitIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		transitIdLabel.setBounds(315, 282, 160, 24);
		add(transitIdLabel);
		
		transitIdField = new JTextField();
		transitIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		transitIdField.setColumns(10);
		transitIdField.setBounds(485, 281, 233, 25);
		add(transitIdField);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(347, 434, 93, 23);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					Result result = logicSer.create(createVO());
					if(result.equals(Result.SUCCESS)){
						
					} else {
						@SuppressWarnings("unused")
						HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
					}
				}
			}
		});
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(541, 434, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancelButton);
	}
	@SuppressWarnings("unused")
	private boolean isLegal(){
		if(Utility.isOutOfDate(datePanel.getCalendar())){
			HintFrame hint = new HintFrame(Hints.OUT_OF_DATE, frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		String expressResult = CheckLegal.isExpressLegal(expressField.getText());
		if(expressResult != null){
			HintFrame hint = new HintFrame(expressResult, frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		if(transitIdField.getText().equals("")){
			HintFrame hint = new HintFrame("中转单或汽运编号未输入！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		if(!Utility.isNumberic(transitIdField.getText())){
			HintFrame hint = new HintFrame("中转单或汽运编号含有非数字字符！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		} else if((transitIdField.getText().length() != 19)&&(transitIdField.getText().length() != 20)){
			HintFrame hint = new HintFrame("中转单或汽运编号长度错误！", frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		return true;
	}
	private StockOutVO createVO(){
		Transit transits[] = Transit.values();
		StockOutVO vo = new StockOutVO(expressField.getText(), datePanel.getCalendar(), transits[transitCombo.getSelectedIndex()], (String) cityCombo.getSelectedItem(),transitIdField.getText(), name, orgId);
		return vo;
	}
}
