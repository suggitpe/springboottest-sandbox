package org.suggs.sandbox.springboottest.greeting.dsl;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetHello implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource("/greeting").with(requestSpecification ->
                requestSpecification.queryParam("name", "Bob")));
    }
}
