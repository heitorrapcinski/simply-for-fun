Copy-Item "~\Bin\jboss*.zip" -Destination ".\bin"
Copy-Item "~\Bin\mssql*.jar" -Destination ".\bin"

#build images
docker build -t alpinelinux-jboss:latest -f .\setup-images\alpinelinux-jboss\Dockerfile .
docker build -t oraclelinux-jboss:latest -f .\setup-images\oraclelinux-jboss\Dockerfile .

#start services
docker-compose up

#config JBoss

#create database
docker exec ambiente-jboss-mssql-database-mssqlserver-1 /opt/mssql-tools18/bin/sqlcmd -No -H  database-mssqlserver -U sa -P P@ssW0rd -i /tmp/instnwnd.sql



