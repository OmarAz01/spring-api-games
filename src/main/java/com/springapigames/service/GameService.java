package com.springapigames.service;

import com.springapigames.entity.Game;

import java.util.List;

public interface GameService {
    List<Game> search(String keyword);

    List<Game> findAll();

    Game save(Game game);

    Game findById(Integer gameId);

    Game updateGame(Game game);

    void delete(Integer gameId);

}
