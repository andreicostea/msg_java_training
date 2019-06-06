package msg.bug.boundary;
//todo: fix bug insertion and update [specifically, the part with users]

import msg.bug.entity.dto.BugDTO;
import msg.bug.entity.dto.BugInputDTO;
import msg.permission.PermissionType;
import msg.user.MessageCatalog;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Stateless
@Path("/bugs")
public class BugResource {
    @EJB
    private BugFacade facade;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBug(@Context SecurityContext securityContext, BugInputDTO input) {
        if (securityContext.isUserInRole(PermissionType.BUG_MANAGEMENT)) {
            facade.createBug(input);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBug(@Context SecurityContext securityContext, BugDTO input) {
        if (securityContext.isUserInRole(PermissionType.BUG_MANAGEMENT)) {
            facade.updateBug(input);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@Context SecurityContext securityContext) {
        if (securityContext.isUserInRole(PermissionType.BUG_MANAGEMENT)) {
            return Response.status(200).entity(facade.getAll()).build();
        } else {
            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();

        }
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/status-limited/{status}")
    @GET
    public Response getStatusLimited(@Context SecurityContext securityContext, @PathParam("status") String status) {
        if (securityContext.isUserInRole(PermissionType.BUG_MANAGEMENT)) {
            return Response.ok(facade.getStatusBugLimited(status)).build();

        } else
            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("/status-all/{status}")
    @GET
    public Response getStatusAll(@Context SecurityContext securityContext, @PathParam("status") String status) {
        if (securityContext.isUserInRole(PermissionType.BUG_CLOSED)) {
            return Response.ok(facade.getStatusBugComplete(status)).build();
        } else
            return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
    }

}


