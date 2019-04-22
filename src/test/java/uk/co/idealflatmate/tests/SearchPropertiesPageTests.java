package uk.co.idealflatmate.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import static org.seleniumhq.jetty7.util.LazyList.getList;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;
import static uk.co.idealflatmate.appmanager.HelperBase.*;
import static uk.co.idealflatmate.appmanager.SearchHelper.*;
//import static uk.co.idealflatmate.appmanager.TespageUrlVerifLiveGoStage;

public class SearchPropertiesPageTests extends TestBase{
    @BeforeMethod

    public void setupMethod() {
        pageUrlVerifLiveGoStage();
        clearCache();
        refresh();
        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
    }

    @Test
    public void propertySearchByDropDown() {


        searchHelper.closePopupSignup();
        cardsOnThePage().shouldHaveSize(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.firstCardIsColivingAdv();
        helperBase.toHomePage();

    }

    @Test
    public void searchPagination() {


        searchHelper.moveToPage(2, "2");
        cardsOnThePage().shouldHaveSize(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToPage(3, "3");
        cardsOnThePage().shouldHaveSize(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToNext(4);
        cardsOnThePage().shouldHaveSize(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToPrevious(3);
        cardsOnThePage().shouldHaveSize(11);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.colivingButton();
        helperBase.toHomePage();
    }

    @Test
    public void searchZone1Pagination() {

        searchHelper.zone1();
        searchHelper.colivingButton();
        helperBase.toHomePage();
    }

    @Test
    public void searchEastLDNPagination() {

        searchHelper.EastLDN1();
        searchHelper.firstCardIsColivingAdv();
        helperBase.toHomePage();
    }

    @Test
    public void applyMoreFilters() {

        searchHelper.activeFiltersNumber();

        searchHelper.clickMoreFilterVerify("Garden", 14, "1 month", "1 week ago");

        searchHelper.numberOfActiveFilters(1);
        searchHelper.verifyClearMoreFilter("Garden");
        Assert.assertEquals(0, activeFiltersNumber());
        helperBase.toHomePage();
    }
    @Test
    public void applyAdvancedFiltersDefault() {

        searchHelper.checkHighPriceSort("3");
        searchHelper.verifSearchHasNoLocation("London");
        searchHelper.clickSearchPropPage("London");
        searchHelper.verifSearchHasLocation("London");
        searchHelper.selectRadius("+20 km");

        Assert.assertEquals(0, activeFiltersNumber());

        searchHelper.activeBudget();
        searchHelper.checkSort("Top matched");

        searchHelper.activeAvailable();
        searchHelper.checkSort("Most recent");

        searchHelper.activateRooms("Studio","1 room");
        searchHelper.activateIdealFM("Male", "Student", 11);
        searchHelper.numberOfActiveFilters(4);

        searchHelper.clearActiveFiters();
        searchHelper.activeFiltersNumber();

        helperBase.toHomePage();
    }

    @Test
    void sortListing() {

        searchHelper.checkSort("Price low to high");
        searchHelper.checkSort("Default");
        searchHelper.checkSort("Most recent");
        searchHelper.checkSort("Price high to low");
        searchHelper.checkSort("Top matched");

        helperBase.toHomePage();
    }

    @Test
    public void sortListingWith2Rooms() {

        searchHelper.clickAvailablePlus("2 rooms to rent");
        // No "1 rooms available" after sorting
        searchHelper.cardsFilterVerification(11, "\n" + "1 room available\n" + " ");
        helperBase.toHomePage();
    }

    @Test
    public void sortListingByUserType() {

        searchHelper.activateIdealFM(11);

        //searchHelper.numberOfActiveFilters(1);
        //searchHelper.activeFiltersIs("All properties");

        searchHelper.filterOptionClick("Agencies");
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Agencies");
        clickApply();
        sleep(2000);
        Assert.assertEquals(getCardUserType(), cardsUserTypeAgent());

        searchHelper.clickMyIdealFM_FilterTypeUserVerify(5, 4);
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Agencies");

        searchHelper.filterOptionClick("Flatmates");
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Flatmates");
        clickApply();
        sleep(2000);
        Assert.assertEquals(getCardUserType(), cardsUserTypeFlatmate());

        searchHelper.clickMyIdealFM_FilterTypeUserVerify(5, 0);
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Flatmates");

        searchHelper.filterOptionClick("Live-in landlords");
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Live-in landlords");
        clickApply();
        sleep(2000);
        searchHelper.moveToPage(3, "3");

        Assert.assertEquals(getCardUserType(), cardsUserTypeLive_in());

        searchHelper.clickMyIdealFM_FilterTypeUserVerify(5, 1);
        searchHelper.filterOptionClick("Live-out landlords");
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Live-out landlords");
        clickApply();
        sleep(2000);
        searchHelper.moveToPage(3, "3");

        Assert.assertEquals(getCardUserType(), cardsUserTypeLive_out());

        searchHelper.moveToPage(1, "1");
        searchHelper.clickMyIdealFM_FilterTypeUserVerify(6, 2);
        searchHelper.filterOptionClick("Select");
        searchHelper.numberOfActiveFilters(1);
        searchHelper.activeFiltersIs("Select");
        clickApply();
        sleep(2000);

        Assert.assertEquals(getCardUserSelectLabel(), cardsUserTypeSelectLabel());
        Assert.assertEquals(getCardUserType(), cardsUserTypeSelect());

        searchHelper.moveToPage(1, "1");
        searchHelper.clickMyIdealFM_FilterTypeUserVerify(6, 4);
        searchHelper.filterOptionClick("Select");
        searchHelper.clickMyIdealFM_FilterTypeUserVerify(6, 0);

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
