package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;

import java.io.File;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;


public class AddPropertyHelper {



    public final MessageHelper messageHelper = new MessageHelper();

    public void openDropDownMenu() {
        $(".dropdown.nav-ihm-profile-bars").click();
    }

    public void pressAddListingFromBody() {
        $(byXpath("/html/body/section/section/div/div/a")).click();
    }


     /* public void pressAddListingFromHello() {
        $(byXpath("html/body/header/div/ul/li/a/span[@class='hidden-xs']")).click();
    }
      */


    public void chooseListingsFromDropDownMenu() {
        $(byXpath("//span[@class='pull-left' and contains(text(), ' Listings')]")).click();
    }


    public void setPostalCode(String postCode) {
        $(".form-control.u_ed-block").setValue(postCode).pressEnter();
    }

    public void pressContinueButton() {
        $("#wizard-next").click();
    }

    public void chooseRoadFor(String road) {
        messageHelper.click(byXpath("//input[@id='property-route']"));
        $(byXpath("//input[@id='property-route']")).setValue(road).pressEnter();;
    }

    public void chooseAreaforLondon() {
        messageHelper.click(byName("Property[area_link_id]"));
        messageHelper.click(byXpath("//*[@id=\"property-area_link_id\"]/option[2]"));
    }

    public void pressAddListingFromHeader() {
        messageHelper.click(byXpath("/html/body/header/div/a"));
    }

    public void setPhoneNumber(String phoneNumber) {
        $("#property-phone_number").waitUntil(visible, 6000).setValue(phoneNumber);

    }


    public void setTotalBedrooms() {
        $("#property-bedrooms_no").click();
        messageHelper.click(byXpath("//*[@id=\"property-bedrooms_no\"]/option[4]"));
    }

    public void setAllAmanities() {
        $(byXpath("//div[@id='property-property_amenities']/div/label[contains(text(), 'Garden')]")).click();
        $(byXpath("//div[@id='property-property_amenities']/div[2]")).click();
        $(byXpath("//div[@id='property-property_amenities']/div[3]")).click();
        $(byXpath("//div[@id='property-property_amenities']/div/label[contains(text(), 'Parking')]")).click();
        $(byXpath("//div[@id='property-property_amenities']/div[1]")).waitUntil(appear, 4000).shouldHave(attribute("class", "checkbox checked"));
        $(byXpath("//div[@id='property-property_amenities']/div[2]")).waitUntil(appear, 4000).shouldHave(attribute("class", "checkbox checked"));
        $(byXpath("//div[@id='property-property_amenities']/div[3]")).waitUntil(appear, 4000).shouldHave(attribute("class", "checkbox checked"));
        $(byXpath("//div[@id='property-property_amenities']/div[4]")).waitUntil(appear, 4000).shouldHave(attribute("class", "checkbox checked"));
        $(byXpath("//label[@for='property-pets_accepted']")).click();
        $(byXpath("//label[@for='property-smokers_accepted']")).click();
        $("#property-smokers_accepted").shouldBe(selected);
        $("#property-pets_accepted").shouldBe(selected);
    }


    public void setPropertyDescription() {
        $(byXpath("//div[@class='form-group field-property-description']/div[1]/textarea")).click();
        $(byXpath("//textarea[@id='property-description']")).setValue("Very good flat");
        // $(byXpath("//div[@class='form-group field-property-description']/div[1]/textarea")).shouldHave(text("Very good flat"));
    }

    public void setMonthlyRent(String rent) {
        $("#room-1-price").click();
        $("#room-1-price").setValue(rent);
        $("#room-1-price").shouldHave(Condition.value("500"));
        //$("#wizard-next").click();
    }

    public void setDeposit(String deposit) {
        $("input#room-1-deposit").click();
        $("input#room-1-deposit").setValue(deposit);
        $("#room-1-deposit").shouldHave(value("1000"));
        // $("#wizard-next").click();
    }

    public void setTotalBills(String bills) {
        $("input#room-1-bills").scrollIntoView(true).setValue(bills);
        $("#room-1-bills").shouldHave(value("400"));
    }

    public void setLeasePeriodFirstRoom() {
        $(byXpath("//div[@class='field-room-1-availability']/div[1]")).waitUntil(appear, 4000).shouldHave(attribute("class", "checkbox checked"));
        $("#room-1-min_stay").click();
        $(byXpath("//*[@id=\"room-1-min_stay\"]/option[2]")).click();
        $("#room-1-max_stay").click();
        $("#room-1-max_stay > option:nth-child(13)").click();
    }


