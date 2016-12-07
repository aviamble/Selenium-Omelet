package com.ebay.tests;

import java.io.IOException;

import omelet.data.IProperty;
import omelet.data.driverconf.IBrowserConf;
import omelet.testng.support.SAssert;

import org.testng.annotations.Test;
import com.ebay.webpages.PageObjectFactory;

public class LogInTest {
	SAssert sAssert =new SAssert();

	@Test(dataProvider="XmlData")
	public void verifyInvalidLogin(IBrowserConf browserConf, IProperty prop) throws IOException
	{
		PageObjectFactory prof=new PageObjectFactory(browserConf,prop);
		sAssert.assertTrue(prof.homePage().loadUrl(prop.getValue("HomePage_url")),"Access URL"+prop.getValue("HomePage_url"));
		sAssert.assertTrue(prof.homePage().clickOnSignIn(),"Click on Sign In link");
		sAssert.assertTrue(prof.loginPage().loginAs(prop.getValue("LoginPage_userid"), prop.getValue("LoginPage_password")),"Login as");
		sAssert.assertEquals(prof.loginPage().getErrorMessage(), prop.getValue("LoginPage_errormessage"), "Verify Error message");
	}
	
}
