package dk.dbc.test;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Startup
@Singleton
@Path("")
public class ResourceBean {
    @Resource(lookup = "java:app/env/url/myenv")
    private String myEnv;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getResource() {
        return myEnv;
    }
}
