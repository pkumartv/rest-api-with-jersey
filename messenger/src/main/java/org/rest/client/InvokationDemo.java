package org.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.eclipse.persistence.oxm.MediaType;

public class InvokationDemo {
    public static void main(String[] args) {
       Invocation invocation= prepareRequestForMessagesByYear(2015);
       Response response = invocation.invoke();
       System.out.println(response.getStatus());
    }

    private static Invocation prepareRequestForMessagesByYear(int year) {
        Client client = ClientBuilder.newClient();
        return client.target("http://localhost:8080/messenger/webapi/")
                                .path("messages")
                                .queryParam("year", year)
                                .request()
                                .buildGet();

                                // /messages?year=2015
    }
}
