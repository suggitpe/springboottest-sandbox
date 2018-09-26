package org.suggs.sandbox.springboottest.greeting.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.suggs.sandbox.springboottest.greeting.dsl.Say;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ContextConfiguration
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class GreetingSteps {

    private static final Logger LOG = LoggerFactory.getLogger(GreetingSteps.class);
    private ConfigurableApplicationContext application;

    @LocalServerPort
    private int localPort = -1;

    public static final String PRODUCER_URL = "http://localhost:";
    private Actor actor;

    @Given("^the Greeting Service is running$")
    public void the_producer_is_running() {
        LOG.info("Checking the producer is running");
        assertThat(localPort, is(not(-1)));
        assertThat(RestAssured.get(PRODUCER_URL + localPort).statusCode(), is(200));
    }

    @When("^(.*) calls the Greeting Service")
    public void calls_the_producer(String actorName) {
        actor = Actor.named(actorName);
        actor.can(CallAnApi.at(PRODUCER_URL + localPort));
        actor.attemptsTo(Say.hello());
    }

    @When("^someone called the Greeting Service anonymously$")
    public void someone_called_the_Producer_anonymously() {
        actor = Actor.named("Anonymous");
        actor.can(CallAnApi.at(PRODUCER_URL + localPort));
        actor.attemptsTo(Say.helloAnonymously());
    }

    @Then("^it says \"(.*)\"$")
    public void it_says(String response) {
        //actor.should(seeThat(TheReply.content(), is(equalTo(response))));
    }

}
