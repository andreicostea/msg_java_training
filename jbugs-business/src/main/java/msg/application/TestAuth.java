package msg.application;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
@Path("/auth")
public class TestAuth {

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/test")
    @GET
    public Response createUser(@Context SecurityContext securityContext) {
         return Response.ok(securityContext.isUserInRole("PROJECT MANAGER")).build();
}
}