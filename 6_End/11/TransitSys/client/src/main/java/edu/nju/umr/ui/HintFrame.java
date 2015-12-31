package edu.nju.umr.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.EDialog;
import edu.nju.umr.ui.component.button.ConfirmButton;

public class HintFrame extends EDialog{
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
		super(FRAME_WIDTH, FRAME_HEIGHT);
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
		case EXPRESS_NOT_FOUND:txt = "订单不存在！";break;
		case OUT_OF_LOAD:txt = "超出满载量！";break;
		case CITY_EXIST:txt="城市已存在！";break;
		case CITY_ID_USED:txt="区号已使用！";break;
		case ORG_EXIST:txt="机构已存在！";break;
		case ACCOUNT_EXIST:txt="账户已存在！";break;
		case STOCK_FULL:txt="库存已满！";break;
		case NOSPACE_FOR_STOCK:txt="没有可用仓库";break;
		default:
			break;
		}
		textAndButton(txt);
		repaint();
	}
	public HintFrame(String error,int x,int y,int width,int height){
		super(FRAME_WIDTH, FRAME_HEIGHT);
		initialize(x, y,width,height);
		textAndButton(error);
	}
	private void initialize(int x,int y,int width,int height){
		setTitle("错误!");
		this.setLayout(null);
		setLocation(x+width/2-FRAME_WIDTH/2, y+height/2-FRAME_HEIGHT/2);
		this.setContentPane(new HintPanel());
		this.setVisible(true);
	}
	private void textAndButton(String text){
		JLabel label=new JLabel(text);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, FRAME_HEIGHT/2-40, FRAME_WIDTH, 40);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 25));
		add(label);
		Button confirmButton = new ConfirmButton();
		confirmButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		});
		confirmButton.setBounds(FRAME_WIDTH/2-50, FRAME_HEIGHT/2+40, 100, 30);
		add(confirmButton);
	}
	
	
}
