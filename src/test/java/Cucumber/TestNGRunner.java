package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features ="src/test/java/Cucumber",
        glue ="Steps",
        monochrome = true,
        plugin ={"pretty", "html:target/cucumber.html"},
        tags = "@Test"

)




public class TestNGRunner extends AbstractTestNGCucumberTests {
}
