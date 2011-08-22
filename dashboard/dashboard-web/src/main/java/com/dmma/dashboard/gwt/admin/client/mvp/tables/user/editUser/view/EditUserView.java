package com.dmma.dashboard.gwt.admin.client.mvp.tables.user.editUser.view;

import gwt.dmma.base.client.utils.CssStyles;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseCompositeView;
import com.dmma.base.gwt.client.ui.gwtentity.editor.GwtEntityEditor;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.bankOffice.editBankOffice.presenter.EditBankOfficePresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.banker.editBanker.presenter.EditBankerPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.broker.editBroker.presenter.EditBrokerPresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.brokerOffice.editBrokerOffice.presenter.EditBrokerOfficePresenter;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.user.editUser.presenter.EditUserPresenterDisplay;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.meta.UserCM;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.UserDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class EditUserView extends BaseCompositeView implements EditUserPresenterDisplay{
	public static String VIEW_TITLE = DashboardMessages.MSG.menuAddEditUser();
	public static String VIEW_WIDTH = "800px";

	private Button saveButton;
	private CheckBox isAdminCB;
	
	private FlowPanel brokerDetailsHolder;
	private FlowPanel bankerDetailsHolder;
	private FlowPanel adminDetailsHolder;
		
	private GwtEntityEditor<UserDTO> editor; 
	
	public EditUserView() {
		super(VIEW_TITLE,"BookingPoView");
	}

	@Override
	protected Widget createContent(){
		FlexTable layout = new FlexTable();
		layout.setWidth("100%");

		layout.setWidget(0, 0, getLineTableRowWidget());
		layout.setWidget(0, 1, getDetails());
		layout.getFlexCellFormatter().setWidth(0,0,"300px");
		layout.setWidget(1, 0, getBottomWidget());
		
		return layout;
	}

	private Widget getDetails() {
		FlexTable table = new FlexTable();
		table.setWidth("450px");
		
		table.setHTML(0, 0, DashboardMessages.MSG.brokerProfileDetails());
		table.getFlexCellFormatter().setStyleName(0,0, CssStyles.TABLE_HEADER);
		brokerDetailsHolder = new FlowPanel();
		brokerDetailsHolder.setStyleName(CssStyles.DATA_DATA);
		brokerDetailsHolder.addStyleName("inOneRow");
		table.setWidget(1, 0, brokerDetailsHolder);
		
		table.setHTML(2, 0, DashboardMessages.MSG.bankerProfileDetails());
		table.getFlexCellFormatter().setStyleName(2,0, CssStyles.TABLE_HEADER);
		bankerDetailsHolder = new FlowPanel();
		bankerDetailsHolder.setStyleName(CssStyles.DATA_DATA);
		bankerDetailsHolder.addStyleName("inOneRow");
		table.setWidget(3, 0, bankerDetailsHolder);
		
		table.setHTML(4, 0, DashboardMessages.MSG.adminProfileDetails());
		table.getFlexCellFormatter().setStyleName(4,0, CssStyles.TABLE_HEADER);
		adminDetailsHolder = new FlowPanel();
		adminDetailsHolder.setStyleName(CssStyles.DATA_DATA);
		adminDetailsHolder.addStyleName("inOneRow");
		
		table.setWidget(5, 0, adminDetailsHolder);
		
		isAdminCB = new CheckBox();
		adminDetailsHolder.add(isAdminCB);
		
		return table;
	}

	private Widget getLineTableRowWidget() {
		editor = new GwtEntityEditor<UserDTO>(new UserCM());
		return editor;
	}

	@Override
	protected String getPrefferedWidth() {
		return	VIEW_WIDTH;
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
	public UserDTO getData() {
		return editor.getData();
	}

	@Override
	public HasClickHandlers getSaveButton() {
		return saveButton;
	}

	@Override
	public void setData(UserDTO data) {
		editor.setData(data);
	}

	@Override
	public void setBrokerProfile(final BrokerDTO broker, final Integer userId) {
		brokerDetailsHolder.clear();
		if(broker!=null){
			Label brokerLabel = new Label (broker.getName()+" "+broker.getSurname());
			brokerLabel.setStyleName(CssStyles.ACTION_WRAP);
			brokerLabel.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					AppEvent e = new AppEvent(EditBrokerPresenter.PRESENTER_ID, this.getClass().getName());
					e.addParam(EKP.ID, broker.getId());
					History.newItem(URLParser.toHistoryToken(e), true );
					//EventBus.get().fireEvent(new AppGwtEvent(e));
				}
			});
			brokerDetailsHolder.add(brokerLabel);
			Label in  = new Label ("in");
			in.setStyleName("boldAndBlack");
			brokerDetailsHolder.add(in);
			
			Label brokerOfficeLabel = new Label (broker.getBrokerOffice().getName());
			brokerOfficeLabel.setStyleName(CssStyles.ACTION_WRAP);
			brokerOfficeLabel.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					AppEvent e = new AppEvent(EditBrokerOfficePresenter.PRESENTER_ID, this.getClass().getName());
					e.addParam(EKP.ID, broker.getBrokerOffice().getId());
					History.newItem(URLParser.toHistoryToken(e), true );
					//EventBus.get().fireEvent(new AppGwtEvent(e));
				}
			});
			brokerDetailsHolder.add(brokerOfficeLabel);
		}else{
			brokerDetailsHolder.add(new Label("NA"));
			if(userId!=null){
				//TODO TRL
				Label createBanker = new Label ("Create Broker");
				createBanker.setStyleName(CssStyles.ACTION_WRAP);
				createBanker.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						AppEvent e = new AppEvent(EditBrokerPresenter.PRESENTER_ID, this.getClass().getName());
						e.addParam(EKP.USER_ID, userId);
						History.newItem(URLParser.toHistoryToken(e), true );
						//EventBus.get().fireEvent(new AppGwtEvent(e));
					}
				});
				brokerDetailsHolder.add(createBanker);
			}
		}
	}

	@Override
	public void setBankerProfile(final BankerDTO banker, final Integer userId) {
		bankerDetailsHolder.clear();
		if(banker!=null){
			Label bankerLabel = new Label (banker.getName()+" "+banker.getSurname());
			bankerLabel.setStyleName(CssStyles.ACTION_WRAP);
			bankerLabel.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					AppEvent e = new AppEvent(EditBankerPresenter.PRESENTER_ID, this.getClass().getName());
					e.addParam(EKP.ID, banker.getId());
					History.newItem(URLParser.toHistoryToken(e), true );
					//EventBus.get().fireEvent(new AppGwtEvent(e));
				}
			});
			bankerDetailsHolder.add(bankerLabel);
			Label in  = new Label ("in"); //TODO TRL
			in.setStyleName("boldAndBlack");
			bankerDetailsHolder.add(in);
			
			Label bankOfficeLabel = new Label (banker.getBankOffice().getName());
			bankOfficeLabel.setStyleName(CssStyles.ACTION_WRAP);
			bankOfficeLabel.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					AppEvent e = new AppEvent(EditBankOfficePresenter.PRESENTER_ID, this.getClass().getName());
					e.addParam(EKP.ID, banker.getBankOffice().getId());
					History.newItem(URLParser.toHistoryToken(e), true );
					//EventBus.get().fireEvent(new AppGwtEvent(e));
				}
			});
			bankerDetailsHolder.add(bankOfficeLabel);
		}else{
			bankerDetailsHolder.add(new Label("NA"));
			if(userId!=null){
				//TODO TRL
				Label createBanker = new Label ("Create Banker");
				createBanker.setStyleName(CssStyles.ACTION_WRAP);
				createBanker.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
						AppEvent e = new AppEvent(EditBankerPresenter.PRESENTER_ID, this.getClass().getName());
						e.addParam(EKP.USER_ID, userId);
						History.newItem(URLParser.toHistoryToken(e), true );
						//EventBus.get().fireEvent(new AppGwtEvent(e));
					}
				});
				bankerDetailsHolder.add(createBanker);
			}
		}
	}

	@Override
	public void setAdminProfile(Boolean isAdmin) {
		if(isAdmin==null){
			isAdminCB.setValue(false);
			isAdminCB.setEnabled(false);
		}else{
			isAdminCB.setValue(isAdmin);
			isAdminCB.setEnabled(true);
		}
	}

	@Override
	public void setBrokerProfileRequested() {
		brokerDetailsHolder.clear();
		brokerDetailsHolder.add(new Image(BaseImages.IMG.loadingSmall()));
	}

	@Override
	public void setBankerProfileRequested() {
		bankerDetailsHolder.clear();
		bankerDetailsHolder.add(new Image(BaseImages.IMG.loadingSmall()));
	}

	@Override
	public void setAdminProfileRequested() {
		isAdminCB.setEnabled(false);
	}

	@Override
	public HasClickHandlers getIsAdminCB() {
		return isAdminCB;
	}

	@Override
	public Boolean getIsAdmin() {
		return isAdminCB.getValue();
	}

	@Override
	public void setDataRequested() {
		//editor.set// TODO Auto-generated method stub
		
	}

	@Override
	public void errorInEmailField() {
		editor.setHaveErrorInField(3);
	}

}