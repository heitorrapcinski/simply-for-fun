FROM alpine

#prepare libraries and binaries
RUN apk update
RUN apk add openjdk8-jdk

COPY bin/jboss-eap-7.4.0.zip /tmp/
COPY bin/mssql-jdbc-12.8.1.jre8 /tmp/

#add user
RUN adduser -D jboss jboss

#install jboss
RUN unzip /tmp/jboss-eap-7.4.0.zip -d /opt/
RUN chown -R jboss:jboss /opt/jboss-eap-7.4/
RUN rm /tmp/jboss-eap-7.4.0.zip

#envinronment
ENV JAVA_HOME=/usr/lib/jvm/default-jvm
ENV JBOSS_HOME=/opt/jboss-eap-7.4
ENV JBOSS_USER=jboss
ENV PATH=$PATH:$JBOSS_HOME/bin

#install jdbc driver
RUN mkdir -p $JBOSS_HOME/modules/system/layers/base/com/microsoft/main/
RUN mv /tmp/mssql-jdbc-12.8.1.jre8.jar $JBOSS_HOME/modules/system/layers/base/com/microsoft/main/

EXPOSE 8080 
EXPOSE 8443
EXPOSE 9990

CMD ["standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

#final
USER jboss
WORKDIR /home/jboss/





