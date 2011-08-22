package gwt.dmma.base.client.ui.table.filter;

import gwt.dmma.base.client.ui.ImageAndLabelDiv;
import gwt.dmma.base.client.utils.CssStyles;

import com.dmma.base.gwt.client.img.BaseImages;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class FilterActionTable extends Composite implements ClickHandler{
	
	private FlexTable filterActionHandler;
	private FilterActionTableListener listener;
	
	private Label openFilter; 
	private ImageAndLabelDiv applyFilter;
	private ImageAndLabelDiv removeFilter;
	
	private Boolean isFilterOpened;
	
	public FilterActionTable(FilterActionTableListener filterActionTableListener) {
		listener = filterActionTableListener;
		init();
		changeVisibility();
		initWidget(filterActionHandler);
	}

	private void init() {
		filterActionHandler = new FlexTable();
		filterActionHandler.setStyleName(CssStyles.TABLE_HEADER_FILTER_ACTIONS);
		
		isFilterOpened = false;
			
		openFilter = new Label("Open Filter");
		openFilter.addStyleName(CssStyles.ACTION_WRAP);
		openFilter.addClickHandler(this);
		filterActionHandler.setWidget(0, 0, openFilter);

		
		
		
		
		applyFilter = new ImageAndLabelDiv(new Image(BaseImages.IMG.okSmall()),"Apply Filter");
		applyFilter.addStyleName(CssStyles.ACTION_WRAP);
		applyFilter.addClickHandler(this);
		//filterActionHandler.setWidget(0, 1, new Image(BaseComposite.RES.okSmall()));
		filterActionHandler.setWidget(0, 1, applyFilter);

		removeFilter = new ImageAndLabelDiv(new Image(BaseImages.IMG.cancelSmall()), "Remove Filter");
		removeFilter.addStyleName(CssStyles.ACTION_WRAP);
		removeFilter.addClickHandler(this);
		//filterActionHandler.setWidget(0, 3, new Image(BaseComposite.RES.cancelSmall()));
		filterActionHandler.setWidget(0, 2, removeFilter);
		
	}

	@Override
	public void onClick(ClickEvent e) {
		if(listener!=null){
			if(e.getSource().equals(openFilter)){
				isFilterOpened = true;
				changeVisibility();
				listener.onOpenFilter();
				
			}else if(e.getSource().equals(applyFilter)){
				listener.onApplyFilter();

			}else if(e.getSource().equals(removeFilter)){
				isFilterOpened = false;
				changeVisibility();
				listener.onRemoveFilter();
			
			}
		}
	}
	
	private void changeVisibility(){
		openFilter.setVisible(!isFilterOpened);
		applyFilter.setVisible(isFilterOpened);
		removeFilter.setVisible(isFilterOpened);
	}
	
	
	
	
	
}
