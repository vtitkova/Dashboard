package gwt.dmma.base.client.ui.listBox;

import java.util.List;

import com.dmma.base.gwt.client.ui.gwtentity.GwtEntityInterface;
import com.dmma.base.gwt.client.ui.gwtentity.editor.DmEditorInterface;
import com.dmma.base.gwt.client.utils.BaseListBoxUtils;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class DmListBox<T extends GwtEntityInterface> extends Composite implements DmEditorInterface{
	private ListBox listBox;
	private boolean firstElementWillBeNull;
	private List<T> values;

	public DmListBox(boolean firstNull) {
		listBox = new ListBox();
		listBox.setWidth("200px");
		firstElementWillBeNull = firstNull;
		initWidget(listBox);
	}



	public void setItems(List<T> values ) {
		this.values = values;
		listBox.clear();
		//XXX a esli values = null ???
		if(firstElementWillBeNull)
			listBox.addItem(" - Select -", "-1");
		for(T element : this.values){
			listBox.addItem(element.toString(), element.getId().toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void setValue(Object value) {
		T someValue = (T)value;
		if(someValue==null)
			return;
		BaseListBoxUtils.setSelectedItemByValue(listBox, someValue.getId().toString());
	}



	@Override
	public Object getValue() {
		Integer integer = BaseListBoxUtils.getSelectedValueAsInteger(listBox);
		if(integer>0){
			for(T element : this.values){
				if(element.getId().equals(integer)){
					return element;
				}
			}
		}
		
		return null;
	}
	
	@Override
	public Widget asWidget() {
		return this;
	}

}
