/**
 * WsData01Soap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.dmma.dashboard.midas.axisclient;

public interface WsData01Soap_PortType extends java.rmi.Remote {

    /**
     * Alle eiendommer for
     * 				en base
     */
    public com.dmma.dashboard.midas.axisclient.BasePropertyResponseBasePropertyResult baseProperty(java.lang.String sIdentityKey, java.lang.String sAccesskey, java.lang.String sBroker) throws java.rmi.RemoteException;

    /**
     * Leverer full
     * 				størrelse bilder til et enkelt oppdrag.
     */
    public com.dmma.dashboard.midas.axisclient.GetPicturesResponseGetPicturesResult getPictures(java.lang.String sIdentityKey, java.lang.String sAccessKey, long nProspectId) throws java.rmi.RemoteException;

    /**
     * Leverer bilder i
     * 				valgfri størrelse til et enkelt oppdrag.
     */
    public com.dmma.dashboard.midas.axisclient.GetScaledPicturesResponseGetScaledPicturesResult getScaledPictures(java.lang.String sIdentityKey, java.lang.String sAccessKey, long nProspectId, int nSize) throws java.rmi.RemoteException;

    /**
     * Antall eiendommer
     * 				for en kjede
     */
    public int propertyCount(java.lang.String sIdentityKey) throws java.rmi.RemoteException;

    /**
     * Antall endrede
     * 				eiendommer for en kjede
     */
    public int changedCount(java.lang.String sIdentityKey) throws java.rmi.RemoteException;

    /**
     * Adder teller
     */
    public boolean addCounter(java.lang.String sIdentityKey, java.lang.String pID, int pCounterType) throws java.rmi.RemoteException;

    /**
     * Test av søk
     * 				eiendommer
     */
    public com.dmma.dashboard.midas.axisclient.SearchTestManualResponseSearchTestManualResult searchTestManual(java.lang.String sIdentityKey, java.lang.String n1, java.lang.String v1, java.lang.String n2, java.lang.String v2, java.lang.String n3, java.lang.String v3) throws java.rmi.RemoteException;

    /**
     * Test av søk
     * 				eiendommer
     */
    public com.dmma.dashboard.midas.axisclient.SearchTestResponseSearchTestResult searchTest(java.lang.String sIdentityKey, java.lang.String pLocation, java.lang.String pOwnType, java.lang.String pPropertyType, java.lang.String pSaleRent, java.lang.String pPriceFrom, java.lang.String pPriceTo, java.lang.String pPropertySize, java.lang.String pLotSize, java.lang.String pBedRooms, java.lang.String pSearchText, java.lang.String pShowSold, java.lang.String pShowShows, java.lang.String pShowComing, java.lang.String pOffice, java.lang.String pQueryID, java.lang.String pUserID, java.lang.String pFK) throws java.rmi.RemoteException;

    /**
     * Test av lagre søk
     */
    public boolean saveSearchTest(java.lang.String sIdentityKey, java.lang.String pUserKey, java.lang.String pQueryName, int pAlertMail, int pAlertSMS, java.lang.String pLocation, java.lang.String pOwnType, java.lang.String pPropertyType, java.lang.String pSaleRent, java.lang.String pPriceFrom, java.lang.String pPriceTo, java.lang.String pPropertySize, java.lang.String pLotSize, java.lang.String pBedRooms, java.lang.String pSearchText, java.lang.String pShowSold, java.lang.String pShowShows, java.lang.String pShowComing, java.lang.String pOffice) throws java.rmi.RemoteException;

    /**
     * Seneste eiendommer
     * 				- input Antall og kontorID (kommaseparert ved flere kontor)
     */
    public com.dmma.dashboard.midas.axisclient.NewsTypeResponseNewsTypeResult newsType(java.lang.String sIdentityKey, java.lang.String estateTypes, java.lang.String count, java.lang.String offices) throws java.rmi.RemoteException;

    /**
     * Seneste eiendommer
     * 				- input Antall, typer (kommaseparert), kontorID (kommaseparert
     * ved
     * 				flere kontor), Antal Dager siden publisert/endret, 0 for publisert/1
     * 				for endret
     */
    public com.dmma.dashboard.midas.axisclient.NewsTypeDaysResponseNewsTypeDaysResult newsTypeDays(java.lang.String sIdentityKey, java.lang.String estateTypes, java.lang.String count, java.lang.String offices, int days, int sortType) throws java.rmi.RemoteException;

    /**
     * Seneste eiendommer
     * 				- input Antall og kontorID (kommaseparert ved flere kontor)
     */
    public com.dmma.dashboard.midas.axisclient.NewsResponseNewsResult news(java.lang.String sIdentityKey, java.lang.String count, java.lang.String offices) throws java.rmi.RemoteException;

    /**
     * Et anntall
     * 				tilfeldige eiendommer
     */
    public com.dmma.dashboard.midas.axisclient.NewsRandomResponseNewsRandomResult newsRandom(java.lang.String sIdentityKey, java.lang.String count, java.lang.String offices) throws java.rmi.RemoteException;

    /**
     * Søk eiendommer -
     * 				input kriterier som string array parvis navn/verdi
     */
    public com.dmma.dashboard.midas.axisclient.SearchResponseSearchResult search(java.lang.String sIdentityKey, com.dmma.dashboard.midas.axisclient.ArrayOfStParam params) throws java.rmi.RemoteException;

    /**
     * Søk endrede
     * 				eiendommer - input antall minutter
     */
    public com.dmma.dashboard.midas.axisclient.GetChangedResponseGetChangedResult getChanged(java.lang.String sIdentityKey, int iMinutes) throws java.rmi.RemoteException;

    /**
     * Søk endrede
     * 				eiendommer - input antall minutter
     */
    public com.dmma.dashboard.midas.axisclient.GetChangedBaseResponseGetChangedBaseResult getChangedBase(java.lang.String sIdentityKey, java.lang.String sAccessKey, int iMinutes) throws java.rmi.RemoteException;

    /**
     * Søk solgte
     * 				eiendommer - input antall dager
     */
    public com.dmma.dashboard.midas.axisclient.GetSoldResponseGetSoldResult getSold(java.lang.String sIdentityKey, int iDays) throws java.rmi.RemoteException;

    /**
     * Returnerer website
     * 				innstillinger
     */
    public com.dmma.dashboard.midas.axisclient.GetSiteSettingsResponseGetSiteSettingsResult getSiteSettings(java.lang.String sIdentityKey) throws java.rmi.RemoteException;

    /**
     * Lagre søk - input
     * 				kriterier som string array parvis navn/verdi
     */
    public boolean saveSearch(java.lang.String sIdentityKey, java.lang.String sUserKey, java.lang.String sQueryName, int bAlertMail, int bAlertSMS, com.dmma.dashboard.midas.axisclient.ArrayOfStParam params) throws java.rmi.RemoteException;

    /**
     * Leverer xml dataset
     * 				for et enkelt oppdrag. Input IdentityKey og ProspektId
     */
    public com.dmma.dashboard.midas.axisclient.GetProspectDataDSResponseGetProspectDataDSResult getProspectDataDS(java.lang.String sIdentityKey, java.lang.String sAccessKey, long nProspectId) throws java.rmi.RemoteException;

    /**
     * Leverer xml streng
     * 				for et enkelt oppdrag.
     */
    public java.lang.String getProspectDataXML(java.lang.String sIdentityKey, java.lang.String sAccessKey, long nProspectId) throws java.rmi.RemoteException;

    /**
     * Returnerer verdien
     * 				Test som string. Kun for test av forbindelse
     */
    public java.lang.String testFunction() throws java.rmi.RemoteException;

    /**
     * Bruker login
     */
    public java.lang.String userLogin(java.lang.String sIdentityKey, java.lang.String sAccessKey, java.lang.String userName, java.lang.String password) throws java.rmi.RemoteException;

    /**
     * Mobil telefon
     * 				kontroll Step 1
     */
    public boolean userCellphoneControl_1(java.lang.String sIdentityKey, java.lang.String sAccessKey, java.lang.String userID, java.lang.String phoneNo) throws java.rmi.RemoteException;

    /**
     * Mobil telefon
     * 				kontroll Step 2
     */
    public boolean userCellphoneControl_2(java.lang.String sIdentityKey, java.lang.String sAccessKey, java.lang.String userID, java.lang.String cellCode) throws java.rmi.RemoteException;

    /**
     * Bruker data
     */
    public com.dmma.dashboard.midas.axisclient.UserGetDataResponseUserGetDataResult userGetData(java.lang.String sIdentityKey, java.lang.String sAccessKey, java.lang.String userID) throws java.rmi.RemoteException;

    /**
     * Innhold boligagent
     */
    public com.dmma.dashboard.midas.axisclient.AgentDataResponseAgentDataResult agentData(java.lang.String sIdentityKey, java.lang.String sAccessKey, java.lang.String sUserKey) throws java.rmi.RemoteException;

    /**
     * Hente lagret søk
     */
    public com.dmma.dashboard.midas.axisclient.AgentGetQueryResponseAgentGetQueryResult agentGetQuery(java.lang.String sIdentityKey, java.lang.String sUserKey, int iQueryID) throws java.rmi.RemoteException;

    /**
     * Oppdater søk
     */
    public int agentQueryUpdate(java.lang.String sIdentityKey, java.lang.String sAccessKey, java.lang.String sUserKey, int iQueryID, java.lang.String sQueryName, boolean bAlertSMS, boolean bAlertMail) throws java.rmi.RemoteException;

    /**
     * Registrer interesse
     */
    public boolean agentInteress_v2(java.lang.String sIdentityKey, java.lang.String sAccessKey, java.lang.String sUserKey, int nProspectID, int nLevel, java.lang.String sName, java.lang.String sComment) throws java.rmi.RemoteException;

    /**
     * Registrer interesse
     */
    public boolean agentInteress(java.lang.String sIdentityKey, java.lang.String sAccessKey, java.lang.String sUserKey, int nProspectID, int nLevel) throws java.rmi.RemoteException;

    /**
     * Visninger
     */
    public boolean agentView(java.lang.String sIdentityKey, java.lang.String sAccessKey, java.lang.String sUserKey, int nShowID, boolean bCancel) throws java.rmi.RemoteException;

    /**
     * Endre passord
     */
    public int userPassword(java.lang.String sIdentityKey, java.lang.String sAccessKey, java.lang.String sUserKey, java.lang.String sOldPassword, java.lang.String sNewPassword) throws java.rmi.RemoteException;

    /**
     * Send passord
     */
    public boolean userSendPassword(java.lang.String sIdentityKey, java.lang.String sAccessKey, java.lang.String sEMail) throws java.rmi.RemoteException;

    /**
     * Meglermelding
     */
    public boolean brokerMsg(java.lang.String sIdentityKey, java.lang.String sAccessKey, com.dmma.dashboard.midas.axisclient.BrokerMsgDsInfo dsInfo) throws java.rmi.RemoteException;

    /**
     * Bruker registrering
     */
    public int userRegistration(java.lang.String sIdentityKey, java.lang.String sAccessKey, java.lang.String sFirstName, java.lang.String sLastName, java.lang.String sEMail, java.lang.String sCellPhone, java.lang.String sAdress, java.lang.String sAdress2, java.lang.String sZipCode, java.lang.String sCity, java.lang.String sPrivatePhone, java.lang.String sJobPhone, java.lang.String sFax) throws java.rmi.RemoteException;

    /**
     * Bruker registrering
     */
    public int agentSaveUser(java.lang.String sIdentityKey, java.lang.String sAccessKey, java.lang.String userID, java.lang.String sFirstName, java.lang.String sLastName, java.lang.String sCellPhone, java.lang.String sAdress, java.lang.String sAdress2, java.lang.String sZipCode, java.lang.String sCity, java.lang.String sPrivatePhone, java.lang.String sJobPhone, java.lang.String sFax, boolean cellAlerts) throws java.rmi.RemoteException;

    /**
     * Slett søk
     */
    public boolean clearSearch(java.lang.String sIdentityKey, java.lang.String sUserKey, int iQueryID) throws java.rmi.RemoteException;

    /**
     * Upload url til fil
     * 				som skal lastes ned
     */
    public boolean uploadURL(int iRef, java.lang.String sOppdrag, java.lang.String sURL) throws java.rmi.RemoteException;

    /**
     * Temporær metode for
     * 				kobling mellom baseident og oppdragsnr
     */
    public long tempLinkID(java.lang.String sIdentityKey, java.lang.String sBaseIdent, java.lang.String sPropertyNo) throws java.rmi.RemoteException;

    /**
     * Søkekontroller og
     * 				verdier til disse
     */
    public com.dmma.dashboard.midas.axisclient.GetControlsResponseGetControlsResult getControls(java.lang.String sIdentityKey) throws java.rmi.RemoteException;

    /**
     * Aktive bud
     */
    public com.dmma.dashboard.midas.axisclient.GetActiveBidResponseGetActiveBidResult getActiveBid(java.lang.String sIdentityKey) throws java.rmi.RemoteException;

    /**
     * Selger informasjon
     */
    public com.dmma.dashboard.midas.axisclient.MyPropertyResponseMyPropertyResult myProperty(java.lang.String sIdentityKey, java.lang.String sUserID) throws java.rmi.RemoteException;

    /**
     * Alle kontorer i en
     * 				kjede
     */
    public com.dmma.dashboard.midas.axisclient.GetChainOfficesResponseGetChainOfficesResult getChainOffices(java.lang.String sIdentityKey, java.lang.String sAccessKey) throws java.rmi.RemoteException;

    /**
     * Alle kontorer i en
     * 				region
     */
    public com.dmma.dashboard.midas.axisclient.GetBaseOfficesResponseGetBaseOfficesResult getBaseOffices(java.lang.String sIdentityKey, java.lang.String sAccessKey) throws java.rmi.RemoteException;

    /**
     * Megler informasjon
     */
    public com.dmma.dashboard.midas.axisclient.GetBrokerResponseGetBrokerResult getBroker(java.lang.String sIdentityKey, java.lang.String officeID, java.lang.String brokerID) throws java.rmi.RemoteException;

    /**
     * Megler informasjon
     * 				med bilde
     */
    public com.dmma.dashboard.midas.axisclient.GetBrokerPResponseGetBrokerPResult getBrokerP(java.lang.String sIdentityKey, java.lang.String officeID, java.lang.String brokerID, java.lang.String pictureSize) throws java.rmi.RemoteException;

    /**
     * Kontor informasjon
     */
    public com.dmma.dashboard.midas.axisclient.GetOfficeResponseGetOfficeResult getOffice(java.lang.String sIdentityKey, int iOfficeID) throws java.rmi.RemoteException;

    /**
     * Kontor informasjon
     */
    public com.dmma.dashboard.midas.axisclient.GetOfficePResponseGetOfficePResult getOfficeP(java.lang.String sIdentityKey, int iPID) throws java.rmi.RemoteException;

    /**
     * Wrapper for
     * 				RegisterInteress
     */
    public int wRegisterInteress(java.lang.String sIdentityKey, java.lang.String sAccessKey, long nProspectID, java.lang.String sServiceName, java.lang.String p1N, java.lang.String p1V, java.lang.String p2N, java.lang.String p2V, java.lang.String p3N, java.lang.String p3V, java.lang.String p4N, java.lang.String p4V, java.lang.String p5N, java.lang.String p5V, java.lang.String p6N, java.lang.String p6V, java.lang.String p7N, java.lang.String p7V, java.lang.String p8N, java.lang.String p8V, java.lang.String p9N, java.lang.String p9V, java.lang.String p10N, java.lang.String p10V) throws java.rmi.RemoteException;

    /**
     * Register customer
     * 				interess
     */
    public int registerInteress(java.lang.String sIdentityKey, java.lang.String sAccessKey, long nProspectID, java.lang.String sServiceName, com.dmma.dashboard.midas.axisclient.ArrayOfStParam params) throws java.rmi.RemoteException;
}
