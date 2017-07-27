FROM tomcat:8.5.16-jre8

MAINTAINER Richard Chesterwood "contact@virtualpairprogrammers.com"

RUN rm -rf ./webapps/*

EXPOSE 8080

ENV JAVA_OPTS="-Dspring.profiles.active=docker-demo"

ADD target/fleetman-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]