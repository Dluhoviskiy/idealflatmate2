package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class SearchHelper extends HelperBase {

    public void searchProperty(String location) {

        $("input#property-location").waitUntil(visible, 4000).click();
        $("input#property-location").waitUntil(empty, 4000).setValue(location);
        sleep(2000);
        $(byXpath("//button[@class='btn btn-primary u_p60-left-sm u_p60-right-sm js-search-submit']")).waitUntil(visible, 10000).click();
    }

    public void searchPropertyByEnter(String location) {

        $("input#property-location").waitUntil(visible, 4000).click();
        $("input#property-location").waitUntil(empty, 10000).setValue(location);
        $(byXpath("//div[@class='ui-menu-item-wrapper' and contains(text(), 'Clapham, London')]")).waitUntil(exist, 4000).pressEnter();
        //$(byXpath("//button[@class='btn btn-primary u_p60-left-sm u_p60-right-sm js-search-submit']")).waitUntil(visible, 10000).click();
        //$(byText("COMPOSE")).click();
    }

    public void searchPropertyBySelectfromList(String location) {

        $("input#property-location").waitUntil(visible, 4000).click();
        $("input#property-location").waitUntil(empty, 10000).setValue(location);
        sleep(1000);
        $(byXpath("//div[@class='ui-menu-item-wrapper' and contains(text(), 'Clapham, London')]")).waitUntil(visible, 4000).click();

    }

    public void searchPropertyIncorrectFirstfromList(String location) {

        $("input#property-location").waitUntil(visible, 4000).click();
        $("input#property-location").waitUntil(empty, 10000).setValue(location).pressEnter();

    }

    public void verificationSearchFromHome(String location) {
        $(byXpath("//div[@class='row cards-container']")).waitUntil(visible, 4000).shouldHave(text(location));
    }
    public void verificationSearchFromHomeLocation(String location) {
        $(byXpath("//h1[@class='h3 u_m0-top u_m0-bottom']")).waitUntil(visible, 10000).shouldHave(text(location));
    }

    public void verificationSearchHomePage(String alert) {
        $(byXpath("//div[@class='js-no-location no-location u_p10-top text-center text-white']")).waitUntil(visible, 10000).shouldHave(text(alert));
    }

    public void verificationSearchFromHomeLocationProperty(String location) {
        $(byXpath("//div[@class='u_p10-bottom u_m30-bottom u_b-bottom']")).waitUntil(visible, 10000).shouldHave(text(location));
    }

    public void zone1() {
        $(By.xpath("//a[contains(text(), 'Zone 1')]")).click();
    }
    public void EastLDN1() {
        $(By.xpath("//a[contains(text(), 'East LDN')]")).click();
    }
    public void amountPropertyCards(int size) {

        $$(byXpath("//div[@class='row  cards-container']/div")).shouldHaveSize(size);
    }

    public void firstCardIsColivingAdv() {

        $$(byXpath("//div[@class='row  cards-container']/div")).first().shouldHave(text("Co-living,"));
        $(By.xpath("//a[contains(text(), 'View all co-living providers')]")).click();
        $(By.xpath("//h1[contains(text(), 'Co-living, the new renting')]")).exists();

    }
    public void colivingButton() {

        $(By.xpath("//a[contains(text(), 'NEW! View')]")).click();
        $(By.xpath("//h1[contains(text(), 'Co-living, the new renting')]")).exists();
    }
    public void colivingButtonOnFirstPage() {
        $(By.xpath("//a[contains(text(), 'NEW! View')]")).exists();
    }

    public void moveToPage(int pageNumberInd, String pageNumber) {
        $$("div ul li a").findBy(text(pageNumber)).click();
        sleep(2000);
        $$("ul.pagination li").get(pageNumberInd-1).shouldHave(cssClass("active"));


    }

    public void moveToFirstPage1(String page) {
        $$("div ul li a").findBy(exactText(page)).click();
        /*JavascriptExecutor jse;
        jse = (JavascriptExecutor)getWebDriver();
        jse.executeScript("document.getElementById('oauth-auth-forgot-link').click();");*/
    }

    public void moveToNext(int pageActiveInd) {
        $(By.xpath("//span[contains(text(), 'Next')]")).click();
        $$("ul.pagination li").get(pageActiveInd-1).shouldHave(cssClass("active"));
    }

    public void moveToPrevious(int pageActiveInd) {
        $(By.xpath("//span[contains(text(), 'Previous')]")).click();
        $$("ul.pagination li").get(pageActiveInd-1).shouldHave(cssClass("active"));
    }
    public void shouldHaveResultText (int pageActiveInd, String text) {
        $(By.xpath("//span[contains(text(), 'Previous')]")).click();
        $$("ul.pagination li").get(pageActiveInd-1).shouldHave(text(text));
    }


    public void clickAdvancedFilter() {
        $(By.xpath("//span[@class='advanced-filters-closed']")).click();

    }

    public void clickAvailablePlus(String text) {
        $(By.xpath("//div[contains(text(), 'Available bedrooms')]/..//button[@data-type='plus']")).click();
        clickAdvancedFilterApply();
        //$(By.xpath("//button[contains(text(), 'Rooms number: 2 ')]")).click();
        $(By.xpath("(//button[@class='btn btn-xs btn-gray'])[4]")).shouldHave(text(text));

    }

    public void cardsWith2roomsAvailable(int number, String text) {
        //$$(byXpath("//div[@class='col-xs-6 u_p0-right text-13 u_ea-right']")).shouldHaveSize(number).shouldHave(CollectionCondition.texts(text));
        $$(byXpath("//div[@class='col-xs-6 u_p0-right text-13 u_ea-right']")).shouldHaveSize(number);
        $$(byXpath("//div[@class='col-xs-6 u_p0-right text-13 u_ea-right']")).filterBy(textCaseSensitive(text)).shouldHaveSize(0);

    }


    public void clickApplyFilters() {
        $(By.xpath("//button[@class='btn btn-sm btn-primary js-submit']")).click();
    }

    public void active3Fiters(int numberFilters, String text1, String text2, String text3) {
        $$(byXpath("//button[@class='btn btn-xs btn-gray']")).shouldHaveSize(numberFilters);
        $(By.xpath("(//button[@class='btn btn-xs btn-gray'])[1]")).shouldHave(text(text1));
        $(By.xpath("(//button[@class='btn btn-xs btn-gray'])[2]")).shouldHave(text(text2));
        $(By.xpath("(//button[@class='btn btn-xs btn-gray'])[3]")).shouldHave(text(text3));
    }

    public void active7Fiters(int numberFilters, String text1, String text2, String text3, String text4, String text5, String text6, String text7) {
        $$(byXpath("//button[@class='btn btn-xs btn-gray']")).shouldHaveSize(numberFilters);
        $(By.xpath("(//button[@class='btn btn-xs btn-gray'])[1]")).shouldHave(text(text1));
        $(By.xpath("(//button[@class='btn btn-xs btn-gray'])[2]")).shouldHave(text(text2));
        $(By.xpath("(//button[@class='btn btn-xs btn-gray'])[3]")).shouldHave(text(text3));
        $(By.xpath("(//button[@class='btn btn-xs btn-gray'])[4]")).shouldHave(text(text4));
        $(By.xpath("(//button[@class='btn btn-xs btn-gray'])[5]")).shouldHave(text(text5));
        $(By.xpath("(//button[@class='btn btn-xs btn-gray'])[6]")).shouldHave(text(text6));
        $(By.xpath("(//button[@class='btn btn-xs btn-gray'])[7]")).shouldHave(text(text7));
    }

    public void clickAdvancedFilterApply() {
        $(By.xpath("//button[@class='btn btn-primary js-submit']")).click();
    }

    public void clickHighestPrice(int number) {
        $("select#property-sort").selectOption(number);


        ElementsCollection expectedNames = $$(byXpath("//div[@class='col-xs-6 u_p0-right text-13 u_ea-right']"));
      //  Collections.sort(expectedNames);
    }
}
