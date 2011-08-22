package gwt.dmma.base.client.utils;


import com.dmma.base.gwt.client.event.AppEvent;
import com.dmma.base.gwt.client.handlers.GoEditClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class WidgetUtil {

	public static Widget wrapTitleValue(String valueTitle, Widget valueHolder){
		FlexTable widget = new FlexTable();
		widget.setHTML(0, 0, valueTitle);
		widget.getFlexCellFormatter().setStyleName(0,0, CssStyles.VALUE_TITLE);
		widget.setWidget(0,1, valueHolder);
		widget.getFlexCellFormatter().setStyleName(0,1, CssStyles.VALUE_HOLDER);
		return widget;
	} 
	
	public static Widget wrapTitleValue(String valueTitle, String valueHolder){
		FlexTable widget = new FlexTable();
		widget.setHTML(0, 0, valueTitle);
		widget.getFlexCellFormatter().setStyleName(0,0, CssStyles.VALUE_TITLE);
		widget.setHTML(0,1, valueHolder);
		widget.getFlexCellFormatter().setStyleName(0,1, CssStyles.VALUE_HOLDER);
		return widget;
	}

	
	/*public static Widget createEditWidget(String editPath, Integer objectId){
		Image img = new Image(BaseComposite.RES.infoSmall());
		img.setStyleName(CssStyles.ACTION_WRAP);
		img.addClickHandler(new GoEditClickHandler(editPath, objectId));
		return img;
	}*/

	public static Widget createEditWidget(ImageResource editIcon, AppEvent params){
		if(editIcon!=null){
			Image img = new Image(editIcon);
			img.setStyleName(CssStyles.ACTION_WRAP);
			img.addClickHandler(new GoEditClickHandler(params));
			return img;
		}else{
			Label l = new Label("edit");
			l.addClickHandler(new GoEditClickHandler(params));
			l.setStyleName(CssStyles.ACTION_WRAP);
			return l;
		}
	}

	
}
