package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class SearchFMPageTests extends TestBase{


    @Test(priority = 1)
    public void fmSearchBy() {

        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();
        searchHelper.amountPropertyCards(12);
        matchingHelper.closeTakeMatch();
        searchHelperFM.verifyMoreFilterActive();
        //searchHelperFM.verifyClearMoreFilter("");
        helperBase.toHomePage();

    }

    @Test(priority = 2)
    public void searchPagination() {

        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();

        searchHelper.moveToPage(2, "2");
        searchHelper.amountPropertyCards(12);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToPage(3, "3");
        searchHelper.amountPropertyCards(12);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToNext(4);
        searchHelper.amountPropertyCards(12);
        searchHelper.colivingButtonOnFirstPage("View all Select providers ");
        searchHelper.moveToPrevious(3);
        searchHelper.amountPropertyCards(12);

        helperBase.toHomePage();
    }


    @Test(priority = 3)
    public void applyMoreFilters() {

        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();

        searchHelper.numberOfActiveFilters(1);

        searchHelperFM.clickMoreFilterVerify("Looking for a room", "Has a room");

        searchHelper.numberOfActiveFilters(1);

        helperBase.toHomePage();
    }

    @Test(priority = 4)
    public void applyAdvancedFiltersDefault() {

        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();
        searchHelper.checkHighPriceSort();
        searchHelper.verifSearchHasNoLocation("London");
        searchHelper.clickSearchPropPage("London");
        searchHelper.verifSearchHasLocation("London");
        searchHelper.selectRadius("+10 km");

        searchHelper.activeBudget();
        searchHelper.checkDefaultTopMatch();

        searchHelper.activeAvailable();

        //searchHelperFM.activeGender("Studio","1 room");
        //searchHelper.activeAgeFM();
        //searchHelper.activeOccupationFM();
        searchHelper.numberOfActiveFilters(4);

        searchHelper.clearActiveFiters();
        searchHelper.noActiveFilters();

        helperBase.toHomePage();
    }

    @Test(priority = 7)
    public void sortListing() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.checkDefaultTopMatch();
        searchHelper.checkMostRecentSort();
        searchHelper.checkLowPriceSort();
        searchHelper.checkHighPriceSort();
        //searchHelper.clickAvailablePlus("Rooms number: 2 ");
        // No "1 rooms available" after sorting
        //searchHelper.cardsWith2roomsAvailable(11, "\n" + "1 rooms available\n" + " ");
        helperBase.toHomePage();
    }

    //@Test(priority = 7)
    public void sortListingWith2Rooms() {

        authorizationHelper.goToPropertyPage();
        searchHelper.closePopupSignup();
        searchHelper.clickAvailablePlus("Rooms number: 2 ");
        // No "1 rooms available" after sorting
        searchHelper.cardsWith2roomsAvailable(11, "\n" + "1 rooms available\n" + " ");
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
