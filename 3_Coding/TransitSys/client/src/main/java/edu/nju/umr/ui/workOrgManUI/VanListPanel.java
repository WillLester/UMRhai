package edu.nju.umr.ui.workOrgManUI;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.nju.umr.logic.workOrgManLogic.VanManLogic;
import edu.nju.umr.logicService.workOrgManLogicSer.VanManLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.InfoFrame;
import edu.nju.umr.ui.Table;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;
import edu.nju.umr.vo.VanVO;

import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class VanListPanel extends JPanel {
	private JTextField textFieldSearch;
	private JFrame frame;
	private Table table;
	private DefaultTableModel model;
	private VanManLSer serv;
	private UserVO user;
	private ArrayList<VanVO> vanList;
	private VanListPanel vanListPanel;

	/**
	 * Create the panel.
	 */
	public VanListPanel(JFrame fr,UserVO uservo) {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		frame=fr;
		user=uservo;
		vanListPanel=this;
		
		JLabel nameLabel = new JLabel("车辆信息列表");
		nameLabel.setFont(new Font("华文新魏",Font.PLAIN ,22));
		nameLabel.setBounds(this.getWidth()/2-Constants.LABEL_WIDTH/2, 0, Constants.LABEL_WIDTH+20, Constants.LABEL_HEIGHT_S);
		add(nameLabel);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setText("请输入关键字或车辆代号");
		textFieldSearch.setBounds(Constants.TABLE_X, Constants.TABLE_Y,600, 21);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton search = new JButton("搜索");
		search.setBounds(textFieldSearch.getX()+600+20, textFieldSearch.getY(), 90, 21);
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				getVans(textFieldSearch.getText());
			}
		});
		add(search);

		JButton all = new JButton("显示全部");
		all.setBounds(textFieldSearch.getX()+700+20, textFieldSearch.getY(), 90, 21);
		all.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			getVans(null);
		}});
		add(all);
		
		
		JButton add = new JButton("新增");
		add.setBounds(this.getWidth()/2-250, Constants.TABLE_HEIGHT*7, 90, 21);
		add.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addVan();
		}});
		add(add);
		
		JButton delete = new JButton("删除");
		delete.setBounds(add.getX()+add.getWidth()+50, add.getY(), 90, 21);
		delete.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			deleteVan();
		}});
		add(delete);
		
		JButton modify = new JButton("查看修改");
		modify.setBounds(delete.getX()+delete.getWidth()+50, add.getY(), 90, 21);
		modify.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			modify();
		}});
		add(modify);
		
		JButton forDetail = new JButton("查看详细");
		forDetail.setBounds(modify.getX()+modify.getWidth()+50, add.getY(), 90, 21);
		forDetail.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			checkVan();
		}});
//		add(forDetail);
		
		JButton out = new JButton("退出");
		out.setBounds(forDetail.getX()+forDetail.getWidth()+50,add.getY(),90,21);
		out.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
			}
		});
		add(out);
		tableInit();
		dataInit();
	}
	private void tableInit(){
		table = new Table(new DefaultTableModel());
		model=(DefaultTableModel)table.getModel();
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e){
				if(e.getValueIsAdjusting()==false);
			}
		});
		table.setBounds(Constants.TABLE_X, textFieldSearch.getY()+40, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBounds(Constants.TABLE_X, textFieldSearch.getY()+40, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"车辆代号","车牌号","服役时间"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	private void dataInit(){
		serv=new VanManLogic();
		getVans(null);
		displayVans();
	}
	@SuppressWarnings("unchecked")
	private void getVans(String keyword)
	{
		ResultMessage message=serv.searchVan(keyword, user.getOrgId());
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
		{
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		vanList=(ArrayList<VanVO>)message.getMessage();
		displayVans();
		
	}
	private void displayVans(){
		model.setRowCount(0);
		for(int i=0;i<vanList.size();i++)
		{
			VanVO temp = vanList.get(i);
			Calendar tempTime=temp.getStartTime();
			String beginTime=tempTime.get(Calendar.YEAR)+"年"+(tempTime.get(Calendar.MONTH)+1)+"月"+tempTime.get(Calendar.DATE)+"日";
			tempTime=temp.getEndTime();
			String endTime=tempTime.get(Calendar.YEAR)+"年"+(tempTime.get(Calendar.MONTH)+1)+"月"+tempTime.get(Calendar.DATE)+"日";
			String [] data=new String[]{temp.getId(),temp.getPlateNum(),beginTime+" 至 "+endTime};
			model.addRow(data);
		}
	}
	
	private void addVan(){
		ResultMessage message=serv.getNextId(user.getOrgId());
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			DoHint.hint(result, frame);
			return;
		}
		String id=(String)message.getMessage();
		InfoFrame info=new InfoFrame("新增车辆");
		VanVO temp=new VanVO(id,"",Calendar.getInstance(),Calendar.getInstance(),null,user.getOrgId());
		info.setContentPane(new VanInfoPanel(info,vanListPanel,temp));
	}
	private void deleteVan(){
		int row=table.getSelectedRow();
		String id=vanList.get(row).getId();
		Result result = serv.deleteVan(id);
		if(!result.equals(Result.SUCCESS))
		{
			DoHint.hint(result, frame);
			return;
		}
		vanList.remove(row);
		displayVans();
	}
	private void modify(){
		int row=table.getSelectedRow();
		VanVO temp=vanList.get(row);
		InfoFrame info=new InfoFrame("查看修改车辆");
		info.setContentPane(new VanInfoPanel(info,vanListPanel,temp));
	}
	private void checkVan(){
		
	}
	public Result confirmed(){
		return null;
	}
//	public static void main(String[] args)
//	{
//		JFrame frame=new JFrame();
//		frame.setContentPane(new VanListPanel(frame));
//		frame.setSize(1200,800);
//		frame.setVisible(true);
//	}

}
