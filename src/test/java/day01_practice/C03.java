package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03 {

        // https://www.bestbuy.com/ sayfasına gidin
        // sayfa Title'ini alın "Best" içerdigini test edin
        // BestBuy logosunun görüntülendigini test edin
        // Canada logosunun görüntülendigini test edin

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @After
    public void tearDown() throws Exception {
        driver.close(); //Tum islemleri yaptiktan sonra yoruma aldigimiz bu kismi yorumdan cikardik.
    }

    @Test
    public void test01() {

        // https://www.bestbuy.com/ sayfasına gidin
        driver.get("https://www.bestbuy.com/");

        // sayfa Title'ini alın "Best" içerdigini test edin
        String bestBuyTitle = driver.getTitle();

        Assert.assertTrue(bestBuyTitle.contains("Best"));

        // BestBuy logosunun görüntülendigini test edin

        //Web sayfasinda BestBUy bir section gibi degil sayfada bir yazi olarak yer aliyordu. Onun uzerinde inspect yaptik
        WebElement bestBuyLogo =driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(bestBuyLogo.isDisplayed());

        // Canada logosunun görüntülendigini test edin
        WebElement canadaLogosu = driver.findElement(By.xpath("(//img[@alt='Canada'])[1]"));
        Assert.assertTrue(canadaLogosu.isDisplayed());

    }
}