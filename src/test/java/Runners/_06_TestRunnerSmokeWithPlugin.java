package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@SmokeTest or @Regression",
        features = { "src/test/java/FeatureFiles"},  // hepsi demek
        glue = {"StepDefinitions"},
        plugin = {"html:target/site/cucumber-pretty.html"} //basit report
)
public class _06_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}
