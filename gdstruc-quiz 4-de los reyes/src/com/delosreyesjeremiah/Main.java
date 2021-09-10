package com.delosreyesjeremiah;

public class Main {

    public static void main(String[] args) {

        Player saber = new Player(1, "Saber", 72);
        Player archer = new Player(2, "Archer", 98);
        Player berserker = new Player (3, "Berserker", 60);
        Player lancer = new Player(4, "Lancer", 55);
        Player rider = new Player(5, "Rider", 46);
        Player assassin = new Player(6, "Assassin", 77);
        Player caster = new Player(7, "Caster", 51);

        PlayerHashtable playerHashtable = new PlayerHashtable(10);

        playerHashtable.put(saber.getUserName(), saber);
        playerHashtable.put(archer.getUserName(), archer);
        playerHashtable.put(berserker.getUserName(), berserker);
        playerHashtable.put(lancer.getUserName(), lancer);
        playerHashtable.put(rider.getUserName(), rider);
        playerHashtable.put(assassin.getUserName(), assassin);
        playerHashtable.put(caster.getUserName(), caster);

        System.out.println("\nPrinting the Player Hashtable...");
        playerHashtable.printHashtable();

        System.out.println("\nGetting a Player [Username: Lancer] from the Player Hashtable...");
        System.out.println(playerHashtable.get("Lancer"));

        System.out.println("\nRemoving a Player [Username: Archer] from the Player Hashtable...");
        playerHashtable.remove("Archer");

        System.out.println("\nGetting a Player [Username: Archer] from the Player Hashtable...");
        System.out.println(playerHashtable.get("Archer"));

        System.out.println("\nPrinting the Player Hashtable...");
        playerHashtable.printHashtable();
    }
}
