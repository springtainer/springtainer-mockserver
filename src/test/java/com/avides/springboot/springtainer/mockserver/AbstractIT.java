package com.avides.springboot.springtainer.mockserver;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockserver.client.MockServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.avides.springboot.springtainer.common.util.DockerClients;
import com.github.dockerjava.api.DockerClient;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DirtiesContext
public abstract class AbstractIT
{
    protected DockerClient dockerClient = DockerClients.build();

    @Autowired
    protected ConfigurableEnvironment environment;

    @Autowired
    protected MockServerClient mockServerClient;
}
