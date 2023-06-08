package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04 {


        // https://www.amazon.com/ adresine gidin
        // arama motorunda nutella yazip aratınız
        // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın

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
        //driver.close();
    }

    @Test
    public void test01() {

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama motorunda nutella yazip aratınız
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Nutella" + Keys.ENTER);

        // sayfada karsınıza cıkan tum urunlere tıklayın ve title'ını yazdırın

        //ilk urunun ya da herhangibir urunun uzerine gidip linki uzerinde yani resminin altindaki yazida inspect yapabiliriz.
        // Gelen HTML kodu uzerine acili sayfadaki ilk usurunun bir ustune gelince ustunde bir kutucuk
        //a tagi ile basladigini anladik. Linklerin tagi a oldugundan a tagli HTML kodunun tamamini almak istedik. class attribute'u uzerine cift tikladik ve value'su olan linkin tamami
        //secili oldu. Biz xpath ile locate alince 26 urun oldugunu anladik ve 1 den 26'ya kadar ok isaretini tikladik. Acili sayfadan secili olanlari kontrol ettik.
        //Tum urunlerin linkini almis oldugumuz xpath icinde oldugunu anladik.

        List<WebElement> nutellaUrunleri = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

        for (int i = 0; i <nutellaUrunleri.size() ; i++) { //0<26 ya da 1<=26 ya da 1<27 yazabilirdik

            nutellaUrunleri = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));

            nutellaUrunleri.get(i).click();

            System.out.println((i+1) + ".URUN TİTLE : " + driver.getTitle()); //i. + "Urun Title" da yazdirabilirdik. 0. Urun Title ..., 1. Urun Title... boyle sonuc verir

            driver.navigate().back();

        }
    }
}