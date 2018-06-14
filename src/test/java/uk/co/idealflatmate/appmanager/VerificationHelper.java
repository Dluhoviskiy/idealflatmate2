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
       // $(".dropdown.nav-ihm-profile-bars").click();
       // $(byXpath("//span[@class='pull-left' and contains(text(), 'Listings')]")).hover().shouldBe(enabled).click();
        //$(byXpath("//div[@class='col-md-8 col-lg-9']")).shouldHave(text("London SE1, UK"));
        $(byXpath("//h1[@class='h2 u_m0-top u_p20-bottom text-normal u_b-bottom']")).shouldHave(text("3 rooms for rent in Bankside, South, London from\n" + "£500"));
        $(byXpath("(//span[@class='text-bold property-phone_hide js-phone-box'])[1]")).shouldHave(text("\n" + "+44 20 7234"));
        //$(byXpath("//div[@id='room1']/div[@class='u_bg-info u_p10 text-center text-18']/strong")).shouldHave(text("500"));
        $(byXpath("(//div[@class='tab-content']//div[@class='row'])[1]")).shouldHave(text("£500" + "month" + "Deposit" + "£1,000" + "Bills pcm" + "£400" + "Lease length" + "1 month+"));
        $(byXpath("//div[@class='panel panel-ihm panel-room-details u_m20-bottom-xs u_m40-bottom-sm hidden-xs']//li/a[contains(text(), 'Room 2')]")).click();
        $(byXpath("//div[@id='room2']")).waitUntil(visible, 4000).shouldHave(text("Room 1" + "Room 2" + "Room 3"));
        //$(byXpath("//div[@class='panel panel-ihm panel-room-details u_m20-bottom-xs u_m40-bottom-sm hidden-xs']//a[contains(text(), 'MORE')]")).click();

       // $(byXpath("//div[@class='panel panel-ihm panel-room-details u_m20-bottom-xs u_m40-bottom-sm hidden-xs']//a[contains(text(), 'Room 3')]")).waitUntil(visible, 4000).click();
        $(byXpath("//div[@class='panel panel-ihm panel-room-details u_m20-bottom-xs u_m40-bottom-sm hidden-xs']//li/a[contains(text(), 'Room 3')]")).click();
        $(byXpath("//div[@id='room3']")).waitUntil(visible, 4000).shouldHave(text("£ 800 per month\n" +
                "Available from 2025-06-11\n" +
                "\n" +
                "Total bills 0"));
        $(byXpath("//h2[@class='h4 u_m20-top-xs u_m40-top-sm' and contains(text(), 'About this listing')]")).scrollIntoView(true);
        $(byXpath("//div[@class='col-md-4 text-primary u_m10-bottom' and contains(text(), 'Room 1')]/parent::div/parent::div")).shouldHave(text("Very comfortable room"));
        $(byXpath("//div[@class='col-md-4 text-primary u_m10-bottom' and contains(text(), 'Room 2')]/parent::div/parent::div")).shouldHave(text("Very comfortable room"));
        $(byXpath("//div[@class='col-md-4 text-primary u_m10-bottom' and contains(text(), 'Room 3')]/parent::div/parent::div")).shouldHave(text("No description available."));
        $(byXpath("//div/div[contains(text(), 'About the Property')]/parent::div/parent::div")).shouldHave(text("\n" +
                "Total rooms: 3\n" +
                "\n" +
                "Available rooms: 3\n" +
                "\n" +
                "Smoking: Accepted\n" +
                "\n" +
                "Pets: Accepted"));
        $(byXpath("//div/div[contains(text(), 'Added Features')]/parent::div/parent::div")).shouldHave(text("Garden\n" +
                "\n" +
                "Communal living room\n" +
                "\n" +
                "Balcony/patio\n" +
                "\n" +
                "Parking"));
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
}

