package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import org.testng.Assert;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class VerificationHelper extends HelperBase {




    public void verificationUserNameOnHomePage(String nameUser) {
        $("span.user-welcome--name").waitUntil(visible, 30000).shouldHave(text(nameUser));
    }

    public void verificationUserIsUnlogged(String SignUp) {

        $(byXpath("//nav/a[@class]")).shouldHave(text(SignUp));
    }

    public void VerificationPasswordError() {
        $(byXpath("//div[input[@id='loginform-username']]/div")).waitUntil(visible, 4000).shouldHave(text("Username cannot be blank."));
    }

    public void VerificationLoginError() {
        $(byXpath("//div[input[@id='loginform-password']]/div")).waitUntil(visible, 4000).shouldHave(text("Password cannot be blank."));
    }

    public void VerificationMessagesTabIsAbsent() {
        $("body > header > div > ul.nav.navbar-nav.navbar-right.nav-aux.hidden-xs.hidden-sm > li:nth-child(3) > a").waitUntil(visible, 4000).shouldNotBe(text("Messages"));
    }

    public void verifyUpgradeButton() {
        $("a.btn.btn-white.box-shadow").waitUntil(visible, 4000).shouldBe(Condition.visible);
    }

    public void verifyTextMessage(String text) {
        sleep(5000);
        $(byXpath("(//div[@class='msg msg-host msg-sent'][last()]//span[last()])[2]")).shouldHave(Condition.text(text));
    }
    public void verifyPageMessage() {
        $(byXpath("//textarea[@name='ConversationMessage[message]']")).waitUntil(visible, 4000).shouldHave(Condition.name("ConversationMessage[message]"));
    }

    public void verifyAddedProperty() {
        //$(".dropdown.nav-ihm-profile-bars").click();
        //$(byXpath("//span[@class='pull-left' and contains(text(), 'My Listings')]")).hover().shouldBe(enabled).click();
            $(byXpath("(//h2[@class='h3 u_m0-top text-info'])[1]")).waitUntil(visible, 4000).shouldHave(text("London SE1, UK"));

    }

    public void verifyAddedPropertyWithAllFields(String month) {//section[@id]//h1/small
        String ref = $(byXpath("//section[@id]//h1/small")).getText();
        $(byXpath("//section[@id]//h1")).getText().contentEquals("3 bedrooms for rent in Bankside, South London from "+"500/month per room\n"
                 + ref);
        $(byXpath("(//span[@class='property-phone_hide js-phone-box'])[2]")).shouldHave(text("\n" + "+44 2 XXXX"));

        //$(byXpath("//div[@class='panel-heading']")).scrollTo();

        $(byXpath("//div[@class='panel-heading']")).waitUntil(visible, 4000).shouldHave(text("Room 1\n" + "Room 2\n" + "Room 3\n"));
        $(byXpath("(//div[@class='tab-content']//div[@class='row'])[1]/div")).getText().contentEquals("500\n" +
                "month\n" +
                "Deposit\n" +
                "1,000\n" +
                "Bills pcm\n" +
                "400\n");

        $(byXpath("(//div[@class='tab-content']//div[@class='row'])[1]//div[@class='col-xs-6 u_p0-right']")).shouldHave(text("Length of Stay\n" +
                "minimum 1 month maximum 12 months"));

        $(byXpath("//div[@class='tab-pane fade active in']//div[@class='clearfix u_m15-top']")).shouldHave(text("Very comfortable room\n"));

        $(byXpath("//a[contains(text(), 'Room 2')]")).click();

        $(byXpath("(//div[@class='tab-content']//div[@class='row'])[1]/div")).getText().contentEquals("500\n" +
                "month\n" +
                "Deposit\n" +
                "1,000\n" +
                "Bills pcm\n" +
                "400\n");

        $(byXpath("(//div[@class='tab-content']//div[@class='row'])[1]//div[@class='col-xs-6 u_p0-right']")).shouldHave(text("Length of Stay\n" +
                "minimum 1 month maximum 12 months"));



        $(byXpath("//div[@class='tab-pane fade in active']//div[@class='clearfix u_m15-top']")).shouldHave(text("Very comfortable room\n"));

        $(byXpath("//a[contains(text(), 'Room 3')]")).click();

        $(byXpath("(//div[@class='tab-content']//div[@class='row'])[3]")).getText().contentEquals("800\n" + "month\n" + "Available from\n" + "11th " + month + " 2025");
       // $(byXpath("//h2[@class='h4 u_m20-top-xs u_m40-top-sm' and contains(text(), 'About this listing')]")).scrollIntoView(true);
        $(byXpath("//div[@class='u_p30-bottom']")).shouldHave(text(" 3 of 2 bedrooms available  Garden  Parking space  Smokers accepted  Pets accepted  Family friendly\n" +
                "Very good flat"));
        //$(byXpath("//div[@class='u_p10-bottom u_b-bottom u_m30-bottom']")).shouldHave(text("Looking for pets accepted."));
        $(byXpath("//div[@class='u_p10-bottom u_m30-bottom u_b-bottom']")).shouldHave(text("London SE1, UK"));
    }

    public void verificationDataProfileFMmin(String PercentCompleted) {
        $(byXpath("//ul[starts-with(@class,'nav dashboard')]")).shouldHave(text(" User Type\n" +
                " Personal Details\n" +
                " Property Preferences\n" +
                " Budget & Availability\n" +
                " Your ideal flatmate"));
        $(byXpath("//div[starts-with(@class,'circularProgress__value')]")).shouldHave(text("\n" +
                "                                        " + PercentCompleted + "\n" +
                "                                        "));
        $(byXpath("//div[starts-with(@class,'col-sm-8')]")).getText().contentEquals("About me\n" +
                "Ronald, 59 is a female looking for a room.\n" +
                "Maximum budget: "+"2500/month\n" +
                "Ready to move in: Immediately");
    }

    public void verificationDataProfileFMListing(String PercentCompleted) {
        $(byXpath("//ul[starts-with(@class,'nav dashboard')]")).shouldHave(text(" User Type\n" +
                " Personal Details\n" +
                " Property Preferences\n" +
                " Budget & Availability\n" +
                " Your ideal flatmate"));
        $(byXpath("//div[starts-with(@class,'circularProgress__value')]")).shouldHave(text(PercentCompleted + "\n" + "complete"));
        $(byXpath("//div[starts-with(@class,'col-sm-8')]")).getText().contentEquals("About me\n" +
                "Ronald, 59 is a female looking for a room.\n" +
                "Maximum budget: "+"2500/month\n" +
                "Ready to move in: Immediately");
    }

    public void verificationDataProfile() {
        $(byXpath("//div[@class='col-sm-5 h5 heading-spaced text-normal u_m20-top u_m30-top-md text-normal-weight']")).getText().contentEquals("Preferred location: London\n" +
                "Preferred location2: South London\n" +
                "Preferred location3: Hackney Marshes\n" +
                "Budget: "+"2500 pm\n" +
                "Ready to move in: now");
    }

    public void verificationDataTenant(String percent) {
        $(byXpath("//ul[starts-with(@class,'nav dashboard')]")).shouldHave(text(" User Type\n" +
                " Personal Details\n" +
                " Property Preferences\n" +
                " Budget & Availability\n" +
                " Your ideal flatmate"));
        $(byXpath("//div[starts-with(@class,'circularProgress__value')]")).shouldHave(text("\n" +
                "                                        " + percent + "\n" +
                "                                        "));
        $(byXpath("//div[starts-with(@class,'col-sm-8')]")).getText().contentEquals("About me\n" +
                "Tell us about yourself\n" +
                "Maximum budget: "+"1250/month\n" +
                "Ready to move in: 08-08-2019\n" +
                "Looking for a room in\n" +
                "South London\n" +
                "Hackney Marshes");
    }

    public void verificationDataTenant1(String percent) {
        $(byXpath("//ul[starts-with(@class,'nav dashboard')]")).shouldHave(text(" User Type\n" +
                " Personal Details\n" +
                " Property Preferences\n" +
                " Budget & Availability\n" +
                " Your ideal flatmate"));
        $(byXpath("//div[starts-with(@class,'circularProgress__value')]")).shouldHave(text("\n" +
                "                                        " + percent + "\n" +
                "                                        "));
        $(byXpath("//div[starts-with(@class,'col-sm-8')]")).getText().contentEquals("About me\n" +
                "Tell us about yourself\n" +
                "Maximum budget: "+"1250/month\n" +
                "Ready to move in: 08-08-2019\n" +
                "Looking for a room in\n" +
                "Watford");
    }

    public void verificationDataLike(String percent) {
        $(byXpath("//ul[starts-with(@class,'nav dashboard')]")).shouldHave(text(" User Type\n" +
                " Personal Details\n" +
                " Property Preferences\n" +
                " Budget & Availability\n" +
                " Your ideal flatmate"));
        $(byXpath("//div[starts-with(@class,'circularProgress__value')]")).shouldHave(text(percent + "\n" +
                "complete"));
        $(byXpath("//div[starts-with(@class,'col-sm-8')]")).getText().contentEquals("About me\n" +
                "Ronald is a female looking for a room.\n" +
                "Maximum budget: "+"2500/month\n" +
                "Ready to move in: Immediately");
    }

    public void verificationDataAgent(String percent) {
        $(byXpath("//ul[starts-with(@class,'nav dashboard')]")).shouldHave(text("User Type\n" +
                "Personal Details\n" +
                "Your ideal tenant"));
        $(byXpath("//div[starts-with(@class,'circularProgress__value')]")).shouldHave(text(percent + "\n" +
                "complete"));
        $(byXpath("//div[starts-with(@class,'col-sm-8')]")).shouldHave(text("About us\n" +
                "Tell us about yourself"));

    }

    public void verificationDataLive_in(String percent) {
        $(byXpath("//ul[starts-with(@class,'nav dashboard')]")).shouldHave(text(" User Type\n" +
                " Personal Details\n" +
                " Your ideal flatmate\n"));
        $(byXpath("//div[starts-with(@class,'circularProgress__value')]")).shouldHave(text(percent + "\n" +
                "complete"));
        $(byXpath("//div[starts-with(@class,'col-sm-8')]")).shouldHave(text("About me\n" +
                "Ronald, 59 is a male professional looking for a room."));
    }

    public void verificationDataLive_in1(String percent) {
        $(byXpath("//ul[starts-with(@class,'nav dashboard')]")).shouldHave(text(" User Type\n" +
                " Personal Details\n" +
                " Your ideal flatmate\n"));
        $(byXpath("//div[starts-with(@class,'circularProgress__value')]")).shouldHave(text(percent + "\n" +
                "complete"));
        $(byXpath("//div[starts-with(@class,'col-sm-8')]")).shouldHave(text("Tell us about yourself"));
    }

    public void verificationDataProfileLiveOut(String percent) {

        $(byXpath("//ul[starts-with(@class,'nav dashboard')]")).shouldHave(text(" User Type\n" +
                " Personal Details\n" +
                " Your ideal tenant\n"));
        $(byXpath("//div[starts-with(@class,'circularProgress__value')]")).shouldHave(text(percent + "\n" +
                "complete"));
        $(byXpath("//div[starts-with(@class,'col-sm-8')]")).shouldHave(text("About me\n" +
                "Ronald is a live-out landlord looking for a room."));
    }

    public void verificationDataProfileFB(String percent, String name) {
        $(byXpath("//ul[starts-with(@class,'nav dashboard')]")).shouldHave(text("User Type\n" +
                "Personal Details\n" +
                "Property Preferences\n" +
                "Budget & Availability\n" +
                "Your ideal flatmate"));
        $(byXpath("//div[starts-with(@class,'circularProgress__value')]")).shouldHave(text(percent + "\n" +
                "complete"));
        $(byXpath("(//h4/../div[@class='text-body-copy'])[1]")).shouldHave(text(name + ", 59 is a female " +
                "freelancer/self employed looking for a room in Zone 1 or Watford or North London."));
     }

    public void verifDataProfFBAgent(String percent, String text1) {
        $(byXpath("//ul[starts-with(@class,'nav dashboard')]")).shouldHave(text("User Type\n" +
                "Personal Details\n" +
                "Your ideal tenant"));
        $(byXpath("//div[starts-with(@class,'circularProgress__value')]")).shouldHave(text(percent + "\n" +
                "complete"));
        $(byXpath("(//h4/../div[@class='text-body-copy'])[1]")).shouldHave(text(text1));
    }

    public void verificationDataProfileFM(String percent) {
        $(byXpath("//ul[starts-with(@class,'nav dashboard')]")).shouldHave(text("User Type\n" +
                "Personal Details\n" +
                "Property Preferences\n" +
                "Budget & Availability\n" +
                "Your ideal flatmate"));
        $(byXpath("//div[starts-with(@class,'circularProgress__value')]")).shouldHave(text("\n" +
                "                                        " + percent + "\n" +
                "                                        "));
        $(byXpath("(//h4/../div[@class='text-body-copy'])[1]")).shouldHave(text("Ronaldina, 59 is a female looking " +
                "for a room in Watford or North London or Zone 1."));
        //String locations2 = $(byXpath("//ul[@class='geo-list u_m0 u_p0']")).getText();
        //Assert.assertEquals(locations2, location1);
        $(byXpath("//ul[@class='geo-list u_m0 u_p0']")).shouldHave(text("Watford\n" +
                "North London\n" +
                "Zone 1"));
        $(byXpath("(//h4[@class='u_m0-top u_m20-bottom text-16'])[2]")).getText().contentEquals("Maximum budget: "+"1250/month");
        $(byXpath("(//h4[@class='u_m0-top u_m20-bottom text-16'])[3]")).shouldHave(text("Ready to move in: Immediately"));

        /*$(byXpath("(//h4/../div[@class='text-body-copy'])[2]")).shouldHave(text("Watford\n" +
                " North London\n" +
                " Zone 1"));*/

    }

    public void verificationDataProfileMatching(String percent) {
        $(byXpath("//ul[starts-with(@class,'nav dashboard')]")).shouldHave(text("User Type\n" +
                "Personal Details\n" +
                "Property Preferences\n" +
                "Budget & Availability\n" +
                "Your ideal flatmate"));
        $(byXpath("//div[starts-with(@class,'circularProgress__value')]")).shouldHave(text("\n" +
                "                                        " + percent + "\n" +
                "                                        "));
        $(byXpath("//div[starts-with(@class,'col-sm-8')]")).getText().contentEquals("About me\n" +
                "Tell us about yourself\n" +
                "Maximum budget: "+"1250/month\n" +
                "Ready to move in: 08-08-2019\n" +
                "Looking for a room in\n" +
                "Watford");
    }

    public void verifyNoProperty() {
        refresh();
        $(byXpath("(//ul[starts-with(@class, 'nav navbar-nav')]/li)[1]")).shouldHave(text("Add a Listing"));
        $(byXpath("//h2[@class='u_m0 u_m20-bottom text-24 u_ef-left-sm']")).shouldHave(text("My Listings"));
        $(byXpath("//section/div[@class='container']")).shouldNotHave((text("Complete your listing now!")));
        sleep(2000);
        if ($(byXpath("//section/div[@class='container']")).has((text("London SE1, UK")))){
            $(byXpath("//button[starts-with(@class,'btn btn-primary-outline')]")).waitUntil(appear, 10000).click();
            $(byXpath("(//input[1][@type='radio'])[1]")).waitUntil(appear, 5000).selectRadio("0");
            $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).waitUntil(Condition.appears, 4000).click();
            sleep(4000);
        }
    }

    public void verifyNoPropertyPending() {
        refresh();
        $(byXpath("(//ul[starts-with(@class, 'nav navbar-nav')]/li)[1]")).shouldHave(text("Add a Listing"));
        $(byXpath("//h2[@class='u_m0 u_m20-bottom text-24 u_ef-left-sm']")).shouldHave(text("My Listings"));
        $(byXpath("//section/div[@class='container']")).shouldNotHave((text("Complete your listing now!")));
        sleep(2000);
        if ($(byXpath("//section/div[@class='container']")).has((text("London SE1, UK")))){
            $(byXpath("//button[starts-with(@class,'btn btn-default')]")).waitUntil(appear, 10000).click();
            $(byXpath("(//input[1][@type='radio'])[1]")).waitUntil(appear, 4000).selectRadio("0");
            $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).waitUntil(Condition.appears, 5000).click();
            sleep(4000);
        }
    }

    public void verifyPackagePurchase(String text) {
            $(byXpath("//div[@class='text-body-copy u_m20-top-md']/p[1]")).shouldHave(text(text));
    }

    public void verifyPackagePurchaseList(String text) {
        $(byXpath("//h2[@class='h3 u_m0-top text-normal-weight']")).shouldHave(text(text));
    }
    public void verifyPackageCanceled(String text) {
        $(byXpath("//div[@class='text-body-copy u_m20-top-md']/p[2]")).shouldHave(text(text));
    }

    //span[contains(text(), 'This email address has already been taken.')]
    public void emailAlreadyExistedAlert() {
        $(byXpath("//div[@class='form-group field-yourinfosignupform-email required has-error']/div[@class='help-block']")).shouldHave(text("This email address already has an Ideal Flatmate account"));
    }

    public void emailAlreadyExistedAlertMessage() {
        $(byXpath("//div[@class='form-group field-yourinfoadditionalsignupform-email required has-error']/div[@class='help-block']")).shouldHave(text("This email address already has an Ideal Flatmate account"));
    }

    public void passwWrongAlertHome() {
        //sleep(2000);
        $(byXpath("//label[contains(text(), 'Your password')]/../div")).waitUntil(exist, 4000).shouldHave(text("Incorrect email or password."));
    }

    public void nameFirstBlankAlert() {
        $(byXpath("//div[@class='form-group required u_m15-bottom field-yourinfosignupform-username required has-error']/div[@class='help-block']")).waitUntil(exist, 10000).shouldHave(text("Username cannot be blank."));
    }

    public void nameFirstBlankAlertMessage() {
        $(byXpath("//div[@class='form-group required u_m15-bottom field-yourinfoadditionalsignupform-username required has-error']/div[@class='help-block']")).waitUntil(exist, 10000).shouldHave(text("Username cannot be blank."));
    }
    public void nameFirstBlankAlertPhone() {
        $(byXpath("//div[@class='form-group required u_m15-bottom field-yourinfofullsignupform-username required has-error']/div[@class='help-block']")).waitUntil(exist, 10000).shouldHave(text("Username cannot be blank."));
    }

    public void emailBlankAlert() {
        $(byXpath("//div[@class='form-group field-yourinfosignupform-email required has-error']/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Email cannot be blank."));
    }

    public void emailBlankAlertMessage() {
        $(byXpath("//div[@class='form-group field-yourinfoadditionalsignupform-email required has-error']/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Email cannot be blank."));
    }

    public void emailBlankAlertPhone() {
        $(byXpath("//div[@class='form-group field-yourinfofullsignupform-email required has-error']/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Email cannot be blank."));
    }
    public void emailBlankAlertMessageLike() {
        $(byXpath("//div[@class='form-group field-yourinfosignupform-email required has-error']/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Email cannot be blank."));
    }



    public void genderBlankAlert() {
        $(byXpath("//div[@class='form-group field-yourinfosignupform-gender required has-error']/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Gender cannot be blank."));
    }

    public void genderBlankAlertMessage() {
        $(byXpath("//div[@class='form-group field-yourinfoadditionalsignupform-gender required has-error']/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Gender cannot be blank."));
    }

    public void genderBlankAlertPhone() {
        $(byXpath("//div[@class='form-group field-yourinfofullsignupform-gender required has-error']/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Gender cannot be blank."));
    }

    public void passwordBlankAlert() {
        $(byXpath("//div[@class='form-group field-yourinfosignupform-password required has-error']/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Password cannot be blank."));

    }

    public void passwordBlankAlertMessage() {
        $(byXpath("//div[@class='form-group field-yourinfoadditionalsignupform-password required has-error']/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Password cannot be blank."));

    }

    public void passwordBlankAlertPhone () {
        $(byXpath("//div[@class='form-group field-yourinfofullsignupform-password required has-error']/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Password cannot be blank."));

    }

    public void dateMonthYearPhoneOccupationBlankError() {
        $(byXpath("//div[select[@id='moreinfosignupform-day']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Day cannot be blank."));
        $(byXpath("//div[select[@id='moreinfosignupform-month']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Month cannot be blank."));
        $(byXpath("//div[select[@id='moreinfosignupform-year']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Year cannot be blank."));
        $(byXpath("//div[div/input[@id='moreinfosignupform-phone']]//div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Phone cannot be blank."));
        $(byXpath("//div[select[@id='moreinfosignupform-occupation_id']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Occupation Id cannot be blank."));
    }

    public void dateMonthYearPhoneOccupationBlankErrorMessage() {
        $(byXpath("//div[select[@id='yourinfoadditionalsignupform-day']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Day cannot be blank."));
        $(byXpath("//div[select[@id='yourinfoadditionalsignupform-month']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Month cannot be blank."));
        $(byXpath("//div[select[@id='yourinfoadditionalsignupform-year']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Year cannot be blank."));
        //$(byXpath("//div[div/input[@id='moreinfosignupform-phone']]//div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Phone cannot be blank."));
        //$(byXpath("//div[select[@id='moreinfosignupform-occupation_id']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Occupation Id cannot be blank."));
    }

    public void dateMonthYearPhoneOccupationBlankErrorPhone() {
        $(byXpath("//div[select[@id='yourinfofullsignupform-day']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Day cannot be blank."));
        $(byXpath("//div[select[@id='yourinfofullsignupform-month']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Month cannot be blank."));
        $(byXpath("//div[select[@id='yourinfofullsignupform-year']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Year cannot be blank."));
        $(byXpath("//div[input[@id='yourinfofullsignupform-phone']]/../div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Phone cannot be blank."));
    }

    public void checkLocationBlank() {
        $("div.error-summary ul li").shouldHave(text("Please choose location"));
    }

    public void budgetError() {
        $(byXpath("//div[input[@id='js-signup-budget-max']]/div[@class='help-block']")).shouldHave(text("Please choose minimum and maximum budget"));
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
        $(byXpath("(//label[contains(text(), 'First Name')])[1]/../p")).waitUntil(exist, 4000).shouldHave(text("Firstname cannot be blank."));
    }

    public void emailBlankAlertMatching() {
        sleep(2000);
        $(byXpath("(//label[contains(text(), 'Email address')])[1]/../p")).waitUntil(exist, 4000).shouldHave(text("Email cannot be blank."));
    }

    public void NameLastBlankAlertMatching() {
        $(byXpath("(//label[contains(text(), 'Last Name')])[1]/../p")).waitUntil(exist, 4000).shouldHave(text("Lastname cannot be blank."));
    }

    public void passwordBlankAlertMatching() {
        $(byXpath("(//label[contains(text(), 'Password')])[1]/../p[1]")).waitUntil(exist, 4000).shouldHave(text("Password cannot be blank."));

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

    public void noUpgradeToFasterReply() {
        $(byXpath("//div[@class='alert alert-warning text-center u_m0']")).shouldNot(exist);

    }
    public void noTextUpgradeToFasterReply() {
        $(byXpath("//div[@class='alert alert-warning text-center u_m0']")).shouldNot(exist);

    }

    public void messageGroup(String text) {
        $(byXpath("//select[@id='property-select']")).waitUntil(exist, 4000).shouldHave(text(text));
    }

    public void photoListingExist(){
        $(byXpath("//div[@class='owl-item active'][1]")).shouldBe(visible);
        $(byXpath("//div[@class='owl-item active'][2]")).shouldBe(visible);
        $(byXpath("//div[@class='owl-item active'][3]")).shouldBe(visible);

    }

    public void checkMatchingConcurrence(String matchScore) {

        if($(byXpath("//ul[@class='dropdown-menu']//a[@class='box-hide-overflow u_ed-block']/span[2]")).isDisplayed()) {
            $(byXpath("//ul[@class='dropdown-menu']//a[@class='box-hide-overflow u_ed-block']/span[2]")).waitUntil(exist, 4000).shouldHave(text(matchScore));
        } else {
            $("span.hidden-xs").click();
            $(byXpath("//ul[@class='dropdown-menu']//a[@class='box-hide-overflow u_ed-block']/span[2]")).waitUntil(exist, 4000).shouldHave(text(matchScore));
        }

    }

    public void checkPhoneAlert() {
        $(byXpath("(//div[input[@id='signup-need-phone']]/p)[1]")).waitUntil(exist, 4000).shouldHave(text("Phone cannot be blank."));
    }

    public void checkPhoneAlertMessage(String text) {
        $(byXpath("//div[@class='form-group required u_m30-bottom field-messagewritesignupform-phone " +
                "has-error']//div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text(text));
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

    public void closeMatchingPopup() {
        if ($(byXpath("//button[@class='btn btn-sm btn-close close js-close-notify-matching']")).is(exist)) {
            $(byXpath("//button[@class='btn btn-sm btn-close close js-close-notify-matching']")).waitUntil(appears, 8000).click();
            sleep(2000);
        }
    }

    public void paymentPage(String text) {
        $(byXpath("//h2[@class='text-20 u_m0-top']")).waitUntil(exist, 4000).shouldHave(text(text));
    }
    public void paymentPageWithoutListingLord(String text) {
        $(byXpath("//h2[@class='text-20 u_m0-top']")).waitUntil(exist, 4000).shouldHave(text(text));
    }

    public void chatPage() {
        $(byXpath("//textarea[@name='ConversationMessage[message]']")).waitUntil(exist, 4000).shouldBe(visible);
    }

    public void verifyAddListingPage() {
        $("h1.list-property-title.u_m0-top").shouldHave(text("Where is your property"));
    }

    public void verifySearchListingPage() {

        $(byXpath("//div[@class='price-range-filter selected']")).getText().contentEquals("200" + " - " + "1250");
        $(byXpath("//input[1]")).shouldHave(value("Watford"));
        $("#property-sort").waitUntil(exist, 20000).should(exist);

    }

    public void verifySearchListingPageMatching() {

        $(byXpath("//div[@class='price-range-filter selected']")).getText().contentEquals( "1200" + " - " + "1250");
        $(byXpath("//input[1]")).shouldHave(value("Watford"));
        $("#property-sort").waitUntil(exist, 20000).should(exist);

    }

    public void verifySearchFMPage() {
        $(byXpath("//h2[contains(.,'flatmates')]")).shouldNotHave(text("rooms"));

    }

    public void verificationFieldLenth(int widthOfField) {
       int p = $(byXpath("//input[@id='yourinfosignupform-email']")).getSize().getWidth();

        Assert.assertEquals(p, widthOfField);
    }


    public void phoneVerification(String phone, String text) {
        Field2("#moreinfosignupform-phone", phone);
        $(byXpath("//div[starts-with(@class,'form-group required u_m15-bottom')]//div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text(text));

    }

    public void profilePhoto10Mb() {
        $(byXpath("//div[starts-with(@class, 'upload-profile-photo u_ed-flex')]//div[@class='help-block']")).shouldHave(text("Sorry! " +
                "That image can’t be uploaded, please try a smaller image size (up to 8Mb)."));

    }
    public void profilePhotoPdf() {
        $(byXpath("//div[starts-with(@class, 'upload-profile-photo u_ed-flex')]//div[@class='help-block']")).shouldHave(text("Wrong" +
                " Extension"));

    }

    public void isHomePage() {
        title().contains("Flatshare and Houseshare Across the UK: ideal flatmate");

    }

    public void isHomePage1() {
        $(byXpath("//h1")).shouldHave(text("Clever matches.\n" +
                "Better flatshares."));

    }
    public void ListingStart() {
            $(byXpath("//h2[@class='u_m0 u_m20-bottom text-24 text-20-xs']")).waitUntil(visible, 4000).shouldHave(text("Start your listing here"));
    }



    public void isFMPage() {
        $(byXpath("//h2[@class='h4' and contains(.,' flatmate')]")).shouldBe(visible);
    }

    public void isPropertyPageLocation(String searchLocation) {

        String currentLocation = $(byXpath("//h1")).getText();
        Assert.assertEquals(currentLocation, searchLocation);
    }
    public void isPropertyPage() {

        title().contains("Find A Room To Rent In The UK | Ideal Flatmate");
    }

    public void PropertyPageNumber(String page) {

        String currentPage = $(byXpath("//a[@class='undefined']")).getText();
        Assert.assertEquals(page, currentPage);
    }

    public void verifyProfComplMenu(String profilePercent) {
        $(byXpath("(//a[@class='clearfix']/span)[2]")).shouldHave(text(profilePercent));

    }

    public void savedProperties(String referNumber) {
        String currentPage = $(byXpath("//div[@class='u_p0-left text-13']")).getText();
        Assert.assertEquals(referNumber, currentPage);

    }

    public void cardIsUnliked() {
        $(byXpath("(//div[@class='container'])[1]")).shouldNotHave(cssClass("div.u_p0-left.text-13"));



    }

    public void removeUnfinishedListing() {
        $(byXpath("//h2[@class='u_m0 u_m20-bottom text-24 u_ef-left-sm']")).shouldHave(text("My Listings"));
        $(byXpath("//section/div[@class='container']")).shouldHave((text("Complete your listing now!")));
        sleep(2000);
        if ($(byXpath("//section/div[@class='container']")).has((text("London SE1, UK")))) {
            $(byXpath("//button[@class='btn btn-default u_p0 btn-circle pull-right js-bring-cover listing-panel-delete u_bg-white']")).waitUntil(appear, 4000).click();
            $(byXpath("(//input[1][@type='radio'])[1]")).selectRadio("0");
            $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).click();
            sleep(5000);
            }
        }

    public void finishUnfinished() {
        $(byXpath("//a[contains(., 'Finish')]")).click();
        $(byXpath("//h1")).shouldHave(text("About your property"));
    }

    public void finishViewUnfinished() {
        $(byXpath("//a[contains(., 'View listing')]")).click();
        $(byXpath("//div[@class='col-xs-8 col-sm-8 u_p10-bottom']")).shouldHave(text(" 0 bedroom available"));
    }

    public void areaBlank() {
        $(byXpath("//div[select[@id='property-area_link_id']]/p")).shouldHave(text("Area cannot be blank."));

    }


    public void verifyPendingProperty() {
        $(byXpath("//div[@class='text-body-copy text-info pull-left']")).shouldHave(text("Your listing is pending."));
    }

    public void finishPendingProperty() {
        $(byXpath("//div//h1/../span")).shouldHave(text("Your listing is pending."));
    }

    public void areasNumberForSignUp() {
        sleep(3000);
        $(byXpath("//li[starts-with(@class,'js-area-limit')]")).shouldHave(text("Sorry, you can`t add more than 3 areas"));

    }

    public void FMBlogPage() {
        switchTo().window(1);
        $(byXpath("//section[@class='page-heading blog-splash']//div[@class=" +
                "'blog-hq-switch container']/a")).getText().contentEquals("You are a landlord? Head to our landlord HQ here");


    }

    public void landlordBlogPage() {

        switchTo().window(1);
        $(byXpath("//section[@class='page-heading blog-splash']//div[@class=" +
                "'blog-hq-switch container']/a")).getText().contentEquals("Are you a flatmate? Head to Flatmate HQ here");

    }


    public void sentRequestDetails() {
        $(byXpath("//div[@class='msg-body']/span")).shouldHave(text("Hi my name is LivOutListNewTrialI am Other and I would" +
                " like to know if the room is still available. Thank you!"));

    }//div[starts-with(@class,'label label-primary')]

    public void searchResultText(String text) {
        $(byXpath("//h1[@class='h4']")).shouldHave(text(text));

    }

    public void noSendDecline() {
        $(byXpath("//button[@class='btn-cancel']")).shouldNot(exist);
    }

    public void packageOnCard(String text, final String label) {
        $(byXpath("//div[@class='container']//div[@class='cover-panel u_bg-white u_m30-bottom u_b']//div[@class='label label-" + label + " listing-panel-label u_p5']")).shouldHave(text(text));
    }

    public void promoteCard() {
        $(byXpath("//a[contains(.,'Promote')]")).shouldHave(exist);
    }

    public void addingListFlowCity(String value) {
        $("input#property-city").shouldHave(value(value));
    }

    public void roadFor(String value) {
        $("input#property-route").shouldHave(value(value));
    }

    public void verifyTitleProperty(String text1) {
        $(byXpath("//h1[starts-with(@class,'h2 u_m0-top')]")).getText().contentEquals(text1);
    }
}