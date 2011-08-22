package gwt.dmma.base.client.onthefly.editor;

import gwt.dmma.base.client.onthefly.footer.OnTheFlyFooterDisplay;
import gwt.dmma.base.client.onthefly.footer.OnTheFlyFooterView;

import java.util.ArrayList;

import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.dmma.base.gwt.shared.dtos.ListBoxDTO;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PopupPanel;

public class OnTheFlyEditorLB extends Composite implements EditorViewDisplay{
	private final FlowPanel content;
	private final OnTheFlyFooterDisplay footer;
	private final ListBox listBox;
	private final boolean flyControls;
	private PopupPanel popupFooterPanel;

	public OnTheFlyEditorLB(boolean flyControls) {
		this.flyControls = flyControls;
		content = new FlowPanel();
		listBox = new ListBox();
		listBox.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent arg0) {
				// TODO arg0.getNativeKeyCode() == 13  ????
				if(arg0.getNativeKeyCode() == 13 && listener!=null){
					listener.onSaveEvent();
				}else if(arg0.getNativeKeyCode() == 27 && listener!=null)
					listener.onCancelEvent();
			}
		});

		listBox.setStyleName("OTFEditorWidget OTFListBoxWidget");
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
		fp.add(listBox);
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
		BaseListBoxUtils.setSelectedItemByValue(listBox, text);
	}

	public void setValues(ArrayList<ListBoxDTO> data) {
		listBox.clear();
		BaseListBoxUtils.addItemsToLB(listBox, data);
	}

	@Override
	public String getText() {
		return BaseListBoxUtils.getSelectedValueAsString(listBox);
	}


	@Override
	public void setFocused() {
		listBox.setFocus(true);
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
