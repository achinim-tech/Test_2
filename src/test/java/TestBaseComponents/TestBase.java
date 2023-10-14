package TestBaseComponents;

import SeleniumTest.Common.PropertyFileReader;
import SeleniumTest.PageObjects.LandingPage;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.time.Duration;

public class TestBase {

    public WebDriver driver;
    LandingPage landingPage;

public WebDriver initializeDriver() throws IOException {
    PropertyFileReader propertyFileReader=new PropertyFileReader();
    String browserName=propertyFileReader.getPropertyValue("browser");

    if(browserName.equalsIgnoreCase("chrome"))
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    } else if (browserName.equalsIgnoreCase("fireforx")) {

       System.setProperty("webdriver.gecko.driver",
                "C:\\Work\\Assessment\\Automation\\Test_2\\src\\main\\resources\\geckodriver.exe");
        WebDriverManager.firefoxdriver().setup();
       driver = new FirefoxDriver();


//       WebDriverManager.firefoxdriver().setup();
//        driver=new FirefoxDriver();


    } else if (browserName.equalsIgnoreCase("edge")) {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
    }
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    return driver;
}

    public  LandingPage launchApplication() throws IOException {
        driver=initializeDriver();
        landingPage=new LandingPage(driver);
        landingPage.goTo();
        return landingPage;


    }

    @After
    public void tearDown()
    {
        System.out.println("BBB");
        driver.close();
    }
}
