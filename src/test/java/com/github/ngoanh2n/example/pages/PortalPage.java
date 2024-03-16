package com.github.ngoanh2n.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.ngoanh2n.RuntimeError;
import com.github.ngoanh2n.example.pages.shared.Header;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Condition.text;

/**
 * @author ngoanh2n
 */
@CanIgnoreReturnValue
@ParametersAreNonnullByDefault
public class PortalPage extends Header<PortalPage> {
    @FindBy(css = ".student_dashboard div h1")
    private SelenideElement lblTitle;

    @FindBy(css = "div[class='quiz_menu'] ul li")
    private ElementsCollection listItems;

    @Step("Verify Dashboard title")
    public PortalPage verifyDashboardTitle(String expected) {
        takeScreenshotToAllure();
        lblTitle.shouldHave(text(expected));
        return this;
    }

    @Step("Verify number of quiz menu")
    public PortalPage verifyNumberOfQuizMenu() {
        //listItems.shouldHave(CollectionCondition.sizeLessThan(1));
        if (listItems.size() > 1) {
            throw new RuntimeError("Intentionally throws exception to illustrate broken case");
        }
        return this;
    }
}
