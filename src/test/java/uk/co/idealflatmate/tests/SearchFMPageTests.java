package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class SearchFMPageTests extends TestBase{


  //  @Test
    public void fmSearchBy() {
        clearCache();
        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();
        searchHelper.amountPropertyCards(12);
        matchingHelper.closeTakeMatch();
        searchHelperFM.verifyMoreFilterActive();
        //searchHelperFM.verifyClearMoreFilter("");
        helperBase.toHomePage();

    }

  //  @Test
    public void searchPagination() {
        clearCache();
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


  //  @Test
    public void applyMoreFilters() {
        clearCache();
        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();

        searchHelper.numberOfActiveFilters(1);

        searchHelperFM.clickMoreFilterVerify("Looking for a room", "Has a room");

        searchHelper.numberOfActiveFilters(1);

        helperBase.toHomePage();
    }

  //  @Test
    public void applyMoreFiltersPhotoNoList() {
        clearCache();
        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();

        searchHelper.numberOfActiveFilters(1);

        searchHelperFM.clickMoreFilterVerifyPhotoListing("Looking for a room", "Has a room");

        searchHelper.numberOfActiveFilters(1);

        helperBase.toHomePage();
    }

   // @Test
    public void applyMoreFiltersPhotoWithList() {
        clearCache();
        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();

        searchHelper.numberOfActiveFilters(1);

        searchHelperFM.clickMoreFilterVerifyPhotoNoListing("Looking for a room");

        searchHelper.numberOfActiveFilters(1);

        helperBase.toHomePage();
    }

  //  @Test
    public void applyAdvancedFiltersDefault() {
        clearCache();
        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();
        searchHelper.checkHighPriceSort("7");
        //searchHelper.checkHighPriceSort1("7");
        searchHelperFM.verifSearchHasNoLocationFM("London");
        searchHelper.clickSearchPropPage("London");
        searchHelperFM.verifSearchHasLocationFM("London");
        searchHelper.selectRadius("+10 km");

        searchHelperFM.activeOccupationFM("Student");

        searchHelper.activeBudget();

        searchHelperFM.activeGender("Male");

        searchHelperFM.activeAgeFM();

        searchHelper.activeAvailable();

        searchHelper.numberOfActiveFilters(6);

        helperBase.toHomePage();
    }

   // @Test
    public void sortListingLoggedIn() {
        clearCache();
        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();
        authorizationHelper.login("FMMatchingSort@gmail.com","qqqqqq");
        searchHelper.checkSort("Price high to low");
        searchHelper.checkSort("Most recent");
        searchHelper.checkSort("Price low to high");
        searchHelper.checkSort("Top Matched");

        helperBase.toHomePage();
    }

}
