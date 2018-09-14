package com.groupproject.match;

import com.groupproject.commons.BaseEntity;
import com.groupproject.game.Game;
import com.groupproject.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Match extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private User host;
    @ManyToOne
    private User guest;
    @OneToMany(mappedBy = "match")
    private Set<Game> games = new HashSet<>();

    public Match() {
    }

    public Match(User host, User guest) {
        this.host = host;
        this.guest = guest;
    }

    public Match(Long id, User host, User guest) {
        this.id = id;
        this.host = host;
        this.guest = guest;
    }

    public Long getId() {
        return id;
    }

    public User getHost() {
        return host;
    }

    public User getGuest() {
        return guest;
    }

    public Set<Game> getGames() {
        return games;
    }
}
