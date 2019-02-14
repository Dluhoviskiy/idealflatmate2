package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class VerificationHelper extends HelperBase {

SelenideElement phoneAlert = $(byXpath("//div[contains(@class,'password')]/div[@class='help-block']"));
SelenideElement genderAlert = $(byXpath("//div[contains(@class,'gender')]/div[@class='help-block']"));
SelenideElement emailExistAlert = $(byXpath("//div[contains(@class,'email')]/div[@class='help-block']"));


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

        $(byXpath("(//h2[@class='h3 u_m0-top text-info'])[1]")).waitUntil(visible, 4000).shouldHave(text("London SE1, UK"));

    }

    public void verifyAddedPropertyWithAllFields(String month, final String room1, final String room2, final String room3) {//section[@id]//h1/small
        String roomNumber1 = "//strong/span[contains(.,'" + room1 + "')]/../..";
        String roomNumber2 = "//strong/span[contains(.,'" + room2 + "')]/../..";
        String roomNumber3 = "//strong/span[contains(.,'" + room3 + "')]/../..";

        String ref = $(byXpath("//section[@id]//h1/small")).getText();
        $(byXpath("//section[@id]//h1")).getText().contentEquals("3 bedrooms for rent in Bankside, South London from "+"500/month per room\n"
                 + ref);
        $(byXpath("(//span[@class='property-phone_hide js-phone-box'])[2]")).shouldHave(text("\n" + "+44 2 XXXX"));

        //$(byXpath("//div[@class='panel-heading']")).scrollTo();


        $(byXpath("//div[@id='property_about']/div[@class='row']")).shouldHave(text("3 of 4 bedrooms available\n" +
                "Garden\n" +
                "Communal living room\n" +
                "Balcony/patio\n" +
                "Parking space\n" +
                "Smokers accepted\n" +
                "Pets accepted\n" +
                "LGBT friendly\n" +
                "Trans friendly\n" +
                "Family friendly\n" +
                "Vegan household\n" +
                "Vegetarian household"));




        $(byXpath("//div[@class='u_p10-bottom u_m30-bottom u_b-bottom']")).shouldHave(text("London SE1, UK"));

        $(byXpath("//a[contains(.,'Rooms')]")).click();

        //$(byXpath("//strong/span[contains(.,'Room 1')]")).waitUntil(visible, 4000).shouldHave(text("Room 1\n" + "Room 2\n" + "Room 3\n"));
        $(byXpath(roomNumber1+"//div[@class='col-xs-12 col-md-7']")).getText().contentEquals("500\n" +
                "month\n" +
                "Deposit\n" +
                "1,000\n" +
                "Bills pcm\n" +
                "400\n");
        $(byXpath(roomNumber1+"//div[@class='col-xs-6 u_p0-left']/strong")).getText().contentEquals("Available from");

        $(byXpath(roomNumber1+"//div[@class='col-xs-6 u_p0-right']")).shouldHave(text("Length of Stay\n" +
                "minimum 1 month maximum 12 months"));

        $(byXpath(roomNumber1+"//div[@class='clearfix u_m15-top']/p")).shouldHave(text("Very comfortable room\n"));

        $(byXpath(roomNumber2+"/div")).click();

        $(byXpath(roomNumber2+"//div[@class='col-xs-12 col-md-7']")).getText().contentEquals("500\n" +
                "month\n" +
                "Deposit\n" +
                "1,000\n" +
                "Bills pcm\n" +
                "400\n");
        $(byXpath(roomNumber2+"//div[@class='col-xs-6 u_p0-left']")).getText().contentEquals("Length of Stay \n" +
                "minimum 1 month maximum 12 months");

        $(byXpath(roomNumber2+"//div[@class='clearfix u_m15-top']/p")).shouldHave(text("Very comfortable room\n"));


        $(byXpath(roomNumber3+"//div[@class='col-xs-12 col-md-7']")).getText().contentEquals("800\n" +
                "month");
        $(byXpath(roomNumber3+"//div[@class='col-xs-6 u_p0-left']")).shouldNotHave((text("Length of Stay\n" +
                "minimum 1 month maximum 12 months")));

        $(byXpath(roomNumber3+"//div[@class='col-xs-6 u_p0-left']")).getText().contentEquals("Available from\n" + "11th " + month + " 2025");
        // $(byXpath("//h2[@class='h4 u_m20-top-xs u_m40-top-sm' and contains(text(), 'About this listing')]")).scrollIntoView(true);
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
        $(byXpath("(//h4/../div[@class='text-body-copy'])[1]")).shouldHave(text(name + ", 60 is a female " +
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
        if ($(byXpath("//section//div[@class='label label-default listing-panel-label u_p5']")).has((text("Free listing")))){
            $(byXpath("//button[starts-with(@class,'btn btn-primary-outline')]")).waitUntil(appear, 10000).click();
            $(byXpath("(//input[1][@type='radio'])[1]")).waitUntil(appear, 5000).selectRadio("0");
            $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).waitUntil(Condition.appears, 4000).click();
            sleep(4000);
        }
    }

    public void verifyNoUnfinishedProperty() {
        refresh();
        $(byXpath("//h2[@class='u_m0 u_m20-bottom text-24 u_ef-left-sm']")).shouldHave(text("My Listings"));
        sleep(2000);
        if ($(byXpath("//section//div[@class='col-sm-7 col-lg-8']/div")).has((text("Complete your listing now!")))){
            $(byXpath("//button[starts-with(@class,'btn btn-default ')]")).waitUntil(appear, 10000).click();
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
        emailExistAlert.shouldHave(text("This email address already has an Ideal Flatmate account"));
    }

    public void passwWrongAlertHome() {
        //sleep(2000);
        $(byXpath("//label[contains(text(), 'Your password')]/../div")).waitUntil(exist, 4000).shouldHave(text("Incorrect email or password."));
    }

    public void nameFirstBlankAlert() {
        $(byXpath("//div[contains(@class,'username')]/div[@class='help-block']")).waitUntil(exist, 10000).shouldHave(text("Username cannot be blank."));
    }

    public void nameFirstBlankAlertMessage() {
        $(byXpath("//div[contains(@class,'username')]/div[@class='help-block']")).waitUntil(exist, 10000).shouldHave(text("Username cannot be blank."));
    }
    public void nameFirstBlankAlertPhone() {
        $(byXpath("//div[contains(@class,'username')]/div[@class='help-block']")).waitUntil(exist, 10000).shouldHave(text("Username cannot be blank."));
    }

    public void emailBlankAlert() {
        emailExistAlert.waitUntil(exist, 4000).shouldHave(text("Email cannot be blank."));
    }

    public void genderBlankAlert() {
        genderAlert.waitUntil(exist, 4000).shouldHave(text("Gender cannot be blank."));
    }

    public void passwordBlankAlert() {
        phoneAlert.waitUntil(exist, 4000).shouldHave(text("Password cannot be blank."));

    }

    public void dateMonthYearPhoneOccupationBlankError() {
        dayMonthYearAlert();
        $(byXpath("//div[contains(@class,'phone')]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Phone cannot be blank."));
        $(byXpath("//div[select[@id='moreinfosignupform-occupation_id']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Occupation Id cannot be blank."));
    }

    public void dateMonthYearPhoneOccupationBlankErrorMessage() {
        dayMonthYearAlert();
        //$(byXpath("//div[div/input[@id='moreinfosignupform-phone']]//div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Phone cannot be blank."));
        //$(byXpath("//div[select[@id='moreinfosignupform-occupation_id']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Occupation Id cannot be blank."));
    }



    public void dateMonthYearPhoneOccupationBlankErrorPhone() {
        dayMonthYearAlert();
        $(byXpath("//div[contains(@class,'phone')]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Phone cannot be blank."));
    }


    public void dayMonthYearAlert() {
        $(byXpath("//div[contains(@class,'day')]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Day cannot be blank."));
        $(byXpath("//div[contains(@class,'month')]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Month cannot be blank."));
        $(byXpath("//div[contains(@class,'year')]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Year cannot be blank."));
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

    public void checkPhoneAlertMessage(String text) {
        $(byXpath("//div[contains(@class,'phone has-error')]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text(text));
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
        $(byXpath("//div[@class='col-xs-6 col-sm-4 u_p10-bottom']")).shouldHave(text(" 0 bedroom available"));
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

    public void verifyAboutFields() {
        $(byXpath("//div[@id='property_about']/div[@class='row']")).shouldHave(text("3 of 4 bedrooms available"));
    }

    public void verifyAddedPropertyWithAllFieldsCouple() {

            $(byXpath("//div[@id='property_about']/div[@class='row']")).shouldHave(text("3 of 4 bedrooms available\n" +
                    "Garden\n" +
                    "Communal living room\n" +
                    "Balcony/patio\n" +
                    "Parking space\n" +
                    "Smokers accepted\n" +
                    "Suitable for couples\n" +
                    "Pets accepted\n" +
                    "LGBT friendly\n" +
                    "Trans friendly\n" +
                    "Family friendly"));

    }

    public void signUpPopupName(String text) {
        $(byXpath("//h1")).shouldHave(text(text));

    }
    public void noConverInbox(String text) {
        $(byXpath("//h1")).shouldHave(text(text));

    }

}