package nopcommerce;
/**
 * Project-1 - ProjectName : com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=
 * %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class NopCommerce {
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;
    static String browser = "Chrome";

    public static void main(String[] args) {

        //Launch the Chrome Browser
        if (browser.trim().equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.trim().equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.trim().equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser");
        }
        //Get base URL
        driver.get(baseUrl);

        //Maximise the Browser
        driver.manage().window().maximize();
        String title = driver.getTitle();

        //Get the title of the Page.
        System.out.println("Title: " + title);

        //Get current URL
        System.out.println("The current URL : " + driver.getCurrentUrl());

        //Get Page source
        System.out.println("Page source : " + driver.getPageSource());

        String navigateUrl = "https://demo.nopcommerce.com/login?returnUrl= %2F";
        driver.navigate().to(navigateUrl);
        //Get current URL
        System.out.println("Get current URL " + driver.getCurrentUrl());

        //back to home page
        driver.navigate().back();

        //We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Find login link element ans=d click on it
        WebElement loginlink = driver.findElement(By.linkText("Log in"));
        loginlink.click();

        //Get current URL
        System.out.println("Get current URL " + driver.getCurrentUrl());

        //Page refresh
        driver.navigate().refresh();

        //Find Email field Element and type the Email
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("prime123@gmail.com");

        //Find Password field and type the Password
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("Prime@333");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Click on login button
        WebElement loginButton = driver.findElement(By.cssSelector(".login-button"));
        loginButton.click();

        driver.quit();
    }
}
