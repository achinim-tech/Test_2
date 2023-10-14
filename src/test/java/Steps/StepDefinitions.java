package Steps;

import SeleniumTest.PageObjects.LandingPage;
import TestBaseComponents.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class StepDefinitions extends TestBase {


    LandingPage landingPage;


    @When("I navigate to the application")
    public void i_navigate_to_the_application() throws IOException {
       landingPage=launchApplication();
    }


    @When("I login with username {string} and {string}")
    public void i_login_with_username_and(String username, String password) throws InterruptedException {
       // System.out.println("AAA");
       // landingPage.Login(username,password);


//        WebElement dropdownStatic= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//        Select dropdown=new Select(dropdownStatic);
//        dropdown.selectByVisibleText("AED");
//        System.out.println(dropdown.getFirstSelectedOption().getText());


//        driver.findElement(By.id("autosuggest")).sendKeys("ind");
//        Thread.sleep(3000);
//        List<WebElement> options=driver.findElements(By.xpath("//*[@class='ui-menu-item']/a"));
//
//
//        for(WebElement option:options)
//        {
//            if(option.getText().equalsIgnoreCase("India"))
//            {
//                option.click();
//                break;
//            }
//        }
//        Thread.sleep(3000);
//        String aaa=driver.findElement(By.id("autosuggest")).getText();
//        System.out.println(aaa);

        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scroll(0,500)");
        Thread.sleep(3000);
        js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");



        int count =0;
        List <WebElement> valuse=driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]"));
        for(int i=0;i<valuse.size();i++)
        {
           System.out.println(Integer.parseInt(valuse.get(i).getText()));
           count=count +Integer.parseInt(valuse.get(i).getText());
        }
        System.out.println("Count is : "+count);



    }

    @After
    public void tearDown()
    {
       
        driver.close();
    }

    @And("I navigate to HomePage")
    public void iNavigateToHomePage() {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.logo-size-60")));
        String HomeTitle=driver.getTitle();
        Assert.assertTrue(HomeTitle.equalsIgnoreCase("Human Resource Information system - Site"));
    }
}
