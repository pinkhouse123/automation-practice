package com.automation.testsuite;

import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.pages.WomenCategoryPage;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;

public class WomenCategoryPageTest extends TestBase {
    HomePage homePage;
    SignInPage signINPage;
    SoftAssert softAssert;
    WomenCategoryPage womenCategoryPage;

    public void setup1() {
        SoftAssert softAssert = new SoftAssert();
        homePage = new HomePage();
        signINPage = new SignInPage();
        womenCategoryPage = new WomenCategoryPage();
        softAssert.assertAll();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToWomenCategoryPageSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        homePage.setClickOnWomenLink();
        String expectedText = "WOMEN";
        String actualText = womenCategoryPage.verifyWomenText();
        Assert.assertEquals(actualText, expectedText);
        softAssert.assertAll();
    }

    @Test(dataProvider = "dataSet", dataProviderClass = TestData.class, groups = {"smoke", "regression"})
    public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty,
                                                                String size, String colour) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        homePage.setClickOnWomenLink();
        womenCategoryPage.setSelectProduct(product);
        womenCategoryPage.selectQty(qty);
        womenCategoryPage.setSelectSize(size);
        womenCategoryPage.setSelectColour(colour);
        womenCategoryPage.setAddToCartButton();
        Thread.sleep(2000);
        String expectedText = "Product successfully added to your shopping cart";
        String actualText = womenCategoryPage.setConfirmationText();
        System.out.println(actualText);
        Assert.assertEquals(actualText, expectedText);
        softAssert.assertAll();
        womenCategoryPage.setCloseWindow();
    }

}