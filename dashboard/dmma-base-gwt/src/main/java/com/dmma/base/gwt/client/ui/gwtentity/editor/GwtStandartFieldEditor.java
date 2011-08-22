package com.dmma.base.gwt.client.ui.gwtentity.editor;

import com.dmma.base.gwt.client.ui.gwtentity.column.GwtColumnMetadata;
import com.dmma.base.gwt.client.utils.CssStyles;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class GwtStandartFieldEditor extends Composite implements DmEditorInterface{
	private GwtColumnMetadata columnMeta;
	
	
	private Label    label; 
	private TextBox  textBox; 
	private CheckBox checkBox; 
	
	
	public GwtStandartFieldEditor(GwtColumnMetadata md) {
		this.columnMeta = md;
		init();
	}


	private void init() {
		if(columnMeta.editable){
			if(columnMeta.clazz.equals(Boolean.class)){
				checkBox = new CheckBox();
				initWidget(checkBox);
			}else{
				textBox = new TextBox();
				initWidget(textBox);
			}
		}else{
			label = new Label();
			label.setStyleName(CssStyles.DATA_DATA);
			initWidget(label);
		}
	}

	public void setValue(Object data) {
		if(columnMeta.editable){
			if(columnMeta.clazz.equals(Boolean.class)){
				Boolean bVal = (Boolean)data;
				if(bVal!=null)
					checkBox.setValue(bVal);
				else
					checkBox.setValue(false);
			}else{
				if(data!=null)
					textBox.setValue( ""+data);
				else
					textBox.setValue("");
			}
		}else{
			if(data!=null)
				label.setText(""+data);
			else
				label.setText("");
		}
	}


	/**if not editable then I will never ask */
	public Object getValue() {
		// esli 4toto slu4itjsja vernjom null :)
		try{
			if(columnMeta.clazz.equals(Boolean.class)){
				return checkBox.getValue();
			}else if (columnMeta.clazz.equals(Double.class)){
				return new Double(textBox.getText().replace(",", "."));
			}else if (columnMeta.clazz.equals(Long.class)){
				return new Long(textBox.getText());
			}else if (columnMeta.clazz.equals(Integer.class)){
				return new Integer(textBox.getText());
			}else{
				return textBox.getValue();
			}
		}catch(Exception e){
			return null;
		}
	}


	@Override
	public Widget asWidget() {
		return this;
	}
	
	
	
	
}
