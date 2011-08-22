package com.dmma.base.gwt.client.ui.abstracts;

import com.dmma.base.gwt.client.utils.BaseStringUtils;
import com.dmma.base.gwt.client.utils.CssStyles;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public abstract class BaseCompositeView extends BaseComposite {
	private DecoratorPanel decoratorPanel;
	private FlexTable baseCompositeViewContent;
	private Label lblTitle;
	private String title;
	private FlowPanel contentPanel;
	private FlowPanel         widthPane;

	protected FlexTable header;
	protected FlexCellFormatter cellFormatter;

	public BaseCompositeView(String title) {
		this(title, "");
	}

	public BaseCompositeView(String title, String styleName) {
		super(styleName);
		this.title = title;
		init();
	}

	protected abstract Widget createContent();
	protected abstract String getPrefferedWidth();
	
	private void init() {
		decoratorPanel = new DecoratorPanel();
		mainPanel.add(decoratorPanel);

		baseCompositeViewContent = new FlexTable();
		baseCompositeViewContent.setCellSpacing(0);
		baseCompositeViewContent.setCellPadding(0);
		baseCompositeViewContent.setWidth("100%");
		decoratorPanel.setWidget(baseCompositeViewContent);

		lblTitle = new Label();
		
		lblTitle.setText(getMyTitle());

		baseCompositeViewContent.setWidget(0, 0, lblTitle);
		FlexCellFormatter cellFormatter = baseCompositeViewContent
				.getFlexCellFormatter();
		cellFormatter.setStyleName(0, 0, CssStyles.APPLICATION_CONTENT_TITLE);
		
		widthPane = new FlowPanel();
		baseCompositeViewContent.setWidget(1, 0, widthPane);
		widthPane.setSize(getPrefferedWidth(), "0px");
		
		contentPanel = new FlowPanel();
		contentPanel.setStyleName("");
		baseCompositeViewContent.setWidget(2, 0, contentPanel);
		contentPanel.add(createContent());
	}

		
	private String getMyTitle() {
		/* Show class name tool tip in hosted mode browser */
		if (!GWT.isScript()){
			String view = BaseStringUtils.getClassShortName(this.getClass().getName());
			String presenter = view.replace("View","Presenter");
			return title+" - "+view+" "+presenter;
		}else
			return title; 
	}

	public void setTitle(String title) {
		this.title = title;
		lblTitle.setText(title);
	}

	@Override
	public void add(Widget widget) {
		super.add(widget);
	}

	
	public void setMyWidth(String width){
		widthPane.setWidth(width);
	}
	
	

}
