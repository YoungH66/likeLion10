package sample.bean;

import java.util.List;

public class Game {
    private List<Player> list;

    public void play(){
        for(Player p : list){
            p.play();
        }
    }
}
