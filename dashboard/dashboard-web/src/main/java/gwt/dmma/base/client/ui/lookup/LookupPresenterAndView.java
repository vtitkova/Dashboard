package gwt.dmma.base.client.ui.lookup;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.ui.Widget;

public interface LookupPresenterAndView<T extends IsSerializable> {
	public String getTitle();
	public Widget asWidget();
	
	public void setLookUpPanelListener(LookUpPanelListener<T> listener);
	public void setDefaultPickedUpObject(T defaultObject);
	
	
}
