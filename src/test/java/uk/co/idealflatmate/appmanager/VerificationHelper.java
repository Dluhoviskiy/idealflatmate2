package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;


public class VerificationHelper {


    public void verificationUserNameOnHomePage(String nameUser) {
        $(".nav.navbar-right.nav-ihm-profile").shouldHave(text(nameUser));
    }

    public void verificationUserNoNameOnHomePage(String nameUser) {
        $(".nav.navbar-right.nav-ihm-profile").shouldNotHave(text(nameUser));
    }

  /*  public void verificationUserNameOnHomePage(String nameUser) {
        verificationUserNameOnHomePage(nameUser);
    }*/

    public void VerificationPasswordError() {
        $("#login-form > div:nth-child(3) > div:nth-child(2) > div > p > span").waitUntil(visible, 4000).shouldHave(text("Password cannot be blank."));
    }

    public void VerificationLoginError() {
        $("#login-form > div:nth-child(3) > div:nth-child(1) > div > p > span").waitUntil(visible, 4000).shouldHave(text("Username cannot be blank."));
    }

    public void VerificationMessagesTabIsAbsent() {
        $("body > header > div > ul.nav.navbar-nav.navbar-right.nav-aux.hidden-xs.hidden-sm > li:nth-child(3) > a").waitUntil(visible, 4000).shouldNotBe(text("Messages"));
    }

    public void verifyUpgradeButton() {
        $(".fa-credit-card").waitUntil(visible, 4000).shouldBe(Condition.visible);
    }

    public void verifyTextMessage(String text) {
        $(".msg-body").waitUntil(visible, 8000).shouldHave(Condition.text(text));
    }
    public void verifyPageMessage() {
        $(byXpath("//textarea[@name='ConversationMessage[message]']")).waitUntil(visible, 4000).shouldHave(Condition.name("ConversationMessage[message]"));
    }



    public void verifyAddedProperty() {
        $(".dropdown.nav-ihm-profile-bars").click();
        $(byXpath("//span[@class='pull-left' and contains(text(), 'Listings')]")).hover().shouldBe(enabled).click();
        $(".col-sm-7.col-lg-8").waitUntil(visible, 4000).shouldHave(text("London SE1, UK"));

    }

    public void verifyAddedPropertyWithAllFields() {
        $(byXpath("//h1[@class='h2 u_m0-top u_p20-bottom text-normal u_b-bottom']")).shouldHave(text("3 rooms for rent in Bankside, South, London from\n" + "£500"));
        $(byXpath("(//span[@class='text-bold property-phone_hide js-phone-box'])[1]")).shouldHave(text("\n" + "+44 20 7234"));
        $(byXpath("//div[@class='panel-heading']")).waitUntil(visible, 4000).shouldHave(text("Room 1\n" + "Room 2\n" + "Room 3\n"));
        $(byXpath("(//div[@class='tab-content']//div[@class='row'])[1]")).shouldHave(text("£500\n" +
                "month\n" +
                "Deposit\n" +
                "£1,000\n" +
                "Bills pcm\n" +
                "£400\n" +
                "Lease length\n" +
                "1 month+"));
        $(byXpath("//div[@class='tab-pane fade active in']//div[@class='clearfix u_m15-top']")).shouldHave(text("Very comfortable room\n"));
        $(byXpath("//a[contains(text(), 'Room 2')]")).click();
        $(byXpath("(//div[@class='tab-content']//div[@class='row'])[2]")).shouldHave(text("£500\n" +
                "month\n" +
                "Deposit\n" +
                "£1,000\n" +
                "Bills pcm\n" +
                "£400\n" +
                "Lease length\n" +
                "1 month+"));
        $(byXpath("//div[@class='tab-pane fade  in active']//div[@class='clearfix u_m15-top']")).shouldHave(text("Very comfortable room\n"));
        $(byXpath("//a[contains(text(), 'Room 3')]")).click();
        $(byXpath("(//div[@class='tab-content']//div[@class='row'])[3]")).shouldHave(text("£800\n" + "month\n" + "Available from\n" + "11th July 2025"));
       // $(byXpath("//h2[@class='h4 u_m20-top-xs u_m40-top-sm' and contains(text(), 'About this listing')]")).scrollIntoView(true);
        $(byXpath("//div[@class='u_p30-bottom']")).shouldHave(text("About the property\n" +
                "3 bedrooms\n" +
                "Garden\n" +
                "Parking space\n" +
                "Smokers accepted\n" +
                "Pet friendly\n" +
                "Very good flat"));
        $(byXpath("//div[@class='u_p10-bottom u_b-bottom u_m30-bottom']")).shouldHave(text("Looking for pets accepted."));
        $(byXpath("//div[@class='u_p10-bottom u_m30-bottom u_b-bottom']")).shouldHave(text("London SE1, UK"));
    }
    /*public void verifyNoOldProperty1() {
        exist$(byXpath("//h1[@class='h3 u_m0-top u_m0-bottom hidden-xs u_ef-left-sm']")).shouldHave(text("Your Listings"));
        $(byXpath("//section/div[@class='container']")).shouldNotHave((text("Complete your listing now!")));
        if text("Complete your listing now!")==null {}
        {
        }

        $(byXpath("//section/div[@class='container']")).shouldNotHave((text("London SE1, UK")));
    }*/


