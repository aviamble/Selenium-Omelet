package com.ebay.tests;



import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;

import org.testng.annotations.Test;
import com.ebay.webpages.PageObjectFactory;

public class SearchProductTest{

	SAssert sAssert=new SAssert();
	@Test(dataProvider="XmlData", groups={"smoke"})
	public void searchProduct(IBrowserConf browserConf, IProperty prop) {
		
		PageObjectFactory prof=new PageObjectFactory(browserConf,prop);
		sAssert.assertTrue(prof.homePage().loadUrl(prop.getValue("HomePage_url")),"Access URL"+prop.getValue("HomePage_url"));
		sAssert.assertTrue(prof.homePage().searchProduct(prop.getValue("HomePage_productname")),"Searching for product. ");
		sAssert.assertTrue(prof.resultPage().clickOnAuction(),"Click on Auction ");
		sAssert.assertTrue(prof.resultPage().verifyFirstProduct(),"Verify first product ");
	}

}
