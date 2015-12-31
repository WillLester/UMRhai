package edu.nju.umr.client;

import edu.nju.umr.constants.Url;
import edu.nju.umr.ui.Constants;
import edu.nju.umr.ui.HintFrame;
import edu.nju.umr.ui.MainFrame;

public class Main {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		boolean isSuc = Url.initialize("url.txt");
		if(!isSuc){
			@SuppressWarnings("unused")
			HintFrame hint = new HintFrame("初始化失败！", 1366/20, 768/40, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		}
		@SuppressWarnings("unused")
		MainFrame frame = new MainFrame();
	}
}
