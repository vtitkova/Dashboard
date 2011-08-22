package com.dmma.dashboard.gwt.core.client.mvp.tip.tipform.presenter;

import gwt.dmma.base.client.ui.lookup.LookUpPanelListener;
import gwt.dmma.base.client.ui.lookup.LookupDialog;
import gwt.dmma.base.client.ui.lookup.LookupPresenterAndView;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.dashboard.gwt.core.client.mvp.banker.lookupBanker.presenter.LookupBankerPresenter;
import com.dmma.dashboard.gwt.core.client.mvp.broker.lookupBroker.presenter.LookupBrokerPresenter;
import com.dmma.dashboard.gwt.core.client.mvp.client.lookupClient.presenter.LookupClientPresenter;
import com.dmma.dashboard.gwt.core.client.mvp.estate.lookupEstate.presenter.LookupEstatePresenter;
import com.dmma.dashboard.gwt.core.client.mvp.tip.tipform.view.AbstractTipFormView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.client.types.TipDirectionType;
import com.dmma.dashboard.gwt.core.client.types.TipStatusType;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.BankerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.BrokerDTO;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.entities.TipDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;


public abstract class AbstractTipFormPresenter<T extends AbstractTipFormPresenterDisplay>{
	protected final T display;
	protected final int MODE;
	
	public AbstractTipFormPresenter(int mode, T display) {
		this.MODE = mode;
		this.display = display;
		init();
	}
	
	private void init() {
		this.display.getSaveButton().addClickHandler(new ClickHandler() {   
			public void onClick(ClickEvent event) {
				doSave();
			}
		});
		this.display.getLookupClientButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				lookUpClient();
			}
		});
		this.display.getRemoveClientButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				display.setPickedUpClient(null);
			}
		});
		this.display.getLookupEstateButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				lookUpEstate();
			}
		});
		this.display.getRemoveEstateButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				display.setPickedUpEstate(null);
			}
		});
		this.display.getLookupPartnerButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				lookUpPartner();
			}
		});
		this.display.getRemovePartnerButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				removePartner();
			}
		});
	}
	
	protected abstract void lookUpPartner();
	protected abstract void removePartner();
	
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
	
	
	private void lookUpEstate() {
		BrokerDTO b = display.getSelectedBroker();
		LookupEstatePresenter presenterAndView = new LookupEstatePresenter(b);
		
		final LookupDialog<EstateDTO> dialog = new LookupDialog<EstateDTO>(presenterAndView);
		presenterAndView.setLookUpPanelListener(new LookUpPanelListener<EstateDTO>() {
			@Override
			public void onLookUpPickUp(EstateDTO object) {
				display.setPickedUpEstate(object);
				dialog.hide();
			}
			@Override
			public void onLookUpCanceled() {
				dialog.hide();
			}
		});
		presenterAndView.setDefaultPickedUpObject(display.getSelectedEstate());
		dialog.center();
		presenterAndView.requestEstateList();
	}
	
	protected void lookUpBanker() {
		LookupPresenterAndView<BankerDTO> presenterAndView = new LookupBankerPresenter();
		final LookupDialog<BankerDTO> dialog = new LookupDialog<BankerDTO>(presenterAndView);
		presenterAndView.setLookUpPanelListener(new LookUpPanelListener<BankerDTO>() {
			@Override
			public void onLookUpPickUp(BankerDTO object) {
				setPickedUpBanker(object);
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
	protected abstract void setPickedUpBanker(BankerDTO object);
	
	protected void lookUpBroker() {
		LookupPresenterAndView<BrokerDTO> presenterAndView = new LookupBrokerPresenter();
		final LookupDialog<BrokerDTO> dialog = new LookupDialog<BrokerDTO>(presenterAndView);
		presenterAndView.setLookUpPanelListener(new LookUpPanelListener<BrokerDTO>() {
			@Override
			public void onLookUpPickUp(BrokerDTO object) {
				setPickedUpBroker(object);
				dialog.hide();
			}
			@Override
			public void onLookUpCanceled() {
				dialog.hide();
			}
		});
		presenterAndView.setDefaultPickedUpObject(display.getSelectedBroker());
		dialog.center();
	}
	protected abstract void setPickedUpBroker(BrokerDTO object);
	
	
	
	
	
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(getPresenterId(), this.getClass().getName());
		Integer tipId = e.getParamAsInteger(EKP.ID);
		if(tipId==null){
			TipDTO newTip = createNewTipBasedOnMode();
			display.setData(newTip);
		}else{
			display.setDataRequested();
			requestTip(tipId);
		}
	}
	
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}
	
	
	
	protected TipDTO createNewTipBasedOnMode() {
		TipDTO newTip = new TipDTO();
		newTip.setTipStatusType(TipStatusType.isNew.getId());
		if(AbstractTipFormView.MEGLER_MODE == MODE){
			newTip.setTipDirectionType(TipDirectionType.isMtoB.getId());
		}else{
			newTip.setTipDirectionType(TipDirectionType.isBtoM.getId());
		}
		requestMyInfo();
		return newTip;
	}
	protected abstract void requestMyInfo();
	
	
	// SAVE TIP
	private SaveCallback   saveCallback   = new SaveCallback();
	protected void doSave() {
		TipDTO entity = display.getData();
		if(entity==null) return;
		ServiceFactory.getTipService().saveOrUpdateForAll(entity,saveCallback);
	}
	private void dataSaved(Integer result) {
		AppDialog.show(BaseMessages.MSG.saveOperationSuccessed(), AppDialog.INFORMATION_MESSAGE);
		afterSaveSuccessed();
	}
	protected abstract void afterSaveSuccessed();
	private class SaveCallback extends MyAsyncCallback<Integer>{
		public void onSuccess(Integer result) {
			if(result==null)
				onnFailure(null);
			else
				dataSaved(result);			
		}
	}
	
	
	// REQUEST AND RECEIVE TIP
	private GetCallback    getCallback    = new GetCallback();
	protected void requestTip(Integer id) {
		if(AbstractTipFormView.MEGLER_MODE == MODE)
			ServiceFactory.getTipService().findByIdAsBroker(id, getCallback);
		else
			ServiceFactory.getTipService().findByIdAsBanker(id, getCallback); 
	}
	private void tipReceived(TipDTO result){
		display.setData(result);
	}
	private class GetCallback extends MyAsyncCallback<TipDTO>{
		public void afterFailure() {
			AppEvent redirectEvent = new AppEvent(getPresenterId(), this.getClass().getName());
			History.newItem(URLParser.toHistoryToken(redirectEvent), true );
		}
		@Override
		public void onSuccess(TipDTO result) {
			tipReceived(result);			
		}
	}
	
	/** returns unique presenter identifier */
	public abstract String getPresenterId();
	
}
