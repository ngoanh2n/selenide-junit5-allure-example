package com.github.ngoanh2n.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.github.ngoanh2n.RuntimeError;
import com.github.ngoanh2n.example.pages.shared.Header;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.qameta.allure.Step;

import javax.annotation.ParametersAreNonnullByDefault;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * @author ngoanh2n
 */
@CanIgnoreReturnValue
@ParametersAreNonnullByDefault
public class PortalPage extends Header<PortalPage> {
    @Step("Verify Dashboard title")
    public PortalPage verifyDashboardTitle(String expected) {
        screenshotEntryPage();
        $(".student_dashboard div h1").shouldHave(text(expected));
        return this;
    }

    @Step("Verify number of quiz menu")
    public PortalPage verifyNumberOfQuizMenu() {
        ElementsCollection collection = $$("div[class='quiz_menu'] ul li");
        //collection.shouldHave(CollectionCondition.sizeLessThan(1));
        if (collection.size() > 1) {
            throw new RuntimeError("Intentionally throws exception to illustrate broken case");
        }
        return this;
    }
}
