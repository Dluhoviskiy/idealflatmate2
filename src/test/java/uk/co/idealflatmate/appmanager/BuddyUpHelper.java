package uk.co.idealflatmate.appmanager;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class BuddyUpHelper extends HelperBase {
    public void clickCardProperty() {
        $(byXpath("//div[@class='cards-container']//picture/img")).click();

    }
    public void clickListingPageButton(final String text) {
        $(byXpath("//section[@id='property-infos']//a[contains(.,'" + text + "')]")).click();

    }

    public void clickGroupSection() {
        $(byXpath("//a[@id='groups-label']")).click();
    }


    public void clickCreateGroup() {
        $(byXpath("//div[@class='text-center create-group-label text-16 text-bold u_p20-top']/a")).click();
    }

    public void closeIntrodGroupsPopup() {
        sleep(3000);
        $(byXpath("//div[@id='introducingBuddyUpGroupModal']//div[@class='btn btn-sm close']")).click();
    }

    public void goGroupsPopup() {
        sleep(3000);
        $(byXpath("//div[@id='introducingBuddyUpGroupModal']//a[@class='btn btn-success u_ed-block']")).click();
    }

    public void goPostAGroupPopup() {
        sleep(3000);
        $(byXpath("//div[@id='js-in-popup-groups-list']//a[@class='btn btn-success u_ed-block']")).click();
    }

    public void postGroup() {
        sleep(2000);
        $(byXpath("//section//button[contains(.,'Post this group')]")).click();
    }

    public void postAGroupPopup() {
        sleep(2000);
        $(byXpath("//a[contains(.,'Post a group')]")).click();
    }

    public void learnMore() {
        sleep(2000);
        $(byXpath("//div[@class='buddyup-group-item u_eh-100']//a[contains(.,'Learn')]")).click();
    }

    public void removeGroup() {
        sleep(2000);
        $(byXpath("//section[@class='modal-content']//a[contains(.,'Remove group')]")).click();
    }

    public void yesRemoveGroup() {
        sleep(2000);
        $(byXpath("//section[@class='modal-content']//a[contains(.,'remove the group')]")).click();
    }

    public void requestToGroup() {
        sleep(2000);
        $(byXpath("//div[@class='u_p10 group-modal-item']//a[contains(.,'Request to join the group')]")).click();
    }

    public void seeMoreGroups() {
        sleep(2000);
        $(byXpath("//section[@class='modal-content']//a[contains(.,'View more groups')]")).click();
    }

    public void exitGroup() {
        sleep(2000);
        $(byXpath("//section//a[contains(.,'Exit group')]")).click();
    }

    public void confirmLeave() {
        sleep(2000);
        $(byXpath("//section//a[contains(.,'Confirm leave')]")).click();
    }
}
