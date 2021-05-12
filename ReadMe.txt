##########SpringBootTech############



3. http://0.0.0.0:9080/api/getHello
Method Type : GET

4. http://0.0.0.0:9080/api/getFibonacciSeries
Method Type : GET

Docker Build :
docker build -t springboottech .
docker run -it -d --name SpringBootTechAnalysis -p 9080:9080 springboottech

