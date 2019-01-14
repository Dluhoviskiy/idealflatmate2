package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Condition.appears;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static com.codeborne.selenide.WebDriverRunner.url;
import static java.util.ResourceBundle.clearCache;

public class HelperBase {

    public static void closeAdvPopUp() {
        if ($(byXpath("(//button[@class='btn btn-sm close u_m15'])[1]")).is(visible)) {
            $(byXpath("(//button[@class='btn btn-sm close u_m15'])[1]")).click();
            sleep(2000);
        }
    }

    public static void closeListPopUp() {
        sleep(2000);
        if($(byXpath("//div[@id='renewAdvertModal']//button[@aria-label='Close']")).isDisplayed()){
            $(byXpath("//div[@id='renewAdvertModal']//button[@aria-label='Close']")).click();
        }
        sleep(2000);


    }

    public static void closeMatchPopUp() {

        if ($(byXpath("//button[@class='btn btn-sm btn-close close js-close-notify-matching']")).isEnabled()) {
            $(byXpath("//button[@class='btn btn-sm btn-close close js-close-notify-matching']")).click();
            sleep(2000);
        } else {}
    }

    public static void closeButtonRenew() {
        $(byXpath("(//button[@aria-label='Close'])[2]")).click();
    }

    public static List<String> getFMcardSearchText() {
        return $$(byXpath("//div[@class='card-profile-text']")).texts();
    }

    public void fillInField(String text, SelenideElement $, SelenideElement selenideElement) {
        sleep(1000);
        selenideElement.waitUntil(visible, 20000).click();
        selenideElement.waitUntil(visible, 20000).clear();
        sleep(1000);
        selenideElement.waitUntil(visible, 20000).setValue(text);
    }

    public void gmailLogin(String text, String field, String next) {
        $(byXpath(field)).waitUntil(appears, 4000).click();
        $(byXpath(field)).waitUntil(appears, 4000);
        $(byXpath(field)).shouldBe(visible);
        $(byXpath(field)).setValue(text);
        $(byXpath(next)).click();
        sleep(2000);
    }

    protected void fillInField1(String nla, SelenideElement $, SelenideElement $1) {
    }

    public void toHomePage() {
        //$(By.xpath("//a[@class='navbar-brand']")).click();
        open("http://front.idealflatmate4test.demo.devplatform2.com/");
    }

    public void Field2(String locator, String locator2, String locator3, String text) {
        $(locator).click();
        $(locator2).clear();
        $(locator3).setValue(text);
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
            open("https://www.idealflatmate.co.uk/");}
    }

    public static void pageUrlVerifLiveGoStage(){
        // проверить, что вы находитесь на верной странице

        if (! url().equals("http://front.idealflatmate4test.demo.devplatform2.com/")) {

            clearBrowserCache();
            refresh();
            close();
            open("http://front.idealflatmate4test.demo.devplatform2.com/");}
    }


    public void closeOpen(String relOrAbsolUrl) {
        clearCache();
        close();
        open(relOrAbsolUrl);
    }

    public static void pageUrlVerifStageGoLive1(){
        // проверить, что вы находитесь на верной странице
        if (! url().equals("https://www.idealflatmate.co.uk/")) {

            clearBrowserCache();
            refresh();
            close();
            open("https://www.idealflatmate.co.uk/");}
    }
}
