package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
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

        $(byXpath("//nav/a[@class]")).waitUntil(visible, 10000).shouldHave(text(SignUp));
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
        $(byXpath("(//div[@class='msg msg-sent'][last()]//span[last()])[2]")).shouldHave(Condition.text(text));
    }
    public void verifyPageMessage() {

        $(byXpath("//label[@for='safety-tip-confirm']//span")).click();

        $(byXpath("//textarea[@placeholder='Type your message here']")).waitUntil(visible, 4000).sendKeys("test message");
        $(byXpath("//a[@title='Send']")).waitUntil(visible, 4000).click();

        $(byXpath("//div[@class='ScrollbarsCustom-Content']//div[contains(text(),'Hey, looks like we are well matched. When are you looking to move?')]")).exists();
        $(byXpath("//div[@class='ScrollbarsCustom-Content']//div[contains(text(),'test message')]")).exists();


    }

    public void verifyPageMessageToFM() {

        $(byXpath("//label[@for='safety-tip-confirm']//span")).click();

        $(byXpath("//textarea[@placeholder='Type your message here']")).waitUntil(visible, 4000).sendKeys("test message");
        $(byXpath("//a[@title='Send']")).waitUntil(visible, 4000).click();

        $(byXpath("//div[@class='ScrollbarsCustom-Content']//div[contains(text(),'Hey, looks like we are well matched. When are you looking to move?')]")).exists();
        $(byXpath("//div[@class='ScrollbarsCustom-Content']//div[contains(text(),'test message')]")).exists();


    }

    public void verifyAddedProperty(String location) {

        $(byXpath("(//h2[@class='h3 u_m0-top text-info'])[1]")).waitUntil(visible, 4000).shouldHave(text(location));

    }

    public void verifyAddedPropertyWithAllFields(final String month, final String room1, final String room2, final String room3, final String listingAbout, final String location) {//section[@id]//h1/small

        String ref = $(byXpath("//section[@id]//h1/small")).getText();
        $(byXpath("//section[@id]//h1")).getText().contentEquals("3 bedrooms for rent in Bankside, South London from "+"500/month per room\n"
                 + ref);
        $(byXpath("//span[@class='property-phone_hide js-phone-box']")).shouldHave(text("\n" + "+44 2 XXXX"));

        verifyAddedPropertyNoRoom(listingAbout);

        $(byXpath("//div[@class='u_p10-bottom u_m30-bottom u_b-bottom']")).shouldHave(text(location));

        $(byXpath("//ul[@class='tabs-2']//a[contains(.,'Rooms')]")).click();

        roomVerification(room1, "£500", "£1,000", "£400", "Now", "", "", "7 months+", "Very comfortable room");
        roomVerification(room2, "£500", "£1,000", "£400", "Now", "", "", "7 months+", "Very comfortable room");
        roomVerification(room3, "£800", "", "", "15th ", month, " 2025", "", "");
    // $(byXpath("//h2[@class='h4 u_m20-top-xs u_m40-top-sm' and contains(text(), 'About this listing')]")).scrollIntoView(true);
}



    public void profileDisplays(ProfileData profileData) {
        if($(byXpath("//div[contains(@class,'circularProgress__value')]")).exists()){
            $(byXpath("//div[contains(@class,'circularProgress__value')]")).shouldHave(text(profileData.getPercentComplete()));}
        if($(byXpath("//ul[contains(@class,'nav dashboard-side-nav')]")).exists()){
            $(byXpath("//ul[contains(@class,'nav dashboard-side-nav')]")).shouldHave(text(profileData.getMyProfile()));}
        $(byXpath("//h2[contains(@class,'profile-info--name_age')]/strong")).shouldHave(text(profileData.getName()));
        if($(byXpath("//h2[contains(@class,'profile-info--name_age')]/span")).exists()){
            $(byXpath("//h2[contains(@class,'profile-info--name_age')]/span")).shouldHave(text(profileData.getAge()));}

        if($(byXpath("//strong[contains(@class,'u_ed-block')]")).exists()){
            $(byXpath("//strong[contains(@class,'u_ed-block')]")).shouldHave(text(profileData.getLookingFor()));
        }
        String about = $(byXpath("//div[contains(@class,'u_p30 u_bg-white')]")).text().replaceAll("£", "");
        Assert.assertEquals(about, profileData.getAboutMe().replaceAll("£", ""));

        if($(byXpath("//h4[contains(.,'My available rooms are ')]")).exists()){
            $(byXpath("//ul[contains(@class,'geo-list u_m0 u_p0')]")).shouldHave(text(profileData.getRoomsLocation()));
            collectionReturn("//ul[contains(@class,'geo-list u_m0 u_p0')]/li").shouldHaveSize(Integer.parseInt((profileData.getRoomsLocation())));
            cardsOnThePage().shouldHaveSize(Integer.parseInt((profileData.getAmountPropertiesCard())));

        }

    }
    public void profileDisplaysForEdit(ProfileData profileData, String moveInDate) {
        if($(byXpath("//div[contains(@class,'circularProgress__value')]")).exists()){
            $(byXpath("//div[contains(@class,'circularProgress__value')]")).shouldHave(text(profileData.getPercentComplete()));}
        if($(byXpath("//ul[contains(@class,'nav dashboard-side-nav')]")).exists()){
            $(byXpath("//ul[contains(@class,'nav dashboard-side-nav')]")).shouldHave(text(profileData.getMyProfile()));}
        $(byXpath("//h2[contains(@class,'profile-info--name_age')]/strong")).shouldHave(text(profileData.getName()));
        if($(byXpath("//h2[contains(@class,'profile-info--name_age')]/span")).exists()){
            $(byXpath("//h2[contains(@class,'profile-info--name_age')]/span")).shouldHave(text(profileData.getAge()));}

        if($(byXpath("//strong[contains(@class,'u_ed-block')]")).exists()){
            $(byXpath("//strong[contains(@class,'u_ed-block')]")).shouldHave(text(profileData.getLookingFor()));
        }
        String about = $(byXpath("//h4[contains(.,'Ready to move')]")).text();
        Assert.assertEquals(about, profileData.getAboutMe()+" "+moveInDate);

        if($(byXpath("//h4[contains(.,'My available rooms are ')]")).exists()){
            $(byXpath("//ul[contains(@class,'geo-list u_m0 u_p0')]")).shouldHave(text(profileData.getRoomsLocation()));
            collectionReturn("//ul[contains(@class,'geo-list u_m0 u_p0')]/li").shouldHaveSize(Integer.parseInt((profileData.getRoomsLocation())));
            cardsOnThePage().shouldHaveSize(Integer.parseInt((profileData.getAmountPropertiesCard())));

        }

    }



    public void verifyNoProperty() {
        refresh();
        //$(byXpath("(//ul[starts-with(@class, 'nav navbar-nav')]/li)[1]")).shouldHave(text("Add a Listing"));
        verifyNoUnfinishedProperty();
        verifyNoPropertyPending();

        if ($(byXpath("//section//div[@class='label label-default listing-panel-label u_p5']")).has((text("Free listing")))){
            $(byXpath("//button[starts-with(@class,'btn btn-primary-outline')]")).waitUntil(appear, 10000).click();
            $(byXpath("(//input[1][@type='radio'])[1]")).waitUntil(appear, 5000).selectRadio("0");
            $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).waitUntil(Condition.appears, 4000).click();
            sleep(4000);
        }
    }

    public static void verifyNoUnfinishedProperty() {
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
        //$(byXpath("(//ul[starts-with(@class, 'nav navbar-nav')]/li)[1]")).shouldHave(text("Add a Listing"));
        $(byXpath("//h2[@class='u_m0 u_m20-bottom text-24 u_ef-left-sm']")).shouldHave(text("My Listings"));
        //$(byXpath("//section/div[@class='container']")).shouldNotHave((text("Complete your listing now!")));
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

        $(byXpath("//select[@id='moreinfosignupform-occupation_id']")).selectOptionByValue("");
        $(byXpath("//div[select[@id='moreinfosignupform-occupation_id']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Occupation Id cannot be blank."));
    }

    public void dateMonthYearBlankErrorMessage() {
        dayMonthYearAlert();
        //$(byXpath("//div[div/input[@id='moreinfosignupform-phone']]//div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Phone cannot be blank."));
        //$(byXpath("//div[select[@id='moreinfosignupform-occupation_id']]/div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text("Occupation Id cannot be blank."));
    }



    public void dateMonthYearPhoneBlankErrorPhone() {
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

    public void paymentPageNotifUpgrade(String text) {
        $(byXpath("//h2[@class='text-18 u_m0-top u_m30-bottom']")).waitUntil(exist, 4000).shouldHave(text(text));
    }

    public void chatPage() {
        $(byXpath("//textarea[@name='ConversationMessage[message]']")).waitUntil(exist, 4000).shouldBe(visible);
    }

    public void verifyAddListingPage() {
        $("li.active a").shouldHave(text("Active"));
        $(byXpath("//li/a[contains(.,'Deactivated')]")).shouldHave((text("Deactivated")));
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


    public void phoneVerification(String text, final String phone) {
        SignUpHelper signUpHelper = new SignUpHelper();
        signUpHelper.profilePhone(phone);

        signUpHelper.clickYourInformationContinue();
        $(byXpath("//div[contains(@class,'form-group required u_m15-bottom')]//div[@class='help-block']")).waitUntil(exist, 4000).shouldHave(text(text));

    }

    public void profilePhoto10Mb() {
        $(byXpath("//div[starts-with(@class, 'upload-profile-photo u_ed-flex')]//div[@class='help-block']")).shouldHave(text("Sorry! " +
                "That image can’t be uploaded, please try a smaller image size (up to 8Mb)."));

    }
    public void profilePhotoPdf() {
        $(byXpath("//div[starts-with(@class, 'upload-profile-photo u_ed-flex')]//div[@class='help-block']")).shouldHave(text("Wrong" +
                " Extension"));

    }

    public void isHomePage(final String textTitle) {
        title().contains(textTitle);

    }

    public void isHomePage1() {
        $(byXpath("//h1")).shouldHave(text("Clever matches.\n" +
                "Better flatshares."));

    }

    public void isResetSuccessful() {
        $(byXpath("//p[@class='text-success']/span")).shouldHave(text("Check your email for further instructions"));

    }
    public void ListingStart(final String text) {
            $(byXpath("//h2[@class='u_m0 u_m20-bottom text-24 text-20-xs']")).waitUntil(visible, 4000).shouldHave(text(text));
    }



    public void isFMPage() {
        $(byXpath("//h1[@class='h4' and contains(.,'Find Flatmates')]")).shouldBe(visible);
    }

    public void isPropertyPageLocation(String searchLocation) {

        String currentLocation = $(byXpath("//h1")).getText();
        Assert.assertEquals(currentLocation, searchLocation);
    }
    public void isPropertyPage() {

        isHomePage("Find A Room To Rent In The UK | Ideal Flatmate");
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

        if ($(byXpath("//section//div[@class='text-body-copy text-info pull-left']")).has((text("Complete your listing now!")))) {
            $(byXpath("//button[@class='btn btn-default u_p0 btn-circle pull-right js-bring-cover listing-panel-delete u_bg-white']")).waitUntil(appear, 4000).click();
            $(byXpath("(//input[1][@type='radio'])[1]")).selectRadio("0");
            $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).click();
            sleep(3000);
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

    public static void areaBlank(final String errorMessage) {
        $(byXpath("//div[select[@id='property-area_link_id']]/p")).shouldHave(text(errorMessage));

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
        $(byXpath("//div[@class='container']//div[@class='label label-" + label + " listing-panel-label u_p5']")).shouldHave(text(text));
    }

    public void promoteCard() {
        $(byXpath("//a[contains(.,'Promote')]")).shouldHave(exist);
    }

    public void addingListFlowCity(String value) {
        $("input#property-city").shouldHave(value(value));
    }

    public void addingListFlowArea(String value) {
        $(byXpath("//select[@id='property-area_link_id']/option[contains(.,'"+value+"')]")).shouldBe(selected);
    }

    public void roadFor(String value) {
        $("input#property-route").shouldHave(value(value));
    }

    public void verifyTitleProperty(String text1) {
        $(byXpath("//h1[starts-with(@class,'h2 u_m0-top')]")).getText().contentEquals(text1);
    }

    public void verifyAboutProperty(String aboutListing) {
        $(byXpath("//div[@id='property_about']/div[@class='row']")).shouldHave(text(aboutListing));
    }

    public void verifyAboutPropertyRooms(String aboutListing) {
        $(byXpath("//div[@id='property_about']/div[@class='u_m20-top']")).shouldHave(text(aboutListing));
    }

    public void verifyAddedPropertyWithAllFieldsCouple(String listingAbout) {

        verifyAddedPropertyRooms(listingAbout);

    }

    public void verifyAddedPropertyRooms(String listingAbout) {

        verifyAboutProperty(listingAbout);

    }

    public void verifyAddedPropertyNoRoom(final String listingAbout) {

        verifyAddedPropertyWithAllFieldsCouple(listingAbout);

    }

    public void signUpPopupName(String text) {
        $(byXpath("//h1")).shouldHave(text(text));

    }
    public void noConverInbox(String text) {
        $(byXpath("//h1")).shouldHave(text(text));

    }

    public void textNoGroup(String text) {
        sleep(2000);
        $(byXpath("//h2[contains(@class,'box-info')]")).shouldHave(text(text));
    }

    public void nameUserInGroup(String name, int userInGroup) {
        $$(byXpath("//div[@id='js-groups-list']//div//div[@class='text-12 hunters-list--username']")).get(userInGroup).shouldHave(text(name));
    }

    public void buddy_upGroup() {

    }

    public void isNotActive(final String propertyID) {

        if($(byXpath("//div[@id='listing-" + propertyID + "']//a[contains(.,'here ')]")).isDisplayed()){
            $(byXpath("//div[@id='listing-" + propertyID + "']//a[contains(.,'here ')]")).click();
            sleep(2000);
        }

    }

    public void roomVerification(final String roomNumber, final String roomPrice,final String deposit, final String bills,
                    String dateNumber, String month, String yearNumber, String lenthOfStay, String descriptionOfRoom) {
        String room = "//span[contains(.,'"+roomNumber+"')]/../..//";

        if($(byXpath(room+"div[@class='col-xs-4 u_p0-left']")).exists()){
            $(byXpath(room+"div[@class='col-xs-4 u_p0-left']")).shouldHave(text(roomPrice + "\n" +   "month")); }

        if($(byXpath(room+"div[@class='col-xs-4']")).exists()){
            $(byXpath(room+"div[@class='col-xs-4']")).shouldHave(text("Deposit\n" + deposit)); }

        if($(byXpath(room+"div[@class='u_ed-block text-13']")).exists()){
            $(byXpath(room+"div[@class='u_ed-block text-13']")).shouldHave(text(("Bills pcm\n" + bills)));  }

        if($(byXpath(room + "div[@class='col-xs-6 u_p0-right']")).exists()){
            $(byXpath(room + "div[@class='col-xs-6 u_p0-right']")).shouldHave(text("Length of Stay\n" +
                lenthOfStay));}

        if($(byXpath(room + "div[@class='clearfix u_m15-top']/p")).exists()){
            $(byXpath(room + "div[@class='clearfix u_m15-top']/p")).shouldHave(text(descriptionOfRoom));}

        if($(byXpath(room + "div[@class='col-xs-6 u_p0-left']")).exists()){
            $(byXpath(room + "div[@class='col-xs-6 u_p0-left']")).shouldHave(text(("Available from\n" + dateNumber+" " + month+" " + yearNumber)));
        }


    }

    public void noRoomVerification(final String roomNumber) {
        String room = "//span[contains(.,'"+roomNumber+"')]/../..//";

        $(byXpath("//ul[@class='tabs-2']//a[contains(.,'Rooms')]")).click();
        $(byXpath(room+"div[@class='col-xs-12 col-md-7']")).shouldNot(exist);
        $(byXpath(room + "div[@class='col-xs-6 u_p0-left']/strong")).shouldNot(exist);
        $(byXpath(room + "div[@class='col-xs-6 u_p0-right']")).shouldNot(exist);
        $(byXpath(room + "div[@class='clearfix u_m15-top']/p")).shouldNot(exist);
        $(byXpath(room + "div[@class='col-xs-6 u_p0-left']")).shouldNot(exist);
    }

    public void roomPriceNotif(final String tipsRent) {
        $(byXpath("//input[@id='room-price']/../../p[contains(@class,'help-block-error')]")).shouldHave(text(tipsRent));
    }

    public void matchingForLordIsHidden() {
        $(byXpath("//div[contains(@class,'card-matching ')]")).shouldNotBe(exist);
    }

    public void featuresOnTheCard() {
        List<String> featureProp = $$(byXpath("//div[starts-with(@class,'card-img--label')]/a/span")).texts();
        List<String> featurePropExpected = Arrays.asList("BILLS INCL.", "ZERO DEPOSIT", "GYM", "CONCIERGE", "STUDENT");
        Assert.assertEquals(featurePropExpected,featureProp);


    }

    public void notifSpamer(final String mesToSpamer) {

        $(byXpath("//div[@class='alert alert-danger']")).shouldHave(text(mesToSpamer));

    }

    public void profileHasMatching() {
        $(byXpath("//span[contains(@class,'btn u_ed-inline-block')]")).shouldHave(text("100% match"));

    }
}