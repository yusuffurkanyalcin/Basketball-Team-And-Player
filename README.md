# Basketball Team Player ( Producter Task ) 

### Features
- JDK 17
- Spring Boot 2.6.7
- Mockito 
- JUnit5
- GraphQL

### API
- `For Scratch URL = http://localhost:8090/graphql`
- `GUI URL         = http://localhost:8090/graphiql `
- ```
  POST http://localhost:8090/graphql
  Content-Type: application/json
  
  {
    "query" : "mutation{ 
         removePlayer(playerId:.....){
             status
         }
    }
  "}
  ```
- ```
  POST http://localhost:8090/graphql
  Content-Type: application/json
  
  {
  "query": "mutation{createPlayer(\n  request:{\n    teamId:1,\n    name:\"John\",\n    surname:\"John\",\n    position:PG,\n  }\n){\n  data{\n    id,\n    team\n  }\n}}\n"}
  ```
- ```
  POST http://localhost:8090/graphql
  Content-Type: application/json

  {
     "query": "query{ 
          getAll{ 
              id,
              name, 
              team, 
              position , 
              createdAt 
          }
     }"
  }
  ```
