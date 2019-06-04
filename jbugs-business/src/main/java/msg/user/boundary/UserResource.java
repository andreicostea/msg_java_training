package msg.user.boundary;

import msg.user.entity.dto.UserInputDTO;
import msg.user.entity.dto.UserLoginDTO;
import msg.user.entity.dto.UserUpdateDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/users")
public class UserResource {

    @EJB
    private UserFacade userFacade;

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    @POST
    public Response createUser(UserInputDTO input, @HeaderParam("authorization") String connectedUserToken) {
//        /*
//        * should decode the token and check if the user has the neccesary permission(s)
//        */

//        if (hasPermission(connectedUserToken, PermissionType.USER_MANAGEMENT)) {
//            userFacade.createUser(input);
//            return Response.ok().build();
//        }
        userFacade.createUser(input);
        return Response.ok().build();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @PATCH
    public Response updateUser(UserUpdateDTO userUpdateDTO) {
        System.out.println(userUpdateDTO.getFirstName());
        userFacade.updateUser(userUpdateDTO);
        return Response.ok("Successfully updated!").build();
    }

    @Path("{id}")
    @DELETE
    public Response deactivateUser(@PathParam("id") int id) {
        userFacade.deactivateUser(id);
        return Response.ok("Successfully deactivated!").build();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    @POST
    public Response userLogin(@HeaderParam("Authorization") String header, UserLoginDTO userLoginDTO) {
        return Response.ok(userFacade.authenticateUser(userLoginDTO)).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getAll() {
        return Response.ok(userFacade.getAll()).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    @GET
    public Response getUserById(@PathParam("id") long id) {
        return Response.ok(userFacade.getUserById(id)).build();
    }
}
