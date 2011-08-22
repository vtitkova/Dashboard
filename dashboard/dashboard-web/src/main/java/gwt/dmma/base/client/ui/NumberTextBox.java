package gwt.dmma.base.client.ui;

import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.TextBox;

public class NumberTextBox extends TextBox implements KeyUpHandler, KeyDownHandler {
	private Integer valueBefor = 0;
	public NumberTextBox() {
		super();
		init();
	}

	private void init() {
		this.setValue("0");
		this.addKeyUpHandler(this);
		this.addKeyDownHandler(this);

	}

	@Override
	public void onKeyDown(KeyDownEvent param) {
		try{
			valueBefor = Integer.parseInt(super.getValue());
		}catch (Exception e) {
			valueBefor = 0;
		}
	}

	@Override
	public void onKeyUp(KeyUpEvent e) {
		Integer newVal;
		try{
			String nv = super.getValue();
			if(nv==null||nv.length()==0){
				newVal = 0;
				super.setValue("0");
			}else{
				newVal = Integer.parseInt(nv);
			}
		}catch (Exception ex) {
			newVal = valueBefor;
			super.setValue(newVal.toString());
		}
	}


	public Integer getValueAsInteger(){
		try{
			return  Integer.parseInt(super.getValue());
		}catch (Exception e) {
			return 0;
		}
	}
	


}
