package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import com.typesafe.config.ConfigException;
import org.openqa.selenium.By;
import uk.co.idealflatmate.tests.TestBase;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class VerificationHelper  {


    public void verificationUserNameOnHomePage(String nameUser) {
        $(".nav.navbar-right.nav-ihm-profile").shouldHave(text(nameUser));
    }

    public void verificationUserNoNameOnHomePage(String nameUser) {
        $(".nav.navbar-right.nav-ihm-profile").shouldNotHave(text(nameUser));
    }

    public void VerificationPasswordError() {
        $(byXpath("//div[input[@id='loginform-username']]/p")).waitUntil(visible, 4000).shouldHave(text("Username cannot be blank."));
    }

    public void VerificationLoginError() {
        $(byXpath("//div[input[@id='loginform-password']]/p")).waitUntil(visible, 4000).shouldHave(text("Password cannot be blank."));
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
        $(byXpath("(//h2[@class='h3 u_m0-top text-info'])[1]")).waitUntil(visible, 4000).shouldHave(text("London SE1, UK"));

    }

    public void verifyAddedPropertyWithAllFields() {
        $(byXpath("//h1[@class='h2 u_m0-top u_p20-bottom text-normal u_b-bottom']")).shouldHave(text("3 rooms for rent in Bankside, South, London from\n" + "£500"));
        $(byXpath("(//span[@class='text-bold property-phone_hide js-phone-box'])[1]")).shouldHave(text("\n" + "+44 2 XXXX"));
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
        $(byXpath("(//div[@class='tab-content']//div[@class='row'])[3]")).shouldHave(text("£800\n" + "month\n" + "Available from\n" + "11th August 2025"));
       // $(byXpath("//h2[@class='h4 u_m20-top-xs u_m40-top-sm' and contains(text(), 'About this listing')]")).scrollIntoView(true);
        $(byXpath("//div[@class='u_p30-bottom']")).shouldHave(text("About the property\n" +
                "3 bedrooms\n" +
                "Garden\n" +
                "Parking space\n" +
                "Smokers accepted\n" +
                "Pet friendly\n" +
                "Very good flat"));
        //$(byXpath("//div[@class='u_p10-bottom u_b-bottom u_m30-bottom']")).shouldHave(text("Looking for pets accepted."));
        $(byXpath("//div[@class='u_p10-bottom u_m30-bottom u_b-bottom']")).shouldHave(text("London SE1, UK"));
    }
    public void verifyNoProperty() {
        $(byXpath("//h1[@class='h3 u_m0-top u_m0-bottom hidden-xs u_ef-left-sm']")).shouldHave(text("Your Listings"));
        $(byXpath("//section/div[@class='container']")).shouldNotHave((text("Complete your listing now!")));
        sleep(2000);
        if ($(byXpath("//section/div[@class='container']")).has((text("London SE1, UK")))){
            $(byXpath("//button[@class='btn btn-default u_p0 btn-circle pull-right js-bring-cover listing-panel-delete u_bg-white']")).waitUntil(appear, 4000).click();
            $(byXpath("(//input[1][@type='radio'])[1]")).waitUntil(appear, 4000).selectRadio("0");
            $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).waitUntil(Condition.appears, 4000).click();
            sleep(4000);
        }
    }

    public void verifyPackagePurchase() {
        $(".u_p20-bottom.u_b-bottom").shouldHave(Condition.value("Congratulations John!"));
    }

    //span[contains(text(), 'This email address has already been taken.')]
    public void emailAlreadyExistedAlert() {
        $(byXpath("//div[@class='form-group floating-label-group  required hasvalue has-error']")).waitUntil(exist, 4000).shouldHave(text("This email address has already been taken."));
    }

    public void emailWrongAlertHome() {
        //sleep(2000);
        $(byXpath("//div[@class='form-group floating-label-group  required hasvalue has-error']/p[@class='help-block help-block-error']")).waitUntil(exist, 4000).shouldHave(text("Incorrect username or password."));
    }

    public void nameFirstBlankAlert() {
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[1]")).waitUntil(exist, 4000).shouldHave(text("Firstname cannot be blank."));
    }

    public void emailBlankAlert() {
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[3]")).waitUntil(exist, 4000).shouldHave(text("Email cannot be blank."));
    }

    public void nameLastBlankAlert() {
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[2]")).waitUntil(exist, 4000).shouldHave(text("Lastname cannot be blank."));
    }

    public void passwordBlankAlert() {
        $(byXpath("//div[@class='form-group floating-label-group required has-error']")).waitUntil(exist, 4000).shouldHave(text("Password cannot be blank."));

    }

    public void ageConfirmCheckMatching() {
       $(byXpath("(//input[@name='SignupForm[is_age_confirm]'])[1]")).waitUntil(appears, 4000).click();

    }
    public void ageConfirmCheckClassicSignUpIf() {
        if (!$(byXpath("(//input[@name='SignupForm[is_age_confirm]'])[2]")).is(selected)) {
              $(byXpath("(//input[@name='SignupForm[is_age_confirm]'])[2]")).waitUntil(appears, 4000).click();
        }
        if (!$(byId("signup-need-is_subscribed")).is(selected)) {
            $(byId("signup-need-is_subscribed")).waitUntil(appears, 4000).click();
        }
    }

    public void ageConfirmCheckClassicSignUp() {
        $(byXpath("(//input[@name='SignupForm[is_age_confirm]'])[2]")).waitUntil(appears, 4000).click();
    }
    public void ageConfirmCheckClassicSignUpListing() {
        $(byCssSelector("#signupnewform-is_age_confirm")).waitUntil(appears, 4000).click();
    }
    public void is_subscribedClassicSignUpListing() {
        $(byCssSelector("#signupnewform-is_subscribed")).waitUntil(appears, 4000).click();
    }



    //span[contains(text(), 'This email address has already been taken.')]
    public void emailAlreadyExistedAlertMatching() {
        $(byXpath("//div[@class='form-group floating-label-group  required has-error hasvalue']")).waitUntil(exist, 4000).shouldHave(text("This email address has already been taken."));
    }

    public void NameFirstBlankAlertMatching() {
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[1]")).waitUntil(exist, 4000).shouldHave(text("Firstname cannot be blank."));
    }

    public void emailBlankAlertMatching() {
        sleep(2000);
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[3]")).waitUntil(exist, 4000).shouldHave(text("Email cannot be blank."));
    }

    public void NameLastBlankAlertMatching() {
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[2]")).waitUntil(exist, 4000).shouldHave(text("Lastname cannot be blank."));
    }

    public void passwordBlankAlertMatching() {
        $(byXpath("(//div[@class='form-group floating-label-group  required has-error'])[4]")).waitUntil(exist, 4000).shouldHave(text("Password cannot be blank."));

    }

    public void checkAgeBlankAlert() {
        $(byXpath("//div[@class='required checkbox has-error']")).waitUntil(exist, 4000).shouldHave(text("Please confirm your age to continue"));
    }

    public void checkAgeBlankAlertMatching() {
        $(byXpath("(//div[@class='required checkbox has-error'])[1]")).waitUntil(exist, 4000).shouldHave(text("Please confirm your age to continue"));
    }

    public void upgradeToFasterReply() {
        $(byXpath("//div[@class='alert alert-warning text-center u_m0']")).waitUntil(exist, 4000).shouldHave(text("Upgrade to get a faster reply"));

    }
    public void noTextUpgradeToFasterReply() {
        $(byXpath("//div[@class='page-content main-content dashboard messages']")).waitUntil(exist, 4000).shouldNotHave(text("Upgrade to get a faster reply"));

    }

    public void messageGroup(String text) {
        $(byXpath("//select[@id='property-select']")).waitUntil(exist, 4000).shouldHave(text(text));
    }

    public void photoListingExist(){
        $(byXpath("//div[@class='owl-item active'][1]")).shouldBe(visible);
        $(byXpath("//div[@class='owl-item active'][2]")).shouldBe(visible);
        $(byXpath("//div[@class='owl-item active'][3]")).shouldBe(visible);

    }

    public void checkMatchingConcurrence(String text) {
        $("span.hidden-xs").click();
        $(byXpath("(//a[@data-target='#matchModal'])[1]")).waitUntil(exist, 4000).shouldHave(text(text));
    }

    public void checkPhoneAlert() {
        $(byXpath("(//div[input[@id='signup-need-phone']]/p)[1]")).waitUntil(exist, 4000).shouldHave(text("Phone cannot be blank."));
    }

    public void closeAdvPopUp() {
        if ($(byXpath("(//button[@class='ub-emb-close'])[1]")).is(exist)) {
            $(byXpath("(//button[@class='ub-emb-close'])[1]")).waitUntil(appears, 8000).click();
            sleep(2000);
        }
    }

    public void verificationEmailErrorListing() {
        $(byXpath("//label[@for='signupnewform-email']/following-sibling::p")).waitUntil(visible, 4000).shouldHave(text("Email cannot be blank."));
    }

    public void verificationNameFErrorListing() {
        $(byXpath("//label[@for='signupnewform-firstname']/following-sibling::p")).waitUntil(visible, 4000).shouldHave(text("First Name cannot be blank."));
    }

    public void verificationNameLErrorListing() {
        $(byXpath("//label[@for='signupnewform-lastname']/following-sibling::p")).waitUntil(visible, 4000).shouldHave(text("Last Name cannot be blank."));
    }

    public void verificationPasswordErrorListing() {
        $(byXpath("//label[@for='signupnewform-password']/following-sibling::p")).waitUntil(visible, 4000).shouldHave(text("Password cannot be blank."));
    }

    public void verificationPasswordConfirmErrorListing() {
        $(byXpath("//label[@for='signupnewform-password_confirm']/following-sibling::p")).waitUntil(visible, 4000).shouldHave(text("Confirm Password cannot be blank."));
    }
    public void verificationPhoneConfirmErrorListing() {
        $(byXpath("//label[@for='signupnewform-phone']/following-sibling::p")).waitUntil(visible, 4000).shouldHave(text("Phone cannot be blank."));
    }

    public void verificationCheckAgeError() {
        $(byXpath("//label[@for='signupnewform-is_age_confirm']/following-sibling::p")).waitUntil(visible, 4000).shouldHave(text("Please confirm your age to continue"));
    }

    public void checkPhoneAlertMatching() {
        $(byXpath("(//div[input[@id='signup-survey-phone']]/p)[1]")).waitUntil(exist, 4000).shouldHave(text("Phone cannot be blank."));

    }

    public void ContinueMatching1() {
        $(byXpath("//button[@id='2']")).waitUntil(exist, 4000).shouldHave(text("Continue"));

    }

    public void closeMatchingPopup() {
        if ($(byXpath("//button[@class='btn btn-sm btn-close close js-close-notify-matching']")).is(exist)) {
            $(byXpath("//button[@class='btn btn-sm btn-close close js-close-notify-matching']")).waitUntil(appears, 8000).click();
            sleep(2000);
        }
    }

    public void paymentPage() {
        $(byXpath("//h1[@class='list-property-title u_m0-top ']")).waitUntil(exist, 4000).shouldHave(text("Upgrade"));
    }

    public void chatPage() {
        $(byXpath("//textarea[@name='ConversationMessage[message]']")).waitUntil(exist, 4000).shouldBe(visible);
    }
}

