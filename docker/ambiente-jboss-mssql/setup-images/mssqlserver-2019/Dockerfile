FROM mcr.microsoft.com/mssql/server:2019-latest

COPY ./sources/instnwnd.sql /tmp/

EXPOSE 1433

#final
USER mssql
WORKDIR /home/mssql/
