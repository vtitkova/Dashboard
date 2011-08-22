package gwt.dmma.base.client.onthefly;

import gwt.dmma.base.client.onthefly.core.OnTheFlyEditor;
import gwt.dmma.base.client.onthefly.editor.OnTheFlyEditorTA;
import gwt.dmma.base.client.onthefly.flatview.FlatViewHTML;

import java.util.List;

public class OnTheFlyEditorForTA extends OnTheFlyEditor<FlatViewHTML, OnTheFlyEditorTA>{
	
	
	public OnTheFlyEditorForTA(){
		super(new FlatViewHTML(), new OnTheFlyEditorTA(true));
	}
	
	
	public void setTexts(List<String> texts){
		setText(OnTheFlyEditorTA.convertArrayToHTMLString(texts));
	}
	
	public List<String> getTexts(){
		return editorDisplay.getTexts();
	}
	
	
}
