package com.github.ngoanh2n.example.common;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * @author ngoanh2n
 */
@CanIgnoreReturnValue
@ParametersAreNonnullByDefault
@SuppressWarnings({"unchecked",})
public abstract class AbstractPage<Page> {
    protected WebDriver driver;
    protected long minTimeoutToWait = 5 * 1000; // Milliseconds

    public AbstractPage() {
        driver = WebDriverRunner.getWebDriver();
    }

    public Page screenshotEntryPage() {
        screenshot();
        return (Page) this;
    }

    @Attachment(type = "image/png")
    private byte[] screenshot() {
        File file = Screenshots.takeScreenShotAsFile();
        if (file != null) {
            try {
                BufferedImage image = ImageIO.read(file);
                ByteArrayOutputStream arrayOs = new ByteArrayOutputStream();
                BufferedOutputStream os = new BufferedOutputStream(arrayOs);
                image.flush();
                ImageIO.write(image, "png", os);
                return arrayOs.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return new byte[]{};
    }
}
