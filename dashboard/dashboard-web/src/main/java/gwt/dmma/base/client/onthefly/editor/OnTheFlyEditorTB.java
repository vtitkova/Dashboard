package gwt.dmma.base.client.onthefly.editor;

import gwt.dmma.base.client.onthefly.footer.OnTheFlyFooterDisplay;
import gwt.dmma.base.client.onthefly.footer.OnTheFlyFooterView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;

public class OnTheFlyEditorTB extends Composite implements EditorViewDisplay{
	private final FlowPanel content;
	private final OnTheFlyFooterDisplay footer;
	private final TextBox texBox;
	private final boolean flyControls;
	private PopupPanel popupFooterPanel;

	public OnTheFlyEditorTB(boolean flyControls) {
		this.flyControls = flyControls;
		content = new FlowPanel();
		texBox = new TextBox();
		texBox.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent arg0) {
				// TODO arg0.getNativeKeyCode() == 13  ????
				if(arg0.getNativeKeyCode() == 13 && listener!=null){
					listener.onSaveEvent();
				}else if(arg0.getNativeKeyCode() == 27 && listener!=null)
					listener.onCancelEvent();
			}
		});

		texBox.setStyleName("OTFEditorWidget OTFTextBoxWidget");
		footer = new OnTheFlyFooterView();
		footer.getSaveButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				if(listener!=null)
					listener.onSaveEvent();
			}
		});
		footer.getCancelButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				if(listener!=null)
					listener.onCancelEvent();
			}
		});
		
		FlowPanel fp = new FlowPanel();
		fp.add(texBox);
		fp.setStyleName("OTFEditorViewDisplay");
		content.add(fp);
		if(!this.flyControls)
			content.add(footer.asWidget());
		else{
			popupFooterPanel = new PopupPanel();
			popupFooterPanel.setAutoHideEnabled(false);
			popupFooterPanel.add(footer.asWidget());
		}
		this.initWidget(content);
	}

	@Override
	public void setTex(String text) {
		texBox.setText(text);
	}


	@Override
	public String getText() {
		return texBox.getText();
	}


	@Override
	public void setFocused() {
		texBox.setFocus(true);
	}

	@Override
	public void onShow() {
		if(this.flyControls)
			popupFooterPanel.showRelativeTo(content);
	}

	@Override
	public void onHide() {
		if(this.flyControls)
			popupFooterPanel.hide();
	}

	private EditorViewListener listener;
	@Override
	public void setListener(EditorViewListener listener) {
		this.listener = listener;

	}



}
