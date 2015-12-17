package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.logic.orderNewLogic.RecipientOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.RecipientOrderLSer;
import edu.nju.umr.po.enums.GoodState;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Hints;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.RecipientVO;

public class RecipientPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2907522992276366929L;
	private JTextField transitIdField;
	private JFrame frame;
	private DatePanel datePanel;
	private JComboBox<String> cityCombo;
	private JComboBox<String> stateCombo;
	private RecipientOrderLSer logicSer;
	private String[] cityList;
	private String name;
	private String userId;
	private String orgId;
	private JTextField idField;
	/**
	 * Create the panel.
	 */
	public RecipientPanel(JFrame fr,RecipientVO vo)
	{
		this(fr,vo.getOpName(),null,vo.getUserId());
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		transitIdField.setText(vo.getTransitId());
		datePanel.setDate(vo.getDate());
		cityCombo.setSelectedItem(vo.getStartPlace());
		stateCombo.setSelectedItem(EnumTransFactory.checkGoodState(vo.getState()));
	}
	/**
	 * @wbp.parser.constructor
	 */
	public RecipientPanel(JFrame fr,String name,String orgId,String userId) {
		setLayout(null);
		frame=fr;
		this.name = name;
		this.userId=userId;
		this.orgId = orgId;
		logicSer = new RecipientOrderLogic();
		
		JLabel titleLabel = new JLabel("营业厅接收单");
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(382+40, 45, 242, 67);
		add(titleLabel);
		
		JLabel transitIdLabel = new JLabel("装车单编号");
		transitIdLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		transitIdLabel.setBounds(342+40, 216, 107, 24);
		add(transitIdLabel);
		
		transitIdField = new JTextField();
		transitIdField.setFont(new Font("宋体", Font.PLAIN, 20));
		transitIdField.setBounds(474+40, 216, 193, 24);
		add(transitIdField);
		transitIdField.setColumns(10);
		
		JLabel dateLabel = new JLabel("到达日期");
		dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		dateLabel.setBounds(342+40, 268, 107, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(532, 268, 285, 26);
		add(datePanel);
		
		JLabel startLabel = new JLabel("出发地");
		startLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		startLabel.setBounds(342+40, 162, 107, 24);
		add(startLabel);
		
		getCity();
		
		cityCombo = new JComboBox<String>();
		cityCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		cityCombo.setBounds(474+40, 166, 193, 21);
		cityCombo.setModel(new DefaultComboBoxModel<String>(cityList));
		add(cityCombo);
		
		JLabel stateLabel = new JLabel("货物到达状态");
		stateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		stateLabel.setBounds(329+40, 327, 120, 45);
		add(stateLabel);
		
		stateCombo = new JComboBox<String>();
		stateCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"完整", "损坏", "丢失"}));
		stateCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		stateCombo.setBounds(474+40, 338, 193, 24);
		add(stateCombo);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(364+40, 434, 93, 23);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					Result result = logicSer.create(createVO());
					DoHint.hint(result, frame);
					if(result.equals(Result.SUCCESS)){
						DoHint.hint(result, frame);
						if(result.equals(Result.SUCCESS)){
							confirmButton.setEnabled(false);
						}
						frame.setTitle("派件单生成");
						frame.setContentPane(new SendPanel(frame,name,orgId,userId,(LinkedList<String>) logicSer.expressList(transitIdField.getText())));
					}
				} 
			}
		});
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setName("cancel");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(548+40, 436, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancelButton);
		
		JLabel idLabel = new JLabel("单据编号");
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idLabel.setBounds(382, 121, 107, 24);
		add(idLabel);
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(505, 121, 193, 24);
		add(idField);
		idField.setColumns(10);

	}
	
	private void getId(){
		ResultMessage message = logicSer.getNextId(orgId);
		if(message.getReInfo() == Result.SUCCESS){
			
		} else {
			DoHint.hint(message.getReInfo(), frame);
		}
	}
	
	private void getCity(){
		ResultMessage result = logicSer.getCities();
		if(result.getReInfo().equals(Result.SUCCESS)){
			cityList = (String[]) result.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(result.getReInfo(), frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
		}
	}
	@SuppressWarnings("unused")
	private boolean isLegal(){
		if(datePanel.getCalendar().after(Calendar.getInstance())){
			HintFrame hint = new HintFrame(Hints.OUT_OF_DATE, frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		String result = CheckLegal.isTransitLegal(transitIdField.getText());
		if(result != null){
			HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
			return false;
		}
		if(!logicSer.isTransitValid(transitIdField.getText())){
			DoHint.hint("中转单不存在！", frame);
			return false;
		}
		return true;
	}
	private RecipientVO createVO(){
		GoodState states[] = GoodState.values();
		RecipientVO vo = new RecipientVO(datePanel.getCalendar(), transitIdField.getText(), (String)cityCombo.getSelectedItem(), states[stateCombo.getSelectedIndex()], name,userId);
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
