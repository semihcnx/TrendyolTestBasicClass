package Object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {
    WebDriver driver;
    public static String loginUrl="http://www.trendyol.com";
    private static WebElement element=null;

    public static WebElement InputUsername(WebDriver driver){
        element=driver.findElement(By.id("email"));
        return element;
    }

    public static WebElement InputPassword(WebDriver driver){
        element=driver.findElement(By.id("password"));
        return element;
    }

    public static WebElement ButtonLoginEnter(WebDriver driver){
        element=driver.findElement(By.id("loginSubmit"));
        return element;


    }
    public static WebElement InputSearch(WebDriver driver){
        element=driver.findElement(By.cssSelector("input[class='search-box']"));
        return element;
    }
    public static WebElement ButtonLogin(WebDriver driver){
        element=driver.findElement(By.id("accountBtn"));
        return element;
    }
    public static WebElement BasketItem(WebDriver driver){
        element=driver.findElement(By.id("myBasketListItem"));
        return element;
    }
   /* public static WebElement notClose(WebDriver driver){
        element=driver.findElement(By.cssSelector("selector\\:\\.modal\\-content\\ notificationPopup"));
        return element;
    }*/
    public static WebElement notClose1(WebDriver driver){
        element=driver.findElement(By.id("Rating-Review"));
        return element;
    }
    public static WebElement Loggedin(WebDriver driver){
        element=driver.findElement(By.className("user-name"));
        return element;
    }

    public static WebElement ButtonPassiveCheck (WebDriver driver){
        element=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/section/section[1]/div[2]/div/div/div[2]/div[2]/div[3]/div[1]/div/button[2]"));
        return element;
    }

    public static WebElement ButtonIncreament (WebDriver driver){
        element=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/section/section[1]/div[2]/div/div/div[2]/div[2]/div[3]/div[1]/div/button[2]"));
        return element;
    }

    public static WebElement partialBasket(WebDriver driver){
        element=driver.findElement(By.cssSelector("button[class='pr-in-btn add-to-bs']"));
        return element;
    }
    public static WebElement partialBasketpassive(WebDriver driver){
        element=driver.findElement(By.cssSelector("button[class='ty-numeric-counter-button passive']"));
        return element;
    }
    public static WebElement btnremove(WebDriver driver){
        element=driver.findElement(By.cssSelector("button.btn-item.btn-remove"));
        return element;
    }
    public static WebElement PopupClose(WebDriver driver){
        //element=driver.findElement(By.xpath("/html/body/div[8]/div/div/a"));
        element= driver.findElement(By.className("fancybox-close"));
        return element;
    }
    public static WebElement contentbody(WebDriver driver){
        element=driver.findElement(By.className("content-body"));
        return element;
    }
}
