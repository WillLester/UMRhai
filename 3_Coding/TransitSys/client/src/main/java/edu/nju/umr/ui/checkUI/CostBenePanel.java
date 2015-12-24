package edu.nju.umr.ui.checkUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.nju.umr.logic.checkLogic.CostBeneLogic;
import edu.nju.umr.logicService.checkLogicSer.CostBeneLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.CostBeneVO;
import edu.nju.umr.vo.ResultMessage;

public class CostBenePanel extends JPanel {

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
		serv = new CostBeneLogic();
		this.setSize(1104,621);
		
		JLabel nameLabel = new JLabel("成本收益");
		nameLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
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
		
		JLabel inLabel = new JLabel("总收入");
		inLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		inLabel.setBounds(210, 196, 106, 27);
		add(inLabel);
		
		JLabel outLabel = new JLabel("总支出");
		outLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		outLabel.setBounds(495, 196, 106, 27);
		add(outLabel);
		
		JLabel profitLabel = new JLabel("总利润");
		profitLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		profitLabel.setBounds(810, 196, 106, 27);
		add(profitLabel);
		
		inField = new TextField();
		inField.setEditable(false);
		inField.setBounds(156, 233, 175, 27);
		add(inField);
		inField.setColumns(10);
		
		outField = new TextField();
		outField.setEditable(false);
		outField.setColumns(10);
		outField.setBounds(438, 233, 175, 27);
		add(outField);
		
		profitField = new TextField();
		profitField.setEditable(false);
		profitField.setColumns(10);
		profitField.setBounds(754, 233, 175, 27);
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
