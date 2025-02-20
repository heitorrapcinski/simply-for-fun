FROM alpine

#prepare libraries and binaries
RUN apk update
RUN apk add openjdk8-jdk

COPY ./bin/jboss-eap-7.4.0.zip /tmp/

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

EXPOSE 8080 
EXPOSE 8443
EXPOSE 9990

CMD ["standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

#final
USER jboss
WORKDIR /home/jboss/





