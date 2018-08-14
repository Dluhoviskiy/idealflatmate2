package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

public class SearchPropertiesPageTests extends TestBase{

    @Test(priority = 1)
    public void propertySearchByDropDown() {

        authorizationHelper.selectAllPropertyInMenu();
        authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.amountPropertyCards(12);
        searchHelper.firstCardIsColivingAdv();


    }

    @Test(priority = 1)
    public void searchPagination() {

        authorizationHelper.goToPropertyPage();
        authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.moveToPage(2, "2");
        searchHelper.amountPropertyCards(12);
        searchHelper.moveToPage(3, "3");
        searchHelper.amountPropertyCards(12);
        searchHelper.moveToNext(3);
        searchHelper.amountPropertyCards(12);
        searchHelper.firstCardIsColivingAdv();
        searchHelper.moveToPrevious(3);
        searchHelper.amountPropertyCards(12);

    }



}
