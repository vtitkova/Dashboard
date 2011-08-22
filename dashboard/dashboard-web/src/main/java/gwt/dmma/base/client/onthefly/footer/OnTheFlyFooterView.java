package gwt.dmma.base.client.onthefly.footer;

import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

public class OnTheFlyFooterView extends Composite implements OnTheFlyFooterDisplay {
	interface MyUiBinder extends UiBinder<Widget, OnTheFlyFooterView> {}
	private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

	@UiField
	protected Button saveButton;
	
	@UiField
	protected HTML cancelButton;


	public OnTheFlyFooterView() {
		 initWidget(uiBinder.createAndBindUi(this));
		 init();
	}

	private void init() {
		saveButton.setText(BaseMessages.MSG.save());     
		cancelButton.setText(BaseMessages.MSG.cancel()); 
	}

	@Override
	public HasClickHandlers getSaveButton() {
		return saveButton;
	}

	@Override
	public HasClickHandlers getCancelButton() {
		return cancelButton;
	}

	
	


}
