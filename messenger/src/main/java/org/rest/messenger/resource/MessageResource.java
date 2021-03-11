package org.rest.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rest.messenger.model.Message;
import org.rest.messenger.service.MessageService;

@Path("messages")
public class MessageResource{

    MessageService messageService= new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message test(@PathParam("messageId") long id){
        Message message= messageService.getMessage(id);
        return message;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message addMessage(Message message){
        return messageService.addMessage(message);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id,Message message){
        message.setId(id);
        return messageService.updateMessage(message);
    }


    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{messageId}")
    public Message deleteMessage(@PathParam("messageId") long id){
        return messageService.removeMessage(id);
    }
}