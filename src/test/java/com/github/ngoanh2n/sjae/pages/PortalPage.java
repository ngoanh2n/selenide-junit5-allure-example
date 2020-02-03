package com.github.ngoanh2n.sjae.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.ngoanh2n.sjae.components.Header;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * PortalPage class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

public class PortalPage extends Header<PortalPage> {

    @Step("Verify Dashboard title")
    public PortalPage verifyDashboardTitle(String expected) {
        this.screenshotEntryPage();
        $(".student_dashboard div h1").shouldHave(text(expected));
        return this;
    }

    public PortalPage verifyLastQuizMenu() {
        ElementsCollection collection = $$("div[class='quiz_menu'] ul li");
        // This causes exception, because the last index is 5
        List<SelenideElement> list = new ArrayList<>(collection);
        list.get(6).shouldHave(text("How-to videos"));
        return this;
    }
}
