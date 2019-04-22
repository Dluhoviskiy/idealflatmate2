package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SearchHelper extends HelperBase {
    SelenideElement clearSearchBar = $(byXpath("//form[@id='search-location']//input"));

    public void searchPropertyHome(String location) {

        searchPropertyBy(location, $("input.react-autosuggest__input"));
        sleep(2000);

        //$(byXpath("//button[@class='text-20']")).waitUntil(visible, 10000).pressEnter();
        $("input.react-autosuggest__input").pressEnter();
    }

    public void searchPropertyHome1(String location) {

        String val = location;
        SelenideElement element = $("input.react-autosuggest__input");

        for (char  c : val.toCharArray()) {
            sleep(500);
            String s = String.valueOf(c);
            element.sendKeys(s);
        }

        element.pressEnter();
    }

    public void searchPropertyHomePostCode(String location) {

        searchPropertyBy(location, $("input.react-autosuggest__input"));
        sleep(2000);
        $(byXpath("(//div[@id='react-autowhatever-1']//span[contains(.,'"+location+"')])[1]")).click();
    }

    public void searchPropertyByEnter(String location) {

        searchPropertyBy(location, $("input.react-autosuggest__input"));
        $(byXpath("//input")).waitUntil(exist, 4000).pressEnter();


    }


    public void searchPropertyBySelectfromList(String location, final String nameDrop) {
        searchPropertyBy(location, $("input.react-autosuggest__input"));
        $(byXpath("//span[contains(.,'" + nameDrop + "')]")).waitUntil(visible, 4000).click();

    }



    public void searchPropertyIncorrectFirstfromList(String location) {

        searchPropertyBy(location, $("input.react-autosuggest__input"));

    }

    public void verificationSearchFromHome(String location) {
        $(byXpath("//div[@class='row cards-container']")).waitUntil(visible, 4000).shouldHave(text(location));
    }
    public void verificationSearchOnFMPage(String location) {
        $(byXpath("//h1[@class='h4']")).waitUntil(visible, 10000).shouldHave(text(location));
    }

    public static String getNumberOfListing() {
        String getNumberOfListing = String.valueOf($(byXpath("//h1[@class='h4']")).text().substring(0, 12).replaceAll("[^0-9]", ""));
        return getNumberOfListing;
    }

    public void verificationSearchProperty(String listingNumber) {

        $(byXpath("//h1[@class='h4']")).waitUntil(visible, 15000).shouldHave(text(listingNumber));
    }

    public void verificationSearchPropertyMap(String location) {
        $(byXpath("//div[@class='u_p10-bottom u_m30-bottom u_b-bottom']/p")).waitUntil(visible, 10000).shouldHave(text(location));

    }

    public void verificationSearchPropertyMes(String location, int IndexOfListing) {
        $$(byXpath("//div[@class='flex-search-columns']//div[@class='row u_m0 u_m5-top']")).get(IndexOfListing).waitUntil(visible, 30000).shouldHave(text(location));

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
        sleep(5000);
    }

    public void firstCardIsColivingAdv() {

        $$(byXpath("//div[@class='cards-container']/div")).first().waitUntil(visible, 25000).shouldHave(text("Select,"));
        $(By.xpath("//a[contains(text(), 'View all Select providers ')]")).click();
        $(By.xpath("//h2[contains(text(), 'Stunning homes, ')]")).exists();

    }
    public void colivingButton() {

        $(By.xpath("//a[contains(., 'View all Select providers ')]")).click();
        $(By.xpath("//h1[contains(text(), 'Select')]")).exists();
    }
    public void colivingButtonOnFirstPage(final String text) {
        $(By.xpath("//a[contains(., '" + text + "')]")).exists();
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

    public void clickAvailablePlus(String rooms) {
        //$(By.xpath("//div[contains(text(), 'Available bedrooms')]/..//button[@data-type='plus']")).click();

        $(By.xpath("//div[@class='bedrooms-filter ']")).click();
        $(By.xpath("//div[@class='form-group']/label[contains(.,'Rooms available in property')]/../select")).selectOptionContainingText(rooms);

        clickApply();
        //$(By.xpath("//button[contains(text(), 'Rooms number: 2 ')]")).click();
        //$(By.xpath("(//button[@class='btn btn-xs btn-gray'])[4]")).shouldHave(text(text));

    }

    public void cardsFilterVerification(int number, String text) {
        ElementsCollection rooms1 = $$(byXpath("//div[@class='text-13 u_p10']"));

        //$$(byXpath("//div[@class='col-xs-6 u_p0-right text-13 u_ea-right']")).shouldHaveSize(number).shouldHave(CollectionCondition.texts(text));
        rooms1.shouldHaveSize(number);
        rooms1.filterBy(textCaseSensitive(text)).shouldHaveSize(0);

    }


    public void clickApplyFilters() {
        $(By.xpath("//button[@class='btn btn-sm btn-primary js-submitLogin']")).click();
    }

    public void selectRadius(String radius) {

        SelenideElement radius1 = $(byXpath("//div[@class='radius-select-holder']"));
        radius1.click();
        $(byXpath("//div[@class='radius-select-holder']/select")).selectOptionContainingText(radius);
        sleep(3000);
        radius1.click();

    }

    public static void activeBudget() {

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

    public void activateRooms(String roomsAvailable, String roomsTotal) {
        SelenideElement selectAvailRoom = $(byXpath("//label[contains(.,'Rooms available in property')]/..//select[@class='form-control']"));
        SelenideElement selectTotalRoom = $(byXpath("//label[contains(.,'Total rooms in property')]/..//select[@class='form-control']"));

        $(byXpath("//div[@class='bedrooms-filter ']")).click();
        selectAvailRoom.click();
        selectAvailRoom.selectOptionContainingText(roomsAvailable);
        selectTotalRoom.click();
        selectTotalRoom.selectOptionContainingText(roomsTotal);
        clickApply();
    }

    public void activateIdealFM(String gender1, String suitableFor, final int fiterNumberIs) {
        activateIdealFM(fiterNumberIs);
        filterOptionClick(gender1);
        filterOptionClick(suitableFor);
        $(byXpath("//div[@class='noUi-handle noUi-handle-lower']")).dragAndDropTo($(byXpath("//span[contains(.,'"+suitableFor+"')]/../../../../div/label")));
        $(byXpath("//div[@class='noUi-handle noUi-handle-upper']")).dragAndDropTo($(byXpath("//span[contains(.,'Professionals and/or Students')]")));
        clickApply();
    }

    public void activateIdealFM( final int fiterNumberIs) {
        $(By.xpath("//div[@class='ideal-flatmate-filter ']")).click();
        $$(By.xpath("//div[@class='circle-btn-group']/label")).shouldHaveSize(fiterNumberIs);

    }

    public void clickMoreFilterVerify(String filter, int numberAboutFilters, String leaseLengthSelected, String addedTime) {
        SelenideElement lengthOfStay = $(By.xpath("//div[starts-with(@class, 'search-panel__more-cell')]//div[starts-with(@class, 'lease-length-filter')]//select[@class='form-control']"));
        SelenideElement propertyAdded = $(By.xpath("//div[starts-with(@class, 'search-panel__more-cell')]//div[starts-with(@class, 'property-added-filter')]//select[@class='form-control']"));
        moreFilterClick();
        filterOptionClick(filter);
        $$(By.xpath("//div[starts-with(@class,'search-panel__more-cell')]//label[@class='circle-button-with-text  ']/span")).shouldHaveSize(numberAboutFilters);
        $(byXpath("//label[@class='circle-button-with-text  active' and contains(.,'"+filter+"')]")).exists();
        lengthOfStay.click();
        lengthOfStay.selectOptionContainingText(leaseLengthSelected);
        propertyAdded.click();
        propertyAdded.selectOptionContainingText(addedTime);
        clickApply();
    }

    public void filterOptionClick(String filter) {
        $(By.xpath("//label[contains(.,'"+ filter +"')]")).click();
    }


    public void clickMyIdealFM_FilterTypeUserVerify(int numberTypes, int indexOfActiveFilter) {
        String userTypeActive = "(//div[@class='circle-btn-group'])[3]/label[@class='circle" +
                "-button-with-text active']";
        ElementsCollection userTypeIcon = $$(By.xpath("userTypeActive"));
        moreFilterClick();
        userTypeIcon.shouldHaveSize(numberTypes);
        if($(userTypeActive).exists()){userTypeIcon.get(indexOfActiveFilter).isEnabled();}

    }

    public void clickHighestPrice(int number) {
        $("select#property-sort").selectOption(number);


        ElementsCollection expectedNames = $$(byXpath("//div[@class='col-xs-6 u_p0-right text-13 u_ea-right']"));
      //  Collections.sort(expectedNames);
    }

    public void closePopupSignup() {

        sleep(4000);
        SelenideElement close1 = $(byXpath("//div[@id='signupNeedspaceModal']//button[@class='btn btn-sm close u_m15' and @aria-label='Close']"));

        if(close1.isDisplayed()){
            close1.click();}
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

        SelenideElement searchField = $(byXpath("//div[@class='search-location-form']//input"));
        //SelenideElement searchElastic = $(byXpath("//span[contains(.,'"+location1+"')]"));

        if(clearSearchBar.exists()){
            clearSearchBar.click();

        }
        sleep(3000);
        searchField.click();

        for (char  c : location.toCharArray()) {
            sleep(500);
            String s = String.valueOf(c);
            searchField.sendKeys(s);

        }

        searchField.pressEnter();


    }



    public void selectSearchPropPage(String location) {
        SelenideElement searchField = $(byXpath("//div[@class='search-location-form']//input"));
        //SelenideElement searchElastic = $(byXpath("//span[contains(.,'"+location1+"')]"));

        if(clearSearchBar.exists()){
            clearSearchBar.click();

        }
        sleep(3000);
        searchField.click();
        searchField.setValue(location);
        $(byXpath("//body//div//form//div[starts-with(@class,'react')]//li[@class='react-autosuggest__suggestion']//span[contains(.,'3')]")).click();

    }



    public void clearSearch() {
        $(byXpath("//form//span[@class='clear-location ']")).click();
        sleep(3000);

    }

    public void cardUserClick() {
        $(byXpath("//div[@class='card-profile-text']/span[@class='card-top-username']")).click();

    }

    public static void clickApply() {
        $(byXpath("//span[contains(.,'Apply')]")).click();

    }

    public void verifyClearMoreFilter(String activeFilter) {
        $(By.xpath("//div[@class='more-filters selected']")).click();
        $(By.xpath("//label[@class='circle-button-with-text  active']/span")).shouldHave(text(activeFilter));
        clearFilter();
        moreFilterClick();
        $(By.xpath("//label[@class='circle-button-with-text  ']/span[contains(.,'"+activeFilter+"')]")).should(exist);

    }



    public static int activeFiltersNumber() {
        int activeFiltersNumber = $$(By.xpath("//div[@class='search-panel hidden-xs']//span[@class='active-filters-count']")).size();
        return activeFiltersNumber;
    }

    public void numberOfActiveFilters(int size) {
        $$(By.xpath("//div[@class='container']//span[contains(@class,'active-filters-count')]")).shouldHaveSize(size);

    }
    public void activeFiltersIs(String activeFilterAre) {
        $(By.xpath("//label[contains(@class,' active')]")).shouldHave(text(activeFilterAre));

    }



    public void verifSearchHasNoLocation(String location) {
        sleep(3000);
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

    public void checkSort(String value) {

        List<String> sortDef1 = getFMcardSearchText();
        propertySortBy(value);
        sleep(4000);
        List<String> sortNew1 = getFMcardSearchText();
        Assert.assertNotEquals(sortNew1, sortDef1);
    }

    public void checkHighPriceSort(String option) {
        sleep(5000);

        List<String> sortDef2 = getFMcardSearchText();
        $("#property-sort").click();
        $(byId("property-sort")).selectOptionByValue(option);
        sleep(3000);
        List<String> sortNew2 = getFMcardSearchText();
        Assert.assertNotEquals(sortNew2, sortDef2);
        sleep(3000);
    }
    public void checkHighPriceSort1(String option) {
        sleep(5000);

        List<String> sortDef2 = $$(byXpath("//div[@class='card-profile-text']")).texts();
        System.out.println(sortDef2);
        Arrays.sort(new List[]{sortDef2});
        //Arrays.sort $$(byXpath("//div[@class='card-profile-text']")).texts();
        System.out.println(new List[]{sortDef2});
        //System.out.println(sortDef2);
        sleep(3000);
        //Assert.assertEquals(sortDef2, new List[]{sortDef2});
        //Arrays.sort(String {sortDef2});
        boolean isSorted = Ordering.natural().isOrdered(sortDef2);
        System.out.println(isSorted);
    }

    public void clearLocation() {
        clearSearchBar.click();


    }

    public void moreFilterClick() {
        $(By.xpath("//div[contains(@class,'more-filters ')]")).click();
    }


    public static List<String> cardsUserTypeAgent() {

        List<String> cardsUserType = Arrays.asList("We are a representing agency", "We are a representing agency",
                "We are a representing agency", "We are a representing agency", "We are a representing agency",
                "We are a representing agency", "We are a representing agency", "We are a representing agency",
                "We are a representing agency", "We are a representing agency", "We are a representing agency");
        return cardsUserType;
    }

    public static List<String> cardsUserTypeFlatmate() {

        List<String> cardsUserType = Arrays.asList("I live in the property", "I live in the property","I live in the property",
                "I live in the property","I live in the property","I live in the property",
                "I live in the property","I live in the property","I live in the property",
                "I live in the property","I live in the property");
        return cardsUserType;


    }
    public static List<String> cardsUserTypeLive_in() {
        List<String> cardsUserType = Arrays.asList("I own and live in the property", "I own and live in the property","I own and live in the property",
                "I own and live in the property","I own and live in the property","I own and live in the property",
                "I own and live in the property","I own and live in the property","I own and live in the property",
                "I own and live in the property","I own and live in the property");
        return cardsUserType;
    }

    public static List<String> cardsUserTypeLive_out() {
        List<String> cardsUserType = Arrays.asList("I own the property, but donʼt live here", "I own the property, but donʼt live here",
                "I own the property, but donʼt live here", "I own the property, but donʼt live here","I own the property, but donʼt live here",
                "I own the property, but donʼt live here", "I own the property, but donʼt live here","I own the property, but donʼt live here",
                "I own the property, but donʼt live here", "I own the property, but donʼt live here","I own the property, but donʼt live here");
        return cardsUserType;

    }

    public static List<String> cardsUserTypeSelect() {
        List<String> cardsUserType = Arrays.asList("Select provider", "Select provider",  "Select provider", "Select provider",
                "Select provider", "Select provider", "Select provider", "Select provider", "Select provider",
                "Select provider","Select provider");
        return cardsUserType;

    }

    public static List<String> cardsUserTypeSelectLabel() {
        List<String> cardsUserType = Arrays.asList("SELECT", "SELECT",  "SELECT", "SELECT","SELECT", "SELECT",
                "SELECT", "SELECT", "SELECT", "SELECT","SELECT");
        return cardsUserType;

    }

}

