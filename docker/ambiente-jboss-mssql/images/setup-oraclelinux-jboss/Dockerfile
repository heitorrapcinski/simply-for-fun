FROM oraclelinux:9

#prepare libraries and binaries
RUN yum update -y
RUN yum install -y unzip java-1.8.0-openjdk-devel.x86_64
COPY bin/jboss-eap-7.4.0.zip /tmp/

#add user
RUN adduser jboss

#install jboss
RUN unzip /tmp/jboss-eap-7.4.0.zip -d /opt/
RUN chown -R jboss:jboss /opt/jboss-eap-7.4/
RUN rm /tmp/jboss-eap-7.4.0.zip

#envinronment
ENV JAVA_HOME=/etc/alternatives/java_sdk
ENV JBOSS_HOME=/opt/jboss-eap-7.4
ENV JBOSS_USER=jboss
ENV PATH=$PATH:$JBOSS_HOME/bin

#configure service
#RUN cp ${JBOSS_HOME}/bin/init.d/jboss-eap.conf /etc/default/
#RUN cp ${JBOSS_HOME}/bin/init.d/jboss-eap-rhel.sh /etc/init.d/

EXPOSE 8080 
EXPOSE 8443
EXPOSE 9990

CMD ["standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

#final
USER jboss
WORKDIR /home/jboss/





