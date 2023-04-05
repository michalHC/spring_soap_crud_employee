# spring_soap_crud_employee
Sample spring soap service

based on https://www.concretepage.com/spring-boot/spring-boot-soap-web-service-example 
adjusted for employee table layout


db run in docker:
```
docker run --name mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d -p 3306:3306 mysql:latest
```

get into container:
```
docker exec -it mysql /bin/bash
```