package com.delosreyesjeremiah;

public class StoredPlayer {
    public String key;
    public Player value;

    public StoredPlayer(String userName, Player player) {
        this.key = userName;
        this.value = player;
    }
}
