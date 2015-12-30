package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.logic.orderNewLogic.ArriveOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.ArriveOrderLSer;
import edu.nju.umr.po.enums.GoodState;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.AutoCompPanel;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ArriveVO;

public class ArrivePanel extends PPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7454707708911829194L;
	private AutoCompPanel idField;
	private JTextField centerField;
	private JFrame frame;
	private DatePanel datePanel;
	private String name;
	private String orgId;
	private String userId;
	private String org;
	private ArriveOrderLSer serv;
	private UMRComboBox<String> startCombo;
	private UMRComboBox<String> stateCombo;
	private Button confirmButton;
	/**
	 * Create the panel.
	 */
	public ArrivePanel(JFrame fr,ArriveVO arrive)
	{
		this(fr,arrive.getOpName(),arrive.getCenterId(),arrive.getUserId(),"");
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		idField.setText(arrive.getId());
		centerField.setText(arrive.getCenterId());
		datePanel.setDate(arrive.getDate());
		startCombo.setSelectedItem((String)arrive.getStartPlace());
		stateCombo.setSelectedItem(arrive.getState().toString());
	}
	public ArrivePanel(JFrame fr,String name,String orgId,String userId,String org) {
		setLayout(null);
		frame=fr;
		this.name = name;
		this.orgId = orgId;
		this.userId=userId;
		this.org = org;
		
		TitleLabel titleLabel = new TitleLabel("中转中心到达单");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(364+75+25, 10, 242, 67);
		add(titleLabel);
		
		JLabel idLabel = new UMRLabel("中转单编号");
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idLabel.setBounds(342+35, 246, 107, 24);
		add(idLabel);
		
		idField = new AutoCompPanel();
		idField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idField.setBounds(474+60, 246, 193, 24);
		add(idField);
		
		JLabel arriveDateLabel = new UMRLabel("到达日期");
		arriveDateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		arriveDateLabel.setBounds(377, 298, 107, 24);
		add(arriveDateLabel);
		
		JLabel centerLabel = new UMRLabel("中转中心编号");
		centerLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		centerLabel.setBounds(377, 137, 120, 24);
		add(centerLabel);
		
		centerField = new TextField();
		centerField.setBounds(474+60, 140, 193, 24);
		centerField.setEnabled(false);
		add(centerField);
		centerField.setColumns(10);
		
		JLabel startLabel = new UMRLabel("出发地");
		startLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		startLabel.setBounds(377, 192, 107, 24);
		add(startLabel);
		
		startCombo = new UMRComboBox<String>();
		startCombo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		startCombo.setBounds(474+60, 196, 193, 24);
		add(startCombo);
		
		datePanel=new DatePanel();
		datePanel.setBounds(474+60, 298, 285, 26);
		add(datePanel);
		
		
		JLabel stateLabel = new UMRLabel("货物到达状态");
		stateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		stateLabel.setBounds(377, 357, 120, 45);
		add(stateLabel);
		
		stateCombo = new UMRComboBox<String>();
		stateCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"完整", "损坏", "丢失"}));
		stateCombo.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		stateCombo.setBounds(474+60, 368, 193, 24);
		add(stateCombo);
		
		confirmButton = new ConfirmButton();
		confirmButton.setBounds(364+60, 464, 100, 30);
		confirmButton.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			createOrder();
		}});
		add(confirmButton);
		
		Button cancelButton = new CanButton();
		cancelButton.setName("cancel");
		cancelButton.setBounds(548+60, 466, 100, 30);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(cancelButton);

		dataInit();
	}
	private void dataInit()
	{
		serv=new ArriveOrderLogic();
		centerField.setText(orgId);
		ResultMessage message = serv.getLocalHallsAndAllCenter(orgId);
		Result result=message.getReInfo();
		if(result == Result.SUCCESS){
			String []orgs=(String[]) message.getMessage();
			startCombo.setModel(new DefaultComboBoxModel<String>(orgs));
		} else {
			DoHint.hint(result, frame);
		}
		
		message=serv.getArriveOrders(org);
		result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			DoHint.hint(result, frame);
			return;
		}
		@SuppressWarnings("unchecked")
		ArrayList<String> ar = (ArrayList<String>)message.getMessage();
		idField.setAllItem(ar);
		
	}
	private void createOrder()
	{
		String id=idField.getText();
		String centerId=centerField.getText();
		if(idField.getText().isEmpty())
		{
			DoHint.hint("中转单或装车单编号未输入!", frame);
			return;
		}
		GoodState state;
		state=GoodState.values()[stateCombo.getSelectedIndex()];
		Result result=serv.create(new ArriveVO(centerId,datePanel.getCalendar(),id,(String)startCombo.getSelectedItem(),state,name,userId));
		DoHint.hint(result, frame,true);
		if(result.equals(Result.SUCCESS)){
			confirmButton.setEnabled(false);
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
}
