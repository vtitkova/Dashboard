/*package com.dmma.dashboard.midas;


public class MidasClientTest {
	private MidasClient midasClient;
	
	public MidasClientTest() {
		midasClient = new MidasClient();
	}
	
	//TODO try to find normal tests
	
	@Test
	public void testGetBroker(){
		Broker b = midasClient.getBroker(new Long("12660"));
		assertNotNull(b);
	}
	
	@Test
	public void testGetMidasBrokerIDsByOffice(){
		Set<Long> set = midasClient.getMidasBrokerIDsByOffice(new Long("11"));
		assertNotNull(set);
	}
	
	@Test
	public void testGetOffice(){
		BrokerOffice o = midasClient.getOffice(new Long("11"));
		assertNotNull(o);
	}
	
	@Test
	public void testGetBrokerWithOffice(){
		Broker b2 = null;
		try {
			b2 = midasClient.getBrokerWithOffice(new Long("96376"), new Long("11"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (NoSuchBrokerFound e) {
			e.printStackTrace();
		} catch (NoSuchOfficeFound e) {
			e.printStackTrace();
		} catch (NoSuchBrokerInOffice e) {
			e.printStackTrace();
		}
		assertNotNull(b2);
	}
	
	@Test
	public void testGetEstateByMidasId(){
		Estate e = null;
		try {
			e = midasClient.getEstate(new Long("412786"), new Long("12660") );
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (ThatIsNotYourEstate e1) {
			e1.printStackTrace();
		} catch (NoSuchEstate e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	
}
*/