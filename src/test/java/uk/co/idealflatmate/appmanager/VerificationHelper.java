package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class VerificationHelper {


    public void verificationAlexNameOnHomePage() {
        $(".nav.navbar-right.nav-ihm-profile").shouldHave(text("Alex"));
    }

    public void verificationAleksandrNameOnHomePage() {
        $(".nav.navbar-right.nav-ihm-profile").shouldHave(text("Alex"));
    }

    public void VerificationPasswordError() {
        $("#login-form > div:nth-child(3) > div:nth-child(2) > div > p > span").shouldHave(text("Password cannot be blank."));
    }

    public void VerificationLoginError() {
        $("#login-form > div:nth-child(3) > div:nth-child(1) > div > p > span").shouldHave(text("Username cannot be blank."));
    }

    public void VerificationMessagesTabIsAbsent() {
        $("body > header > div > ul.nav.navbar-nav.navbar-right.nav-aux.hidden-xs.hidden-sm > li:nth-child(3) > a").shouldNotBe(text("Messages"));
    }

    public void verifyUpgradeButton() {
        $(".fa.fa-credit-card").shouldBe(Condition.visible);
    }

    public void verifyTextMessage() {
        $(".msg-body").shouldHave(Condition.text("It looks great"));
    }

    public void verifyAddedProperty() {
        $(".dropdown.nav-ihm-profile-bars").click();
        $(byXpath("/html/body/header/div/ul[1]/li/ul/li[10]/a")).hover().shouldBe(enabled).click();
        $(".col-sm-7.col-lg-8").shouldHave(text("London SE1, UK"));

    }

    public void verifyPackagePurchase() {
        $(".u_p20-bottom.u_b-bottom").shouldHave(Condition.value("Congratulations John!"));
    }
}
