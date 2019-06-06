package msg.user.boundary;

import msg.permission.PermissionType;
import msg.user.MessageCatalog;
import msg.user.entity.dto.UserInputDTO;
import msg.user.entity.dto.UserLoginDTO;
import msg.user.entity.dto.UserUpdateDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


@Stateless
@Path("/users")
public class UserResource {

    @EJB
    private UserFacade userFacade;

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    @POST
    public Response createUser(@Context SecurityContext securityContext, UserInputDTO input) {
        if (securityContext.isUserInRole(PermissionType.USER_MANAGEMENT)) {
            userFacade.createUser(input);
            return Response.ok("Successfully created!").build();
        }
        return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @PATCH
    public Response updateUser(@Context SecurityContext securityContext, UserUpdateDTO userUpdateDTO) {
        if (securityContext.isUserInRole(PermissionType.USER_MANAGEMENT)) {
            userFacade.updateUser(userUpdateDTO);
            return Response.ok("Successfully updated!").build();
        }
        return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
    }

    @Path("/{id}")
    @DELETE
    public Response deactivateUser(@Context SecurityContext securityContext, @PathParam("id") long id) {
        if (securityContext.isUserInRole(PermissionType.USER_MANAGEMENT)) {
            userFacade.deactivateUser(id);
            return Response.ok("Successfully deactivated!").build();
        }
        return Response.status(Response.Status.FORBIDDEN).build();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    @POST
    public Response userLogin(@HeaderParam("Authorization") String header, UserLoginDTO userLoginDTO) {
        return Response.ok(userFacade.authenticateUser(userLoginDTO)).build();
    }


    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAll(@Context SecurityContext securityContext) {
        if (securityContext.isUserInRole(PermissionType.USER_MANAGEMENT)) {
            return Response.ok(userFacade.getAll()).build();
        }
        return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @GET
    public Response getUserById(@Context SecurityContext securityContext, @PathParam("id") long id) {
        if (securityContext.isUserInRole(PermissionType.USER_MANAGEMENT)) {
            return Response.ok(userFacade.getUserById(id)).build();
        }
        return Response.status(Response.Status.FORBIDDEN).entity(MessageCatalog.PERMISSION_NOT_FOUND).build();
    }
}
