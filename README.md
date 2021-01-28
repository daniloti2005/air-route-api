# air-route-api

This project is developed to be used as an API to test the library air-route-common, that is responsible for manipulate graph data structure and perform dijkstra diagram.

## How to compile
```maven
mvn clean install spring-boot:run
```

## How to test

* Import public postman public collection: https://www.getpostman.com/collections/687feaeceb7b92de5d0a
* Or use this curl commands: 
  * To post new route:
```
  curl --location --request POST 'localhost:8080/route' \
--header 'Content-type: application/json' \
--data-raw '{
    "origin": "Sumare", 
    "destination": "Campinas",
    "cost": 1
}'
```
  * search by id:
  ```
  curl --location --request GET 'localhost:8080/route/1'
 ```
 
 * search all:
 ```
 curl --location --request GET 'localhost:8080/routes'
 ```
 
 * change already added:
 ```
 curl --location --request PUT 'localhost:8080/route/1' \
--header 'Content-type: application/json' \
--data-raw '{
    "origin": "Sumare", 
    "destination": "Campinas",
    "cost": 1
}'
```
 * delete by Id
  ```
 curl --location --request DELETE 'localhost:8080/route/1'
  ```
  
  * perform dijkstra between two points already added
   ```curl
   curl --location --request POST 'localhost:8080/dijkstra' \
--header 'Content-type: application/json' \
--data-raw '{
    "origin": "GRU", 
    "destination": "CDG"
}'
```
   
 
 
 

