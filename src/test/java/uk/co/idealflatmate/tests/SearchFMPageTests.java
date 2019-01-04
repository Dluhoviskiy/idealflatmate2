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
    public void applyMoreFiltersPhotoNoList() {

        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();

        searchHelper.numberOfActiveFilters(1);

        searchHelperFM.clickMoreFilterVerifyPhotoListing("Looking for a room", "Has a room");

        searchHelper.numberOfActiveFilters(1);

        helperBase.toHomePage();
    }

    @Test(priority = 5)
    public void applyMoreFiltersPhotoWithList() {

        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();

        searchHelper.numberOfActiveFilters(1);

        searchHelperFM.clickMoreFilterVerifyPhotoNoListing("Looking for a room");

        searchHelper.numberOfActiveFilters(1);

        helperBase.toHomePage();
    }

    @Test(priority = 6)
    public void applyAdvancedFiltersDefault() {

        authorizationHelper.goToFMpage();
        searchHelper.closePopupSignup();
        searchHelper.checkHighPriceSort("7");
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

    @Test(priority = 7)
    public void sortListingLoggedIn() {

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
