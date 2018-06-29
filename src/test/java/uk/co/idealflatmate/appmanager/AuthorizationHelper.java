package uk.co.idealflatmate.appmanager;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationHelper {


    public void logoutFromApp() {
        $(".nav.navbar-right.nav-ihm-profile").waitUntil(visible, 4000).click();
        $(byXpath("//li/a[contains(text(), ' Log out')]")).waitUntil(visible, 4000).click();
    }

    public void goToPropertyPage() {
        if($(byXpath("//div[@class='lp-element lp-pom-root']")).is(visible)){
            $(byXpath("(//button[@class='ub-emb-close'])[1]")).waitUntil(appears, 4000).click();
            sleep(2000);
        }else {
            $(byXpath("(//a[@href='/search' and contains(text(), 'Find a room')])[2]")).waitUntil(appears, 4000).click();
        }
  //      $(byXpath("//ul[@class='nav navbar-nav navbar-right nav-aux hidden-xs hidden-sm']//a[@href='/search' and contains(text(), 'Properties')]")).click();
    }

    public void goToFMpage() {
        if($(byXpath("//div[@class='lp-element lp-pom-root']")).is(visible)){
            $(byXpath("(//button[@class='ub-emb-close'])[1]")).waitUntil(appears, 4000).click();
            sleep(2000);
        }else {
            $(byXpath("(//a[@href='/search/flatmate' and contains(text(), 'Find a flatmate')])[2]")).waitUntil(appears, 4000).click();
        }
        //      $(byXpath("//ul[@class='nav navbar-nav navbar-right nav-aux hidden-xs hidden-sm']//a[@href='/search' and contains(text(), 'Properties')]")).click();
    }


    public void setLoginAsUserWithoutPackage(String email) {
        $("#loginform-username").waitUntil(appears, 4000).click();
        $(".form-group.floating-label-group.field-loginform-username.required").waitUntil(appears, 4000);
        $("#loginform-username").shouldBe(visible);
        $("#loginform-username").setValue(email);
        sleep(2000);

    }

    public void setPassword(String password) {
        $("#loginform-password").waitUntil(visible, 4000).setValue(password).pressEnter();
        sleep(2000);
    }

    public void LoginFacebookWithActiveAccount(String email, String password) {
        $("#email").waitUntil(visible, 4000).setValue(email);
        $("#pass").waitUntil(visible, 4000).setValue(password).pressEnter();
       // $(byXpath("//button[@type='submit' and (contains(text(), 'Продолжить как Александр'))]")).waitUntil(visible, 4000).click();
    }

    public void LoginFacebookWithNewAccount(String email, String password) {
        $("#email").waitUntil(visible, 4000).setValue(email);
        $("#pass").waitUntil(visible, 4000).setValue(password).pressEnter();
       // $(byXpath("//button[@type='submit' and (contains(text(), 'Продолжить как Ronald'))]")).waitUntil(visible, 4000).click();
    }

    public void clickSignInWithFacebook() {
        $(byXpath("//*[@id=\"login-form\"]/div[1]/a")).waitUntil(visible, 4000).click();

    }
    public void clickSignInWithFacebookMatching() {
        $(byXpath("(//a[@class=\"btn btn-block btn-social btn-facebook u_m10-bottom auth-link facebook js-facebook-url\"])[1]")).waitUntil(visible, 4000).click();

    }

    public void setLoginAsUserWithPremiumFlathunterPackage(String email) {
        $("#loginform-username").waitUntil(visible, 4000).click();
        $(".form-group.floating-label-group.field-loginform-username.required").waitUntil(appears, 4000);
        $("#loginform-username").shouldBe(visible);
        $("#loginform-username").waitUntil(visible, 4000).setValue(email);
    }

    public void setLoginAsUserWithoutPackage2(AuthorizationHelper authorizationHelper) {
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage("cro.gen49@gmail.com");
    }

    public void clickSignUpButton() {
        $(".signup-modal-test").click();
    }



    public void clickSignInButton() {
        if($(byXpath("//div[@class='lp-element lp-pom-root']")).is(visible)){
            $(byXpath("(//button[@class='ub-emb-close'])[1]")).waitUntil(appears, 4000).click();
            sleep(2000);
        }else {
            $(byXpath("//li/a[contains(text(), 'Log in')]")).waitUntil(appears, 4000).click();
        }
    }

    public void clickLoginSubmitButton() {
        $(byXpath("//*[@id=\"login-form\"]/div[5]/div/button")).click();
        sleep(2000);
    }

    public void removeAccount() {
        $(byXpath("//button[@type='submit' and contains(text(), 'Delete!')]")).waitUntil(appears, 4000).click();
        confirm("Are you sure you wish to delete your account?");
    }

    public void alertAccept() {
       //Assert.assertTrue($(By.tagName("p")).isDisplayed());

       confirm("ok");
    }

    public void clickFormSignInPropertyContact() {
        $(byXpath("(//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign in')])[2]")).waitUntil(visible, 4000).click();

    }
    public void clickFormSignInFMmessage() {
        $(byXpath("(//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign in')])[3]")).waitUntil(visible, 4000).click();

    }


    public void clickSignUpButtonInForm() {
        sleep(2000);
        $(byXpath("//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign up')]")).waitUntil(appears, 6000).click();
        sleep(2000);
    }

    public void setNewLoginMail(String email) {

        $("#signup-need-email").waitUntil(visible, 6000).click();
        $("#signup-need-email").waitUntil(appears, 4000).clear();
        $("#signup-need-email").shouldBe(visible);
        $("#signup-need-email").setValue(email);
    }

    public void setNewLoginPassword(String password) {
        $("#signup-need-password").click();
        $("#signup-need-password").waitUntil(appears, 4000).clear();
        $("#signup-need-password").shouldBe(visible);
        $("#signup-need-password").setValue(password);
    }

    public void setNewLoginNameF(String nameF) {
        $("#signup-need-firstname").click();
        $("#signup-need-firstname").waitUntil(appears, 4000).clear();
        $("#signup-need-firstname").shouldBe(visible);
        $("#signup-need-firstname").setValue(nameF);
    }

    public void setNewLoginNameL(String nameL) {
        $("#signup-need-lastname").click();
        $("#signup-need-lastname").waitUntil(appears, 4000).clear();
        $("#signup-need-lastname").shouldBe(visible);
        $("#signup-need-lastname").setValue(nameL);
    }

    public void setNewLoginMailMatching(String email) {
        $("#signup-survey-email").click();
        $("#signup-survey-email").waitUntil(appears, 4000).clear();
        $("#signup-survey-email").shouldBe(visible);
        $("#signup-survey-email").setValue(email);
    }

    public void setNewLoginPasswordMatching(String password) {
        $("#signup-survey-password").click();
        $("#signup-survey-password").waitUntil(appears, 4000).clear();
        $("#signup-survey-password").shouldBe(visible);
        $("#signup-survey-password").setValue(password);
    }

    public void setNewLoginNameFMatching(String nameF) {
        $("#signup-survey-firstname").click();
        $("#signup-survey-firstname").waitUntil(appears, 4000).clear();
        $("#signup-survey-firstname").shouldBe(visible);
        $("#signup-survey-firstname").setValue(nameF);
    }

    public void setNewLoginNameLMatching(String nameL) {
        $("#signup-survey-lastname").click();
        $("#signup-survey-lastname").waitUntil(appears, 4000).clear();
        $("#signup-survey-lastname").shouldBe(visible);
        $("#signup-survey-lastname").setValue(nameL);
    }



    public void clickFormSignUp() {
        $(byXpath("(//button[@class='btn btn-primary text-uppercase'])[1]")).waitUntil(appears, 4000).click();

    }

    public void clickFormSignUpSave() {
        $(byXpath("(//button[contains(text(), 'Save & Continue')])[1]")).waitUntil(appears, 4000).click();
        sleep(2000);
    }

    public void clickCloseMoreAboutYouMatching() {
        $(byXpath("(//button[@class='btn btn-sm btn-close close'])[1]")).waitUntil(appears, 4000).click();

    }

    public void clickCloseMoreAboutYou() {
        $(byXpath("(//button[@class='btn btn-sm btn-close close'])[2]")).waitUntil(appears, 4000).click();

    }

    public void chooseAccountFromDropDownMenu() {
        $(byXpath("//span[@class='pull-left' and contains(text(), ' Account')]")).click();
    }
    public void chooseSettingsFromDashboard() {
        $(byXpath("//a[@class='btn btn-tabs ' and contains(text(), 'Settings')]")).click();
    }


    /*
    public void closeFormSignupFMPage2() {
        $(byXpath("(//h4[contains(text(), 'Sign up to find flatmates')]/preceding-sibling::button)[1]")).waitUntil(visible, 8000).click();

    }



    public void closeFormSignupFMPage() {

        if (isElementPresent(byXpath("(//h4[contains(text(), 'Sign up to find flatmates')]/preceding-sibling::button)[3])"))) {
            $(byXpath("(//h4[contains(text(), 'Sign up to find flatmates')]/preceding-sibling::button)[1]")).waitUntil(visible, 4000).click();}
    }

    public boolean isElementPresent(By xpathExpression) {
        try {
            findElement($x(String.valueOf(xpathExpression)));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private void findElement(SelenideElement selenideElement) {

    }

    public void clickPage2() {

    $(byXpath("//ul[@class='pagination']//a[contains(text(), '2')]")).waitUntil(visible, 4000).click();

    }
    */



}