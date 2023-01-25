package com.obsqura.ProjectServiceApp;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryPageTest extends Base{
	LoginPage loginPageObj;
	HomePage homePageObj;
	InventoryPage inventoryPageObj;
	
	@Test(priority=1)
	public void verifyClickOnShow() throws IOException {
		loginPageObj=new LoginPage(driver);
		loginPageObj.loginWithValidUserNameAndPassword();
		homePageObj=new HomePage(driver);
		homePageObj.clickOnInventoryProductsMoreInfo();
		inventoryPageObj=new InventoryPage(driver);
		inventoryPageObj.clickShow();
	}
	@Test(priority=0)
	public void verifyClickOnImage() throws IOException {
		loginPageObj=new LoginPage(driver);
		loginPageObj.loginWithValidUserNameAndPassword();
		homePageObj=new HomePage(driver);
		homePageObj.clickOnInventoryProductsMoreInfo();
		inventoryPageObj=new InventoryPage(driver);
		inventoryPageObj.clickOnImage();
	}

}
