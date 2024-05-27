package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_04_Relative_Locator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");

        driver.manage().window().maximize();
    }

    @Test
    public void  TC_01_Relative(){
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");
        //Login button
        By loginButtonBy = By.cssSelector("button.login-button");
        WebElement loginButtonElement = driver.findElement(By.cssSelector("button.login-button"));
        RelativeLocator.with(By.tagName("label")).above(loginButtonBy);
        // Remember Me Checkbox
        By rememberMeCheckboxBy = By.id("RememberMe");

        //Forgot Password link
        WebElement fotgotPasswordElement = driver.findElement(By.cssSelector("span.forgot-password"));

        //Password texbox
        By passwordTextboxBy= By.cssSelector("input#Password");


        WebElement rememberMeTextElement = driver
                .findElement(RelativeLocator.with(By.tagName("label"))
                .above(loginButtonElement)
                .toRightOf(rememberMeCheckboxBy)
                .toLeftOf(fotgotPasswordElement)
                .below(passwordTextboxBy)
                .near(fotgotPasswordElement));
        System.out.println(rememberMeTextElement.getText());

        //List thẻ a
        List<WebElement> allLinks = driver.findElements(RelativeLocator.with(By.tagName("a")));
        System.out.println(allLinks.size());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
