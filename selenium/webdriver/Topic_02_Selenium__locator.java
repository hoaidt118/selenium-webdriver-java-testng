package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium__locator {
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

    /*
        selenium version: 1.x/2.x/3.x/4.x
        8 loại locator
        Selenium locator = HTML attribute
         ID/Class/Name= Trùng với 3 attribute của HTML
         linkText/ Partial LinkText: HTML link (thẻ a)
         Tagname: HTML Tagname
         Css/XPath

         Selenium version 4.x -GUI (graphic user interface)
         Class- Relative Locator
         above/bellow/ near/ leftof/ rightof

         UI Testing
         FUI: Functional UI
         GUI: Graphic UI
         Font/ Size/ Color/ Position/ Locator/ Resolution/ Responsive/ ...

         TestNG: order test case theo Alphabet (0-9, a-z)
        */
    @Test
    public void  TC_01_ID(){
       // driver.findElement(By)
        // tìm element có ID là FistName
        System.out.println(driver.findElement(By.id("FirstName")));
    }

    @Test
    public void  TC_02_Class(){
        // tìm element có class = header-logo
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void  TC_03_Name(){
        // tìm element có name = DateOfBirthDay
        driver.findElement(By.name("DateOfBirthDay"));
    }

    @Test
    public void  TC_04_TagName(){
        // tìm những thẻ input giống nhau
        driver.findElements(By.tagName("input"));
    }

    @Test
    public void  TC_05_LinkText(){
        // Tìm những link có text =  Shipping & returns
        // Độ chính xác cáo
        driver.findElement(By.linkText("Shipping & returns"));
    }

    @Test
    public void  TC_06_Partial_LinkText(){
        // Tìm những link có text chứa text cần tìm
        // Độ chính xác không cao
        driver.findElement(By.partialLinkText("for vendor"));
    }

    @Test
    public void  TC_07_CSS(){
        // CSS với ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        //CSS với class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        //CSS với Name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        // CSS voi TagName
        driver.findElement(By.cssSelector("input"));

        // CSS voi link, phải kt hợp link với href
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));

        // CSS voi partial link
        driver.findElement(By.cssSelector("a[href*='addresses']"));
        //driver.findElement(By.cssSelector("a[href^='addresses']"));
       // driver.findElement(By.cssSelector("a[href$='addresses']"));
    }
    @Test
    public void  TC_08_XPath(){
        // CSS với ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        //CSS với class
        driver.findElement(By.xpath("//div[@class='page-title']"));

        //CSS với Name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        // CSS voi TagName
        driver.findElement(By.xpath("//input"));

        // CSS voi link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));

        // CSS voi partial link
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
