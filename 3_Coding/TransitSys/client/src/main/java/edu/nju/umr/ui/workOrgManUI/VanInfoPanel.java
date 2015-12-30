package edu.nju.umr.ui.workOrgManUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.InfoFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.ELabel;
import edu.nju.umr.ui.component.InfoPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.Utils;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.VanVO;

@SuppressWarnings("restriction")
public class VanInfoPanel extends InfoPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6047938368654645426L;
	private TextField textFieldNum;
	private TextField textFieldPlate;
	private VanListPanel fatherPanel;
	private String imageString=null;
	private VanVO van;
	private JFrame frame;
	private DatePanel servTime;
	private JLabel pic;
	private String orgId;
	private Button confirm;
	private static final int y=25;

	/**
	 * Create the panel.
	 */
	public VanInfoPanel(InfoFrame fr,VanListPanel father,VanVO vanvo,String orgId) {
		this.setSize(Constants.INFO_WIDTH,Constants.INFO_HEIGHT);
		setLayout(null);
		fatherPanel=father;
		frame=fr;
		van=vanvo;
		this.orgId = orgId;
		
		JLabel nameLabel = new TitleLabel("车辆信息");
		nameLabel.setLocation(995/2-nameLabel.getWidth()/2+50, nameLabel.getY());
		add(nameLabel);
		
		JLabel vanNum = new ELabel("车辆代号");
		vanNum.setFont(Utils.COMBO_FONT);
		vanNum.setBounds(Constants.INFOTABLE_X, y+Constants.INFOTABLE_Y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(vanNum);
		
		textFieldNum = new TextField();
		textFieldNum.setBounds(vanNum.getX()+vanNum.getWidth(), vanNum.getY(), Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		textFieldNum.setEnabled(false);
		add(textFieldNum);
		textFieldNum.setColumns(10);
		
		JLabel plateNum = new ELabel("车牌号");
		plateNum.setFont(Utils.COMBO_FONT);
		plateNum.setBounds(vanNum.getX(), vanNum.getY()+vanNum.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(plateNum);
		
		textFieldPlate = new TextField();
		textFieldPlate.setBounds(textFieldNum.getX(), plateNum.getY()+3, Constants.TEXTFIELD_WIDTH_S, Constants.TEXTFIELD_HEIGHT);
		add(textFieldPlate);
		textFieldPlate.setColumns(10);
		
		JLabel workTime = new ELabel("服役时间");
		workTime.setFont(Utils.COMBO_FONT);
		workTime.setBounds(vanNum.getX(), plateNum.getY()+plateNum.getHeight()+30, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(workTime);
		
		JLabel labely = new ELabel("由");
		labely.setFont(Utils.COMBO_FONT);;
		labely.setBounds(textFieldNum.getX(), workTime.getY()+8, 19, 15);
		
		servTime=new DatePanel();
		servTime.setBounds(labely.getX(), workTime.getY()+5, Constants.DATE_WIDTH, Constants.DATE_HEIGHT);
		add(servTime);
		
		JLabel labelz = new ELabel("至");
		labelz.setFont(Utils.COMBO_FONT);
		labelz.setBounds(labely.getX(), labely.getY()+30, 19, 15);
		
		JLabel picture = new ELabel("车辆图片");
		picture.setFont(Utils.COMBO_FONT);
		picture.setBounds(vanNum.getX(), labelz.getY()+20+40, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT_S);
		add(picture);
		
		pic = new ELabel("图片");
		pic.setFont(Utils.COMBO_FONT);
		pic.setBounds(textFieldNum.getX(), picture.getY(), 350, 180);
		add(pic);
		
		Button upload = new Button();
		upload.setNewImages("buttonImage", "buttonImageSt", "buttonImageP");
		upload.setBounds(pic.getX()+pic.getWidth()-100, pic.getY()+pic.getHeight()-5, 100, 30);
		upload.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JFileChooser chooser = new javax.swing.JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("图片","jpg","png");
			chooser.setFileFilter(filter);
			chooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY); 
			int returnVal = chooser.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				 File file = chooser.getSelectedFile();
				 readAndDisplayImage(file.getPath());
			}
		}});
		add(upload);
		
		confirm = new ConfirmButton();
		confirm.setBounds(upload.getX()+200, upload.getY(), 100, 30);
		confirm.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			confirmChange();
		}});
		add(confirm);
		
		Button cancel = new CanButton();
		cancel.setBounds(confirm.getX()+confirm.getWidth()+50, confirm.getY(), 100, 30);
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
		if(imageString!=null){
			baseCodeToImage(imageString);
			showpic();
		}
	}
	private void showpic(){
//		pic.setIcon(new ImageIcon("test.jpg"));
		readAndDisplayImage("test.jpg");
	}
	private void baseCodeToImage(String baseCode){
		if(baseCode.isEmpty())return;
		BASE64Decoder decoder = new BASE64Decoder();
		try{
			byte[] bytes = decoder.decodeBuffer(baseCode);
			for(int i=0;i<bytes.length;i++){
				if(bytes[i]<0){
					bytes[i]+=256;
				}
			}
			OutputStream out = new FileOutputStream("test.jpg");
			out.write(bytes);
			out.flush();
			out.close();
		} catch(Exception e){
			return;
		}
	}
	private void readAndDisplayImage(String path){
		byte[] data = null;  
		try {  
			InputStream in = new FileInputStream(path);  
			data = new byte[in.available()];
			in.read(data);  
			in.close();
			Image bufferedImage = ImageIO.read(new File(path)); 
			int width = pic.getWidth();
			int height = bufferedImage.getHeight(null)*width/bufferedImage.getWidth(null);
			bufferedImage=bufferedImage.getScaledInstance(width, height,  Image.SCALE_SMOOTH);
			pic.setBounds(pic.getX(), pic.getY(), width, height);
			pic.setIcon(new ImageIcon(bufferedImage));
		} catch (Exception e) {  
			e.printStackTrace();  
		}
		BASE64Encoder encoder = new BASE64Encoder();  
		imageString=encoder.encode(data);
	}
	private void confirmChange(){
		if(textFieldPlate.getText().isEmpty()){
			DoHint.hint("车牌号未输入",frame);
			return;
		}
		if(imageString==null||imageString.isEmpty()){
			DoHint.hint("图片未选择!", frame);
			return;
		}
		VanVO temp=new VanVO(textFieldNum.getText(),textFieldPlate.getText(),servTime.getCalendar(),imageString,orgId);
		Result result=fatherPanel.confirmed(temp);
		DoHint.hint(result, frame,true);
		if(result.equals(Result.SUCCESS)){
			confirm.setEnabled(false);
		}
		
		
	}

}
