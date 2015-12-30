package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderNewLogic.RecipientOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.RecipientOrderLSer;
import edu.nju.umr.po.enums.GoodState;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.AutoCompPanel;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Hints;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.RecipientVO;

public class RecipientPanel extends PPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2907522992276366929L;
	private AutoCompPanel transitIdField;
	private JFrame frame;
	private DatePanel datePanel;
	private UMRComboBox<String> cityCombo;
	private UMRComboBox<String> stateCombo;
	private RecipientOrderLSer logicSer;
	private String[] orgList;
	private String name;
	private String userId;
	private String orgId;
	private TextField idField;
	/**
	 * Create the panel.
	 */
	public RecipientPanel(JFrame fr,RecipientVO vo)
	{
		this(fr,vo.getOpName(),null,vo.getUserId(),null);
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		idField.setText(vo.getId());
		transitIdField.setText(vo.getTransitId());
		datePanel.setDate(vo.getDate());
		cityCombo.setSelectedItem(vo.getStartPlace());
		stateCombo.setSelectedItem(EnumTransFactory.checkGoodState(vo.getState()));
	}
	/**
	 * @wbp.parser.constructor
	 */
	public RecipientPanel(JFrame fr,String name,String orgId,String userId,String org) {
		setLayout(null);
		frame=fr;
		this.name = name;
		this.userId=userId;
		this.orgId = orgId;
		logicSer = new RecipientOrderLogic();
		
		TitleLabel titleLabel = new TitleLabel("营业厅接收单");
		titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(382+40, 10, 242, 67);
		add(titleLabel);
		
		UMRLabel transitIdLabel = new UMRLabel("装车单编号");
		transitIdLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		transitIdLabel.setBounds(342+40, 236, 107, 24);
		add(transitIdLabel);
		
		transitIdField = new AutoCompPanel();
		transitIdField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		transitIdField.setBounds(474+50, 236, 193, 24);
		add(transitIdField);
		
		UMRLabel dateLabel = new UMRLabel("到达日期");
		dateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		dateLabel.setBounds(342+40, 291, 107, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(525, 291, 285, 26);
		add(datePanel);
		
		UMRLabel startLabel = new UMRLabel("出发地");
		startLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		startLabel.setBounds(342+40, 182, 107, 24);
		add(startLabel);
		
		getOrg();
		
		cityCombo = new UMRComboBox<String>();
		cityCombo.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		cityCombo.setBounds(474+50, 186, 193, 24);
		cityCombo.setModel(new DefaultComboBoxModel<String>(orgList));
		add(cityCombo);
		
		UMRLabel stateLabel = new UMRLabel("货物到达状态");
		stateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		stateLabel.setBounds(329+49, 347, 120, 45);
		add(stateLabel);
		
		stateCombo = new UMRComboBox<String>();
		stateCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"完整", "损坏", "丢失"}));
		stateCombo.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		stateCombo.setBounds(474+50, 358, 193, 24);
		add(stateCombo);
		
		Button confirmButton = new ConfirmButton();
		confirmButton.setBounds(364+40, 454,100, 30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					Result result = logicSer.create(createVO());
					DoHint.hint(result, frame,true);
					if(result.equals(Result.SUCCESS)){
//						DoHint.hint(result, frame);
//						if(result.equals(Result.SUCCESS)){
//							confirmButton.setEnabled(false);
//						}
//						frame.setTitle("派件单生成");
//						frame.setContentPane(new SendPanel(frame,name,orgId,userId,(LinkedList<String>) logicSer.expressList(transitIdField.getText())));
					}
				} 
			}
		});
		add(confirmButton);
		
		Button cancelButton = new CanButton();
		cancelButton.setName("cancel");
		cancelButton.setBounds(548+40, 456, 100, 30);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancelButton);
		
		UMRLabel idLabel = new UMRLabel("单据编号");
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idLabel.setBounds(382, 141, 107, 24);
		add(idLabel);
		
		idField = new TextField();
		idField.setEditable(false);
		idField.setBounds(525, 141, 199, 28);
		add(idField);
		idField.setColumns(10);
		if(orgId != null){
			getId();
		}
		if(org!=null){
			ResultMessage message=logicSer.getComingLoadingOrder(org);
			Result result=message.getReInfo();
			if(result.equals(Result.SUCCESS)){
				@SuppressWarnings("unchecked")
				ArrayList<String> ar=(ArrayList<String>)message.getMessage();
				transitIdField.setAllItem(ar);
			}
		}
	}
	
	private void getId(){
		ResultMessage message = logicSer.getNextId(orgId);
		if(message.getReInfo() == Result.SUCCESS){
			String re = orgId + DateFormat.DATESTRING.format(Calendar.getInstance().getTime());
			int size = (int) message.getMessage();
			String id = ""+size;
			while(id.length() < 7){
				id = "0"+id;
			}
			re += id;
			idField.setText(re);
		} else {
			DoHint.hint(message.getReInfo(), frame);
		}
	}
	
	private void getOrg(){
		ResultMessage result = logicSer.getLocalHallAndCenter(orgId);
		if(result.getReInfo().equals(Result.SUCCESS)){
			orgList = (String[]) result.getMessage();
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
//		if(!logicSer.isLoadValid(transitIdField.getText())){
//			DoHint.hint("中转单不存在！", frame);
//			return false;
//		}
		return true;
	}
	private RecipientVO createVO(){
		GoodState states[] = GoodState.values();
		RecipientVO vo = new RecipientVO(idField.getText(),datePanel.getCalendar(), transitIdField.getText(), (String)cityCombo.getSelectedItem(), states[stateCombo.getSelectedIndex()], name,userId);
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
