# springboot-testcontainer-mockserver

[![Maven Central](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/avides/springboot/testcontainer/springboot-testcontainer-mockserver/maven-metadata.xml.svg)](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.avides.springboot.testcontainer%22%20AND%20a%3A%22springboot-testcontainer-mockserver%22)
[![Build](https://github.com/springboot-testcontainer/springboot-testcontainer-mockserver/workflows/release/badge.svg)](https://github.com/springboot-testcontainer/springboot-testcontainer-mockserver/actions)
[![Nightly build](https://github.com/springboot-testcontainer/springboot-testcontainer-mockserver/workflows/nightly/badge.svg)](https://github.com/springboot-testcontainer/springboot-testcontainer-mockserver/actions)
[![Coverage report](https://sonarcloud.io/api/project_badges/measure?project=springboot-testcontainer_springboot-testcontainer-mockserver&metric=coverage)](https://sonarcloud.io/dashboard?id=springboot-testcontainer_springboot-testcontainer-mockserver)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=springboot-testcontainer_springboot-testcontainer-mockserver&metric=alert_status)](https://sonarcloud.io/dashboard?id=springboot-testcontainer_springboot-testcontainer-mockserver)
[![Technical dept](https://sonarcloud.io/api/project_badges/measure?project=springboot-testcontainer_springboot-testcontainer-mockserver&metric=sqale_index)](https://sonarcloud.io/dashboard?id=springboot-testcontainer_springboot-testcontainer-mockserver)

### Dependency
```xml
<dependency>
	<groupId>com.avides.springboot.testcontainer</groupId>
	<artifactId>springboot-testcontainer-mockserver</artifactId>
	<version>1.0.0-RC1</version>
	<scope>test</scope>
</dependency>
```

### Configuration
Properties consumed (in `bootstrap-it.properties`):
- `embedded.container.mockserver.enabled` (default is `true`)
- `embedded.container.mockserver.startup-timeout` (default is `30`)
- `embedded.container.mockserver.docker-image` (default is `jamesdbloom/mockserver:mockserver-5.7.1`)
- `embedded.container.mockserver.server-port` (default is `1080`)

Properties provided (in `application-it.properties`):
- `embedded.container.mockserver.host`
- `embedded.container.mockserver.url`
- `embedded.container.mockserver.server-port`

Example for minimal configuration in `application-it.properties`:
```
rest.any-mock-subject.url=${embedded.container.mockserver.url}
```

A properly configured MockServerClient is available as bean.

## Logging
To reduce logging insert this into the logback-configuration:
```xml
<!-- Testcontainers -->
<logger name="com.github.dockerjava.jaxrs" level="WARN" />
<logger name="com.github.dockerjava.core.command" level="WARN" />
<logger name="org.apache.http" level="WARN" />
```

## Labels
The container exports multiple labels to analyze running testcontainers:
- `TESTCONTAINER_SERVICE=mockserver`
- `TESTCONTAINER_IMAGE=${embedded.container.mockserver.docker-image}`
- `TESTCONTAINER_STARTED=$currentTimestamp`
