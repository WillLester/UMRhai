package edu.nju.umr.ui.userPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.accountUI.CountPanel;
import edu.nju.umr.ui.checkUI.BusiCircumPanel;
import edu.nju.umr.ui.checkUI.CostBenePanel;
import edu.nju.umr.ui.checkUI.DiaryListPanel;
import edu.nju.umr.ui.checkUI.IncomeListPanel;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.orderNewUI.PaymentPanel;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.UserVO;

public class FinancePanel extends UserPanel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5651667612499627695L;
	private static final String pathf="finance/";
	private static final String pathb="finance&manager/";
	public FinancePanel(UserVO user,MainFrame fr) {
		
		super(user,fr);
		
		Button diaryButton = new Button();
		diaryButton.setNewImages(pathb+"diary",pathb+ "diarySt", pathb+"diaryP");
		diaryButton.setBounds(Constants.FIRST_X, Constants.DOUBLE_Y, 95, 95);
		this.add(diaryButton);
		diaryButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("查看日志");
				ffr.setContentPane(new DiaryListPanel(ffr));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button busiCircumButton = new Button();
		busiCircumButton.setNewImages(pathb+"busiCircum", pathb+"busiCircumSt", pathb+"busiCircumP");
		busiCircumButton.setBounds(Constants.SECOND_X, Constants.DOUBLE_Y, 95, 95);
		this.add(busiCircumButton);
		busiCircumButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("查看经营情况表");
				ffr.setContentPane(new BusiCircumPanel(ffr));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button costBeneButton = new Button();
		costBeneButton.setNewImages(pathb+"costBene", pathb+"costBeneSt", pathb+"costBeneP");
		costBeneButton.setBounds(Constants.THIRD_X, Constants.DOUBLE_Y, 95, 95);
		this.add(costBeneButton);
		costBeneButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("查看成本收益表");
				ffr.setContentPane(new CostBenePanel(ffr));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button incomeButton = new Button();
		incomeButton.setNewImages(pathf+"incomeList", pathf+"incomeListSt", pathf+"incomeListP");
		incomeButton.setBounds(Constants.FIRST_X, Constants.SECOND_Y, 95, 95);
		this.add(incomeButton);
		incomeButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("查看收款记录");
				ffr.setContentPane(new IncomeListPanel(ffr));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button countButton = new Button();
		countButton.setNewImages(pathf+"count", pathf+"countSt", pathf+"countP");
		countButton.setBounds(Constants.SECOND_X, Constants.SECOND_Y, 95, 95);
		this.add(countButton);
		countButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("期初建账");
				ffr.setContentPane(new CountPanel(ffr,user.getName()));
				fr.sonFrames.add(ffr);
			}
		});
		
		Button paymentButton = new Button();
		paymentButton.setNewImages(pathf+"payment", pathf+"paymentSt", pathf+"paymentP");
		paymentButton.setBounds(Constants.THIRD_X, Constants.SECOND_Y, 95,95);
		this.add(paymentButton);
		paymentButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				FunctionFrame ffr = new FunctionFrame("生成付款单");
				ffr.setContentPane(new PaymentPanel(ffr,user.getName(),user.getId()));
				fr.sonFrames.add(ffr);
			}
		});
		
		UnpassedOrderMessagePanel upo;
		try {
			upo = new UnpassedOrderMessagePanel(user.getId());
			upo.setBounds(Constants.UNPASSED_X, Constants.UNPASSED_Y, 200, 30);
			add(upo);
		} catch (RemoteException e1) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
	}


}

