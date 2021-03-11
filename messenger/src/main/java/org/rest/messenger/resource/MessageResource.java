package org.rest.messenger.resource;

import java.util.List;

import javax.ws.rs.GET;
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
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_XML)
    public Message test(@PathParam("messageId") long id){
        Message message= messageService.getMessage(id);
        return message;
    }

}