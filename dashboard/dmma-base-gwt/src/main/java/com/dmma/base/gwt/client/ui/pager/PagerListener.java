package com.dmma.base.gwt.client.ui.pager;

public interface PagerListener {
	public void onItemsOnScreenChanged(Integer newValue);
	public void onPageChanged(         Integer newValue);
}
