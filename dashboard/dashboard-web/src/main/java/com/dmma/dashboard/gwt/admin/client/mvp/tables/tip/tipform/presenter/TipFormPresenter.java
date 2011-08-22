package com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tipform.presenter;

import gwt.dmma.base.client.ui.lookup.LookUpPanelListener;
import gwt.dmma.base.client.ui.lookup.LookupDialog;
import gwt.dmma.base.client.ui.lookup.LookupPresenterAndView;

import java.util.ArrayList;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tipform.view.TipFormView;
import com.dmma.dashboard.gwt.admin.client.mvp.tables.tip.tips.presenter.TipsPresenter;
import com.dmma.dashboard.gwt.core.client.mvp.banker.lookupBanker.presenter.LookupBankerPresenter;
import com.dmma.dashboard.gwt.core.client.mvp.broker.lookupBroker.presenter.LookupBrokerPresenter;
import com.dmma.dashboard.gwt.core.client.mvp.client.lookupClient.presenter.LookupClientPresenter;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.client.types.TipStatusType;
import com.dmma.dashboard.gwt.core.client.types.search.EstateStatusSearchType;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.dmma.dashboard.gwt.core.shared.wrappers.EstateSearchWrapper;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class TipFormPresenter implements Presenter {  
	public static String PRESENTER_ID = "TipForm";

	private GetCallback    getCallback    = new GetCallback();
	private SaveCallback   saveCallback   = new SaveCallback();

	private final TipFormPresenterDisplay     display;

	public TipFormPresenter() {
		this.display = new TipFormView();
		init();
	}

	private void init() {
		this.display.getSaveButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				doSave();
			}
		});
		this.display.getShowOnlyActiveChangeHandler().addValueChangeHandler( new ValueChangeHandler<Boolean>() {
			@Override
			public void onValueChange(ValueChangeEvent<Boolean> arg0) {
				requestEstates();
			}
		});
		this.display.getLookupClientButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				lookUpClient();
			}
		});

		this.display.getLookupBankerButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				lookUpBanker();
			}
		});
		this.display.getLookupBrokerButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				lookUpBroker();
			}
		});
		this.display.getRemoveClientButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				display.setPickedUpClient(null);
			}
		});
		this.display.getRemoveBrokerButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				display.setPickedUpBroker(null);
				requestEstates();
			}
		});
		this.display.getRemoveBankerButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				display.setPickedUpBanker(null);
			}
		});
	}

	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	private void lookUpClient() {
		LookupPresenterAndView<ClientDTO> presenterAndView = new LookupClientPresenter();
		final LookupDialog<ClientDTO> dialog = new LookupDialog<ClientDTO>(presenterAndView);
		presenterAndView.setLookUpPanelListener(new LookUpPanelListener<ClientDTO>() {
			@Override
			public void onLookUpPickUp(ClientDTO object) {
				display.setPickedUpClient(object);
				dialog.hide();
			}
			@Override
			public void onLookUpCanceled() {
				dialog.hide();
			}
		});
		presenterAndView.setDefaultPickedUpObject(display.getSelectedClient());
		dialog.center();
	}

	private void lookUpBanker() {
		LookupPresenterAndView<BankerDTO> presenterAndView = new LookupBankerPresenter();
		final LookupDialog<BankerDTO> dialog = new LookupDialog<BankerDTO>(presenterAndView);
		presenterAndView.setLookUpPanelListener(new LookUpPanelListener<BankerDTO>() {
			@Override
			public void onLookUpPickUp(BankerDTO object) {
				display.setPickedUpBanker(object);
				dialog.hide();
			}
			@Override
			public void onLookUpCanceled() {
				dialog.hide();
			}
		});
		presenterAndView.setDefaultPickedUpObject(display.getSelectedBanker());
		dialog.center();
	}
	private void lookUpBroker() {
		LookupPresenterAndView<BrokerDTO> presenterAndView = new LookupBrokerPresenter();
		final LookupDialog<BrokerDTO> dialog = new LookupDialog<BrokerDTO>(presenterAndView);
		presenterAndView.setLookUpPanelListener(new LookUpPanelListener<BrokerDTO>() {
			@Override
			public void onLookUpPickUp(BrokerDTO object) {
				display.setPickedUpBroker(object);
				dialog.hide();
				requestEstates();
			}
			@Override
			public void onLookUpCanceled() {
				dialog.hide();
			}
		});
		presenterAndView.setDefaultPickedUpObject(display.getSelectedBroker());
		dialog.center();
	}



	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		Integer tipFormId = e.getParamAsInteger(EKP.ID);
		if(tipFormId==null){
			TipDTO newTip = createNewTipBasedOnMode();
			display.setData(newTip);
		}else{
			display.setDataRequested();
			requestTip(tipFormId);
		}
	}



	private TipDTO createNewTipBasedOnMode() {
		TipDTO newTip = new TipDTO();
		newTip.setTipStatusType(TipStatusType.isNew.getId());
		return newTip;
	}

	private void requestEstates() {
		BrokerDTO broker = display.getSelectedBroker();
		Integer brokerId = null;
		if(broker!=null)
			brokerId = broker.getId();

		if( brokerId == null || brokerId < 0 ){
			display.setEstateData(null);
			return;
		}
		EstateSearchWrapper wrapper = new EstateSearchWrapper();
		wrapper.setBrokerId(brokerId);

		if(display.getIsShowOnlyActiveCB()){
			wrapper.setStatusSearchTypeId(EstateStatusSearchType.isActive.getId());
		}else{
			wrapper.setStatusSearchTypeId(EstateStatusSearchType.isAll.getId());
		}
		ServiceFactory.getEstateService().findEstateBySearchWrapperShort(wrapper, estateGetCallback);
	}
	private EstateGetCallback estateGetCallback = new EstateGetCallback();
	private class EstateGetCallback extends MyAsyncCallback<ArrayList<ListBoxDTO>>{
		@Override
		public void onSuccess(ArrayList<ListBoxDTO> result) {
			display.setEstateData(result);
		}
	}





	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}

	private void doSave() {
		TipDTO entity = display.getData();
		if(entity==null) return;
		ServiceFactory.getTipService().saveOrUpdate(entity,saveCallback);
	}
	private void dataSaved(Integer result) {
		AppDialog.show(BaseMessages.MSG.saveOperationSuccessed(), AppDialog.INFORMATION_MESSAGE);
		AppEvent event = new AppEvent(TipsPresenter.PRESENTER_ID, this.getClass().getName());
		History.newItem(URLParser.toHistoryToken(event), true );
	}
	private class SaveCallback extends MyAsyncCallback<Integer>{
		public void onSuccess(Integer result) {
			if(result==null)
				onnFailure(null);
			else
				dataSaved(result);			
		}
	}



	private void requestTip(Integer id) {
		ServiceFactory.getTipService().findByIdAsAdmin(id, getCallback); 
	}
	private void tipReceived(TipDTO result){
		display.setData(result);
		requestEstates();
	}

	private class GetCallback extends MyAsyncCallback<TipDTO>{
		public void afterFailure() {
			AppEvent redirectEvent = new AppEvent(PRESENTER_ID, this.getClass().getName());
			History.newItem(URLParser.toHistoryToken(redirectEvent), true );
		}
		@Override
		public void onSuccess(TipDTO result) {
			tipReceived(result);			
		}
	}




}
