# springtainer-mockserver

[![Maven Central](https://img.shields.io/maven-central/v/com.avides.springboot.springtainer/springtainer-mockserver.svg?label=maven-central)](https://search.maven.org/artifact/com.avides.springboot.springtainer/springtainer-mockserver)
[![Release](https://github.com/springtainer/springtainer-mockserver/actions/workflows/release.yml/badge.svg)](https://github.com/springtainer/springtainer-mockserver/actions/workflows/release.yml)
[![Nightly build](https://github.com/springtainer/springtainer-mockserver/actions/workflows/nightly.yml/badge.svg)](https://github.com/springtainer/springtainer-mockserver/actions/workflows/nightly.yml)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-mockserver&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=springtainer_springtainer-mockserver)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=springtainer_springtainer-mockserver&metric=coverage)](https://sonarcloud.io/summary/new_code?id=springtainer_springtainer-mockserver)

### Dependency

```xml
<dependency>
  <groupId>com.avides.springboot.springtainer</groupId>
  <artifactId>springtainer-mockserver</artifactId>
  <version>2.0.0-RC1</version>
  <scope>test</scope>
</dependency>
```

### Configuration

Properties consumed (in `bootstrap-it.properties`):

- `embedded.container.mockserver.enabled` (default is `true`)
- `embedded.container.mockserver.startup-timeout` (default is `30`)
- `embedded.container.mockserver.docker-image` (default is `mockserver/mockserver:mockserver-5.15.0`)
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
