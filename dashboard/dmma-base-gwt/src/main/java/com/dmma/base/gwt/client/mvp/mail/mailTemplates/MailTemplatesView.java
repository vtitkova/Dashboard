package com.dmma.base.gwt.client.mvp.mail.mailTemplates;

import java.util.ArrayList;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.shared.entities.MailTemplateDTO;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MailTemplatesView extends Composite implements  MailTemplatesDisplay{
	interface MyUiBinder extends UiBinder<Widget, MailTemplatesView> {}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	public static String VIEW_TITLE = BaseMessages.MSG.menuMailTemplates();

	@UiField
	Button refreshButton;
	
	@UiField(provided = true)
	CellTable<MailTemplateDTO> mailTemplatesTable;
	
	
	public MailTemplatesView(){
		mailTemplatesTable = new CellTable<MailTemplateDTO>();
		initTableColumns();
		initWidget(uiBinder.createAndBindUi(this));
	}

	private void initTableColumns(){
		Column<MailTemplateDTO, String> idColumn = new Column<MailTemplateDTO, String>(
		        new TextCell()) {
		      @Override
		      public String getValue(MailTemplateDTO object) {
		        return object.getId().toString();
		      }
		};
		mailTemplatesTable.addColumn(idColumn, "ID");
		mailTemplatesTable.setColumnWidth(idColumn, 40, Unit.PX);
	
		Column<MailTemplateDTO, String> nameColumn = new Column<MailTemplateDTO, String>(
		        new TextCell()) {
		      @Override
		      public String getValue(MailTemplateDTO object) {
		        return object.getName();
		      }
		};
		mailTemplatesTable.addColumn(nameColumn, "Name");
		mailTemplatesTable.setColumnWidth(nameColumn, 70, Unit.PX);
	
		Column<MailTemplateDTO, String> titleColumn = new Column<MailTemplateDTO, String>(
		        new TextCell()) {
		      @Override
		      public String getValue(MailTemplateDTO object) {
		        return object.getTitle();
		      }
		};
		mailTemplatesTable.addColumn(titleColumn, "Title");
		mailTemplatesTable.setColumnWidth(titleColumn, 80, Unit.PX);
		
		/*
		Column<MailTemplateDTO, String> titleColumn = new Column<MailTemplateDTO, String>(
		        new TextCell()) {
		      @Override
		      public String getValue(MailTemplateDTO object) {
		        return object.getTitle();
		      }
		};
		mailTemplatesTable.addColumn(titleColumn, "Title");
		mailTemplatesTable.setColumnWidth(titleColumn, 80, Unit.PX);*/
		
		
		
	
	}

	

	@Override
	public void setData(ArrayList<MailTemplateDTO> data) {
		mailTemplatesTable.setRowData(data);
	}

	@Override
	public void setDataRequested() {
		//contentTable.setRowData(null);
		/*contentTable.removeAllRows();
		createHeader();
		BaseFlexTableUtil.addAnimatedRequestingDataSmall(contentTable);*/
	}

	@Override
	public String getCaption() {
		return VIEW_TITLE;
	}

	@Override
	public HasClickHandlers getRefreshButton() {
		return refreshButton;
	}

}