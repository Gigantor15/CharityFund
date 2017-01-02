package Cumcumber;


import org.junit.Ignore;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@Ignore
@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/donation.feature"})
public class FeatureTranslator {} // hook class
