package com.avides.springboot.springtainer.mockserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MockserverPropertiesTest
{
    @Test
    public void testDefaults()
    {
        MockserverProperties properties = new MockserverProperties();
        assertTrue(properties.isEnabled());
        assertEquals(30, properties.getStartupTimeout());
        assertEquals("mockserver/mockserver:mockserver-7.4.0", properties.getDockerImage());

        assertEquals(1080, properties.getServerPort());
        assertEquals("ERROR", properties.getLogLevel());
    }
}
