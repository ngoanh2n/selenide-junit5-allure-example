package com.github.ngoanh2n.components;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.ngoanh2n.common.BasePage;
import com.github.ngoanh2n.pages.LoginPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * HomePage class
 * <br/>
 *
 * @author ngoanh2n@gmail.com (Ho Huu Ngoan)
 */

public abstract class NavigationBar<Page> extends BasePage<Page> {

    @Step("Logout and go back LoginPage")
    public LoginPage logout() {
        SelenideElement profileDropdown = $("a[href='/anonymous.automation']");
        profileDropdown.click();
        // Wait until DropDown show
        profileDropdown.waitUntil(visible, minTimeoutToWait);
        $("a[href='/users/sign_out']").click();
        this.screenshotEntryPage();
        return Selenide.page(LoginPage.class);
    }
}
