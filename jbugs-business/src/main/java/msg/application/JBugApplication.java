package msg.application;

import msg.user.boundary.UserResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("jbugs-api")
public class JBugApplication extends Application {

    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<>();
        classes.add(UserResource.class);

        return classes;
    }





}
