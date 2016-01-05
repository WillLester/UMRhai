package edu.nju.umr.ui.checkUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;

import edu.nju.umr.logic.checkLogic.CostBeneLogic;
import edu.nju.umr.logicService.checkLogicSer.CostBeneLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.CostBeneVO;
import edu.nju.umr.vo.ResultMessage;

public class CostBenePanel extends PPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8005438231338516338L;
	private JFrame frame;
	private CostBeneLSer serv;
	private TextField inField;
	private TextField outField;
	private TextField profitField;
	/**
	 * Create the panel.
	 */
	public CostBenePanel(JFrame fr) {
		setLayout(null);
		frame=fr;
		this.setSize(1104,621);
		try {
			serv = new CostBeneLogic();
		} catch (RemoteException e1) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
		TitleLabel nameLabel = new TitleLabel("成本收益");
		add(nameLabel);
		
		Button out = new ExitButton();
		out.setBounds(this.getWidth()/10*9-Constants.BUTTON_WIDTH, this.getHeight()/10*8, 100, 30);
		out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(out);
		
		UMRLabel inLabel = new UMRLabel("总收入");
		inLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		inLabel.setBounds(210, 230, 106, 27);
		add(inLabel);
		
		UMRLabel outLabel = new UMRLabel("总支出");
		outLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		outLabel.setBounds(495, 230, 106, 27);
		add(outLabel);
		
		UMRLabel profitLabel = new UMRLabel("总利润");
		profitLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		profitLabel.setBounds(810, 230, 106, 27);
		add(profitLabel);
		
		inField = new TextField();
		inField.setEditable(false);
		inField.setBounds(156, 267, 175, 27);
		add(inField);
		inField.setColumns(10);
		
		outField = new TextField();
		outField.setEditable(false);
		outField.setColumns(10);
		outField.setBounds(438, 267, 175, 27);
		add(outField);
		
		profitField = new TextField();
		profitField.setEditable(false);
		profitField.setColumns(10);
		profitField.setBounds(754, 267, 175, 27);
		add(profitField);
		
		

		dataInit();
	}
	
	private void dataInit(){
		ResultMessage message = serv.getCostBene();
		if(message.getReInfo() == Result.SUCCESS){
			CostBeneVO vo = (CostBeneVO) message.getMessage();
			inField.setText(vo.getIncome().toString());
			outField.setText(vo.getPayment().toString());
			profitField.setText(vo.getBenefit().toString());
		} else {
			DoHint.hint(message.getReInfo(), frame);
		}
	}
}
