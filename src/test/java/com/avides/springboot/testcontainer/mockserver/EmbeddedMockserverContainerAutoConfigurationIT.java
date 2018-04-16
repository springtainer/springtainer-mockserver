package com.avides.springboot.testcontainer.mockserver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

public class EmbeddedMockserverContainerAutoConfigurationIT extends AbstractIT
{
    @Test
    public void testGeneratedProperties() throws InterruptedException
    {
        assertThat(environment.getProperty("embedded.mockserver.host")).isNotEmpty();
        assertThat(environment.getProperty("embedded.mockserver.server-port")).isNotEmpty();
        assertThat(environment.getProperty("embedded.mockserver.proxy-port")).isNotEmpty();

        System.out.println();
        System.out.println("Resolved properties:");
        System.out.println("Host:           " + environment.getProperty("embedded.mockserver.host"));
        System.out.println("Server Port:    " + environment.getProperty("embedded.mockserver.server-port"));
        System.out.println("Proxy Port:     " + environment.getProperty("embedded.mockserver.proxy-port"));
        System.out.println();
    }

    @Test
    public void testMockserverService() throws Exception
    {
        mockServerClient.when(HttpRequest.request().withMethod("POST").withPath("/test"))
                .respond(HttpResponse.response().withStatusCode(Integer.valueOf(666)));
        URL url = new URL("http://" + environment.getProperty("embedded.mockserver.host") + ":" + environment
                .getProperty("embedded.mockserver.server-port") + "/test");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        assertEquals(666, urlConnection.getResponseCode());
    }

    @Configuration
    @EnableAutoConfiguration
    static class TestConfiguration
    {
        // nothing
    }
}
