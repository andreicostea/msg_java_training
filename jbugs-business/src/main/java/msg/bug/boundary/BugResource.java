package msg.bug.boundary;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/bugs")
public class BugResource {
    @EJB
    private BugFacade facade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()
    {
        return Response.status(200).entity(facade.getAll()).build();
//        return Response
//                .status(200)
//                .header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Credentials", "true")
//                .header("Access-Control-Allow-Headers",
//                        "origin, content-type, accept, authorization")
//                .header("Access-Control-Allow-Methods",
//                        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                .entity(facade.getAll())
//                .build();
    }

}
