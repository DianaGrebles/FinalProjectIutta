package FinalProjectIutta;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.herokuapp.LoginTest.sleep;

//import org.testng.annotations.Parameters;
public class AddTest {


    WebDriver driver;
    String url = "https://iutta.ro/genti/magpie-geanta-din-pinatex-brodata/";

    @BeforeTest
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\diagr\\IdeaProjects\\MySeleniumProject\\src\\lib\\chromedriver.exe");
        System.out.println("Open Magpie Bag Page");
        driver = new ChromeDriver();
        //default:driver = new ChromeDriver();       }
        System.out.println("Open Shop");
        driver.get(url);
        driver.manage().window().maximize();


    }


    /*@Parameters({"usernameP","passwordP","errorP"})
    @Test(priority=1, groups = {"smoke","all"})*/


    @Test
    public void addTest() {

        WebElement addToCart = driver.findElement(By.name("add-to-cart"));
        addToCart.click();
        sleep(3000);

        WebElement continutCos = driver.findElement(By.className("elementor-button-icon-qty"));
        Assert.assertEquals(continutCos.getText(), "1");

        //WebElement SeeCart=driver.findElement(By.partialLinkText("iutta.ro/cos/"));
        //Assert.assertTrue(SeeCart.isDisplayed());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

}





