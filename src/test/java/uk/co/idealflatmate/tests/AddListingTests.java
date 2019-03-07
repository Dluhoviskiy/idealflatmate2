package uk.co.idealflatmate.tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
//import static uk.co.idealflatmate.appmanager.HelperBase.pageUrlVerifLiveGoStage;
import static uk.co.idealflatmate.appmanager.HelperBase.closeMatchPopUp;

public class AddListingTests extends TestBase {

    @Test
    public void loginStartListing() {

        authorizationHelper.login("passwUniv","userNotpaid");

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

        authorizationHelper.clickJoinFreeButton();
        authorizationHelper.clickSignInButtonInForm();
        authorizationHelper.setLoginAsUserWithoutPackage("userNotpaid");
        authorizationHelper.setPassword("passwUniv");
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

        addPropertyHelper.pressAddListingFromHeaderNotLoggedUser();
        addPropertyHelper.selectTypeUser("An agency");

        signUpHelper.agentSignListing("Ronald", "agent", "passwUniv",
                                      "66666666", "Tell us about yourself");

        verificationHelper.verificationUserNameOnHomePage("Ronald");

        verificationHelper.verifyAddListingPage();

        addPropertyHelper.addListingWithoutPhoto("SE1", "2", "4", "900");

        paymentsHelper.addPropertyHelper.finishPropertyAgency();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyAddedProperty("London SE1, UK");

        addPropertyHelper.RemoveListing();

        authorizationHelper.chooseProfileFromHeader();
        verificationHelper.verificationDataAgent("75%");

        authorizationHelper.chooseSettingsFromDashboard();
        authorizationHelper.removeAccount();
        verificationHelper.verificationUserIsUnlogged("Join Free");
    }



    @Test
    public void propertyAddWithAllFields() {

        authorizationHelper.login("passwUniv", "agentNotPaid");

        matchingHelper.closePopupMatching();
        addPropertyHelper.closeRenewPopup();

        //getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        verificationHelper.verifyNoProperty();

        allFields();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.photoListingExist();
        verificationHelper.verifyAddedPropertyWithAllFields("February", "Room 1", "Room 2", "Room 3");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().RemoveListing();
        verificationHelper.verifyNoProperty();
        authorizationHelper.logoutFromApp();
    }

    @Test
    public void propertyEditAllFieldsAbout() {

        authorizationHelper.login("passwUniv", "agentEdit");

        matchingHelper.closePopupMatching();
        addPropertyHelper.closeRenewPopup();

        //getAddPropertyHelper().openDropDownMenu();
        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();

        verificationHelper.photoListingExist();
        verificationHelper.verifyAboutFields();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        addPropertyHelper.clickEdit();
        addPropertyHelper.clickAboutOptions();
        helperBase.saveUpdateButton();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();

        verificationHelper.verifyAddedPropertyWithAllFieldsCouple();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        addPropertyHelper.clickEdit();
        addPropertyHelper.clickAboutOptions();
        helperBase.saveUpdateButton();

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().viewListing();
        verificationHelper.verifyAboutFields();

        addPropertyHelper.verifyBreadCrumbs("Search Rooms", "London", "Bankside", "3 bedrooms for rent in Bankside, South London from ");
        addPropertyHelper.goByLink("Bankside");
        searchHelper.verificationSearchProperty("rooms matched to rent in and around Bankside");



        authorizationHelper.logoutFromApp();
    }




    @Test
    public void titleListing() {

        authorizationHelper.login("passwUniv", "userTitle");

        verificationHelper.verificationUserNameOnHomePage("Title");
        verificationHelper.closeMatchingPopup();

        paymentsHelper.addPropertyHelper.chooseListingsFromDropDownMenu();
        addPropertyHelper.addListingFromPage();
        paymentsHelper.addPropertyHelper.setPostalCode("l11");
        getAddPropertyHelper().pressContinue();

        addPropertyHelper.chooseRoadFor("testRoad");
        verificationHelper.addingListFlowCity("Liverpool");
        getAddPropertyHelper().pressContinue();

        addPropertyHelper.pressBack();

        verificationHelper.addingListFlowCity("Liverpool");
        verificationHelper.roadFor("testRoad");
        getAddPropertyHelper().pressContinue();

        addPropertyHelper.setTotalBedrooms("4");
        addPropertyHelper.setMonthlyRent("500");

        String text1 = "Test_Property_Title";
        addPropertyHelper.propertytitle(text1);

        getAddPropertyHelper().pressContinue();

        addPropertyHelper.ContinueListingWithoutPhoto();
        paymentsHelper.verificationPaymentPageFeatureListing("Want more from your listing? Upgrade now!");

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        closeMatchPopUp();
        getAddPropertyHelper().viewListing();

        verificationHelper.verifyTitleProperty(text1);

        getAddPropertyHelper().chooseListingsFromDropDownMenu();
        getAddPropertyHelper().RemoveListing();
        verificationHelper.verifyNoProperty();
        authorizationHelper.logoutFromApp();

        verificationHelper.verificationUserIsUnlogged("Join Free");

    }

    public void allFields() {
        addPropertyHelper.pressAddListingFromBody();
        addPropertyHelper.setPostalCode("SE1");
        addPropertyHelper.pressContinue();

        addPropertyHelper.chooseRoadFor("Idealstreet");
        addPropertyHelper.chooseAreaforLondon("2");
        addPropertyHelper.pressContinue();

        //getAddPropertyHelper().setPhoneNumber("+44 20 7234 3456", "\n" + "Don't display on my listing");
        addPropertyHelper.setPhoneNumber1("+44 20 7234 3456");
        addPropertyHelper.setTotalBedrooms("4");
        addPropertyHelper.setAllAmanities("Garden", "Parking", " Communal living room",
                " Balcony/patio", "property-pets_accepted", "property-smokers_accepted", "property-family_friendly",
                "property-lgbt_friendly", "property-trans_friendly", "property-vegan_household", "property-vegetarian_household");
        addPropertyHelper.setPropertyDescription();
        addPropertyHelper.setMonthlyRent("500");
        addPropertyHelper.setDeposit("1000");
        addPropertyHelper.setTotalBills("400");
        addPropertyHelper.setLeasePeriodFirstRoom();
        addPropertyHelper.setRoomDescription("Very comfortable room");
        addPropertyHelper.copySecondRoom();
        addPropertyHelper.removeSecondRoom();
        addPropertyHelper.copySecondRoom();
        addPropertyHelper.addAnotherRoom();
        addPropertyHelper.setAnotherMonthlyRent("800");
        addPropertyHelper.setLeasePeriodSecondRoom();
        addPropertyHelper.pressContinue();

        addPropertyHelper.uploadProperty3Photos();
        addPropertyHelper.uploadPropertyLargePhoto();
        addPropertyHelper.uploadPropertyNotPhoto();

        addPropertyHelper.finishPropertyCreatingAgency();
    }


}











