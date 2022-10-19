package com.steeplesoft.fwdemo.quarkus;

import static io.restassured.RestAssured.when;

import com.steeplesoft.fwdemo.quarkus.controller.ActorsResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
@TestHTTPEndpoint(ActorsResource.class)
public class ActorResourceTestCase {

    @Test
    public void testGetActors() {
        when().get()
                .then()
                .statusCode(200);
    }
}
