package com.dmma.dashboard.gwt.broker.client.mvp.hts.htsForm.presenter;


import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.event.URLParser;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.base.gwt.shared.keys.AppParamConstants;
import com.dmma.dashboard.gwt.broker.client.mvp.hts.htsForm.view.BrokersHtsFormView;
import com.dmma.dashboard.gwt.broker.client.mvp.hts.myHts.presenter.BrokersHtsPresenter;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.shared.entities.ClientVisitDTO;
import com.dmma.dashboard.gwt.core.shared.entities.HaveToSellDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;

public class BrokersHtsFormPresenter  implements Presenter {  
	public static String PRESENTER_ID = "HtsForm";
	
	private AppEvent     defParams;
	private GetCallback  callback     = new GetCallback();
	
	private final BrokersHtsFormPresenterDisplay     display;
	
	public BrokersHtsFormPresenter() {
		this.display = new BrokersHtsFormView();
		init() ;
	}

	private void init() {
		display.getSaveButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				doSave();
			}

		});
	}
	
	
	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}



	@Override
	public void repaintWidget(HasWidgets container) {
		container.clear();
		container.add(display.asWidget());
	}


	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(PRESENTER_ID, this.getClass().getName());
		defParams = e;
		Integer id = defParams.getParamAsInteger(AppParamConstants.ID);
		if(id!=null){
			requestHts(id);
		}else {
			AppEvent redirectEvent = new AppEvent(BrokersHtsPresenter.PRESENTER_ID, this.getClass().getName());
			History.newItem(URLParser.toHistoryToken(redirectEvent), true );
		}
	}
	
	
	private void requestHts(Integer id) {
		display.setDataRequested();
		ServiceFactory.getHaveToSellService().findByIdAsBroker(id, callback); 
	}
	private void htsRecived(HaveToSellDTO result){
			display.setData(result);
			
			Integer defBrokerId = result.getDefaultBroker().getId();
			Integer processedBrokerId = result.getProcessedBy().getId();
			if(defBrokerId.equals(processedBrokerId)){
				ServiceFactory.getClientVisitService().findById(result.getClientVisitId(), new AsyncCallback<ClientVisitDTO>() {
					@Override
					public void onSuccess(ClientVisitDTO result) {
						display.setClientVisitData(result);
					}
					@Override
					public void onFailure(Throwable caught) {
					}
				}); 
			}
			
			
	}
	private class GetCallback extends MyAsyncCallback<HaveToSellDTO>{
		@Override
		public void afterFailure() {
			AppEvent redirectEvent = new AppEvent(BrokersHtsPresenter.PRESENTER_ID, this.getClass().getName());
			History.newItem(URLParser.toHistoryToken(redirectEvent), true );
		}
		@Override
		public void onSuccess(HaveToSellDTO result) {
			htsRecived(result);			
		}
	}

	private void doSave() {
		HaveToSellDTO dto = display.getHaveToSellDTO();
		if(dto!=null){
			display.setSaveRequested();
			ServiceFactory.getHaveToSellService().saveOrUpdate(dto, saveCallback);
		}
	}
	private void saveDone(Integer result) {
		requestHts(result);
	}
	
	
	private SaveCallback saveCallback  = new SaveCallback(); 
	private class SaveCallback extends MyAsyncCallback<Integer>{
		@Override
		public void afterFailure() {
			AppEvent redirectEvent = new AppEvent(BrokersHtsPresenter.PRESENTER_ID, this.getClass().getName());
			History.newItem(URLParser.toHistoryToken(redirectEvent), true );
		}
		@Override
		public void onSuccess(Integer result) {
			saveDone(result);			
		}
	}


}
