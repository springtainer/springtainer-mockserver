package com.avides.springboot.testcontainer.mockserver;

import static com.avides.springboot.testcontainer.mockserver.MockserverProperties.BEAN_NAME;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mockserver.client.server.MockServerClient;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

import com.avides.springboot.testcontainer.common.container.AbstractBuildingEmbeddedContainer;
import com.avides.springboot.testcontainer.common.container.EmbeddedContainer;

import lombok.Getter;

@Configuration
@ConditionalOnProperty(name = "embedded.container.mockserver.enabled", matchIfMissing = true)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties(MockserverProperties.class)
public class EmbeddedMockserverContainerAutoConfiguration
{
    @ConditionalOnMissingBean(MockserverContainer.class)
    @Bean(name = BEAN_NAME)
    public EmbeddedContainer mockserverContainer(ConfigurableEnvironment environment, MockserverProperties properties)
    {
        return new MockserverContainer("mockserver", environment, properties);
    }

    public class MockserverContainer extends AbstractBuildingEmbeddedContainer<MockserverProperties>
    {
        @Getter
        private MockServerClient mockServerClient;

        public MockserverContainer(String service, ConfigurableEnvironment environment, MockserverProperties properties)
        {
            super(service, environment, properties);
        }

        @Override
        protected List<String> getEnvs()
        {
            List<String> envs = new ArrayList<>();
            envs.add("LOG_LEVEL=" + properties.getLogLevel());
            return envs;
        }

        @Override
        protected Map<String, Object> providedProperties()
        {
            Map<String, Object> provided = new HashMap<>();
            provided.put("embedded.mockserver.host", getContainerHost());
            provided.put("embedded.mockserver.server-port", Integer.valueOf(getContainerPort(properties.getServerPort())));
            provided.put("embedded.mockserver.proxy-port", Integer.valueOf(getContainerPort(properties.getProxyPort())));
            provided.put("embedded.mockserver.url", "http://" + getContainerHost() + ":" + getContainerPort(properties.getServerPort()));
            return provided;
        }

        @Override
        protected boolean isContainerReady(MockserverProperties properties)
        {
            mockServerClient = new MockServerClient(getContainerHost(), getContainerPort(properties.getServerPort()));
            mockServerClient.when(HttpRequest.request().withMethod("POST")).respond(HttpResponse.response().withStatusCode(Integer.valueOf(200)));
            mockServerClient.reset();
            return true;
        }
    }
}
