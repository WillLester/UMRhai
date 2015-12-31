package edu.nju.umr.logicService.checkLogicSer;

import java.util.Calendar;

import edu.nju.umr.vo.ResultMessage;

public interface DiaryLSer {
	public ResultMessage seeDiary(Calendar start,Calendar end);
}