package Cumcumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/donation.feature",
							  "src/test/resources/makeEvent.feature",
							  "src/test/resources/viewEvent.feature" 
							})
public class FeatureTranslator {



} // hook class
