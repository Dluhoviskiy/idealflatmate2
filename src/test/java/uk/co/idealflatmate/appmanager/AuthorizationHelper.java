package uk.co.idealflatmate.appmanager;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class AuthorizationHelper {


    public void logoutFromApp() {
        $(".nav.navbar-right.nav-ihm-profile").click();
        $(byXpath("//li/a[contains(text(), ' Log out')]")).click();
    }

    public void goToPropertyPage() {
        $(byXpath("(//a[@href='/search' and contains(text(), 'Find a room')])[2]")).waitUntil(appears, 4000).click();
  //      $(byXpath("//ul[@class='nav navbar-nav navbar-right nav-aux hidden-xs hidden-sm']//a[@href='/search' and contains(text(), 'Properties')]")).click();
    }

    public void goToFMpage() {
        $(byXpath("(//a[@href='/search/flatmate' and contains(text(), 'Find a flatmate')])[2]")).waitUntil(appears, 4000).click();
        //      $(byXpath("//ul[@class='nav navbar-nav navbar-right nav-aux hidden-xs hidden-sm']//a[@href='/search' and contains(text(), 'Properties')]")).click();
    }


    public void setLoginAsUserWithoutPackage(String email) {
        $("#loginform-username").click();
        $(".form-group.floating-label-group.field-loginform-username.required").waitUntil(appears, 4000);
        $("#loginform-username").shouldBe(visible);
        $("#loginform-username").setValue(email);

    }

    public void setPassword(String password) {
        $("#loginform-password").waitUntil(visible, 4000).setValue(password).pressEnter();
    }

    public void setLoginAndPasswordOnFacebook(String email, String password) {
        $("#email").waitUntil(visible, 4000).setValue(email);
        $("#pass").waitUntil(visible, 4000).setValue(password).pressEnter();
    }

    public void clickSignInWithFacebook() {
        $(byXpath("//*[@id=\"login-form\"]/div[1]/a")).waitUntil(visible, 4000).click();

    }
    public void clickSignInWithFacebookMatching() {
        $(byXpath("(//a[@class=\"btn btn-block btn-social btn-facebook u_m10-bottom auth-link facebook\"])[1]")).waitUntil(visible, 4000).click();
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
        $(byXpath("//li/a[contains(text(), 'Log in')]")).waitUntil(appears, 4000).click();
    }

    public void clickLoginSubmitButton() {
        $(byXpath("//*[@id=\"login-form\"]/div[5]/div/button")).click();
    }

    public void removeAccount() {

    }
    public void clickFormSignInPropertyContact() {
        $(byXpath("(//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign in')])[2]")).waitUntil(visible, 4000).click();

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