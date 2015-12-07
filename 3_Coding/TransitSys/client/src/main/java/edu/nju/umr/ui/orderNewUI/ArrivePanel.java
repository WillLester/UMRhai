package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
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

import edu.nju.umr.logic.orderNewLogic.ArriveOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.ArriveOrderLSer;
import edu.nju.umr.po.enums.GoodState;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ArriveVO;

public class ArrivePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7454707708911829194L;
	private JTextField idField;
	private JTextField centerField;
	private JFrame frame;
	private DatePanel datePanel;
	private String name;
	private String org;
	private String orgId;
	private String userId;
	private ArriveOrderLSer serv;
	private JComboBox<String> startCombo;
	private JComboBox<String> stateCombo;
	/**
	 * Create the panel.
	 */
	public ArrivePanel(JFrame fr,ArriveVO arrive)
	{
		this(fr,arrive.getOpName(),arrive.getCenterId(),arrive.getUserId(),null);
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
		this.org=org;
		this.userId=userId;
		
		JLabel titleLabel = new JLabel("中转中心到达单");
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(364+75+25, 10, 242, 67);
		add(titleLabel);
		
		JLabel idLabel = new JLabel("中转单编号");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		idLabel.setBounds(342+75, 216, 107, 24);
		add(idLabel);
		
		idField = new JTextField();
		idField.setFont(new Font("宋体", Font.PLAIN, 20));
		idField.setBounds(474+75+25, 216, 193, 24);
		add(idField);
		idField.setColumns(10);
		
		JLabel arriveDateLabel = new JLabel("到达日期");
		arriveDateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		arriveDateLabel.setBounds(342+75+25, 268, 107, 24);
		add(arriveDateLabel);
		
		JLabel centerLabel = new JLabel("中转中心编号");
		centerLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		centerLabel.setBounds(329+75, 107, 120, 24);
		add(centerLabel);
		
		centerField = new JTextField();
		centerField.setBounds(474+75+25, 110, 193, 24);
		centerField.setEnabled(false);
		add(centerField);
		centerField.setColumns(10);
		
		JLabel startLabel = new JLabel("出发地");
		startLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		startLabel.setBounds(342+75+25, 162, 107, 24);
		add(startLabel);
		
		startCombo = new JComboBox<String>();
		startCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		startCombo.setBounds(474+75+25, 166, 193, 21);
		add(startCombo);
		
		datePanel=new DatePanel();
		datePanel.setBounds(474+75+25, 268, 285, 26);
		add(datePanel);
		
		
		JLabel stateLabel = new JLabel("货物到达状态");
		stateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		stateLabel.setBounds(329+75+25, 327, 120, 45);
		add(stateLabel);
		
		stateCombo = new JComboBox<String>();
		stateCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"完整", "损坏", "丢失"}));
		stateCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		stateCombo.setBounds(474+75+25, 338, 193, 24);
		add(stateCombo);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(364+75+25, 434, 93, 23);
		confirmButton.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			createOrder();
		}});
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setName("cancel");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(548+75+25, 436, 93, 23);
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
		if(!result.equals(Result.SUCCESS))
		{
			DoHint.hint(result, frame);
			return;
		}
		@SuppressWarnings("unchecked")
		ArrayList<OrgVO> orgList=(ArrayList<OrgVO>)message.getMessage();
		String []orgs=new String[orgList.size()];
		for(int i=0;i<orgList.size();i++)
		{
			orgs[i]=orgList.get(i).getName();
		}
		startCombo.setModel(new DefaultComboBoxModel<String>(orgs));
		
	}
	private void createOrder()
	{
		String id=idField.getText();
		String centerId=centerField.getText();
		if(idField.getText().isEmpty())
		{
			DoHint.hint("中转单编号未输入!", frame);
			return;
		}
		GoodState state;
		state=GoodState.values()[stateCombo.getSelectedIndex()];
		Result result=serv.create(new ArriveVO(centerId,datePanel.getCalendar(),id,(String)startCombo.getSelectedItem(),state,name,userId),org);
		if(!result.equals(Result.SUCCESS))
		{
			DoHint.hint(result, frame);
		}
		else
		{
			frame.dispose();
		}
	}
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		for(Component co:this.getComponents())
		{
			if(!co.getName().equals("cancel"))
			co.setEnabled(enabled);
		}
	}
}
