package org.suggs.sandbox.springboottest.greeting.dsl;

import net.serenitybdd.screenplay.Performable;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Say {
    public static Performable hello() {
        return instrumented(GetHello.class);
    }

    public static Performable helloAnonymously() {
        return instrumented(GetHelloAnonymously.class);
    }
}
