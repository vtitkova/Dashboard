package gwt.dmma.base.client.ui.table;

import gwt.dmma.base.client.ui.NumberTextBox;
import gwt.dmma.base.client.ui.table.filter.FilterActionTable;
import gwt.dmma.base.client.ui.table.filter.FilterActionTableListener;
import gwt.dmma.base.client.ui.table.util.GwtTableUtil;
import gwt.dmma.base.client.utils.CssStyles;
import gwt.dmma.base.client.utils.WidgetUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.ui.abstracts.BaseComposite;
import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityListInterface;
import com.dmma.base.gwt.client.ui.gwtentity.GwtEnumRendererInterface;
import com.dmma.base.gwt.client.utils.BaseFlexTableUtil;
import com.dmma.base.gwt.client.utils.BaseFormats;
import com.dmma.base.gwt.shared.keys.AppParamConstants;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;


public class GwtTable extends BaseComposite implements GwtTableModelListener, FilterActionTableListener{

	private IGwtTableModel model;
	private ScrollPanel   scroller; 
	private FlexTable     tableHeader;
	private FlexTable     table;

	private FilterActionTable filterActionTable;
	private Integer filterRowIndex;
	private ArrayList<TextBox> filterWidgets;
	private HashMap<Integer, ArrayList<TextBox>> allCellEditors;
	private HashMap<Integer, GwtEnumRendererInterface> allEnumRenderers;
	private HashMap<Integer, GwtEntityListInterface> allEntityListRenderers;

	public void addEnumRenderer(Integer row, GwtEnumRendererInterface renderer){
		if(allEnumRenderers == null )
			allEnumRenderers = new HashMap<Integer, GwtEnumRendererInterface>();
		allEnumRenderers.put(row, renderer);
	}
	public void addEntityListRenderer(Integer row, GwtEntityListInterface renderer){
		if(allEntityListRenderers == null )
			allEntityListRenderers = new HashMap<Integer, GwtEntityListInterface>();
		allEntityListRenderers.put(row, renderer);
	}
	
	//flagssad
	private boolean isFilterAvailable = false;
	private boolean isEditLincAvailable = false;
	private ImageResource    editIcon;
	private String   editMainParamKey; // (id || groupId || typeId || ...)
	private AppEvent editEventTemplate;


	// TODO BASE 1 !!!! nado goToPresenterId , goToObjectLinkparam (id, groupId, typeId)
	// aditional param set;
	// t.e. vse eti polja mogut bitj dinami4eski izmeneni!!!!!


	
	private Map<String, int[]>   hghRows;

	public GwtTable(IGwtTableModel modell) {
		this(modell, false);
	}

	public GwtTable(IGwtTableModel modell, boolean isFilterAvailable) {
		this(modell, isFilterAvailable, false,"");
	}




	public GwtTable(IGwtTableModel modell, boolean isFilterAvailable, boolean isEditLincAvailable, String targetPresenter) {
		super("GwtTable_container");
		this.model = modell;
		this.model.addTableModelListener(this);
		this.isEditLincAvailable = isEditLincAvailable;
		this.isFilterAvailable = isFilterAvailable;
		init();
		createTableHeader();
		if(this.isFilterAvailable&&GwtTableUtil.modelHaveFilterabeColumns(modell))
			createTableFilter();

		if(isEditLincAvailable)
			editEventTemplate = new AppEvent(targetPresenter, this.getClass().getName());

		setDataNotFound();
	}

	public void setViewPortHeight(String h) {
		scroller.setHeight(h);
	}

	public void setEditMainParamKey(String editMainParamKey) {
		this.editMainParamKey = editMainParamKey;
	}

	private void init() {
		FlexTable wrap = new FlexTable();
		wrap.setStyleName("GwtTable_rootTable");
		wrap.setCellSpacing(0);
		wrap.setCellPadding(0);
		this.add(wrap);

		tableHeader = new FlexTable();
		wrap.setWidget(0, 0, tableHeader);


		table = new FlexTable();
		scroller = new ScrollPanel(table);
		wrap.setWidget(1, 0, scroller);
	}


