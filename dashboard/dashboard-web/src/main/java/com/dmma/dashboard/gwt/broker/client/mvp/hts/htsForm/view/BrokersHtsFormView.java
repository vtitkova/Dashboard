package com.dmma.dashboard.gwt.broker.client.mvp.hts.htsForm.view;


import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.AppEventManager;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.contactInfo.ContactInfoBigPopup;
import com.dmma.base.gwt.client.ui.estateInfo.PlaceInfoBigPopup;
import com.dmma.base.gwt.client.utils.BaseFlexTableUtil;
import com.dmma.base.gwt.client.utils.BaseFormats;
import com.dmma.dashboard.gwt.broker.client.mvp.hts.htsForm.presenter.BrokersHtsFormPresenter;
import com.dmma.dashboard.gwt.broker.client.mvp.hts.htsForm.presenter.BrokersHtsFormPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.ClientVisitDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;

public class BrokersHtsFormView extends BaseCompositeView implements  BrokersHtsFormPresenterDisplay{
	public static String VIEW_TITLE =  DashboardMessages.MSG.menuHtsForm();
	
	interface MyUiBinder extends UiBinder<Widget, BrokersHtsFormView> {}
    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);
	
	public static String VIEW_WIDTH = "800px";
	public static String VIEW_PORT_HEIGHT =   "400px";

	private HaveToSellDTO hts;
	
	@UiField
	FlexTable loadingContainer;
	@UiField
	Widget mainContainer;
	
	@UiField
	protected Label    idLabel;
	@UiField
	protected Label reminderLabel;
	
	@UiField
	protected Label    activeFrom;
	@UiField
	protected Label    clientLabel;
	@UiField
	protected Label    defBrokerCaption;
	@UiField
	protected Label    defBroker;
	
	@UiField
	protected TextArea  commentsTA;
	@UiField
	protected RadioButton wtsYes;
	@UiField
	protected RadioButton wtsNo;
	
	@UiField
	protected Label wasOnVisitCaption;
	@UiField
	protected Label wasOnVisitEstate;
	@UiField
	protected Label wasOnVisitTime;
	
	
	
	@UiField
    protected Button saveButton;
	
	public BrokersHtsFormView() {
		super(VIEW_TITLE, "BookingPoView");
		init();
	}
	
	private void init(){
		reminderLabel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent e) {
				AppEvent event = new AppEvent(BrokersHtsFormPresenter.PRESENTER_ID, this.getClass().getName());
				event.addParam(EKP.ID, hts.getParrentId());
				AppEventManager.get().changeHistory(event);
			}
		});
		clientLabel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				ContactInfoBigPopup.show(hts.getClient(), clientLabel);
			}
		});
		defBroker.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				ContactInfoBigPopup.show(hts.getDefaultBroker(), defBroker);
			}
		});
		wasOnVisitEstate.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PlaceInfoBigPopup.show(visitedEstate, wasOnVisitEstate);
			}
		});
		wtsYes.addClickHandler(rbClickHandler);
		wtsNo.addClickHandler(rbClickHandler);
	}
	
	
	@Override
	public void setData(HaveToSellDTO data) {
		loadingContainer.removeAllRows();
		loadingContainer.setVisible(false);
		mainContainer.setVisible(true);
		hts = data;
		idLabel.setText(hts.getId()==null ? "" : ""+hts.getId());
		if(hts.getParrentId()!=null){
			reminderLabel.setVisible(true);
			reminderLabel.setText("This is reminder, click here to see parrent");
		}else
			reminderLabel.setVisible(false);
		activeFrom.setText(BaseFormats.getFormattedDate(hts.getActiveFrom()));
		clientLabel.setText(hts.getClient().getFullName());
		
		Integer defBrokerId = hts.getDefaultBroker().getId();
		Integer processedBrokerId = hts.getProcessedBy().getId();
		
		if(!defBrokerId.equals(processedBrokerId)){
			defBrokerCaption.setVisible(true);
			defBroker.setVisible(true);
			defBroker.setText(hts.getDefaultBroker().getFullName());
	
		
		}else{
			defBrokerCaption.setVisible(false);
			defBroker.setVisible(false);
		}
		wasOnVisitCaption.setVisible(false);
		wasOnVisitEstate.setVisible(false);
		wasOnVisitTime.setVisible(false);
		
		
		
		commentsTA.setValue(hts.getProcessedComments());
		
		wtsYes.setValue(hts.getWantsToSell()==null ? false :  hts.getWantsToSell());
		wtsNo.setValue( hts.getWantsToSell()==null ? false : !hts.getWantsToSell());
	
		saveButton.setEnabled(true);
		if(hts.getProcessedDate()!=null){
			saveButton.setText(BaseMessages.MSG.update());
		}else{
			saveButton.setText(BaseMessages.MSG.save());
		}
	}


	@Override
	public void setDataRequested() {
		mainContainer.setVisible(false);
		BaseFlexTableUtil.addAnimatedRequestingDataSmall(loadingContainer);
		loadingContainer.setVisible(true);
	}


	@Override
	public HasClickHandlers getSaveButton() {
		return saveButton;
	}


	@Override
	public HaveToSellDTO getData() {
		return null;
	}

	@Override
	protected Widget createContent() {
		return  uiBinder.createAndBindUi(this);
	}

	@Override
	protected String getPrefferedWidth() {
		return VIEW_WIDTH;
	}

	private EstateDTO visitedEstate;
	@Override
	public void setClientVisitData(ClientVisitDTO result) {
		wasOnVisitCaption.setVisible(true);
		wasOnVisitEstate.setVisible(true);
		wasOnVisitTime.setVisible(true);
		visitedEstate = result.getEstate();
		wasOnVisitEstate.setText(result.getEstate().getDisplayName());
		wasOnVisitTime.setText(BaseFormats.getFormattedInterval(result.getEstateViewing().getDateFrom(),result.getEstateViewing().getDateTo()));
		
	}
	
	private void doWtsRBClicked() {
		
		// TODO Auto-generated method stub
		
	}
	
	private BRClickHandler rbClickHandler = new BRClickHandler();
	private class BRClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			doWtsRBClicked();
		}

	}
	@Override
	public HaveToSellDTO getHaveToSellDTO() {
		String comments = commentsTA.getText();
		if(comments == null || comments.trim().length()==0){
			return null;
		}
		
		Boolean wts = null;
		if(wtsYes.getValue()){
			wts = true;
		}
		if(wtsNo.getValue()){
			wts = false;
		}
		if(wts == null ){
			return null;
		}
		
		hts.setWantsToSell(wts);
		hts.setProcessedComments(comments);
		return hts;
	}

	@Override
	public void setSaveRequested() {
		saveButton.setEnabled(false);
	}

}