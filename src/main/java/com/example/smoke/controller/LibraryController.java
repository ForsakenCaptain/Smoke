package com.example.smoke.controller;

import com.example.smoke.models.Game;
import com.example.smoke.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/library")
public class LibraryController {

//    @Autowired
    private GameService gameService;

    @Autowired
    public LibraryController(GameService gameService){
        this.gameService = gameService;
    }

    @PostMapping("/Game")
    public String addGame(@RequestParam String name, @RequestParam int price){
        Game game2 = new Game();
        game2.setName(name);
        game2.setPrice(price);
        gameService.createGame(game2);
        return "Game has been added";
    }

    @PostMapping("/libraryCreateGame")
    public Game createGame(@RequestBody Game game){
        return gameService.createGame(game);
    }



    @PostMapping("/Create")
    public List<Game> createGames(@RequestBody List<Game> game){
        return gameService.createGames(game);
    }


    @GetMapping("/GetGames/{id}")
    public Game getGame(@PathVariable int id){
        Game game = gameService.getGameById(id);
        return game;
    }


    @GetMapping("/GetAllGames")
    public List<Game> getGames(){
        List<Game> games = gameService.getAllGames();
        return games;
    }


    public Game updateGame(@RequestBody Game game){
        return gameService.updateGame(game);
    }


    public String deleteGame(@PathVariable int id){
        return gameService.deleteGame(id);
    }
}