	private void createTableHeader(){
		int row = 	tableHeader.getRowCount();
		FlexCellFormatter formatter  = tableHeader.getFlexCellFormatter();
		for(int i = 0; i< model.getColumnCount(); i++){
			tableHeader.setHTML(row, i, model.getColumnName(i));
			formatter.setWidth(row, i,  model.getColumnWidth(i)+"px");
		}
		int i =  model.getColumnCount();

		if(isEditLincAvailable){
			tableHeader.setHTML(row, i, "");
			formatter.setWidth(row,  i, "20px");
			i++;
		}

		tableHeader.setHTML(row, i, "");
		formatter.setWidth(row,  i, "12px");

		tableHeader.getRowFormatter().setStyleName(row, CssStyles.TABLE_HEADER);
	}


	private void createTableFilter() {
		createFilterActionHandler();
		createFilterRow();
	}

	private void createFilterRow() {
		filterRowIndex = 	tableHeader.getRowCount();

		int[] indexes = GwtTableUtil.getFilterableColumnIndexes(model);
		filterWidgets = new ArrayList<TextBox>(indexes.length);

		//FlexCellFormatter formatter  = tableHeader.getFlexCellFormatter();

		for(int i = 0; i< indexes.length; i++){
			TextBox tb = new TextBox();
			filterWidgets.add(tb);
			//tb.setWidth((model.getColumnWidth(indexes[i])-8)+"px");
			tb.setWidth("100%");
			tb.addKeyUpHandler(new KeyUpHandler() {
				@Override
				public void onKeyUp(KeyUpEvent e) {
					if(e.getNativeKeyCode()==KeyCodes.KEY_ENTER){
						onApplyFilter();
					}
				}
			});
			//tb.setHeight("10px");
			tableHeader.setWidget(filterRowIndex, indexes[i], tb);
		}
		tableHeader.setHTML(filterRowIndex, model.getColumnCount(), "");
		if(isEditLincAvailable)
			tableHeader.setHTML(filterRowIndex, model.getColumnCount()+1, "");

		//formatter.setWidth(filterRowIndex,  model.getColumnCount(), "12px");
		tableHeader.getRowFormatter().setStyleName(filterRowIndex, CssStyles.TABLE_HEADER);
		tableHeader.getRowFormatter().setVisible(filterRowIndex, false);
		tableHeader.getRowFormatter().addStyleName(filterRowIndex, CssStyles.TABLE_HEADER_FILTER_FILTER);

	}


	private void createFilterActionHandler() {
		int row = 	tableHeader.getRowCount();
		filterActionTable  = new FilterActionTable(this);

		tableHeader.setWidget(row, 0, filterActionTable);
		int i = 1;
		if(isEditLincAvailable) i++;
		tableHeader.getFlexCellFormatter().setColSpan(row, 0, model.getColumnCount()+i);
		tableHeader.getRowFormatter().setStyleName(row, CssStyles.TABLE_HEADER);

	}



	@Override
	public void onModelChanged(GwtTableModelEvent event) {
		if(event.type==GwtTableModelEvent.DATA_REQUESTED){
			setDataRequested();
			return;
		}else if(event.type==GwtTableModelEvent.DATA_RECEIVED){
			if(model.getRowCount()>0){
				setData();
				return;
			}
		}else if(event.type==GwtTableModelEvent.DATA_UPDATED){
			if(model.getRowCount()>0){
				updateData(event);
				return;
			}
		}
		setDataNotFound();
	}



	private void updateData(GwtTableModelEvent event) {
		Integer column = event.getColumn();
		Integer row    = event.getRow();

		//if(column==null&&row==null){
		// refresh all data as column and row not specified
		//	setData();
		//	return;
		//} 

		if(row==null){
			for(int curRow = 0; curRow < model.getRowCount(); curRow++){
				updateDataInRow(curRow, column);
			}
		}else{
			updateDataInRow(row, column);
		}
	}


	private void updateDataInRow(int row, Integer column) {
		if(column==null){
			for(int curCol = 0; curCol < model.getColumnCount(); curCol++){
				updateDataInCell(row, curCol);
			}
		}else{
			updateDataInCell(row, column);
		}
	}


