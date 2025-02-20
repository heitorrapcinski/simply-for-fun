Copy-Item "~\Bin\jboss*.zip" -Destination ".\bin"

docker build -t alpinelinux-jboss:latest -f .\setup-images\alpinelinux-jboss\Dockerfile .
docker build -t oraclelinux-jboss:latest -f .\setup-images\oraclelinux-jboss\Dockerfile .
docker build -t mssqlserver-2019:latest -f .\setup-images\mssqlserver-2019\Dockerfile .