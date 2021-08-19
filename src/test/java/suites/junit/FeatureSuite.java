package suites.junit;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.CucumberOptions;
import courgette.api.junit.Courgette;
import org.junit.runner.RunWith;

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 10,
        runLevel = CourgetteRunLevel.FEATURE,
        rerunFailedScenarios = false,
        showTestOutput = true,
        reportTargetDir = "build",
        reportTitle = "Sample Report Title ",
        environmentInfo = "browser=chrome; git_branch=master; project_info=Courgette-JVM is awesome!",
        plugin = "extentreports",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "steps",
                tags = {"@regression", "not @excluded"},
                publish = false,
                plugin = {
                        "pretty",
                        "json:build/cucumber-report/cucumber.json",
                        "html:build/cucumber-report/cucumber.html",
                        "junit:build/cucumber-report/cucumber.xml",
                        "message:build/cucumber-report/cucumber.ndjson"}
        ))
public class FeatureSuite {
}

/*
@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 10,
        runLevel = CourgetteRunLevel.SCENARIO,
        rerunFailedScenarios = true,
        rerunAttempts = 1,
        showTestOutput = true,
        reportTitle = "Courgette-JVM Example",
        reportTargetDir = "build",
        environmentInfo = "browser=chrome; git_branch=master",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "steps",
                tags = {"@regression", "not @wip"},
                publish = true,
                plugin = {
                        "pretty",
                        "json:build/cucumber-report/cucumber.json",
                        "html:build/cucumber-report/cucumber.html",
                        "junit:build/cucumber-report/cucumber.xml"}
        ))*/
