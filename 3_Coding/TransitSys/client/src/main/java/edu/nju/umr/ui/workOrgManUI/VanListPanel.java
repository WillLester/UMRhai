package edu.nju.umr.ui.workOrgManUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import edu.nju.umr.logic.workOrgManLogic.VanManLogic;
import edu.nju.umr.logicService.workOrgManLogicSer.VanManLSer;
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
import edu.nju.umr.ui.component.button.AllButton;
import edu.nju.umr.ui.component.button.CheckButton;
import edu.nju.umr.ui.component.button.DelButton;
import edu.nju.umr.ui.component.button.ExitButton;
import edu.nju.umr.ui.component.button.SearchButton;
import edu.nju.umr.ui.utility.DoHint;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.VanVO;


public class VanListPanel extends PPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5807654807287399993L;
	private TextField textFieldSearch;
	private FunctionFrame frame;
	private Table table;
	private DefaultTableModel model;
	private VanManLSer serv;
	private String orgId;
	private ArrayList<VanVO> vanList;
	private VanListPanel vanListPanel;
	private String name;
	/**
	 * Create the panel.
	 */
	public VanListPanel(FunctionFrame fr,String orgId,String name) {
		this.setSize(Constants.PANEL_WIDTH,Constants.PANEL_HEIGHT);
		setLayout(null);
		frame=fr;
		this.orgId = orgId;
		this.name = name;
		vanListPanel=this;
		vanList = new ArrayList<VanVO>();
		
		TitleLabel nameLabel = new TitleLabel("车辆信息列表");
		add(nameLabel);
		
		textFieldSearch = new TextField();
		textFieldSearch.setBounds(Constants.TABLE_X, Constants.TABLE_Y+45,600, 21);
		add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		Button search = new SearchButton();
		search.setBounds(textFieldSearch.getX()+600+Constants.INTERVAL, textFieldSearch.getY()-5, 100, 30);
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				getVans(textFieldSearch.getText());
			}
		});
		add(search);

		Button all = new AllButton();
		all.setBounds(textFieldSearch.getX()+700+Constants.INTERVAL*2, textFieldSearch.getY()-5, 100, 30);
		all.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			getVans(null);
		}});
		add(all);
		
		
		Button add = new AddButton();
		add.setBounds(this.getWidth()/2-250, Constants.TABLE_HEIGHT*7+60, 100, 30);
		add.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			addVan();
		}});
		add(add);
		
		Button delete = new DelButton();
		delete.setBounds(add.getX()+add.getWidth()+50, add.getY(), 100, 30);
		delete.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int n = JOptionPane.showConfirmDialog(frame, "确认删除吗?", "确认删除框", JOptionPane.YES_NO_OPTION);  
	        if (n == JOptionPane.YES_OPTION)
	        {
	        	deleteVan();
	        }
		}});
		add(delete);
		
		Button modify = new CheckButton();
		modify.setBounds(delete.getX()+delete.getWidth()+50, add.getY(), 100, 30);
		modify.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			modify();
		}});
		add(modify);
		
		Button forDetail = new CheckButton();
		forDetail.setBounds(modify.getX()+modify.getWidth()+50, add.getY(), 90, 21);
		forDetail.addActionListener(new ActionListener(){@Override
		public void actionPerformed(ActionEvent e) {
			checkVan();
		}});
//		add(forDetail);
		
		Button out = new ExitButton();
		out.setBounds(forDetail.getX()+forDetail.getWidth()+50,add.getY(),100,30);
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
		table.setBounds(Constants.TABLE_X, textFieldSearch.getY()+50, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scroll=new UMRScrollPane(table);
		scroll.setBounds(Constants.TABLE_X, textFieldSearch.getY()+50, Constants.TABLE_WIDTH, Constants.TABLE_HEIGHT*5);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		String[] columnNames={"车辆代号","车牌号","服役时间"};
		model.setColumnIdentifiers(columnNames);
		add(scroll);
	}
	private void dataInit(){
		try {
			serv = new VanManLogic();
		} catch (RemoteException e) {
			DoHint.hint(Result.NET_INTERRUPT, frame);
			frame.dispose();
		}
		getVans(null);
		displayVans();
	}
	@SuppressWarnings("unchecked")
	private void getVans(String keyword){
		ResultMessage message=serv.searchVan(keyword, orgId);
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			new HintFrame(result,frame.getX(),frame.getY(),frame.getWidth(),frame.getHeight());
			return;
		}
		vanList=(ArrayList<VanVO>)message.getMessage();
		displayVans();
		
	}
	private void displayVans(){
		model.setRowCount(0);
		for(int i=0;i<vanList.size();i++){
			VanVO temp = vanList.get(i);
			Calendar tempTime=temp.getServTime();
			String servTime=tempTime.get(Calendar.YEAR)+"年"+(tempTime.get(Calendar.MONTH)+1)+"月"+tempTime.get(Calendar.DATE)+"日";
			String [] data=new String[]{temp.getId(),temp.getPlateNum(),servTime};
			model.addRow(data);
		}
	}
	
	private void addVan(){
		ResultMessage message=serv.getNextId(orgId);
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			DoHint.hint(result, frame);
			return;
		}
		String id=(String)message.getMessage();
		InfoFrame info=new InfoFrame("新增车辆");
		VanVO temp=new VanVO(id,"",Calendar.getInstance(),null,orgId);
		info.setContentPane(new VanInfoPanel(info,vanListPanel,temp,orgId));
		frame.sonFrames.add(info);
	}
	private void deleteVan(){
		int row=table.getSelectedRow();
		String id=vanList.get(row).getId();
		Result result = serv.deleteVan(id,name);
		DoHint.hint(result, frame);
		if(result.equals(Result.SUCCESS))
		{
			vanList.remove(row);
			displayVans();
		}
	}
	private void modify(){
		int row=table.getSelectedRow();
		if(row<0||row>=vanList.size())return;
		VanVO temp=vanList.get(row);
		InfoFrame info=new InfoFrame("查看修改车辆");
		info.setContentPane(new VanInfoPanel(info,vanListPanel,temp,orgId));
		frame.sonFrames.add(info);
	}
	private void checkVan(){
		
	}
	private void sort(){
		for(int i=0;i<vanList.size();i++)
		{
			for(int j=i+1;j<vanList.size();j++)
			{
				VanVO left=vanList.get(i);
				VanVO right=vanList.get(j);
				if(left.getId().compareTo(right.getId())>0)
				{
					vanList.set(i,right);
					vanList.set(j, left);
				}
			}
		}
	}
	Result confirmed(VanVO temp){
		for(int i=0;i<vanList.size();i++){
			if(vanList.get(i).getId().equals(temp.getId())){
				Result result=serv.reviseVan(temp,name);
				return result;
			}
		}
		Result result = serv.addVan(temp,name);
		if(!result.equals(Result.SUCCESS)){
			return result;
		}
		vanList.add(temp);
		sort();
		displayVans();
		return result;
	}
}
