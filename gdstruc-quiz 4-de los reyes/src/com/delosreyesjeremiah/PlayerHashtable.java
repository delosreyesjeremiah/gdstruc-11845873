package com.delosreyesjeremiah;

public class PlayerHashtable {
    private StoredPlayer[] hashtable;

    public PlayerHashtable(int capacity) {
        hashtable = new StoredPlayer[capacity];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        int stoppingIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        }
        else {
            hashedKey++;
        }

        while (hashedKey != stoppingIndex
                && hashtable[hashedKey] != null
                && !hashtable[hashedKey].key.equals(key))
        {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        return -1;
    }

    private boolean isOccupied(int index) {
        return hashtable[index] != null;
    }

    public void put(String userName, Player player) {
        int hashedKey = hashKey(userName);

        if (isOccupied(hashedKey)) {
            int stoppingIndex = hashedKey;
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }

            while (isOccupied(hashedKey) && hashedKey != stoppingIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (isOccupied(hashedKey)) {
            System.out.println("Sorry, there is already an element at position " + hashedKey);
        }
        else {
            hashtable[hashedKey] = new StoredPlayer(userName, player);
        }
    }

    public Player get(String userName) {
        int hashedKey = findKey(userName);
        if (hashedKey == - 1) {
            return null;
        }
        return hashtable[hashedKey].value;
    }

    public void remove(String userName) {
        int hashedKey = findKey(userName);
        if (hashedKey == - 1) {
            return;
        }
        hashtable[hashedKey] = null;
    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] != null) {
                System.out.println("Element " + i + " " + hashtable[i].value);
            }
            else {
                System.out.println("Element " + i + " null");
            }
        }
    }

}
