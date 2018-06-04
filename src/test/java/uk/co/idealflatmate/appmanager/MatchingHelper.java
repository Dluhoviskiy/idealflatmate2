package uk.co.idealflatmate.appmanager;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MatchingHelper {

    public void clickHomePageMatching() {
        //$(byXpath("//button[contains(text(), 'Find your new flatmate!')]")).waitUntil(visible, 4000).click();
        $(byXpath("//button[contains(text(), 'Start the match test')] ")).waitUntil(visible, 4000).click();

    }

    public void clickContinueMatching() {
        $(byXpath("//button[@id='2' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }
    public void clickContinueMatching3() {
        $(byXpath("//button[@id='3' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatching4() {
        $(byXpath("//button[@id='4' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatching5() {
        $(byXpath("//button[@id='5' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatching6() {
        $(byXpath("//button[@id='6' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }
    public void clickContinueMatching7() {
        $(byXpath("//button[@id='7' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

}
