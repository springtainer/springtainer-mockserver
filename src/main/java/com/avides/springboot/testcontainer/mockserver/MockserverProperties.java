package com.avides.springboot.testcontainer.mockserver;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.avides.springboot.testcontainer.common.container.AbstractEmbeddedContainerProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ConfigurationProperties("embedded.container.mockserver")
@Getter
@Setter
@ToString(callSuper = true)
public class MockserverProperties extends AbstractEmbeddedContainerProperties
{
    public static final String BEAN_NAME = "embeddedMockserverContainer";

    private int serverPort = 1080;

    private int proxyPort = 1090;

    private String logLevel = "ERROR";

    public MockserverProperties()
    {
        setDockerImage("jamesdbloom/mockserver:mockserver-5.3.0");
    }
}
