package edu.nju.umr.ui.transitInfoUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.nju.umr.logic.transitInfoLogic.CustomerLogic;
import edu.nju.umr.logicService.transitInfoLogicSer.CustomerLogicSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.MainFrame;
import edu.nju.umr.ui.userUI.LoginPanel;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.vo.ResultMessage;

public class TransitInfoInqPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 640397412841029930L;
	private JTextField idField;
	private CustomerLogicSer logicSer;
	private ArrayList<String> info;
	private MainFrame frame;
	/**
	 * Create the panel.
	 */
	public TransitInfoInqPanel(MainFrame fr) {
		setLayout(null);
		logicSer = new CustomerLogic();
		frame = fr;
		this.setBounds(150, 0, 1229, 691);
		
		JLabel titleLabel = new JLabel("物流历史轨迹查询");
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(364, 10, 242, 67);
		add(titleLabel);
		
		JLabel idLabel = new JLabel("订单编号");
		idLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		idLabel.setBounds(305, 107, 120, 24);
		add(idLabel);
		
		idField = new JTextField();
		idField.setBounds(408, 110, 193, 24);
		add(idField);
		idField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setBounds(174, 153, 687, 374);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(174, 153, 687, 374);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scroll);
		
		JButton confirmButton = new JButton("确定");
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
					} else {
						@SuppressWarnings("unused")
						HintFrame hint = new HintFrame(message.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
					}
				}
			}
		});
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(638, 108, 93, 23);
		add(confirmButton);
		
		JButton closeButton = new JButton("关闭");
		closeButton.setFont(new Font("宋体", Font.PLAIN, 20));
		closeButton.setBounds(547, 571, 93, 23);
		closeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		add(closeButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(386, 571, 93, 23);
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
