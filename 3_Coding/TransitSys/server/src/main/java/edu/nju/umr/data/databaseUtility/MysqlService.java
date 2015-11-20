package edu.nju.umr.data.databaseUtility;

import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.POKind;
import edu.nju.umr.po.enums.Result;

public interface MysqlService {
	public Result addInfo(PO po);
	public Result deleteInfo(PO po);
	public Result reviseInfo(PO po);
	public Object checkAll(POKind kind);
	public Object checkInfo(PO po);
}
