package com.springapigames.service.impl;

import com.springapigames.entity.Game;
import com.springapigames.repo.GameRepo;
import com.springapigames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepo gameRepo;

    public GameRepo getGameRepo() {
        return gameRepo;
    }

    public void setGameRepo(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    @Override
    public List<Game> findAll() {
        return gameRepo.findAll();
    }

    @Override
    public List<Game> search(String keyword) {
        return gameRepo.search(keyword);
    }

    @Override
    public Game save(Game game) {
        return gameRepo.save(game);
    }

    @Override
    public Game findById(Integer gameId) {
        return gameRepo.findById(gameId).get();
    }

    @Override
    public Game updateGame(Game game) {
        Game existingGame = gameRepo.findById(game.getGameId()).orElse(null);
        existingGame.setTitle(game.getTitle());
        existingGame.setDescription(game.getDescription());
        Game updatedGame = gameRepo.save(existingGame);
        return updatedGame;

    }

    @Override
    public void delete(Integer gameId) {
        gameRepo.deleteById(gameId);
    }
}
