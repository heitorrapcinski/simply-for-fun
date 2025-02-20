FROM mcr.microsoft.com/mssql/server:2019-latest

COPY sources/instnwnd.sql /tmp/

RUN sqlcmd -i /tmp/instnwnd.sql