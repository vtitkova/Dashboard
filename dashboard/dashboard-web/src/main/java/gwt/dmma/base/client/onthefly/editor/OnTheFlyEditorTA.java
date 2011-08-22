package gwt.dmma.base.client.onthefly.editor;

import gwt.dmma.base.client.onthefly.footer.OnTheFlyFooterDisplay;
import gwt.dmma.base.client.onthefly.footer.OnTheFlyFooterView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextArea;

public class OnTheFlyEditorTA extends Composite implements EditorViewDisplay{
	private final FlowPanel content;
	private final OnTheFlyFooterDisplay footer;
	private final TextArea texBox;
	private final boolean flyControls;
	private PopupPanel popupFooterPanel;
	
	public OnTheFlyEditorTA(boolean flyControls) {
		this.flyControls = flyControls;
		content = new FlowPanel();
		
		texBox = new TextArea();
		texBox.addKeyUpHandler(new KeyUpHandler() {
			@Override
			public void onKeyUp(KeyUpEvent arg0) {
				if(arg0.getNativeKeyCode() == 27 && listener!=null){
					listener.onCancelEvent();
					return;
				}
				Integer i = 	texBox.getElement().getScrollHeight();
				//System.out.println(i);
				texBox.setHeight(i+"px");
				repositionFooter();
				
			}
		});
		/*texBox.addFocusListener(new FocusListener() {
			@Override
			public void onLostFocus(Widget arg0) {
				if(listener!=null)
					listener.onCancelEvent();
			}

			@Override
			public void onFocus(Widget arg0) {
			}
		});*/
		
		
		texBox.setStyleName("OTFEditorWidget OTFTextAreaWidget");
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
		texBox.setText(cleanHTML(text));
	}
	
	
	@Override
	public String getText() {
		return convertArrayToHTMLString(getTexts());
	}
	
	public List<String> getTexts() {
		return convertTextToList(texBox.getText().trim());
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
	
	private void repositionFooter() {
		if(this.flyControls)
			popupFooterPanel.showRelativeTo(content);
	}
	

	@Override
	public void onHide() {
		if(this.flyControls)
			popupFooterPanel.hide();
	}
	
	public static String newLineTag = "<br>";
	public static String convertArrayToHTMLString(List<String> texts){
		if(texts == null || texts.isEmpty()) return "";
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < texts.size(); i++){
			sb.append(texts.get(i));
			if(i<texts.size()-1 ){
				sb.append(newLineTag);
			}
		}
		return sb.toString();
	}
	
	public static String cleanHTML(String text){
		if(text == null)
			text = "";
		String retVal = text.replace(newLineTag, "\r\n");
		return retVal;
	}
	
	public static ArrayList<String> convertTextToList(String textsFromTA){
		if (textsFromTA ==null || "".equals(textsFromTA)) return null;
		// split only on "\n" and remove any \r we might have (on IE)
		List<String> split = Arrays.asList(textsFromTA.split("\n"));
		ArrayList<String> cleaned = new ArrayList<String>();
		for (String string : split) {
			cleaned.add(string.trim());
		}
		return cleaned;
	}
	
	private EditorViewListener listener;
	@Override
	public void setListener(EditorViewListener listener) {
		this.listener = listener;
		
	}
}
