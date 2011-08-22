package gwt.dmma.base.client.onthefly.flatview;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;

public class FlatViewHTML extends Composite implements FlatViewDisplay{
	private HTML content;
	private FlatViewListener listener;


	public FlatViewHTML() {
		this.content = new HTML();
		content.setStyleName("OTFFlatViewDisplay");
		content.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				if(listener!=null)
					listener.onStartEditEvent();
			}
		});
		initWidget(content);
	}

	@Override
	public void setText(String text) {
		if(text == null || "".equals(text)){
			content.setHTML("&nbsp");
		}else
			content.setHTML(text);

	}

	@Override
	public void setFlatViewListener(FlatViewListener listener) {
		this.listener = listener;

	}



}
