package se.tink.webtesting;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@RunWith(JUnit4.class)
public class BrowserTest {
    private WebDriver driver;

    @Before
    public void createDriver() throws MalformedURLException {
        final URL wd = new URL(System.getenv("WEB_TEST_WEBDRIVER_SERVER"));

        driver = new Augmenter().augment(new RemoteWebDriver(wd, new DesiredCapabilities()));
    }

    @After
    public void quitDriver() {
        try {
            driver.quit();
        } finally {
            driver = null;
        }
    }

    @Test
    public void hoy() {}
}
