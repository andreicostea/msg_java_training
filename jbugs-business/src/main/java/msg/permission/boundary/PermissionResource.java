package msg.permission.boundary;

import msg.permission.PermissionType;
import msg.permission.entity.dto.PermissionDTO;
import msg.user.MessageCatalog;

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
    public Response createPermission(@Context SecurityContext securityContext, PermissionDTO permissionDTO) {
        if (securityContext.isUserInRole(String.valueOf(PermissionType.PERMISSION_MANAGEMENT))) {
            return Response.ok(permissionFacade.createPermission(permissionDTO)).build();
        } else {
            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    @DELETE
    public Response removePermission(@Context SecurityContext securityContext,@PathParam("id") long id) {
        if (securityContext.isUserInRole(String.valueOf(PermissionType.PERMISSION_MANAGEMENT))) {
        System.out.println("deleted permission with id:" + id);
        permissionFacade.removePermission(id);
        return Response.ok().build(); }
    else{
        return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
        }
    }
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAll(@Context SecurityContext securityContext) {
        if (securityContext.isUserInRole(String.valueOf(PermissionType.PERMISSION_MANAGEMENT))) {
        return Response.ok(permissionFacade.getAll()).build();
        } else {
            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
        }
    }
}


