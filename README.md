springboot-testcontainer-mockserver
===================================

[![Maven Central](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/avides/springboot/testcontainer/springboot-testcontainer-mockserver/maven-metadata.xml.svg)](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.avides.springboot.testcontainer%22%20AND%20a%3A%22springboot-testcontainer-mockserver%22)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/3ef2b23118074ae7bbe52a3bd53defad)](https://www.codacy.com/app/avides-builds/springboot-testcontainer-mockserver)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/3ef2b23118074ae7bbe52a3bd53defad)](https://www.codacy.com/app/avides-builds/springboot-testcontainer-mockserver)
[![Build Status](https://travis-ci.org/springboot-testcontainer/springboot-testcontainer-mockserver.svg?branch=master)](https://travis-ci.org/springboot-testcontainer/springboot-testcontainer-mockserver)

### Dependency
```xml
<dependency>
	<groupId>com.avides.springboot.testcontainer</groupId>
	<artifactId>springboot-testcontainer-mockserver</artifactId>
	<version>0.1.0-RC8</version>
	<scope>test</scope>
</dependency>
```

### Configuration
Properties consumed (in `bootstrap-it.properties`):
- `embedded.container.mockserver.enabled` (default is `true`)
- `embedded.container.mockserver.startup-timeout` (default is `30`)
- `embedded.container.mockserver.docker-image` (default is `jamesdbloom/mockserver:mockserver-5.5.1`)
- `embedded.container.mockserver.server-port` (default is `1080`)
- `embedded.container.mockserver.proxy-port` (default is `1090`)

Properties provided (in `application-it.properties`):
- `embedded.container.mockserver.host`
- `embedded.container.mockserver.url`
- `embedded.container.mockserver.server-port`
- `embedded.container.mockserver.proxy-port`

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
