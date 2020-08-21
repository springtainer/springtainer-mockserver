# springtainer-mockserver

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.avides.springboot.springtainer/springtainer-mockserver/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.avides.springboot.springtainer/springtainer-mockserver)
[![Build](https://github.com/springtainer/springtainer-mockserver/workflows/release/badge.svg)](https://github.com/springtainer/springtainer-mockserver/actions)
[![Nightly build](https://github.com/springtainer/springtainer-mockserver/workflows/nightly/badge.svg)](https://github.com/springtainer/springtainer-mockserver/actions)
[![Coverage report](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-mockserver&metric=coverage)](https://sonarcloud.io/dashboard?id=springtainer_springtainer-mockserver)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-mockserver&metric=alert_status)](https://sonarcloud.io/dashboard?id=springtainer_springtainer-mockserver)
[![Technical dept](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-mockserver&metric=sqale_index)](https://sonarcloud.io/dashboard?id=springtainer_springtainer-mockserver)

### Dependency
```xml
<dependency>
	<groupId>com.avides.springboot.springtainer</groupId>
	<artifactId>springtainer-mockserver</artifactId>
	<version>1.3.0-SNAPSHOT</version>
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
<!-- Springtainer -->
<logger name="com.github.dockerjava.jaxrs" level="WARN" />
<logger name="com.github.dockerjava.core.command" level="WARN" />
<logger name="org.apache.http" level="WARN" />
```

## Labels
The container exports multiple labels to analyze running springtainers:
- `SPRINGTAINER_SERVICE=mockserver`
- `SPRINGTAINER_IMAGE=${embedded.container.mockserver.docker-image}`
- `SPRINGTAINER_STARTED=$currentTimestamp`
