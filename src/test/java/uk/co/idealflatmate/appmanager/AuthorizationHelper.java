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
        $(byXpath("/html/body/header/div/ul[1]/li/ul/li[13]/a")).click();
    }

    public void setLoginAsUserWithoutPackage() {
        $("#loginform-username").click();
        $(".form-group.floating-label-group.field-loginform-username.required").shouldBe(visible).waitUntil(appears, 4000);
        $("#loginform-username").setValue("cro.gen4@gmail.com");
        $("#loginform-username").shouldHave(value("cro.gen4@gmail.com"));

    }

    public void setPassword() {
        $("#loginform-password").setValue("123456").pressEnter();
    }

    public void setLoginAndPasswordOnFacebook() {
        $("#email").setValue("aleksandr.serdiuk@gmail.com");
        $("#pass").setValue("Apple210189").pressEnter();
    }

    public void ClickLoginWithFacebook() {
        $("#login-form > div.text-center.u_p15-top > a").click();
    }

    public void setLoginAsUserWithPremiumFlathunterPackage() {
        $("#loginform-username").click();
        $(".form-group.floating-label-group.field-loginform-username.required").shouldBe(visible);
        $("#loginform-username").setValue("cro.gen49@gmail.com");
    }

    public void setLoginAsUserWithoutPackage2(AuthorizationHelper authorizationHelper) {
        authorizationHelper.setLoginAsUserWithPremiumFlathunterPackage();
    }

    public void clickSignInButton() {
        $(byXpath("/html/body/header/div/ul[2]/li[3]/a")).click();
    }

    public void clickLoginSubmitButton() {
        $(byXpath("//*[@id=\"login-form\"]/div[5]/div/button")).click();
    }
}
