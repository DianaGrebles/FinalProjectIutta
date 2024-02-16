package FinalProjectIutta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrivacyPolicy {


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
    public void PrivacyPolicy() {


        WebElement politicaDeConfidentialitate = driver.findElement(By.linkText("politica de confidențialitate"));
        politicaDeConfidentialitate.click();
        String expectedlink = "https://iutta.ro/politica-de-confidentialitate/";
        String actuallink = driver.getCurrentUrl();
        Assert.assertEquals(actuallink, expectedlink);

        // String
        //WebElement TikTokOfficial-driver.findElement(By.linkText("https://www.tiktok.com/@iuttaofficial");
        //Assert.assertTrue(TikToklink=TikTokOfficial);
        //????????????????????????

    }


    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }


}


//SOCIA MEDIA!!!
//Simboluri
