package com.github.ngoanh2n.pages;

import com.github.ngoanh2n.components.NavigationBar;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * HomePage class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

public class HomePage extends NavigationBar<HomePage> {

    @Step("Verify welcome title for HomePage")
    public HomePage verifyHomePageEmpty() {
        this.screenshotEntryPage();
        $("h2[class='blank-state-welcome-title']").shouldHave(text("Welcome to GitLab"));
        return this;
    }
}
