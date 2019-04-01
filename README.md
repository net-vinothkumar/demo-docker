# demo-docker
How to create Docker Image and run Java App (Spring Boot Jar) in a Docker Engine | InterviewDot

# What is Docker ?

# Difference between VMs and Docker Containers ?
![vm vs containers](https://user-images.githubusercontent.com/30971809/55304291-08e4bf00-544b-11e9-8098-59eba5d6fdf4.jpg)


# Install Docker in your computer : 

https://hub.docker.com/editions/community/docker-ce-desktop-mac

# Create a new Spring Boot Rest Project using https://start.spring.io/

<img width="1076" alt="Screen Shot 2019-04-01 at 06 44 59" src="https://user-images.githubusercontent.com/30971809/55304033-be167780-5449-11e9-930f-c8651d749708.png">

# Start the spring boot demo app :
```$ mvn spring-boot:run```

As usual, the application will be running on port 8080. To test this endpoint, navigate your browser (or use curl, postman, etc.) to "http://localhost:8080/docker/interviewdot", you will see a response.

# Dockerizing the Spring Boot App :
Dockerfile – Specifying a file that contains native Docker commands to build the image
A Dockerfile is just a regular .txt file that includes native Docker commands that are used to specify the layers of an image. 

```
FROM java:8-jdk-alpine

COPY ./target/demo-docker-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch demo-docker-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","demo-docker-0.0.1-SNAPSHOT.jar"]
```
# Build the spring boot app docker image :
```
Vinoths-MBP:demo-docker vinothkumar$ docker build -t interviewdot:1 .
Sending build context to Docker daemon  16.96MB
Step 1/5 : FROM java:8-jdk-alpine
8-jdk-alpine: Pulling from library/java
709515475419: Pull complete 
38a1c0aaa6fd: Pull complete 
5b58c996e33e: Pull complete 
Digest: sha256:d49bf8c44670834d3dade17f8b84d709e7db47f1887f671a0e098bafa9bae49f
Status: Downloaded newer image for java:8-jdk-alpine
 ---> 3fd9dd82815c
Step 2/5 : COPY ./target/demo-docker-0.0.1-SNAPSHOT.jar /usr/app/
 ---> 9208a550a98b
Step 3/5 : WORKDIR /usr/app
 ---> Running in 31c435fa05a2
Removing intermediate container 31c435fa05a2
 ---> adc8c0999f8f
Step 4/5 : RUN sh -c 'touch demo-docker-0.0.1-SNAPSHOT.jar'
 ---> Running in 4894eb3036f0
Removing intermediate container 4894eb3036f0
 ---> a1b01ade8df8
Step 5/5 : ENTRYPOINT ["java","-jar","demo-docker-0.0.1-SNAPSHOT.jar"]
 ---> Running in fbb2e10ecae9
Removing intermediate container fbb2e10ecae9
 ---> fa4896fc6a0c
Successfully built fa4896fc6a0c
Successfully tagged interviewdot:1
```
# List the docker built images :
```
Vinoths-MBP:demo-docker vinothkumar$ docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
interviewdot        1                   fa4896fc6a0c        38 seconds ago      178MB
java                8-jdk-alpine        3fd9dd82815c        2 years ago         145MB
```
# Run the spring boot docker image :
```
Vinoths-MBP:demo-docker vinothkumar$ docker run -p 8080:8080 interviewdot:1

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.3.RELEASE)

2019-04-01 04:31:58.891  INFO 1 --- [           main] c.i.demodocker.DemoDockerApplication     : Starting DemoDockerApplication v0.0.1-SNAPSHOT on a01a869f87b2 with PID 1 (/usr/app/demo-docker-0.0.1-SNAPSHOT.jar started by root in /usr/app)
2019-04-01 04:31:58.894  INFO 1 --- [           main] c.i.demodocker.DemoDockerApplication     : No active profile set, falling back to default profiles: default
2019-04-01 04:32:00.105  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2019-04-01 04:32:00.173  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2019-04-01 04:32:00.174  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.16]
2019-04-01 04:32:00.187  INFO 1 --- [           main] o.a.catalina.core.AprLifecycleListener   : The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path: [/usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64/server:/usr/lib/jvm/java-1.8-openjdk/jre/lib/amd64:/usr/lib/jvm/java-1.8-openjdk/jre/../lib/amd64:/usr/java/packages/lib/amd64:/usr/lib64:/lib64:/lib:/usr/lib]
2019-04-01 04:32:00.268  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2019-04-01 04:32:00.269  INFO 1 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1332 ms
2019-04-01 04:32:00.508  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2019-04-01 04:32:00.704  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2019-04-01 04:32:00.708  INFO 1 --- [           main] c.i.demodocker.DemoDockerApplication     : Started DemoDockerApplication in 2.252 seconds (JVM running for 2.605)
2019-04-01 04:32:06.782  INFO 1 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2019-04-01 04:32:06.782  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2019-04-01 04:32:06.789  INFO 1 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 6 ms
```
# Access the spring boot docker app in http://localhost:8080/docker/interviewdot :
<img width="691" alt="Screen Shot 2019-04-01 at 06 56 14" src="https://user-images.githubusercontent.com/30971809/55304343-506b4b00-544b-11e9-9fbc-c04c885ef34a.png">
