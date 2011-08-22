package com.dmma.dashboard.gwt.core.client.i18n;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;

public interface DashboardMessages extends Constants{
	public static final DashboardMessages  MSG = (DashboardMessages)     GWT.create(DashboardMessages.class);
		
	public String greeting1();
	public String greeting2();
	
	public String menuTables();
	public String menuEstates();
	public String menuEstatesAdd();
	public String menuEstatesList();
	public String menuEstateDetails();
	public String save();
	public String lookup();
	public String or();
	public String id();
	public String midasId();
	public String externalId();
	public String userId();
	public String finnCode();
	public String orderNumber();
	public String orderNumberShort();
	
	public String menuClients();
	public String menuAddClient();
	public String menuAddEditClient();
	public String menuBrokerOffices();
	public String menuAddBrokerOffice();
	public String menuAddEditBrokerOffice();
	public String menuBankOffices();
	public String menuAddBankOffice();
	public String menuAddEditBankOffice();
	public String menuBrokers();
	public String menuAddBroker();
	public String menuAddEditBroker();
	public String menuBankers();
	public String menuAddBanker();
	public String menuAddEditBanker();
	public String menuUsers();
	public String menuAddUser();
	public String menuAddEditUser();

	public String menuHome();
	public String menuBrokerHome();
	public String menuBankerHome();
	
	//Setup And MyInfo
	public String menuSetups();
	public String menuSetupsMyProfile();

	//My Profile
	
	public String name();
	public String surname();  
	public String email(); 
	public String phone();
	public String cellphone();
	public String avco();
	public String comments();
	public String address();
	public String zip();
	public String city();   
	public String broker();  
	public String banker(); 
	public String client(); 
	public String office(); 
	public String bankOffice();
	public String brokerOffice();
	public String estate();  
	public String postCode();
	public String postCodeShort();
	public String postCity();
	public String gnr();
	public String bnr();
	public String viewing();
	public String viewings();
	public String enabled();
	public String password();
	
	//Errors
	public String  thatIsNotBrokersEstateGError();
	public String  thatIsNotYourEstateGError();
	public String partOfEmail();
	public String userRole();
	public String userStatus();
	public String all();
	public String disabled();
	public String brokersOnly();
	public String bankersOnly();
	public String adminsOnly();
	public String phoneStarts();
	public String brokerProfileDetails();
	public String bankerProfileDetails();
	public String adminProfileDetails();
	public String userDetails();
	public String newUserWillBeCreated();
	public String someoneElseHaveThisPhone();
	public String someoneElseHaveThisEmail();
	public String someoneElseHaveThisExternalId();
	public String someoneElseHaveThisMidasId();
	public String someoneElseBankerHaveThisUser();
	public String someoneElseBrokerHaveThisUser();
	public String thisEstateIsRegistered();
	// TIP
	public String homeShowTipsTodo(); 
	public String homeHideTipsTodo();
	public String menuTip();
	public String menuTips();
	public String menuMyTips();
	public String menuTipForm();
	public String tipType();
	public String tipLoan();
	public String tipSell();
	public String tipInventory();
	public String tipDirectionType();
	public String tipDirectionBrokerToBanker();
	public String tipDirectionBankerToBroker();
	public String tipsToMe();
	public String tipsFromMe();
	public String tipStatus();
	public String tipStatusNew();
	public String tipStatusInProcess();
	public String tipStatusSucceed();
	public String tipStatusRejected();
	//Estate Status
	public String status();
	public String isReady();
	public String isForSale();
	public String isOfferReceived();
	public String isSold();
	public String isForRent();
	public String isRented();
	public String isWithdrawn();
	public String isBroken();
	
	public String active();
	public String inactive();
	public String modificationComments();
	public String modificationDate();
	public String htsCreatedBy();
	public String htsAskDate();
	public String htsAskedBy();
	public String htsAskComments();
	public String htsWantsToSell();
	public String htsRemind();
	public String htsRemindDate();
	public String htsRemindedDate();
	public String htsRremindedBy();
	public String htsRemindComments();
	public String enterPhone();
	public String lookupBanker();
	public String lookupBroker();
	public String lookupClient();
	public String lookupEstate();
	public String showOnlyActiveEstate();
	public String synchronize();
	public String iNeedToAskClients();
	public String partnersNeedToAskClients();
	public String isPlaningToGo();
	public String isWasOnViewing();
	public String isWasNotOnViewing();
	public String futureViewings();
	public String pastViewings();
	public String totalClients();
	public String unfinalyzed();
	public String unfinalyzedViewings();
	public String clientVisitPlanner();
	public String menuHts();
	public String menuMyHts();
	public String menuHtsForm();
	public String processed();
	public String toBeDone();
	public String wantToSell();
	public String wantToSellShort();
	public String menuMailTemplates();
	public String brokerWelcomeMailTemplate();
	public String bankerWelcomeMailTemplate();
}
