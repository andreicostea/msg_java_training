package msg.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BusinessWebAppExceptionMapper implements ExceptionMapper<BusinessWebAppException> {
    @Override
    public Response toResponse(BusinessWebAppException e) {
        return Response.status(e.getStatus()).entity(e.getExceptionMessage()).build();
    }
}
