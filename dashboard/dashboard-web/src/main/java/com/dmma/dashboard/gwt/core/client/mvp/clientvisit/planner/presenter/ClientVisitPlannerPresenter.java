package com.dmma.dashboard.gwt.core.client.mvp.clientvisit.planner.presenter;

import gwt.dmma.base.client.ui.lookup.LookUpPanelListener;
import gwt.dmma.base.client.ui.lookup.LookupDialog;
import gwt.dmma.base.client.ui.lookup.LookupPresenterAndView;

import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.presenter.Presenter;
import com.dmma.base.gwt.client.rpc.MyAsyncCallback;
import com.dmma.dashboard.gwt.core.client.mvp.client.lookupClient.presenter.LookupClientPresenter;
import com.dmma.dashboard.gwt.core.client.mvp.clientvisit.planner.view.ClientVisitPlannerView;
import com.dmma.dashboard.gwt.core.client.services.factory.ServiceFactory;
import com.dmma.dashboard.gwt.core.client.types.ClientVisitStatusType;
import com.dmma.dashboard.gwt.core.shared.constants.EKP;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitDTOS;
import com.dmma.dashboard.gwt.core.shared.entities.wrappers.ClientVisitPlanDTOW;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class ClientVisitPlannerPresenter  implements Presenter{
	public static String PRESENTER_ID = "cvp";
	protected final int MODE;


	private GetCallback  callback     = new GetCallback();
	private final ClientVisitPlannerPresenterDisplay   display;
	private ClientVisitPlanDTOW clientVisitPlan;
	
	public ClientVisitPlannerPresenter(int mode){
		this.MODE = mode;
		display = new ClientVisitPlannerView(MODE);
		init();
	}


	private void init() {
		this.display.getAddButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				if(clientVisitPlan==null) return;
				LookupPresenterAndView<ClientDTO> presenterAndView = new LookupClientPresenter();
				final LookupDialog<ClientDTO> dialog = new LookupDialog<ClientDTO>(presenterAndView);
				presenterAndView.setLookUpPanelListener(new LookUpPanelListener<ClientDTO>() {
					@Override
					public void onLookUpPickUp(ClientDTO client) {
						ClientVisitDTOS clientVisit = new ClientVisitDTOS();
						clientVisit.setClient(client);
						//we will setup at server 
						//clientVisit.setCreated(new Date());
						clientVisit.setEstateId(clientVisitPlan.getEstate().getId());
						clientVisit.setEstateViewingId(clientVisitPlan.getEstateViewing().getId());
						if(clientVisitPlan.getIsFuture())
							clientVisit.setStatus(ClientVisitStatusType.isPlaningToGo.getId());
						else
							clientVisit.setStatus(ClientVisitStatusType.isWasOnViewing.getId());
						saveClientVisit(clientVisit);
						dialog.hide();
					}
					@Override
					public void onLookUpCanceled() {
						dialog.hide();
					}
				});
				dialog.center();
			}
		});
	}


	@Override
	public String getPresenterId() {
		return PRESENTER_ID;
	}


	@Override
	public void repaintWidget(HasWidgets hasWidgetContainer) {
		hasWidgetContainer.clear();
		hasWidgetContainer.add(display.asWidget());
	}


	@Override
	public void applyNewParams(AppEvent e) {
		if(e==null) e = new AppEvent(getPresenterId(), this.getClass().getName());
		Integer estateViewingId = e.getParamAsInteger(EKP.ID);
		if(estateViewingId==null){
			afterGetFalure();
		}else{
			requestClientVisitPlan(estateViewingId);
		}
	}


	private void requestClientVisitPlan(Integer estateViewingId) {
		clientVisitPlan = null;
		display.setDataRequested();
		if(ClientVisitPlannerView.MEGLER_MODE == MODE){
			ServiceFactory.getClientVisitService().getClientVisitPlanAsBroker(estateViewingId, callback); 
		}else{ 
			ServiceFactory.getClientVisitService().getClientVisitPlanAsAdmin(estateViewingId, callback); 
		}
	}
	private void clientVisitPlanRecived(ClientVisitPlanDTOW result){
		clientVisitPlan = result;
		display.setData(clientVisitPlan);
	}
	private class GetCallback extends MyAsyncCallback<ClientVisitPlanDTOW>{
		@Override
		public void afterFailure() {
			afterGetFalure();
		}
		@Override
		public void onSuccess(ClientVisitPlanDTOW result) {
			clientVisitPlanRecived(result);			
		}
	}

	protected void afterGetFalure(){
		//Override this method
	}
	
	
	public void saveClientVisit(ClientVisitDTOS clientVisit) {
		display.setWeAreBusy(true);
		ServiceFactory.getClientVisitService().saveOrUpdateDTOS(clientVisit, saveCVCallback);
	}
	public void clientVisitSaved(ClientVisitDTOS clientVisit) {
		clientVisitPlan.getClientVisits().add(clientVisit);
		display.addOneClientVisits(clientVisit);
		display.setWeAreBusy(false);
	}
	private SaveCVCallback saveCVCallback = new SaveCVCallback();
	private class SaveCVCallback extends MyAsyncCallback<ClientVisitDTOS>{
		@Override
		public void onSuccess(ClientVisitDTOS clientVisit) {
			clientVisitSaved(clientVisit);			
		}
	}

}
