package edu.nju.umr.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import edu.nju.umr.po.enums.Result;

public class HintFrame extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5725804299757185729L;
	public static final int FRAME_WIDTH = (int)(1366*0.3);
	public static final int FRAME_HEIGHT = (int)(768*0.3);
	/**
	 * Create the frame.
	 */
	public HintFrame(Result re,int x,int y) {
		setTitle("错误!");
		this.setLayout(null);
		setBounds(x, y, FRAME_WIDTH, FRAME_HEIGHT);
		this.setVisible(true);
		String txt=null;
		switch(re)
		{
		case SUCCESS:break;
		case FILE_NOT_FOUND:txt="未找到对应文件";break;
		case ID_WRONG:txt="用户名不存在";break;
		case NET_INTERRUPT:txt="网络异常";break;
		case OUT_OF_STOCK_MANEUVER:txt="流动库存剩余空间不足";break;
		case OUT_OF_STOCK_PLANE:txt="飞机库存剩余空间不足";break;
		case OUT_OF_STOCK_TRAIN:txt="火车库存剩余空间不足";break;
		case OUT_OF_STOCK_VAN:txt="汽车库存剩余空间不足件";break;
		case PASSWORD_WRONG:txt="密码错误";break;
		case PO_NOT_FOUND:txt="未找到对应文件";break;
		case SERIAL_FAIL:txt="序列化失败";break;
		}
		JLabel label=new JLabel(txt);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, FRAME_HEIGHT/2-50, FRAME_WIDTH, 40);
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		add(label);
		JButton button_1 = new JButton("确定");
		button_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 20));
		button_1.setBounds(FRAME_WIDTH/2-40, FRAME_HEIGHT/2+14, 80, 28);
		add(button_1);

	}
}
