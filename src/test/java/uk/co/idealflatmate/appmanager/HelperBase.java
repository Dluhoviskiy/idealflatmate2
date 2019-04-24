package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;
import java.util.List;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.url;
import static java.util.ResourceBundle.clearCache;
import static uk.co.idealflatmate.tests.TestBase.newPage;


public class HelperBase  {



    public static void closeAdvPopUp() {
        String needSpace = "//div[@id='signupNeedspaceModal']//button[@aria-label='Close']";

        if ($(byXpath(needSpace)).is(visible)) {
            hoverClick(needSpace);
            sleep(2000);
        }

        if ($(byXpath(needSpace)).isDisplayed()) {
            hoverClick(needSpace);
            sleep(2000);
        }

    }

    public static void closeListRenewPopUp() {
        SelenideElement buttonRenew = $(byXpath("//section[@class='modal-content u_bg-gray-lighter']//button[@aria-label='Close']"));
        sleep(5000);
        if(buttonRenew.isDisplayed()){
            buttonRenew.waitUntil(visible, 7000).click();
        }
    }

    public static void propertySortBy(String value) {
        $("#property-sort").selectOptionContainingText(value);
    }

    public static void closeMatchPopUp() {
        SelenideElement buttonMatch = $(byXpath("//button[@class='btn btn-sm btn-close close js-close-notify-matching']"));
        sleep(2000);
        if (buttonMatch.isDisplayed()) {
            buttonMatch.waitUntil(visible, 7000).click();
        }
    }

    public static void closeButtonRenew() {
        $(byXpath("(//button[@aria-label='Close'])[2]")).click();
    }

    public static List<String> getFMcardSearchText() {
        return $$(byXpath("//div[@class='card-profile-text']")).texts();
    }

    public static List<String> getCardUserType() {

        return $$(byXpath("//div[@class='card-profile-text']/span[@class='card-top-username u_ed-block text-11 text-muted']")).texts();

    }



    public static List<String> getCardUserSelectLabel() {

        return $$(byXpath("//div[@class='card-matching text-uppercase text-12 text-center u_bg-orange']")).texts();

    }
    public static void scrollDownPageOn(final String points) {
        executeJavaScript("scrollBy(0," + points + ")");
    }



    public void fillInField(String text, SelenideElement selElem) {
        sleep(1000);

        selElem.waitUntil(visible, 20000).click();
        selElem.waitUntil(visible, 20000).clear();
        sleep(1000);
        selElem.waitUntil(visible, 20000).setValue(text);
    }
    protected void fillInField1(String Number, SelenideElement selElem1, SelenideElement selElem2) {
        selElem1.waitUntil(visible, 20000).click();
        selElem2.waitUntil(visible, 20000).clear();
        sleep(1000);
        selElem2.waitUntil(visible, 20000).setValue(Number);

    }

    public void gmailLogin(String text, String field, String next) {
        $(byXpath(field)).waitUntil(appears, 4000).click();
        $(byXpath(field)).waitUntil(appears, 4000);
        $(byXpath(field)).shouldBe(visible);
        $(byXpath(field)).setValue(text);
        $(byXpath(next)).click();
        sleep(2000);
    }



    public void toHomePage() {
        //$(By.xpath("//a[@class='navbar-brand']")).click();
        open("http://front.idealflatmate4test.demo.devplatform2.com/");

    }

    public void Field2(String locator, String phone) {
        $(locator).click();
        $(locator).clear();
        $(locator).setValue(phone);
    }

    public void FieldEnter(String text, SelenideElement string1, SelenideElement string2) {
        string1.click();
        string1.clear();
        string1.setValue(text);
        sleep(1000);
        string2.click();
    }

    public void dateMonthYear(String day, String month, String year, SelenideElement day1, SelenideElement month1, SelenideElement year1) {
        day1.selectOptionByValue(day);
        month1.click();
        month1.selectOptionByValue(month);
        year1.click();
        year1.selectOptionByValue(year);
    }


    public static void pageUrlVerifStageGoLive(){
        // проверить, что вы находитесь на верной странице
        if (! url().equals("https://www.idealflatmate.co.uk/")) {

            newPage("https://www.idealflatmate.co.uk/");
        }

    }


    public static void pageUrlVerifLiveGoStage(){
        // проверить, что вы находитесь на верной странице

        if (! url().equals("http://front.idealflatmate4test.demo.devplatform2.com/")) {
            sleep(1000);
            newPage("http://front.idealflatmate4test.demo.devplatform2.com");
            String currentUrl = url();
            System.out.println(currentUrl);
        }
    }


    public void closeOpen(String relOrAbsolUrl) {
        clearBrowserCache();
        clearBrowserCookies();
        close();
        open(relOrAbsolUrl);
    }

    public static void hoverClick(String xpath) {
        SelenideElement elementHoverClick = $(byXpath(""+xpath+"")).waitUntil(visible, 10000);
        elementHoverClick.hover();
        elementHoverClick.click();
    }

    public void hoverCShouldExist(String xpath) {
        SelenideElement elementHoverClick = $(byXpath(""+xpath+"")).waitUntil(visible, 10000);
        elementHoverClick.hover();
        elementHoverClick.should(exist);
    }

    public void searchPropertyBy(String location, SelenideElement location1) {

        location1.waitUntil(visible, 10000).click();
        for (char  c : location.toCharArray()) {
            sleep(500);
            String s = String.valueOf(c);
            location1.sendKeys(s);
        }
        //location1.waitUntil(visible, 10000).click();
        sleep(1000);


    }

    public static void clickButton(final String textButton, final String byTag) {
        $(byXpath("//" + byTag + "[contains(.,'" + textButton + "')]")).click();
    }

    public static  ElementsCollection cardsOnThePage () {
        ElementsCollection cardsOnThePage = $$(byXpath("//div[@class='card-body clearfix']"));

        return cardsOnThePage;
    }

    public static  String postCodeFromCard(final String id_property) {
        String postCodeFromCard = $(byXpath("//div[@id='property_card_" + id_property + "']//div[@class='card-infos-left']/div")).text();

        return postCodeFromCard;
    }
}
