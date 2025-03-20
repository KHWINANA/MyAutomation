package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;


    @FindBy(xpath = "//input[@id='user-name']")
    WebElement username_xpath;

    @FindBy(id = "password")
    WebElement password_id;

    @FindBy(name = "login-button")
    WebElement LoginButton_name;

    @FindBy(xpath = "//span[@class='title']")
    WebElement product_xpath;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(username_xpath));
        username_xpath.sendKeys(username);

    }

    public void enterPassword(String password) {
        username_xpath.sendKeys(password);

    }

    public void clickLoginButton() {
        LoginButton_name.click();
    }

    public void verifyProductIsVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(product_xpath));
        String productText = product_xpath.getText();
        Assert.assertEquals(productText, "Products");
    }

}
