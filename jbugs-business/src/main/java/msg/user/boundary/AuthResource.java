package msg.user.boundary;

import msg.user.entity.dto.UserInputDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
    public Response whatever(UserInputDTO userInputDTO) {
        System.out.println(userInputDTO.getEmail());
        return Response.ok(userFacade.authenticateUser(userInputDTO)).build();
    }

    @GET
    public Response whatever1() {
        return Response.ok().build();
    }


}
