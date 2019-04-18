package com.qa.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/com/qa/feature/FreeCRM.feature", //path of the feature file
		glue= {"com/qa/stepDefinations"}, //path of the stepDefinations file
		format= {"pretty","html:test-output","json:json_output/cucumber.json","junit:junit_output/cucumber.xml"}, //to generate reporting format for diff type
		monochrome=true, // display the console o/p in proper readble format
		dryRun=false, //immigiatley check the witch metods are missing from feature file and stepDefination => ddryRun=true
		strict=true //it will check if any step is not fefined in step definations file
		//tags= {"~@RegressionTest","~@SmokeTest"}  // it will execute only the specified perticiular test
		)

public class TestRunner {

}
