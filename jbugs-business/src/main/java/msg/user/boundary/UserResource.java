package msg.user.boundary;

import msg.user.entity.dto.UserInputDTO;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UserResource {

    @EJB
    private UserFacade userFacade;

    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response createUser(UserInputDTO input){
        userFacade.createUser(input);
        return Response.ok().build();
    }


    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response userLogin(UserInputDTO input){
        userFacade.loginUser(input);
        return Response.ok().build();
    }
}
