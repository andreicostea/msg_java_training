package msg.role.boundary;

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
@Path("/roles")
public class RoleResource {
    @EJB
    private RoleFacade roleFacade;

    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @GET
    public Response getRoleById(@PathParam("id") long id) {

        return Response.ok(roleFacade.getRoleById(id)).build();
    }
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAllRolesAndPermissions() {
        return Response.ok(roleFacade.getAllRolesAndPermissions()).header("Cache-Control", "no-cache").build();
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @POST
    public Response addPermision(@Context SecurityContext securityContext, @PathParam("id") Long id, PermissionDTO permissionDTO) {
        if (securityContext.isUserInRole(String.valueOf(PermissionType.PERMISSION_MANAGEMENT))) {
            return Response.ok(roleFacade.addPermission(id, permissionDTO).getPermissions()).build();
        }
        return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
    }
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    @Path("/types")
    public Response getAllRolesType() {
        return Response.ok(roleFacade.getAllRolesType()).build();
    }

}

