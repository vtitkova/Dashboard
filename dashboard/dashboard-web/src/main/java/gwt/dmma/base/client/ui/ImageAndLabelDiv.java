package gwt.dmma.base.client.ui;

import gwt.dmma.base.client.utils.CssStyles;

import com.dmma.base.gwt.client.ui.abstracts.BaseComposite;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class ImageAndLabelDiv extends BaseComposite implements HasClickHandlers{
	private Image  image;
	private Label  label;
	private String text;
	private boolean enabled = true;

	
	public ImageAndLabelDiv(Image image, String text) {
		super(CssStyles.IMAGE_LABEL_DIV);
		this.image = image;
		this.text  = text;
		init();
	}
	
	private void init() {
		mainPanel.add(image);
		label = new Label();
		label.setText(text);
		mainPanel.add(label);
		sinkEvents(Event.ONCLICK);		
		//sinkEvents(Event.ONMOUSEOVER | Event.ONMOUSEOUT | Event.ONCLICK | Event.ONMOUSEDOWN | Event.ONMOUSEUP);
		
	}
  
	@Override
	public void onBrowserEvent(Event event) {
		if (enabled) {
			switch (DOM.eventGetType(event)) {
			case Event.ONCLICK:
				ClickEvent.fireNativeEvent(event, this);
				break;
			/*case Event.ONMOUSEDOWN:
				addStyleDependentName(STYLE_CLICK);
				break;
			case Event.ONMOUSEUP:
				removeStyleDependentName(STYLE_CLICK);
			case Event.ONMOUSEOUT:
				removeStyleDependentName(STYLE_MOUSEOVER);
				break;
			case Event.ONMOUSEOVER:
				addStyleDependentName(STYLE_MOUSEOVER);
				break;*/
			default:
				break;
			}
		}

	}
	
	

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return addHandler(handler, ClickEvent.getType());
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if (enabled) {
			//removeStyleDependentName(STYLE_DISABLED);
		} else {
			//addStyleDependentName(STYLE_DISABLED);
		}
	}

	
}
