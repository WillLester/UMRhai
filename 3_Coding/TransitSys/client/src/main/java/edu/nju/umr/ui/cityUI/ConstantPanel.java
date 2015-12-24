package edu.nju.umr.ui.cityUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import edu.nju.umr.logic.cityLogic.ConstantLogic;
import edu.nju.umr.logicService.cityLogicSer.ConstantLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.button.ConfirmButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ConstantVO;
import edu.nju.umr.vo.ResultMessage;


public class ConstantPanel extends PPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3910636508748161665L;
	private TextField planeField;
	private TextField trainField;
	private TextField vanField;
	private TextField planeCostField;
	private TextField trainCostField;
	private TextField vanCostField;
	private TextField economicField;
	private TextField normalField;
	private TextField fastField;
	private JFrame frame;
	private ConstantLSer logicSer;
	/**
	 * Create the panel.
	 */
	public ConstantPanel(JFrame fr,String name) {
		setLayout(null);
		frame=fr;
		logicSer = new ConstantLogic();
//		logicSer = new ConstantPanelStub();
		
		
		JLabel titleLabel = new JLabel("常量制定");
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(367, 10, 242, 82);
		add(titleLabel);
		
		JLabel planeLabel = new JLabel("飞机满载量(吨)");
		planeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		planeLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		planeLabel.setBounds(246, 94, 90, 15);
		add(planeLabel);
		
		JLabel trainLabel = new JLabel("火车满载量(吨)");
		trainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		trainLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		trainLabel.setBounds(246, 144, 90, 15);
		add(trainLabel);
		
		JLabel vanLabel = new JLabel("汽车满载量(吨)");
		vanLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vanLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		vanLabel.setBounds(246, 191, 90, 15);
		add(vanLabel);
		
		planeField = new TextField();
		planeField.setBounds(362, 91, 60, 21);
		add(planeField);
		planeField.setColumns(10);
		
		trainField = new TextField();
		trainField.setColumns(10);
		trainField.setBounds(362, 141, 60, 21);
		add(trainField);
		
		vanField = new TextField();
		vanField.setColumns(10);
		vanField.setBounds(362, 188, 60, 21);
		add(vanField);
		
		JLabel planeCostLabel = new JLabel("飞机运费(元每公里每吨)");
		planeCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		planeCostLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		planeCostLabel.setBounds(466, 94, 143, 15);
		add(planeCostLabel);
		
		JLabel trainCostLabel = new JLabel("火车运费(元每公里每吨)");
		trainCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		trainCostLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		trainCostLabel.setBounds(466, 144, 143, 15);
		add(trainCostLabel);
		
		JLabel vanCostLabel = new JLabel("汽车运费(元每公里每吨)");
		vanCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		vanCostLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		vanCostLabel.setBounds(466, 188, 143, 15);
		add(vanCostLabel);
		
		planeCostField = new TextField();
		planeCostField.setColumns(10);
		planeCostField.setBounds(637, 91, 60, 21);
		add(planeCostField);
		
		trainCostField = new TextField();
		trainCostField.setColumns(10);
		trainCostField.setBounds(637, 141, 60, 21);
		add(trainCostField);
		
		vanCostField = new TextField();
		vanCostField.setColumns(10);
		vanCostField.setBounds(637, 188, 60, 21);
		add(vanCostField);
		
		JLabel priceLabel = new JLabel("快递价格比");
		priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		priceLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		priceLabel.setBounds(246, 266, 90, 15);
		add(priceLabel);
		
		JLabel economicLabel = new JLabel("经济快递/元");
		economicLabel.setHorizontalAlignment(SwingConstants.CENTER);
		economicLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		economicLabel.setBounds(346, 266, 67, 15);
		add(economicLabel);
		
		economicField = new TextField();
		economicField.setColumns(10);
		economicField.setBounds(410, 263, 43, 21);
		add(economicField);
		
		JLabel colonLabel1 = new JLabel(":");
		colonLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		colonLabel1.setFont(new Font("宋体", Font.PLAIN, 12));
		colonLabel1.setBounds(451, 266, 13, 15);
		add(colonLabel1);
		
		JLabel normalLabel = new JLabel("标准快递/元");
		normalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		normalLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		normalLabel.setBounds(458, 266, 67, 15);
		add(normalLabel);
		
		normalField = new TextField();
		normalField.setColumns(10);
		normalField.setBounds(519, 263, 43, 21);
		add(normalField);
		
		JLabel colonLabel2 = new JLabel(":");
		colonLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		colonLabel2.setFont(new Font("宋体", Font.PLAIN, 12));
		colonLabel2.setBounds(563, 266, 13, 15);
		add(colonLabel2);
		
		JLabel fastLabel = new JLabel("次晨特快/元");
		fastLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fastLabel.setFont(new Font("宋体", Font.PLAIN, 12));
		fastLabel.setBounds(572, 266, 67, 15);
		add(fastLabel);
		
		fastField = new TextField();
		fastField.setColumns(10);
		fastField.setBounds(637, 263, 43, 21);
		add(fastField);
		
		ResultMessage message = logicSer.getConstant();
		if(message.getReInfo().equals(Result.SUCCESS)){
			ConstantVO constant = (ConstantVO) message.getMessage();
			planeField.setText(""+constant.getMaxLoadPlane());
			trainField.setText(""+constant.getMaxLoadTrain());
			vanField.setText(""+constant.getMaxLoadVan());
			planeCostField.setText(""+constant.getPricePlane());
			trainCostField.setText(""+constant.getPriceTrain());
			vanCostField.setText(""+constant.getPriceVan());
			economicField.setText(""+constant.getLvEco());
			normalField.setText(""+constant.getLvStd());
			fastField.setText(""+constant.getLvVip());
		} else if(message.getReInfo().equals(Result.FILE_NOT_FOUND)){
			planeField.setText("50");
			trainField.setText("2000");
			vanField.setText("10");
			planeCostField.setText("20");
			trainCostField.setText("0.2");
			vanCostField.setText("2");
			economicField.setText("18");
			normalField.setText("23");
			fastField.setText("25");
		} else {
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame(message.getReInfo(), frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
		}
		
		Button confirmButton = new ConfirmButton();
		confirmButton.setBounds(312, 425, 100, 30);
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(isLegal()){
					Result result = logicSer.setConstant(createConstant(),name);
					DoHint.hint(result, frame, true);
					if(result.equals(Result.SUCCESS)){
						confirmButton.setEnabled(false);
					}
				}
			}
		});		
		add(confirmButton);
		
		Button exitButton = new ExitButton();
		exitButton.setBounds(519, 427, 100, 30);
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
		try{
			Double.parseDouble(planeField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("飞机满载量格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if(Double.parseDouble(planeField.getText())<0){
			HintFrame hint = new HintFrame("飞机满载量应为正！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		try {
			Double.parseDouble(trainField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("火车满载量格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if(Double.parseDouble(trainField.getText())<0){
			HintFrame hint = new HintFrame("火车满载量应为正！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		try {
			Double.parseDouble(vanField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("汽车满载量格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if(Double.parseDouble(vanField.getText())<0){
			HintFrame hint = new HintFrame("汽车满载量应为正！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		try {
			Double.parseDouble(planeCostField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("飞机运费格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if(Double.parseDouble(planeCostField.getText())<0){
			HintFrame hint = new HintFrame("飞机运费应为正！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		try {
			Double.parseDouble(trainCostField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("火车运费格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if(Double.parseDouble(trainCostField.getText())<0){
			HintFrame hint = new HintFrame("火车运费应为正！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		try {
			Double.parseDouble(vanCostField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("汽车运费格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if(Double.parseDouble(vanCostField.getText())<0){
			HintFrame hint = new HintFrame("汽车运费应为正！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		try {
			Double.parseDouble(economicField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("经济快递格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if(Double.parseDouble(economicField.getText())<0){
			HintFrame hint = new HintFrame("经济快递费用应为正！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		try {
			Double.parseDouble(normalField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("标准快递格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if(Double.parseDouble(normalField.getText())<0){
			HintFrame hint = new HintFrame("标准快递费用应为正！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		try {
			Double.parseDouble(fastField.getText());
		} catch (NumberFormatException e){
			HintFrame hint = new HintFrame("次晨快递格式错误！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		if(Double.parseDouble(fastField.getText())<0){
			HintFrame hint = new HintFrame("次晨快递费用应为正！", frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
			return false;
		}
		return true;
	}
	private ConstantVO createConstant(){
		ConstantVO vo = new ConstantVO(new BigDecimal(planeField.getText()), new BigDecimal(trainField.getText()), new BigDecimal(vanField.getText()), 
				new BigDecimal(planeCostField.getText()), new BigDecimal(trainCostField.getText()), new BigDecimal(vanCostField.getText()), 
				new BigDecimal(economicField.getText()), new BigDecimal(normalField.getText()), new BigDecimal(fastField.getText()));
		return vo;
	}
}