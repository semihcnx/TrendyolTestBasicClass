import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Object.PageObjects;


import java.util.List;
import java.util.Random;

import static java.lang.Thread.*;

public class MainTest {
    protected WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(PageObjects.loginUrl);
        driver.manage().window().maximize();
    }

    @Test
    public void userLogin() throws InterruptedException {
        String username="USERNAME";
        String password="PASSWORD";
        sleep(1000);
        PageObjects.PopupClose(driver).click();
        sleep(1000);
        PageObjects.ButtonLogin(driver).click();
        sleep(1000);
        PageObjects.InputUsername(driver).sendKeys(username);
        PageObjects.InputPassword(driver).sendKeys(password);
        PageObjects.ButtonLoginEnter(driver).click();

    }
    @Test
    public void searchBilgisayar() throws InterruptedException{
        userLogin();
            sleep(4000);
            String searchText="Bilgisayar";
            PageObjects.InputSearch(driver).sendKeys(searchText);
            PageObjects.InputSearch(driver).sendKeys(Keys.ENTER);
    }

    @Test
    public void itemRandom() throws  InterruptedException{
        searchBilgisayar();
        sleep(1000);
        List<WebElement> listings = driver.findElements(By.cssSelector("div[class='p-card-wrppr']>div>a"));
        Random r = new Random();
        int randomValue=0;
        randomValue = r.nextInt(listings.size());
        listings.get(randomValue).click();
        WebElement Element1 = driver.findElement(By.cssSelector("span[class='prc-slg']"));
        String element= Element1.getText();
        System.out.println(element);
        driver.findElement(By.cssSelector("button[class='pr-in-btn add-to-bs']")).click();
    }

    @Test
    public void basketIncreament() throws  InterruptedException{
        itemRandom();
        sleep(1000);
        PageObjects.BasketItem(driver).click();
        sleep(5000);
        WebElement Element1 = driver.findElement(By.cssSelector("div[class='pb-basket-item-price']"));
        String element= Element1.getText();
        System.out.println(element);
        Boolean active= PageObjects.partialBasketpassive(driver).isDisplayed();

        if (active ==true)
        {
            PageObjects.ButtonIncreament(driver).click();
            sleep(4000);
            driver.findElement(By.className("i-trash")).click();

            sleep(3000);
            if(PageObjects.contentbody(driver).isDisplayed()){
                PageObjects.btnremove(driver).click();
            }
        }

        else if (active == false) {
            driver.findElement(By.className("i-trash")).click();
            sleep(3000);
            if(PageObjects.contentbody(driver).isDisplayed()){
                PageObjects.btnremove(driver).click();
            }
        }

    }
    @After
    public void close(){
        driver.quit();
    }

}
