package edu.nju.umr.ui.stockUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.umr.logicService.stockLogicSer.StockWarningLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.vo.ResultMessage;

public class StockWarningPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -833178303850310584L;
	private JTextField planeField;
	private JTextField trainField;
	private JTextField vanField;
	private JTextField maneuverField;
	private JFrame frame;
	private StockWarningLSer logicSer;
	private ArrayList<Integer> warnings;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public StockWarningPanel(JFrame fr,String orgId) {
		setLayout(null);
		frame=fr;
		
		JLabel warningLabel = new JLabel("库存报警设置");
		warningLabel.setFont(new Font("华文新魏", Font.PLAIN, 22));
		warningLabel.setBounds(486, 25, 132, 24);
		add(warningLabel);
		
		JLabel planeLabel = new JLabel("航运区警戒线（%）");
		planeLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		planeLabel.setBounds(389, 85, 132, 24);
		add(planeLabel);
		
		JLabel trainLabel = new JLabel("铁运区警戒线（%）");
		trainLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		trainLabel.setBounds(389, 145, 132, 24);
		add(trainLabel);
		
		JLabel vanLabel = new JLabel("汽运区警戒线（%）");
		vanLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		vanLabel.setBounds(389, 205, 132, 24);
		add(vanLabel);
		
		JLabel maneuverLabel = new JLabel("机动区警戒线（%）");
		maneuverLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		maneuverLabel.setBounds(389, 265, 132, 24);
		add(maneuverLabel);
		
		planeField = new JTextField();
		planeField.setBounds(555, 85, 132, 22);
		add(planeField);
		planeField.setColumns(10);
		
		trainField = new JTextField();
		trainField.setBounds(555, 145, 132, 24);
		add(trainField);
		trainField.setColumns(10);
		
		vanField = new JTextField();
		vanField.setBounds(555, 205, 132, 24);
		add(vanField);
		vanField.setColumns(10);
		
		maneuverField = new JTextField();
		maneuverField.setBounds(555, 265, 132, 24);
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
		
		JButton confirmButton = new JButton("确认修改");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 12));
		confirmButton.setBounds(428, 407, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
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
					Result result = logicSer.setWarning(newWarn, orgId);
					if(result.equals(Result.SUCCESS)){
						frame.dispose();
					} else {
						@SuppressWarnings("unused")
						HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
					}
				}
			}
		});
		add(confirmButton);
		
		JButton cancelButton = new JButton("取消修改");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 12));
		cancelButton.setBounds(555, 407, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
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
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 12));
		exitButton.setBounds(746, 407, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
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
