package edu.nju.umr.ui.orderNewUI;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.logic.orderNewLogic.ExpressOrderLogic;
import edu.nju.umr.logicService.orderNewLogic.ExpressOrderLSer;
import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.Parse;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.DatePanel;
import edu.nju.umr.ui.LocPanel;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.UMRLabel;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.Utils;
import edu.nju.umr.ui.component.button.CanButton;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.component.comboBox.UMRComboBox;
import edu.nju.umr.ui.utility.CheckLegal;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.ui.utility.Utility;
import edu.nju.umr.utility.EnumTransFactory;
import edu.nju.umr.vo.order.ExpressVO;

public class ExpressPanel extends PPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 472329397579383210L;
	protected TextField barcodeField;
	protected TextField senderField;
	protected TextField senderCompanyField;
	protected TextField senderMobileField;
	protected TextField senderPhoneField;
	protected TextField receiverField;
	protected TextField receiverCompanyField;
	protected TextField receiverMobileField;
	protected TextField receiverPhoneField;
	protected TextField volumnField;
	protected TextField weightField;
	protected TextField nameField;
	protected JFrame frame;
	protected TextField costField;
	protected TextField lengthField;
	protected TextField widthField;
	protected TextField heightField;
	protected TitleLabel titleLabel;
	protected UMRLabel barcodeLabel;
	protected UMRLabel dateLabel;
	protected UMRLabel sender;
	protected UMRLabel senderLabel;
	protected UMRLabel senderCompanyLabel;
	protected UMRLabel senderMobileLabel;
	protected UMRLabel senderPhoneLabel;
	protected UMRLabel receiver;
	protected UMRLabel receiverLabel;
	protected UMRLabel receiverCompanyLabel;
	protected UMRLabel receiverMobileLabel;
	protected UMRLabel receiverPhoneLabel;
	protected UMRLabel goodLabel;
	protected UMRLabel numLabel;
	protected JSpinner numSpinner;
	protected UMRLabel volumnLabel;
	protected UMRLabel cubeMLabel;
	protected UMRLabel weightLabel;
	protected UMRLabel kgLabel;
	protected UMRLabel nameLabel;
	protected UMRLabel pakKindLabel;
	protected UMRLabel expressKindLabel;
	protected UMRLabel lengthLabel;
	protected UMRLabel mLabelL;
	protected UMRLabel widthLabel;
	protected UMRLabel mLabelW;
	protected UMRLabel heightLabel;
	protected UMRLabel mLabelH;
	protected DatePanel datePanel;
	protected UMRComboBox<String> pakKindCombo;
	protected UMRComboBox<String> expressKindCombo;
	protected UMRLabel costLabel;
	protected Button confirmButton;
	protected Button cancelButton;
	protected LocPanel senderLoc;
	protected LocPanel receiverLoc;
	private ExpressOrderLSer logicSer;
	private String name;
	protected UMRLabel arriveLabel;
	protected TextField arriveField;
	private String userId;
	private String nowOrgId;
	protected ConfirmListener conListener;
	/**
	 * Create the panel.
	 */
	public ExpressPanel(JFrame fr,ExpressVO vo)
	{
		this(fr,vo.getOpName(),vo.getUserId(),vo.getNowOrgId());
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
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
		
		arriveField.setText(DateFormat.DATE.format(vo.getArrive().getTime()));
		numSpinner.setValue(vo.getNum());
		datePanel.setDate(vo.getCreateDate());
		pakKindCombo.setSelectedItem(EnumTransFactory.checkParse(vo.getParse()));
		expressKindCombo.setSelectedItem(EnumTransFactory.checkExpress(vo.getKind()));
		senderLoc.setLoc(vo.getSendLoc());
		receiverLoc.setLoc(vo.getReceiveLoc());
		
		
		
	}
	public ExpressPanel(JFrame fr,String name,String userId,String orgId) {
		setLayout(null);
		frame=fr;
		logicSer = new ExpressOrderLogic();
//		logicSer = new ExpressPanelStub();
		this.name = name;
		this.userId = userId;
		this.nowOrgId=orgId;
		
		titleLabel = new TitleLabel("订单");
		titleLabel.setBounds(437, 21, 240, 35);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(Utils.TITLE_FONT);
		add(titleLabel);
		
		barcodeLabel = new UMRLabel("订单条形码号");
		barcodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		barcodeLabel.setStdFont();
		barcodeLabel.setBounds(189, 86, 120, 24);
		add(barcodeLabel);
		
		barcodeField = new TextField();
		barcodeField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		barcodeField.setColumns(10);
		barcodeField.setBounds(337, 86, 165, 25);
		add(barcodeField);
		
		dateLabel=new UMRLabel("日期");
		dateLabel.setBounds(189, 133,120, 24);
		dateLabel.setStdFont();
		add(dateLabel);
		
		datePanel = new DatePanel();
		datePanel.setBounds(342, 133, 500, 24);
		add(datePanel);
		
		sender = new UMRLabel("寄件人");
		sender.setHorizontalAlignment(SwingConstants.CENTER);
		sender.setStdFont();
		sender.setBounds(159, 178, 120, 24);
		add(sender);
		
		senderLabel = new UMRLabel("姓名");
		senderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderLabel.setStdFont();
		senderLabel.setBounds(253, 212, 120, 24);
		add(senderLabel);
		
		senderField = new TextField();
		senderField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		senderField.setColumns(10);
		senderField.setBounds(343, 212, 83, 25);
		add(senderField);
		
		senderCompanyLabel = new UMRLabel("单位");
		senderCompanyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderCompanyLabel.setStdFont();
		senderCompanyLabel.setBounds(836, 253, 62, 24);
		add(senderCompanyLabel);
		
		senderCompanyField = new TextField();
		senderCompanyField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		senderCompanyField.setColumns(10);
		senderCompanyField.setBounds(892, 252, 165, 25);
		add(senderCompanyField);
		
		senderMobileLabel = new UMRLabel("手机");
		senderMobileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderMobileLabel.setStdFont();
		senderMobileLabel.setBounds(253, 253, 120, 24);
		add(senderMobileLabel);
		
		senderMobileField = new TextField();
		senderMobileField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		senderMobileField.setColumns(10);
		senderMobileField.setBounds(343, 253, 193, 25);
		add(senderMobileField);
		
		senderPhoneLabel = new UMRLabel("电话");
		senderPhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		senderPhoneLabel.setStdFont();
		senderPhoneLabel.setBounds(546, 253, 62, 24);
		add(senderPhoneLabel);
		
		senderPhoneField = new TextField();
		senderPhoneField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		senderPhoneField.setColumns(10);
		senderPhoneField.setBounds(613, 252, 216, 25);
		add(senderPhoneField);
		
		receiver = new UMRLabel("收件人");
		receiver.setHorizontalAlignment(SwingConstants.CENTER);
		receiver.setStdFont();
		receiver.setBounds(159, 287, 120, 24);
		add(receiver);
		
		senderLoc = new LocPanel(frame,this);
		senderLoc.setBounds(437, 204, 600, 50);
		add(senderLoc);
		
		receiverLabel = new UMRLabel("姓名");
		receiverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverLabel.setStdFont();
		receiverLabel.setBounds(253, 321, 120, 24);
		add(receiverLabel);
		
		receiverField = new TextField();
		receiverField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		receiverField.setColumns(10);
		receiverField.setBounds(343, 321, 83, 25);
		add(receiverField);
		
		receiverCompanyLabel = new UMRLabel("单位");
		receiverCompanyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverCompanyLabel.setStdFont();
		receiverCompanyLabel.setBounds(836, 362, 62, 24);
		add(receiverCompanyLabel);
		
		receiverCompanyField = new TextField();
		receiverCompanyField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		receiverCompanyField.setColumns(10);
		receiverCompanyField.setBounds(892, 362, 165, 25);
		add(receiverCompanyField);
		
		receiverMobileLabel = new UMRLabel("手机");
		receiverMobileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverMobileLabel.setStdFont();
		receiverMobileLabel.setBounds(253, 362, 120, 24);
		add(receiverMobileLabel);
		
		receiverMobileField = new TextField();
		receiverMobileField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		receiverMobileField.setColumns(10);
		receiverMobileField.setBounds(343, 362, 193, 25);
		add(receiverMobileField);
		
		receiverPhoneLabel = new UMRLabel("电话");
		receiverPhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		receiverPhoneLabel.setStdFont();
		receiverPhoneLabel.setBounds(546, 362, 62, 24);
		add(receiverPhoneLabel);
		
		receiverPhoneField = new TextField();
		receiverPhoneField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		receiverPhoneField.setColumns(10);
		receiverPhoneField.setBounds(613, 362, 216, 25);
		add(receiverPhoneField);
		
		receiverLoc = new LocPanel(frame,this);
		receiverLoc.setBounds(437, 312, 600,50);
		add(receiverLoc);
		
		goodLabel = new UMRLabel("货物信息");
		goodLabel.setHorizontalAlignment(SwingConstants.CENTER);
		goodLabel.setStdFont();
		goodLabel.setBounds(159, 396, 120, 24);
		add(goodLabel);
		
		numLabel = new UMRLabel("件数");
		numLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		numLabel.setBounds(253, 430, 120, 24);
		add(numLabel);
		
		numSpinner = new JSpinner();
		numSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		numSpinner.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		numSpinner.setBounds(337, 429, 48, 26);
		add(numSpinner);
		
		volumnLabel = new UMRLabel("体积");
		volumnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		volumnLabel.setStdFont();
		volumnLabel.setBounds(724, 430, 62, 24);
		add(volumnLabel);
		
		volumnField = new TextField();
		volumnField.setEditable(false);
		volumnField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		volumnField.setColumns(10);
		volumnField.setBounds(779, 430, 50, 25);
		volumnField.setEnabled(false);
		volumnField.addFocusListener(new MyFocusListener());
		add(volumnField);
		
		cubeMLabel = new UMRLabel("m³");
		cubeMLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cubeMLabel.setStdFont();
		cubeMLabel.setBounds(833, 430, 41, 24);
		add(cubeMLabel);
		
		weightLabel = new UMRLabel("重量");
		weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		weightLabel.setStdFont();
		weightLabel.setBounds(854, 430, 62, 25);
		add(weightLabel);
		
		weightField = new TextField();
		weightField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		weightField.setColumns(10);
		weightField.setBounds(914, 430, 50, 25);
		weightField.addFocusListener(new MyFocusListener());
		add(weightField);
		
		kgLabel = new UMRLabel("kg");
		kgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		kgLabel.setStdFont();
		kgLabel.setBounds(962, 430, 41, 24);
		add(kgLabel);
		
		nameLabel = new UMRLabel("内件品名");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setStdFont();
		nameLabel.setBounds(271, 464, 120, 24);
		add(nameLabel);
		
		nameField = new TextField();
		nameField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		nameField.setColumns(10);
		nameField.setBounds(389, 464, 193, 25);
		add(nameField);
		
		pakKindLabel = new UMRLabel("包装种类");
		pakKindLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pakKindLabel.setStdFont();
		pakKindLabel.setBounds(271, 503, 120, 24);
		add(pakKindLabel);
		
		pakKindCombo = new UMRComboBox<String>();
		pakKindCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"纸箱", "木箱", "快递袋"}));
		pakKindCombo.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		pakKindCombo.setBounds(389, 503, 103, 25);
		pakKindCombo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				getPrice();
			}
		});
		add(pakKindCombo);
		
		expressKindLabel = new UMRLabel("快递种类");
		expressKindLabel.setHorizontalAlignment(SwingConstants.CENTER);
		expressKindLabel.setStdFont();
		expressKindLabel.setBounds(512, 503, 120, 24);
		add(expressKindLabel);
		
		expressKindCombo = new UMRComboBox<String>();
		expressKindCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"经济快递", "标准快递", "特快专递"}));
		expressKindCombo.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		expressKindCombo.setBounds(629, 503, 123, 25);
		expressKindCombo.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				getPrice();
			}
		});
		add(expressKindCombo);
		
		costLabel = new UMRLabel("费用/元");
		costLabel.setHorizontalAlignment(SwingConstants.LEFT);
		costLabel.setStdFont();
		costLabel.setBounds(760, 503, 83, 24);
		add(costLabel);
		
		confirmButton = new ConfirmButton();
		confirmButton.setBounds(450, 556, 100, 30);
		conListener = new ConfirmListener();
		confirmButton.addActionListener(conListener);
		add(confirmButton);
		
		cancelButton = new CanButton();
		cancelButton.setName("cancel");
		cancelButton.setBounds(590, 556,100, 30);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
			}
		});
		add(cancelButton);
		
		costField = new TextField();
		costField.setEditable(false);
		costField.setBounds(832, 503, 66, 21);
		costField.setEnabled(false);
		add(costField);
		costField.setColumns(10);
		
		lengthLabel = new UMRLabel("长");
		lengthLabel.setBounds(405, 430, 41, 24);
		lengthLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		add(lengthLabel);
		
		lengthField = new TextField();
		lengthField.setBounds(437, 430, 50, 25);
		add(lengthField);
		lengthField.addFocusListener(new MyFocusListener());
		lengthField.setColumns(10);
		
		mLabelL = new UMRLabel("m");
		mLabelL.setBounds(503, 430, 32, 24);
		mLabelL.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		add(mLabelL);
		
		widthLabel = new UMRLabel("宽");
		widthLabel.setBounds(520, 430, 62, 24);
		widthLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		add(widthLabel);
		
		widthField = new TextField();
		widthField.setBounds(549, 430, 50, 25);
		widthField.addFocusListener(new MyFocusListener());
		add(widthField);
		widthField.setColumns(10);
		
		mLabelW = new UMRLabel("m");
		mLabelW.setBounds(609, 430, 32, 24);
		mLabelW.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		add(mLabelW);
		
		heightLabel = new UMRLabel("高");
		heightLabel.setBounds(625, 430, 62, 24);
		heightLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		add(heightLabel);
		
		heightField = new TextField();
		heightField.setBounds(651, 430, 50, 25);
		heightField.addFocusListener(new MyFocusListener());
		add(heightField);
		heightField.setColumns(10);
		
		mLabelH = new UMRLabel("m");
		mLabelH.setBounds(711, 430, 41, 24);
		mLabelH.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		add(mLabelH);

		
		arriveLabel = new UMRLabel("到达时间");
		arriveLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		arriveLabel.setBounds(592, 464, 93, 22);
		add(arriveLabel);
		
		arriveField = new TextField();
		arriveField.setEditable(false);
		arriveField.setBounds(684, 464, 187, 25);
		arriveField.setEnabled(false);
		add(arriveField);
		arriveField.setColumns(10);
	}
	
	public class ConfirmListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(isLegal()){
				Result result = logicSer.create(createVO());
				DoHint.hint(result, frame,true);
				if(result.equals(Result.SUCCESS)){
					confirmButton.setEnabled(false);
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
				senderLoc.getProvince(),senderLoc.getCity(),receiverLoc.getProvince(),receiverLoc.getCity(),userId,nowOrgId);
		return vo;
		
	}
	public void setEnabled(boolean enabled)
	{
		super.setEnabled(enabled);
		for(Component co:this.getComponents())
		{
			if(co.getName()==null)
			co.setEnabled(enabled);
		}
	}
	public void getPrice(){
		if(name.equals("")){
			return;
		}
		String city1=senderLoc.getCity();
		String city2=receiverLoc.getCity();
		if(city1.isEmpty())return;
		if(city2.isEmpty())return;
		if(weightField.getText().isEmpty())return;
		if(volumnField.getText().isEmpty())return;

		double weight=Double.parseDouble(weightField.getText());
		
		weight=Double.max(weight, Double.parseDouble(volumnField.getText())/5000);
		Express[] expresses = Express.values();
		Parse[] parses = Parse.values();
 		String data=logicSer.getPrice(city1, city2,expresses[expressKindCombo.getSelectedIndex()],parses[pakKindCombo.getSelectedIndex()],weight);
		costField.setText(data);
	}
	public void getTime(){
		if(name.equals("")){
			return;
		}
		String city1=senderLoc.getCity();
		String city2=receiverLoc.getCity();
		if(city1.isEmpty())return;
		if(city2.isEmpty())return;
		int day =logicSer.getTime(city1, city2);
		Calendar arrive = Calendar.getInstance();
		arrive.add(Calendar.DAY_OF_YEAR, day);
		arriveField.setText(DateFormat.DATE.format(arrive.getTime()));
	}
	private void getVol(){
		if(name.equals("")){
			return;
		}
		if(lengthField.getText().isEmpty())return;
		if(widthField.getText().isEmpty())return;
		if(heightField.getText().isEmpty())return;
		
		double vol=Double.parseDouble(lengthField.getText())*Double.parseDouble(widthField.getText())*Double.parseDouble(heightField.getText());
		volumnField.setText(Double.toString(vol));
	}
	private class MyFocusListener implements FocusListener{
		public void focusGained(FocusEvent e) {
		}
		public void focusLost(FocusEvent e) {
			getVol();
			getPrice();
			getTime();
		}
	}
}
