package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {

        // https://ebay.com sayfasına gidiniz
        // electronics bolumune tıklayınız
        // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız

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
        // driver.close();
    }


    @Test
    public void test01() {

        // https://ebay.com sayfasına gidiniz
        driver.get("https://ebay.com");

        // electronics bolumune tıklayınız
        driver.findElement(By.xpath("(//a[text()='Electronics'])[2]")).click(); //a tagi icndeki text olup Electronics text'tir

        //Biz burada 1/3 olarak sonuc alinca
        //indexi [1] yazdik. Acik olan sayfada ust seceneklerden biri olan Electronics'in secili olmadigini gorunce index olarak
        //[2] yi denedik. Bunu yazinca Electronics aktif hale gelecek sekilde secili oldugunu gorduk ve 2. index'in dogru
        //oldugunu anladik. 2. index ile unique hale getirdik. 1 of 1 oldu alt cubukta

        // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız

        //Son kodumuzu calistirnca web sayfasinda karsimiza urun resimleri cikti. Biz bunlarin genislik ve uzunluklarini bilmiyoruz.
        //tahminen oyledir diye dusunduk. Bazilarinin boyutlari daha buyuktu. Bize sadece genisligi 225 uzunlugu 225 olan resinler lazim.
        //herhangibir resmin uzerine gelip inspect yaptik. HTML kodunda width="225" height="225"'i gorduk. width attribute'u uzerine cift tikladik
        //xpath ile locate almaya karar verdik. //img[@width='225'] biz ayrica height attribute'unu de kullanmaliyiz cunku bu bizden istenmis.
        //bunun icin height attribute'u uzerinde cift tiklama yaptik. her iki attribute ve value arasinda and @height='225' yazdik. width ve height attribute'lerinin
        //tagi img Biz de(By.xpath("//img[@width='225' and @height='225']")); seklinde locate aldik. Bu locate alma isleminde digerlerinden farkli olarak iki attribute ve iki value
        //aldik. Taglari ayni olan iki attribute ve iki value alacak olursak locate'i boykle aliriz. Locate'i yazdigimiz alt cubukta sonuc 24 oldu. Bunun uzerine 1 den baslayarak
        //sonuc kismindaki ok isaretlerine tek tek bastik. Her basista bir diger resmin uzerine gidildigini acik olan sayfada gorduk. 24 resmi tek tek gezindik.

        //driver.findelements ile aldigimiz 24 webelement'i webelementlerden olusan bir liste assign ettik. Sorumuza gore 24 resmin hepsine tek tek tiklayacagiz. Kac resmimiz
        //oldugu belirli. Dolayisiyla for loop kullanmak mantikli olur.


        List<WebElement> resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']")); //Basta listimizi for loop icinde ikinci satira almistik.

        for (int i = 0; i <resimler.size() ; i++) { //1<24 de yazabiliriz. Kac resim oldugu belirli. 24'e kadar for loop gidecek. i'yi 1 den baslatsaydik 1<25 derdik. Toplam 24 resim yani
            //resimler.size() yazinca baslangicta List<WebElement> olan listimiz tam olarak for loop icinde oldugundan resimler yazisi kirmizi oldu. Bu nedenle List'imizi for loop
            //disina aldik ancak bu defa ikinci ve devam eden resimlerin locate'lerini bulamayacagindan Listi isim ve devam eden kodu ile for loop icine aldik.
            //Bundan sonra i>resimler.size yazdik ve kod daha dinamik hale geldi. Cunku bulunulan ulkeye gore bu boyutlarda resmi olan urunlerin sayisi az ya da cok olabilir ve
            //biz net bir rakam vermeden size eklemesi ile sayi artsa da azalsa da kodumuz etkilenmeyecek

            resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']")); //Bu kismi kodu run edince ikinci resmin locate'ine ulasamadigini anlayinca ekledik.

            resimler.get(i).click(); //resimler listesindeki i.nci index'e tikla ve sayfa basligini yazdir. Yazdirma istenirse sout yazmaliyiz.

            System.out.println(driver.getTitle());

            driver.navigate().back(); //ilk urune buraya kadar tikladik ve sayfa basligini yazdirdik. Ikinci urune gecebilmemiz icin bir back yapmamiz lazim

        }

    }
}