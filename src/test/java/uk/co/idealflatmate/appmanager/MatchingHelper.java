package uk.co.idealflatmate.appmanager;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MatchingHelper {

    public void clickHomePageMatching() {
        $(byXpath("//button[contains(text(), 'Find your new flatmate!')]")).waitUntil(visible, 4000).click();
        //$(byXpath("//button[contains(text(), 'Start the match test')] ")).waitUntil(visible, 4000).click();

    }
    public void clickContinueMatching1() {
        $(byXpath("//button[@id='2' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
        sleep(3000);
    }

    public void clickContinueMatching2() {
        $(byXpath("//button[@id='3' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
        sleep(3000);

    }
    public void clickContinueMatching3() {
        $(byXpath("//button[@id='4' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatching4() {
        $(byXpath("//button[@id='5' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatching5() {
        $(byXpath("//button[@id='6' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatching6() {
        $(byXpath("//button[@id='7' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatchingAfterSignUp() {
        $(byXpath("(//button[contains(text(), 'Continue')])[7]")).waitUntil(visible, 4000).click();
        sleep(2000);
    }
    public void clickContinueMatching7() {
        $(byXpath("//button[@id='19' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatching8() {
        $(byXpath("//button[@id='18' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }
    public void clickContinueMatching9() {
        $(byXpath("//button[@id='17' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatching10() {
        $(byXpath("//button[@id='20' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatching11() {
        $(byXpath("//button[@id='21' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatching12() {
        $(byXpath("//button[@id='8' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }
    public void clickContinueMatching13() {
        $(byXpath("//button[@id='9' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }
    public void clickContinueMatching14() {
        $(byXpath("//button[@id='10' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }
    public void clickContinueMatching15() {
        $(byXpath("//button[@id='11' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatching16() {
        $(byXpath("//button[@id='12' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatching17() {
        $(byXpath("//button[@id='13' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickContinueMatching18() {
        $(byXpath("//button[@id='14' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }
    public void clickContinueMatching19() {
        $(byXpath("//button[@id='15' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }
    public void clickContinueMatching20() {
        $(byXpath("//button[@id='16' and contains(text(), 'Continue')]")).waitUntil(visible, 4000).click();
    }

    public void clickSkip7step() {
        $(byXpath("(//div[@class='col-sm-3 col-sm-push-6'])[7]/a")).waitUntil(visible, 4000).click();
    }
    public void chooseMatchingFromDropDownMenu() {
        $(byXpath("//span[@class='pull-left' and contains(text(), ' Matching')]")).click();

    }
}
