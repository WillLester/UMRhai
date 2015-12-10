package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.logic.orderNewLogic.SendOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.SendOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Hints;
import edu.nju.umr.ui.utility.Utility;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.SendVO;

public class SendPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2026433345972064274L;
	private JTextField barcodeField;
	private JComboBox<String> courierCombo;
	private JFrame frame;
	private DatePanel datePanel;
	private String name;
	private String[] courierList;
	private SendOrderLSer logicSer;
	private String userId;
	/**
	 * Create the panel.
	 */
	public SendPanel(JFrame fr,SendVO vo)
	{
		this(fr, vo.getOpName(),null, vo.getUserId(),null,null);
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(false);
		}
		barcodeField.setText(vo.getExpressId());
		courierCombo.setSelectedItem(vo.getCourier());
		datePanel.setDate(vo.getDate());
	}
	public SendPanel(JFrame fr,String name,String orgId,String userId,String org,LinkedList<String> express) {
		setLayout(null);
		frame=fr;
		this.name = name;
		this.userId=userId;
		logicSer = new SendOrderLogic();
		
		JLabel titleLabel = new JLabel("派件单");
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(382, 45, 242, 67);
		add(titleLabel);
		
		JLabel barcodeLabel = new JLabel("托运单条形码号");
		barcodeLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		barcodeLabel.setBounds(342, 216, 140, 24);
		add(barcodeLabel);
		
		barcodeField = new JTextField();
		barcodeField.setFont(new Font("宋体", Font.PLAIN, 20));
		barcodeField.setBounds(487, 216, 193, 24);
		barcodeField.setText(express.get(0));
		barcodeField.setEnabled(false);
		add(barcodeField);
		barcodeField.setColumns(10);
		
		JLabel dateLabel = new JLabel("到达日期");
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		dateLabel.setBounds(342, 268, 107, 24);
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(532, 268, 285, 26);
		add(datePanel);
		
		JLabel courierLabel = new JLabel("派送员");
		courierLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		courierLabel.setBounds(342, 162, 107, 24);
		add(courierLabel);
		
		ResultMessage result = logicSer.getCouriers(orgId);
		if(result.getReInfo().equals(Result.SUCCESS)){
			courierList = (String[]) result.getMessage();
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(result.getReInfo(), frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
		}
		
		courierCombo = new JComboBox<String>();
		courierCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		courierCombo.setBounds(487, 162, 193, 24);
		courierCombo.setModel(new DefaultComboBoxModel<String>(courierList));
		add(courierCombo);
		
		JButton confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(364, 434, 93, 23);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					Result result = logicSer.create(createVO(),org);
					DoHint.hint(result, frame);
					if(result.equals(Result.SUCCESS)){
						confirmButton.setEnabled(false);
						try{
							Thread.sleep(300);
						}catch(Exception ex)
						{
							ex.printStackTrace();
						}
						if(!express.isEmpty()){
							express.removeFirst();
							frame.setContentPane(new SendPanel(fr, name, orgId, userId, org, express));
						} else {
							frame.dispose();
						}
					}
//					if(result.equals(Result.SUCCESS)){
//						if(!express.isEmpty()){
//							express.removeFirst();
//							frame.setContentPane(new SendPanel(fr, name, orgId, userId, org, express));
//						} else {
//							frame.dispose();
//						}
//					} else {
//						@SuppressWarnings("unused")
//						HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(),frame.getWidth(),frame.getHeight());
//					}
				}
			}
		});
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setName("cancel");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(548, 436, 93, 23);
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
		return true;
	}
	private SendVO createVO(){
		SendVO vo = new SendVO(datePanel.getCalendar(), barcodeField.getText(), (String) courierCombo.getSelectedItem(), name,userId);
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
