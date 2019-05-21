package msg.exeptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RuntimeExceptionMapper implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Unexcepted error occurred").build();
    }
}
