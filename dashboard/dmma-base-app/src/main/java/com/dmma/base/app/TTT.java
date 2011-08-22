package com.dmma.base.app;

import com.dmma.base.app.clazz.Currency;
import com.dmma.base.app.utils.BaseServerFormats;

public class TTT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Currency c = new Currency(new Double("10.946"));

		System.out.println(BaseServerFormats.getFormattedCurrency(c));
	}

}
