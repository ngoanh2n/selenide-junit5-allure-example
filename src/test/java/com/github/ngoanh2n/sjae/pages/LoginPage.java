package com.github.ngoanh2n.sjae.pages;

import com.codeborne.selenide.Selenide;
import com.github.ngoanh2n.sjae.common.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author ngoanh2n
 */
public class LoginPage extends BasePage<LoginPage> {

    @Step("Login with {username}/{password}")
    public PortalPage login(String username, String password) {
        this.screenshotEntryPage();
        $("#UserUsername").setValue(username);
        $("#UserPassword").setValue(password);
        $("input[type='submit'][value='Log In']").click();
        return Selenide.page(PortalPage.class);
    }
}
