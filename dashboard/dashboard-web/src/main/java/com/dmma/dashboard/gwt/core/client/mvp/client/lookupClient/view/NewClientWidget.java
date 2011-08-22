package com.dmma.dashboard.gwt.core.client.mvp.client.lookupClient.view;


import com.dmma.base.gwt.client.i18n.BaseMessages;
import com.dmma.base.gwt.client.ui.abstracts.BaseComposite;
import com.dmma.base.gwt.client.ui.gwtentity.editor.GwtEntityEditor;
import com.dmma.dashboard.gwt.core.client.meta.ClientCM;
import com.dmma.dashboard.gwt.core.shared.entities.ClientDTO;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;

public class NewClientWidget extends BaseComposite {
	private GwtEntityEditor<ClientDTO> editor;
	private Button saveAndPicUpButton;

	
	public NewClientWidget() {
		super(null);
		init();
	}
	private void init() {
		
		editor = new GwtEntityEditor<ClientDTO>(new ClientCM());
		editor.setData(new ClientDTO());
		saveAndPicUpButton = new Button(BaseMessages.MSG.saveAndPickUp());
		add(editor);
		add(saveAndPicUpButton);
	}
	
	public HasClickHandlers getSaveAndPicUpButton() {
		return saveAndPicUpButton;
	}
	public void clean() {
		editor.setData(new ClientDTO());
	}

	public ClientDTO getData() {
		return editor.getData();
	}
	
	public void setSavingInProcess() {
		saveAndPicUpButton.setEnabled(false);
	}
	
	public void setSavingFailed() {
		saveAndPicUpButton.setEnabled(true);
	}
	public void errorInPhoneField() {
		editor.setHaveErrorInField(4);
	}


}
