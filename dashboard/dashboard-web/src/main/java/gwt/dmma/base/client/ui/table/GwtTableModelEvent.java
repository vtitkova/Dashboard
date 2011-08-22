package gwt.dmma.base.client.ui.table;

public class GwtTableModelEvent {
	public static int DATA_REQUESTED  = 1; 
	public static int DATA_NOTFOUND   = 2; 
	public static int DATA_RECEIVED   = 3; 
	public static int DATA_UPDATED    = 4; 
	 
	
	protected int  type;
	protected Integer  column;
	protected Integer  row;
	
	
	
	public GwtTableModelEvent(int type) {
		this.type = type;
	}



	public Integer getColumn() {
		return column;
	}



	public void setColumn(Integer column) {
		this.column = column;
	}



	public Integer getRow() {
		return row;
	}



	public void setRow(Integer row) {
		this.row = row;
	}
	
	
	
	
}
