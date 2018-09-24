package org.suggs.sandbox.springboottest.greeting;

import io.restassured.RestAssured;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class TestUsingSpringBoot {

    public static final String PRODUCER_URL = "http://localhost:";

    @LocalServerPort
    private int localPort = -1;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void startsWithARandomPort() {
        assertThat(localPort).isNotEqualTo(-1);
    }

    @Test
    public void respondsToRestApiCalls() {
        assertThat(RestAssured.get(PRODUCER_URL + localPort).statusCode()).isEqualTo(200);
    }

}
