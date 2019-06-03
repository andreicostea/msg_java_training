package msg.application;

import msg.bug.boundary.BugResource;
import msg.exceptions.BusinessExceptionMapper;
import msg.exceptions.BusinessWebAppExceptionMapper;
import msg.filters.AuthorizationFilter;
import msg.notification.boundary.NotificationResource;
import msg.permission.boundary.PermissionResource;
import msg.role.boundary.RoleResource;

import msg.user.boundary.AuthResource;
import msg.user.boundary.UserResource;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@ApplicationPath("jbugs-api")
public class JBugsApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(AuthorizationFilter.class);
        classes.add(NotificationResource.class);
        classes.add(UserResource.class);
        classes.add(BusinessExceptionMapper.class);
        classes.add(BusinessWebAppExceptionMapper.class);
        classes.add(PermissionResource.class);
        classes.add(BugResource.class);
        classes.add(RoleResource.class);

//        classes.add(BusinessExceptionMapper.class);
//        classes.add(RuntimeExceptionMapper.class);
//        classes.add(AuthResource.class);
//        classes.add(AuthorizationFilter.class);
//        some random change to test git
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> set = new HashSet<>();
        set.add(new JacksonJsonProvider());
        return set;
    }

}
