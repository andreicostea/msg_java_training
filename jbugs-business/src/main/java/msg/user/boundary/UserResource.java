package msg.user.boundary;

import msg.user.entity.dto.UserInputDTO;
import msg.user.entity.dto.UserLoginDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    public Response createUser(UserInputDTO input){
        userFacade.createUser(input);
        return Response.ok().build();
    }


    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    @POST
    public Response userLogin(UserLoginDTO input){
        userFacade.loginUser(input);
        return Response.ok().build();
    }
}
