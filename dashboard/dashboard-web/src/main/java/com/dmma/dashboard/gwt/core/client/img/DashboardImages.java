package com.dmma.dashboard.gwt.core.client.img;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface DashboardImages extends ClientBundle {
	public static final DashboardImages  IMG = (DashboardImages)     GWT.create(DashboardImages.class);
	
	//home 
	@Source("com/dmma/dashboard/gwt/core/client/img/home.png")
	public ImageResource home();

	@Source("com/dmma/dashboard/gwt/core/client/img/prefs.gif")
	public ImageResource setup();
	
	@Source("com/dmma/dashboard/gwt/core/client/img/users.gif")
	public ImageResource users();
	
	@Source("com/dmma/dashboard/gwt/core/client/img/user_blue.gif")
	public ImageResource userBlue();
	
	@Source("com/dmma/dashboard/gwt/core/client/img/user_green.gif")
	public ImageResource userGreen();
	
	@Source("com/dmma/dashboard/gwt/core/client/img/user_folder.gif")
	public ImageResource userFolder();
	
	@Source("com/dmma/dashboard/gwt/core/client/img/graph.gif")
	public ImageResource graph();

	@Source("com/dmma/dashboard/gwt/core/client/img/editor.gif")
	public ImageResource editor();

	@Source("com/dmma/dashboard/gwt/core/client/img/arrow_left_green_22.png")
	public ImageResource arrowLeftGreen22();
	
	@Source("com/dmma/dashboard/gwt/core/client/img/arrow_right_grey_22.png")
	public ImageResource arrowRightGrey22();
	
	@Source("com/dmma/dashboard/gwt/core/client/img/arrow_up_green_22.png")
	public ImageResource arrowUpGreen22();
	
	@Source("com/dmma/dashboard/gwt/core/client/img/arrow_up_grey_22.png")
	public ImageResource arrowUpGrey22();
	
	@Source("com/dmma/dashboard/gwt/core/client/img/arrow_down_green_22.png")
	public ImageResource arrowDownGreen22();
	
	@Source("com/dmma/dashboard/gwt/core/client/img/arrow_down_grey_22.png")
	public ImageResource arrowDownGrey22();
	
	
	@Source("com/dmma/dashboard/gwt/core/client/img/arrows_left_right_22.png")
	public ImageResource arrowsLeftRight22();
	
	
	

	@Source("com/dmma/dashboard/gwt/core/client/img/synchronize_22.png")
	public ImageResource synchronize22();

	@Source("com/dmma/dashboard/gwt/core/client/img/reply_16.png")
	public ImageResource reply16();

	@Source("com/dmma/dashboard/gwt/core/client/img/not_known_16.png")
	public ImageResource notKnown16();
	
	@Source("com/dmma/dashboard/gwt/core/client/img/warning_16.png")
	public ImageResource warning16();
	
		
	@Source("com/dmma/dashboard/gwt/core/client/img/user_disabled_16.png")
	public ImageResource userDisabled16();
	
	@Source("com/dmma/dashboard/gwt/core/client/img/true_16.png")
	public ImageResource true16();
	
}
