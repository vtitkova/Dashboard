package gwt.dmma.base.client.onthefly.flatview;

import com.google.gwt.user.client.ui.Widget;

public interface FlatViewDisplay{
	public Widget asWidget();
	public void setText(String text);

	public interface  FlatViewListener{
		public void onStartEditEvent();
	}
	public void setFlatViewListener(FlatViewListener listener);
	
	
}
