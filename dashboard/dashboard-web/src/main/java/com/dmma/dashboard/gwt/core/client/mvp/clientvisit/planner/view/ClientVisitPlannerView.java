package com.dmma.dashboard.gwt.core.client.mvp.clientvisit.planner.view;

import gwt.dmma.base.client.onthefly.OnTheFlyEditorForTA;
import gwt.dmma.base.client.onthefly.core.OnTheFlyEditorListenerAdapter;
import gwt.dmma.base.client.utils.CssStyles;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.utils.BaseFlexTableUtil;
import com.dmma.base.gwt.client.utils.BaseFormats;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.mvp.clientvisit.planner.presenter.ClientVisitPlannerPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.onthefly.OnTheFlyEditorForClientVisitStatus;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.client.types.ClientVisitStatusType;
import com.dmma.dashboard.gwt.core.client.utils.DashboardWidgetUtils;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitDTOS;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitPlanDTOW;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Hidden;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class ClientVisitPlannerView  extends BaseCompositeView implements ClientVisitPlannerPresenterDisplay{
	public static String VIEW_TITLE = DashboardMessages.MSG.clientVisitPlanner();
	public static String VIEW_WIDTH = "800px";

	public static int MEGLER_MODE = 1;
	public static int BANKER_MODE = 2;
	public static int ADMIN_MODE  = 3;

	
	
	protected final int MODE;


	private Button addButton;
	private Button pdfButton;

	private FlexTable headerTable;
	private FlexTable clientVisitsTable;
	
	private FormPanel pdfDownForm;
	private Hidden formParameter;

	public ClientVisitPlannerView(int mode) {
		super(VIEW_TITLE,"BookingPoView");
		this.MODE =  mode;
	}

	@Override
	protected Widget createContent(){
		FlowPanel layout = new FlowPanel();
		layout.setWidth("100%");
		layout.add(createHeader());
		layout.add(createClientVisitsTable());
		layout.add(createControls());

		return layout;
	}	

	public Widget createHeader(){
		headerTable = new FlexTable();
		headerTable.setWidth("100%");
		return headerTable;
	}
	
	public Widget createClientVisitsTable(){
		clientVisitsTable = new FlexTable();
		clientVisitsTable.setWidth("100%");
		return clientVisitsTable;
	}
	
	public Widget createControls(){
		FlowPanel fp = new FlowPanel();
		
		addButton = new Button("Add");
		
		pdfButton = new Button("Pdf");
		pdfButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				pdfDownForm.submit();
			}
		});
		fp.add(addButton);
		fp.add(pdfButton);
		
		pdfDownForm = new FormPanel();
		pdfDownForm.setAction("ClientVisitPlannerPDF");
		formParameter = new Hidden("id");
		pdfDownForm.add(formParameter);
		
		fp.add(pdfDownForm);
		return fp;
	}

		
	
	@Override
	public void setData(ClientVisitPlanDTOW data) {
		// data !=null - presenter should redirect this page to  .... 
		
		formParameter.setValue(""+data.getEstateViewing().getId());
		//1st row
		headerTable.setHTML(0, 0, DashboardMessages.MSG.estate());
		headerTable.setWidget(0, 1, DashboardWidgetUtils.createEstateWidget(data.getEstate()));
		headerTable.getFlexCellFormatter().setColSpan(0, 1, 3);
		
		//2nd
		headerTable.setHTML(1, 0, DashboardMessages.MSG.broker());
		headerTable.setWidget(1, 1, DashboardWidgetUtils.createBrokerWidget(data.getEstate().getBroker()));
		
		headerTable.setHTML(1, 2, DashboardMessages.MSG.viewings());
		
		
		//3nd
		if(data.getIsFuture()){
			headerTable.setHTML(2, 0, DashboardMessages.MSG.futureViewings());
		}else{
			headerTable.setHTML(2, 0, DashboardMessages.MSG.pastViewings());
		}
		headerTable.getFlexCellFormatter().setColSpan(2, 0,2);
		
		String v = BaseFormats.getFormattedInterval(data.getEstateViewing().getDateFrom(),data.getEstateViewing().getDateTo());
		headerTable.setHTML(1,3, v);
		
		createClientVisitsTableHeader();
		if(data.getClientVisits()==null||data.getClientVisits().isEmpty()){
			BaseFlexTableUtil.addDataNotFound(clientVisitsTable);
		}else{
			for(ClientVisitDTOS clientVisit : data.getClientVisits()){
				createOneRow(clientVisit);
			}
		}
		addButton.setEnabled(true);
		pdfButton.setEnabled(true);
	}
	
	private void createOneRow(final ClientVisitDTOS clientVisit){
		int row = clientVisitsTable.getRowCount();
		clientVisitsTable.setHTML(row, 0, row+"");
		
		clientVisitsTable.setWidget(row, 1, DashboardWidgetUtils.createClientWidget(clientVisit.getClient()));
		final OnTheFlyEditorForTA editor = new OnTheFlyEditorForTA();
		editor.setText(clientVisit.getComments());
		editor.setListener(new OnTheFlyEditorListenerAdapter() {
			@Override
			public void onSave() {
				clientVisit.setComments(editor.getText());
				updateClientVisit(clientVisit);
			}
		});
		clientVisitsTable.setWidget(row, 2, editor);
		
		final OnTheFlyEditorForClientVisitStatus editorStatus = new OnTheFlyEditorForClientVisitStatus();
		editorStatus.setValues(ClientVisitStatusType.getValuesAsListBoxDTOs());
		editorStatus.setText(clientVisit.getStatus()+"");
		editorStatus.setListener(new OnTheFlyEditorListenerAdapter() {
			@Override
			public void onSave() {
				clientVisit.setStatus(Integer.parseInt(editorStatus.getText()));
				updateClientVisit(clientVisit);
			}
		});
		clientVisitsTable.setWidget(row, 3, editorStatus);
		
		clientVisitsTable.setHTML(row, 4, BaseFormats.getFormattedDate(clientVisit.getCreated()));
		
		
		
		if(row%2==0)
			clientVisitsTable.getRowFormatter().setStyleName(row, CssStyles.TABLE_COLOR_ROW);
	}
	
	
	private void createClientVisitsTableHeader() {
		int col = 0;
		clientVisitsTable.setHTML(0, col++, BaseMessages.MSG.nr());
		clientVisitsTable.setHTML(0, col++, DashboardMessages.MSG.client());
		clientVisitsTable.setHTML(0, col++, DashboardMessages.MSG.comments());
		clientVisitsTable.setHTML(0, col++, DashboardMessages.MSG.status());
		clientVisitsTable.setHTML(0, col++, BaseMessages.MSG.created());
		clientVisitsTable.getRowFormatter().setStyleName(0, CssStyles.TABLE_HEADER);
	}
	
	
	@Override
	public void setDataRequested() {
		headerTable.removeAllRows();
		clientVisitsTable.removeAllRows();
		addButton.setEnabled(false);
		pdfButton.setEnabled(false);
		headerTable.setWidget(0, 0, new Image(BaseImages.IMG.loadingSmall()));
	}

	@Override
	public HasClickHandlers getAddButton() {
		return addButton;
	}

	@Override
	public HasClickHandlers getPdfButton() {
		return pdfButton;
	}

	@Override
	protected String getPrefferedWidth() {
		return VIEW_WIDTH;
	}

	@Override
	public void setWeAreBusy(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOneClientVisits(ClientVisitDTOS clientVisit) {
		createOneRow(clientVisit);
	}


	private void updateClientVisit(ClientVisitDTOS clientVisit) {
		setWeAreBusy(true);
		ServiceFactory.getClientVisitService().saveOrUpdateDTOS(clientVisit, saveCVCallback);
	}

	public void clientVisitSaved(ClientVisitDTOS clientVisit) {
		setWeAreBusy(false);
	}
	private SaveCVCallback saveCVCallback = new SaveCVCallback();
	private class SaveCVCallback extends MyAsyncCallback<ClientVisitDTOS>{
		@Override
		public void onSuccess(ClientVisitDTOS clientVisit) {
			clientVisitSaved(clientVisit);			
		}
	}
	

}
