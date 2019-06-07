package msg.notification.boundary;

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
@Path("/notifications")
public class NotificationResource {
    @EJB
    private NotificationFacade notificationFacade;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("id") long id) {
        return Response.ok()
                .entity(notificationFacade.getAllNotificationById(id))
                .build();
    }

    @GET
    @Path("/welcome/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWelcomeNotificationById(@PathParam("id") long id) {
        return Response.status(200)
                .entity(notificationFacade.getWelcomeNotificationById(id))
                .build();
    }

    @GET
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUpdateNotificationById(@PathParam("id") long id) {
        return Response.status(200)
                .entity(notificationFacade.getUpdateNotificationById(id))
                .build();

    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteNotificationsPeriodically( ) {

            notificationFacade.deleteNotificationsPeriodically();
            return Response.ok()
                    .build();


    }


}

