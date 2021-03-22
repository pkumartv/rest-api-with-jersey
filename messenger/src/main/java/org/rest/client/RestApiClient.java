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
        Message message = client
                    .target("http://localhost:8080/messenger/webapi/messages/2")
                    .request(MediaType.APPLICATION_JSON)
                    .get(Message.class);
        // Split
        // WebTarget target =
        // client.target("http://localhost:8080/messenger/webapi/messages/1");
        // Builder builder= target.request();
        // Response response=builder.get();
        //Message message = response.readEntity(Message.class);
        System.out.println("response " + message.getMessage());
    }

}
