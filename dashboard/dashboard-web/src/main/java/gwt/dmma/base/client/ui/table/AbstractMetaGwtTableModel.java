package gwt.dmma.base.client.ui.table;


import java.util.ArrayList;
import java.util.List;

import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityInterface;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;


public class AbstractMetaGwtTableModel<T extends GwtEntityInterface> implements IGwtTableModel{
	//private T example;
	private IGwtEntityCM META;
	protected GwtTableModelListener listener;
	private ArrayList<T>  objects;


	public AbstractMetaGwtTableModel(T example, IGwtEntityCM META) {
		//this.example = example;
		this.META = META;
	}

	
	public void setObjects(ArrayList<T> objects) {
		this.objects = objects;
		if(listener!=null){
			if(objects==null||objects.size()==0){
				listener.onModelChanged(new GwtTableModelEvent(GwtTableModelEvent.DATA_NOTFOUND));
			}else{
				listener.onModelChanged(new GwtTableModelEvent(GwtTableModelEvent.DATA_RECEIVED));
			}
		}
	}


	public List<T> getObjects() {
		return objects;
	}
		

	@Override
	public void addTableModelListener(GwtTableModelListener listenerr) {
		this.listener = listenerr;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return META.getColumnMeta()[columnIndex].clazz;
	}

	@Override
	public int getColumnCount() {
		return META.getColumnMeta().length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return META.getColumnMeta()[columnIndex].title;
	}

	@Override
	public int getColumnWidth(int columnIndex) {
		return META.getColumnMeta()[columnIndex].width;
	}

	//REwrite this method if you wana!
	@Override
	public int[] getIndexesByFilter(ArrayList<String> filterStrings) {
		return null;
	}

	@Override
	public int getRowCount() {
		if(objects!=null)
			return objects.size();
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(objects==null||objects.size()==0||objects.size()<=rowIndex){
			return null;
		}else{
			return objects.get(rowIndex).getValueAt(columnIndex);
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return META.getColumnMeta()[columnIndex].editableInTable;
	}

	@Override
	public boolean isColumnFilterable(int columnIndex) {
		return META.getColumnMeta()[columnIndex].filterable;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if(objects==null||objects.size()==0||objects.size()<=rowIndex)
			return;
		objects.get(rowIndex).setValueAt(columnIndex,aValue);
	}


	@Override
	public Integer getObjectId(int rowIndex) {
		if(objects==null||objects.size()==0||objects.size()<=rowIndex){
			return null;
		}else{
			return objects.get(rowIndex).getId();
		}
	}

	public void setRequesting() {
		objects = null;
		if(listener!=null){
			listener.onModelChanged(new GwtTableModelEvent(GwtTableModelEvent.DATA_REQUESTED));
		}
		
	}

}
