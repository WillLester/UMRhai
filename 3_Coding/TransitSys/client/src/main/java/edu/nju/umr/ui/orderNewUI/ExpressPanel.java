package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderNewLogic.ExpressOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.ExpressOrderLSer;
import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.LocPanel;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Utility;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.order.ExpressVO;

public class ExpressPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 472329397579383210L;
	protected JTextField barcodeField;
	protected JTextField senderField;
	protected JTextField senderCompanyField;
	protected JTextField senderMobileField;
	protected JTextField senderPhoneField;
	protected JTextField receiverField;
	protected JTextField receiverCompanyField;
	protected JTextField receiverMobileField;
	protected JTextField receiverPhoneField;
	protected JTextField volumnField;
	protected JTextField weightField;
	protected JTextField nameField;
	protected JFrame frame;
	protected JTextField costField;
	protected JTextField lengthField;
	protected JTextField widthField;
	protected JTextField heightField;
	protected JLabel titleLabel;
	protected JLabel barcodeLabel;
	protected JLabel dateLabel;
	protected JLabel sender;
	protected JLabel senderLabel;
	protected JLabel senderCompanyLabel;
	protected JLabel senderMobileLabel;
	protected JLabel senderPhoneLabel;
	protected JLabel receiver;
	protected JLabel receiverLabel;
	protected JLabel receiverCompanyLabel;
	protected JLabel receiverMobileLabel;
	protected JLabel receiverPhoneLabel;
	protected JLabel goodLabel;
	protected JLabel numLabel;
	protected JSpinner numSpinner;
	protected JLabel volumnLabel;
	protected JLabel cubeMLabel;
	protected JLabel weightLabel;
	protected JLabel kgLabel;
	protected JLabel nameLabel;
	protected JLabel pakKindLabel;
	protected JLabel expressKindLabel;
	protected JLabel lengthLabel;
	protected JLabel mLabelL;
	protected JLabel widthLabel;
	protected JLabel mLabelW;
	protected JLabel heightLabel;
	protected JLabel mLabelH;
	protected DatePanel datePanel;
	protected JComboBox<String> pakKindCombo;
	protected JComboBox<String> expressKindCombo;
	protected JLabel costLabel;
	protected JButton confirmButton;
	protected JButton cancelButton;
	protected LocPanel senderLoc;
	protected LocPanel receiverLoc;
	private ExpressOrderLSer logicSer;
	private String name;
	protected JLabel arriveLabel;
	protected JTextField arriveField;
	/**
	 * Create the panel.
	 */
	public ExpressPanel(JFrame fr,ExpressVO vo)
	{
		this(fr,vo.getOpName());
		for(Component co:this.getComponents())
		{
			co.setEnabled(false);
		}
		barcodeField.setText(vo.getId());
		senderField.setText(vo.getSender());
		senderCompanyField.setText(vo.getSendUnit());
		senderMobileField.setText(vo.getSendMobile());
		senderPhoneField.setText(vo.getSendPhone());
		receiverField.setText(vo.getReceiver());
		receiverCompanyField.setText(vo.getReceiveUnit());
		receiverMobileField.setText(vo.getReceiveMobile());
		receiverPhoneField.setText(vo.getReceivePhone());
		volumnField.setText(Double.toString(vo.getVolumn()));
		weightField.setText(Double.toString(vo.getWeight()));
		nameField.setText(vo.getName());
		costField.setText(Double.toString(vo.getCost()));
		lengthField.setText(Double.toString(vo.getLength()));
		widthField.setText(Double.toString(vo.getWidth()));
		heightField.setText(Double.toString(vo.getHeight()));
		arriveField.setText(vo.getArrive().toString());
		numSpinner.setValue(vo.getNum());
		datePanel.setDate(vo.getCreateDate());
		pakKindCombo.setSelectedItem(EnumTransFactory.checkParse(vo.getParse()));
		expressKindCombo.setSelectedItem(EnumTransFactory.checkExpress(vo.getKind()));
		
		
	}
	public ExpressPanel(JFrame fr,String name) {
		setLayout(null);
		frame=fr;
		logicSer = new ExpressOrderLogic();
		this.name = name;
		
		titleLabel = new JLabel("订单创建");
		titleLabel.setBounds(437, 21, 120, 35);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		add(titleLabel);
		
		barcodeLabel = new JLabel("订单条形码号");
		barcodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		barcodeLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		barcodeLabel.setBounds(189, 66, 120, 24);
		add(barcodeLabel);
		
		barcodeField = new JTextField();
		barcodeField.setFont(new Font("宋体", Font.PLAIN, 20));
		barcodeField.setColumns(10);
		barcodeField.setBounds(337, 65, 165, 25);
		add(barcodeField);
		
		dateLabel=new JLabel("日期");
		dateLabel.setBounds(189, 113,120, 24);
		dateLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(342, 113, 500, 24);
		add(datePanel);
		
		sender = new JLabel("寄件人");
		sender.setHorizontalAlignment(SwingConstants.CENTER);
		sender.setFont(new Font("宋体", Font.PLAIN, 20));
		sender.setBounds(159, 158, 120, 24);
		add(sender);
		
		senderLabel = new JLabel("姓名");
		senderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderLabel.setBounds(253, 192, 120, 24);
		add(senderLabel);
		
		senderField = new JTextField();
		senderField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderField.setColumns(10);
		senderField.setBounds(343, 192, 83, 25);
		add(senderField);
		
		senderCompanyLabel = new JLabel("单位");
		senderCompanyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderCompanyLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderCompanyLabel.setBounds(836, 233, 62, 24);
		add(senderCompanyLabel);
		
		senderCompanyField = new JTextField();
		senderCompanyField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderCompanyField.setColumns(10);
		senderCompanyField.setBounds(892, 232, 165, 25);
		add(senderCompanyField);
		
		senderMobileLabel = new JLabel("手机");
		senderMobileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderMobileLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderMobileLabel.setBounds(253, 233, 120, 24);
		add(senderMobileLabel);
		
		senderMobileField = new JTextField();
		senderMobileField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderMobileField.setColumns(10);
		senderMobileField.setBounds(343, 233, 193, 25);
		add(senderMobileField);
		
		senderPhoneLabel = new JLabel("电话");
		senderPhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderPhoneLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		senderPhoneLabel.setBounds(546, 233, 62, 24);
		add(senderPhoneLabel);
		
		senderPhoneField = new JTextField();
		senderPhoneField.setFont(new Font("宋体", Font.PLAIN, 20));
		senderPhoneField.setColumns(10);
		senderPhoneField.setBounds(613, 232, 216, 25);
		add(senderPhoneField);
		
		receiver = new JLabel("收件人");
		receiver.setHorizontalAlignment(SwingConstants.CENTER);
		receiver.setFont(new Font("宋体", Font.PLAIN, 20));
		receiver.setBounds(159, 267, 120, 24);
		add(receiver);
		
		senderLoc = new LocPanel(frame);
		senderLoc.setBounds(437, 184, 600, 50);
		add(senderLoc);
		
		receiverLabel = new JLabel("姓名");
		receiverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverLabel.setBounds(253, 301, 120, 24);
		add(receiverLabel);
		
		receiverField = new JTextField();
		receiverField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverField.setColumns(10);
		receiverField.setBounds(343, 301, 83, 25);
		add(receiverField);
		
		receiverCompanyLabel = new JLabel("单位");
		receiverCompanyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverCompanyLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverCompanyLabel.setBounds(836, 342, 62, 24);
		add(receiverCompanyLabel);
		
		receiverCompanyField = new JTextField();
		receiverCompanyField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverCompanyField.setColumns(10);
		receiverCompanyField.setBounds(892, 342, 165, 25);
		add(receiverCompanyField);
		
		receiverMobileLabel = new JLabel("手机");
		receiverMobileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverMobileLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverMobileLabel.setBounds(253, 342, 120, 24);
		add(receiverMobileLabel);
		
		receiverMobileField = new JTextField();
		receiverMobileField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverMobileField.setColumns(10);
		receiverMobileField.setBounds(343, 342, 193, 25);
		add(receiverMobileField);
		
		receiverPhoneLabel = new JLabel("电话");
		receiverPhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverPhoneLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverPhoneLabel.setBounds(546, 342, 62, 24);
		add(receiverPhoneLabel);
		
		receiverPhoneField = new JTextField();
		receiverPhoneField.setFont(new Font("宋体", Font.PLAIN, 20));
		receiverPhoneField.setColumns(10);
		receiverPhoneField.setBounds(613, 342, 216, 25);
		add(receiverPhoneField);
		
		receiverLoc = new LocPanel(frame);
		receiverLoc.setBounds(437, 292, 600,50);
		add(receiverLoc);
		
		goodLabel = new JLabel("货物信息");
		goodLabel.setHorizontalAlignment(SwingConstants.CENTER);
		goodLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		goodLabel.setBounds(159, 376, 120, 24);
		add(goodLabel);
		
		numLabel = new JLabel("件数");
		numLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		numLabel.setBounds(253, 410, 120, 24);
		add(numLabel);
		
		numSpinner = new JSpinner();
		numSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		numSpinner.setFont(new Font("宋体", Font.PLAIN, 20));
		numSpinner.setBounds(337, 409, 48, 26);
		add(numSpinner);
		
		volumnLabel = new JLabel("体积");
		volumnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		volumnLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		volumnLabel.setBounds(724, 410, 62, 24);
		add(volumnLabel);
		
		volumnField = new JTextField();
		volumnField.setEditable(false);
		volumnField.setFont(new Font("宋体", Font.PLAIN, 20));
		volumnField.setColumns(10);
		volumnField.setBounds(779, 410, 50, 25);
		add(volumnField);
		
		cubeMLabel = new JLabel("m³");
		cubeMLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cubeMLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		cubeMLabel.setBounds(833, 410, 41, 24);
		add(cubeMLabel);
		
		weightLabel = new JLabel("重量");
		weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weightLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		weightLabel.setBounds(854, 410, 62, 25);
		add(weightLabel);
		
		weightField = new JTextField();
		weightField.setFont(new Font("宋体", Font.PLAIN, 20));
		weightField.setColumns(10);
		weightField.setBounds(914, 410, 50, 25);
		add(weightField);
		
		kgLabel = new JLabel("kg");
		kgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		kgLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		kgLabel.setBounds(962, 410, 41, 24);
		add(kgLabel);
		
		nameLabel = new JLabel("内件品名");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		nameLabel.setBounds(271, 444, 120, 24);
		add(nameLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("宋体", Font.PLAIN, 20));
		nameField.setColumns(10);
		nameField.setBounds(389, 444, 193, 25);
		add(nameField);
		
		pakKindLabel = new JLabel("包装种类");
		pakKindLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pakKindLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		pakKindLabel.setBounds(271, 483, 120, 24);
		add(pakKindLabel);
		
		pakKindCombo = new JComboBox<String>();
		pakKindCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"纸箱", "木箱", "快递袋"}));
		pakKindCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		pakKindCombo.setBounds(389, 483, 103, 25);
		add(pakKindCombo);
		
		expressKindLabel = new JLabel("快递种类");
		expressKindLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressKindLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		expressKindLabel.setBounds(512, 483, 120, 24);
		add(expressKindLabel);
		
		expressKindCombo = new JComboBox<String>();
		expressKindCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"经济快递", "标准快递", "特快专递"}));
		expressKindCombo.setFont(new Font("宋体", Font.PLAIN, 20));
		expressKindCombo.setBounds(629, 483, 123, 25);
		add(expressKindCombo);
		
		costLabel = new JLabel("费用：");
		costLabel.setHorizontalAlignment(SwingConstants.LEFT);
		costLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		costLabel.setBounds(779, 483, 83, 24);
		add(costLabel);
		
		confirmButton = new JButton("确定");
		confirmButton.setFont(new Font("宋体", Font.PLAIN, 20));
		confirmButton.setBounds(418, 536, 93, 23);
		confirmButton.addActionListener(new ConfirmListener());
		add(confirmButton);
		
		cancelButton = new JButton("取消");
		cancelButton.setFont(new Font("宋体", Font.PLAIN, 20));
		cancelButton.setBounds(642, 536, 93, 23);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancelButton);
		
		costField = new JTextField();
		costField.setEditable(false);
		costField.setBounds(832, 483, 66, 21);
		add(costField);
		costField.setColumns(10);
		
		lengthLabel = new JLabel("长");
		lengthLabel.setBounds(405, 410, 41, 24);
		lengthLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		add(lengthLabel);
		
		lengthField = new JTextField();
		lengthField.setBounds(437, 410, 50, 25);
		add(lengthField);
		lengthField.setColumns(10);
		
		mLabelL = new JLabel("m");
		mLabelL.setBounds(503, 410, 32, 24);
		mLabelL.setFont(new Font("宋体", Font.PLAIN, 20));
		add(mLabelL);
		
		widthLabel = new JLabel("宽");
		widthLabel.setBounds(520, 410, 62, 24);
		widthLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		add(widthLabel);
		
		widthField = new JTextField();
		widthField.setBounds(549, 410, 50, 25);
		add(widthField);
		widthField.setColumns(10);
		
		mLabelW = new JLabel("m");
		mLabelW.setBounds(609, 410, 32, 24);
		mLabelW.setFont(new Font("宋体", Font.PLAIN, 20));
		add(mLabelW);
		
		heightLabel = new JLabel("高");
		heightLabel.setBounds(625, 410, 62, 24);
		heightLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		add(heightLabel);
		
		heightField = new JTextField();
		heightField.setBounds(651, 410, 50, 25);
		add(heightField);
		heightField.setColumns(10);
		
		mLabelH = new JLabel("m");
		mLabelH.setBounds(711, 410, 41, 24);
		mLabelH.setFont(new Font("宋体", Font.PLAIN, 20));
		add(mLabelH);

		
		arriveLabel = new JLabel("到达时间");
		arriveLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		arriveLabel.setBounds(592, 444, 93, 22);
		add(arriveLabel);
		
		arriveField = new JTextField();
		arriveField.setEditable(false);
		arriveField.setBounds(684, 444, 187, 25);
		add(arriveField);
		arriveField.setColumns(10);
	}
	
	public class ConfirmListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			if(isLegal()){
				Result result = logicSer.create(createVO());
				if(result.equals(Result.SUCCESS)){
					
				} else {
					DoHint.hint(result, frame);
				}
			}
		}
		
	}
	private boolean isLegal(){
		String barcodeRe = CheckLegal.isExpressLegal(barcodeField.getText());
		if(barcodeRe != null){
			DoHint.hint(barcodeRe, frame);
			return false;
		}
		if(sender.getText().equals("")){
			DoHint.hint("请填写寄件人！", frame);
			return false;
		}
		if(!senderLoc.isLegal()){
			return false;
		}
		if((senderMobileField.getText().equals(""))&&(senderPhoneField.getText().equals(""))){
			DoHint.hint("请填写寄件人手机或电话！", frame);
			return false;
		} else {
			if(senderMobileField.getText().length() != 11){
				DoHint.hint("寄件人手机号长度错误！", frame);
				return false;
			}
			if(!Utility.isNumberic(senderMobileField.getText())){
				DoHint.hint("寄件人手机号格式错误！", frame);
				return false;
			}
		}
		if(receiver.getText().equals("")){
			DoHint.hint("请填写收件人！", frame);
			return false;
		}
		if(!receiverLoc.isLegal()){
			return false;
		}
		if((receiverMobileField.getText().equals(""))&&(receiverPhoneField.getText().equals(""))){
			DoHint.hint("请填写收件人手机或电话！", frame);
			return false;
		} else {
			if(receiverMobileField.getText().length() != 11){
				DoHint.hint("收件人手机号长度错误！", frame);
				return false;
			}
			if(!Utility.isNumberic(receiverMobileField.getText())){
				DoHint.hint("收件人手机号格式错误！", frame);
				return false;
			}
		}
		try {
			Double.parseDouble(weightField.getText());
		} catch (NumberFormatException e){
			DoHint.hint("重量格式不正确！", frame);
			return false;
		}
		if(Double.parseDouble(weightField.getText())<=0){
			DoHint.hint("重量不能为负！", frame);
			return false;
		}
		try{
			Double.parseDouble(lengthField.getText());
		} catch (NumberFormatException e){
			DoHint.hint("长度格式不正确！", frame);
			return false;
		}
		if(Double.parseDouble(lengthField.getText()) <= 0){
			DoHint.hint("长度不能为负！", frame);
			return false;
		}
		try {
			Double.parseDouble(widthField.getText());
		} catch (NumberFormatException e){
			DoHint.hint("宽度格式不正确！", frame);
			return false;
		}
		if(Double.parseDouble(widthField.getText()) <= 0){
			DoHint.hint("宽度不能为负！", frame);
			return false;
		}
		try {
			Double.parseDouble(heightField.getText());
		} catch (NumberFormatException e){
			DoHint.hint("高度格式不正确！", frame);
			return false;
		}
		if(Double.parseDouble(heightField.getText()) <= 0){
			DoHint.hint("高度不能为负！", frame);
			return false;
		}
		return true;
	}
	private ExpressVO createVO(){
		Date date = null;
		try {
			date = DateFormat.DATE.parse(arriveField.getText());
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Calendar arrive = Calendar.getInstance();
		arrive.setTime(date);
		ExpressVO vo = new ExpressVO(barcodeField.getText(), sender.getText(), senderLoc.getLoc(), receiver.getText(), receiverLoc.getLoc(), senderMobileField.getText(), receiverMobileField.getText(), senderPhoneField.getText(), receiverPhoneField.getText(), 
				senderCompanyField.getText(), receiverCompanyField.getText(), (Integer)numSpinner.getValue(), nameField.getText(), Double.parseDouble(lengthField.getText()), Double.parseDouble(widthField.getText()), Double.parseDouble(heightField.getText()), 
				Double.parseDouble(weightField.getText()), Double.parseDouble(volumnField.getText()), arrive, datePanel.getCalendar(), EnumTransFactory.getExpress((String)expressKindCombo.getSelectedItem()), Double.parseDouble(costField.getText()), name,EnumTransFactory.getParse((String)pakKindCombo.getSelectedItem()),
				senderLoc.getProvince(),senderLoc.getCity(),receiverLoc.getProvince(),receiverLoc.getCity());
		return vo;
		
	}

}
