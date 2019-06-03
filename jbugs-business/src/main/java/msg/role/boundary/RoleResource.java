package msg.role.boundary;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/roles")
public class RoleResource {

    @EJB
    private RoleFacade roleFacade;

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAllRoles() {
        return Response.ok(roleFacade.getAll()).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/types")
    public Response getAllRolesType(){
        return Response.ok(roleFacade.getAllRolesType()).build();
    }




}
