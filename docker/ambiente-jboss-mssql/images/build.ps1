Copy-Item "~\Bin\jboss*.zip" -Destination ".\bin"

docker build -t alpinelinux-jboss:latest -f .\setup\alpinelinux-jboss\Dockerfile .
docker build -t oraclelinux-jboss:latest -f .\setup\oraclelinux-jboss\Dockerfile .