FROM tomcat:latest

COPY ./src /var/pfe-test/src

RUN ["/bin/bash", "-c", "cp /var/pfe-test/src/ws-a/target/ws-a.war /usr/local/tomcat/webapps/"]
RUN ["/bin/bash", "-c", "cp /var/pfe-test/src/ws-b/target/ws-b.war /usr/local/tomcat/webapps/"]
RUN ["/bin/bash", "-c", "cp /var/pfe-test/src/ws-c/target/ws-c.war /usr/local/tomcat/webapps/"]
RUN ["/bin/bash", "-c", "cp /var/pfe-test/src/ws-d/target/ws-d.war /usr/local/tomcat/webapps/"]
