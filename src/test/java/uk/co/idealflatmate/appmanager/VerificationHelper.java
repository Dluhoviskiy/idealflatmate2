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

    public void verifyTextMessage() {
        $(".msg-body").waitUntil(visible, 4000).shouldHave(Condition.text("Test Upgrade"));
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
        $(byXpath("//div[@class='col-md-8 col-lg-9']")).shouldHave(text("London SE1, UK"));
        $(byXpath("//span[@class='text-bold js-phone-box']")).shouldHave(text("+44 20"));
        //$(byXpath("//div[@id='room1']/div[@class='u_bg-info u_p10 text-center text-18']/strong")).shouldHave(text("500"));
        $(byXpath("//div[@id='room1']")).shouldHave(text("£ 500 per month\n" +
                "Deposit £1,000\n" +
                "Available now\n" +
                "Min. stay 1 months\n" +
                "Max. stay 12 months\n" +
                "Total bills 400.00"));
        $(byXpath("//div[@class='panel panel-ihm panel-room-details u_m20-bottom-xs u_m40-bottom-sm hidden-xs']//li/a[contains(text(), 'Room 2')]")).click();
        $(byXpath("//div[@id='room2']")).waitUntil(visible, 4000).shouldHave(text("£ 500 per month\n" +
                "Deposit £1,000\n" +
                "Available now\n" +
                "Min. stay 1 months\n" +
                "Max. stay 12 months\n" +
                "Total bills 400.00"));
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


    public void AgeConfirmCheck() {
        $(byXpath("(//input[@name='SignupForm[is_age_confirm]'])[2]")).waitUntil(appears, 4000).click();

    }
}

