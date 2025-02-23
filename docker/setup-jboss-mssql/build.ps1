Copy-Item "~\Bin\jboss*.zip" -Destination ".\bin"
Copy-Item "~\Bin\mssql*.jar" -Destination ".\bin"

#build images
docker build -t alpinelinux-jboss:latest -f .\setup-images\alpinelinux-jboss\Dockerfile .
docker build -t oraclelinux-jboss:latest -f .\setup-images\oraclelinux-jboss\Dockerfile .

#start services
docker-compose up




