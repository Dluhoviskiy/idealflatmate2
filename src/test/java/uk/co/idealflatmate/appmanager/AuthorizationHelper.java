package uk.co.idealflatmate.appmanager;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AuthorizationHelper {


    public void logoutFromApp() {
        $(".nav.navbar-right.nav-ihm-profile").click();
        $(byXpath("//li/a[contains(text(), ' Log out')]")).click();
    }

    public void goToPropertyPage() {
        $( byXpath("//a[@class='dropdown-toggle' and contains(text(), 'Browse ')]")).click();
        $( byXpath("//ul[@class='nav navbar-nav navbar-right nav-aux hidden-xs hidden-sm']//a[@href='/search' and contains(text(), 'Properties')]")).click();
    }


    public void setLoginAsUserWithoutPackage() {
        $("#loginform-username").click();
        $(".form-group.floating-label-group.field-loginform-username.required").waitUntil(appears, 4000);
        $("#loginform-username").shouldBe(visible);
        $("#loginform-username").setValue("cro.gen44@gmail.com");

    }

    public void setPassword() {
        $("#loginform-password").setValue("123456").pressEnter();
    }

    public void setLoginAndPasswordOnFacebook() {
        $("#email").setValue("aleksandr.serdiuk@gmail.com");
        $("#pass").setValue("Apple210189").pressEnter();
    }

    public void  clickSignInWithFacebook() {
        $(byXpath("//*[@id=\"login-form\"]/div[1]/a")).click();
    }

    public void setLoginAsUserWithPremiumFlathunterPackage() {
        $("#loginform-username").click();
        $(".form-group.floating-label-group.field-loginform-username.required").waitUntil(appears, 4000);
        $("#loginform-username").shouldBe(visible);
        $("#loginform-username").setValue("cro.gen49@gmail.com");
    }

    public void setLoginAsUserWithoutPackage2(AuthorizationHelper authorizationHelper) {
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage();
    }

    public void clickSignUpButton() {
        $(".signup-modal-test").click();
    }

    public void clickSignInButton() {
        $(byXpath("//li/a[contains(text(), 'Log in')]")).click();
    }

    public void clickLoginSubmitButton() {
        $(byXpath("//*[@id=\"login-form\"]/div[5]/div/button")).click();
    }
}
