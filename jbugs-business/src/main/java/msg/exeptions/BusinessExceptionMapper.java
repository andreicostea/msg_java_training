package msg.exeptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessException> {
    @Override
    public Response toResponse(BusinessException e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getExceptionMessage()).build();
    }
}
