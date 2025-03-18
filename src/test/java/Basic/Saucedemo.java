package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Saucedemo {
    WebDriver driver;

    @Test
public void loginInWithValidDetails(){
    driver= new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();

String productText = driver.findElement(By.xpath("//span[@class='title']")).getText();

        Assert.assertEquals(productText,"Products");
}
@AfterTest
    public void closeBrowser(){
        driver.quit();
}
}
