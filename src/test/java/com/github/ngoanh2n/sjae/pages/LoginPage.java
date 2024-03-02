package com.github.ngoanh2n.sjae.pages;

import com.codeborne.selenide.Selenide;
import com.github.ngoanh2n.sjae.common.AbstractPage;
import com.github.ngoanh2n.sjae.models.Account;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.qameta.allure.Step;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author ngoanh2n
 */
@CanIgnoreReturnValue
@ParametersAreNonnullByDefault
public class LoginPage extends AbstractPage<LoginPage> {
    @Step("Login with account: {0}")
    public PortalPage login(Account account) {
        this.screenshotEntryPage();
        $("#UserUsername").setValue(account.getUsername());
        $("#UserPassword").setValue(account.getPassword());
        $("input[type='submit'][value='Log In']").click();
        return Selenide.page(PortalPage.class);
    }
}
