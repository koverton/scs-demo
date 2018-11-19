# scs-demo
SpringCloudStreams demo with Solace messaging.

## Example: `Source`, `Processor` and `Sink` Microservices

This is an INCOMPLETE example of a SpringCloudStreams pipeline starting with a
`Source` that produces an event, a `Processor` which consumes that event
produces a new event, and a `Sink` which just consumes the final event.

```
    [Source] ->event-> [Processor] ->event-> [Sink]
```

For this example, imagine a community site where users can signup for
an email newsletter. The API Gateway simply converts the request to a
JSON message on your EventMesh bus for consumption by a bunch of
UserSignupEvent processor Microservices which implement the SpringCloudStreams
`Processor` class to send an introductory email to the new users and
produce an EmailSentEvent to the EventMesh representing that fact.

Rather than tightly-coupling any additional behavior directly to the
UserSignupEvent processor, additional features and behavior can be
added without affecting these upstream Microservices by adding new
Microservices that handle the EmailSentEvent. In this example, a simple
logging service is added to log the EmailSentEvent.

The logical pipeline looks like this:

```
    [APIGW] ->UserSignupEvent-> [EmailSender] ->EmailSentEvent-> [EmailSentLogger]
```

## Configuring the Solace Binding

Each project contains an application.yml file with a  SpringCloudStreams
configuration. Here is where you put your appropriate connectivity
details for your Solace broker. For example, the following will bind
to a Solace message-broker running under the localhost Docker daemon:

```yml
---
spring:
  cloud:
    stream:
      bindings:
        output:
          destination: "newsletter/accounts/1.0/user/signup"
          content-type: "application/json"
solace:
  java:
    host: tcp://localhost
    msgVpn: default
    clientUsername: default
    clientPassword: default
    connectRetries: -1
    reconnectRetries: -1
server:
  port: 9096
```

## Project Structure and Building

Each process is a separate maven project and can be build and run directly
as an executable jar:

```bash
cd sink
mvn install
java -jar target/*.jar
```

## Deploying to CloudFoundry

Assuming your `cf` tools and environment are setup, you can create a
very simple `manifest.yml` in the root of each project with the
path to that project's JAR file, and optionally binding it to a CF
Solace service in the target CF foundation. then deploy it via `cf push`.
For example:

```yml
---
applications:
- name: DemoProcessorApp
  memory: 1G
  path: target/processor-1.0-SNAPSHOT.jar
  services:
  - SolaceEventMesh
```