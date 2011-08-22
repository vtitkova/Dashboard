package gwt.dmma.base.client.ui.table.util;

import gwt.dmma.base.client.ui.table.IGwtTableModel;


public class GwtTableUtil {
	
	public static boolean modelHaveFilterabeColumns(IGwtTableModel model){
		if(model==null) return false;
		int col = model.getColumnCount();
		for(int i = 0; i<col;i++){
			if(model.isColumnFilterable(i))
				return true;
		}
		return false;
	}

	public static int[] getFilterableColumnIndexes(IGwtTableModel model) {
		if(model==null) return null;
		
		int colCnt = model.getColumnCount();
		int filtColCnt = 0;
		
		for(int i = 0; i<colCnt;i++){
			if(model.isColumnFilterable(i))
				filtColCnt++;
		}
		
		int[] indexes = new int[filtColCnt];
		
		filtColCnt = 0;
		for(int i = 0; i<colCnt;i++){
			if(model.isColumnFilterable(i)){
				indexes[filtColCnt] = i;
				filtColCnt++;
			}
		}
		
		return indexes;
	}
}
