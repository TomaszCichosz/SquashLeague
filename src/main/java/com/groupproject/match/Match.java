package com.groupproject.match;

import com.groupproject.commons.BaseEntity;
import com.groupproject.game.Game;
import com.groupproject.player.Player;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "matches")
public class Match extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Player host;
    @ManyToOne
    private Player guest;
    @OneToMany(mappedBy = "match")
    private Set<Game> games = new HashSet<>();

    public Match() {
    }

    public Match(Player host, Player guest) {
        this.host = host;
        this.guest = guest;
    }

    public Match(Long id, Player host, Player guest) {
        this.id = id;
        this.host = host;
        this.guest = guest;
    }

    public Long getId() {
        return id;
    }

    public Player getHost() {
        return host;
    }

    public Player getGuest() {
        return guest;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void addGame(Game game) {
        games.add(game);
    }
}
