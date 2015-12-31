package edu.nju.umr.ui.stockUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import edu.nju.umr.logic.stockLogic.StockWarningLogic;
import edu.nju.umr.logicService.stockLogicSer.StockWarningLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.Utils;
import edu.nju.umr.ui.component.button.CanModButton;
import edu.nju.umr.ui.component.button.ConfirmModButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;

public class StockWarningPanel extends PPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -833178303850310584L;
	private TextField planeField;
	private TextField trainField;
	private TextField vanField;
	private TextField maneuverField;
	private JFrame frame;
	private StockWarningLSer logicSer;
	private ArrayList<Integer> warnings;
	private static final int y=35;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public StockWarningPanel(JFrame fr,String orgId,String name) {
		setLayout(null);
		frame=fr;
		logicSer = new StockWarningLogic();
		
		TitleLabel warningLabel = new TitleLabel("库存报警设置");
		add(warningLabel);
		
		UMRLabel planeLabel = new UMRLabel("航运区警戒线（%）");
		planeLabel.setFont(Utils.COMBO_FONT);
		planeLabel.setForeground(Utils.STD_COLOR);
		planeLabel.setBounds(380, y+85, 138, 24);
		add(planeLabel);
		
		UMRLabel trainLabel = new UMRLabel("铁运区警戒线（%）");
		trainLabel.setFont(Utils.COMBO_FONT);
		trainLabel.setForeground(Utils.STD_COLOR);
		trainLabel.setBounds(380, y+145, 138, 24);
		add(trainLabel);
		
		UMRLabel vanLabel = new UMRLabel("汽运区警戒线（%）");
		vanLabel.setFont(Utils.COMBO_FONT);
		vanLabel.setForeground(Utils.STD_COLOR);
		vanLabel.setBounds(380, y+205, 138, 24);
		add(vanLabel);
		
		UMRLabel maneuverLabel = new UMRLabel("机动区警戒线（%）");
		maneuverLabel.setFont(Utils.COMBO_FONT);
		maneuverLabel.setForeground(Utils.STD_COLOR);
		maneuverLabel.setBounds(380, y+265, 138, 24);
		add(maneuverLabel);
		
		planeField = new TextField();
		planeField.setBounds(555, y+85, 132, 22);
		add(planeField);
		planeField.setColumns(10);
		
		trainField = new TextField();
		trainField.setBounds(555, y+145, 132, 24);
		add(trainField);
		trainField.setColumns(10);
		
		vanField = new TextField();
		vanField.setBounds(555, y+205, 132, 24);
		add(vanField);
		vanField.setColumns(10);
		
		maneuverField = new TextField();
		maneuverField.setBounds(555, y+265, 132, 24);
		add(maneuverField);
		maneuverField.setColumns(10);
		
		ResultMessage message = logicSer.getWarning(orgId);
		if(message.getReInfo().equals(Result.SUCCESS)){
			this.warnings = (ArrayList<Integer>) message.getMessage();
			planeField.setText(""+warnings.get(0));
			trainField.setText(""+warnings.get(1));
			vanField.setText(""+warnings.get(2));
			maneuverField.setText(""+warnings.get(3));
		} else if(!message.getReInfo().equals(Result.FILE_NOT_FOUND)){
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(message.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
		} 
		
		Button confirmButton = new ConfirmModButton();
		confirmButton.setBounds(428, y+385,100, 30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					ArrayList<Integer> newWarn = new ArrayList<Integer>();
					newWarn.add(Integer.parseInt(planeField.getText()));
					newWarn.add(Integer.parseInt(trainField.getText()));
					newWarn.add(Integer.parseInt(vanField.getText()));
					newWarn.add(Integer.parseInt(maneuverField.getText()));
					Result result = logicSer.setWarning(newWarn, orgId,name);
					DoHint.hint(result, frame);
					if(result.equals(Result.SUCCESS)){
						confirmButton.setEnabled(false);
						try{
							Thread.sleep(300);
						}catch(Exception ex)
						{
							ex.printStackTrace();
						}
						frame.dispose();
					}
				}
			}
		});
		add(confirmButton);
		
		Button cancelButton = new CanModButton();
		cancelButton.setBounds(555, y+385, 100, 30);
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(warnings == null){
					planeField.setText("");
					trainField.setText("");
					vanField.setText("");
					maneuverField.setText("");
				} else {
					planeField.setText(""+warnings.get(0));
					trainField.setText(""+warnings.get(1));
					vanField.setText(""+warnings.get(2));
					maneuverField.setText(""+warnings.get(3));
				}
			}
		});
		add(cancelButton);
		
		Button exitButton = new ExitButton();
		exitButton.setBounds(766, y+385,100, 30);
		exitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(exitButton);
	}
	@SuppressWarnings("unused")
	private boolean isLegal(){
		try {
			Integer.parseInt(planeField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("航运区警戒线格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if((Integer.parseInt(planeField.getText())<0)||(Integer.parseInt(planeField.getText())>100)){
			HintFrame hint = new HintFrame("航运区警戒线大小不正确！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		try {
			Integer.parseInt(trainField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("铁运区警戒线格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if((Integer.parseInt(trainField.getText())<0)||(Integer.parseInt(trainField.getText())>100)){
			HintFrame hint = new HintFrame("铁运区警戒线大小不正确！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		try {
			Integer.parseInt(vanField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("汽运区警戒线格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if((Integer.parseInt(vanField.getText())<0)||(Integer.parseInt(vanField.getText())>100)){
			HintFrame hint = new HintFrame("汽运区警戒线大小不正确！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		try {
			Integer.parseInt(maneuverField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("机动区警戒线格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if((Integer.parseInt(maneuverField.getText())<0)||(Integer.parseInt(maneuverField.getText())>100)){
			HintFrame hint = new HintFrame("机动区警戒线大小不正确！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		return true;
	}
}
