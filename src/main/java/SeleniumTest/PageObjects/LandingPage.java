package SeleniumTest.PageObjects;

import SeleniumTest.Common.BaseClass;
import SeleniumTest.Common.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LandingPage extends BaseClass {

    WebDriver driver;

    By txtUsername =By.xpath("//*[@id='User_user_name']");
    By txtPassword=By.cssSelector("#User_user_password");
    By btnLogin=By.xpath("//button[contains(text(),'Sign in')]");
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void goTo() throws IOException {
        PropertyFileReader propertyFileReader=new PropertyFileReader();
        String url=propertyFileReader.getPropertyValue("url");
        driver.get(url);
    }

    public void Login(String username, String password)
    {
        driver.findElement(txtUsername).sendKeys(username);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
       // return new HomePage(driver);
    }
}