	private void updateDataInCell(int row, int column) {
		if(model.isCellEditable(row, column)){
			ArrayList<TextBox> columnEditors = getColumnEditorList(column);
			if(row>=columnEditors.size()){
				createEditableCell(row, column,row );
			}else{
				TextBox tb = columnEditors.get(row);
				Object val = model.getValueAt(row, column);
				if(val==null)
					tb.setText("");
				else 
					tb.setText(""+val);
			}
		}else{
			Object val = model.getValueAt(row, column);
			if(val==null)
				table.setHTML(row, column, "");
			else{
				if(Date.class.equals(model.getColumnClass(column)))
					table.setHTML(row, column, BaseFormats.getFormattedDate((Date) val)); 
				else if(Double.class.equals(model.getColumnClass(column)))
					table.setHTML(row, column, BaseFormats.getFormattedCurency((Double) val)); 
				else 
					table.setHTML(row, column, ""+val);
			} 

		}
	}


	private void setData() {
		table.removeAllRows();
		if(allCellEditors!=null)
			allCellEditors.clear();

		for(int i = 0; i < model.getRowCount(); i++){
			createOneRow(i);
		}
	}
	
	private void createOneRow(int rowIndex) {
		int row = 	table.getRowCount();
		for(int columnIndex = 0; columnIndex< model.getColumnCount(); columnIndex++){
			if(model.isCellEditable(rowIndex, columnIndex)){
				createEditableCell(row, columnIndex, rowIndex);
			}else{
				Object val = model.getValueAt(rowIndex, columnIndex);
				if(val==null)
					table.setHTML(row, columnIndex, "");
				else {
					Class<?> clazz = model.getColumnClass(columnIndex) ;
					String result = toString(columnIndex, val, clazz);
					table.setHTML(row, columnIndex, result);
				}
			}
		}

		// setWidth
		if(row==0){
			FlexCellFormatter formatter  = table.getFlexCellFormatter();
			for(int columnIndex = 0; columnIndex< model.getColumnCount(); columnIndex++)
				formatter.setWidth(row, columnIndex,  model.getColumnWidth(columnIndex)+"px");
		}

		if(isEditLincAvailable){
			// create Edit Event
			if(editMainParamKey==null||editMainParamKey.length()<1){
				editMainParamKey = AppParamConstants.ID;
			}

			AppEvent currentEvent = editEventTemplate.clone();
			currentEvent.addParam(editMainParamKey, model.getObjectId(rowIndex));
			table.setWidget(row, model.getColumnCount(),WidgetUtil.createEditWidget(editIcon, currentEvent));
		}

		// color row
		if(row%2==0)
			table.getRowFormatter().setStyleName(row, CssStyles.TABLE_COLOR_ROW);
	}



	@SuppressWarnings("unchecked")
	private String toString(Integer colIndex, Object val, Class<?> clazz) {
		if(Date.class.equals(clazz))
			return BaseFormats.getFormattedDate((Date) val); 
		else if(Double.class.equals(clazz))
			return BaseFormats.getFormattedCurency((Double) val); 
		else if(GwtEnumRendererInterface.class.equals(clazz)){
			if(allEnumRenderers!=null&&allEnumRenderers.get(colIndex)!=null){
				GwtEnumRendererInterface rend = allEnumRenderers.get(colIndex);
				return rend.lookUpById((Integer)val); 
			}else
				return "FIX ME - Set Renderer"; 
		}else if(GwtEntityListInterface.class.equals(clazz)){
			if(allEntityListRenderers!=null&&allEntityListRenderers.get(colIndex)!=null){
				GwtEntityListInterface<IsSerializable> rend = allEntityListRenderers.get(colIndex);
				return rend.getValue((ArrayList<IsSerializable>) val); 
			}else
				return "FIX ME - Set Renderer"; 
		}else
			return val.toString();

	}

	private void createEditableCell(int row, int columnIndex, int rowIndex) {
		ArrayList<TextBox> columnEditors = getColumnEditorList(columnIndex);

		TextBox tb = new NumberTextBox();
		Object val = model.getValueAt(rowIndex, columnIndex);
		if(val==null)
			tb.setText("");
		else 
			tb.setText(""+val);


		table.setWidget(row, columnIndex,tb); 
		columnEditors.add(tb);
		tb.setWidth((model.getColumnWidth(columnIndex)-10)+"px");
		/*tb.addFocusHandler(new FocusHandler() {

			@Override
			public void onFocus(FocusEvent e) {
				System.out.println(e.getType());
			}
		});*/


	}


