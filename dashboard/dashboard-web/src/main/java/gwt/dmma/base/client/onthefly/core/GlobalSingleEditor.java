package gwt.dmma.base.client.onthefly.core;

public class GlobalSingleEditor {

	private static OnTheFlyEditor<?,?> currentEditor;
	
	public static void iBecomeActive(OnTheFlyEditor<?,?> onTheFlyEditor) {
		if(currentEditor != null ){
			if(currentEditor != onTheFlyEditor){
				currentEditor.doCancel();
			}
		}
		currentEditor = onTheFlyEditor;
	}
}
