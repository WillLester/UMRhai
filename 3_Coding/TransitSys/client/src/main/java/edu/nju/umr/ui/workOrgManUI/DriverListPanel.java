package edu.nju.umr.ui.workOrgManUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.workOrgManLogic.DriverManLogic;
import edu.nju.umr.logicService.workOrgManLogicSer.DriverManLSer;
import edu.nju.umr.po.enums.Gender;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.InfoFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.component.Button;
import edu.nju.umr.ui.component.PPanel;
import edu.nju.umr.ui.component.TextField;
import edu.nju.umr.ui.component.TitleLabel;
import edu.nju.umr.ui.component.UMRScrollPane;
import edu.nju.umr.ui.component.button.AddButton;
import edu.nju.umr.ui.component.button.CheckButton;
import edu.nju.umr.ui.component.button.DelButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.component.button.SearchButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.DriverVO;
import edu.nju.umr.vo.ResultMessage;

public class DriverListPanel extends PPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8718383258027786192L;
	private TextField textFieldSearch;
	private FunctionFrame frame;
	private DriverListPanel panel;
	private Table table;
	private DefaultTableModel model;
	private DriverManLSer serv;
	private ArrayList<DriverVO> driverList;
	private String name;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("unchecked")
	public DriverListPanel(FunctionFrame fr,String orgId,String name) {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		frame=fr;
		panel=this;
		this.name = name;
		serv=new DriverManLogic();
		
		TitleLabel nameLabel = new TitleLabel("司机信息列表");
//		nameLabel.setFont(new Font("微软雅黑",Font.PLAIN ,22));
//		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2,25, Constants.LABEL_WIDTH+20, Constants.LABEL_HEIGHT_S);
		add(nameLabel);
		
		textFieldSearch = new TextField();
		textFieldSearch.setText("请输入关键字或司机编号");
		textFieldSearch.setBounds(Constants.TABLE_X, Constants.TABLE_Y,300, 21);
//		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		Button search = new SearchButton();
		search.setBounds(textFieldSearch.getX()+300+20, textFieldSearch.getY(), 100, 30);
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ResultMessage message=serv.searchDriver(orgId);
				Result result=message.getReInfo();
				if(!result.equals(Result.SUCCESS))
				{
					new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
				}
				else
				{
					driverList=(ArrayList<DriverVO>)message.getMessage();
					displayDrivers();
				}
			}
		});
//		add(search);
		
		Button add = new AddButton();
		add.setBounds(this.getWidth()/2-250, Constants.TABLE_HEIGHT*7+25, 100, 30);
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				ResultMessage message = serv.getNextDriver(orgId);
				Result result = message.getReInfo();
				if(!result.equals(Result.SUCCESS))
				{
					DoHint.hint(result, frame);
				}
				else
				{
					String nextId=orgId+(String)message.getMessage();
					InfoFrame ffr=new InfoFrame("新增司机信息输入");
					ffr.setContentPane(new DriverInfoPanel(ffr,panel,new DriverVO(nextId,"",Calendar.getInstance(),
						"","",Gender.MAN,Calendar.getInstance(),Calendar.getInstance(),orgId),orgId));
					fr.sonFrames.add(ffr);
				}
			}
		});
		add(add);
		
		Button delete = new DelButton();
		delete.setBounds(add.getX()+add.getWidth()+50, add.getY(), 100, 30);
		delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				int n = JOptionPane.showConfirmDialog(frame, "确认删除吗?", "确认删除框", JOptionPane.YES_NO_OPTION);  
		        if (n == JOptionPane.YES_OPTION)
		        {
		        	Result result;
		        	result=serv.deleteDriver(driverList.get(table.getSelectedRow()).getId(),name);
		        	DoHint.hint(result, frame,false);
		        	if(result.equals(Result.SUCCESS)){
		        		model.removeRow(table.getSelectedRow());
		        	}
		        }
			}
		});
		add(delete);
		
		Button modify = new Button();
		modify.setIcon(new ImageIcon("ui/button/buttonRev.png"));
		modify.setRolloverIcon(new ImageIcon("ui/button/buttonRevSt.png"));
		modify.setPressedIcon(new ImageIcon("ui/button/buttonRevP.png"));
		modify.setBounds(delete.getX()+delete.getWidth()+50, add.getY(), 100, 30);
		modify.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				InfoFrame ffr=new InfoFrame("修改司机信息");
				ffr.setContentPane(new DriverInfoPanel(ffr,panel,driverList.get(table.getSelectedRow()),orgId));
				fr.sonFrames.add(ffr);
			}
		});
		add(modify);
		
		Button forDetail = new CheckButton();
		forDetail.setBounds(modify.getX()+modify.getWidth()+50, add.getY(), 100, 30);
//		add(forDetail);
		
		Button out = new ExitButton();
		out.setBounds(forDetail.getX()+forDetail.getWidth()+50,add.getY(),150,45);
		out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(out);
		
		tableInit();
		driverList=(ArrayList<DriverVO>)serv.searchDriver(orgId).getMessage();
		displayDrivers();
		
	}
	void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setBounds(Constants.TABLE_X, textFieldSearch.getY()+20, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new UMRScrollPane(table);
		scroll.setBounds(Constants.TABLE_X, textFieldSearch.getY()+60, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"编号","姓名","出生日期","身份证号","手机号","性别","行驶证有效期限","行驶证失效期限"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	void displayDrivers(){
		model.setRowCount(0);
		for(int i=0;i<driverList.size();i++)
		{
			DriverVO driver=driverList.get(i);
			String [] data=driver.getData();
			model.addRow(data);
		}
	}
	void addDriver(DriverVO driver){
		
	}
	public Result Modify(DriverVO driver){
		int index;
		Result result=Result.SUCCESS;
		for(index=0;index<driverList.size();index++)
		{
			DriverVO dr=driverList.get(index);
			if(dr.getId().equals(driver.getId()))
			{
				result=serv.reviseDriver(driver,name);
				if(!result.equals(Result.SUCCESS))
					return result;
				driverList.remove(index);
				driverList.add(driver);
				break;
			}
		}
		if(index==driverList.size())
		{
			result=serv.addDriver(driver,name);
			if(!result.equals(Result.SUCCESS))
				return result;
			for(int i=0;i<model.getRowCount();i++){
				if(Integer.parseInt(model.getValueAt(i, 0).toString().substring(5, 9))>i+1){
					driverList.add(i, driver);
					displayDrivers();
					return result;
				}
			}
			driverList.add(driver);
		}
		displayDrivers();
		return result;
	}
//	public static void main(String[] args){
//		FunctionFrame f=new FunctionFrame("");
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setSize(1300,800);
//		f.setContentPane(new DriverListPanel(f,"",""));
//		f.setVisible(true);
//	}
}
