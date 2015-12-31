package edu.nju.umr.po;

import edu.nju.umr.po.enums.MysqlOperation;

public abstract class PO {
	public abstract String getCommand(MysqlOperation op);
}
