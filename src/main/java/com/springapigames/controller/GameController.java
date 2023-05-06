package com.springapigames.controller;

import com.springapigames.entity.Game;
import com.springapigames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    @Autowired
    private GameService gameService;

    public GameService getGameService() {
        return gameService;
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }


    @GetMapping("/search")
    public ResponseEntity<List<Game>> search(@RequestParam("keyword") String keyword){
        try {
            String decodedKeyword = java.net.URLDecoder.decode(keyword, "UTF-8");
            List<Game> games = gameService.search(decodedKeyword);
            if (games.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            else {
                return ResponseEntity.status(HttpStatus.OK).body(games);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getById(@PathVariable("id") Integer gameId){
        try {
            Game game = gameService.findById(gameId);
            return ResponseEntity.status(HttpStatus.OK).body(game);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }




    @PostMapping("/save")
    public ResponseEntity<Game> save(@RequestBody Game game){
        try {
            Game savedGame = gameService.save(game);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedGame);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> update(@PathVariable("id") Integer gameId, @RequestBody Game game) {
        try {
            game.setGameId(gameId);
            Game updatedGame = gameService.updateGame(game);
            return ResponseEntity.status(HttpStatus.OK).body(updatedGame);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer gameId) {
        try {
            gameService.delete(gameId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Game>> findAll() {
        try {
            List<Game> games = gameService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(games);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}
