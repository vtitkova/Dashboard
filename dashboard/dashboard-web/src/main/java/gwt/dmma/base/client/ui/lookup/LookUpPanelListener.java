package gwt.dmma.base.client.ui.lookup;

import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * The ... //TODO 
 */
public interface LookUpPanelListener<T extends IsSerializable>{
	/** User found object and pick it up. 
	 * */
	public void onLookUpPickUp(T object);

	/** User trying to close lookup widget.
	 * */
	public void onLookUpCanceled();

}
