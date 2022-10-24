package org.acme;

import io.quarkus.cache.CacheResult;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.security.Principal;

@ApplicationScoped
public class GreetingIntermediary {

    @Inject
    @RestClient
    GreetingClient greetingService;


    @CacheResult(cacheName = "hello")
    public String sayHello(Principal principal) {
        return greetingService.sayHello(String.valueOf(Math.random()));
    }
}
