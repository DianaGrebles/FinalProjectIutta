package FinalProjectIutta;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.herokuapp.LoginTest.sleep;

public class Subscribe {


    WebDriver driver;
    String url = "https://iutta.ro/";

    @BeforeTest
    public void setUp() {
        //1. deschide pagina de Login
        //switch (FirefoxDriver){
        // case "chrome": driver = new ChromeDriver();break;
        //case "edge": driver = new EdgeDriver();break;
        //driver = new FirefoxDriver();
        //default:driver = new ChromeDriver();       }
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\diagr\\IdeaProjects\\MySeleniumProject\\src\\lib\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\diagr\\IdeaProjects\\MySeleniumProject\\src\\lib\\chromedriver.exe");
        //System.out.println("Open Login");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();


        try {
            WebElement accept = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/button[2]"));
            if (accept.isDisplayed()) {
                accept.click();
            }
        } catch (Exception e) {
            throw new RuntimeException("Acord absent.");

        }
    }


    // @Parameters({"usernameP","passwordP","errorP"})
    //@Test(priority=1, groups = {"smoke","all"})
    @Test
    public void subscribe() throws InterruptedException {


        WebElement subscribeField = driver.findElement(By.id("form-field-email"));
        sleep(3000);

        //facem scroll down
        Actions action = new Actions(driver);
        action.moveToElement(subscribeField);
        action.perform();

        subscribeField.sendKeys("test@test.com");
        sleep(3000);
        subscribeField.sendKeys(Keys.ENTER);

        sleep(3000);

        //WebElement subscribeButton = driver.findElement(By.className("elementor-button-text"));
        //subscribeButton.click();
        String expectedMessage = "Te-ai abonat cu succes!";
        // String actualMessage=driver.findElement(By.xpath("//div[@role='alert']"));
        sleep(3000);
        String actualMessage = driver.findElement(By.xpath("//div[@role=\"alert\"]")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);


        // String
        //WebElement TikTokOfficial-driver.findElement(By.linkText("https://www.tiktok.com/@iuttaofficial");
        //Assert.assertTrue(TikToklink=TikTokOfficial);
        //????????????????????????

    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

    public static void wait(int ms) {
        sleep(3000);
    }


}




