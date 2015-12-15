package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import edu.nju.umr.logic.orderNewLogic.CenterLoadingOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.CenterLoadingOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.ExpressListPanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.CenterLoadingVO;

public class CenterLoadingPanel extends JPanel implements PriceCount{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6510869696757978208L;
	private JTextField transitIdField;
	private JTextField supervisionField;
	private JTextField escortField;
	private JTextField vanIdField;
	private JFrame frame;
	private CenterLoadingOrderLSer logicSer;
	private DatePanel datePanel;
	private JTextField costField;
	private JComboBox<String> arriveCombo;
	private String name;
	private ExpressListPanel expressList;
	private String userId;
	private String org;
	/**
	 * Create the panel.
	 */
	public CenterLoadingPanel(JFrame fr,CenterLoadingVO vo)
	{
		this(fr,vo.getOpName(),vo.getUserId(),null,null);
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		transitIdField.setText(vo.getTransitId());
		supervisionField.setText(vo.getSupervision());
		escortField.setText(vo.getEscort());
		vanIdField.setText(vo.getVanId());
		datePanel.setDate(vo.getDate());
		costField.setText(Double.toString(vo.getCost()));
		arriveCombo.setSelectedItem((String)vo.getTarget());
		expressList.showExpressList(vo.getExpress());
	}
	/**
	 * @wbp.parser.constructor
	 */
	public CenterLoadingPanel(JFrame fr,String name,String userId,String org,String orgId) {
		setLayout(null);
		JLabel titleLabel = new JLabel("中转中心装车单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setBounds(392+75, 10, 243, 67);
		add(titleLabel);
		frame = fr;
		logicSer = new CenterLoadingOrderLogic();
		this.name = name;
		this.userId = userId;
		this.org = org;
		
		JLabel transitIdLabel = new JLabel("汽运编号");
		transitIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		transitIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		transitIdLabel.setBounds(355+75, 87, 120, 24);
		add(transitIdLabel);
		
		transitIdField = new JTextField();
		transitIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		transitIdField.setBounds(560, 87, 190, 25);
		transitIdField.setEditable(false);
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
		arriveLabel.setBounds(278, 155, 85, 24);
		add(arriveLabel);
		
		arriveCombo = new JComboBox<String>();
		arriveCombo.setFont(new Font("黑体", Font.PLAIN, 15));
		arriveCombo.setBounds(342, 155, 150, 25);
		ResultMessage message = logicSer.getHalls();
		if(message.getReInfo().equals(Result.SUCCESS)){
			String halls[] = (String[]) message.getMessage();
			arriveCombo.setModel(new DefaultComboBoxModel<String>(halls));;
		} else {
			hint(message.getReInfo());
		}
		arriveCombo.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent e) {
			getPrice();
		}});
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
		
		JLabel costLabel = new JLabel("运费/元");
		costLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		costLabel.setBounds(655, 204, 79, 24);
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
					DoHint.hint(result, frame,true);
					if(result.equals(Result.SUCCESS)){
						confirmButton.setEnabled(false);
					}
				}
			}
		});
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setName("cancel");
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
		costField.setEnabled(false);
		add(costField);
		costField.setColumns(10);
		
		expressList = new ExpressListPanel(frame,this);
		expressList.setBounds(266, 216, 677, 273);
		add(expressList);
		
		if(orgId!=null){
			message = logicSer.getNextId(orgId);
			Result result=message.getReInfo();
			if(result.equals(Result.SUCCESS))
			{
				int num=(Integer)message.getMessage();
				if(num==-1)
				{
					DoHint.hint(Result.DATABASE_ERROR, frame);
				}
				else
				{
					String temp=Integer.toString(num);
					while(temp.length()<5)
					{
						temp="0"+temp;
					}
					temp=orgId+DateFormat.DATESTRING.format(Calendar.getInstance().getTime())+temp;
					transitIdField.setText(temp);
				}
			}
		}
	}
	private void hint(Result result){
		@SuppressWarnings("unused")
		HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
	}
	private void hint(String hint){
		@SuppressWarnings("unused")
		HintFrame hintF = new HintFrame(hint, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
	}
	private CenterLoadingVO createVO(){
		ArrayList<String> expresses = expressList.getExpresses();
		CenterLoadingVO vo = new CenterLoadingVO(datePanel.getCalendar(), transitIdField.getText(),(String)arriveCombo.getSelectedItem(), vanIdField.getText(), 
				supervisionField.getText(), escortField.getText(), 
				expresses, Double.parseDouble(costField.getText()), name,userId);
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
	public void getPrice(){
		ResultMessage message=logicSer.getPrice(org,(String)arriveCombo.getSelectedItem(),expressList.getExpresses());
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			DoHint.hint(result, frame);
			return;
		}
		BigDecimal price=(BigDecimal)message.getMessage();
		costField.setText(price.toString());
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
