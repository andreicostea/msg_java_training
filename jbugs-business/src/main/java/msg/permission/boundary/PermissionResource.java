package msg.permission.boundary;

import msg.permission.entity.dto.PermissionDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
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
        return Response.ok().header("Cache-Control", "no-cache").build();
    }

    //Asta cu token ce o zis catalin
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/test")
    @GET
    public Response createUser(@Context SecurityContext securityContext) {
        return Response.ok(securityContext.isUserInRole("PERMISSION MANAGER")).build();
    }

    //get for permissions
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAll() {
        return Response.ok(permissionFacade.getAll()).build();
    }

}


