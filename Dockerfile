#FROM java:8-jdk-alpine
#EXPOSE 8085
#ADD /target/survey2020-1.0.war survey2020-1.0.war
#ENTRYPOINT ["java","-jar","survey2020-1.0.war"]

FROM ubuntu:latest
MAINTAINER sahanekanayake08@gmail.com

RUN apt-get update
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    apt-get install -y ant && \
    apt-get install -y wget && \
    apt-get clean;

RUN java -version

RUN apt-get install git -y
RUN git --version

RUN apt install maven -y
RUN mvn --version

RUN mkdir /opt/tomcat/
WORKDIR /opt/tomcat
RUN pwd
# RUN apt-get remove tomcat8

RUN wget http://apache.mirrors.spacedump.net/tomcat/tomcat-8/v8.5.47/bin/apache-tomcat-8.5.47.tar.gz

RUN tar xvfz apache*.tar.gz
RUN mv apache-tomcat-8.5.47/* /opt/tomcat/.
RUN ls
RUN ls /opt/tomcat/


RUN mkdir /opt/sahan/
WORKDIR /opt/sahan/
RUN git clone https://github.com/sahan89/SampleSurveyApplication.git
WORKDIR /opt/sahan/SampleSurveyApplication/
RUN pwd
RUN ls -al
RUN mvn clean install
RUN cp /opt/sahan/SampleSurveyApplication/target/survey2020-1.0.war /opt/tomcat/webapps/ survey2020

WORKDIR /opt/tomcat/webapps/
RUN ls -al
EXPOSE 8080
CMD ["/opt/tomcat/bin/catalina.sh", "run"]
