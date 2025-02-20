FROM mcr.microsoft.com/mssql/server:2019-latest

ENV ACCEPT_EULA=Y
ENV MSSQL_SA_PASSWORD=P@ssW0rd

COPY ./sources/instnwnd.sql /tmp/

#RUN /opt/mssql-tools18/bin/sqlcmd -No -H localhost -U sa -P P@ssW0rd -i /tmp/instnwnd.sql