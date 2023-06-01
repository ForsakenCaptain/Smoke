package com.example.smoke.services;

import com.example.smoke.models.Game;
import com.example.smoke.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game createGame(Game game){
        return gameRepository.save(game);
    }

    public List<Game> createGames(List<Game> games){return gameRepository.saveAll(games);}

    public Game getGameById(int id){
        Game game = gameRepository.findById(id).orElse(null);
        return game;
    }

    public List<Game> getAllGames(){return gameRepository.findAll();}

    public Game updateGame(Game game){
        Game game2 = null;
        Optional<Game> optionalGame = gameRepository.findById(game.getGameId());
        if ((optionalGame.isPresent())){
            game2 = optionalGame.get();
            game2.setName(game.getName());
            game2.setPrice(game.getPrice());
            gameRepository.save(game2);
        }
        else {
            return new Game();
        }
        return game2;
    }

    public String deleteGame(int id){
        gameRepository.deleteById(id);
        return "Game has been deleted";
    }
}
