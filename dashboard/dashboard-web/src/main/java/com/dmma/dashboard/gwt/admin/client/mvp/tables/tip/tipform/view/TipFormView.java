package com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tipform.view;

import gwt.dmma.base.client.utils.CssStyles;

import java.util.ArrayList;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.contactInfo.ContactInfoBigPopup;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.base.gwt.client.utils.BaseFormats;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tipform.presenter.TipFormPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.img.DashboardImages;
import com.dmma.dashboard.gwt.core.client.types.TipDirectionType;
import com.dmma.dashboard.gwt.core.client.types.TipStatusType;
import com.dmma.dashboard.gwt.core.client.types.TipType;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class TipFormView extends BaseCompositeView implements TipFormPresenterDisplay{
	public static String VIEW_TITLE = DashboardMessages.MSG.menuTipForm();
	public static String VIEW_WIDTH = "800px";
	private static int LB_WIDTH = 180;
	
	private TipDTO tipDTO = new TipDTO();
	private FlexTable deatilsTable;
	private Button saveButton;
	
	private Label    idLabel;
	private ListBox  tipDirectionTypeLB;
	private Image    tipDirectionTypeImage;
	private Label    brokerLA;
	private Image    lookupBrokerButton;
	private Image    removeBrokerButton;
	private Label    bankerLA;
	private Image    lookupBankerButton;
	private Image    removeBankerButton;
	private Label    clientLA;
	private Image    lookupClientButton;
	private Image    removeClientButton;
	private ListBox  estateLB;
	private CheckBox showOnlyActiveCB;
	
	private ListBox  tipTypeLB;
	private TextArea comments;
	private DateBox  created;
	private ListBox  tipStatusTypeLB;
	private TextArea statusComments;
	private DateBox  modified;
	
	private boolean keepEstateId = true; 
	private FlexTable layout;
	
	public TipFormView() {
		super(VIEW_TITLE,"BookingPoView");
	}

	@Override
	protected Widget createContent(){
		layout = new FlexTable();
		layout.setWidth("100%");
	
		layout.setWidget(0, 0, getHeaderWidget());
		deatilsTable = new FlexTable();
		layout.setWidget(1, 0, deatilsTable);
		layout.setWidget(2, 0, getBottomWidget());

		createTitles();
		createComponents();

		return layout;
	}

	private void createComponents() {
		deatilsTable.getFlexCellFormatter().setWidth(0, 2, "20px");
		deatilsTable.getFlexCellFormatter().setWidth(0, 3, "20px");
		//deatilsTable.setBorderWidth(1);
		
		//ID
		idLabel = new Label();
		deatilsTable.setWidget( 0, 1, idLabel);
		
		//BROKER
		brokerLA = new Label();
		brokerLA.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				ContactInfoBigPopup.show(tipDTO.getBroker(), brokerLA);
			}
		});
		brokerLA.setStyleName(CssStyles.ACTION_WRAP);
		brokerLA.addStyleName(CssStyles.HIGHLITABLE);
		deatilsTable.setWidget(1, 1, brokerLA);
		lookupBrokerButton = new Image(BaseImages.IMG.search());
		deatilsTable.setWidget(1, 2, lookupBrokerButton);
		removeBrokerButton = new Image(BaseImages.IMG.cancelSmall());
		deatilsTable.setWidget(1, 3, removeBrokerButton);
		
		//DIRECTION
		tipDirectionTypeLB  = new ListBox();
		tipDirectionTypeLB.addItem(BaseMessages.MSG.select(), "-1");
		tipDirectionTypeLB.addItem(TipDirectionType.isMtoB.getTitle(), TipDirectionType.isMtoB.getId().toString());
		tipDirectionTypeLB.addItem(TipDirectionType.isBtoM.getTitle(), TipDirectionType.isBtoM.getId().toString());
		tipDirectionTypeLB.setWidth((LB_WIDTH - 30)+"px");
		tipDirectionTypeLB.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(ChangeEvent arg0) {
				renderTipDirectionImage();
			}
		});

		tipDirectionTypeImage = new Image();
		tipDirectionTypeImage.setVisible(false);

		FlexTable wraper = new FlexTable();
		wraper.setCellPadding(0);
		wraper.setCellSpacing(0);
		wraper.setWidget(0, 0, tipDirectionTypeImage);
		wraper.setWidget(0, 1, tipDirectionTypeLB);
		wraper.getFlexCellFormatter().setWidth(0, 0, "30px");
		deatilsTable.setWidget( 2, 1, wraper);

		//BANKER
		bankerLA = new Label();
		bankerLA.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				ContactInfoBigPopup.show(tipDTO.getBanker(), bankerLA);
			}
		});
		bankerLA.setStyleName(CssStyles.ACTION_WRAP);
		bankerLA.addStyleName(CssStyles.HIGHLITABLE);
		deatilsTable.setWidget(3, 1, bankerLA);
		lookupBankerButton = new Image(BaseImages.IMG.search());
		deatilsTable.setWidget(3, 2, lookupBankerButton);
		removeBankerButton = new Image(BaseImages.IMG.cancelSmall());
		deatilsTable.setWidget(3, 3, removeBankerButton);
		
		//CLIENT
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
		lookupClientButton = new Image(BaseImages.IMG.search());
		deatilsTable.setWidget(4, 2, lookupClientButton);
		removeClientButton = new Image(BaseImages.IMG.cancelSmall());
		deatilsTable.setWidget(4, 3, removeClientButton);
		
		estateLB = new ListBox();
		estateLB.setWidth(LB_WIDTH+"px");
		BaseListBoxUtils.setItemsNAToLB(estateLB);
		deatilsTable.setWidget(5, 1, estateLB);
		
		showOnlyActiveCB = new CheckBox(DashboardMessages.MSG.showOnlyActiveEstate());
		showOnlyActiveCB.setValue(true);
		deatilsTable.setWidget(5, 2, showOnlyActiveCB);
		deatilsTable.getFlexCellFormatter().setColSpan(5, 2, 3);
		
		tipTypeLB  = new ListBox();
		tipTypeLB.addItem(BaseMessages.MSG.select(), "-1");
		tipTypeLB.addItem(TipType.isLoan.getTitle(), TipType.isLoan.getId().toString());
		tipTypeLB.addItem(TipType.isSell.getTitle(), TipType.isSell.getId().toString());
		tipTypeLB.addItem(TipType.isInventory.getTitle(), TipType.isInventory.getId().toString());
		tipTypeLB.setWidth(LB_WIDTH+"px");
		deatilsTable.setWidget(6, 1, tipTypeLB);
		
		comments = new TextArea();
		deatilsTable.setWidget(7, 1, comments);
		
		created = new DateBox();
		created.setFormat(new DateBox.DefaultFormat(BaseFormats.DATE_FORMAT));
		deatilsTable.setWidget(8, 1, created);
		
		
		tipStatusTypeLB  = new ListBox();
		tipStatusTypeLB.addItem(BaseMessages.MSG.select(), "-1");
		tipStatusTypeLB.addItem(TipStatusType.isNew.getTitle(),       TipStatusType.isNew.getId().toString());
		tipStatusTypeLB.addItem(TipStatusType.isInProcess.getTitle(), TipStatusType.isInProcess.getId().toString());
		tipStatusTypeLB.addItem(TipStatusType.isSucceed.getTitle(),   TipStatusType.isSucceed.getId().toString());
		tipStatusTypeLB.addItem(TipStatusType.isRejected.getTitle(),  TipStatusType.isRejected.getId().toString());
		tipStatusTypeLB.setWidth(LB_WIDTH+"px");
		deatilsTable.setWidget(9, 1, tipStatusTypeLB);
		
		statusComments = new TextArea();
		deatilsTable.setWidget(10, 1, statusComments);
		
		
		modified = new DateBox();
		modified.setFormat(new DateBox.DefaultFormat(BaseFormats.DATE_FORMAT));
		deatilsTable.setWidget(11, 1, modified);
		
		
	}

	private void renderTipDirectionImage() {
		Integer dirId = BaseListBoxUtils.getSelectedValueAsInteger(tipDirectionTypeLB);
		if(dirId!=null && dirId>0){
			//Megler sverhu
			if(TipDirectionType.isMtoB.getId()==dirId)
				tipDirectionTypeImage.setResource(DashboardImages.IMG.arrowDownGreen22());
			else 
				tipDirectionTypeImage.setResource(DashboardImages.IMG.arrowUpGreen22());

			tipDirectionTypeImage.setVisible(true);
		}else{
			tipDirectionTypeImage.setVisible(false);
		}
	}

	private Widget getHeaderWidget() {
		FlexTable widget = new FlexTable();
		return widget;
	}

	@Override
	protected String getPrefferedWidth() {
		return	VIEW_WIDTH;
	}

	private void setErrorInCell(int row){
		deatilsTable.getFlexCellFormatter().addStyleName(row, 0, CssStyles.fieldRequiredError);
	}
	
	private void removeErrorInCell(){
		for(int i = 0; i <12 ; i++)
			deatilsTable.getFlexCellFormatter().removeStyleName(i, 0, CssStyles.fieldRequiredError);
		
	}
	
	private void createTitles() {
		int row = 0;
		deatilsTable.setHTML( row,   0, DashboardMessages.MSG.id());
		deatilsTable.setHTML( row,   1, "&nbsp;");
		deatilsTable.setHTML( row,   2, "&nbsp;");
		deatilsTable.setHTML( row,   3, "&nbsp;");
		deatilsTable.setHTML( row++, 4, "&nbsp;");
		
		deatilsTable.setHTML( row++, 0, DashboardMessages.MSG.broker());
		deatilsTable.setHTML( row++, 0, DashboardMessages.MSG.tipDirectionType());
		deatilsTable.setHTML( row++, 0, DashboardMessages.MSG.banker());
	
		deatilsTable.setHTML( row++, 0, DashboardMessages.MSG.client());
		deatilsTable.setHTML( row++, 0, DashboardMessages.MSG.estate());
		
		deatilsTable.setHTML( row++, 0, DashboardMessages.MSG.tipType());
		
		deatilsTable.setHTML( row++, 0, DashboardMessages.MSG.comments());
		
		deatilsTable.setHTML( row++, 0, BaseMessages.MSG.created());
		deatilsTable.setHTML( row++, 0, DashboardMessages.MSG.status());
		deatilsTable.setHTML( row++, 0, DashboardMessages.MSG.modificationComments());
		deatilsTable.setHTML( row++, 0, DashboardMessages.MSG.modificationDate());
	}
	
	
	
	
	private Widget getBottomWidget() {
		FlexTable widget = new FlexTable();

		saveButton = new  Button();
		saveButton.setText(DashboardMessages.MSG.save());
		widget.setWidget(0, 0, saveButton);
		widget.addStyleName(CssStyles.TABLE_DATA_PADDING_20);
		return widget;
	}
	

	@Override
	public HasClickHandlers getSaveButton() {
		return saveButton;
	}


	@Override
	public void setData(TipDTO data) {
		if(data==null)
			tipDTO = new TipDTO();
		else
			tipDTO = data;
		saveButton.setEnabled(true);
		deatilsTable.setWidget( 0, 1, idLabel);
		
		removeErrorInCell();
		idLabel.setText(""+tipDTO.getId());
		
		//tipDirectionType
		BaseListBoxUtils.setSelectedItemByValue(tipDirectionTypeLB, ""+tipDTO.getTipDirectionType());
		renderTipDirectionImage();
		
		
		// banker;
		setPickedUpBanker(tipDTO.getBanker());

		// broker;
		setPickedUpBroker(tipDTO.getBroker());
		
		
		// client;
		setPickedUpClient(tipDTO.getClient());
		
		// estate;
		BaseListBoxUtils.setOnlyOneIdToLB(estateLB, tipDTO.getEstate());
		keepEstateId = true; 
		if( tipDTO.getEstate()!=null){
			showOnlyActiveCB.setValue(false);
		}else{
			showOnlyActiveCB.setValue(true);
		}
		
		
		
		//tipType;         //Loan, SellEstate, broker inventory
		BaseListBoxUtils.setSelectedItemByValue(tipTypeLB, ""+tipDTO.getTipType());
		//comments;
		comments.setText(tipDTO.getComments());
		//created;
		created.setValue(tipDTO.getCreated());
		//tipStatusType;    // is New, isInProcess, isAccepted, isRejected
		BaseListBoxUtils.setSelectedItemByValue(tipStatusTypeLB, ""+tipDTO.getTipStatusType());
		//modified;         // date status has been modified
		modified.setValue(tipDTO.getModified());
		//statusComments;
		statusComments.setText(tipDTO.getStatusComments());
		
	}
	
	@Override
	public TipDTO getData() {
		removeErrorInCell();
		int requiredErrorsCount = 0;
		
		if(tipDTO.getBroker()==null){
			setErrorInCell(1);      
			requiredErrorsCount++;
		}
		
		
		Integer tipDirectionType = BaseListBoxUtils.getSelectedValueAsInteger(tipDirectionTypeLB);
		if(tipDirectionType<0){
			setErrorInCell(2);     
			requiredErrorsCount++;
		}
		tipDTO.setTipDirectionType(tipDirectionType);

		if(tipDTO.getBanker() == null ){
			setErrorInCell(3); 
			requiredErrorsCount++;
		}
		
		if(tipDTO.getClient()==null){
			setErrorInCell(4);
			requiredErrorsCount++;
		}
		
		Integer estateId = getSelectedEstateId();
		if(estateId>0){
			tipDTO.setEstate(new EstateDTO(estateId));
		}
		
		Integer tipType = BaseListBoxUtils.getSelectedValueAsInteger(tipTypeLB);
		if(tipType<0){
			setErrorInCell(6);
			requiredErrorsCount++;
		}
		tipDTO.setTipType(tipType);
		
		tipDTO.setComments(comments.getText());

		tipDTO.setCreated(created.getValue());
		
		Integer tipStatusType = BaseListBoxUtils.getSelectedValueAsInteger(tipStatusTypeLB);
		if(tipStatusType<0){
			setErrorInCell(9);
			requiredErrorsCount++;
		}
		tipDTO.setTipStatusType(tipStatusType);
		
		
		tipDTO.setModified(modified.getValue());

		tipDTO.setStatusComments(statusComments.getText());
		
		if(requiredErrorsCount>0){
			AppDialog.show(BaseMessages.MSG.requiredFieldsError(), AppDialog.ERROR_MESSAGE);
			return null;
		} 
		return tipDTO;
	}

	
	
	@Override
	public void setEstateData(ArrayList<ListBoxDTO> data) {
		if(keepEstateId){
			BaseListBoxUtils.setItemsToLBKeepId(estateLB, data);
			keepEstateId = false;
		}else{
			BaseListBoxUtils.setItemsToLB(estateLB, data);
		}
	}

	private Integer getSelectedEstateId() {
		return BaseListBoxUtils.getSelectedValueAsInteger(estateLB);
	}

	@Override
	public boolean getIsShowOnlyActiveCB() {
		return showOnlyActiveCB.getValue();
	}

	@Override
	public HasValueChangeHandlers<Boolean> getShowOnlyActiveChangeHandler() {
		return showOnlyActiveCB;
	}


	// Lookup functionality for Clients
	@Override
	public HasClickHandlers getLookupClientButton() {
		return lookupClientButton;
	}
	@Override
	public void setPickedUpClient(ClientDTO object) {
		tipDTO.setClient(object);
		if(object!=null){
			clientLA.setText(object.getFullName());
			removeClientButton.setVisible(true);
		}else{
			clientLA.setText("");
			removeClientButton.setVisible(false);
		}
	}
	@Override
	public ClientDTO getSelectedClient() {
		return tipDTO.getClient();
	}

	// Lookup functionality for Banker
	@Override
	public HasClickHandlers getLookupBankerButton() {
		return lookupBankerButton;
	}
	@Override
	public void setPickedUpBanker(BankerDTO object) {
		tipDTO.setBanker(object);
		if(object!=null){
			bankerLA.setText(object.getFullName());
			removeBankerButton.setVisible(true);
		}else{
			bankerLA.setText("");
			removeBankerButton.setVisible(false);
		}
	}
	@Override
	public BankerDTO getSelectedBanker() {
		return tipDTO.getBanker();
	}

	// Lookup functionality for Broker
	@Override
	public HasClickHandlers getLookupBrokerButton() {
		return lookupBrokerButton;
	}
	@Override
	public void setPickedUpBroker(BrokerDTO object) {
		tipDTO.setBroker(object);
		if(object!=null){
			brokerLA.setText(object.getFullName());
			removeBrokerButton.setVisible(true);
		}else{
			brokerLA.setText("");
			removeBrokerButton.setVisible(false);
		}
			
	}
	@Override
	public BrokerDTO getSelectedBroker() {
		return tipDTO.getBroker();
	}

	@Override
	public void setDataRequested() {
		saveButton.setEnabled(false);
		deatilsTable.setWidget( 0, 1, new Image(BaseImages.IMG.loadingSmall()));
	}

	@Override
	public HasClickHandlers getRemoveClientButton() {
		return removeClientButton;
	}

	@Override
	public HasClickHandlers getRemoveBankerButton() {
		return removeBankerButton;
	}

	@Override
	public HasClickHandlers getRemoveBrokerButton() {
		return removeBrokerButton;
	}

	/*@Override
	public Integer getSelectedClientId() {
		ClientO2P client = getSelectedClient();
		if(client!=null)
			return client.getId();
		return null;
	}

	@Override
	public Integer getSelectedBankerId() {
		BankerDTO banker = getSelectedBanker();
		if(banker!=null)
			return banker.getId();
		return null;
	}

	@Override
	public Integer getSelectedBrokerId() {
		BrokerO2P broker = getSelectedBroker();
		if(broker!=null)
			return broker.getId();
		return null;
	}*/

}