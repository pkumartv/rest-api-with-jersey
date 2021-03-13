package org.rest.messenger.resource;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.rest.messenger.model.Message;
import org.rest.messenger.resource.beans.MessageFilterBean;
import org.rest.messenger.service.MessageService;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filter) 
    {
        if(filter.getYear() > 0){
            return messageService.getAllMessagesForYear(filter.getYear());            
        }
        if(filter.getStart() > 0 && filter.getSize() >0)
            return messageService.getAllMessagesPaginated(filter.getStart(), filter.getSize());
        
            return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    public Message test(@PathParam("messageId") long id) {
        Message message = messageService.getMessage(id);
        return message;
    }

    @POST
    public Response addMessage(Message message,@Context UriInfo uriInfo) {
        // return Response.status(Status.CREATED)
        //         .entity(newMessage)
        //         .build();

        Message newMessage= messageService.addMessage(message);
        String newId=String.valueOf(newMessage.getId());
        URI uri= uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri)
                        .entity(newMessage)
                        .build();                
        //return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id, Message message) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public Message deleteMessage(@PathParam("messageId") long id) {
        return messageService.removeMessage(id);
    }

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource(){
        return new CommentResource();
    }
}