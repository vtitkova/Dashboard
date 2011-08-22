package gwt.dmma.base.client.onthefly.core;

import gwt.dmma.base.client.onthefly.editor.EditorViewDisplay;
import gwt.dmma.base.client.onthefly.flatview.FlatViewDisplay;
import gwt.dmma.base.client.onthefly.flatview.FlatViewDisplay.FlatViewListener;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.FlowPanel;


public abstract class OnTheFlyEditor<FD extends FlatViewDisplay, ED extends EditorViewDisplay> extends FlowPanel{
	
	protected Boolean rejectChanges;
	protected final boolean oneActiveEditorPerPage;
	
	protected final FD flatViewDisplay;
	protected final ED editorDisplay;

	private Listener listener;
	
	
	protected String setedText;
	
	public interface Listener{
		public void beforeSaving(String candidateForSaving);
		public void onSave();
	}
		
	
	public OnTheFlyEditor(FD flatViewDisplay, ED editorDisplay, String text ) {
		this(flatViewDisplay, editorDisplay);
		setText(text);
	}
	
	public OnTheFlyEditor(FD flatViewDisplay, ED editorDisplay) {
		super();
		oneActiveEditorPerPage = true;
		this.setStyleName("OnTheFlyEditor");
		this.flatViewDisplay = flatViewDisplay;
		this.editorDisplay = editorDisplay;
		this.add(flatViewDisplay.asWidget());
		this.rejectChanges = false;
		init();
		
		if(!GWT.isScript()){
			this.setTitle(OnTheFlyEditor.class.getName());
		}
	}
	
	private void init() {
		flatViewDisplay.setFlatViewListener(new FlatViewListener(){
			@Override
			public void onStartEditEvent() {
				switchToEditMode();
			}
		});
		editorDisplay.setListener(new EditorViewDisplay.EditorViewListener() {
			@Override
			public void onSaveEvent() {
				OnTheFlyEditor.this.doSave();
			}
			@Override
			public void onCancelEvent() {
				OnTheFlyEditor.this.doCancel();
			}
		});
		
	}
	
	public void switchToViewMode(){
		this.clear();
		this.add(flatViewDisplay.asWidget());
		editorDisplay.onHide();
	}
	public void switchToEditMode(){
		if(oneActiveEditorPerPage){
			GlobalSingleEditor.iBecomeActive(this);
		}
		editorDisplay.setTex(setedText);
		this.clear();
		this.add(editorDisplay.asWidget());
		editorDisplay.onShow();
		editorDisplay.setFocused();
		
	}
	
	public void doCancel() {
		switchToViewMode();
	}
	
	private void doSave() {
		String text = editorDisplay.getText();
		if(listener != null){
			listener.beforeSaving(text);
		}
		if(!rejectChanges){
			setedText = text;
			flatViewDisplay.setText(setedText);
			switchToViewMode();
			if(listener != null){
				listener.onSave();
			}
		}else{
			rejectChanges = false;
		}
	}
	
	public void setRejectChanges(boolean rejectThisTime){
		rejectChanges = rejectThisTime;
	}
	
	
	public void setText(String text){
		setedText = text;
		flatViewDisplay.setText(setedText);
	}
	
	public String getText(){
		return setedText;
	}

	public void setListener(Listener listener) {
		this.listener = listener;
	}

	
	
	
}
