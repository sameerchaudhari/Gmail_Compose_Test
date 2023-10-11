package gmailComposeTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", 
    glue = "gmailComposeTestStepDef", 
    plugin = {"pretty", "html:target/cucumber-reports"},
    
    publish=true,
    
    dryRun=true //to tell whether to test run(true) or actual run(false)
    		
)

public class TestRunner {

}
