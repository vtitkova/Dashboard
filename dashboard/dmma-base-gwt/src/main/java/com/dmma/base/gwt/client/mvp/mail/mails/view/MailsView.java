package com.dmma.base.gwt.client.mvp.mail.mails.view;

import java.util.ArrayList;
import java.util.Date;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.mvp.mail.mails.presenter.MailsPresenterDisplay;
import com.dmma.base.gwt.client.types.MailStatusType;
import com.dmma.base.gwt.client.utils.BaseFormats;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.base.gwt.shared.entities.MailDTO;
import com.dmma.base.gwt.shared.wrappers.MailSearchWrapper;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionModel;

public class MailsView extends Composite implements  MailsPresenterDisplay{
	interface MyUiBinder extends UiBinder<Widget, MailsView> {}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	public static String VIEW_TITLE = BaseMessages.MSG.menuMails();
	
	private SelectionModel<MailDTO> selectionModel;
	
	@UiField
	MailCss style;
	
	@UiField
	CheckBox selectAllCB;
	
	@UiField
	ListBox statusLB;
	
	@UiField
	ListBox templateLB;

	@UiField
	DateBox fromDP;
	
	@UiField
	DateBox toDP;
	
	@UiField(provided = true)
	SimplePager pager;

	
	@UiField(provided = true)
	CellTable<MailDTO> contentTable;
	
	public MailsView(){
		contentTable = new CellTable<MailDTO>();
		selectionModel = new MultiSelectionModel<MailDTO>();
		contentTable.setSelectionModel(selectionModel, DefaultSelectionEventManager.<MailDTO> createCheckboxManager());

		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
	    pager.setDisplay(contentTable);
	    
		initTableColumns();
		initWidget(uiBinder.createAndBindUi(this));
		
		statusLB.addItem(BaseMessages.MSG.all(), "-1");
		statusLB.addItem(MailStatusType.isNew.getTitle(), MailStatusType.isNew.getId().toString());
		statusLB.addItem(MailStatusType.isSent.getTitle(), MailStatusType.isSent.getId().toString());
		statusLB.addItem(MailStatusType.isFailed.getTitle(), MailStatusType.isFailed.getId().toString());
		
		templateLB.addItem(BaseMessages.MSG.all(), "-1");
		
	}

