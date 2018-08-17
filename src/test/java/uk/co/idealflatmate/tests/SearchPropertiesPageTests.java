package uk.co.idealflatmate.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SearchPropertiesPageTests extends TestBase{


    @Test(priority = 1)
    public void propertySearchByDropDown() {

        authorizationHelper.selectAllPropertyInMenu();
        authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.amountPropertyCards(12);
        searchHelper.colivingButtonOnFirstPage();
        searchHelper.firstCardIsColivingAdv();

    }

    @Test(priority = 2)
    public void searchPagination() {

        authorizationHelper.goToPropertyPage();
        //authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.moveToPage(2, "2");
        searchHelper.amountPropertyCards(12);
        searchHelper.moveToPage(3, "3");
        searchHelper.amountPropertyCards(12);
        searchHelper.moveToNext(3);
        searchHelper.amountPropertyCards(12);
        searchHelper.moveToPrevious(3);
        searchHelper.amountPropertyCards(12);
        searchHelper.colivingButton();

    }

    @Test(priority = 3)
    public void searchZone1Pagination() {

        authorizationHelper.goToPropertyPage();
        //authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.zone1();
        searchHelper.colivingButton();

    }

    @Test(priority = 4)
    public void searchEastLDNPagination() {

        authorizationHelper.goToPropertyPage();
        //authorizationHelper.clickCloseSignUpFMPage();
        searchHelper.EastLDN1();
        searchHelper.firstCardIsColivingAdv();

    }




}
