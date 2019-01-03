package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SearchHelperFM extends HelperBase {

    public void searchProperty(String location) {

        $("input#property-location").waitUntil(visible, 4000).click();
        $("input#property-location").waitUntil(empty, 4000).setValue(location);
        sleep(2000);
        $(byXpath("//button[@class='js-search-submit text-20']")).waitUntil(visible, 10000).click();
    }

    public void searchPropertyByEnter(String location) {

        $("input#property-location").waitUntil(visible, 4000).click();
        $("input#property-location").waitUntil(empty, 10000).setValue(location);
        $(byXpath("//div[@class='ui-menu-item-wrapper' and contains(text(), 'Clapham, London')]")).waitUntil(exist, 4000).pressEnter();
        //$(byXpath("//button[@class='btn btn-primary u_p60-left-sm u_p60-right-sm js-search-submitLogin']")).waitUntil(visible, 10000).click();
        //$(byText("COMPOSE")).click();
    }

    public void searchPropertyBySelectfromList(String location) {

        $("input#property-location").waitUntil(visible, 4000).click();
        $("input#property-location").waitUntil(empty, 10000).setValue(location);
        sleep(1000);
        $(byXpath("//div[@class='ui-menu-item-wrapper' and contains(text(), 'Clapham Junction')]")).waitUntil(visible, 4000).click();

    }

    public void searchPropertyIncorrectFirstfromList(String location) {

        $("input#property-location").waitUntil(visible, 4000).click();
        $("input#property-location").waitUntil(empty, 10000).setValue(location).pressEnter();

    }

    public void verificationSearchFromHome(String location) {
        $(byXpath("//div[@class='row cards-container']")).waitUntil(visible, 4000).shouldHave(text(location));
    }
    public void verificationSearchOnFMPage(String location) {
        $(byXpath("//h2[@class='h4']")).waitUntil(visible, 10000).shouldHave(text(location));
    }

    public void verificationSearchProperty(String location) {
        $(byXpath("//h1[@class='h4']")).waitUntil(visible, 15000).shouldHave(text(location));
    }

    public void verificationSearchPropertyMap(String location) {
        $(byXpath("//div[@class='u_p10-bottom u_m30-bottom u_b-bottom']/p")).waitUntil(visible, 10000).shouldHave(text(location));
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
        $(By.xpath("//a[contains(text(), 'East London')]")).click();
    }
    public void amountPropertyCards(int size) {

        $$(byXpath("//div[@class='card-body clearfix']")).shouldHaveSize(size);
    }

    public void firstCardIsColivingAdv() {

        $$(byXpath("//div[@class='cards-container']/div")).first().waitUntil(visible, 15000).shouldHave(text("Select,"));
        $(By.xpath("//a[contains(text(), 'View all Select providers ')]")).click();
        $(By.xpath("//h2[contains(text(), 'Stunning homes, ')]")).exists();

    }
    public void colivingButton() {

        $(By.xpath("//a[contains(., 'View all Select providers ')]")).click();
        $(By.xpath("//h1[contains(text(), 'Select')]")).exists();
    }
    public void colivingButtonOnFirstPage() {
        $(By.xpath("//a[contains(., 'View all Select providers ')]")).exists();
    }

    public void moveToPage(int pageNumberInd, String pageNumber) {
        $$("div ul.pagination li a").findBy(text(pageNumber)).click();
        sleep(5000);

        $$("ul.pagination li").get(pageNumberInd).shouldHave(cssClass("active"));


    }

    public void moveToFirstPage1(String page) {
        $$("div ul li a").findBy(exactText(page)).click();
        /*JavascriptExecutor jse;
        jse = (JavascriptExecutor)getWebDriver();
        jse.executeScript("document.getElementById('oauth-auth-forgot-link').click();");*/
    }

    public void moveToNext(int pageActiveInd) {
        sleep(2000);
        $(By.xpath("//a[contains(text(), 'Next')]")).click();
        sleep(2000);
        $$("ul.pagination li").get(pageActiveInd).shouldHave(cssClass("active"));
    }

    public void moveToPrevious(int pageActiveInd) {
        sleep(2000);
        $(By.xpath("//a[contains(text(), 'Previous')]")).click();
        sleep(2000);
        $$("ul.pagination li").get(pageActiveInd).shouldHave(cssClass("active"));
    }
    public void shouldHaveResultText (int pageActiveInd, String text) {
        $(By.xpath("//a[contains(text(), 'Previous')]")).click();
        $$("ul.pagination li").get(pageActiveInd-1).shouldHave(text(text));
    }

    public void clickAvailablePlus(String text) {
        $(By.xpath("//div[contains(text(), 'Available bedrooms')]/..//button[@data-type='plus']")).click();
        clickApply();
        //$(By.xpath("//button[contains(text(), 'Rooms number: 2 ')]")).click();
        $(By.xpath("(//button[@class='btn btn-xs btn-gray'])[4]")).shouldHave(text(text));

    }

    public void cardsWith2roomsAvailable(int number, String text) {
        //$$(byXpath("//div[@class='col-xs-6 u_p0-right text-13 u_ea-right']")).shouldHaveSize(number).shouldHave(CollectionCondition.texts(text));
        $$(byXpath("//div[@class='col-xs-6 u_p0-right text-13 u_ea-right']")).shouldHaveSize(number);
        $$(byXpath("//div[@class='col-xs-6 u_p0-right text-13 u_ea-right']")).filterBy(textCaseSensitive(text)).shouldHaveSize(0);

    }


    public void clickApplyFilters() {
        $(By.xpath("//button[@class='btn btn-sm btn-primary js-submitLogin']")).click();
    }

    public void selectRadius(String radius) {
        $(byXpath("//div[@class='radius-select-holder']")).click();
        $(byXpath("//div[@class='radius-select-holder']/select")).selectOptionContainingText(radius);
        $(byXpath("//div[@class='radius-select-holder']")).click();
        sleep(5000);
    }

    public void activeBudget() {

        $(byXpath("//div[@class='price-range-filter ']")).click();
        $(byXpath("//div[@class='noUi-handle noUi-handle-lower']")).dragAndDropTo($(byXpath("//span[contains(.,'Clear')]")));
        $(byXpath("//div[@class='noUi-handle noUi-handle-upper']")).dragAndDropTo($(byXpath("//span[contains(.,'Apply')]")));
        clickApply();
    }

    public void activeAvailable() {
        $(byXpath("//div[@class='available-from-filter ']")).click();
        $(byXpath("//button[@class='react-calendar__navigation__arrow react-calendar__navigation__next-button']")).click();
        $(byXpath("//label[@for='react-calendar-check']")).click();
        clickApply();
    }

    public void activeRooms(String roomsAvailable, String roomsTotal) {
        $(byXpath("//div[@class='bedrooms-filter ']")).click();
        $(byXpath("//label[contains(.,'Rooms available in property')]/..//select[@class='form-control']")).click();
        $(By.xpath("//label[contains(.,'Rooms available in property')]/..//select[@class='form-control']")).selectOptionContainingText(roomsAvailable);
        $(By.xpath("//label[contains(.,'Total rooms in property')]/..//select[@class='form-control']")).click();
        $(By.xpath("//label[contains(.,'Total rooms in property')]/..//select[@class='form-control']")).selectOptionContainingText(roomsTotal);
        clickApply();
    }

    public void activeIdealFM() {
        $(By.xpath("//div[@class='ideal-flatmate-filter ']")).click();
        $$(By.xpath("//div[@class='circle-btn-group']/label")).shouldHaveSize(6);
        $(By.xpath("//span[contains(.,'Male')]")).click();
        $(By.xpath("//span[contains(.,'Student')]")).click();
        $(byXpath("//div[@class='noUi-handle noUi-handle-lower']")).dragAndDropTo($(byXpath("//span[contains(.,'Student')]/../../../../div/label")));
        $(byXpath("//div[@class='noUi-handle noUi-handle-upper']")).dragAndDropTo($(byXpath("//span[contains(.,'Freelancer/self employed')]")));
        clickApply();
    }

    public void clickMoreFilterVerify(String About, String AboutProp) {

        SelenideElement checkBox = $(byXpath("//label[@for='no-photo']/../input"));
        SelenideElement checkBoxClick = $(byXpath("//div[input[@id='no-photo']]"));
        SelenideElement moreFilter = $(By.xpath("//div[@class='flatmate-type-filter selected']"));
        List<String> hasList = $$(byXpath("//div[@class='card-profile-text']")).texts();

        moreFilter.click();
        $(By.xpath("//label[@class='circle-button-with-text active']/span[contains(., '"+About+"')]")).exists();
        $(By.xpath("//span[contains(.,'"+ AboutProp +"')]")).click();
        clickApply();

        sleep(2000);
        List<String> noList = $$(byXpath("//div[@class='card-profile-text']")).texts();
        Assert.assertNotEquals(hasList, noList);

        List<String> hasListWithoutPhoto = $$(byXpath("//div[@class='card-profile-text']")).texts();
        moreFilter.click();
        $(By.xpath("//label[@class='circle-button-with-text active']/span[contains(., '"+AboutProp+"')]")).exists();

        sleep(1000);
        checkBox.shouldNotBe(checked);
        sleep(1000);
        checkBoxClick.click();
        clickApply();
        sleep(1000);

        sleep(2000);
        List<String> noPhotoList = $$(byXpath("//div[@class='card-profile-text']")).texts();
        Assert.assertNotEquals(hasListWithoutPhoto, noPhotoList);

        moreFilter.click();
        sleep(1000);
        checkBox.shouldBe(checked);
        clearFilter();

        moreFilter.click();
        sleep(2000);
        checkBox.shouldNotBe(checked);
        $(By.xpath("//label[@class='circle-button-with-text active']/span[contains(., '"+About+"')]")).exists();

    }

    public void clickHighestPrice(int number) {
        $("select#property-sort").selectOption(number);


        ElementsCollection expectedNames = $$(byXpath("//div[@class='col-xs-6 u_p0-right text-13 u_ea-right']"));
      //  Collections.sort(expectedNames);
    }

    public void closePopupSignup() {

        if($(byXpath("//button[@class='btn btn-sm close u_m15' and @aria-label='Close']")).isDisplayed()){
            $(byXpath("//button[@class='btn btn-sm close u_m15' and @aria-label='Close']")).click();}
    }

    public void priceFilter() {
        $(byXpath("//div[@class='price-range-filter ']")).click();
    }
    public void priceFilterActive() {
        $(byXpath("//div[@class='container']//span[@class='active-filters-count']")).click();
    }
    public static void clearFilter() {
        sleep(2000);
        $(byXpath("//span[contains(.,'Clear')]")).click();

    }

    public void clickSearchPropPage(String location) {
        SelenideElement element = $(byXpath("//div[@class='search-location-form']//input"));
        element.click();
        element.clear();
        element.setValue(location);
        element.pressEnter();
        sleep(2000);

    }

    public void clearSearch() {
        $(byXpath("//form//span[@class='clear-location ']")).click();
        sleep(3000);

    }

    public void lastCardClick() {
        $(byXpath("(//div[@class='card-profile-text']/span[@class='card-top-username'])[6]")).click();

    }

    public static void clickApply() {
        $(byXpath("//span[contains(.,'Apply')]")).click();

    }

    public void verifyClearMoreFilter(String About) {

        $(By.xpath("//div[@class='flatmate-type-filter selected']//span[@class='active-filters-count']")).shouldBe(exist);
        $(By.xpath("//div[@class='more-filters selected']")).click();
        clearFilter();
        $(By.xpath("//div[@class='more-filters ']")).click();
        $(By.xpath("//label[@class='circle-button-with-text  ']/span[contains(.,'"+About+"')]")).should(exist);

    }



    public void noActiveFilters() {
        $(By.xpath("//div[@class='search-panel hidden-xs']//span[@class='active-filters-count']")).shouldNot(exist);
    }

    public void numberOfActiveFilters(int size) {
        $$(By.xpath("//div[@class='search-panel hidden-xs']//span[@class='active-filters-count']")).shouldHaveSize(size);
    }

    public void verifSearchHasNoLocation(String location) {

        $(byXpath("//h1[@class='h4' and contains(.,'"+location+"')]")).shouldNotBe(visible);
    }

    public void verifSearchHasLocation(String location) {

        $(byXpath("//h1[@class='h4' and contains(.,'"+location+"')]")).waitUntil(visible, 15000).should(exist);
    }


    public void clearActiveFiters() {
        $(byXpath("//div[@class='price-range-filter selected']")).click();
        clearFilter();
        $(byXpath("//div[@class='available-from-filter selected']")).click();
        clearFilter();
        $(byXpath("//div[@class='bedrooms-filter selected']")).click();
        clearFilter();
        $(By.xpath("//div[@class='ideal-flatmate-filter selected']")).click();
        clearFilter();
    }

    public void checkFMSearch() {
        sleep(3000);

        List<String> sortDef = $$(byXpath("//div[@class='card-profile-text']")).texts();
        sleep(3000);

        List<String> sortNew = $$(byXpath("//div[@class='card-profile-text']")).texts();
        Assert.assertNotEquals(sortDef, sortNew);
    }

    public void checkMostRecentSort() {
        sleep(3000);

        List<String> sortDef1 = $$(byXpath("//div[@class='card-profile-text']")).texts();
        $("#property-sort").selectOptionContainingText("Most recent");
        sleep(3000);
        List<String> sortNew1 = $$(byXpath("//div[@class='card-profile-text']")).texts();
        Assert.assertNotEquals(sortNew1, sortDef1);
    }

    public void checkLowPriceSort() {
        sleep(3000);

        List<String> sortDef2 = $$(byXpath("//div[@class='card-profile-text']")).texts();
        $("#property-sort").selectOptionContainingText("Price low to high");
        sleep(3000);
        List<String> sortNew2 = $$(byXpath("//div[@class='card-profile-text']")).texts();
        Assert.assertNotEquals(sortNew2, sortDef2);

    }

    public void checkHighPriceSort() {
        sleep(5000);

        List<String> sortDef2 = $$(byXpath("//div[@class='card-profile-text']")).texts();
        $("#property-sort").click();
        $(byId("property-sort")).selectOptionByValue("3");
        sleep(3000);
        List<String> sortNew2 = $$(byXpath("//div[@class='card-profile-text']")).texts();
        Assert.assertNotEquals(sortNew2, sortDef2);

    }

    public void verifyMoreFilterActive() {
        $(By.xpath("//div[@class='flatmate-type-filter selected']//span[@class='active-filters-count']")).shouldBe(exist);
    }
}
