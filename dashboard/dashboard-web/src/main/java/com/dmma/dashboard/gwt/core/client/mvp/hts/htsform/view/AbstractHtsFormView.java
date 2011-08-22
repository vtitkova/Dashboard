/*package com.dmma.dashboard.gwt.core.client.mvp.hts.htsform.view;

import gwt.dmma.base.client.ui.abstracts.BaseCompositeView;
import gwt.dmma.base.client.ui.contactInfo.ContactInfoBigPopup;
import gwt.dmma.base.client.ui.dialog.AppDialog;
import gwt.dmma.base.client.ui.estateInfo.PlaceInfoBigPopup;
import gwt.dmma.base.client.utils.AppFormats;
import gwt.dmma.base.client.utils.AppUtils;
import gwt.dmma.base.client.utils.CssStyles;

import java.util.Date;

import com.dmma.dashboard.gwt.core.client.i18n.DashboardTRL;
import com.dmma.dashboard.gwt.core.client.mvp.hts.htsform.presenter.AbstractHtsFormPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.mvp.tip.tipform.presenter.AbstractTipFormPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.types.TipDirectionType;
import com.dmma.dashboard.gwt.core.client.types.TipStatusType;
import com.dmma.dashboard.gwt.core.client.types.TipType;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class AbstractHtsFormView extends PresenterView implements AbstractHtsFormPresenterDisplay{
	public static String VIEW_TITLE = DashboardTRL.msg.menuHtsForm();
	public static String VIEW_WIDTH = "800px";
	public static String LB_WIDTH = "180px";

	public static int MEGLER_MODE = 1;
	public static int BANKER_MODE = 2;
	protected final int MODE;

	//default position if MODE = MEGLER_MODE
	int meglerPos = 1; 
	int bankerPos = 3;
	
	protected FlexTable layout;
	protected FlexTable deatilsTable;
	protected boolean is_I_send; 
	protected TipDTO  tipDTO;
	// COMPONENTs

	protected Label    idLabel;
	protected Label    bankerLA;
	protected Label    tipDirectionTypeLA;
	protected Label    brokerLA;
	
	protected Label    clientLA;
	protected Image    lookupClientButton;
	protected Image    removeClientButton;
	
	protected Label    estateLA;
	protected Image    lookupEstateButton;
	protected Image    removeEstateButton;
	
	protected ListBox  tipTypeLB;
	protected TextArea comments;
	protected DateBox  created;

	protected TextArea statusComments;
	protected DateBox  modified;
	
	protected Image    tipDirectionTypeImage;
	protected ListBox  tipStatusTypeLB;
	protected Button saveButton;

	// this button can be Broker or Banker remove/lookup
	protected Image    lookupPartnerButton;
	protected Image    removePartnerButton;

	
	public AbstractHtsFormView(int mode) {
		super(VIEW_TITLE, "BookingPoView");
		MODE = mode;
		init();
	}

	private void init(){
		layout.setWidget(0, 0, getHeaderWidget());
		deatilsTable = new FlexTable();
		layout.setWidget(1, 0, deatilsTable);
		layout.setWidget(2, 0, getBottomWidget());
		createComponentsAndTitles();
	}

	protected void createComponentsAndTitles() {
		// ID
		deatilsTable.setHTML(   0, 0, DashboardTRL.msg.id());
		idLabel = new Label();
		deatilsTable.setWidget( 0, 1, idLabel);
		deatilsTable.setHTML(   0, 2, "&nbsp;");
		deatilsTable.setHTML(   0, 3, "&nbsp;");
		deatilsTable.setHTML(   0, 4, "&nbsp;");
		deatilsTable.getFlexCellFormatter().setWidth(0, 2, "20px");
		deatilsTable.getFlexCellFormatter().setWidth(0, 3, "20px");
		//deatilsTable.setBorderWidth(1);

		if(MODE==BANKER_MODE){
			meglerPos = 3;
			bankerPos = 1;
		}

		
		//MEGLER
		deatilsTable.setHTML( meglerPos, 0, DashboardTRL.msg.broker());
		brokerLA = new Label();
		brokerLA.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				ContactInfoBigPopup.show(tipDTO.getBroker(), brokerLA);
			}
		});
		brokerLA.setStyleName(CssStyles.ACTION_WRAP);
		brokerLA.addStyleName(CssStyles.HIGHLITABLE);
		deatilsTable.setWidget(meglerPos, 1, brokerLA);


		//DIRECTION
		deatilsTable.setHTML( 2, 0, DashboardTRL.msg.banker());
		tipDirectionTypeLA  = new Label();
		tipDirectionTypeImage = new Image();
		tipDirectionTypeImage.setVisible(false);

		FlexTable wraper = new FlexTable();
		wraper.setCellPadding(0);
		wraper.setCellSpacing(0);
		wraper.setWidget(0, 0, tipDirectionTypeImage);
		wraper.setWidget(0, 1, tipDirectionTypeLA);
		wraper.getFlexCellFormatter().setWidth(0, 0, "30px");
		deatilsTable.setWidget( 2, 1, wraper);

		//BANKER
		deatilsTable.setHTML( bankerPos, 0, DashboardTRL.msg.banker());
		bankerLA = new Label();
		bankerLA.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				ContactInfoBigPopup.show(tipDTO.getBanker(), bankerLA);
			}
		});
		bankerLA.setStyleName(CssStyles.ACTION_WRAP);
		bankerLA.addStyleName(CssStyles.HIGHLITABLE);
		deatilsTable.setWidget(bankerPos, 1, bankerLA);

		// Lookup and remove always will be on 3 position
		lookupPartnerButton = new Image(RES.search());
		lookupPartnerButton.setStyleName(CssStyles.ACTION_WRAP);
		deatilsTable.setWidget( 3, 2, lookupPartnerButton);
		removePartnerButton = new Image(RES.cancelSmall());
		removePartnerButton.setStyleName(CssStyles.ACTION_WRAP);
		deatilsTable.setWidget(3, 3, removePartnerButton);
		
		//CLIENT 
		deatilsTable.setHTML(4, 0, DashboardTRL.msg.client());
		clientLA = new Label();
		clientLA.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				ContactInfoBigPopup.show(tipDTO.getClient(), clientLA);
			}
		});
		clientLA.setStyleName(CssStyles.ACTION_WRAP);
		clientLA.addStyleName(CssStyles.HIGHLITABLE);
		deatilsTable.setWidget(4, 1, clientLA);
		lookupClientButton = new Image(RES.search());
		lookupClientButton.setStyleName(CssStyles.ACTION_WRAP);
		deatilsTable.setWidget(4, 2, lookupClientButton);
		removeClientButton = new Image(RES.cancelSmall());
		removeClientButton.setStyleName(CssStyles.ACTION_WRAP);
		deatilsTable.setWidget(4, 3, removeClientButton);
		
		//ESTATE
		deatilsTable.setHTML( 5, 0, DashboardTRL.msg.estate());
		estateLA = new Label();
		estateLA.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				PlaceInfoBigPopup.show(tipDTO.getEstate(), estateLA);
			}
		});
		estateLA.setStyleName(CssStyles.ACTION_WRAP);
		estateLA.addStyleName(CssStyles.HIGHLITABLE);
		deatilsTable.setWidget(5, 1, estateLA);
		
		lookupEstateButton = new Image(RES.search());
		lookupEstateButton.setStyleName(CssStyles.ACTION_WRAP);
		deatilsTable.setWidget(5, 2, lookupEstateButton);
		removeEstateButton = new Image(RES.cancelSmall());
		removeEstateButton.setStyleName(CssStyles.ACTION_WRAP);
		deatilsTable.setWidget(5, 3, removeEstateButton);
		
		
		//TYPE
		deatilsTable.setHTML(6, 0, DashboardTRL.msg.tipType());
		tipTypeLB  = new ListBox();
		tipTypeLB.addItem(TRL.select(), "-1");
		tipTypeLB.addItem(TipType.isLoan.getTitle(), TipType.isLoan.getId().toString());
		tipTypeLB.addItem(TipType.isSell.getTitle(), TipType.isSell.getId().toString());
		tipTypeLB.addItem(TipType.isInventory.getTitle(), TipType.isInventory.getId().toString());
		tipTypeLB.setWidth(LB_WIDTH);
		deatilsTable.setWidget(6, 1, tipTypeLB);
		
		//COMMENTS
		deatilsTable.setHTML(7, 0, DashboardTRL.msg.comments());
		comments = new TextArea();
		deatilsTable.setWidget(7, 1, comments);
	
		//CREATED
		deatilsTable.setHTML(8, 0, DashboardTRL.msg.created());
		created = new DateBox();
		created.setFormat(new DateBox.DefaultFormat(AppFormats.DATE_FORMAT));
		deatilsTable.setWidget(8, 1, created);
		
		//STATUS
		deatilsTable.setHTML(9, 0, DashboardTRL.msg.status());
		tipStatusTypeLB  = new ListBox();
		AppUtils.setItemsNAToLB(tipStatusTypeLB);
		tipStatusTypeLB.setWidth(LB_WIDTH);
		deatilsTable.setWidget(9, 1, tipStatusTypeLB);
		
		//REPLY PART
		deatilsTable.setHTML(10, 0, DashboardTRL.msg.modificationComments());
		statusComments = new TextArea();
		deatilsTable.setWidget(10, 1, statusComments);
		


		deatilsTable.setHTML(11, 0, DashboardTRL.msg.modificationDate());
		modified = new DateBox();
		modified.setFormat(new DateBox.DefaultFormat(AppFormats.DATE_FORMAT));
		deatilsTable.setWidget(11, 1, modified);
		
	}

	@Override
	protected Widget createContent(){
		layout = new FlexTable();
		layout.setWidth("100%");
		return layout;
	}

	@Override
	public void setData(TipDTO data) {
		tipDTO = data;
		// detect direction: is to me or is from me
		if(TipDirectionType.isMtoB.getId().equals(tipDTO.getTipDirectionType())){
			// Megler to Banker
			is_I_send =  MEGLER_MODE == MODE;
		}else{
			// Banker to Megler
			is_I_send =  BANKER_MODE == MODE;
		}
		removeErrorInCell();

		
		
		// ID 
		idLabel.setText(tipDTO.getId()==null ? "" : ""+tipDTO.getId());
		deatilsTable.setWidget( 0, 1, idLabel);

		//BROKER & BANKER
		renderBroker();
		renderBanker();
		// lookup & remove partner
		renderLookupAndRemovePartner();
		
		//Tip Direction Image And Label
		renderTipDirectionImageAndLabel();
		
		//Client
		renderClient();
		
		//Estate
		renderEstate();
		
		//TipType
		renderTipType();

		//Comments And Created
		renderCommentsAndCreated();
		
	
		//Tip Status Type - is New/isInProcess/isAccepted/isRejected
		renderTipStatusTypeLBBasedOnMode();

		//Reply And Changed
		renderReply();
		
		
		//SAVE BUTTON
		renderSaveButtonBasedOnMode();
	}
	
	protected void renderBroker() {
		if(tipDTO.getBroker()!=null){
			brokerLA.setText(tipDTO.getBroker().getFullName());
		}else{
			brokerLA.setText("");
		}
	}
	protected void renderBanker() {
		if(tipDTO.getBanker()!=null){
			bankerLA.setText(tipDTO.getBanker().getFullName());
		}else{
			bankerLA.setText("");
		}
	}
	
	protected void renderLookupAndRemovePartner(){
		lookupPartnerButton.setVisible(false);
		removePartnerButton.setVisible(false);
		if(is_I_send && TipStatusType.isNew.getId().equals(tipDTO.getTipStatusType())){
			lookupPartnerButton.setVisible(true);
			if(MEGLER_MODE == MODE && tipDTO.getBanker()!=null){
				removePartnerButton.setVisible(true);
			}
			if(BANKER_MODE == MODE && tipDTO.getBroker()!=null){
				removePartnerButton.setVisible(true);
			}
		}
	}

	protected void renderTipDirectionImageAndLabel() {
		tipDirectionTypeLA.setText(TipDirectionType.getTitleById(tipDTO.getTipDirectionType()));
		if(is_I_send)
			tipDirectionTypeImage.setResource(RES.arrowDownGrey22());
		else 
			tipDirectionTypeImage.setResource(RES.arrowUpGreen22());
		tipDirectionTypeImage.setVisible(true);
	}

	
	
	private void renderClient(){
		if(tipDTO.getClient()!=null){
			clientLA.setText(tipDTO.getClient().getFullName());
		}else{
			clientLA.setText("");
		}

		removeClientButton.setVisible(false);
		lookupClientButton.setVisible(false);
		
		if(is_I_send && TipStatusType.isNew.getId().equals(tipDTO.getTipStatusType())){
			lookupClientButton.setVisible(true);
			if(tipDTO.getClient()!=null)
				removeClientButton.setVisible(true);
		}
	
	}
	
	protected void renderEstate(){
		if(tipDTO.getEstate()!=null){
			estateLA.setText(tipDTO.getEstate().getAddress());
		}else{
			estateLA.setText("");
		}
		
		removeEstateButton.setVisible(false);
		lookupEstateButton.setVisible(false);
		
		if(is_I_send && TipStatusType.isNew.getId().equals(tipDTO.getTipStatusType())){
			if(tipDTO.getBroker()!=null)
				lookupEstateButton.setVisible(true);
			if(tipDTO.getEstate()!=null)
				removeEstateButton.setVisible(true);
		}
		
		
		
	}
	
	private void renderTipType(){
		AppUtils.selectedItemByValue(tipTypeLB, ""+tipDTO.getTipType());
		tipTypeLB.setEnabled(false);
		if(is_I_send && TipStatusType.isNew.getId().equals(tipDTO.getTipStatusType())){
			tipTypeLB.setEnabled(true);
		}
	}
	
	private void renderCommentsAndCreated(){
		comments.setText(tipDTO.getComments());
		created.setValue(tipDTO.getCreated());

		comments.setEnabled(false);
		created.setEnabled(false);
		if(is_I_send && TipStatusType.isNew.getId().equals(tipDTO.getTipStatusType())){
			comments.setEnabled(true);
			created.setEnabled(true);
		}
	}
	

	protected void renderTipStatusTypeLBBasedOnMode(){
		//XXX mozet originaljnij status pokazatj sboku?! ... a to 
		// esli isNew, to ne vidno eto 4to bil isNew
		tipStatusTypeLB.clear();
		TipStatusType type = TipStatusType.getById(tipDTO.getTipStatusType());
		if(is_I_send){
			// this box always will be not editable, as only Megler can change status;
			tipStatusTypeLB.addItem(type.getTitle(),  type.getId().toString());
			tipStatusTypeLB.setEnabled(false);
		}else{
			// Someone sent to me
			if(TipStatusType.isNew.equals(type) || TipStatusType.isInProcess.equals(type) ){ // to InPro/Ace/Rej
				tipStatusTypeLB.addItem(TRL.select(), "-1");
				tipStatusTypeLB.addItem(TipStatusType.isInProcess.getTitle(), TipStatusType.isInProcess.getId().toString());
				tipStatusTypeLB.addItem(TipStatusType.isSucceed.getTitle(),   TipStatusType.isSucceed.getId().toString());
				tipStatusTypeLB.addItem(TipStatusType.isRejected.getTitle(),  TipStatusType.isRejected.getId().toString());
			}else{ // to InPro/Ace/Rej
				tipStatusTypeLB.addItem(TRL.select(), "-1");
				tipStatusTypeLB.addItem(TipStatusType.isSucceed.getTitle(),   TipStatusType.isSucceed.getId().toString());
				tipStatusTypeLB.addItem(TipStatusType.isRejected.getTitle(),  TipStatusType.isRejected.getId().toString());
			}
			AppUtils.selectedItemByValue(tipStatusTypeLB, ""+type.getId());
			tipStatusTypeLB.setEnabled(true);
		}
	} 

	private void renderReply(){
		statusComments.setText(tipDTO.getStatusComments());
		modified.setValue(tipDTO.getModified());

		statusComments.setEnabled(false);
		modified.setEnabled(false);
		
		if(!is_I_send){
			statusComments.setEnabled(true);
			modified.setEnabled(true);
			
			if(tipDTO.getModified()==null)
				modified.setValue(new Date());
		}
	}
	
	private void renderSaveButtonBasedOnMode() {
		if(is_I_send){
			//edit possible only if isNew
			TipStatusType type = TipStatusType.getById(tipDTO.getTipStatusType());
			saveButton.setEnabled(TipStatusType.isNew.equals(type));
		}else{
			// I always can reply
			saveButton.setEnabled(true);
		}

	}
	
	protected Widget getHeaderWidget() {
		FlexTable widget = new FlexTable();
		return widget;
	}

	protected Widget getBottomWidget() {
		FlexTable widget = new FlexTable();

		saveButton = new  Button();
		saveButton.setText(DashboardTRL.msg.save());
		widget.setWidget(0, 0, saveButton);
		widget.addStyleName(CssStyles.TABLE_DATA_PADDING_20);
		return widget;
	}

	@Override
	public void setDataRequested() {
		saveButton.setEnabled(false);
		deatilsTable.setWidget( 0, 1, new Image(RES.loadingSmall()));
	}

	@Override
	public HasClickHandlers getSaveButton() {
		return saveButton;
	}

	@Override
	protected String getPrefferedWidth() {
		return	VIEW_WIDTH;
	}

	protected void setErrorInCell(int row){
		deatilsTable.getFlexCellFormatter().addStyleName(row, 0, CssStyles.fieldRequiredError);
	}

	protected void removeErrorInCell(){
		for(int i = 0; i <12 ; i++)
			deatilsTable.getFlexCellFormatter().removeStyleName(i, 0, CssStyles.fieldRequiredError);

	}

	// Lookup functionality for Clients
	@Override
	public HasClickHandlers getLookupClientButton() {
		return lookupClientButton;
	}
	@Override
	public HasClickHandlers getRemoveClientButton() {
		return removeClientButton;
	}
	
	@Override
	public void setPickedUpClient(ClientO2P object) {
		tipDTO.setClient(object);
		renderClient();
	}
	
	@Override
	public BankerDTO getSelectedBanker() {
		return tipDTO.getBanker();
	}
	
	@Override
	public BrokerO2P getSelectedBroker() {
		return tipDTO.getBroker();
	}
	
	@Override
	public HasClickHandlers getLookupPartnerButton() {
		return lookupPartnerButton;
	}

	@Override
	public HasClickHandlers getRemovePartnerButton() {
		return removePartnerButton;
	}

	@Override
	public HasClickHandlers getLookupEstateButton() {
		return lookupEstateButton;
	}

	@Override
	public HasClickHandlers getRemoveEstateButton() {
		return removeEstateButton;
	}

	@Override
	public void setPickedUpEstate(EstateO2P object) {
		tipDTO.setEstate(object);
		renderEstate();
	}

	@Override
	public ClientO2P getSelectedClient() {
		return tipDTO.getClient();
	}

	@Override
	public EstateO2P getSelectedEstate() {
		return tipDTO.getEstate();
	}
	
	@Override
	public TipDTO getData() {
		removeErrorInCell();
		int requiredErrorsCount = 0;
		
		// ID - skip
		//DIRECTION - skip
		// Megler or Banker
		if(MEGLER_MODE == MODE){
			if(tipDTO.getBanker()==null){
				setErrorInCell(3);      
				requiredErrorsCount++;
			}
		}else{
			if(tipDTO.getBroker()==null){
				setErrorInCell(3);      
				requiredErrorsCount++;
			}
		}
		
		//Client
		if(tipDTO.getClient()==null){
			setErrorInCell(4);
			requiredErrorsCount++;
		}
		
		//ESTATE - not req

		//TIP TYPE
		Integer tipType = AppUtils.getSelectedValueAsInteger(tipTypeLB);
		if(tipType<0){
			setErrorInCell(6);
			requiredErrorsCount++;
		}
		tipDTO.setTipType(tipType);
		
		
		tipDTO.setComments(comments.getText());

		tipDTO.setCreated(created.getValue());
		
		Integer tipStatusType = AppUtils.getSelectedValueAsInteger(tipStatusTypeLB);
		if(tipStatusType<0){
			setErrorInCell(9);
			requiredErrorsCount++;
		}
		tipDTO.setTipStatusType(tipStatusType);
		
		
		tipDTO.setModified(modified.getValue());

		tipDTO.setStatusComments(statusComments.getText());
		
		if(requiredErrorsCount>0){
			AppDialog.show(TRL.requiredFieldsError(), AppDialog.ERROR_MESSAGE);
			return null;
		} 
		return tipDTO;
	}
	
}
*/