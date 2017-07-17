FROM openjdk:8u131-jre

MAINTAINER Richard Knowles "richard@inceptiontraining.co.uk"

ADD /target/fleetman-0.0.1-SNAPSHOT.war webapp.war

EXPOSE 8080

CMD ["java","-Dspring.profiles.active=docker","-Djava.security.egd=file:/dev/./urandom","-jar","webapp.war"]
