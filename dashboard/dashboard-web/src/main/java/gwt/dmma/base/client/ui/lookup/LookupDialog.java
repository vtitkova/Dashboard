package gwt.dmma.base.client.ui.lookup;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.ui.DialogBox;

public class LookupDialog<T extends IsSerializable> {
	private DialogBox dialog;
	private LookupPresenterAndView<T> presenterAndView;
	
	public LookupDialog(LookupPresenterAndView<T> presenterAndView) {
		this.presenterAndView = presenterAndView;
		init();
	}
	
	
	private void init(){
		dialog = new DialogBox();
		dialog.setAnimationEnabled(true);
		dialog.setGlassEnabled(true);
		dialog.setText(presenterAndView.getTitle());
		dialog.add(presenterAndView.asWidget());
	}

	public void center(){
		dialog.center();
	}
	
	public void hide(){
		dialog.hide();
	}
	
}
