package com.github.ngoanh2n.example.pages.shared;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.ngoanh2n.example.common.AbstractPage;
import com.github.ngoanh2n.example.pages.LoginPage;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * @author ngoanh2n
 */
@CanIgnoreReturnValue
@ParametersAreNonnullByDefault
public abstract class Header<Page> extends AbstractPage<Page> {
    @FindBy(xpath = "//a[text()='my account']")
    private SelenideElement mnMyAccount;

    @FindBy(css = "a[href='/users/logout']")
    private SelenideElement subMnLogout;

    @Step("Logout and go back LoginPage")
    public LoginPage logout() {
        mnMyAccount.hover();
        subMnLogout.click();
        takeScreenshotToAllure();
        return Selenide.page(LoginPage.class);
    }
}
