package msg.bug.boundary;

import msg.bug.entity.dto.BugDTO;
import msg.bug.entity.dto.BugInputDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/bugs")
public class BugResource {
    @EJB
    private BugFacade facade;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBug(BugInputDTO input)
    {
        facade.createBug(input);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBug(BugDTO input)
    {
        //facade.updateBug(input);
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll()
    {
        return Response.status(200).entity(facade.getAll()).build();
        //return Response.ok().build();
    }

}
