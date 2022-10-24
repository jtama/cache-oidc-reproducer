package org.acme;

import io.quarkus.security.Authenticated;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.security.Principal;


@Authenticated
@Path("/hello")
public class GreetingResource {


    @Inject
    Principal principal;

    @Inject
    GreetingIntermediary greetingIntermediary;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        for (int i = 0; i < 100;i++) {
            System.out.println(greetingIntermediary.sayHello(principal));
        }
        return "Yop";
    }
}
