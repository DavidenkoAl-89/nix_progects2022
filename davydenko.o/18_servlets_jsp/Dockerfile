
FROM maven:latest AS build
COPY pom.xml /18_servlets_jsp/
COPY src /18_servlets_jsp/src/
WORKDIR /18_servlets_jsp/
RUN mvn -f /18_servlets_jsp clean package

FROM  tomcat:7
COPY --from=build /18_servlets_jsp/target/18_servlets_jsp.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh", "run"]



