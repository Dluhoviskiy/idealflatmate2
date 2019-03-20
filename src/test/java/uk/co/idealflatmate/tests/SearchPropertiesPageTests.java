package uk.co.idealflatmate.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
//import static org.seleniumhq.jetty7.util.LazyList.getList;
import static org.testng.Assert.assertEquals;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
//import static uk.co.idealflatmate.appmanager.TespageUrlVerifLiveGoStage;

public class SearchPropertiesPageTests extends TestBase{
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
    }

    @Test
    public void propertySearchByDropDown() {

        authorizationHelper.selectAllPropertyInMenu();
        searchHelper.closePopupSignup();
        searchHelper.amountPropertyCards(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.firstCardIsColivingAdv();
        helperBase.toHomePage();

    }

    @Test
    public void searchPagination() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.moveToPage(2, "2");
        searchHelper.amountPropertyCards(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToPage(3, "3");
        searchHelper.amountPropertyCards(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToNext(4);
        searchHelper.amountPropertyCards(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToPrevious(3);
        searchHelper.amountPropertyCards(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.colivingButton();
        helperBase.toHomePage();
    }

    @Test
    public void searchZone1Pagination() {
;
        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.zone1();
        searchHelper.colivingButton();
        helperBase.toHomePage();
    }

    @Test
    public void searchEastLDNPagination() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.EastLDN1();
        searchHelper.firstCardIsColivingAdv();
        helperBase.toHomePage();
    }

    @Test
    public void applyMoreFilters() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.noActiveFilters();

        searchHelper.clickMoreFilterVerify("Garden", 16, "1 month", "1 week ago");

        searchHelper.numberOfActiveFilters(1);
        searchHelper.verifyClearMoreFilter("Garden");
        searchHelper.noActiveFilters();
        helperBase.toHomePage();
    }
    @Test
    public void applyAdvancedFiltersDefault() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.checkHighPriceSort("3");
        searchHelper.verifSearchHasNoLocation("London");
        searchHelper.clickSearchPropPage("London");
        searchHelper.verifSearchHasLocation("London");
        searchHelper.selectRadius("+20 km");

        searchHelper.noActiveFilters();

        searchHelper.activeBudget();
        searchHelper.checkSort("Top matched");

        searchHelper.activeAvailable();
        searchHelper.checkSort("Most recent");

        searchHelper.activeRooms("Studio","1 room");
        searchHelper.activeIdealFM();
        searchHelper.numberOfActiveFilters(4);

        searchHelper.clearActiveFiters();
        searchHelper.noActiveFilters();

        helperBase.toHomePage();
    }

    @Test
    void sortListing() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.checkSort("Price low to high");
        searchHelper.checkSort("Default");
        searchHelper.checkSort("Most recent");
        searchHelper.checkSortHighPrice("3");//Price high to low
        searchHelper.checkSort("Top matched");
        //searchHelper.clickAvailablePlus("Rooms number: 2 ");
        // No "1 rooms available" after sorting
        //searchHelper.cardsWith2roomsAvailable(11, "\n" + "1 rooms available\n" + " ");
        helperBase.toHomePage();
    }

    @Test
    public void sortListingWith2Rooms() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.clickAvailablePlus("2 rooms to rent");
        // No "1 rooms available" after sorting
        searchHelper.cardsWith2roomsAvailable(11, "\n" + "1 room available\n" + " ");
        helperBase.toHomePage();
    }

    /*@Test(priority = 4)
    public void sortListingByBudget() {

        authorizationHelper.goToPropertyPage();
        helperBase.toHomePage();
        //Lowest budget
        searchHelper.clickHighestPrice(3);
        sleep(5000);

        int cardsBudgetText = 0;
        String[] texts = $$(String.format("div.card-infos-left", cardsBudgetText)).getTexts();



        Arrays.sort(texts);

        $$(String.format("div.card-infos-left", cardsBudgetText)).shouldHave(CollectionCondition.texts(texts));

       // searchHelper.verifySortingByBudget();
        helperBase.toHomePage();
    }*/
    /*@Test
    public void userCanSortProductsByNameinList()   {


        // get list with product names
        ArrayList expectedBudget = getList(java.util.Optional.of(".//*[@class='product-name']/a"));

        // sort() will return this list sorted in ascending order
        Collections.sort(expectedBudget);


        // get another list with product names
        ArrayList actualBudget = getList(".//*[@class='product-name']/a");

        // compare lists
        assertEquals(actualNames, expectedBudget, "Not sorted by name.");

    }*/


}
