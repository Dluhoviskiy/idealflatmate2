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
}
