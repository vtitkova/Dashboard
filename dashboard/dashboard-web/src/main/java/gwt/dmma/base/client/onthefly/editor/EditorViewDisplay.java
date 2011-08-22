package gwt.dmma.base.client.onthefly.editor;

import com.google.gwt.user.client.ui.Widget;

public interface EditorViewDisplay {
	public Widget asWidget();
	public void setTex(String text);
	public String getText();
	public void setFocused();
	public void onShow();
	public void onHide();
	
	public interface EditorViewListener{
		public void onSaveEvent();
		public void onCancelEvent();
	}
	public void setListener(EditorViewListener listener);
	

	
	
}
