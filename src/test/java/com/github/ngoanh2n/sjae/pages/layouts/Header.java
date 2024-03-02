package com.github.ngoanh2n.sjae.pages.layouts;

import com.codeborne.selenide.Selenide;
import com.github.ngoanh2n.sjae.common.AbstractPage;
import com.github.ngoanh2n.sjae.pages.LoginPage;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.qameta.allure.Step;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * @author ngoanh2n
 */
@CanIgnoreReturnValue
@ParametersAreNonnullByDefault
public abstract class Header<Page> extends AbstractPage<Page> {
    @Step("Logout and go back LoginPage")
    public LoginPage logout() {
        $("li[class='menu_parent'] a[href='/vocabulary/students/portal']").hover();
        $x("//div[@class='right_part']//li[@class='menu_parent']").should(appear);
        $("a[href='/users/logout']").click();
        this.screenshotEntryPage();
        return Selenide.page(LoginPage.class);
    }
}