	private ArrayList<TextBox> getColumnEditorList(int columnIndex) {
		if(allCellEditors==null)
			allCellEditors = new HashMap<Integer, ArrayList<TextBox>>();

		ArrayList<TextBox> colEditors = allCellEditors.get(new Integer(columnIndex));
		if(colEditors==null){
			colEditors = new ArrayList<TextBox>(model.getRowCount());
			allCellEditors.put(new Integer(columnIndex), colEditors);
		}
		return colEditors;
	}

	public void setDataNotFound() {
		table.removeAllRows();
		BaseFlexTableUtil.addDataNotFound(table);
	}

	public void setDataRequested() {
		table.removeAllRows();
		BaseFlexTableUtil.addAnimatedRequestingData(table);
		table.getFlexCellFormatter().setWidth(0, 0, getTotalWidth()+"px");
	}

	public Integer getTotalWidth(){
		Integer retVal = 0;
		for(int i = 0; i< model.getColumnCount(); i++){
			retVal+=model.getColumnWidth(i);
		}
		return retVal;
	}

	public void highlightRows(int[] rows) {
		highlightRows(rows, CssStyles.TABLE_HIGHLIGHTED_ROW);
	}

	public void highlightRows(int[] rows, String styleName) {
		if(table == null||table.getRowCount()==0) return; 

		remooveStyleHGH(styleName);
		if(hghRows==null)
			hghRows = new HashMap<String, int[]>();
			hghRows.put(styleName, rows);
			if(rows!=null)
				for(int i:rows){
					table.getRowFormatter().addStyleName(i, styleName);
				}
	}


	public void remooveAllHGH(){
		if(hghRows!=null&&hghRows.size()>0){
			for(String key:hghRows.keySet())
				remooveStyleHGH(key);
		}
	}

	public void remooveStyleHGH(String style){
		if(hghRows!=null&&hghRows.get(style)!=null){
			int[] rows = hghRows.get(style);
			if(rows.length>0){
				for(int i:rows)
					table.getRowFormatter().removeStyleName(i,style);
				hghRows.remove(style);
			}
		}

	}


	public void updateModel(Integer rowIndex){
		if(allCellEditors==null||allCellEditors.isEmpty()) return;

		for(Entry<Integer, ArrayList<TextBox>> entry : allCellEditors.entrySet()){
			Integer collIndex = entry.getKey();
			ArrayList<TextBox> columnEditors = entry.getValue();

			if(rowIndex==null){
				for(int rInd = 0; rInd<columnEditors.size(); rInd++){
					TextBox tb = columnEditors.get(rInd);
					String val = tb.getValue();
					model.setValueAt(val, rInd, collIndex);
				}	
			}else{
				TextBox tb = columnEditors.get(rowIndex);
				String val = tb.getValue();
				model.setValueAt(val, rowIndex, collIndex);
			}
		}
	}


	public void tryToPutFocusToCell(Integer found, int i) {
		if(allCellEditors==null||allCellEditors.isEmpty()) return;
		ArrayList<TextBox> colEditors = allCellEditors.get(i);
		if(colEditors==null||colEditors.isEmpty()) return;

		TextBox tb = colEditors.get(found);
		if(tb==null) return;
		tb.setFocus(true);

	}


	@Override
	public void onApplyFilter() {
		ArrayList<String> filterStrings = new ArrayList<String>(filterWidgets.size());
		for(TextBox tb: filterWidgets){
			String filter = tb.getValue();
			filterStrings.add(filter);
		}

		int[] indexes = model.getIndexesByFilter(filterStrings);
		highlightRows(indexes);

	}

	@Override
	public void onOpenFilter() {
		if(filterRowIndex!=null){
			tableHeader.getRowFormatter().setVisible(filterRowIndex, true);
		}
	}


	@Override
	public void onRemoveFilter() {
		for(TextBox tb: filterWidgets){
			tb.setText("");
		}
		highlightRows(null);
		if(filterRowIndex!=null){
			tableHeader.getRowFormatter().setVisible(filterRowIndex, false);
		}
	}

	/**
	 * Set custon icon for edit
	 * if this icon is not set edit link will be text: "edit"
	 * */
	public void setEditImageResource(ImageResource editIcon) {
		this.editIcon = editIcon;
	}

	public AppEvent getEditEventTemplate() {
		return editEventTemplate;
	}

}
