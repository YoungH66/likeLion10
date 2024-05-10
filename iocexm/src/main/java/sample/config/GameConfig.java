package sample.config;

import org.springframework.context.annotation.Bean;
import sample.bean.Dice;
import sample.bean.Game;
import sample.bean.Player;

import java.util.List;

public class GameConfig {
    @Bean
    public Dice dice() {
        return new Dice(6);
    }

    @Bean
    public Player kim(Dice dice){
        Player player = new Player();
        player.setDice(dice);
        player.setPlayerName("Kim");
        return player;
    }

    @Bean
    public Player young(Dice dice){
        Player player = new Player();
        player.setDice(dice);
        player.setPlayerName("Young");
        return player;
    }

    @Bean
    public Player hun(Dice dice){
        Player player = new Player();
        player.setDice(dice);
        player.setPlayerName("Hun");
        return player;
    }

    @Bean
    public Game game(List<Player> players){
        return new Game(players);
    }
}
