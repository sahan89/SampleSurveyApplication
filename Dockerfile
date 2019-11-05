FROM java:8-jdk-alpine
EXPOSE 8085
ADD /target/survey2020-1.0.war survey2020-1.0.war
ENTRYPOINT ["java","-jar","survey2020-1.0.war"]
