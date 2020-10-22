package com.indra.test;

import org.testng.annotations.Test;

import com.indra.test.util.DataProviderClass;

public class AirAsiaTestWithJSON {

	@Test(dataProvider = "getFlights", dataProviderClass = DataProviderClass.class)
	public void testMethod(DataProviderClass data) {

		System.out.println(data.getOrigin());
		System.out.println(data.getDestination());
	}

}
