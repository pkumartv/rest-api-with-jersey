package org.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.Invocation.Builder;

import org.rest.messenger.model.Message;

public class RestApiClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        // Split
        // WebTarget target =
        // client.target("http://localhost:8080/messenger/webapi/messages/1");
        // Builder builder= target.request();
        // Response response=builder.get();
        //Message message = response.readEntity(Message.class);


        WebTarget baseTarget = client.target("http://localhost:8080/messenger/webapi/");
        WebTarget messagesTarget = baseTarget.path("messages");
        WebTarget singleMessagesTarget = messagesTarget.path("{messageId}");

        Message message1 = singleMessagesTarget.resolveTemplate("messageId", 1)
                    .request(MediaType.APPLICATION_JSON)
                    .get(Message.class);

        System.out.println("response " + message1.getMessage());

        Message message2 = singleMessagesTarget.resolveTemplate("messageId", 2)
        .request(MediaType.APPLICATION_JSON)
        .get(Message.class);

        System.out.println("response " + message2.getMessage());
    }

}
