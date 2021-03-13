package org.rest.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.rest.messenger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        ErrorMessage errorMessage= new ErrorMessage(exception.getMessage(), 500, "http://localhost:8080/messenger/webapi/messages");
        return Response
                    .status(Status.INTERNAL_SERVER_ERROR)
                    .entity(errorMessage)
                    .build();
    }
    

}
