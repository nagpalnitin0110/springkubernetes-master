##########SpringBootTech############

Developer=Bikash Kaushik

1. http://0.0.0.0:9080/api/getDBDetails
Method Type : GET

3. http://0.0.0.0:9080/api/getHello
Method Type : GET

4. http://0.0.0.0:9080/api/getFibonacciSeries
Method Type : GET

Docker Build :
docker build -t springboottech .
docker run -it -d --name SpringBootTechAnalysis -p 9080:9080 springboottech

SQL Schema :
create table Employee(FirstName varchar(30),LastName varchar(30),Company varchar(30));
insert into Employee values('Bikash','Kaushik','Keenable');

Environment Variables used :
1. DATASOURCE.URL
2. DATASOURCE.USERNAME
3. DATASOURCE.PASSWORD
