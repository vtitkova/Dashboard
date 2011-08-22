package com.dmma.base.gwt.client.ui.gwtentity.editor;

import java.util.HashMap;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.img.BaseImages;
import com.dmma.base.gwt.client.ui.abstracts.BaseComposite;
import com.dmma.base.gwt.client.ui.dialog.AppDialog;
import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityInterface;
import com.dmma.base.gwt.client.ui.gwtentity.column.GwtColumnMetadata;
import com.dmma.base.gwt.client.ui.gwtentity.column.IGwtEntityCM;
import com.dmma.base.gwt.client.utils.CssStyles;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;

public class GwtEntityEditor<T extends GwtEntityInterface> extends BaseComposite{

	private FlexTable content;
	private T data;
	private IGwtEntityCM META;
	private Label[]            titleLabels;
	private DmEditorInterface[]    editors;
	
	private HashMap<String, DmEditorInterface> registeredEditors;
	
	public GwtEntityEditor(IGwtEntityCM META){
		super("GwtEntityEditor");
		this.META = META;
		init();
	}

	/**
	 * REMEMBER - all content will be remocved when we setting data*/
	public FlexTable getContentTable(){
		return content;
	}
	
	private void init() {
		content = new FlexTable();
		content.setStyleName("GwtEntityEditor_table");
		content.setWidget(0, 0, new Image(BaseImages.IMG.loading())); 
		this.add(content);
	}

	public void setData(T data) {
		content.removeAllRows();
		this.data = data;
		titleLabels = new Label[META.getColumnMeta().length];
		editors     = new DmEditorInterface[META.getColumnMeta().length];
		
		int columnCount = META.getColumnMeta().length;
		for(int i = 0; i < columnCount; i++){
			GwtColumnMetadata columnMetaData = META.getColumnMeta()[i];
			int row = content.getRowCount();
			Label label = new Label(columnMetaData.title);
			titleLabels[i] = label;
			label.setStyleName(CssStyles.DATA_TITLE);
			content.setWidget(row, 0, label);
			
			DmEditorInterface editor = findeEditor(columnMetaData);
			editor.setValue(data.getValueAt(i));
			content.setWidget(row, 1, editor.asWidget());
			editors[i] = editor;
		}
	}
	
	private DmEditorInterface findeEditor(GwtColumnMetadata columnMetaData){
		DmEditorInterface editor;
		if(registeredEditors!=null &&
				registeredEditors.get(columnMetaData.clazz.getName())!=null)
			editor =  registeredEditors.get(columnMetaData.clazz.getName());
		else
			editor = new GwtStandartFieldEditor(columnMetaData);
		return editor;
	}
	

	public T getData() {
		int requiredErrorsCount = 0;
		for(int i = 0; i < editors.length; i++){
			if(META.getColumnMeta()[i].editable)
				data.setValueAt(i, editors[i].getValue());
				if(META.getColumnMeta()[i].required){
					if(data.getValueAt(i)==null||data.getValueAt(i).toString().length()==0){
						titleLabels[i].addStyleName(CssStyles.fieldRequiredError);
						requiredErrorsCount++;
					}else{
						titleLabels[i].removeStyleName(CssStyles.fieldRequiredError);
					}
				}
		}
	
		if(requiredErrorsCount>0){
			AppDialog.show(BaseMessages.MSG.requiredFieldsError(), AppDialog.ERROR_MESSAGE);
			return null;
		} 
		return data;
	}

	
	public void setFieldEditor(Class<?> clazz, DmEditorInterface editorInterface) {
		// XXX think about ... nado sdelatj tak 4ton editori bili osnovani na indexe a ne na classe.
		if(registeredEditors==null)
			registeredEditors = new HashMap<String, DmEditorInterface>();
		registeredEditors.put(clazz.getName(), editorInterface);
	}

	public void setHaveErrorInField(int i){
		if(i>=0 && i < titleLabels.length)
			titleLabels[i].addStyleName(CssStyles.fieldRequiredError);
	}
	
}
