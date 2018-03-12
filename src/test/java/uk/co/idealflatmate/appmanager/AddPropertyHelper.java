package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.Condition;

import java.io.File;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AddPropertyHelper {


    public final MessageHepler messageHepler = new MessageHepler();


    public void finishPropertyCreating() {
        $(byXpath("//*[@id=\"wizard-finish\"]")).scrollIntoView(true).click();
        $(byXpath("//*[@id=\"wizard-finish\"]")).waitUntil(Condition.disappears, 4000);
    }

    public void setMonthlyRent() {
        $("#room-1-price").click();
        $("#room-1-price").setValue("500");
        $("#room-1-price").shouldHave(Condition.value("500"));
        $("#wizard-next").click();
    }

    public void setTotalBedrooms() {
        $("#property-bedrooms_no").click();
        messageHepler.click(byXpath("//*[@id=\"property-bedrooms_no\"]/option[2]"));
    }

    public void chooseAreaforLondon() {
        messageHepler.click(byName("Property[area_link_id]"));
        messageHepler.click(byXpath("//*[@id=\"property-area_link_id\"]/option[2]"));
    }

    public void pressContinueButton() {
        $("#wizard-next").click();
    }

    public void setPostalCode() {
        $(".form-control.u_ed-block").setValue("SE1").pressEnter();
    }

    public void pressAddListingFromHeader() {
        messageHepler.click(byXpath("/html/body/header/div/a"));
    }

    public void uploadPropertyPhoto() {
        $("#uploadimageform-imagefiles").uploadFile(new File("C:\\Users\\Lenovo\\Documents\\Photos for testing\\Property1.jpg"));
        $(".file-preview-frame.krajee-default.file-preview-initial.file-sortable.kv-preview-thumb ").shouldBe(Condition.visible);
    }

    public void uploadProperty3Photos() {
        $("#uploadimageform-imagefiles").uploadFile(new File("C:\\Users\\Lenovo\\Documents\\Photos for testing\\Property1.jpg"));
        $("#uploadimageform-imagefiles").uploadFile(new File("C:\\Users\\Lenovo\\Documents\\Photos for testing\\Property2.jpg"));
        $("#uploadimageform-imagefiles").uploadFile(new File("C:\\Users\\Lenovo\\Documents\\Photos for testing\\Property3.jpg"));
        $(".file-preview-frame.krajee-default.file-preview-initial.file-sortable.kv-preview-thumb ").shouldBe(Condition.visible);

    }
}
