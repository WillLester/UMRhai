package edu.nju.umr.ui.utility;

import javax.swing.JFrame;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.SuccessPanel;

public class DoHint {
	public static void hint(Result result,JFrame fr){
		if(result.equals(Result.SUCCESS))
		{
			SuccessPanel suc=new SuccessPanel(fr);
			fr.add(suc);
			fr.setVisible(true);
			return;
		}
		@SuppressWarnings("unused")
		HintFrame hint = new HintFrame(result, fr.getX(), fr.getY(), fr.getWidth(), fr.getHeight());
	}
	public static void hint(Result result,JFrame fr,boolean close){
		if(result.equals(Result.SUCCESS))
		{
			SuccessPanel suc=new SuccessPanel(fr,close);
			fr.add(suc);
			fr.setVisible(true);
			return;
		}
		else
		{
			hint(result,fr);
		}
	}
	public static void hint(String content,JFrame fr){
		HintFrame hint = new HintFrame(content, fr.getX(), fr.getY(), fr.getWidth(), fr.getHeight());
		hint.setVisible(true);
	}
}
