package msg.user.boundary;

import msg.user.entity.dto.UserInputDTO;

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
@Path("/auth")
public class AuthResource {
    @EJB
    UserFacade userFacade;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response whatever(UserInputDTO userInputDTO) {
        return Response.ok(userFacade.authenticateUser(userInputDTO)).build();
    }

    @GET
    public Response whatever1() {
        return Response.ok().build();
    }


}
