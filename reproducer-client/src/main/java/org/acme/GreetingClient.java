package org.acme;

import io.quarkus.cache.CacheName;
import io.quarkus.cache.CacheResult;
import io.quarkus.oidc.token.propagation.AccessTokenRequestFilter;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestQuery;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(configKey = "greeting")
@RegisterProvider(AccessTokenRequestFilter.class)
public interface GreetingClient {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    String sayHello(@QueryParam("value") String value);
}
