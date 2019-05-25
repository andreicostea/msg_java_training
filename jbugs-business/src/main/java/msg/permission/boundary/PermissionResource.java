package msg.permission.boundary;

import msg.permission.entity.dto.PermissionDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
@Path("/permissions")
public class PermissionResource {
    @EJB
    private PermissionFacade permissionFacade;

    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response createPermission(PermissionDTO permissionDTO) {
        return Response.ok(permissionFacade.createPermission(permissionDTO)).build();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @DELETE
    public Response removePermission(@PathParam("id") long id) {
        System.out.println("deleted permission with id:" + id);
        permissionFacade.removePermission(id);
        return Response.ok().build();
    }

}


