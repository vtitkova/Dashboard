package gwt.dmma.base.client.onthefly.footer;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface OnTheFlyFooterDisplay {
	public Widget asWidget();
	public HasClickHandlers getSaveButton();
	public HasClickHandlers getCancelButton();
}
