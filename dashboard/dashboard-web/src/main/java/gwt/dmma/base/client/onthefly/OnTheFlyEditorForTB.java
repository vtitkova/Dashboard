package gwt.dmma.base.client.onthefly;

import gwt.dmma.base.client.onthefly.core.OnTheFlyEditor;
import gwt.dmma.base.client.onthefly.editor.OnTheFlyEditorTB;
import gwt.dmma.base.client.onthefly.flatview.FlatViewHTML;

public class OnTheFlyEditorForTB extends OnTheFlyEditor<FlatViewHTML, OnTheFlyEditorTB>{
	
	
	public OnTheFlyEditorForTB(){
		super(new FlatViewHTML(), new OnTheFlyEditorTB(true));
	}
	
	
	
	
	
}
