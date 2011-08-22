MIDAS lookup service 
http://data.emprof.no/wsData01.asmx
563433E3-ECBB-4B72-906A-EBEF44F82A7D


http://help.github.com/win-set-up-git/


Zapros Brokerov
http://data.emprof.no/wsData01.asmx?op=GetBroker


11
	12660 - ole@em1hallingdal.no       412786, 477915
	94064 - jorgen@em1hallingdal.no
	96376 - ingvild@em1hallingdal.no
12
	12652 - helle@em1hadeland.no
	12653 - lene@em1hadeland.no
	96946 - hilde@em1hadeland.no
	
577
	morten.normann@em1mn.no	
	
	
	454012 estate i dohrena viewing
	

1. PROJECT STRUCTURE
Downloaded project should have next structure.
 
BrokerDashboard
 |--docs               -folder for project documentation     
 |--dashboard          -folder for project modules
 |   |--dashboard-web  -folder for web project source code (see below)
 |   `--pom.xml        -parent POM file (define all required dependencies, parameters and repositories for project)
 `--workspace          -setup Eclipse WorkSpace in this folder. (probably this folder will not exist)


dashboard-web
 |--src
 |   |--main
 |   |   |--java           -java files 
 |   |   `--resources      -project configuration and properties files
 |   `--test
 |       |--java
 |       `--resources
 |--war
 |   |--css                -project CSS styles
 |   |--img                -images and icons 
 |   |--META-INF
 |   |--WEB-INF            -jsp pages, web.xml, spring dispatcher configuration xml
 |   `--favicon.ico      
 |--pom.xml
 `--README.txt             - this file :) -short explanation about project. 
 

2. RUN PROJECT FROM MAVEN PLUGIN
	a. clean the project 
	   $>mvn clean
	b. run a GWT module in the GWT Hosted mode 
	   $>mvn gwt:run

3. IMPORT PROJECT TO ECLIPSE
	*. insure that your Eclipse have installed GWT plugin and SDK 
	   for more information see ECLIPSE PreSetup steps.
	a. clean the project 
	   $>mvn clean
	b. create eclipse project configurration
	   $>mvn eclipse:eclipse
	c. lunch eclipse and select BrokerDashboard\workspace directory as workspace.
	d. register M2_REPO variable (if required)
	   Window->Preferences->Java->Build Path->Classpath Variables->New..
	   Name: M2_REPO
	   Path: "path to local maven repository" 
	   ................. example .........................................................
	   like  M2_REPO = C:/Program Files/Apache Software Foundation/apache-maven-2.2.1/repo 
	   or    M2_REPO = D:\.m2\repository
	   ...................................................................................
	e. import project into Eclipse: 
       File->Import...->Existing Project into Workspace-> ${basedir}/dashboard-web 
    f. use google web toolkit
	   Project->Properties->Google->Web Tolkit->Use Google web tolkit
	   *** if you will have error like 
	   *** The project 'XXX' does not have any GWT SDK's on its build path 
	   *** GWT SDK library must appear before the Maven dependencies in the "Order and Export" tab.
	   
    g. create run configuration
	   Run->Run Configurations...->Web Application
		
		Project:    dashboard-web
		Main Class: com.google.gwt.dev.DevMode
		Program arguments:
		

		
		-remoteUI "${gwt_remote_ui_server_port}:${unique_id}" 
		-logLevel INFO 
		-codeServerPort 9997 
		-port 8888 
		-startupUrl broker.do 
		-war D:\WS\BrokerDashboard\dashboard\dashboard-web\war 
		com.dmma.dashboard.gwt.banker.Banker 
		com.dmma.dashboard.gwt.admin.Admin 
		com.dmma.dashboard.gwt.broker.Broker
		
		
     * note: add binde address if required to run configuration  
         -bindAddress 0.0.0.0 
       

4. CREATE WAR INSTALATION
	a. run comand to create deliverable war file
	   $>mvn clean install
	WAR file will be created under ${basedir}/dashboard-web/targer/Dashboard.war


ECLIPSE PreSetup steps
	a. install plugin for eclipse
	Help->Install New Software...   http://dl.google.com/eclipse/plugin/3.6
	I would recomend install only plugin and MANUALY download GWT 2.0.4 SDK, unzip it into folder.

NOTES: 
  Somtimes it is required to convert project to Faceted Form, to do this do
	Project->Properties->Project Facets->Convert to Faceted Form->Dynamic Web Module (change to war!!!)
  Suppress warnings - add all required JAR's
	Project->Properties->Google->Web Application->Add...   select all JAR's



		
		