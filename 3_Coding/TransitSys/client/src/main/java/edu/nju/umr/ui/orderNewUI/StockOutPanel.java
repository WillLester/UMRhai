package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderNewLogic.StockOutOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.StockOutOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Hints;
import edu.nju.umr.ui.utility.Utility;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockOutVO;

public class StockOutPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4807982962712921033L;
	private JTextField expressField;
	private JTextField transitIdField;
	private JComboBox<String> targetCombo;
	private JComboBox<String> transitCombo;
	private JFrame frame;
	private DatePanel datePanel;
	private StockOutOrderLSer logicSer;
	private String name;
	private String orgId;
	private String userId;
	private JTextField idField;
	/**
	 * Create the panel.
	 */
	public StockOutPanel(JFrame fr,StockOutVO vo)
	{
		this(fr,vo.getOpName(),vo.getStockId(),vo.getUserId());
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		expressField.setText(vo.getExpressId());
		transitIdField.setText(vo.getTransitId());
		targetCombo.setSelectedItem(vo.getArrivePlace());
		transitCombo.setSelectedItem(EnumTransFactory.checkTransit(vo.getKind()));
		datePanel.setDate(vo.getDate());
		
	}
	/**
	 * @wbp.parser.constructor
	 */
	public StockOutPanel(JFrame fr,String name,String orgId,String userId) {
		setLayout(null);
		frame=fr;
		logicSer = new StockOutOrderLogic();
		this.name = name;
		this.orgId = orgId;
		this.userId=userId;
		
		JLabel titleLabel = new JLabel("出库单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titleLabel.setBounds(392, 10, 243, 67);
		add(titleLabel);
		
		JLabel expressLabel = new JLabel("快递编号");
		expressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		expressLabel.setBounds(355, 124, 120, 24);
		add(expressLabel);
		
		expressField = new JTextField();
		expressField.setFont(new Font("宋体", Font.PLAIN, 20));
		expressField.setBounds(485, 124, 165, 25);
		add(expressField);
		expressField.setColumns(10);
		
		JLabel dateLabel = new JLabel("出库日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		dateLabel.setBounds(298, 170, 120, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(449, 170, 285, 26);
		add(datePanel);
		
		String targetList[] = null;
		ResultMessage result = logicSer.getOrgs();
		if(result.getReInfo() == Result.SUCCESS){
			targetList = (String[]) result.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(result.getReInfo(), frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			
		}
		JLabel targetLabel = new JLabel("目的地");
		targetLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		targetLabel.setBounds(251, 213, 85, 24);
		add(targetLabel);
		
		targetCombo = new JComboBox<String>();
		targetCombo.setFont(new Font("黑体", Font.PLAIN, 15));
		targetCombo.setModel(new DefaultComboBoxModel<String>(targetList));
		targetCombo.setBounds(334, 214, 183, 25);
		add(targetCombo);
		
		JLabel transitLabel = new JLabel("装运形式");
		transitLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		transitLabel.setBounds(541, 214, 85, 24);
		add(transitLabel);
		
		transitCombo = new JComboBox<String>();
		transitCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		transitCombo.setBounds(636, 214, 87, 25);
		transitCombo.setModel(new DefaultComboBoxModel<String>(new String[]{"飞机","铁路","公路"}));
		add(transitCombo);
		
		JLabel transitIdLabel = new JLabel("中转单/汽运编号");
		transitIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transitIdLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
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
					DoHint.hint(result, frame,true);
					if(result.equals(Result.SUCCESS)){
						confirmButton.setEnabled(false);
					}
				}
			}
		});
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setName("cancel");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(541, 434, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancelButton);
		
		JLabel idLabel = new JLabel("出库单编号");
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idLabel.setBounds(355, 87, 120, 24);
		add(idLabel);
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(485, 87, 165, 25);
		idField.setEnabled(false);
		add(idField);
		idField.setColumns(10);
		
		if(orgId!=null)
		{
			ResultMessage messagee=logicSer.getNextId(orgId);
			Result resultt=messagee.getReInfo();
			if(!resultt.equals(Result.SUCCESS))
			{
				DoHint.hint(resultt, frame);
			}
			else
			{
				int num=(Integer)messagee.getMessage();
				String temp=Integer.toString(num);
				while(temp.length()<5)
				{
					temp="0"+temp;
				}
				idField.setText(orgId+DateFormat.DATESTRING.format(Calendar.getInstance().getTime())+temp);
			}
		}
	}
	@SuppressWarnings("unused")
	private boolean isLegal(){
		if(datePanel.getCalendar().after(Calendar.getInstance())){
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
		if(!logicSer.isExpressValid(expressField.getText())){
			DoHint.hint("快递单不存在！", frame);
			return false;
		}
		return true;
	}
	private StockOutVO createVO(){
		Transit transits[] = Transit.values();
		StockOutVO vo = new StockOutVO(idField.getText(),expressField.getText(), datePanel.getCalendar(), transits[transitCombo.getSelectedIndex()], 
				(String) targetCombo.getSelectedItem(),transitIdField.getText(), name, orgId,userId);
		return vo;
	}
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(enabled);
		}
	}

}
