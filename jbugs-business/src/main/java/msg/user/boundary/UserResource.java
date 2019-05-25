package msg.user.boundary;

import msg.user.entity.dto.UserInputDTO;
import msg.user.entity.dto.UserLoginDTO;

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
//        /* todo: implement hasPermission
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
    @Path("/login")
    @POST
    public Response userLogin(UserLoginDTO input) {
        userFacade.loginUser(input);
        return Response.ok().build();
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
