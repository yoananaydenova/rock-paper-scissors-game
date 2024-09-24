# Rock, Paper, Scissors Game

Objective: Write a server-side application that allows a user to play Rock, Paper, Scissors against a computer.

Requirements:

1. Game Functionality:
   - Start Game: Create an endpoint to initialize a new game session.
   - Make Moves: Create an endpoint to receive the player’s choice (rock, paper, or scissors) and determine the outcome against the computer's choice.
   - Terminate Game: Create an endpoint to allow the user to end the game session.
2. Web Application:
   - The application should be developed as a web service.
   - No user interface is required; focus solely on the server-side logic.
3. Code Quality:
   - Emphasize clarity and simplicity in your code.
   - Ensure the code is well-structured and easy to read.
   - Consider performance and how to manage game states efficiently. 
4. Creativity:
   - You have the freedom to choose how to implement the game logic and structure your application.
   - Feel free to include any additional features or enhancements you think would improve the application.

# RESULT

**1. Description**
        
Тhis application is built with Spring Boot 3, Java 17 and uses MySQL for database. 
It is a server-side game of "Rock, Paper, Scissors" that allows the user to play against the computer.
There are Integration and Unit tests of some basic functionalities.

**2. Tech stack**
- Spring Boot 3
- Java 17
- MySQL 
- Maven
- JUnit, Mockito
- [MapStruct](https://mapstruct.org)
- [Swagger and OpenAPI](https://swagger.io/)

**3. Design**

 - no

**4. Features**

 - Swagger UI

**5. How to run the project**

 - Clone the application

```bash
git clone  https://github.com/yoananaydenova/rock-paper-scissors-game.git
```

 - Change mysql username and password as per your installation

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation
 - Run the app using maven as run the following command in a terminal window (in the project directory):

```bash
./mvnw spring-boot:run
```

The app will start running at <http://localhost:8080>.

**6. Explore Rest APIs**

The app defines following CRUD APIs.

  Home: 
```bash 
GET /
```

  Find game by id: 
```bash
GET /game/{gameId}
 ```
    
  Start game: 
```bash
POST /start
```
    
  Play game:
```bash
PUT /game
```
    
  Stop game: 
```bash
PUT /stop/{gameId}
```

You can test them using postman, Swagger or any other rest client.

Once the application is running, you can access the Swagger UI at <http://localhost:8080/swagger-ui/index.html>.  