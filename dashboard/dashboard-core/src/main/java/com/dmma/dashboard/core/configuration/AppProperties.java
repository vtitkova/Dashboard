package com.dmma.dashboard.core.configuration;

import org.constretto.ConstrettoBuilder;
import org.constretto.ConstrettoConfiguration;
import org.springframework.core.io.DefaultResourceLoader;

public class AppProperties {
	public static final ConstrettoConfiguration constrettoConfiguration;

	public static final String environment;
	public static final String midasWsUrl;
	public static final String midasWsKey;
	public static final String midasCastormappingPath;
	public static final Boolean useGwtCodeserv;
	public static final String gwtCodeserv;
	
	public static final Boolean ignoreJCaptcha;
	
	public static final Integer htsAvailableForPartnersAfterDays;
	public static final Integer htsExpiryAfterDays;
	
			
	public static final String  mailServerHost;
	public static final Integer mailServePort;
	public static final String  mailServerUser;
	public static final String  mailServerPassword;
	public static final String  mailFromEmail;
	public static final Boolean mailSendEmails;
	public static final String  mailRedirectAllTo;

	static{
		constrettoConfiguration = new ConstrettoBuilder().createPropertiesStore()
        .addResource(new DefaultResourceLoader().getResource("classpath:dashboard.properties")).done()
        .getConfiguration();
		environment            = constrettoConfiguration.evaluateToString("environment");
		midasWsUrl             = constrettoConfiguration.evaluateToString("midas.ws.url");
		midasWsKey             = constrettoConfiguration.evaluateToString("midas.ws.key");
		midasCastormappingPath = constrettoConfiguration.evaluateToString("midas.castormapping.path");
		useGwtCodeserv         = constrettoConfiguration.evaluateToBoolean("dashboard.use.gwt.codeserv");
		gwtCodeserv            = constrettoConfiguration.evaluateToString("dashboard.gwt.codeserv");
		ignoreJCaptcha         = constrettoConfiguration.evaluateToBoolean("ignoreJCaptcha");
		htsAvailableForPartnersAfterDays = constrettoConfiguration.evaluateToInt("hts.available.for.partners.after.days");
		htsExpiryAfterDays               = constrettoConfiguration.evaluateToInt("hts.expiry.after.days");
	
		mailServerHost     = constrettoConfiguration.evaluateToString("mail.server.host");
		mailServePort      = constrettoConfiguration.evaluateToInt("mail.server.port");
		mailServerUser     = constrettoConfiguration.evaluateToString("mail.server.user");
		mailServerPassword = constrettoConfiguration.evaluateToString("mail.server.password");
		mailFromEmail      = constrettoConfiguration.evaluateToString("mail.from.email");
		mailSendEmails     = constrettoConfiguration.evaluateToBoolean("mail.send.emails");
		mailRedirectAllTo  = constrettoConfiguration.evaluateToString("mail.redirect.all.to");
		//XXX set other properties
	} 
	
	public static boolean getUseGwtCodeserv(){
		if(useGwtCodeserv==null) return false;
		return useGwtCodeserv.booleanValue();
	}
	
	
}
