package edu.nju.umr.ui.transitInfoUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import edu.nju.umr.logic.transitInfoLogic.CustomerLogic;
import edu.nju.umr.logicService.transitInfoLogicSer.CustomerLogicSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.ELabel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.UMRScrollPane;
import edu.nju.umr.ui.component.UMRTextArea;
import edu.nju.umr.ui.component.Utils;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.userUI.LoginPanel;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;

public class TransitInfoInqPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 640397412841029930L;
	private TextField idField;
	private CustomerLogicSer logicSer;
	private ArrayList<String> info;
	private MainFrame frame;
	private static final int x=100;
	/**
	 * Create the panel.
	 */
	public TransitInfoInqPanel(MainFrame fr) {
		setLayout(null);
		logicSer = new CustomerLogic();
//		logicSer = new TransitInfoInqPanelStub();
		frame = fr;
		this.setBounds(0, 0, 1229, 691);
		
		JLabel titleLabel = new TitleLabel("物流轨迹查询");
		add(titleLabel);
		
		JLabel idLabel = new ELabel("订单编号");
		idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		idLabel.setForeground(Utils.STD_COLOR);
		idLabel.setBounds(305+x, 107, 120, 24);
		add(idLabel);
		
		idField = new TextField();
		idField.setBounds(408+x, 110, 193, 24);
		add(idField);
		idField.setColumns(10);
		
		JTextArea textArea = new UMRTextArea();
		textArea.setEnabled(false);
		textArea.setBounds(174+x, 153, 687, 374);
		JScrollPane scroll = new UMRScrollPane(textArea);
		scroll.setBounds(174+x, 153, 687, 374);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBorder(BorderFactory.createEmptyBorder());
		add(scroll);
		
		Button confirmButton = new ConfirmButton();
		confirmButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				if(isLegal()){
					ResultMessage message = logicSer.enterBarcodeCustomer(idField.getText());
					if(message.getReInfo().equals(Result.SUCCESS)){
						textArea.setText("");
						info = (ArrayList<String>) message.getMessage();
						for(String inf:info){
							textArea.append(inf);
							textArea.append("\n");
						}
						if(info.size()==0){
							DoHint.hint(Result.EXPRESS_NOT_FOUND, frame);
						}
					} else {
						@SuppressWarnings("unused")
						HintFrame hint = new HintFrame(message.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
					}
				}
			}
		});
		confirmButton.setBounds(638+x, 108, 100,30 );
		add(confirmButton);
		
		Button closeButton = new ExitButton();
		closeButton.setBounds(547+x, 571, 100, 30);
		closeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		add(closeButton);
		
		Button cancelButton = new CanButton();
		cancelButton.setBounds(386+x, 571, 100, 30);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				frame.setContentPane(new LoginPanel(frame));
			}
		});
		add(cancelButton);
	}
	private boolean isLegal(){
		String result = CheckLegal.isExpressLegal(idField.getText());
		if(result != null){
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(result, frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		} else {
			return true;
		}
	}
}
