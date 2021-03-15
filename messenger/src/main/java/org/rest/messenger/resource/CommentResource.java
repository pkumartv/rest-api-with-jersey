package org.rest.messenger.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Below is optional
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
    @GET 
    public String test(){
        return "Hola from comments a sub resource";
    }

    @GET
    @Path("/{commentId}")
    public String getCommentById(@PathParam("messageId") long messageId,
                                 @PathParam("commentId") long id
                                ){
        return "Comment for message("+messageId+") is id: "+id;
    }

    //TODO: implement other apis
    
}
