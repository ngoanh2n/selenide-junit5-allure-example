package com.github.ngoanh2n.example.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.ngoanh2n.example.common.AbstractPage;
import com.github.ngoanh2n.example.models.Account;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * @author ngoanh2n
 */
@CanIgnoreReturnValue
@ParametersAreNonnullByDefault
public class LoginPage extends AbstractPage<LoginPage> {
    @FindBy(css = "#UserUsername")
    private SelenideElement txtUsername;

    @FindBy(css = "#UserPassword")
    private SelenideElement txtPassword;

    @FindBy(css = "input[type='submit'][value='Log In']")
    private SelenideElement btnLogin;

    @Step("Login with account: {0}")
    public PortalPage login(Account account) {
        takeScreenshotToAllure();
        txtUsername.setValue(account.getUsername());
        txtPassword.setValue(account.getPassword());
        btnLogin.click();
        return Selenide.page(PortalPage.class);
    }
}
