package org.rest.messenger.exception;

import java.util.logging.ErrorManager;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.rest.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

    @Override
    public Response toResponse(DataNotFoundException exception) {
        ErrorMessage errorMessage= new ErrorMessage(exception.getMessage(), 404, "http://localhost:8080/messenger/webapi/messages");
        return Response
                    .status(Status.NOT_FOUND)
                    .entity(errorMessage)
                    .build();
    }
    
}
