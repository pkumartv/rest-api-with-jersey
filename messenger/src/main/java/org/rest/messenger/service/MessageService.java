package org.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.rest.messenger.model.Message;

public class MessageService {
    
    public List<Message> getMessages(){
        List<Message> messageList= new ArrayList<Message>();
        Message m1= new Message(1L, "Hola Amigos", "Pavan");
        Message m2= new Message(2L, "Hello folks", "Kiran");

        messageList.add(m1);
        messageList.add(m2);

        return messageList;
    }
}
