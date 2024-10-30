package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RamblerSearchTests {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\heart\\Desktop\\chromedriver.exe"); // Укажите путь к chromedriver
        ChromeOptions opt = new ChromeOptions();
        opt.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSearchRambler() {
        driver.get("https://www.rambler.ru/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rc__QUSht.rc__yjE3E")));
        searchBox.sendKeys("Rambler");
        WebElement searchButton = driver.findElement(By.cssSelector(".rc__-9ByP.rc__WL27c"));
        Assert.assertTrue(searchButton.isDisplayed());
        searchButton.click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".SmartCaptcha__captcha--1G0fW.Error__error--2Pu8p"))); // Замените на фактический селектор капчи
            Thread.sleep(20000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement results = driver.findElement(By.cssSelector("h2.Serp__title--3i6Ro"));
        Assert.assertTrue(results.getText().contains("Рэмблер"));
    }

    @Test
    public void testSearchRussianText() {
        driver.get("https://www.rambler.ru/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rc__QUSht.rc__yjE3E")));
        searchBox.sendKeys("Rambler");
        WebElement searchButton = driver.findElement(By.cssSelector(".rc__-9ByP.rc__WL27c"));
        Assert.assertTrue(searchButton.isDisplayed());
        searchButton.click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".SmartCaptcha__captcha--1G0fW.Error__error--2Pu8p"))); // Замените на фактический селектор капчи
            Thread.sleep(20000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement results = driver.findElement(By.cssSelector("h2.Serp__title--3i6Ro"));
        Assert.assertTrue(results.getText().contains("Тестирование"));
    }

    @Test
    public void testSearchNumbers() {
        driver.get("https://www.rambler.ru/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rc__QUSht.rc__yjE3E")));
        searchBox.sendKeys("12345");
        WebElement searchButton = driver.findElement(By.cssSelector(".rc__-9ByP.rc__WL27c"));
        Assert.assertTrue(searchButton.isDisplayed());
        searchButton.click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".SmartCaptcha__captcha--1G0fW.Error__error--2Pu8p"))); // Замените на фактический селектор капчи
            Thread.sleep(20000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement results = driver.findElement(By.cssSelector("h2.Serp__title--3i6Ro"));
        Assert.assertTrue(results.getText().contains("12345"));
    }

    @Test
    public void testSearchEmptyInput() {
        driver.get("https://www.rambler.ru/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rc__QUSht.rc__yjE3E")));
        searchBox.clear();
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".rc__-9ByP.rc__WL27c")));
        Assert.assertTrue(searchButton.isDisplayed());
        searchButton.click();
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.Error__title--3qsmL")));
        Assert.assertTrue(results.getText().contains("Задан пустой поисковый запрос"));
    }
    @Test
    public void testSearchLongInput() {
        driver.get("https://www.rambler.ru/");
        String longInput = "a".repeat(1024); // Строка более 1024 символов
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rc__QUSht.rc__yjE3E")));
        searchBox.sendKeys(longInput);
        WebElement searchButton = driver.findElement(By.cssSelector(".rc__-9ByP.rc__WL27c"));
        Assert.assertTrue(searchButton.isDisplayed());
        searchButton.click();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".SmartCaptcha__captcha--1G0fW.Error__error--2Pu8p"))); // Замените на фактический селектор капчи
            Thread.sleep(20000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.Error__title--3qsmL")));
        Assert.assertTrue(results.getText().contains("Задан пустой поисковый запрос"));
    }
}
