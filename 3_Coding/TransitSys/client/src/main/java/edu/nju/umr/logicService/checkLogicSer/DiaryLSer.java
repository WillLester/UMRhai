package edu.nju.umr.logicService.checkLogicSer;

import java.util.Date;

import edu.nju.umr.vo.ResultMessage;

public interface DiaryLSer {
	public ResultMessage seeDiary(Date start,Date end);
}