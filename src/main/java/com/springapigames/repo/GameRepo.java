package com.springapigames.repo;

import com.springapigames.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepo extends JpaRepository<Game, Integer> {

    @Query(value = "SELECT * FROM games WHERE MATCH(title, description) AGAINST(?1 IN BOOLEAN MODE)", nativeQuery = true)
    List<Game> search(String keyword);

}
