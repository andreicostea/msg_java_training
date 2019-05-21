package msg.notifications.boundary.resource;

import msg.notifications.boundary.NotificationFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
@Path("/notifications")
public class NotificationResource {
    @EJB
    private NotificationFacade notificationFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("id") long id) {
        System.out.println("here");
        return Response.status(200)
                .entity(notificationFacade.getNotificationById(id))
                .build();

    }

}