    public void verifyNoProperty() {
        $(byXpath("//h1[@class='h3 u_m0-top u_m0-bottom hidden-xs u_ef-left-sm']")).shouldHave(text("Your Listings"));
        $(byXpath("//section/div[@class='container']")).shouldNotHave((text("Complete your listing now!")));
        $(byXpath("//section/div[@class='container']")).shouldNotHave((text("London SE1, UK")));
    }


    public void verifyPackagePurchase() {
        $(".u_p20-bottom.u_b-bottom").shouldHave(Condition.value("Congratulations John!"));
    }

    //span[contains(text(), 'This email address has already been taken.')]
    public void emailAlreadyExistedAlert() {
        $(byXpath("//div[@class='form-group floating-label-group  required hasvalue has-error']")).waitUntil(exist, 4000).shouldHave(text("This email address has already been taken."));
    }

    public void NameFirstBlankAlert() {
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[1]")).waitUntil(exist, 4000).shouldHave(text("Firstname cannot be blank."));
    }

    public void emailBlankAlert() {
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[3]")).waitUntil(exist, 4000).shouldHave(text("Email cannot be blank."));
    }

    public void NameLastBlankAlert() {
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[2]")).waitUntil(exist, 4000).shouldHave(text("Lastname cannot be blank."));
    }

    public void passwordBlankAlert() {
        $(byXpath("//div[@class='form-group floating-label-group required has-error']")).waitUntil(exist, 4000).shouldHave(text("Password cannot be blank."));

    }

    public void AgeConfirmCheckMatching() {
        $(byXpath("(//input[@name='SignupForm[is_age_confirm]'])[1]")).waitUntil(appears, 4000).click();

    }

    public void AgeConfirmCheckClassicSignUp() {
        $(byXpath("(//input[@name='SignupForm[is_age_confirm]'])[2]")).waitUntil(appears, 4000).click();

    }

    //span[contains(text(), 'This email address has already been taken.')]
    public void emailAlreadyExistedAlertMatching() {
        $(byXpath("//div[@class='form-group floating-label-group  required has-error hasvalue']")).waitUntil(exist, 4000).shouldHave(text("This email address has already been taken."));
    }

    public void NameFirstBlankAlertMatching() {
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[1]")).waitUntil(exist, 4000).shouldHave(text("Firstname cannot be blank."));
    }

    public void emailBlankAlertMatching() {
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[3]")).waitUntil(exist, 4000).shouldHave(text("Email cannot be blank."));
    }

    public void NameLastBlankAlertMatching() {
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[2]")).waitUntil(exist, 4000).shouldHave(text("Lastname cannot be blank."));
    }

    public void passwordBlankAlertMatching() {
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[4]")).waitUntil(exist, 4000).shouldHave(text("Password cannot be blank."));

    }

    public void checkAgeBlankAlert() {
        $(byXpath("//div[@class='required flex-form-row has-error']")).waitUntil(exist, 4000).shouldHave(text("Please confirm your age to continue"));
    }

    public void checkAgeBlankAlertMatching() {
        $(byXpath("//div[@class='required flex-form-row has-error']")).waitUntil(exist, 4000).shouldHave(text("Please confirm your age to continue"));
    }

    public void upgradeToFasterReply() {
        $(byXpath("//div[@class='alert alert-warning text-center u_m0']")).waitUntil(exist, 4000).shouldHave(text("Upgrade to get a faster reply"));

    }

    public void messageGroup(String text) {
        $(byXpath("//select[@id='property-select']")).waitUntil(exist, 4000).shouldHave(text(text));
    }

    public void photoListingExist(){
        $(byXpath("//div[@class='owl-item active'][1]")).shouldBe(visible);
        $(byXpath("//div[@class='owl-item active'][2]")).shouldBe(visible);
        $(byXpath("//div[@class='owl-item active'][3]")).shouldBe(visible);

    }
}

