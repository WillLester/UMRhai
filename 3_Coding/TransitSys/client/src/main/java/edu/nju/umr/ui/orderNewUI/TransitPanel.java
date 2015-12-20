package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
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
import edu.nju.umr.logic.orderNewLogic.TransitOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.TransitOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.ExpressListPanel;
import edu.nju.umr.ui.stub.TransitPanelStub;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Hints;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.TransitVO;

public class TransitPanel extends JPanel implements PriceCount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3747167346049866099L;
	private JTextField idField;
	private JTextField supervisionField;
	private JTextField planeIdField;
	private JTextField containerField;
	private JComboBox<String> startCombo;
	private JComboBox<String> arriveCombo;
	private JComboBox<String> kindCombo;
	private ExpressListPanel expressList;
	private JTextField costField;
	private JFrame frame;
	private DatePanel datePanel;
	private TransitOrderLSer logicSer;
	private String name;
	private String userId;
	/**
	 * Create the panel.
	 */
	public TransitPanel(JFrame fr,TransitVO vo)
	{
		this(fr,"",vo.getOpName(),vo.getUserId(),"");
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		idField.setText(vo.getId());
		supervisionField.setText(vo.getSupervision());
		planeIdField.setText(vo.getPlaneId());
		containerField.setText(vo.getContainerId());
		startCombo.setSelectedItem(vo.getStartPlace());
		arriveCombo.setSelectedItem(vo.getArrivePlace());
		expressList.showExpressList(vo.getExpress());
		kindCombo.setSelectedIndex(vo.getTransit().ordinal());
		costField.setText(Double.toString(vo.getCost()));
		datePanel.setDate(vo.getDate());
	}
	/**
	 * @wbp.parser.constructor
	 */
	public TransitPanel(JFrame fr,String org,String name,String userId,String orgId) {
		setLayout(null);
		frame = fr;
		this.name = name;
		this.userId=userId;
		logicSer = new TransitOrderLogic();
//		logicSer = new TransitPanelStub(); 
		
		JLabel titleLabel = new JLabel("中转单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setBounds(392, 10, 243, 67);
		add(titleLabel);
		
		JLabel idLabel = new JLabel("中转单编号");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		idLabel.setBounds(355, 87, 120, 24);
		add(idLabel);
		
		idField = new JTextField();
		idField.setFont(new Font("宋体", Font.PLAIN, 20));
		idField.setBounds(485, 87, 165, 25);
		idField.setEditable(false);
		add(idField);
		idField.setColumns(10);
		
		JLabel dateLabel = new JLabel("装车日期");
		dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dateLabel.setBounds(296, 121, 120, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(452, 121, 285, 26);
		add(datePanel);
		
		JLabel startLabel = new JLabel("出发地");
		startLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		startLabel.setBounds(140, 157, 85, 24);
		add(startLabel);
		
		arriveCombo = new JComboBox<String>();
		arriveCombo.setFont(new Font("黑体", Font.PLAIN, 17));
		arriveCombo.setBounds(432, 157, 140, 25);
		arriveCombo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				getPrice();
			}
		});
		add(arriveCombo);
		
		startCombo = new JComboBox<String>();
		startCombo.setFont(new Font("黑体", Font.PLAIN, 17));
		startCombo.setBounds(214, 157, 148, 25);
		ResultMessage message = logicSer.getCenters();
		if(message.getReInfo().equals(Result.SUCCESS)){
			String[] centers = (String[]) message.getMessage();
			startCombo.setModel(new DefaultComboBoxModel<String>(centers));
			for(int i = 0;i < centers.length;i++){
				if(centers[i].equals(org)){
					startCombo.setSelectedIndex(i);
					String[] arrives = new String[centers.length - 1];
					System.arraycopy(centers, 0, arrives, 0, i);
					System.arraycopy(centers, i+1, arrives, i, centers.length - 1 - i);
					arriveCombo.setModel(new DefaultComboBoxModel<String>(arrives));
					arriveCombo.setSelectedIndex(0);
					break;
				}
			}
			if(arriveCombo.getModel().getSize() == 0){
				arriveCombo.setModel(new DefaultComboBoxModel<String>(centers));
			}
		} else {
			DoHint.hint(message.getReInfo(), frame);
		}
		startCombo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				getPrice();
			}
		});
		add(startCombo);
		
		JLabel supervisionLabel = new JLabel("监装员");
		supervisionLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		supervisionLabel.setBounds(582, 157, 85, 24);
		add(supervisionLabel);
		
		supervisionField = new JTextField();
		supervisionField.setFont(new Font("宋体", Font.PLAIN, 20));
		supervisionField.setColumns(10);
		supervisionField.setBounds(646, 157, 85, 25);
		add(supervisionField);
		
		JLabel planeIdLabel = new JLabel("航班号");
		planeIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		planeIdLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		planeIdLabel.setBounds(220, 204, 120, 24);
		add(planeIdLabel);
		
		planeIdField = new JTextField();
		planeIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		planeIdField.setColumns(10);
		planeIdField.setBounds(328, 203, 165, 25);
		add(planeIdField);
		
		JLabel costLabel = new JLabel("运费/元");
		costLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		costLabel.setBounds(661, 204, 100, 24);
		add(costLabel);
		
		costField = new JTextField();
		costField.setFont(new Font("宋体", Font.PLAIN, 20));
		costField.setBounds(748,203,165,25);
		costField.setEditable(false);
		add(costField);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(342, 499, 93, 23);
		add(confirmButton);
		confirmButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
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
		cancelButton.setBounds(542, 499, 93, 23);
		add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				frame.dispose();
			}
		});
		
		JLabel kindLabel = new JLabel("运输方式");
		kindLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		kindLabel.setBounds(741, 157, 80, 24);
		add(kindLabel);
		
		JLabel arriveLabel = new JLabel("到达地");
		arriveLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		arriveLabel.setBounds(366, 157, 85, 24);
		add(arriveLabel);
		
		JLabel containerLabel = new JLabel("货柜号");
		containerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		containerLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		containerLabel.setBounds(485, 204, 120, 24);
		add(containerLabel);
		
		containerField = new JTextField();
		containerField.setFont(new Font("宋体", Font.PLAIN, 20));
		containerField.setColumns(10);
		containerField.setBounds(582, 204, 69, 25);
		add(containerField);
		
		expressList = new ExpressListPanel(frame,this);
		expressList.setBounds(206, 212, 683, 297);
		add(expressList);
		
		kindCombo = new JComboBox<String>();
		kindCombo.setBounds(827, 157, 62, 25);
		String kind[] = {"飞机","铁路","公路"};
		kindCombo.setModel(new DefaultComboBoxModel<String>(kind));
		kindCombo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				if(e.getStateChange() == ItemEvent.SELECTED){
					if(kindCombo.getSelectedIndex() == 0){
						planeIdField.setEnabled(true);
					} else {
						planeIdField.setEnabled(false);
					}
				}
				getPrice();
			}
		});
		kindCombo.setSelectedIndex(0);
		add(kindCombo);
		
		if(orgId!=null){
			message=logicSer.getNextId(orgId);
			Result result=message.getReInfo();
			if(!result.equals(Result.SUCCESS)){
				DoHint.hint(result, frame);
			} else{
				int num=(Integer)message.getMessage();
				String temp=Integer.toString(num);
				while(temp.length()<7){
					temp="0"+temp;
				}
				idField.setText(orgId+DateFormat.DATESTRING.format(Calendar.getInstance().getTime())+temp);
			}
		}
	}
	private boolean isLegal(){
		String result = CheckLegal.isTransitLegal(idField.getText());
		if(result != null){
			DoHint.hint(result, frame);
			return false;
		}
		if(expressList.isEmpty()){
			DoHint.hint(Hints.EXPRESSLIST_NULL, frame);
			return false;
		}
		if(supervisionField.getText().equals("")){
			DoHint.hint("请输入监装员！", frame);
			return false;
		}
		if(kindCombo.getSelectedIndex() == 0){
			if(planeIdField.getText().equals("")){
				DoHint.hint("请输入航班号！", frame);
				return false;
			}
		}
		if(containerField.getText().equals("")){
			DoHint.hint("请输入货柜号！", frame);
			return false;
		}
		return true;
	}
	private TransitVO createVO(){
		if(kindCombo.getSelectedIndex() == 0){
			TransitVO vo = new TransitVO(idField.getText(),planeIdField.getText(), (String)startCombo.getSelectedItem(), 
					(String)arriveCombo.getSelectedItem(), containerField.getText(), supervisionField.getText(), expressList.getExpresses(),
					name,Double.parseDouble(costField.getText()),datePanel.getCalendar(),userId,Transit.values()[kindCombo.getSelectedIndex()]);
			return vo;
		} else {
			TransitVO vo = new TransitVO(idField.getText(),null, (String)startCombo.getSelectedItem(), 
					(String)arriveCombo.getSelectedItem(), containerField.getText(), supervisionField.getText(),
					expressList.getExpresses(), name,Double.parseDouble(costField.getText()),datePanel.getCalendar(),userId,
					Transit.values()[kindCombo.getSelectedIndex()]);
			return vo;
		}
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
	@Override
	public void getPrice() {
		String start=(String)startCombo.getSelectedItem();
		String des=(String)arriveCombo.getSelectedItem();
		int tran=kindCombo.getSelectedIndex();
		if(tran<0)return;
		if(start.isEmpty())return;
		if(des.isEmpty())return;
		ResultMessage message=logicSer.getPrice(start, des, tran, expressList.getExpresses());
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			DoHint.hint(result, frame);
			return;
		}
		BigDecimal price=(BigDecimal)message.getMessage();
		costField.setText(price.toString());
	}

}
