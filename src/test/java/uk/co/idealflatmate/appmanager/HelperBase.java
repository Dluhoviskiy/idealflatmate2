package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.url;
import static java.util.ResourceBundle.clearCache;
import static uk.co.idealflatmate.tests.TestBase.newDriverPage;


public class HelperBase  {

    public static void closeAdvPopUp() {
        String needSpace = "//div[@id='signupNeedspaceModal']//button[@aria-label='Close']";

        if ($(byXpath(needSpace)).is(visible)) {
            hoverClick(needSpace);
            sleep(2000);
        }
    }

    public static void closeListRenewPopUp() {
        sleep(2000);
        SelenideElement buttonRenew = $(byXpath("//section[@class='modal-content u_bg-gray-lighter']//button[@aria-label='Close']"));
        if(buttonRenew.isDisplayed()){
            buttonRenew.click();
        }
        sleep(2000);


    }

    public static void closeMatchPopUp() {

        if ($(byXpath("//button[@class='btn btn-sm btn-close close js-close-notify-matching']")).exists()) {
            $(byXpath("//button[@class='btn btn-sm btn-close close js-close-notify-matching']")).click();
            sleep(2000);
        } else {

        }
    }

    public static void closeButtonRenew() {
        $(byXpath("(//button[@aria-label='Close'])[2]")).click();
    }

    public static List<String> getFMcardSearchText() {
        return $$(byXpath("//div[@class='card-profile-text']")).texts();
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

            clearBrowserCache();
            refresh();
            close();
            open("https://www.idealflatmate.co.uk/");
        }

    }

   /* public static void pageUrlVerifLiveGoStage(){
        // проверить, что вы находитесь на верной странице

        if (! url().equals("http://front.idealflatmate4test.demo.devplatform2.com/")) {

            //clearBrowserCache();
            //refresh();
            //close();
            //open ("http://front.idealflatmate4test.demo.devplatform2.com/");

        }
    }*/

    public static void pageUrlVerifLiveGoStage(){
        // проверить, что вы находитесь на верной странице

        if (! url().equals("http://front.idealflatmate4test.demo.devplatform2.com/")) {
            newDriverPage("http://front.idealflatmate4test.demo.devplatform2.com");
            //clearBrowserCache();
            //refresh();
            //close();
            //open ("http://front.idealflatmate4test.demo.devplatform2.com/");

        } else{}
    }


    public void closeOpen(String relOrAbsolUrl) {
        clearCache();
        close();
        open(relOrAbsolUrl);
    }

    public  void pageUrlVerifStageGoLive1(){
        // проверить, что вы находитесь на верной странице
        if (! url().equals("https://www.idealflatmate.co.uk/")) {
            newDriverPage("https://www.idealflatmate.co.uk/");
           // clearBrowserCache();
           // refresh();
           // close();
           // open("https://www.idealflatmate.co.uk/");
        }
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
        location1.setValue(location);
        sleep(1000);


    }
}
