package edu.nju.umr.ui.workOrgManUI;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.UserVO;
import edu.nju.umr.vo.VanVO;

public class VanInfoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6047938368654645426L;
	private JTextField textFieldNum;
	private JTextField textFieldPlate;
	private VanListPanel fatherPanel;
	private String imageString=null;
	private BufferedImage image;
	private VanVO van;
	private JFrame frame;
	private DatePanel servTime;
	private DatePanel end;
	private JLabel pic;
	private UserVO user;

	/**
	 * Create the panel.
	 */
	public VanInfoPanel(JFrame fr,VanListPanel father,VanVO vanvo,UserVO uservo) {
		this.setSize(Constants.INFO_WIDTH,Constants.INFO_HEIGHT);
		setLayout(null);
		fatherPanel=father;
		frame=fr;
		van=vanvo;
		user=uservo;
		
		JLabel nameLabel = new JLabel("车辆信息");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_L);
		add(nameLabel);
		
		JLabel vanNum = new JLabel("车辆代号");
		vanNum.setBounds(Constants.INFOTABLE_X, Constants.INFOTABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(vanNum);
		
		textFieldNum = new JTextField();
		textFieldNum.setBounds(vanNum.getX()+vanNum.getWidth(), vanNum.getY(), Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		textFieldNum.setEnabled(false);
		add(textFieldNum);
		textFieldNum.setColumns(10);
		
		JLabel plateNum = new JLabel("车牌号");
		plateNum.setBounds(vanNum.getX(), vanNum.getY()+vanNum.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(plateNum);
		
		textFieldPlate = new JTextField();
		textFieldPlate.setBounds(textFieldNum.getX(), plateNum.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldPlate);
		textFieldPlate.setColumns(10);
		
		JLabel workTime = new JLabel("服役时间");
		workTime.setBounds(vanNum.getX(), plateNum.getY()+plateNum.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(workTime);
		
		JLabel labely = new JLabel("由");
		labely.setBounds(textFieldNum.getX(), workTime.getY()+8, 19, 15);
//		add(labely);
		
		servTime=new DatePanel();
		servTime.setBounds(labely.getX(), workTime.getY()+5, Constants.DATE_WIDTH, Constants.DATE_HEIGHT);
		add(servTime);
		
		JLabel labelz = new JLabel("至");
		labelz.setBounds(labely.getX(), labely.getY()+30, 19, 15);
//		add(labelz);
		
		end=new DatePanel();
		end.setBounds(labelz.getX()+20, labelz.getY()+3, Constants.DATE_WIDTH, Constants.DATE_HEIGHT);
//		add(end);
		
		JLabel picture = new JLabel("车辆图片");
		picture.setBounds(vanNum.getX(), labelz.getY()+20+40, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(picture);
		
		pic = new JLabel("图片");
		pic.setBounds(textFieldNum.getX(), picture.getY(), 350, 180);
		add(pic);
		
		JButton upload = new JButton("选择图片");
		upload.setBounds(pic.getX()+pic.getWidth()-100, pic.getY()+pic.getHeight()+15, 93, 23);
		add(upload);
		
		JButton confirm = new JButton("确定");
		confirm.setBounds(upload.getX()+200, upload.getY(), 93, 23);
		confirm.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			confirmChange();
		}});
		add(confirm);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(confirm.getX()+confirm.getWidth()+50, confirm.getY(), 93, 23);
		cancel.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			frame.dispose();
		}});
		add(cancel);
		
		dataInit();
	}
	private void dataInit(){
		textFieldNum.setText(van.getId());
		textFieldPlate.setText(van.getPlateNum());
		servTime.setDate(van.getServTime());
		imageString=van.getPhoto();
		if(!imageString.equals(null))
		{
			image=baseCodeToImage(imageString);
			pic.setIcon(new ImageIcon(image));
		}
	}
	private BufferedImage baseCodeToImage(String baseCode){
		
		return null;
	}
	private String imageToBaseCode(Image im)
	{
		return null;
	}
	private void confirmChange(){
		if(textFieldPlate.getText().isEmpty())
		{
			DoHint.hint("车牌号未输入",frame);
			return;
		}
		if(imageString.isEmpty())
		{
			DoHint.hint("图片未选择!", frame);
			return;
		}
		VanVO temp=new VanVO(textFieldNum.getText(),textFieldPlate.getText(),servTime.getCalendar(),imageString,user.getOrgId());
		Result result=fatherPanel.confirmed(temp);
		
	}
//	public static void main(String[] args)
//	{
//		JFrame frame=new JFrame();
//		frame.setContentPane(new VanInfoPanel(frame,null,null,null));
//		frame.setSize(1200,800);
//		frame.setVisible(true);
//	}

}
