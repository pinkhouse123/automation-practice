package com.automation.testsuite;

import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAccountPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    SoftAssert softAssert;
    String timeStamp ;

    public void set() {
        SoftAssert softAssert = new SoftAssert();
        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
        timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        softAssert.assertAll();
    }
    @Test (groups = {"sanity", "regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        homePage.setClickOnSignInLink();
        signInPage.setClickOnCreateAnAccount("prime1"+timeStamp+"@gmail.com");
        createAccountPage.fillPersonalInformationForm("Umi","Patel","umi123");
        createAccountPage.fillYourAddressDetails("14 Queen Road","New York","Texas","12578","United States","01458965874","01478592647","Home");
        String expectedTest= "My account";
        String actualTest= createAccountPage.verifyMyAccountText();
        Assert.assertEquals(expectedTest,actualTest);
        softAssert.assertAll();
    }


}