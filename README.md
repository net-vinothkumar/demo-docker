# demo-docker
How to create Docker Image and run Java App (Spring Boot Jar) in a Docker Engine | InterviewDot

# What is Docker ?

# What is the difference between VMs and Docker Containers ?

# Install Docker in your computer : 

https://hub.docker.com/editions/community/docker-ce-desktop-mac

# Create a new Spring Boot Rest Project using https://start.spring.io/

<img width="1076" alt="Screen Shot 2019-04-01 at 06 44 59" src="https://user-images.githubusercontent.com/30971809/55304033-be167780-5449-11e9-930f-c8651d749708.png">

# Start the spring boot demo app :
```$ mvn spring-boot:run```

As usual, the application will be running on port 8080. To test this endpoint, navigate your browser (or use curl, postman, etc.) to "http://localhost:8080/docker/interviewdot", you will see a response.

# Dockerizing the Spring Boot App
Dockerfile – Specifying a file that contains native Docker commands to build the image
A Dockerfile is just a regular .txt file that includes native Docker commands that are used to specify the layers of an image. 

```
FROM java:8-jdk-alpine

COPY ./target/demo-docker-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch demo-docker-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","demo-docker-0.0.1-SNAPSHOT.jar"]
```
