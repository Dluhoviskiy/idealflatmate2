package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;

public class AddListingTests extends TestBase {

    @Test
    public void loginStartListing() {
        pageUrlVerifLiveGoStage();

        authorizationHelper.login("cro.gen.FHListingNotPaid@gmail.com", "qqqqqq");

        verificationHelper.closeMatchingPopup();

        //verificationHelper.verifyNoProperty();
        paymentsHelper.addPropertyHelper.chooseListingsFromDropDownMenu();
        addPropertyHelper.addListingFromPage();
        paymentsHelper.addPropertyHelper.setPostalCode("SE1");
        //getAddPropertyHelper().pressContinue1();
        getAddPropertyHelper().pressContinue();

        paymentsHelper.addPropertyHelper.chooseAreaforLondon("2");
        getAddPropertyHelper().pressContinue();

        //getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.finishUnfinished();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.finishViewUnfinished();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.removeUnfinishedListing();
        verificationHelper.verifyNoPropertyPending();
        verificationHelper.verificationUserNameOnHomePage("John");

        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }

    @Test
    public void loginPendingListing() {
        pageUrlVerifLiveGoStage();

        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("cro.gen.FHListingPaid@gmail.com");
        authorizationHelper.setPassword("qqqqqq");
        authorizationHelper.submitLogin();

        verificationHelper.closeMatchingPopup();

        //verificationHelper.verifyNoProperty();
        paymentsHelper.addPropertyHelper.chooseListingsFromDropDownMenu();
        addPropertyHelper.addListingFromPage();
        paymentsHelper.addPropertyHelper.setPostalCode("SE1");
        //getAddPropertyHelper().pressContinue1();
        getAddPropertyHelper().pressContinue();

        paymentsHelper.addPropertyHelper.chooseAreaforLondon("2");
        getAddPropertyHelper().pressContinue();

        paymentsHelper.addPropertyHelper.setTotalBedrooms("4");
        paymentsHelper.addPropertyHelper.setMonthlyRent("500");
        getAddPropertyHelper().pressContinue();

        paymentsHelper.addPropertyHelper.ContinueListingWithoutPhoto();
        verificationHelper.finishPendingProperty();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyPendingProperty();
        addPropertyHelper.RemoveListing();
        verificationHelper.verifyNoPropertyPending();
        verificationHelper.verificationUserNameOnHomePage("John");

        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.logoutFromApp();
        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    @Test
    public void signUpPropertyAdding() {
        pageUrlVerifLiveGoStage();

        addPropertyHelper.pressAddListingFromHeaderNotLoggedUser();
        addPropertyHelper.selectTypeUser("An agency");

        signUpHelper.agentSignListing("Ronald", "agentTest11rrr2@gmail.com", "qqqqqq",
                                      "66666666", "Tell us about yourself");

        verificationHelper.verificationUserNameOnHomePage("Ronald");

        verificationHelper.verifyAddListingPage();

        addPropertyHelper.addListingWithoutPhoto("SE1", "2", "4", "900");

        paymentsHelper.addPropertyHelper.finishPropertyAgency();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyAddedProperty();
        addPropertyHelper.RemoveListing();

        authorizationHelper.chooseProfileFromHeader();
        verificationHelper.verificationDataAgent("75%");

        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }



    @Test
    public void propertyAddWithAllFields() {
        pageUrlVerifLiveGoStage();

        authorizationHelper.login("cro.gen.AgencyNotPaid@gmail.com", "qqqqqq");

        matchingHelper.closePopupMatching();
        addPropertyHelper.closeRenewPopup();

        //getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoProperty();

        getAddPropertyHelper().pressAddListingFromBody();
        getAddPropertyHelper().setPostalCode("SE1");
        getAddPropertyHelper().pressContinue();

        getAddPropertyHelper().chooseRoadFor("Idealstreet");
        getAddPropertyHelper().chooseAreaforLondon("2");
        getAddPropertyHelper().pressContinue();

        //getAddPropertyHelper().setPhoneNumber("+44 20 7234 3456", "\n" + "Don't display on my listing");
        getAddPropertyHelper().setPhoneNumber1("+44 20 7234 3456");
        getAddPropertyHelper().setTotalBedrooms("4");
        getAddPropertyHelper().setAllAmanities("Garden", "Parking", " Communal living room", " Balcony/patio ", "property-pets_accepted", "property-smokers_accepted", "property-family_friendly");
        getAddPropertyHelper().setPropertyDescription();
        getAddPropertyHelper().setMonthlyRent("500");
        getAddPropertyHelper().setDeposit("1000");
        getAddPropertyHelper().setTotalBills("400");
        getAddPropertyHelper().setLeasePeriodFirstRoom();
        getAddPropertyHelper().setRoomDescription("Very comfortable room");
        getAddPropertyHelper().copySecondRoom();
        getAddPropertyHelper().removeSecondRoom();
        getAddPropertyHelper().copySecondRoom();
        getAddPropertyHelper().addAnotherRoom();
        getAddPropertyHelper().setAnotherMonthlyRent("800");
        getAddPropertyHelper().setLeasePeriodSecondRoom();
        getAddPropertyHelper().pressContinue();

        addPropertyHelper.uploadProperty3Photos();
        addPropertyHelper.uploadPropertyLargePhoto();
        addPropertyHelper.uploadPropertyNotPhoto();

        addPropertyHelper.finishPropertyCreatingAgency();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.photoListingExist();
        verificationHelper.verifyAddedPropertyWithAllFields("February");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().RemoveListing();
        verificationHelper.verifyNoProperty();
        authorizationHelper.logoutFromApp();
    }






}











