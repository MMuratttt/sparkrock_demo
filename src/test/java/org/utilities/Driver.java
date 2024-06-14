package org.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.time.Duration;

public class Driver {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static org.openqa.selenium.WebDriver getDriver() {

        //singleton design pattern
        if (webDriver.get() == null) {

            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    webDriver.set(new ChromeDriver());
                    webDriver.get().manage().window().maximize();
                    webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    webDriver.set(new FirefoxDriver());
                    webDriver.get().manage().window().maximize();
                    webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions optionsHeadless = new ChromeOptions();
                    optionsHeadless.addArguments("--headless");
                    webDriver.set(new ChromeDriver(optionsHeadless));
                    webDriver.get().manage().window().maximize();
                    webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    SafariOptions safariOptions = new SafariOptions();
                    webDriver.set(new SafariDriver(safariOptions));
                    webDriver.get().manage().window().maximize();
                    webDriver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

            }

        }

        return webDriver.get();

    }

    public static void killWebDriver() {
        if (webDriver.get() != null) {
            webDriver.get().quit(); // this line will terminate the existing session. value will not even be null
            webDriver.remove();
        }

    }
}

