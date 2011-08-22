package com.dmma.base.gwt.client.css;

import com.google.gwt.resources.client.CssResource;


/**
 * Base Css styles for DiM's fraamework
 * 
 * IMPORTANT: there is an GWT's issue:
 * Issue 6022: 	ui:style relative source references throw errors during compilation 
 * Description: Using a relative path for a ui:style src reference in a project that is exported to a jar
 *              and used in a second project causes a GWT compilation error that it's unable to find definitions.css.
 * 
 * To avoid that, I'm still continue using relative paths, like 
 *				 <ui:style type='com.dmma.base.gwt.client.css.BaseCss' src='../../../css/MailCss.css' />
 * But, you need to coppy MailCss.css file into your project final web-app.
 * And in your Module.gwt.xml, add:
 * 	<source path="../../base/gwt/client"/>
 * 
 * 
 * 
 * */
public interface BaseCss extends CssResource{
	public String dialogImage();
	public String dialogVPanel();

	public String baseLoadingPopup();
	public String baseLoadingImage();
	public String baseLoadingCaption();
	public String baseLoadingMsg();
	
	public String autoMargin();
	
	public String tableHeader();

}