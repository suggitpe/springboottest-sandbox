package org.suggs.sandbox.springboottest.greeting;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.suggs.sandbox.springboottest.greeting.domain.Greeting;

import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Api("Greeting Controller")
public class GreetingController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @ApiOperation(value = "If you tell it your name it will say hi!")
    @RequestMapping(value = "/greeting", method = GET, produces = "application/json")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), "producer", String.format(template, name), 1L);
    }

}
