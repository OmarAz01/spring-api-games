# Spring REST API
Spring | MySQL  
## Features  
Search games by keyword, add game, update game, find game, and remove game.  
## Installation
1. Clone the repo
2. Install MySQL
3. Create a new schema
4. Create an application.properties file under src/main/resources and fill it with the connection details that match your local MySQL installation
5. Build the application using Maven
6. Run the application  

## API Endpoints  
Here are the API endpoints available:  
- GET /api/v1/games/all: Returns all games
- GET /api/v1/games/search?keyword=(search keyword): Returns all games that contain any of the keywords either in the title or description of the game
- GET /api/v1/games/{id}: Returns game with that id
- POST /api/v1/games/save: Saves a new game into the database
- PUT /api/v1/games/{id}: Updates the game with that id with the new fields
- DELETE /api/v1/games/{id}: Deletes game with that id
