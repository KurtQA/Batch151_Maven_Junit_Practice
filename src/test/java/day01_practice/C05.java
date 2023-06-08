package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05 {

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
        // driver.close();  Sayfayi tekrar ziyaret etmek isteyebiliriz diye basta close kismini yoruma aldik
    }

    @Test
    public void test01() {

        //https://www.sahibinden.com/ sayfasina gidin
        driver.get("https://www.sahibinden.com/");

        //Title ve Url'ini alin ve yazdirin
        String sahibindenTitle=driver.getTitle();
        System.out.println("SAHIBINDEN TITLE: " +sahibindenTitle);

        String sahibindenUrl= driver.getCurrentUrl();
        System.out.println("SAHIBINDEN URL: "+sahibindenUrl);

        //Title'in "Online" kelimesini icerip icermedigini test edin
        Assert.assertTrue(sahibindenTitle.contains("Online"));

        //Url'in "sahibinden" kelimesini icerip icermedigini test edin
        Assert.assertTrue(sahibindenUrl.contains("sahibinden"));

        //https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");

        //Title'ini alin ve yazdirin
        String amazonTitle=driver.getTitle();
        System.out.println("AmazonTitle: "+amazonTitle);

        //Title'in "more" keloimesini icerip icermedigini test edin
        Assert.assertTrue(amazonTitle.contains("more"));






















    }
}
