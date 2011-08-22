package com.dmma.base.gwt.client.ui.abstracts;

import com.dmma.base.gwt.client.utils.BaseFlexTableUtil;
import com.dmma.base.gwt.client.utils.CssStyles;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.ScrollPanel;


public abstract class BaseScrolableTable extends BaseComposite{
	private ScrollPanel     scroller; 
	protected FlexTable     table; 

	public BaseScrolableTable(String style) {
		super("");
		init();
		setDataNotFound();
		setViewPortSize("100%", "200px");
	}

	private void init() {
		table = new FlexTable();
		table.setWidth("100%");
		scroller = new ScrollPanel(table);
		this.add(scroller);
	}
	
	
	protected void createTableHeader(){
		String[] headers = getTableHeaders();
		int row = 	table.getRowCount();
		for(int i =0; i<headers.length;i++){
			table.setHTML(row,i, headers[i]);
		}
		table.getRowFormatter().setStyleName(row, CssStyles.TABLE_HEADER);
	}
	
	protected abstract String[] getTableHeaders();

	public void setDataRequested() {
		table.removeAllRows();
		createTableHeader();
		BaseFlexTableUtil.addAnimatedRequestingData(table);
	}

	public void setDataNotFound() {
		table.removeAllRows();
		createTableHeader();
		BaseFlexTableUtil.addDataNotFound(table);
	}

	public void setViewPortSize(String w, String h) {
		scroller.setSize(w, h);
	}
		
	
}
