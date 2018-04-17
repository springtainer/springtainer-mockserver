package com.avides.springboot.testcontainer.mockserver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MockserverPropertiesTest
{
    @Test
    public void testDefaults()
    {
        MockserverProperties properties = new MockserverProperties();
        assertTrue(properties.isEnabled());
        assertEquals(30, properties.getStartupTimeout());
        assertEquals("jamesdbloom/mockserver:mockserver-5.3.0", properties.getDockerImage());

        assertEquals(1080, properties.getServerPort());
        assertEquals(1090, properties.getProxyPort());
        assertEquals("ERROR", properties.getLogLevel());
    }
}