	private void initTableColumns(){
		Column<MailDTO, Boolean> checkColumn = new Column<MailDTO, Boolean>(
				new CheckboxCell(true, false)) {
			@Override
			public Boolean getValue(MailDTO object) {
				// Get the value from the selection model.
				return selectionModel.isSelected(object);
			}
		};
		contentTable.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
		contentTable.setColumnWidth(checkColumn, 40, Unit.PX);
		
		// Status
	    Column<MailDTO, Integer> statusColumn;
	    statusColumn = new Column<MailDTO, Integer>(new MailStatusCell()) {
			@Override
			public Integer getValue(MailDTO object) {
				return object.getStatus();
			}
		};
	   
	    /*mailToColumn.setSortable(true);
	    sortHandler.setComparator(firstNameColumn, new Comparator<ContactInfo>() {
	      public int compare(ContactInfo o1, ContactInfo o2) {
	        return o1.getFirstName().compareTo(o2.getFirstName());
	      }
	    });*/
	    contentTable.addColumn(statusColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
	    
	    
		
		// Mail To .
	    Column<MailDTO, String> mailToColumn = new Column<MailDTO, String>(
	        new TextCell()) {
	      @Override
	      public String getValue(MailDTO object) {
	        return object.getMailTo();
	      }
	    };
	    /*mailToColumn.setSortable(true);
	    sortHandler.setComparator(firstNameColumn, new Comparator<ContactInfo>() {
	      public int compare(ContactInfo o1, ContactInfo o2) {
	        return o1.getFirstName().compareTo(o2.getFirstName());
	      }
	    });*/
	    contentTable.addColumn(mailToColumn, "Mail to");
	  //  contentTable.setColumnWidth(mailToColumn, 20, Unit.PCT);

	    // Template name.
	    Column<MailDTO, String> templateNameColumn = new Column<MailDTO, String>(new TextCell()) {
	      @Override
	      public String getValue(MailDTO object) {
	        return object.getTemplateName();
	      }
	    };
	    /*mailToColumn.setSortable(true);
	    sortHandler.setComparator(firstNameColumn, new Comparator<ContactInfo>() {
	      public int compare(ContactInfo o1, ContactInfo o2) {
	        return o1.getFirstName().compareTo(o2.getFirstName());
	      }
	    });*/
	    contentTable.addColumn(templateNameColumn, "Template");
	 //   contentTable.setColumnWidth(templateNameColumn, 20, Unit.PCT);
	   
	    // Subject Column
	    Column<MailDTO, String> subjectColumn = new Column<MailDTO, String>(new TextCell()) {
	      @Override
	      public String getValue(MailDTO object) {
	        return object.getSubject();
	      }
	    };
	    /*mailToColumn.setSortable(true);
	    sortHandler.setComparator(firstNameColumn, new Comparator<ContactInfo>() {
	      public int compare(ContactInfo o1, ContactInfo o2) {
	        return o1.getFirstName().compareTo(o2.getFirstName());
	      }
	    });*/
	    contentTable.addColumn(subjectColumn, "Subject");
	 //   contentTable.setColumnWidth(templateNameColumn, 20, Unit.PCT);

		
	 // Subject Column
	    Column<MailDTO, String> dateColumn = new Column<MailDTO, String>(new TextCell()) {
	      @Override
	      public String getValue(MailDTO object) {
	        return BaseFormats.getFormattedDateTime(object.getCreated());
	      }
	    };
	    /*mailToColumn.setSortable(true);
	    sortHandler.setComparator(firstNameColumn, new Comparator<ContactInfo>() {
	      public int compare(ContactInfo o1, ContactInfo o2) {
	        return o1.getFirstName().compareTo(o2.getFirstName());
	      }
	    });*/
	    contentTable.addColumn(dateColumn, BaseMessages.MSG.created());
	    contentTable.setColumnWidth(templateNameColumn, 110, Unit.PX);
	    
	}

	

	@Override
	public void setData(ArrayList<MailDTO> data) {
		contentTable.setRowData(data);
		// TODO Auto-generated method stub
		
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

	
	private class MailStatusCell extends AbstractCell<Integer>{
		public MailStatusCell() {
		}

		@Override
		public void render(com.google.gwt.cell.client.Cell.Context context, Integer value, SafeHtmlBuilder sb) {
			sb.appendHtmlConstant(MailStatusType.createIconHTML(value));
		}
		
	}


	@Override
	public HasChangeHandlers getStatusCB() {
		return statusLB;
	}

	@Override
	public void setSelectedStatusId(Integer statusId) {
		BaseListBoxUtils.setSelectedItemByValue(statusLB, ""+statusId);
	}

	@Override
	public HasChangeHandlers getTemplateCB() {
		return templateLB;
	}

	@Override
	public void setSelectedTemplateName(String templateName) {
		BaseListBoxUtils.setSelectedItemByValue(templateLB, ""+templateName);
	}

	@Override
	public void addAvailableTemplateNames(String templateTitle,	String templateName) {
		templateLB.addItem(templateTitle, templateName);
	}

	@Override
	public MailSearchWrapper getMailSearchWrapper() {
		MailSearchWrapper retVal = new MailSearchWrapper();
		retVal.setStatusId(BaseListBoxUtils.getSelectedValueAsInteger(statusLB));
		retVal.setMailTemplateName(BaseListBoxUtils.getSelectedValueAsString(templateLB));
		retVal.setDateFrom(fromDP.getValue());
		retVal.setDateTo(toDP.getValue());
		return retVal;
	}

	@Override
	public void setDateFrom(Date paramAsDate) {
		fromDP.setValue(paramAsDate);
	}

	@Override
	public void setDateTo(Date paramAsDate) {
		toDP.setValue(paramAsDate);		
	} 
	

}