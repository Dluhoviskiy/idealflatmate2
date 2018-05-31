package uk.co.idealflatmate.appmanager;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AuthorizationHelper {


    public void logoutFromApp() {
        $(".nav.navbar-right.nav-ihm-profile").click();
        $(byXpath("//li/a[contains(text(), ' Log out')]")).click();
    }

    public void goToPropertyPage() {
        $(byXpath("//a[@class='dropdown-toggle' and contains(text(), 'Browse ')]")).click();
        $(byXpath("//ul[@class='nav navbar-nav navbar-right nav-aux hidden-xs hidden-sm']//a[@href='/search' and contains(text(), 'Properties')]")).click();
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
        $(byXpath("//li/a[contains(text(), 'Log in')]")).click();
    }

    public void clickLoginSubmitButton() {
        $(byXpath("//*[@id=\"login-form\"]/div[5]/div/button")).click();
    }

    public void removeAccount() {

    }
    public void clickFormSignInPropertyContact() {
        $(byXpath("(//a[@class='btn btn-default u_m10-bottom-xs' and contains(text(), 'sign in')])[2]")).waitUntil(visible, 4000).click();

    }

}