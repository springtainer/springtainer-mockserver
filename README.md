springboot-testcontainer-mockserver
==============================

[![Maven Central](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/avides/springboot/testcontainer/springboot-testcontainer-mockserver/maven-metadata.xml.svg)](https://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.avides.springboot.testcontainer%22%20AND%20a%3A%22springboot-testcontainer-mockserver%22)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/3ef2b23118074ae7bbe52a3bd53defad)](https://www.codacy.com/app/avides-builds/springboot-testcontainer-mockserver?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=springboot-testcontainer/springboot-testcontainer-mockserver&amp;utm_campaign=Badge_Grade)
[![Coverage Status](https://coveralls.io/repos/springboot-testcontainer/springboot-testcontainer-mockserver/badge.svg)](https://coveralls.io/r/springboot-testcontainer/springboot-testcontainer-mockserver)
[![Build Status](https://travis-ci.org/springboot-testcontainer/springboot-testcontainer-mockserver.svg?branch=master)](https://travis-ci.org/springboot-testcontainer/springboot-testcontainer-mockserver)

### Dependency
```xml
<dependency>
	<groupId>com.avides.springboot.testcontainer</groupId>
	<artifactId>springboot-testcontainer-mockserver</artifactId>
	<version>0.1.0-RC1</version>
	<scope>test</scope>
</dependency>
```

### Configuration
Properties consumed (in `bootstrap-it.properties`):
- `embedded.mockserver.enabled` (default is `true`)
- `embedded.mockserver.startup-timeout` (default is `30`)
- `embedded.mockserver.docker-image` (default is `jamesdbloom/mockserver:mockserver-5.3.0`)
- `embedded.mockserver.server-port` (default is `1080`)
- `embedded.mockserver.proxy-port` (default is `1090`)

Properties provided (in `application-it.properties`):
- `embedded.mockserver.host`
- `embedded.mockserver.server-port`
- `embedded.mockserver.proxy-port`

Example for minimal configuration in `application-it.properties`:
```
rest.any-mock-subject.url=http://${embedded.mockserver.host}:${embedded.mockserver.server-port}/
```

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
- `TESTCONTAINER_IMAGE=${embedded.mockserver.docker-image}`
- `TESTCONTAINER_STARTED=$currentTimestamp`