    public void setRoomDescription() {
        $(byXpath("//div[@class='form-group field-room-1-description']/textarea")).click();
        $(byXpath("//div[@class='form-group field-room-1-description in-use']/textarea")).setValue("Very comfortable room");
        // $("#room-1-description").shouldHave(text("Very comfortable room"));
    }

    public void copySecondRoom() {
        $(byXpath("//button[@class='btn btn-sm btn-primary-outline js-room-copy']")).waitUntil(appear, 4000).click();
        $(byXpath("//div/input[@id='room-2-price']")).shouldBe(visible);
    }

    public void removeSecondRoom() {
        $(byXpath("//button[@class='btn btn-sm btn-primary-outline js-room-remove u_ef-left']")).waitUntil(appear, 4000).click();
        $(byXpath("//div/input[@id='room-2-price']")).shouldNotBe(visible);
    }

    public void addAnotherRoom() {
        $(byXpath("//button[@class='btn btn-sm btn-primary js-room-add']")).waitUntil(visible, 4000).click();
        $(byXpath("//div[@data-idx='3']")).waitUntil(appear, 4000);
        $(byXpath("//div[@data-idx='3']")).scrollIntoView(true);
    }


    public void setAnotherMonthlyRent(String rent) {
        $(byXpath("//div/input[@id='room-3-price']")).click();
        $(byXpath("//div/input[@id='room-3-price']")).setValue(rent);
        $(byXpath("//div/input[@id='room-3-price']")).shouldHave(Condition.value("800"));
        //$("#wizard-next").click();
    }

    public void setLeasePeriodSecondRoom() {
        $(byXpath("//div[@class='field-room-3-availability']/div[1]")).waitUntil(appear, 4000).shouldHave(attribute("class", "checkbox checked"));
        $(byXpath("//div[@class='field-room-3-availability']/div/label")).waitUntil(appear, 4000).click();
        $(byXpath("//div[@class='field-room-3-availability']/div[1]")).waitUntil(appear, 4000).shouldHave(attribute("class", "checkbox"));
        $(byXpath("//input[@id='room-3-available_from']")).waitUntil(appear, 4000).click();
        $(".ui-icon.ui-icon-circle-triangle-e").waitUntil(appear, 4000).click();
        $(".ui-datepicker-year").waitUntil(appear, 4000).click();
        messageHelper.click(byXpath("//option[@value='2025']"));
        $(byXpath("//a[@class='ui-state-default' and contains(text(), '11')]")).waitUntil(appear, 4000).click();

    }

    public void uploadPropertyPhoto() {
       //$("#uploadimageform-imagefiles").uploadFile(new File("C:\\Users\\Lenovo\\Documents\\Photos for testing\\Property1.jpg"));
        $("#uploadimageform-imagefiles").uploadFile(new File("src/test/resources/Property1.jpg"));
        $(".file-preview-frame.krajee-default.file-preview-initial.file-sortable.kv-preview-thumb ").shouldBe(Condition.visible);
    }

    public void uploadProperty3Photos() {
        $("#uploadimageform-imagefiles").uploadFile(new File("src/test/resources/listing1.jpg"));
        $("#uploadimageform-imagefiles").uploadFile(new File("src/test/resources/listing2.jpeg"));
        $("#uploadimageform-imagefiles").uploadFile(new File("src/test/resources/listing3.jpg"));
        $(".file-preview-frame.krajee-default.file-preview-initial.file-sortable.kv-preview-thumb ").shouldBe(Condition.visible);
    }

    public void finishPropertyCreating() {
        $(byXpath("//*[@id=\"wizard-finish\"]")).scrollIntoView(true).click();
        //$(byXpath("//*[@id=\"wizard-finish\"]")).waitUntil(Condition.disappears, 4000);
        $(byXpath("//div[@class='u_p20-bottom u_b-bottom u_b-2']/a[contains(text(), 'Continue without upgrading')]")).waitUntil(appear, 4000).click();
        $(byXpath("//span[contains(text(), 'Your')]")).shouldHave(text("Your listing is now live!"));
    }

    public void viewListing() {
        $(byXpath("//a[@class='btn btn-half btn-primary listing-panel-button u_m10-bottom-xs']")).waitUntil(appear, 4000).click();
    }

    public void RemoveListing() {
        $(byXpath("//button[contains(@class, \"listing-panel-delete\")]")).waitUntil(appear, 4000).click();
        $(byXpath("(//input[1][@type='radio'])[1]")).waitUntil(appear, 4000).selectRadio("0");
        $(byXpath("//button[@type='submit' and contains(text(), 'Delete property')]")).waitUntil(Condition.appears, 4000).click();
    }

}
