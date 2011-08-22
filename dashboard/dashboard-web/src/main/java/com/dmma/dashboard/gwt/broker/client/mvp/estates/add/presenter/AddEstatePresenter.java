package com.dmma.dashboard.gwt.broker.client.mvp.estates.add.presenter;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.dashboard.gwt.broker.client.mvp.estates.add.view.AddEstateView;
import com.dmma.dashboard.gwt.broker.client.mvp.estates.list.preaenter.MyEstatesPresenter;
import com.dmma.dashboard.gwt.core.client.i18n.DashboardMessages;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.EstateDTO;
import com.dmma.dashboard.gwt.core.shared.errors.ThatIsNotBrokersEstateGError;
import com.dmma.dashboard.gwt.core.shared.errors.ThisEstateisRegisteredGError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;


public class AddEstatePresenter implements Presenter {  
	public static String PRESENTER_ID = "AddEstate";
	private final AddEstatePresenterDisplay     display;
	
	private EstateDTO recivedEstate;
	
	private GetCallback      callback          = new GetCallback();
	
	public AddEstatePresenter() {
		this.display = new AddEstateView();
		init();
	}

	private void init() {
		this.display.getRequestButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				requestEstate();
			}
		});
		this.display.getConfirmButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				doSave();
			}

			
		});
	}
	
	private void doSave() {
		if(recivedEstate!=null){
			ServiceFactory.getEstateService().saveMyEstateFromMidas(recivedEstate, new MyAsyncCallback<Integer>() {
				
				@Override
				public void onSuccess(Integer result) {
					if(result==null) onnFailure(null);
					else 
						estateSaved(result);
				}
				
				@Override
				public void onnFailure(Throwable caught) {
					if(caught!=null && caught instanceof ThisEstateisRegisteredGError){
						AppDialog.show(DashboardMessages.MSG.thisEstateIsRegistered(), AppDialog.ERROR_MESSAGE);
						return;
					}
					AppDialog.show(BaseMessages.MSG.saveOperationFailed(), AppDialog.ERROR_MESSAGE);
				}
			});
		}
	}
	private void estateSaved(Integer result) {
		AppDialog.show(BaseMessages.MSG.saveOperationSuccessed(), AppDialog.INFORMATION_MESSAGE);
		AppEvent event = new AppEvent(MyEstatesPresenter.PRESENTER_ID, this.getClass().getName());
		History.newItem(URLParser.toHistoryToken(event), true );	
	}
	
	@Override
	public void repaintWidget(final HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}

	private void requestEstate() {
		recivedEstate = null;
		Long midasId =  display.getMidasId();
		if(midasId!=null){
			display.setDataRequested();
			ServiceFactory.getEstateService().getMyEstateFromMidas(midasId, callback);
		}
	}


	private void estateRecived(EstateDTO result){
		recivedEstate = result;
		display.setData(result);
	}

	private class GetCallback extends MyAsyncCallback<EstateDTO>{
		@Override
		public void onnFailure(Throwable caught) {
			if(caught instanceof ThatIsNotBrokersEstateGError){
				AppDialog.show(DashboardMessages.MSG.thatIsNotYourEstateGError(), AppDialog.ERROR_MESSAGE);
			} else 	if(caught instanceof ThisEstateisRegisteredGError){
				AppDialog.show(DashboardMessages.MSG.thisEstateIsRegistered(), AppDialog.WARNING_MESSAGE);
			}
			estateRecived(null);
		}
		@Override
		public void onSuccess(EstateDTO result) {
			estateRecived(result);			
		}
	}

	@Override
	public void applyNewParams(AppEvent e) {
	}

	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}
}
