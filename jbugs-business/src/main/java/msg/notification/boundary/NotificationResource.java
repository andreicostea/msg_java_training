package msg.notification.boundary;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("id") long id) {
        System.out.println("here" + id);
        return Response.status(200)
                .entity(notificationFacade.getAllNotificationById(id))
                .build();

    }

    @GET
    @Path("/welcome/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWelcomeNotification(@PathParam("id") long id) {
        System.out.println("here");
        return Response.status(200)
                .entity(notificationFacade.getWelcomeNotificationById(id))
                .build();

    }

}

