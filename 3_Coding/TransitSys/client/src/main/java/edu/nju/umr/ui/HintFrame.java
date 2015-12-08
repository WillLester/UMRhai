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
	public HintFrame(Result result,int x,int y,int width,int height) {
		initialize(x,y,width,height);
		String txt=null;
		switch(result){
		case SUCCESS:break;
		case FILE_NOT_FOUND:txt="未找到对应文件";break;
		case ID_WRONG:txt="用户名不存在";break;
		case NET_INTERRUPT:txt="网络异常";break;
		case OUT_OF_STOCK_MANEUVER:txt="机动库存剩余空间不足";break;
		case OUT_OF_STOCK_PLANE:txt="航运区库存剩余空间不足";break;
		case OUT_OF_STOCK_TRAIN:txt="火车区库存剩余空间不足";break;
		case OUT_OF_STOCK_VAN:txt="汽运库存剩余空间不足件";break;
		case PASSWORD_WRONG:txt="密码错误";break;
		case PO_NOT_FOUND:txt="未知类型";break;
		case PO_KIND_ERROR:txt = "类型错误";break;
		case SERIAL_FAIL:txt="序列化失败";break;
		case DATABASE_ERROR:txt = "数据库发生错误";break;
		case DATA_NOT_FOUND:txt = "未找到数据";break;
		case ID_IS_USED:txt = "用户名重复";break;
		case EXPRESS_NOT_FOUND:txt = "订单号有错误！";break;
		case OUT_OF_LOAD:txt = "超出满载量！";break;
		default:
			break;
		}
		textAndButton(txt);

	}
	public HintFrame(String error,int x,int y,int width,int height){
		initialize(x, y,width,height);
		textAndButton(error);
	}
	private void initialize(int x,int y,int width,int height){
		setTitle("错误!");
		this.setLayout(null);
		setBounds(x+width/2-FRAME_WIDTH/2, y+height/2-FRAME_HEIGHT/2, FRAME_WIDTH, FRAME_HEIGHT);
		this.setVisible(true);
	}
	private void textAndButton(String text){
		JLabel label=new JLabel(text);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, FRAME_HEIGHT/2-50, FRAME_WIDTH, 40);
		label.setFont(new Font("宋体", Font.PLAIN, 30));
		add(label);
		JButton confirmButton = new JButton("确定");
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(FRAME_WIDTH/2-40, FRAME_HEIGHT/2+14, 80, 28);
		add(confirmButton);
	}
}
