package com.automation.testsuite;

import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import resources.testdata.TestData;

public class SignInPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;

    public void setup2() {
        SoftAssert softAssert = new SoftAssert();
        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage =new CreateAccountPage();
        softAssert.assertAll();

    }
    @Test(groups = {"sanity", "regression"})
    public void userShouldNavigateToSignInPageSuccessFully(){
        SoftAssert softAssert = new SoftAssert();
        homePage.setClickOnSignInLink();
        String expectedTest= "AUTHENTICATION";
        String actualTest= signInPage.verifyAuthenticationText();
        Assert.assertEquals(expectedTest,actualTest);
        softAssert.assertAll();
    }

    @Test (dataProvider = "credentials", dataProviderClass = TestData.class ,groups = {"regression"})

    public void verifyTheErrorMessageWithInValidCredentials(String username, String password,String message) {
        SoftAssert softAssert = new SoftAssert();
        homePage.setClickOnSignInLink();
        signInPage.signInWithUserNameAndPassword(username, password);
        String expectedTest = message;
        String actualTest = signInPage.getVerifyAuthenticationFailedMessage();
        Assert.assertEquals(expectedTest, actualTest);
        softAssert.assertAll();
    }
    @Test (groups = {"smoke","regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        SoftAssert softAssert = new SoftAssert();
        homePage.setClickOnSignInLink();
        signInPage.signInWithUserNameAndPassword("Umipatel@gmail.com","acd1234");
        String expectedTest = "Sign out";
        String actualTest = signInPage.verifyLogOutLink();
        Assert.assertEquals(expectedTest, actualTest);
        softAssert.assertAll();
    }
    @Test(groups = {"smoke","regression"})
    public void VerifyThatUserShouldLogOutSuccessFully(){
        SoftAssert softAssert = new SoftAssert();
        homePage.setClickOnSignInLink();
        signInPage.signInWithUserNameAndPassword("Umipatel@gmail.com","acd1234");
        signInPage.clickOnSignOut();
        String expectedTest = "Sign in";
        String actualTest = homePage.signButtonVerify();
        Assert.assertEquals(expectedTest, actualTest);
        softAssert.assertAll();
    }


}