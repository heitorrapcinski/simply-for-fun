#create database
docker exec setup-jboss-mssql-database-mssqlserver-1 /opt/mssql-tools18/bin/sqlcmd -No -H  database-mssqlserver -U sa -P P@ssW0rd -i /tmp/instnwnd.sql

#config JBoss
docker exec setup-jboss-mssql-middleware-jboss-1 /opt/jboss-eap-7.4/bin/jboss-cli.sh --file=/tmp/jboss-config.cli
docker exec setup-jboss-mssql-middleware-jboss-1 /opt/jboss-eap-7.4/bin/add-user.sh -e -u admin -p admin

